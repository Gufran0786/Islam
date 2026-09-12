package com.example.util

import com.example.data.AppLanguage
import com.example.data.ProphetEntity
import com.example.data.ProphetEventEntity

object AppLocaleManager {

    fun getUiString(key: String, language: AppLanguage): String {
        return when (language) {
            AppLanguage.HINDI -> getHindiString(key)
            AppLanguage.URDU -> getUrduString(key)
            AppLanguage.ARABIC -> getArabicString(key)
            AppLanguage.BENGALI -> getBengaliString(key)
            AppLanguage.TURKISH -> getTurkishString(key)
            AppLanguage.INDONESIAN -> getIndonesianString(key)
            AppLanguage.MALAY -> getMalayString(key)
            AppLanguage.PERSIAN -> getPersianString(key)
            AppLanguage.FRENCH -> getFrenchString(key)
            AppLanguage.SPANISH -> getSpanishString(key)
            AppLanguage.GERMAN -> getGermanString(key)
            AppLanguage.RUSSIAN -> getRussianString(key)
            AppLanguage.GUJARATI -> getGujaratiString(key)
            AppLanguage.TAMIL -> getTamilString(key)
            AppLanguage.TELUGU -> getTeluguString(key)
            AppLanguage.PUNJABI -> getPunjabiString(key)
            AppLanguage.SWAHILI -> getSwahiliString(key)
            AppLanguage.ENGLISH -> getEnglishString(key)
        }
    }

    private fun getEnglishString(key: String): String = when (key) {
        "tab_home" -> "Home"
        "tab_anbiya" -> "Prophets"
        "tab_family_tree" -> "Family Tree"
        "tab_quran" -> "Quran"
        "tab_angels" -> "Angels"
        "tab_time" -> "Time & Azan"
        "tab_diary" -> "Diary"
        "tab_settings" -> "Settings"
        "nav_prophets" -> "Prophets"
        "nav_quran" -> "Quran"
        "nav_diary" -> "Diary"
        "nav_settings" -> "Settings"
        "app_title" -> "Stories of the Prophets"
        "app_subtitle" -> "Biographies, Sacred Chronicles & Spiritual Diary"
        "search_prophet_hint" -> "Search prophet, parents, siblings or events..."
        "bookmarks_only" -> "Saved Only"
        "add_prophet" -> "Add Prophet"
        "edit" -> "Edit"
        "delete" -> "Delete"
        "save" -> "Save"
        "cancel" -> "Cancel"
        "age" -> "Age / Lifespan"
        "father" -> "Father"
        "mother" -> "Mother"
        "siblings" -> "Brothers & Sisters"
        "children" -> "Children"
        "wives" -> "Wife / Wives"
        "era_location" -> "Era & Location"
        "highlights" -> "Highlights"
        "events" -> "Key Life Events"
        "moral_lesson" -> "Moral Lesson"
        "quranic_ref" -> "Quranic Reference"
        "read_narrative" -> "Read Narrative"
        "settings_language" -> "App Language"
        "settings_language_desc" -> "Change language across the entire application"
        "settings_paper" -> "Paper Style"
        "settings_font" -> "Book Font"
        "settings_font_size" -> "Font Size"
        "settings_dark_mode" -> "Dark Reading Mode"
        "calendar_title" -> "Tri-Calendar & Real-Time Clock"
        "hijri_date" -> "Hijri Islamic Date"
        "hindi_date" -> "Hindi Vikram Samvat"
        "english_date" -> "Gregorian Date"
        "live_clock" -> "Live Clock"
        "reset_factory" -> "Reset to Original Data"
        "voice_note" -> "Voice Note"
        "daily_reflection" -> "Daily Reflection"
        else -> key
    }

