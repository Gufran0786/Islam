package com.example.data

/**
 * Node representing a Prophet within the unified Islamic Genealogical Family Tree (شجرۂ نسبِ انبیاء کرام).
 */
data class ProphetTreeNode(
    val id: String,
    val orderIndex: Int,
    val nameArabic: String,
    val nameRoman: String,
    val nameHindi: String,
    val nameUrdu: String,
    val title: String,
    val fatherName: String,
    val motherName: String,
    val eraLocation: String,
    val generationLevel: Int,
    val branch: String,
    val parentNodeId: String?,
    val directChildrenNodeIds: List<String>,
    val relationDescription: String,
    val lineageChain: String
)

object ProphetFamilyTreeData {

    val nodes: List<ProphetTreeNode> = listOf(
        // Generation 1
        ProphetTreeNode(
            id = "adam",
            orderIndex = 1,
            nameArabic = "آدَم عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Adam (A.S.)",
            nameHindi = "हज़रत आदम (अ.स.)",
            nameUrdu = "حضرت آدم علیہ السلام",
            title = "Abul Bashar (Father of Mankind) • Safiyullah",
            fatherName = "Khaliq: Allah Ta'ala (Bila-Walid)",
            motherName = "Khaliq: Allah Ta'ala (Mitti se takhleeq)",
            eraLocation = "Jannat / Sarandip (Sri Lanka) & Makkah",
            generationLevel = 1,
            branch = "Awwaleen (Origin)",
            parentNodeId = null,
            directChildrenNodeIds = listOf("sheeth"),
            relationDescription = "Insaniyat ke pehle bashar aur pehle Nabi.",
            lineageChain = "Allah Ta'ala ki qudrat se pehle insan o nabi banaye gaye."
        ),

        // Generation 2
        ProphetTreeNode(
            id = "sheeth",
            orderIndex = 2,
            nameArabic = "شِيث عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Sheeth (A.S.)",
            nameHindi = "हज़रत शीष (अ.स.)",
            nameUrdu = "حضرت شیث علیہ السلام",
            title = "Hibatullah (Allah ka tohfa)",
            fatherName = "Hazrat Adam (A.S.)",
            motherName = "Hazrat Hawwa (A.S.)",
            eraLocation = "Makkah Mukarramah / Hijaz",
            generationLevel = 2,
            branch = "Awwaleen (Origin)",
            parentNodeId = "adam",
            directChildrenNodeIds = listOf("idris"),
            relationDescription = "Hazrat Adam (A.S.) ke farzand jinko 50 sahife ata hue.",
            lineageChain = "Sheeth ibn Adam (A.S.)"
        ),

        // Generation 3
        ProphetTreeNode(
            id = "idris",
            orderIndex = 3,
            nameArabic = "إِدْرِيس عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Idris (A.S.)",
            nameHindi = "हज़रत इद्रीस (अ.स.)",
            nameUrdu = "حضرت ادریس علیہ السلام",
            title = "Akhnookh • Mu'allim al-Khatt wa al-Kalam",
            fatherName = "Yared (Yard)",
            motherName = "Barkanah",
            eraLocation = "Babil (Iraq) & Misr",
            generationLevel = 3,
            branch = "Awwaleen (Origin)",
            parentNodeId = "sheeth",
            directChildrenNodeIds = listOf("nuh"),
            relationDescription = "Pehle nabi jinhone qalam se likhna aur kapde seena sikhaya.",
            lineageChain = "Idris ibn Yard ibn Mahlalel ibn Qinan ibn Anosh ibn Sheeth ibn Adam (A.S.)"
        ),

        // Generation 4
        ProphetTreeNode(
            id = "nuh",
            orderIndex = 4,
            nameArabic = "نُوح عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Nuh (A.S.)",
            nameHindi = "हज़रत नूह (अ.स.)",
            nameUrdu = "حضرت نوح علیہ السلام",
            title = "Shaykh al-Anbiya • Adam-e-Saani",
            fatherName = "Lamech (Lamik)",
            motherName = "Shamkha bint Anosh",
            eraLocation = "Mesopotamia (Iraq)",
            generationLevel = 4,
            branch = "Awwaleen (Origin)",
            parentNodeId = "idris",
            directChildrenNodeIds = listOf("hud", "saleh", "ibrahim"),
            relationDescription = "Toofan-e-Nuh ke baad dunya ki nayi aabadi inke beton (Sam, Ham, Yafith) se phaili.",
            lineageChain = "Nuh ibn Lamik ibn Methuselah ibn Idris (A.S.)"
        ),

        // Generation 5 - Aad
        ProphetTreeNode(
            id = "hud",
            orderIndex = 5,
            nameArabic = "هُود عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Hud (A.S.)",
            nameHindi = "हज़रत हूद (अ.स.)",
            nameUrdu = "حضرت ہود علیہ السلام",
            title = "Nabi-e-Qaum-e-Aad",
            fatherName = "Shalikh (Shalakh)",
            motherName = "Aad lineage",
            eraLocation = "Ahqaf (Yemen / Oman)",
            generationLevel = 5,
            branch = "Arab-e-Baidah",
            parentNodeId = "nuh",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Sam ibn Nuh ki nasl se Qaum-e-Aad ki taraf maboos hue.",
            lineageChain = "Hud ibn Shalikh ibn Arfakhshand ibn Sam ibn Nuh (A.S.)"
        ),

        // Generation 5 - Thamud
        ProphetTreeNode(
            id = "saleh",
            orderIndex = 6,
            nameArabic = "صَالِح عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Saleh (A.S.)",
            nameHindi = "हज़रत सालेह (अ.स.)",
            nameUrdu = "حضرت صالح علیہ السلام",
            title = "Nabi-e-Naqatullah (Oonthni ka mojaza)",
            fatherName = "Ubaid ibn Asif",
            motherName = "Thamud lineage",
            eraLocation = "Al-Hijr / Mada'in Saleh (Hejaz)",
            generationLevel = 5,
            branch = "Arab-e-Baidah",
            parentNodeId = "nuh",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Sam ibn Nuh ki nasl se Qaum-e-Thamud ki taraf bheje gaye.",
            lineageChain = "Saleh ibn Ubaid ibn Asif ibn Mashikh ibn Ubaid ibn Hadir ibn Sam ibn Nuh (A.S.)"
        ),

        // Generation 6 - Central Pillar
        ProphetTreeNode(
            id = "ibrahim",
            orderIndex = 7,
            nameArabic = "إِبْرَاهِيم عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Ibrahim (A.S.)",
            nameHindi = "हज़रत इब्राहीम (अ.स.)",
            nameUrdu = "حضرت ابراہیم علیہ السلام",
            title = "Khalilullah (Allah ke dost) • Abul Anbiya",
            fatherName = "Tarikh (Aazar)",
            motherName = "Amila / Nuna",
            eraLocation = "Ur (Iraq), Harran, Sham, Misr & Makkah",
            generationLevel = 6,
            branch = "Markaz-e-Anbiya (Central Root)",
            parentNodeId = "nuh",
            directChildrenNodeIds = listOf("ismail", "ishaq"),
            relationDescription = "Tamam ba'd mein aane wale Anbiya ke jadd-e-amjad (Grand Patriarch).",
            lineageChain = "Ibrahim ibn Tarikh ibn Nahor ibn Sarug ibn Reu ibn Peleg ibn Eber ibn Shalikh ibn Arfakhshand ibn Sam ibn Nuh (A.S.)"
        ),

        // Generation 6 - Nephew of Ibrahim
        ProphetTreeNode(
            id = "lut",
            orderIndex = 8,
            nameArabic = "لُوط عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Lut (A.S.)",
            nameHindi = "हज़रत लूत (अ.स.)",
            nameUrdu = "حضرت لوط علیہ السلام",
            title = "Nabi-e-Sodom wa Gomorrah",
            fatherName = "Haran (Brother of Ibrahim A.S.)",
            motherName = "Mesopotamia lineage",
            eraLocation = "Sodom & Dead Sea (Jordan)",
            generationLevel = 6,
            branch = "Contemporary to Ibrahim",
            parentNodeId = "ibrahim",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Ibrahim (A.S.) ke bhatijey (brother Haran ke bete).",
            lineageChain = "Lut ibn Haran ibn Tarikh (Haran Ibrahim A.S. ke bhai the)"
        ),

        // Generation 7 - Branch 1: Ismaili Branch (Arab-e-Musta'ribah)
        ProphetTreeNode(
            id = "ismail",
            orderIndex = 9,
            nameArabic = "إِسْمَاعِيل عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Ismail (A.S.)",
            nameHindi = "हज़रत इस्माईल (अ.स.)",
            nameUrdu = "حضرت اسماعیل علیہ السلام",
            title = "Zabihullah (Allah ki rah mein qurbani) • Abul Arab",
            fatherName = "Hazrat Ibrahim (A.S.)",
            motherName = "Hazrat Hajirah (Hagar) A.S.",
            eraLocation = "Makkah Mukarramah (Hijaz)",
            generationLevel = 7,
            branch = "Bani Ismail (Arab-e-Musta'ribah)",
            parentNodeId = "ibrahim",
            directChildrenNodeIds = listOf("muhammad"),
            relationDescription = "Hazrat Ibrahim ke bade farzand; Ka'bah ki tameer shareek rahe; Quraish aur Khatam-un-Nabiyyin ke jadd-e-aala.",
            lineageChain = "Ismail ibn Ibrahim (A.S.) -> Qedar -> Adnan -> Quraish -> Prophet Muhammad (S.A.W.)"
        ),

        // Generation 7 - Branch 2: Ishaqi Branch (Bani Israel)
        ProphetTreeNode(
            id = "ishaq",
            orderIndex = 10,
            nameArabic = "إِسْحَاق عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Ishaq (A.S.)",
            nameHindi = "हज़रत इसहाक़ (अ.स.)",
            nameUrdu = "حضرت اسحاق علیہ السلام",
            title = "Basharat-e-Ilaahi • Jadd-e-Bani Israel",
            fatherName = "Hazrat Ibrahim (A.S.)",
            motherName = "Hazrat Sarah (A.S.)",
            eraLocation = "Hebron (Al-Khalil / Palestine)",
            generationLevel = 7,
            branch = "Bani Israel Root",
            parentNodeId = "ibrahim",
            directChildrenNodeIds = listOf("yaqub", "ayyub"),
            relationDescription = "Hazrat Ibrahim ke doosre farzand; Hazrat Sarah se paida hue.",
            lineageChain = "Ishaq ibn Ibrahim (A.S.)"
        ),

        // Generation 8 - Israel
        ProphetTreeNode(
            id = "yaqub",
            orderIndex = 11,
            nameArabic = "يَعْقُوب عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Yaqub (A.S.)",
            nameHindi = "हज़रत याक़ूब (अ.स.)",
            nameUrdu = "حضرت یعقوب علیہ السلام",
            title = "Israel (Allah ka banda) • Sabir-e-Azam",
            fatherName = "Hazrat Ishaq (A.S.)",
            motherName = "Rifqa (Rebekah)",
            eraLocation = "Kan'an (Canaan / Palestine) & Misr",
            generationLevel = 8,
            branch = "Bani Israel",
            parentNodeId = "ishaq",
            directChildrenNodeIds = listOf("yusuf"),
            relationDescription = "Inhi ka laqab 'Israel' tha jinke 12 beton se Bani Israel ke 12 qabeele bane.",
            lineageChain = "Yaqub ibn Ishaq ibn Ibrahim (A.S.)"
        ),

        // Generation 9 - Yusuf
        ProphetTreeNode(
            id = "yusuf",
            orderIndex = 12,
            nameArabic = "يُوسُف عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Yusuf (A.S.)",
            nameHindi = "हज़रत यूसुफ़ (अ.स.)",
            nameUrdu = "حضرت یوسف علیہ السلام",
            title = "As-Siddiq • Ahsan al-Qasas • Aziz-e-Misr",
            fatherName = "Hazrat Yaqub (A.S.)",
            motherName = "Rahil (Rachel)",
            eraLocation = "Kan'an & Misr (Egypt)",
            generationLevel = 9,
            branch = "Bani Israel",
            parentNodeId = "yaqub",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Yaqub ke mahboob tareen farzand aur Misr ke azeem wazir.",
            lineageChain = "Yusuf ibn Yaqub ibn Ishaq ibn Ibrahim (A.S.)"
        ),

        // Contemporary - Shu'aib
        ProphetTreeNode(
            id = "shuaib",
            orderIndex = 13,
            nameArabic = "شُعَيْب عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Shu'aib (A.S.)",
            nameHindi = "हज़रत शुऐब (अ.स.)",
            nameUrdu = "حضرت شعیب علیہ السلام",
            title = "Khateeb al-Anbiya (Eloquent Orator)",
            fatherName = "Mika'il / Yashjur",
            motherName = "Madyan lineage",
            eraLocation = "Madyan & Ashab al-Aykah (Jordan/Tabuk)",
            generationLevel = 8,
            branch = "Descendant of Ibrahim (via Madyan)",
            parentNodeId = "ibrahim",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Ibrahim (A.S.) ke farzand Madyan ki nasl se; Hazrat Musa ke susar mohtaram.",
            lineageChain = "Shu'aib ibn Yashjur ibn Madyan ibn Ibrahim (A.S.)"
        ),

        // Ayyub & Dhul Kifl
        ProphetTreeNode(
            id = "ayyub",
            orderIndex = 14,
            nameArabic = "أَيُّوب عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Ayyub (A.S.)",
            nameHindi = "हज़रत अय्यूब (अ.स.)",
            nameUrdu = "حضرت ایوب علیہ السلام",
            title = "Imam al-Sabireen (Symbol of Supreme Patience)",
            fatherName = "Amos ibn Zarikh",
            motherName = "Lineage of Lut (A.S.)",
            eraLocation = "Hauran / Sham (Syria)",
            generationLevel = 9,
            branch = "Branch of Ishaq (A.S.)",
            parentNodeId = "ishaq",
            directChildrenNodeIds = listOf("dhulkifl"),
            relationDescription = "Hazrat Ishaq ke farzand Eesau ki nasl se; be-misaal sabr ke malik.",
            lineageChain = "Ayyub ibn Amos ibn Zarikh ibn Eesau ibn Ishaq ibn Ibrahim (A.S.)"
        ),

        ProphetTreeNode(
            id = "dhulkifl",
            orderIndex = 15,
            nameArabic = "ذُو ٱلْكِفْل عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Dhul-Kifl (A.S.)",
            nameHindi = "हज़रत ज़ुल-किफ़्ल (अ.स.)",
            nameUrdu = "حضرت ذوالکفل علیہ السلام",
            title = "Bishr • Kafil-e-Ahad (Pledge keeper)",
            fatherName = "Hazrat Ayyub (A.S.)",
            motherName = "Rahma (Granddaughter of Yusuf A.S.)",
            eraLocation = "Damascus / Babylon",
            generationLevel = 10,
            branch = "Branch of Ayyub (A.S.)",
            parentNodeId = "ayyub",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Ayyub (A.S.) ke farzand jinhone insaaf aur zimmadari ko nibhaya.",
            lineageChain = "Dhul-Kifl (Bishr) ibn Ayyub (A.S.)"
        ),

        // Generation 10 - Musa & Harun (Levi branch)
        ProphetTreeNode(
            id = "musa",
            orderIndex = 16,
            nameArabic = "مُوسَىٰ عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Musa (A.S.)",
            nameHindi = "हज़रत मूसा (अ.स.)",
            nameUrdu = "حضرت موسیٰ علیہ السلام",
            title = "Kaleemullah (Allah se kalam karne wale) • Ulul Azm",
            fatherName = "Imran (Amram)",
            motherName = "Yukhabid (Jochebed)",
            eraLocation = "Misr, Sinai, Tur & Madyan",
            generationLevel = 10,
            branch = "Bani Israel (Levi tribe)",
            parentNodeId = "yaqub",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Yaqub ke farzand Levi ki nasl se; Firaun se muqabla kiya aur Taurat ata hui.",
            lineageChain = "Musa ibn Imran ibn Qahath ibn Levi ibn Yaqub ibn Ishaq ibn Ibrahim (A.S.)"
        ),

        ProphetTreeNode(
            id = "harun",
            orderIndex = 17,
            nameArabic = "هَارُون عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Harun (A.S.)",
            nameHindi = "हज़रत हारून (अ.स.)",
            nameUrdu = "حضرت ہارون علیہ السلام",
            title = "Wazir-e-Musa • Khush-Bayan Nabi",
            fatherName = "Imran (Amram)",
            motherName = "Yukhabid (Jochebed)",
            eraLocation = "Misr & Sehra-e-Sinai",
            generationLevel = 10,
            branch = "Bani Israel (Levi tribe)",
            parentNodeId = "yaqub",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Musa (A.S.) ke sage bade bhai aur wazir.",
            lineageChain = "Harun ibn Imran ibn Qahath ibn Levi ibn Yaqub (A.S.)"
        ),

        // Dawood & Sulaiman (Judah branch)
        ProphetTreeNode(
            id = "dawood",
            orderIndex = 18,
            nameArabic = "دَاوُۥد عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Dawood (A.S.)",
            nameHindi = "हज़रत दाऊद (अ.स.)",
            nameUrdu = "حضرت داؤد علیہ السلام",
            title = "Khalifatullah • Sahibul Zaboor • Nabi wa Badshah",
            fatherName = "Yassa (Jesse)",
            motherName = "Nitzevet",
            eraLocation = "Baitul Muqaddas (Jerusalem / Palestine)",
            generationLevel = 12,
            branch = "Bani Israel (Judah tribe)",
            parentNodeId = "yaqub",
            directChildrenNodeIds = listOf("sulaiman"),
            relationDescription = "Yaqub ke farzand Yahuda (Judah) ki nasl se; Jalut ko qatal kiya aur Zaboor paai.",
            lineageChain = "Dawood ibn Yassa ibn Obeid ibn Boaz ibn Salmah ibn Nahshon ibn Amminadab ibn Ram ibn Hezron ibn Perez ibn Judah ibn Yaqub (A.S.)"
        ),

        ProphetTreeNode(
            id = "sulaiman",
            orderIndex = 19,
            nameArabic = "سُلَيْمَان عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Sulaiman (A.S.)",
            nameHindi = "हज़रत सुलैमान (अ.स.)",
            nameUrdu = "حضرت سلیمان علیہ السلام",
            title = "Hakim-e-Jinn-o-Ins • Malikat-e-Saba ke daur ke badshah",
            fatherName = "Hazrat Dawood (A.S.)",
            motherName = "Bathsheba",
            eraLocation = "Baitul Muqaddas (Jerusalem)",
            generationLevel = 13,
            branch = "Bani Israel (Judah tribe)",
            parentNodeId = "dawood",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Dawood ke farzand jinhe hawa, jinnat aur parindon ki boliyon par qudrat di gayi.",
            lineageChain = "Sulaiman ibn Dawood (A.S.)"
        ),

        // Yunus
        ProphetTreeNode(
            id = "yunus",
            orderIndex = 20,
            nameArabic = "يُونُس عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Yunus (A.S.)",
            nameHindi = "हज़रत यूनुस (अ.स.)",
            nameUrdu = "حضرت یونس علیہ السلام",
            title = "Zun-Noon (Machli wale) • Sahibul Hoot",
            fatherName = "Matta (Amittai)",
            motherName = "Binyamin lineage",
            eraLocation = "Nineveh (Mosul / Iraq)",
            generationLevel = 11,
            branch = "Bani Israel (Benjamin tribe)",
            parentNodeId = "yaqub",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Yaqub ke chote farzand Binyamin ki nasl se; machli ke pet mein Ayat-e-Kareema padhi.",
            lineageChain = "Yunus ibn Matta (nasl-e-Binyamin ibn Yaqub A.S.)"
        ),

        // Ilyas & Al-Yasa
        ProphetTreeNode(
            id = "ilyas",
            orderIndex = 21,
            nameArabic = "إِلْيَاس عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Ilyas (A.S.)",
            nameHindi = "हज़रत इल्यास (अ.स.)",
            nameUrdu = "حضرت الیاس علیہ السلام",
            title = "Nabi-e-Ba'labak • Mujaahid al-Tauheed",
            fatherName = "Yasin ibn Finhas",
            motherName = "Harun lineage",
            eraLocation = "Baalbek (Lebanon / Syria)",
            generationLevel = 12,
            branch = "Bani Israel (Harun lineage)",
            parentNodeId = "harun",
            directChildrenNodeIds = listOf("alyasa"),
            relationDescription = "Hazrat Harun (A.S.) ki aulado mein se; but 'Baal' ki parastish ke khilaf lade.",
            lineageChain = "Ilyas ibn Yasin ibn Finhas ibn Eleazar ibn Harun (A.S.)"
        ),

        ProphetTreeNode(
            id = "alyasa",
            orderIndex = 22,
            nameArabic = "ٱلْيَسَع عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Al-Yasa (A.S.)",
            nameHindi = "हज़रत अल-यसअ (अ.स.)",
            nameUrdu = "حضرت الیسع علیہ السلام",
            title = "Janasheen-e-Ilyas • Sahibul Barkat",
            fatherName = "Akhtoob (Shaphat)",
            motherName = "Sham lineage",
            eraLocation = "Syria / Palestine",
            generationLevel = 13,
            branch = "Bani Israel",
            parentNodeId = "ilyas",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Ilyas (A.S.) ke shagirde-khas aur khalifa.",
            lineageChain = "Al-Yasa ibn Akhtoob (rafeeq o janasheen Hazrat Ilyas A.S.)"
        ),

        // Zakariya & Yahya
        ProphetTreeNode(
            id = "zakariya",
            orderIndex = 23,
            nameArabic = "زَكَرِيَّا عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Zakariya (A.S.)",
            nameHindi = "हज़रत ज़करिया (अ.स.)",
            nameUrdu = "حضرت زکریا علیہ السلام",
            title = "Kafil-e-Maryam • Shahid al-Haqq",
            fatherName = "Barkhiya (Dan)",
            motherName = "Bani Israel lineage",
            eraLocation = "Baitul Muqaddas (Palestine)",
            generationLevel = 14,
            branch = "Bani Israel (Sulaiman lineage)",
            parentNodeId = "sulaiman",
            directChildrenNodeIds = listOf("yahya"),
            relationDescription = "Hazrat Dawood o Sulaiman ki aulado mein se; Hazrat Maryam ki parwarish ki.",
            lineageChain = "Zakariya ibn Barkhiya ibn Muslim ibn Sadooq ibn Sulaiman ibn Dawood (A.S.)"
        ),

        ProphetTreeNode(
            id = "yahya",
            orderIndex = 24,
            nameArabic = "يَحْيَىٰ عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Yahya (A.S.)",
            nameHindi = "हज़रत यह्या (अ.स.)",
            nameUrdu = "حضرت یحییٰ علیہ السلام",
            title = "Sayyid-o-Hasoor • Nam-e-Ilaahi",
            fatherName = "Hazrat Zakariya (A.S.)",
            motherName = "Isha (Elizabeth)",
            eraLocation = "Palestine & Jordan Valley",
            generationLevel = 15,
            branch = "Bani Israel",
            parentNodeId = "zakariya",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Zakariya (A.S.) ke farzand jinka naam khud Allah Ta'ala ne 'Yahya' rakha.",
            lineageChain = "Yahya ibn Zakariya (A.S.)"
        ),

        // Isa
        ProphetTreeNode(
            id = "isa",
            orderIndex = 25,
            nameArabic = "عِيسَىٰ عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Isa (A.S.)",
            nameHindi = "हज़रत ईसा (अ.स.)",
            nameUrdu = "حضرت عیسیٰ علیہ السلام",
            title = "Al-Masih • Kalimatullah • Roohullah • Ulul Azm",
            fatherName = "Bila-Baap (Mo'jaza-e-Qudrat)",
            motherName = "Hazrat Maryam bint Imran (A.S.)",
            eraLocation = "Bait Lahm (Bethlehem) & Nazareth (Palestine)",
            generationLevel = 15,
            branch = "Bani Israel (Maryam bint Imran)",
            parentNodeId = "sulaiman",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Bani Israel ke aakhri Rasool jo bina baap ke Allah ke kun kahne se paida hue aur aasmaan par uthaye gaye.",
            lineageChain = "Isa ibn Maryam bint Imran ibn Yashhim ibn Amon ibn Sulaiman ibn Dawood (A.S.)"
        ),

        // Khatam-un-Nabiyyin - Prophet Muhammad (S.A.W.)
        ProphetTreeNode(
            id = "muhammad",
            orderIndex = 26,
            nameArabic = "مُحَمَّدٌ رَسُولُ ٱللَّهِ ﷺ",
            nameRoman = "Hazrat Muhammad (S.A.W.)",
            nameHindi = "हज़रत मुहम्मद मुस्तफ़ा (सल्ल.)",
            nameUrdu = "حضرت محمد مصطفیٰ صلی اللہ علیہ وسلم",
            title = "Khatam-un-Nabiyyin • Sayyid al-Mursaleen • Rahmatul-lil-Aalameen",
            fatherName = "Hazrat Abdullah",
            motherName = "Hazrat Aminah bint Wahb",
            eraLocation = "Makkah Mukarramah & Madinah Munawwarah",
            generationLevel = 16,
            branch = "Bani Ismail (Khatam-un-Nubuwwah)",
            parentNodeId = "ismail",
            directChildrenNodeIds = emptyList(),
            relationDescription = "Hazrat Ibrahim aur Ismail (A.S.) ki duawon ka samra; Qayamat tak aane wale tamam insano ke Rasool.",
            lineageChain = "Muhammad (S.A.W.) ibn Abdullah ibn Abdul Muttalib ibn Hashim ibn Abd Manaf ibn Qusayy ibn Kilab ibn Murrah ibn Ka'b ibn Lu'ayy ibn Ghalib ibn Fihr (Quraish) ibn Malik ibn An-Nadr ibn Kinanah ibn Khuzaymah ibn Mudrikah ibn Ilyas ibn Mudar ibn Nizar ibn Ma'add ibn Adnan (nasl-e-Ismail ibn Ibrahim A.S.)"
        )
    )
}
