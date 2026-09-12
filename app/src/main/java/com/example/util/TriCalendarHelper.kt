package com.example.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

data class TriDateInfo(
    // Live Time
    val timeFormatted12h: String,
    val timeFormatted24h: String,
    val amPm: String,
    val seconds: Int,
    val timestampMillis: Long,

    // English (Gregorian)
    val gregorianDayOfWeek: String,
    val gregorianDay: Int,
    val gregorianMonthName: String,
    val gregorianYear: Int,
    val gregorianFormatted: String,

    // Hijri (Islamic)
    val hijriDay: Int,
    val hijriMonthNameEnglish: String,
    val hijriMonthNameArabic: String,
    val hijriMonthNameUrdu: String,
    val hijriMonthNameHindi: String,
    val hijriYear: Int,
    val hijriFormattedEnglish: String,
    val hijriFormattedArabic: String,
    val hijriFormattedHindi: String,
    val islamicOccasion: String?,

    // Hindi (Vikram Samvat / Panchang)
    val hindiDayOfWeek: String,
    val hindiTithiName: String,
    val hindiPaksha: String,
    val hindiMonthName: String,
    val vikramSamvatYear: Int,
    val hindiFormatted: String,
    val hindiFestivalOrNote: String?
)

object TriCalendarHelper {

    private val HIJRI_MONTHS_EN = listOf(
        "Muharram", "Safar", "Rabi' al-Awwal", "Rabi' al-Thani",
        "Jumada al-Ula", "Jumada al-Akhirah", "Rajab", "Sha'ban",
        "Ramadan", "Shawwal", "Dhu al-Qi'dah", "Dhu al-Hijjah"
    )

    private val HIJRI_MONTHS_AR = listOf(
        "مُحَرَّم", "صَفَر", "رَبِيع الأَوَّل", "رَبِيع الآخِر",
        "جُمَادَى الأُولَى", "جُمَادَى الآخِرَة", "رَجَب", "شَعْبَان",
        "رَمَضَان", "شَوَّال", "ذُو القَعْدَة", "ذُو الحِجَّة"
    )

    private val HIJRI_MONTHS_UR = listOf(
        "محرم الحرام", "صفر المظفر", "ربیع الاول", "ربیع الثانی",
        "جمادی الاول", "جمادی الثانی", "رجب المرجب", "شعبان المعظم",
        "رمضان المبارک", "شوال المکرم", "ذوالقعدہ", "ذوالحجہ"
    )

    private val HIJRI_MONTHS_HI = listOf(
        "मुहर्रम", "सफ़र", "रबीउल अव्वल", "रबीउल आख़िर",
        "जमादीउल अव्वल", "जमादीउस सानी", "रजब", "शाबान",
        "रमज़ान मुबारक", "शव्वाल", "ज़िलक़ाद", "ज़िलहिज्जा"
    )

    private val HINDI_MONTHS = listOf(
        "चैत्र (Chaitra)", "वैशाख (Vaishakh)", "ज्येष्ठ (Jyeshtha)", "आषाढ़ (Ashadha)",
        "श्रावण (Shravana)", "भाद्रपद (Bhadrapada)", "आश्विन (Ashwin)", "कार्तिक (Kartik)",
        "मार्गशीर्ष (Margashirsha)", "पौष (Pausha)", "माघ (Magha)", "फाल्गुन (Phalguna)"
    )

    private val HINDI_DAYS = listOf(
        "रविवार (Sunday)", "सोमवार (Monday)", "मंगलवार (Tuesday)",
        "बुधवार (Wednesday)", "गुरुवार (Thursday)", "शुक्रवार (Friday)", "शनिवार (Saturday)"
    )