    private fun getHindiString(key: String): String = when (key) {
        "tab_home" -> "होम"
        "tab_anbiya" -> "अंबिया"
        "tab_family_tree" -> "फैमिली ट्री"
        "tab_quran" -> "क़ुरआन"
        "tab_angels" -> "फ़रिश्ते"
        "tab_time" -> "नमाज़ व वक़्त"
        "tab_diary" -> "डायरी"
        "tab_settings" -> "सेटिंग्स"
        "nav_prophets" -> "नबी / पैग़म्बर"
        "nav_quran" -> "क़ुरआन"
        "nav_diary" -> "डायरी"
        "nav_settings" -> "सेटिंग्स"
        "app_title" -> "क़िससुल अंबिया"
        "app_subtitle" -> "पैग़म्बरों का जीवन, घटनाएं और आत्म-चिंतन"
        "search_prophet_hint" -> "नबी, माता-पिता, भाई-बहन या घटना खोजें..."
        "bookmarks_only" -> "केवल सुरक्षित"
        "add_prophet" -> "नबी जोड़ें"
        "edit" -> "संपादित करें"
        "delete" -> "हटाएं"
        "save" -> "सहेजें"
        "cancel" -> "रद्द करें"
        "age" -> "उम्र / जीवनकाल"
        "father" -> "पिता"
        "mother" -> "माता"
        "siblings" -> "भाई और बहनें"
        "children" -> "संतान"
        "wives" -> "पत्नियां (बीवियां)"
        "era_location" -> "काल और स्थान"
        "highlights" -> "मुख्य सारांश"
        "events" -> "जीवन की मुख्य घटनाएं"
        "moral_lesson" -> "नैतिक सीख व नसीहत"
        "quranic_ref" -> "क़ुरआनी संदर्भ"
        "read_narrative" -> "विस्तृत वृत्तांत पढ़ें"
        "settings_language" -> "ऐप की भाषा (Language)"
        "settings_language_desc" -> "संपूर्ण ऐप की भाषा विश्व स्तर पर बदलें"
        "settings_paper" -> "कागज़ की शैली"
        "settings_font" -> "किताब का फ़ॉन्ट"
        "settings_font_size" -> "फ़ॉन्ट का आकार"
        "settings_dark_mode" -> "डार्क मोड"
        "calendar_title" -> "त्रि-पंचांग व सजीव घड़ी"
        "hijri_date" -> "हिजरी इस्लामी तिथि"
        "hindi_date" -> "हिन्दी विक्रम संवत"
        "english_date" -> "ग्रेगोरियन अंग्रेजी तिथि"
        "live_clock" -> "सजीव वास्तविक समय"
        "reset_factory" -> "मूल डेटा पुनः स्थापित करें"
        "voice_note" -> "वॉइस नोट"
        "daily_reflection" -> "दैनिक आत्म-चिंतन"
        else -> getEnglishString(key)
    }

    private fun getUrduString(key: String): String = when (key) {
        "tab_home" -> "ہوم"
        "tab_anbiya" -> "انبیاء"
        "tab_family_tree" -> "شجرۂ نسب"
        "tab_quran" -> "قرآن"
        "tab_angels" -> "فرشتے"
        "tab_time" -> "اوقات و اذان"
        "tab_diary" -> "ڈائری"
        "tab_settings" -> "سیٹنگز"
        "nav_prophets" -> "قصص الانبیاء"
        "nav_quran" -> "القرآن"
        "nav_diary" -> "ڈائری"
        "nav_settings" -> "ترتیبات"
        "app_title" -> "قصص الانبیاء علیہم السلام"
        "app_subtitle" -> "انبیاء کرام کی سوانح، حیات کے واقعات اور افکار"
        "search_prophet_hint" -> "نبی، والدین، بہن بھائی یا واقعہ تلاش کریں..."
        "bookmarks_only" -> "صرف محفوظ کردہ"
        "add_prophet" -> "نبی شامل کریں"
        "edit" -> "تبدیل کریں"
        "delete" -> "حذف کریں"
        "save" -> "محفوظ کریں"
        "cancel" -> "منسوخ"
        "age" -> "عمر / حیات"
        "father" -> "والد محترم"
        "mother" -> "والدہ محترمہ"
        "siblings" -> "بھائی اور بہنیں"
        "children" -> "اولاد"
        "wives" -> "ازواجِ مطہرات / بیویاں"
        "era_location" -> "زمانہ و مقام"
        "highlights" -> "نمایاں جھلکیاں"
        "events" -> "حیات کے اہم واقعات"
        "moral_lesson" -> "درس و نصیحت"
        "quranic_ref" -> "قرآنی حوالہ"
        "read_narrative" -> "مکمل واقعہ پڑھیں"
        "settings_language" -> "ایپ کی زبان (Language)"
        "settings_language_desc" -> "پوری ایپ کی زبان تبدیل کریں"
        "settings_paper" -> "کاغذ کا انداز"
        "settings_font" -> "کتاب کا رسم الخط"
        "settings_font_size" -> "حروف کا سائز"
        "settings_dark_mode" -> "نائٹ موڈ"
        "calendar_title" -> "سہ رخی کیلنڈر اور لائیو گھڑی"
        "hijri_date" -> "ہجری اسلامی تاریخ"
        "hindi_date" -> "ہندی وکرم سموت"
        "english_date" -> "عیسوی انگریزی تاریخ"
        "live_clock" -> "حقیقی وقت"
        "reset_factory" -> "اصل ڈیٹا بحال کریں"
        "voice_note" -> "صوتی نوٹ"
        "daily_reflection" -> "روزانہ کے تاثرات"
        else -> getEnglishString(key)
    }

