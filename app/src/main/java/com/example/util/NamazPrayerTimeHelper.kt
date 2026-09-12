package com.example.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import kotlin.math.*

data class NamazTimeEntry(
    val id: String,
    val nameUrdu: String,
    val nameHindi: String,
    val nameRoman: String,
    val nameArabic: String,
    val timeFormatted: String,
    val timeMillis: Long,
    val isNext: Boolean = false,
    val isCurrent: Boolean = false,
    val rakats: String,
    val description: String
)

data class NamazSchedule(
    val fajr: NamazTimeEntry,
    val sunrise: NamazTimeEntry,
    val dhuhr: NamazTimeEntry,
    val asr: NamazTimeEntry,
    val maghrib: NamazTimeEntry,
    val isha: NamazTimeEntry,
    val currentPrayer: NamazTimeEntry?,
    val nextPrayer: NamazTimeEntry?,
    val remainingTimeString: String
)

object NamazPrayerTimeHelper {

    /**
     * Calculates prayer times for a given date in milliseconds.
     * Uses standard solar calculation for subcontinent/standard latitude (e.g. 28.6° N, 77.2° E or user zone).
     */
    fun calculatePrayerTimes(
        dateTimeMillis: Long,
        customTimesMap: Map<String, Pair<Int, Int>>? = null
    ): NamazSchedule {
        val cal = Calendar.getInstance().apply {
            timeInMillis = dateTimeMillis
        }

        val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)
        val year = cal.get(Calendar.YEAR)

        // Solar declination approximation
        val b = 2.0 * PI * (dayOfYear - 81) / 365.0
        val eot = 9.87 * sin(2 * b) - 7.53 * cos(b) - 1.5 * sin(b) // Equation of time in minutes
        val declination = 23.45 * sin(2.0 * PI * (284 + dayOfYear) / 365.0) * (PI / 180.0)

        // Assume standard median coordinates (Lat 25.0° N, Long 60.0° E)
        val latRad = 25.0 * (PI / 180.0)

        // Solar noon approx 12:15 PM adjusted for EoT
        val solarNoonMinutes = 12 * 60 + 15 - eot.toInt()

        // Hour angle for sunset / sunrise (zenith = 90.833 deg)
        val cosH0 = (sin(-0.833 * PI / 180.0) - sin(latRad) * sin(declination)) / (cos(latRad) * cos(declination))
        val h0Rad = acos(cosH0.coerceIn(-1.0, 1.0))
        val halfDayMinutes = (h0Rad * (180.0 / PI) * 4).toInt()

        val sunriseMin = solarNoonMinutes - halfDayMinutes
        val sunsetMin = solarNoonMinutes + halfDayMinutes

        // Fajr (18 degrees twilight before sunrise)
        val cosFajr = (sin(-18.0 * PI / 180.0) - sin(latRad) * sin(declination)) / (cos(latRad) * cos(declination))
        val fajrHalfDayMin = (acos(cosFajr.coerceIn(-1.0, 1.0)) * (180.0 / PI) * 4).toInt()
        val fajrMin = solarNoonMinutes - fajrHalfDayMin

        // Asr (Shafi'i/Standard shadow = shadow + object height, approx solarNoon + ~230 mins)
        val asrMin = solarNoonMinutes + (halfDayMinutes * 0.58).toInt()

        // Maghrib (sunset + 2 mins)
        val maghribMin = sunsetMin + 2

        // Isha (18 degrees dusk after sunset)
        val cosIsha = (sin(-18.0 * PI / 180.0) - sin(latRad) * sin(declination)) / (cos(latRad) * cos(declination))
        val ishaHalfDayMin = (acos(cosIsha.coerceIn(-1.0, 1.0)) * (180.0 / PI) * 4).toInt()
        val ishaMin = solarNoonMinutes + ishaHalfDayMin

        fun toMillis(minutesFromMidnight: Int): Long {
            val c = Calendar.getInstance().apply {
                timeInMillis = dateTimeMillis
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
                add(Calendar.MINUTE, minutesFromMidnight)
            }
            return c.timeInMillis
        }

        fun formatTime(timeMillis: Long): String {
            val sdf = SimpleDateFormat("hh:mm a", Locale.ENGLISH)
            return sdf.format(Date(timeMillis))
        }

        val fajrMillis = customTimesMap?.get("fajr")?.let { toMillis(it.first * 60 + it.second) } ?: toMillis(fajrMin)
        val sunriseMillis = customTimesMap?.get("sunrise")?.let { toMillis(it.first * 60 + it.second) } ?: toMillis(sunriseMin)
        val dhuhrMillis = customTimesMap?.get("dhuhr")?.let { toMillis(it.first * 60 + it.second) } ?: toMillis(solarNoonMinutes + 4)
        val asrMillis = customTimesMap?.get("asr")?.let { toMillis(it.first * 60 + it.second) } ?: toMillis(asrMin)
        val maghribMillis = customTimesMap?.get("maghrib")?.let { toMillis(it.first * 60 + it.second) } ?: toMillis(maghribMin)
        val ishaMillis = customTimesMap?.get("isha")?.let { toMillis(it.first * 60 + it.second) } ?: toMillis(ishaMin)