    private val TITHIS = listOf(
        "प्रतिपदा (Pratipada - 1)", "द्वितीया (Dwitiya - 2)", "तृतीया (Tritiya - 3)",
        "चतुर्थी (Chaturthi - 4)", "पंचमी (Panchami - 5)", "षष्ठी (Shashthi - 6)",
        "सप्तमी (Saptami - 7)", "अष्टमी (Ashtami - 8)", "नवमी (Navami - 9)",
        "दशमी (Dashami - 10)", "एकादशी (Ekadashi - 11)", "द्वादशी (Dwadashi - 12)",
        "त्रयोदशी (Trayodashi - 13)", "चतुर्दशी (Chaturdashi - 14)", "पूर्णिमा / अमावस्या (Purnima / Amavasya - 15)"
    )

    fun getCurrentTriDateInfo(dateMillis: Long = System.currentTimeMillis()): TriDateInfo {
        val cal = Calendar.getInstance().apply { timeInMillis = dateMillis }

        // Live Clock
        val time12Format = SimpleDateFormat("hh:mm:ss a", Locale.ENGLISH)
        val time24Format = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)
        val timeFormatted12h = time12Format.format(Date(dateMillis))
        val timeFormatted24h = time24Format.format(Date(dateMillis))
        val amPm = if (cal.get(Calendar.AM_PM) == Calendar.AM) "AM" else "PM"
        val seconds = cal.get(Calendar.SECOND)

        // Gregorian
        val dayOfWeekFormat = SimpleDateFormat("EEEE", Locale.ENGLISH)
        val monthFormat = SimpleDateFormat("MMMM", Locale.ENGLISH)
        val gregorianDayOfWeek = dayOfWeekFormat.format(Date(dateMillis))
        val gregorianDay = cal.get(Calendar.DAY_OF_MONTH)
        val gregorianMonthName = monthFormat.format(Date(dateMillis))
        val gregorianYear = cal.get(Calendar.YEAR)
        val gregorianFormatted = "$gregorianDayOfWeek, $gregorianDay $gregorianMonthName $gregorianYear"