    private fun getArabicString(key: String): String = when (key) {
        "nav_prophets" -> "الأنبياء"
        "nav_quran" -> "القرآن"
        "nav_diary" -> "اليوميات"
        "nav_settings" -> "الإعدادات"
        "app_title" -> "قصص الأنبياء"
        "app_subtitle" -> "سير الأنبياء العطرة والأحداث التاريخية"
        "search_prophet_hint" -> "ابحث عن نبي، الوالدين، أو الأحداث..."
        "bookmarks_only" -> "المحفوظة فقط"
        "add_prophet" -> "إضافة نبي"
        "edit" -> "تعديل"
        "delete" -> "حذف"
        "save" -> "حفظ"
        "cancel" -> "إلغاء"
        "age" -> "العمر / مدة الحياة"
        "father" -> "الأب"
        "mother" -> "الأم"
        "siblings" -> "الإخوة والأخوات"
        "children" -> "الأبناء"
        "era_location" -> "العصر والمكان"
        "highlights" -> "أبرز المحطات"
        "events" -> "الأحداث والوقائع"
        "moral_lesson" -> "العبرة والموعظة"
        "quranic_ref" -> "الشاهد القرآني"
        "read_narrative" -> "قراءة القصة كاملة"
        "settings_language" -> "لغة التطبيق"
        "settings_language_desc" -> "تغيير لغة التطبيق لجميع الشاشات"
        "settings_paper" -> "نمط الورق"
        "settings_font" -> "نوع الخط"
        "settings_font_size" -> "حجم الخط"
        "settings_dark_mode" -> "الوضع الليلي"
        "calendar_title" -> "التقويم الثلاثي والساعة الحية"
        "hijri_date" -> "التاريخ الهجري"
        "hindi_date" -> "التاريخ الهندي (سامفات)"
        "english_date" -> "التاريخ الميلادي"
        "live_clock" -> "الوقت الفعلي"
        "reset_factory" -> "استعادة البيانات الأصلية"
        "voice_note" -> "تسجيل صوتي"
        "daily_reflection" -> "تأملات يومية"
        else -> getEnglishString(key)
    }

    private fun getBengaliString(key: String): String = when (key) {
        "nav_prophets" -> "নবীগণ"
        "nav_quran" -> "কুরআন"
        "nav_diary" -> "ডায়েরি"
        "nav_settings" -> "সেটিংস"
        "app_title" -> "কাসাসুল আম্বিয়া"
        "app_subtitle" -> "নবীগণের জীবনী ও আধ্যাত্মিক ডায়েরি"
        "search_prophet_hint" -> "নবী, পিতামাতা বা ঘটনা খুঁজুন..."
        "bookmarks_only" -> "শুধুমাত্র সংরক্ষিত"
        "add_prophet" -> "নবী যোগ করুন"
        "edit" -> "সম্পাদনা"
        "delete" -> "মুছুন"
        "save" -> "সংরক্ষণ"
        "cancel" -> "বাতিল"
        "age" -> "বয়স / আয়ু"
        "father" -> "পিতা"
        "mother" -> "মাতা"
        "siblings" -> "ভাই ও বোন"
        "children" -> "সন্তানাদি"
        "era_location" -> "যুগ ও স্থান"
        "highlights" -> "সারসংক্ষেপ"
        "events" -> "জীবনের প্রধান ঘটনাবলী"
        "moral_lesson" -> "শিক্ষা ও উপদেশ"
        "quranic_ref" -> "কুরআনিক রেফারেন্স"
        "read_narrative" -> "বিস্তারিত ঘটনা পড়ুন"
        "settings_language" -> "অ্যাপের ভাষা"
        "settings_language_desc" -> "সম্পূর্ণ অ্যাপের ভাষা পরিবর্তন করুন"
        "calendar_title" -> "ত্রয়ী ক্যালেন্ডার ও লাইভ ঘড়ি"
        "hijri_date" -> "হিজরি ইসলামিক তারিখ"
        "hindi_date" -> "বিক্রম সংবত তারিখ"
        "english_date" -> "ইংরেজি গ্রেগরিয়ান তারিখ"
        "live_clock" -> "লাইভ সময়"
        else -> getEnglishString(key)
    }