        val currentMinutesOfDay = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE)

        val fajrEntry = NamazTimeEntry(
            id = "fajr",
            nameUrdu = "فجر",
            nameHindi = "फ़ज्र",
            nameRoman = "Fajr",
            nameArabic = "الفَجْر",
            timeFormatted = formatTime(fajrMillis),
            timeMillis = fajrMillis,
            rakats = "2 Sunnat + 2 Farz",
            description = "Subah Sadiq se Tulu-e-Aftab tak ka waqt"
        )

        val sunriseEntry = NamazTimeEntry(
            id = "sunrise",
            nameUrdu = "طلوعِ آفتاب",
            nameHindi = "तुलू-ए-आफ़ताब (सूर्योदय)",
            nameRoman = "Tulu-e-Aftab (Sunrise)",
            nameArabic = "شُرُوقُ الشَّمْس",
            timeFormatted = formatTime(sunriseMillis),
            timeMillis = sunriseMillis,
            rakats = "Awqat-e-Makrooh",
            description = "Suraj nikalne ka waqt (Is dauran Namaz makrooh hai)"
        )

        val dhuhrEntry = NamazTimeEntry(
            id = "dhuhr",
            nameUrdu = "ظہر",
            nameHindi = "ज़ुहर",
            nameRoman = "Dhuhr",
            nameArabic = "الظُّهْر",
            timeFormatted = formatTime(dhuhrMillis),
            timeMillis = dhuhrMillis,
            rakats = "4 Sunnat + 4 Farz + 2 Sunnat + 2 Nafl",
            description = "Zawaal-e-Aftab ke baad se Asr tak"
        )

        val asrEntry = NamazTimeEntry(
            id = "asr",
            nameUrdu = "عصر",
            nameHindi = "अस्र",
            nameRoman = "Asr",
            nameArabic = "العَصْر",
            timeFormatted = formatTime(asrMillis),
            timeMillis = asrMillis,
            rakats = "4 Sunnat (Ghair-Muakkadah) + 4 Farz",
            description = "Dopehar ke baad se Ghurub-e-Aftab se pehle tak"
        )

        val maghribEntry = NamazTimeEntry(
            id = "maghrib",
            nameUrdu = "مغرب",
            nameHindi = "मग़रिब",
            nameRoman = "Maghrib",
            nameArabic = "المَغْرِب",
            timeFormatted = formatTime(maghribMillis),
            timeMillis = maghribMillis,
            rakats = "3 Farz + 2 Sunnat + 2 Nafl",
            description = "Suraj doobne ke foran baad ka waqt"
        )

        val ishaEntry = NamazTimeEntry(
            id = "isha",
            nameUrdu = "عشاء",
            nameHindi = "इशा",
            nameRoman = "Isha",
            nameArabic = "العِشَاء",
            timeFormatted = formatTime(ishaMillis),
            timeMillis = ishaMillis,
            rakats = "4 Farz + 2 Sunnat + 3 Witr Wajib + 2 Nafl",
            description = "Shafaq khatam hone ke baad se Nisf-Shab tak"
        )

        val allList = listOf(fajrEntry, sunriseEntry, dhuhrEntry, asrEntry, maghribEntry, ishaEntry)

        var current: NamazTimeEntry? = null
        var next: NamazTimeEntry? = null

        when {
            currentMinutesOfDay < fajrMin -> {
                next = fajrEntry
                current = ishaEntry
            }
            currentMinutesOfDay < sunriseMin -> {
                current = fajrEntry
                next = dhuhrEntry
            }
            currentMinutesOfDay < (solarNoonMinutes + 4) -> {
                current = sunriseEntry
                next = dhuhrEntry
            }
            currentMinutesOfDay < asrMin -> {
                current = dhuhrEntry
                next = asrEntry
            }
            currentMinutesOfDay < maghribMin -> {
                current = asrEntry
                next = maghribEntry
            }
            currentMinutesOfDay < ishaMin -> {
                current = maghribEntry
                next = ishaEntry
            }
            else -> {
                current = ishaEntry
                next = fajrEntry
            }
        }

        val targetMillis = next.timeMillis.let {
            if (it < dateTimeMillis) it + 86400000L else it
        }
        val diffMs = (targetMillis - dateTimeMillis).coerceAtLeast(0)
        val hours = diffMs / (1000 * 60 * 60)
        val mins = (diffMs % (1000 * 60 * 60)) / (1000 * 60)
        val remainingString = "${hours}h ${mins}m baaqi"

        return NamazSchedule(
            fajr = fajrEntry.copy(isCurrent = current == fajrEntry, isNext = next == fajrEntry),
            sunrise = sunriseEntry.copy(isCurrent = current == sunriseEntry, isNext = next == sunriseEntry),
            dhuhr = dhuhrEntry.copy(isCurrent = current == dhuhrEntry, isNext = next == dhuhrEntry),
            asr = asrEntry.copy(isCurrent = current == asrEntry, isNext = next == asrEntry),
            maghrib = maghribEntry.copy(isCurrent = current == maghribEntry, isNext = next == maghribEntry),
            isha = ishaEntry.copy(isCurrent = current == ishaEntry, isNext = next == ishaEntry),
            currentPrayer = current,
            nextPrayer = next,
            remainingTimeString = remainingString
        )
    }
}