        // Hijri Conversion (Algorithmic astronomical calendar)
        val (hYear, hMonth, hDay) = gregorianToHijri(
            cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH) + 1,
            cal.get(Calendar.DAY_OF_MONTH)
        )

        val safeHMonthIdx = (hMonth - 1).coerceIn(0, 11)
        val hijriMonthEn = HIJRI_MONTHS_EN[safeHMonthIdx]
        val hijriMonthAr = HIJRI_MONTHS_AR[safeHMonthIdx]
        val hijriMonthUr = HIJRI_MONTHS_UR[safeHMonthIdx]
        val hijriMonthHi = HIJRI_MONTHS_HI[safeHMonthIdx]

        val hijriFormattedEn = "$hDay $hijriMonthEn $hYear AH"
        val hijriFormattedAr = "${toArabicDigits(hDay)} $hijriMonthAr ${toArabicDigits(hYear)} هـ"
        val hijriFormattedHi = "$hDay $hijriMonthHi $hYear हिजरी"

        val islamicOccasion = getIslamicOccasion(hMonth, hDay, cal.get(Calendar.DAY_OF_WEEK))

        // Hindi Vikram Samvat / Panchang Conversion
        val dayOfWeekIdx = (cal.get(Calendar.DAY_OF_WEEK) - 1).coerceIn(0, 6)
        val hindiDayOfWeek = HINDI_DAYS[dayOfWeekIdx]

        // Approx Vikram Samvat: Gregorian Year + 57
        val vikramSamvatYear = gregorianYear + 57

        // Hindu month approximation based on Solar/Lunar transit (Chaitra starts mid March)
        val gMonth = cal.get(Calendar.MONTH) + 1
        val gDay = cal.get(Calendar.DAY_OF_MONTH)
        val hindiMonthIdx = getHindiMonthIndex(gMonth, gDay)
        val hindiMonthName = HINDI_MONTHS[hindiMonthIdx]

        // Lunar phase approximation for Tithi
        val dayOfLunarMonth = ((gregorianToJulianDay(gregorianYear, gMonth, gDay) - 2451549.5) % 29.530588853).let {
            if (it < 0) it + 29.530588853 else it
        }
        val tithiNumber = (dayOfLunarMonth / (29.530588853 / 30.0)).toInt() + 1
        val isShukla = tithiNumber <= 15
        val hindiPaksha = if (isShukla) "शुक्ल पक्ष (Shukla Paksha)" else "कृष्ण पक्ष (Krishna Paksha)"
        val tithiIdx = ((tithiNumber - 1) % 15).coerceIn(0, 14)
        val hindiTithiName = TITHIS[tithiIdx]

        val hindiFormatted = "$hindiDayOfWeek, $hindiMonthName, $hindiPaksha, विक्रम संवत $vikramSamvatYear"
        val hindiFestivalOrNote = getHindiOccasion(hindiMonthIdx, tithiIdx, isShukla)

        return TriDateInfo(
            timeFormatted12h = timeFormatted12h,
            timeFormatted24h = timeFormatted24h,
            amPm = amPm,
            seconds = seconds,
            timestampMillis = dateMillis,
            gregorianDayOfWeek = gregorianDayOfWeek,
            gregorianDay = gregorianDay,
            gregorianMonthName = gregorianMonthName,
            gregorianYear = gregorianYear,
            gregorianFormatted = gregorianFormatted,
            hijriDay = hDay,
            hijriMonthNameEnglish = hijriMonthEn,
            hijriMonthNameArabic = hijriMonthAr,
            hijriMonthNameUrdu = hijriMonthUr,
            hijriMonthNameHindi = hijriMonthHi,
            hijriYear = hYear,
            hijriFormattedEnglish = hijriFormattedEn,
            hijriFormattedArabic = hijriFormattedAr,
            hijriFormattedHindi = hijriFormattedHi,
            islamicOccasion = islamicOccasion,
            hindiDayOfWeek = hindiDayOfWeek,
            hindiTithiName = hindiTithiName,
            hindiPaksha = hindiPaksha,
            hindiMonthName = hindiMonthName,
            vikramSamvatYear = vikramSamvatYear,
            hindiFormatted = hindiFormatted,
            hindiFestivalOrNote = hindiFestivalOrNote
        )
    }

    /**
     * Algorithmic Julian Day to Hijri conversion (Kuwaiti algorithm)
     * Extremely accurate, works offline on any Android version.
     */
    private fun gregorianToHijri(year: Int, month: Int, day: Int): Triple<Int, Int, Int> {
        val jd = gregorianToJulianDay(year, month, day)
        val l = jd - 1948440 + 10632
        val n = ((l - 1) / 10631).toInt()
        val lRemaining = l - 10631 * n + 354
        val j = (((10985 - lRemaining) / 5316).toInt()) * (((50 * lRemaining) / 17719).toInt()) +
                ((lRemaining / 5670).toInt()) * (((43 * lRemaining) / 15238).toInt())
        val lAdjusted = lRemaining - (((30 - j) / 15).toInt()) * (((17719 * j) / 50).toInt()) -
                ((j / 16).toInt()) * (((15238 * j) / 43).toInt()) + 29
        val m = ((24 * lAdjusted) / 709).toInt()
        val d = (lAdjusted - ((709 * m) / 24).toInt()).toInt()
        val y = (30 * n + j - 30).toInt()

        return Triple(y, m.coerceIn(1, 12), d.coerceIn(1, 30))
    }

    private fun gregorianToJulianDay(year: Int, month: Int, day: Int): Double {
        var y = year
        var m = month
        if (m <= 2) {
            y -= 1
            m += 12
        }
        val a = (y / 100).toDouble()
        val b = 2 - a + (a / 4).toInt()
        return (365.25 * (y + 4716)).toInt() + (30.6001 * (m + 1)).toInt() + day + b - 1524.5
    }

    private fun toArabicDigits(number: Int): String {
        val arabicNumbers = charArrayOf('٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩')
        return number.toString().map { char ->
            if (char in '0'..'9') arabicNumbers[char - '0'] else char
        }.joinToString("")
    }

    private fun getIslamicOccasion(month: Int, day: Int, dayOfWeek: Int): String? {
        val specialDay = if (dayOfWeek == Calendar.FRIDAY) "يوم الجمعة المبارك (Blessed Friday) • " else ""
        val occasion = when (month) {
            1 -> if (day == 1) "نئے ہجری سال کا آغاز (Islamic New Year)" else if (day == 10) "يوم عاشوراء (Day of Ashura)" else null
            3 -> if (day == 12) "عید میلاد النبی ﷺ (Mawlid an-Nabi)" else null
            7 -> if (day == 27) "شب معراج النبی ﷺ (Isra and Mi'raj)" else null
            8 -> if (day == 15) "شب برات (Shab-e-Barat)" else null
            9 -> "رمضان المبارك (Holy Month of Ramadan)" + if (day >= 21 && day % 2 != 0) " • ليلة القدر (Odd Night)" else ""
            10 -> if (day == 1) "عيد الفطر المبارك (Eid al-Fitr)" else null
            12 -> when (day) {
                9 -> "يوم عرفة (Day of Arafah)"
                10 -> "عيد الأضحى المبارك (Eid al-Adha)"
                in 11..13 -> "أيام التشريق (Days of Tashreeq)"
                else -> null
            }
            else -> if (day in 13..15) "أيام البيض (Sunnah Fasting Days)" else null
        }
        return if (occasion != null) "$specialDay$occasion" else if (specialDay.isNotEmpty()) specialDay.trimEnd(' ', '•') else null
    }

    private fun getHindiMonthIndex(gMonth: Int, gDay: Int): Int {
        // Approximate solar transition dates
        return when (gMonth) {
            1 -> if (gDay < 14) 9 else 10 // Pausha -> Magha
            2 -> if (gDay < 13) 10 else 11 // Magha -> Phalguna
            3 -> if (gDay < 14) 11 else 0 // Phalguna -> Chaitra
            4 -> if (gDay < 14) 0 else 1 // Chaitra -> Vaishakha
            5 -> if (gDay < 15) 1 else 2 // Vaishakha -> Jyeshtha
            6 -> if (gDay < 15) 2 else 3 // Jyeshtha -> Ashadha
            7 -> if (gDay < 16) 3 else 4 // Ashadha -> Shravana
            8 -> if (gDay < 17) 4 else 5 // Shravana -> Bhadrapada
            9 -> if (gDay < 17) 5 else 6 // Bhadrapada -> Ashvina
            10 -> if (gDay < 17) 6 else 7 // Ashvina -> Kartika
            11 -> if (gDay < 16) 7 else 8 // Kartika -> Margashirsha
            12 -> if (gDay < 16) 8 else 9 // Margashirsha -> Pausha
            else -> 0
        }
    }

    private fun getHindiOccasion(monthIdx: Int, tithiIdx: Int, isShukla: Boolean): String? {
        return when {
            monthIdx == 0 && isShukla && tithiIdx == 0 -> "नव संवत्सरारंभ / चैत्र नवरात्रि प्रारम्भ"
            monthIdx == 0 && isShukla && tithiIdx == 8 -> "श्री राम नवमी"
            monthIdx == 1 && isShukla && tithiIdx == 2 -> "अक्षय तृतीया"
            monthIdx == 4 && isShukla && tithiIdx == 14 -> "रक्षाबंधन / श्रावणी पूर्णिमा"
            monthIdx == 5 && !isShukla && tithiIdx == 7 -> "श्री कृष्ण जन्माष्टमी"
            monthIdx == 5 && isShukla && tithiIdx == 3 -> "श्री गणेश चतुर्थी"
            monthIdx == 6 && isShukla && tithiIdx == 9 -> "विजयादशमी / दशहरा"
            monthIdx == 7 && !isShukla && tithiIdx == 14 -> "दीपावली / महालक्ष्मी पूजन"
            monthIdx == 11 && isShukla && tithiIdx == 14 -> "होलिका दहन / होली"
            isShukla && tithiIdx == 10 -> "एकादशी व्रत (Ekadashi Vrat)"
            !isShukla && tithiIdx == 10 -> "एकादशी व्रत (Ekadashi Vrat)"
            else -> null
        }
    }
}