    private fun getTurkishString(key: String): String = when (key) {
        "nav_prophets" -> "Peygamberler"
        "nav_quran" -> "Kuran"
        "nav_diary" -> "Günlük"
        "nav_settings" -> "Ayarlar"
        "app_title" -> "Peygamberler Tarihi"
        "app_subtitle" -> "Peygamberlerin Hayatı ve Manevi Günlük"
        "search_prophet_hint" -> "Peygamber, ebeveyn veya olay ara..."
        "bookmarks_only" -> "Kayıtlılar"
        "add_prophet" -> "Peygamber Ekle"
        "edit" -> "Düzenle"
        "delete" -> "Sil"
        "save" -> "Kaydet"
        "cancel" -> "İptal"
        "age" -> "Yaş / Ömür"
        "father" -> "Baba"
        "mother" -> "Anne"
        "siblings" -> "Kardeşler"
        "children" -> "Çocuklar"
        "era_location" -> "Dönem ve Bölge"
        "highlights" -> "Önemli Noktalar"
        "events" -> "Önemli Olaylar"
        "moral_lesson" -> "İbret ve Ders"
        "quranic_ref" -> "Kur'an Referansı"
        "read_narrative" -> "Tüm Hikayeyi Oku"
        "settings_language" -> "Uygulama Dili"
        "settings_language_desc" -> "Uygulama genelinde dili değiştirin"
        "calendar_title" -> "Üçlü Takvim ve Canlı Saat"
        "hijri_date" -> "Hicri İslami Tarih"
        "hindi_date" -> "Hint Samvat Tarihi"
        "english_date" -> "Miladi Tarih"
        "live_clock" -> "Canlı Saat"
        else -> getEnglishString(key)
    }

    private fun getIndonesianString(key: String): String = when (key) {
        "nav_prophets" -> "Kisah Nabi"
        "nav_quran" -> "Al-Qur'an"
        "nav_diary" -> "Buku Harian"
        "nav_settings" -> "Pengaturan"
        "app_title" -> "Kisah 25 Nabi & Rasul"
        "app_subtitle" -> "Biografi, Mukjizat dan Refleksi Harian"
        "search_prophet_hint" -> "Cari nabi, orang tua, atau peristiwa..."
        "bookmarks_only" -> "Tersimpan"
        "add_prophet" -> "Tambah Nabi"
        "edit" -> "Ubah"
        "delete" -> "Hapus"
        "save" -> "Simpan"
        "cancel" -> "Batal"
        "age" -> "Usia / Masa Hidup"
        "father" -> "Ayah"
        "mother" -> "Ibu"
        "siblings" -> "Saudara Kandung"
        "children" -> "Anak-anak"
        "era_location" -> "Zaman & Lokasi"
        "highlights" -> "Ringkasan Utama"
        "events" -> "Peristiwa Kehidupan"
        "moral_lesson" -> "Pelajaran & Hikmah"
        "quranic_ref" -> "Rujukan Al-Qur'an"
        "read_narrative" -> "Baca Kisah Lengkap"
        "settings_language" -> "Bahasa Aplikasi"
        "settings_language_desc" -> "Ubah bahasa di seluruh aplikasi"
        "calendar_title" -> "Kalender Tiga Serangkai & Jam Waktu Nyata"
        "hijri_date" -> "Tanggal Hijriah"
        "hindi_date" -> "Tanggal Vikram Samvat"
        "english_date" -> "Tanggal Masehi"
        "live_clock" -> "Waktu Nyata"
        else -> getEnglishString(key)
    }

    private fun getMalayString(key: String): String = getIndonesianString(key)

