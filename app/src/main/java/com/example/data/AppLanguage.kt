package com.example.data

enum class AppLanguage(
    val code: String,
    val displayName: String,
    val nativeName: String,
    val flag: String,
    val region: String
) {
    HINDI("hi", "Hindi", "हिन्दी", "🇮🇳", "India"),
    URDU("ur", "Urdu", "اردو", "🇵🇰", "Pakistan / South Asia"),
    ENGLISH("en", "English", "English", "🌐", "International"),
    ARABIC("ar", "Arabic", "العربية", "🇸🇦", "Arab World"),
    BENGALI("bn", "Bengali", "বাংলা", "🇧🇩", "Bangladesh / India"),
    TURKISH("tr", "Turkish", "Türkçe", "🇹🇷", "Turkey"),
    INDONESIAN("id", "Indonesian", "Bahasa Indonesia", "🇮🇩", "Indonesia"),
    MALAY("ms", "Malay", "Bahasa Melayu", "🇲🇾", "Malaysia"),
    PERSIAN("fa", "Persian / Farsi", "فارسی", "🇮🇷", "Iran / Central Asia"),
    FRENCH("fr", "French", "Français", "🇫🇷", "France / Francophone"),
    SPANISH("es", "Spanish", "Español", "🇪🇸", "Spain / Latin America"),
    GERMAN("de", "German", "Deutsch", "🇩🇪", "Germany / Europe"),
    RUSSIAN("ru", "Russian", "Русский", "🇷🇺", "Russia / Eurasia"),
    GUJARATI("gu", "Gujarati", "ગુજરાતી", "🇮🇳", "Gujarat, India"),
    TAMIL("ta", "Tamil", "தமிழ்", "🇮🇳", "Tamil Nadu / Sri Lanka"),
    TELUGU("te", "Telugu", "తెలుగు", "🇮🇳", "Andhra Pradesh / Telangana"),
    PUNJABI("pa", "Punjabi", "ਪੰਜਾਬੀ", "🇮🇳", "Punjab"),
    SWAHILI("sw", "Swahili", "Kiswahili", "🇰🇪", "East Africa")
}