    private fun getPersianString(key: String): String = when (key) {
        "nav_prophets" -> "پیامبران"
        "nav_quran" -> "قرآن"
        "nav_diary" -> "دفترچه"
        "nav_settings" -> "تنظیمات"
        "app_title" -> "قصص الانبیاء"
        "app_subtitle" -> "زندگانی پیامبران و وقایع تاریخ اسلام"
        "search_prophet_hint" -> "جستجوی پیامبر، والدین، رویدادها..."
        "bookmarks_only" -> "نشان شده‌ها"
        "add_prophet" -> "افزودن پیامبر"
        "edit" -> "ویرایش"
        "delete" -> "حذف"
        "save" -> "ذخیره"
        "cancel" -> "انصراف"
        "age" -> "سن و طول عمر"
        "father" -> "پدر"
        "mother" -> "مادر"
        "siblings" -> "برادران و خواهران"
        "children" -> "فرزندان"
        "era_location" -> "دوران و مکان"
        "highlights" -> "نکات برجسته"
        "events" -> "رویدادهای مهم زندگی"
        "moral_lesson" -> "درس اخلاقی و پند"
        "quranic_ref" -> "مرجع قرآنی"
        "read_narrative" -> "خواندن متن کامل"
        "settings_language" -> "زبان برنامه"
        "settings_language_desc" -> "تغییر زبان سراسری برنامه"
        "calendar_title" -> "تقویم سه‌گانه و ساعت زنده"
        "hijri_date" -> "تاریخ هجری قمری"
        "hindi_date" -> "تاریخ هندی ساموات"
        "english_date" -> "تاریخ میلادی"
        "live_clock" -> "ساعت زنده"
        else -> getEnglishString(key)
    }

    private fun getFrenchString(key: String): String = when (key) {
        "nav_prophets" -> "Prophètes"
        "nav_quran" -> "Coran"
        "nav_diary" -> "Journal"
        "nav_settings" -> "Paramètres"
        "app_title" -> "Histoires des Prophètes"
        "app_subtitle" -> "Biographies, Chroniques Sacrées & Journal"
        "search_prophet_hint" -> "Rechercher un prophète, parents, événements..."
        "bookmarks_only" -> "Favoris"
        "add_prophet" -> "Ajouter un prophète"
        "edit" -> "Modifier"
        "delete" -> "Supprimer"
        "save" -> "Enregistrer"
        "cancel" -> "Annuler"
        "age" -> "Âge / Longévité"
        "father" -> "Père"
        "mother" -> "Mère"
        "siblings" -> "Frères et Sœurs"
        "children" -> "Enfants"
        "era_location" -> "Époque et Lieu"
        "highlights" -> "Points Clés"
        "events" -> "Événements Majeurs"
        "moral_lesson" -> "Leçon Morale"
        "quranic_ref" -> "Référence Coranique"
        "read_narrative" -> "Lire le Récit"
        "settings_language" -> "Langue de l'application"
        "settings_language_desc" -> "Changer la langue globale de l'application"
        "calendar_title" -> "Calendrier Triple & Horloge en Direct"
        "hijri_date" -> "Date Hégirienne"
        "hindi_date" -> "Date Vikram Samvat"
        "english_date" -> "Date Grégorienne"
        "live_clock" -> "Horloge en Direct"
        else -> getEnglishString(key)
    }

    private fun getSpanishString(key: String): String = when (key) {
        "nav_prophets" -> "Profetas"
        "nav_quran" -> "Corán"
        "nav_diary" -> "Diario"
        "nav_settings" -> "Ajustes"
        "app_title" -> "Historias de los Profetas"
        "app_subtitle" -> "Biografías, Crónicas Sagradas y Diario Espiritual"
        "search_prophet_hint" -> "Buscar profeta, padres o sucesos..."
        "bookmarks_only" -> "Guardados"
        "add_prophet" -> "Añadir Profeta"
        "edit" -> "Editar"
        "delete" -> "Eliminar"
        "save" -> "Guardar"
        "cancel" -> "Cancelar"
        "age" -> "Edad / Longevidad"
        "father" -> "Padre"
        "mother" -> "Madre"
        "siblings" -> "Hermanos y Hermanas"
        "children" -> "Hijos"
        "era_location" -> "Época y Lugar"
        "highlights" -> "Puntos Clave"
        "events" -> "Acontecimientos Vitales"
        "moral_lesson" -> "Lección Moral"
        "quranic_ref" -> "Referencia Coránica"
        "read_narrative" -> "Leer Relato Completo"
        "settings_language" -> "Idioma de la Aplicación"
        "settings_language_desc" -> "Cambiar el idioma en toda la aplicación"
        "calendar_title" -> "Triple Calendario y Reloj en Tiempo Real"
        "hijri_date" -> "Fecha Hijri Islámica"
        "hindi_date" -> "Fecha Vikram Samvat"
        "english_date" -> "Fecha Gregoriana"
        "live_clock" -> "Reloj en Vivo"
        else -> getEnglishString(key)
    }

    private fun getGermanString(key: String): String = when (key) {
        "nav_prophets" -> "Propheten"
        "nav_quran" -> "Koran"
        "nav_diary" -> "Tagebuch"
        "nav_settings" -> "Einstellungen"
        "app_title" -> "Geschichten der Propheten"
        "app_subtitle" -> "Biografien, heilige Chroniken & Tagebuch"
        "search_prophet_hint" -> "Prophet, Eltern oder Ereignisse suchen..."
        "bookmarks_only" -> "Lesezeichen"
        "add_prophet" -> "Prophet hinzufügen"
        "edit" -> "Bearbeiten"
        "delete" -> "Löschen"
        "save" -> "Speichern"
        "cancel" -> "Abbrechen"
        "age" -> "Alter / Lebensdauer"
        "father" -> "Vater"
        "mother" -> "Mutter"
        "siblings" -> "Geschwister"
        "children" -> "Kinder"
        "era_location" -> "Epoche & Ort"
        "highlights" -> "Höhepunkte"
        "events" -> "Wichtige Lebensereignisse"
        "moral_lesson" -> "Moralische Lehre"
        "quranic_ref" -> "Koran-Referenz"
        "read_narrative" -> "Vollständige Erzählung lesen"
        "settings_language" -> "App-Sprache"
        "settings_language_desc" -> "Sprache für die gesamte App ändern"
        "calendar_title" -> "Dreifach-Kalender & Echtzeituhr"
        "hijri_date" -> "Islamisches Hidschri-Datum"
        "hindi_date" -> "Hindi Vikram Samvat"
        "english_date" -> "Gregorianisches Datum"
        "live_clock" -> "Echtzeituhr"
        else -> getEnglishString(key)
    }

    private fun getRussianString(key: String): String = when (key) {
        "nav_prophets" -> "Пророки"
        "nav_quran" -> "Коран"
        "nav_diary" -> "Дневник"
        "nav_settings" -> "Настройки"
        "app_title" -> "Истории Пророков"
        "app_subtitle" -> "Жизнеописания, священные хроники и размышления"
        "search_prophet_hint" -> "Поиск пророка, родителей, событий..."
        "bookmarks_only" -> "Закладки"
        "add_prophet" -> "Добавить пророка"
        "edit" -> "Редактировать"
        "delete" -> "Удалить"
        "save" -> "Сохранить"
        "cancel" -> "Отмена"
        "age" -> "Возраст / Срок жизни"
        "father" -> "Отец"
        "mother" -> "Мать"
        "siblings" -> "Братья и сестры"
        "children" -> "Дети"
        "era_location" -> "Эпоха и место"
        "highlights" -> "Краткое содержание"
        "events" -> "Ключевые события"
        "moral_lesson" -> "Назидание и урок"
        "quranic_ref" -> "Коранический аят"
        "read_narrative" -> "Читать повествование"
        "settings_language" -> "Язык приложения"
        "settings_language_desc" -> "Сменить язык интерфейса приложения"
        "calendar_title" -> "Тройной календарь и часы реального времени"
        "hijri_date" -> "Исламская дата Хиджры"
        "hindi_date" -> "Дата Викрам Самват"
        "english_date" -> "Григорианская дата"
        "live_clock" -> "Текущее время"
        else -> getEnglishString(key)
    }

    private fun getGujaratiString(key: String): String = when (key) {
        "nav_prophets" -> "પયગંબરો"
        "nav_quran" -> "કુરાન"
        "nav_diary" -> "ડાયરી"
        "nav_settings" -> "સેટિંગ્સ"
        "app_title" -> "કિસાસુલ અંબિયા"
        "app_subtitle" -> "પયગંબરોના જીવન પ્રસંગો અને આત્મ-ચિંતન"
        "search_prophet_hint" -> "પયગંબર, માતા-પિતા કે ઘટના શોધો..."
        "bookmarks_only" -> "માત્ર સંગ્રહિત"
        "age" -> "ઉંમર / આયુષ્ય"
        "father" -> "પિતા"
        "mother" -> "માતા"
        "siblings" -> "ભાઈ-બહેન"
        "children" -> "સંતાન"
        "calendar_title" -> "ત્રિવિધ કેલેન્ડર અને ઘડિયાળ"
        "hijri_date" -> "હિજરી ઇસ્લામિક તારીખ"
        "hindi_date" -> "વિક્રમ સંવત તારીખ"
        "english_date" -> "ગ્રેગોરિયન અંગ્રેજી તારીખ"
        "live_clock" -> "વાસ્તવિક સમય"
        else -> getHindiString(key)
    }

    private fun getTamilString(key: String): String = when (key) {
        "nav_prophets" -> "நபிமார்கள்"
        "nav_quran" -> "குர்ஆன்"
        "nav_diary" -> "டைரி"
        "nav_settings" -> "அமைப்புகள்"
        "app_title" -> "நபிமார்களின் வரலாறு"
        "search_prophet_hint" -> "நபி அல்லது நிகழ்வுகளைத் தேடுங்கள்..."
        "calendar_title" -> "முப்பரிமாண காலண்டர் & நேரடி கடிகாரம்"
        "hijri_date" -> "ஹிஜ்ரி இஸ்லாமிய தேதி"
        "hindi_date" -> "விக்ரம் சம்வத் தேதி"
        "english_date" -> "ஆங்கில தேதி"
        else -> getEnglishString(key)
    }

    private fun getTeluguString(key: String): String = when (key) {
        "nav_prophets" -> "ప్రవక్తలు"
        "nav_quran" -> "ఖురాన్"
        "nav_diary" -> "డైరీ"
        "nav_settings" -> "సెట్టింగ్‌లు"
        "app_title" -> "ప్రవక్తల చరిత్ర"
        "calendar_title" -> "త్రివిధ క్యాలెండర్ & గడియారం"
        "hijri_date" -> "హిజ్రీ ఇస్లామిక్ తేదీ"
        "hindi_date" -> "విక్రమ్ సంవత్ తేదీ"
        "english_date" -> "ఆంగ్ల గ్రెగోరియన్ తేదీ"
        else -> getEnglishString(key)
    }

    private fun getPunjabiString(key: String): String = when (key) {
        "nav_prophets" -> "ਨਬੀ / ਪੈਗੰਬਰ"
        "nav_quran" -> "ਕੁਰਆਨ"
        "nav_diary" -> "ਡਾਇਰੀ"
        "nav_settings" -> "ਸੈਟਿੰਗਾਂ"
        "app_title" -> "ਕਿਸਸੁਲ ਅੰਬੀਆ"
        "calendar_title" -> "ਤਿੰਨ-ਪੱਖੀ ਕੈਲੰਡਰ ਅਤੇ ਘੜੀ"
        "hijri_date" -> "ਹਿਜਰੀ ਇਸਲਾਮੀ ਤਾਰੀਖ਼"
        "hindi_date" -> "ਬਿਕ੍ਰਮੀ ਸੰਮਤ ਤਾਰੀਖ਼"
        "english_date" -> "ਅੰਗਰੇਜ਼ੀ ਤਾਰੀਖ਼"
        else -> getHindiString(key)
    }

    private fun getSwahiliString(key: String): String = when (key) {
        "nav_prophets" -> "Mitume"
        "nav_quran" -> "Kurani"
        "nav_diary" -> "Shajara"
        "nav_settings" -> "Mipangilio"
        "app_title" -> "Visa vya Mitume"
        "calendar_title" -> "Kalenda ya Utatu & Saa Halisi"
        "hijri_date" -> "Tarehe ya Hijria"
        "hindi_date" -> "Tarehe ya Vikram Samvat"
        "english_date" -> "Tarehe ya Kizungu"
        else -> getEnglishString(key)
    }

    /**
     * Localizes Prophet information to the selected app language.
     * When user changes language, the Prophet's descriptive labels and titles
     * adapt according to the selected language, while keeping Arabic calligraphy respectful!
     */
    fun getLocalizedProphetTitle(title: String, language: AppLanguage): String {
        return when (language) {
            AppLanguage.HINDI -> when (title) {
                "Abul-Bashar (Father of Mankind)", "Father of Mankind" -> "मानव जाति के आदि पिता (अबुल-बशर)"
                "The Patient Builder" -> "धैर्यवान कश्ती निर्माता (शेखुल-अंबिया)"
                "Khalilullah (Friend of Allah)" -> "ख़लीलुल्लाह (अल्लाह के मित्र)"
                "Zabihullah (The Sacrificed)" -> "ज़बीहुल्लाह (अल्लाह की राह में समर्पित)"
                "The Righteous Dreamer" -> "सच्चे सपनों वाले (अज़ीज़-ए-मिस्र)"
                "Kalimullah (He who spoke to Allah)" -> "कलीमुल्लाह (अल्लाह से संवाद करने वाले)"
                "Ruhullah (Spirit of Allah)" -> "रूहुल्लाह और कलिमतुल्लाह (ईसा मसीह)"
                "Khatam-un-Nabiyyin (Seal of the Prophets)" -> "खातम-उन-नबिय्यीन (रहमतुल-लिल-आलमीन ﷺ)"
                else -> title
            }
            AppLanguage.URDU -> when (title) {
                "Abul-Bashar (Father of Mankind)", "Father of Mankind" -> "ابو البشر (پہلے انسان و نبی)"
                "The Patient Builder" -> "شیخ الانبیاء (صابر اور کشتی بنانے والے)"
                "Khalilullah (Friend of Allah)" -> "خلیل اللہ (اللہ کے برگزیدہ دوست)"
                "Zabihullah (The Sacrificed)" -> "ذبیح اللہ (راہِ خدا میں قربان)"
                "The Righteous Dreamer" -> "صدیق و حسین (عزیزِ مصر)"
                "Kalimullah (He who spoke to Allah)" -> "کلیم اللہ (طور پر ہم کلام ہونے والے)"
                "Ruhullah (Spirit of Allah)" -> "روح اللہ و کلمۃ اللہ (حضرت مسیح)"
                "Khatam-un-Nabiyyin (Seal of the Prophets)" -> "خاتم النبیین (رحمۃ للعالمین ﷺ)"
                else -> title
            }
            AppLanguage.ARABIC -> when (title) {
                "Abul-Bashar (Father of Mankind)", "Father of Mankind" -> "أبو البشر وخليفة الله في الأرض"
                "The Patient Builder" -> "شيخ المرسلين وصاحب السفينة"
                "Khalilullah (Friend of Allah)" -> "خليل الرحمن وإمام الحنفاء"
                "Zabihullah (The Sacrificed)" -> "ذبيح الله وباني البيت العتيق"
                "The Righteous Dreamer" -> "الصديق الجميل وعزيز مصر"
                "Kalimullah (He who spoke to Allah)" -> "كليم الله وصاحب التوراة"
                "Ruhullah (Spirit of Allah)" -> "روح الله وكلمته الملقاة إلى مريم"
                "Khatam-un-Nabiyyin (Seal of the Prophets)" -> "خاتم الأنبياء والمرسلين ﷺ"
                else -> title
            }
            AppLanguage.TURKISH -> when (title) {
                "Abul-Bashar (Father of Mankind)", "Father of Mankind" -> "İnsanlığın Atası (Ebu'l-Beşer)"
                "The Patient Builder" -> "Sabır Timsali ve Gemi Ustası"
                "Khalilullah (Friend of Allah)" -> "Halilullah (Allah'ın Dostu)"
                "Zabihullah (The Sacrificed)" -> "Zebihullah (Kurban Edilen)"
                "Kalimullah (He who spoke to Allah)" -> "Kelamullah (Allah ile Konuşan)"
                "Ruhullah (Spirit of Allah)" -> "Ruhullah (Allah'ın Ruhu)"
                "Khatam-un-Nabiyyin (Seal of the Prophets)" -> "Hatemü'l-Enbiya (Son Peygamber ﷺ)"
                else -> title
            }
            AppLanguage.FRENCH -> when (title) {
                "Abul-Bashar (Father of Mankind)", "Father of Mankind" -> "Père de l'Humanité (Aboul-Bashar)"
                "Khalilullah (Friend of Allah)" -> "L'Ami Intime d'Allah (Khalilullah)"
                "Kalimullah (He who spoke to Allah)" -> "Celui qui parla à Allah (Kalimullah)"
                "Khatam-un-Nabiyyin (Seal of the Prophets)" -> "Le Sceau des Prophètes (ﷺ)"
                else -> title
            }
            AppLanguage.SPANISH -> when (title) {
                "Abul-Bashar (Father of Mankind)", "Father of Mankind" -> "Padre de la Humanidad"
                "Khalilullah (Friend of Allah)" -> "El Amigo Íntimo de Dios"
                "Kalimullah (He who spoke to Allah)" -> "Aquel que habló con Dios"
                "Khatam-un-Nabiyyin (Seal of the Prophets)" -> "El Sello de los Profetas (ﷺ)"
                else -> title
            }
            else -> title
        }
    }
}
