package com.example.data

object InitialData {

    data class PrepopulatedProphet(
        val prophet: ProphetEntity,
        val events: List<ProphetEventEntity>
    )

    fun getInitialData(): List<PrepopulatedProphet> {
        return listOf(
            // 1. Hazrat Adam (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 1,
                    orderIndex = 1,
                    nameArabic = "آدم عليه السلام",
                    nameRoman = "Hazrat Adam (A.S.)",
                    title = "Abul Bashar / Safiyullah (Chosen of Allah)",
                    ageYears = "960–1000 Saal",
                    fatherName = "Direct Creation from Soil (Bila Walidain)",
                    motherName = "None (Pehle Insan)",
                    siblings = "None (Awwal al-Bashar)",
                    children = "Habil (Abel), Qabil (Cain), Sheeth (Seth), Iqlima, Lubuda",
                    wives = "Hazrat Hawwa (A.S.) - Umm al-Bashar",
                    eraLocation = "Beginning of Creation, Sri Lanka / Arabian Peninsula",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Pehle Insan aur Pehle Nabi jinhe Allah Ta'ala ne mitti se takhleeq farmaya aur Farishton se sajda karwaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 101, prophetId = 1,
                        title = "Takhleeq-e-Adam aur Sajda ka Hukm",
                        summary = "Allah ne Adam (A.S.) ko mitti se banaya, ilm-e-asma sikhaya, aur farishton ko sajda-e-tazeem ka hukm diya.",
                        detailedNarrative = "Jab Allah Ta'ala ne zameen par apna Khalifa banane ka irada farmaya, to mitti jama karke usme apni taraf se rooh phoonki. Adam (A.S.) ko tamam cheezon ke naam aur unki haqeeqat ka ilm bakhsha. Farishton ne sajda kiya magar Iblees ne takabbur kiya aur randa-e-dargah hua.",
                        quranicReference = "Surah Al-Baqarah (2:30-34), Surah Al-A'raf (7:11-18)",
                        moralLesson = "Ilm aur tawazu insan ka asli sharaf hai, jabki takabbur zillat ka sabab banta hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 102, prophetId = 1,
                        title = "Jannat se Zameen par Nuzul aur Dua-e-Tauba",
                        summary = "Shaitan ke behkawe ke baad nihayat aaji ke sath tauba ki aur Allah ne dua qabool farmai.",
                        detailedNarrative = "Adam (A.S.) aur Hawwa (A.S.) ne zameen par aakar nihayat aaji ke sath tauba ki: 'Rabbana zalamna anfusana wa il-lam taghfir lana wa tarhamna lanakunanna minal-khasireen'. Allah ne unki tauba qabool farmai aur hidayat ka wada diya.",
                        quranicReference = "Surah Al-A'raf (7:23), Surah Ta-Ha (20:121-123)",
                        moralLesson = "Ghalti ke baad sachchi nidamat aur ruju' ilallah insan ko Allah ka muqarrab bana deti hai.",
                        orderIndex = 2
                    )
                )
            ),

            // 2. Hazrat Idris (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 2,
                    orderIndex = 2,
                    nameArabic = "إدریس علیه السلام",
                    nameRoman = "Hazrat Idris (A.S.)",
                    title = "Ustad al-Bashar (The Scholar & First Scribe)",
                    ageYears = "Taqreeban 365 Saal",
                    fatherName = "Yared (Yarid bin Mahalalel)",
                    motherName = "Barkanah",
                    siblings = "Khabra aur digar rishtedar",
                    children = "Methuselah (Matushelakh)",
                    wives = "Aadanah / Barkanah",
                    eraLocation = "Babylon (Iraq) wa Misr (Egypt)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Pehle shakhs jinhone qalam se likhna, kapde silna aur hisaab-o-falakiyat ka aaghaz kiya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 201, prophetId = 2,
                        title = "Ilm-o-Hikmat aur Qalam ki Ibtida",
                        summary = "Hazrat Idris (A.S.) ne logon ko tauheed sikhayi aur unhe buland maqam ata hua.",
                        detailedNarrative = "Hazrat Idris (A.S.) nihayat sadiq aur parhezgar the. Riwayat me aata hai ki sabse pehle qalam se likhne ka aaghaz unhi se hua. Quran-e-Pak me irshad hai: 'Wa rafa'nahu makanan 'aliyya' (Humne unhe buland maqam par uthaya).",
                        quranicReference = "Surah Maryam (19:56-57)",
                        moralLesson = "Ilm, hunar aur mehnat deen wa dunya dono me insan ke darjaat buland karte hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 3. Hazrat Nuh (A.S.) - Noah
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 3,
                    orderIndex = 3,
                    nameArabic = "نوح عليه السلام",
                    nameRoman = "Hazrat Nuh (A.S.)",
                    title = "Shaikh al-Anbiya / Adam Thani (Father of Mankind II)",
                    ageYears = "950+ Saal",
                    fatherName = "Lamech (Lamik bin Methuselah)",
                    motherName = "Qanoosh bint Rakeel",
                    siblings = "Sabik aur digar baradaran",
                    children = "Sam (Shem), Ham, Yafith (Japheth), Kanaan (Yam)",
                    wives = "Amzura / Waliyah (Waghila)",
                    eraLocation = "Mesopotamia (Kufa / Southern Iraq)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "950 saal tak sabr-o-istiqamat ke sath tableegh ki aur Allah ke hukm se azeem Kashti banai."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 301, prophetId = 3,
                        title = "Kashti ki Tameer aur Aalamgeer Toofan",
                        summary = "Toofan-e-Nuh me imandar kashti me bach gaye aur kuffar ghaarat hue.",
                        detailedNarrative = "Hazrat Nuh (A.S.) ne Allah ke hukm se Kashti banai. Aalamgeer toofan ke waqt har jandar ka joda aur imandar sawar hue. Kashti Koh-e-Judi par thehri.",
                        quranicReference = "Surah Hud (11:36-48), Surah Nuh (71:1-28)",
                        moralLesson = "Najaat sirf imaan aur itaat-e-ilahi me hai, nasabi rishte amal ke baghair be-asar hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 4. Hazrat Hud (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 4,
                    orderIndex = 4,
                    nameArabic = "هود عليه السلام",
                    nameRoman = "Hazrat Hud (A.S.)",
                    title = "Nabi-e-Qoum-e-Aad",
                    ageYears = "Taqreeban 464 Saal",
                    fatherName = "Shalikh (bin Arphaxad bin Sam)",
                    motherName = "Umm Hud (Muwahhida)",
                    siblings = "Hazrat Murrah",
                    children = "Faris, Malik aur aal-o-awlad",
                    wives = "Malika / Khulud",
                    eraLocation = "Al-Ahqaf (Yemen wa Hadramaut)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Qoum-e-Aad jo buland mehlon aur jismani taqat par naaz karti thi, use tauheed ki dawat di."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 401, prophetId = 4,
                        title = "Qoum-e-Aad par Tund-o-Teez Aandhi ka Azaab",
                        summary = "7 raat aur 8 din chalne wali aandhi ne takabbur karne wali qoum ko nest-o-nabood kar diya.",
                        detailedNarrative = "Qoum-e-Aad ne kaha 'Hum se zyada taqatwar kaun hai?'. Allah ne un par 7 raatein aur 8 din musalsal haibatnak hawa chalai jisme wo ukhde hue khajoor ke tano ki tarah dher ho gaye.",
                        quranicReference = "Surah Al-Haqqah (69:6-8), Surah Hud (11:50-60)",
                        moralLesson = "Taqat aur daulat ka ghamand karne wale Allah ke azaab ke aage kuch nahi.",
                        orderIndex = 1
                    )
                )
            ),

            // 5. Hazrat Salih (A.S.) - Saleh
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 5,
                    orderIndex = 5,
                    nameArabic = "صالح عليه السلام",
                    nameRoman = "Hazrat Salih (A.S.)",
                    title = "Nabi-e-Qoum-e-Thamud",
                    ageYears = "Taqreeban 280 Saal",
                    fatherName = "Ubaid (bin Asif bin Maseh)",
                    motherName = "Umm Salih",
                    siblings = "Nazeer aur baradaran",
                    children = "Haroon aur digar awlad",
                    wives = "Jamila",
                    eraLocation = "Al-Hijr / Mada'in Salih (Saudi Arabia)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Pahad se mo'jizati Oontni (Naqatullah) nikli, jise zillat-pasandon ne qatal kiya aur azaab aaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 501, prophetId = 5,
                        title = "Naqatullah (Oontni) ka Mo'jiza aur Rajfah",
                        summary = "Thamud ne oontni ko zakhmi kiya, 3 din baad azeem cheekh ne unhe halaak kar diya.",
                        detailedNarrative = "Thamud ke mutalbe par Allah ne chatan se doodh dene wali azeem oontni zahir ki. Magar Qaddar bin Salif aur shar-pasandon ne oontni ki koonchein kaat di. Teesri subah ek chinghad aur zalzale ne unhe unke gharon me halak kar diya.",
                        quranicReference = "Surah Ash-Shu'ara (26:141-159), Surah Hud (11:61-68)",
                        moralLesson = "Allah ke ehkam aur uski nishaniyon ki behurmati azaab-e-ilahi ko dawat deti hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 6. Hazrat Ibrahim (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 6,
                    orderIndex = 6,
                    nameArabic = "إبراهيم عليه السلام",
                    nameRoman = "Hazrat Ibrahim (A.S.)",
                    title = "Khalilullah (Friend of Allah) / Abul Anbiya",
                    ageYears = "175–195 Saal",
                    fatherName = "Tarukh (Azar uncle / guardian)",
                    motherName = "Buna bint Karbana",
                    siblings = "Nahor (Nahoor), Haran (Father of Hazrat Lut)",
                    children = "Hazrat Ismail (A.S.), Hazrat Ishaq (A.S.), Madyan, Zimran",
                    wives = "Hazrat Sarah (A.S.), Hazrat Hajar (A.S.), Qantura, Hajoon",
                    eraLocation = "Ur (Babylon), Canaan (Palestine), Makkah Al-Mukarramah",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Tauheed ke azeem parcham-bardar, Aag me dale gaye magar gulzar hui, Kaaba ki tameer ki."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 601, prophetId = 6,
                        title = "Namrood ki Aag ka Gulzar Banna",
                        summary = "Namrood ne azeem aag dahkai, Allah ne aag ko thanda aur salamati wala bana diya.",
                        detailedNarrative = "Jab Ibrahim (A.S.) ne buton ko tode aur tauheed bayan ki, to Namrood ne unhe azeem aag me phenka. Allah Ta'ala ne aag ko hukm diya: 'Ya naaru kooni bardanw-wa salaaman 'alaaa Ibraheem'. Aag bagh-o-bahar ban gayi.",
                        quranicReference = "Surah Al-Anbiya (21:68-71)",
                        moralLesson = "Jo Allah par kamil bharosa rakhta hai, aag bhi uska baal bika nahi kar sakti.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 602, prophetId = 6,
                        title = "Kaaba ki Tameer aur Maqam-e-Ibrahim",
                        summary = "Hazrat Ibrahim aur Hazrat Ismail (A.S.) ne baitullah ki tameer farmai aur Hajj ki azaan di.",
                        detailedNarrative = "Baap aur bete ne milkar Khana-e-Kaba ki deewarein uthain aur dua mangi: 'Rabbana taqabbal minna'. Allah ne unke qadmon ke nishan ko 'Maqam-e-Ibrahim' bana diya.",
                        quranicReference = "Surah Al-Baqarah (2:127-129)",
                        moralLesson = "Ikhlas ke sath kiya gaya amal qiyamat tak ke liye baais-e-barkat ban jata hai.",
                        orderIndex = 2
                    )
                )
            ),

            // 7. Hazrat Lut (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 7,
                    orderIndex = 7,
                    nameArabic = "لوط عليه السلام",
                    nameRoman = "Hazrat Lut (A.S.)",
                    title = "Nabi-e-Sodom wa Gomorrah",
                    ageYears = "Taqreeban 175 Saal",
                    fatherName = "Haran (Brother of Hazrat Ibrahim A.S.)",
                    motherName = "Umm Lut",
                    siblings = "Milkah, Iscah (Sara)",
                    children = "Rithah, Za'oora (Betiyaan)",
                    wives = "Wa'ilah (Walihah - nafarman aur kuffar ki hamdard)",
                    eraLocation = "Sodom & Gomorrah (Dead Sea / Jordan)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Fuhash aur behayai me lipt qoum ko dawat di; subah saware pattharon ki baarish se azaab aaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 701, prophetId = 7,
                        title = "Qoum-e-Lut par Patharon ki Baarish",
                        summary = "Be-haya qoum ki bastiyan ulat di gayin aur paki-parhezgari ko bacha liya gaya.",
                        detailedNarrative = "Farishte mehmaan ban kar aaye. Jab bad-kirdar qoum ne hamla karna chaha to farishton ne unhe andha kar diya aur Hazrat Lut ko ahl-e-khana ke sath raat me nikalne ka hukm diya. Subah hote hi bastiyan palat di gayin.",
                        quranicReference = "Surah Hud (11:77-83), Surah Al-Hijr (15:58-76)",
                        moralLesson = "Akhlaqi bigaad aur fitrat ke khilaf gunah qaumon ko zameen-bose kar dete hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 8. Hazrat Ismail (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 8,
                    orderIndex = 8,
                    nameArabic = "إسماعيل عليه السلام",
                    nameRoman = "Hazrat Ismail (A.S.)",
                    title = "Zabihullah (The Sacrificed of Allah) / Jadd al-Mustafa",
                    ageYears = "137 Saal",
                    fatherName = "Hazrat Ibrahim (A.S.)",
                    motherName = "Hazrat Hajar (A.S.)",
                    siblings = "Hazrat Ishaq (A.S.)",
                    children = "Nabit, Qaydar (Ancestors of Arab Adnan)",
                    wives = "Amarah bint Sa'd, Sayyidah bint Mudad (Jurhum tribe)",
                    eraLocation = "Makkah Al-Mukarramah (Hejaz)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Pani ke liye Zamzam jaari hua, Qurbani ke azeem imtihan me sabr dikhaya, Kaaba tameer kiya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 801, prophetId = 8,
                        title = "Zamzam ka Chashma aur Sa'ee",
                        summary = "Hazrat Hajar ne Safa wa Marwah ke 7 chakkar lagaye aur bachhe ke qadmon se Zamzam phoot pada.",
                        detailedNarrative = "Hazrat Hajar ne pyase bachhe Ismail (A.S.) ke liye Safa aur Marwa ke darmiyan daud lagai. Jibreel (A.S.) ne apna par maara aur qudrat se Zamzam ka aab-e-shifa chashma jari hua.",
                        quranicReference = "Sahih Bukhari (Hadith-e-Baitullah), Surah Ibrahim (14:37)",
                        moralLesson = "Maa ki koshish aur tawakkul-e-ilahi qiyamat tak ke hujjaj ke liye shiaar ban gaya.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 802, prophetId = 8,
                        title = "Azeem Qurbani aur Dumbey ka Fidya",
                        summary = "Ibrahim (A.S.) ke khwab par labbaik kaha aur Allah ne Jannati dumba bhej kar zibah farmaya.",
                        detailedNarrative = "Hazrat Ismail (A.S.) ne farzandana ata'at se kaha: 'Abba jaan! Jo hukm mila hai kar guzariye, insha-Allah aap mujhe sabir payenge'. Allah ne imtihan qubool farmaya aur fidya bakhsha.",
                        quranicReference = "Surah As-Saffat (37:101-108)",
                        moralLesson = "Raza-e-ilahi ke aage apni pyari se pyari cheez qurban karne ka jazba imaan ki jaan hai.",
                        orderIndex = 2
                    )
                )
            ),

            // 9. Hazrat Ishaq (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 9,
                    orderIndex = 9,
                    nameArabic = "إسحاق عليه السلام",
                    nameRoman = "Hazrat Ishaq (A.S.)",
                    title = "Nabiullah / Basharat-e-Mala'ikah",
                    ageYears = "180 Saal",
                    fatherName = "Hazrat Ibrahim (A.S.)",
                    motherName = "Hazrat Sarah (A.S.)",
                    siblings = "Hazrat Ismail (A.S.)",
                    children = "Hazrat Ya'qub (A.S.), Isu (Esau)",
                    wives = "Hazrat Rifqah (Rebecca bint Bethuel)",
                    eraLocation = "Hebron (Al-Khalil / Palestine)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Hazrat Sarah ki budhape me basharat hui; unki nasal se Bani Israel ke anbiya paida hue."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 901, prophetId = 9,
                        title = "Budhape me Ishaq (A.S.) ki Basharat",
                        summary = "Farishton ne Ibrahim aur Sarah ko nek-o-alim bete ki khushkhabri di.",
                        detailedNarrative = "Farishton ne Sarah (A.S.) ko Ishaq aur unke baad Ya'qub (A.S.) ki khushkhabri sunai to wo hairan hui. Farishton ne kaha: 'Kya tum Allah ke hukm par ta'ajjub karti ho?'.",
                        quranicReference = "Surah Hud (11:69-73), Surah As-Saffat (37:112-113)",
                        moralLesson = "Allah har cheez par qadir hai, mayusi momin ka shiaar nahi.",
                        orderIndex = 1
                    )
                )
            ),

            // 10. Hazrat Ya'qub (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 10,
                    orderIndex = 10,
                    nameArabic = "يعقوب عليه السلام",
                    nameRoman = "Hazrat Ya'qub (A.S.)",
                    title = "Israel (Servant of Allah)",
                    ageYears = "147 Saal",
                    fatherName = "Hazrat Ishaq (A.S.)",
                    motherName = "Hazrat Rifqah",
                    siblings = "Isu (Esau - Judwa Bhai)",
                    children = "Hazrat Yusuf (A.S.), Binyamin, Yahuda, Rubil, Sham'oon, Levi, Dan, Naftali, Gad, Asher, Isakar, Zabulon",
                    wives = "Liyya (Leah), Rahil (Rachel), Bilhah, Zilfah",
                    eraLocation = "Palestine wa Misr (Egypt)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hazrat Yusuf ke firaq me azeem 'Sabr-e-Jameel' ikhtiyar kiya, ro ro kar beenai gayi aur phir wapas aayi."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1001, prophetId = 10,
                        title = "Sabr-e-Jameel aur Gam ka Izhar Sirf Allah Se",
                        summary = "Bete Yusuf ke firaq me farmaya: 'Innamaa ashkoo bassee wa huzneee ilal-laah'.",
                        detailedNarrative = "Bhaiyon ne khoon-alood qamees laakar jhoota qissa sunaya to Ya'qub (A.S.) ne Sabr-e-Jameel kiya. Salon baad jab Yusuf (A.S.) ki qamees ankhon par lagai gayi to beenai laut aayi.",
                        quranicReference = "Surah Yusuf (12:18, 12:86, 12:96)",
                        moralLesson = "Dukh me sirf Allah ke samne daastan bayan karna aur mayus na hona shaan-e-nubuwwat hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 11. Hazrat Yusuf (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 11,
                    orderIndex = 11,
                    nameArabic = "يوسف عليه السلام",
                    nameRoman = "Hazrat Yusuf (A.S.)",
                    title = "As-Siddiq (The Truthful) / Ahsan al-Qasas",
                    ageYears = "110 Saal",
                    fatherName = "Hazrat Ya'qub (A.S.)",
                    motherName = "Hazrat Rahil (Rachel)",
                    siblings = "Binyamin (Real), aur 10 sautele bhai",
                    children = "Afraheem (Ephraim), Manassa (Manasseh)",
                    wives = "Hazrat Zulaikha / Asenath bint Poti-Phera",
                    eraLocation = "Canaan (Palestine) to Misr (Egypt)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Kuen se qaid-khane tak, phir Misr ke azeem Aziz bane; husn, pak-damani aur muafi ki misaal."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1101, prophetId = 11,
                        title = "Kuen me Phenka Jana aur Pak-damani ka Imtihan",
                        summary = "Hasad ki aag me bhaiyon ne kuen me daala, Misr me ghulam bane magar har aazmaish me pak-daman rahe.",
                        detailedNarrative = "Bhaiyon ne kuen me daal diya. Qafla Misr le gaya jahan Aziz-e-Misr ne khareeda. Zulaikha ki aazmaish me farmaya: 'Ma'azallah!' aur gunah par qaid-khane ko tarjeeh di.",
                        quranicReference = "Surah Yusuf (12:15-33)",
                        moralLesson = "Taqwa aur iffat insan ko har aaloodgi se bacha kar buland martabe tak pahunchati hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 1102, prophetId = 11,
                        title = "Misr ki Hukumat aur Bhaiyon ko Azeem Muafi",
                        summary = "Khazana-e-Misr sambhala aur bhaiyon se farmaya: 'Laa tasreeba 'alaikumul yawm'.",
                        detailedNarrative = "Badshah ke khwab ki tabeer se Misr ko qahat se bachaya. Jab zalim bhai samne aazij hue to inteqam lene ke bajaye sabko muaf kar diya aur walidain ko takht par bithaya.",
                        quranicReference = "Surah Yusuf (12:55-57, 12:92-100)",
                        moralLesson = "Taqat hone ke bawajood muaf kar dena azeem akhlaq ki inteha hai.",
                        orderIndex = 2
                    )
                )
            ),

            // 12. Hazrat Ayyub (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 12,
                    orderIndex = 12,
                    nameArabic = "أيوب عليه السلام",
                    nameRoman = "Hazrat Ayyub (A.S.)",
                    title = "Sayyid as-Sabireen (Master of Patient Ones)",
                    ageYears = "70–93 Saal",
                    fatherName = "Amos (bin Tarekh bin Isu bin Ishaq)",
                    motherName = "Bint Lut (A.S.)",
                    siblings = "Rishtedaar wa ahl-e-qabila",
                    children = "Beshumar aulad jo aazmaish ke baad dugni ata hui",
                    wives = "Hazrat Rahma (bint Afraheem bin Yusuf A.S.)",
                    eraLocation = "Hauran (Syria / Jordan)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Daulat, aulad aur sehat sab chheen gaye, 18 saal shadeed beemari me sabr kiya aur dua qabool hui."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1201, prophetId = 12,
                        title = "Shadeed Bemari me Sabr aur Shifa ka Chashma",
                        summary = "Dua mangi: 'Rabbi innee massaniyad-durru wa Anta arhamur-raahimeen', Allah ne qadam marwa kar thanda chashma nikaala.",
                        detailedNarrative = "Ayyub (A.S.) ne beemari me bhi zikr-e-ilahi na chhoda. Biwi Rahma ne wafa ki misaal qayam ki. Allah ne farmaya: apna paon zameen par maaro, ye thanda paani nahane aur peene ke liye hai, jisse tamam amraaz door ho gaye.",
                        quranicReference = "Surah Al-Anbiya (21:83-84), Surah Sad (38:41-44)",
                        moralLesson = "Bimari aur tangdasti me shikwa karne ke bajaye sabr aur adab ke sath dua mangni chahiye.",
                        orderIndex = 1
                    )
                )
            ),

            // 13. Hazrat Shu'ayb (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 13,
                    orderIndex = 13,
                    nameArabic = "شعيب عليه السلام",
                    nameRoman = "Hazrat Shu'ayb (A.S.)",
                    title = "Khateeb al-Anbiya (Orator of the Prophets)",
                    ageYears = "Taqreeban 242 Saal",
                    fatherName = "Mikaeel (bin Yashjur bin Madyan bin Ibrahim)",
                    motherName = "Bint Lut (A.S.)",
                    siblings = "Ahl-e-Madyan",
                    children = "Safura (Zipporah - Zauja Musa A.S.), Sharfa",
                    wives = "Maymuna",
                    eraLocation = "Madyan wa Ashab al-Aykah (Jordan / Saudi border)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Tijarat me nap-tol ki chori aur raah-zani rokne ki taleem di; fasih-o-baleeg taqreer farmate the."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1301, prophetId = 13,
                        title = "Nap-Tol ki Chori aur Sayah Badal ka Azaab",
                        summary = "Madyan ke tajiron ko imandari ka hukm diya, inkar par 'Azaab Yawm az-Zullah' ne ghair liya.",
                        detailedNarrative = "Hazrat Shu'ayb ne farmaya: nap aur tol pura karo aur zameen me fasaad na machao. Kuffar ne mazaq udaya. Phir aag barsane wale badal aur zalzale ne unhe unke mehlon me tabah kar diya.",
                        quranicReference = "Surah Hud (11:84-95), Surah Ash-Shu'ara (26:176-190)",
                        moralLesson = "Ma'ashi bad-diyanati aur tijarat me dhoka puri qoum ko tabahi ke dahaney par la khada karta hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 14. Hazrat Harun (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 14,
                    orderIndex = 14,
                    nameArabic = "هارون عليه السلام",
                    nameRoman = "Hazrat Harun (A.S.)",
                    title = "Wazeer-e-Musa wa Fasih al-Lisan",
                    ageYears = "122–123 Saal",
                    fatherName = "Imran (Amram bin Kohath bin Levi)",
                    motherName = "Yokheved (Jochebed)",
                    siblings = "Hazrat Musa (A.S.), Hazrat Maryam (Miriam - Sister)",
                    children = "Shubbar, Shubayr, Eleazar, Ithamar",
                    wives = "Elisheba (Alisheba bint Aminadab)",
                    eraLocation = "Misr wa Sehra-e-Sina (Sinai Peninsula)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Hazrat Musa ke muawin aur wazeer, fasih bayaan aur meharban shafiq nabi."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1401, prophetId = 14,
                        title = "Firaun ke Darbar me Musa (A.S.) ki Rafaqaat",
                        summary = "Allah ne Musa (A.S.) ki dua par Harun (A.S.) ko nabi aur bazu banakar bheja.",
                        detailedNarrative = "Musa (A.S.) ne dua ki: 'Waj'al lee wazeeram min ahlee Haroona akhee'. Harun (A.S.) ne Firaun ke aage sachchai ki dalail pesh karne me Musa (A.S.) ka kamil sath diya.",
                        quranicReference = "Surah Ta-Ha (20:29-36), Surah Al-Qasas (28:34-35)",
                        moralLesson = "Nek maqsad ke liye sachche sathi aur bhai ka sath Allah ki azeem naimat hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 15. Hazrat Musa (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 15,
                    orderIndex = 15,
                    nameArabic = "موسى عليه السلام",
                    nameRoman = "Hazrat Musa (A.S.)",
                    title = "Kalimullah (The One who Spoke to Allah)",
                    ageYears = "120 Saal",
                    fatherName = "Imran (Amram bin Kohath bin Levi)",
                    motherName = "Yokheved (Yukabad)",
                    siblings = "Hazrat Harun (A.S.), Miriam (Badi Behan)",
                    children = "Gershom, Eliezer",
                    wives = "Hazrat Safura (Zipporah bint Shu'ayb)",
                    eraLocation = "Misr (Egypt), Madyan, Koh-e-Toor, Sehra-e-Teeh",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Sandook me Dariya-e-Neel me bahaye gaye, Firaun ke mahal me pale, Asa aur Yadd-e-Bayza ka mojiza, Taurat ata hui."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1501, prophetId = 15,
                        title = "Koh-e-Toor par Kalam-e-Ilahi aur Firaun ka Muqabla",
                        summary = "Aag dekh kar Toor par gaye, Allah se kalam kiya aur Firaun ke jadugaron ko shikast di.",
                        detailedNarrative = "Allah ne pukaara: 'Innee Anallaahu Rabbul-'Aalameen'. Asa azdaha ban gaya aur haath chamakne laga. Darbar-e-Firaun me jab jadugaron ne rasiyan phenki to Asa sabko nigal gaya aur jadugar sajde me gir pade.",
                        quranicReference = "Surah Ta-Ha (20:9-70), Surah Al-Qasas (28:29-38)",
                        moralLesson = "Haq ke aage baatil ke tamam fareb aur hile nest-o-nabood ho jate hain.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 1502, prophetId = 15,
                        title = "Behr-e-Ahmar (Red Sea) ka Phatna aur Firaun ka Ghaq hona",
                        summary = "Asa marne par samandar me 12 khushk raaste bane, Bani Israel bach gaye aur Firaun lashkar samet doob gaya.",
                        detailedNarrative = "Samandar aage tha aur peechhe zalim lashkar. Musa (A.S.) ne farmaya: 'Kalla! Inna ma'iya Rabbee sayahdeen'. Samandar phat gaya aur unche pahadon jaisi maujein ruk gayin. Firaun doobte waqt imaan laya magar der ho chuki thi.",
                        quranicReference = "Surah Ash-Shu'ara (26:61-68), Surah Yunus (10:90-92)",
                        moralLesson = "Zulm chahe kitna hi mutakabbir kyu na ho, uska anjaam zillat-amez barbadi hai.",
                        orderIndex = 2
                    )
                )
            ),

            // 16. Hazrat Talut (A.S./R.A.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 16,
                    orderIndex = 16,
                    nameArabic = "طالوت عليه السلام / رحمه الله",
                    nameRoman = "Hazrat Talut (Saul)",
                    title = "Malik-e-Bani Israel / Commander chosen by Allah",
                    ageYears = "Taqreeban 70 Saal",
                    fatherName = "Kish (Qais bin Abiel)",
                    motherName = "Umm Talut",
                    siblings = "Ahl-e-Bani Benjamin",
                    children = "Jonathan, Michal, Merab",
                    wives = "Ahinoam",
                    eraLocation = "Palestine / Jerusalem",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Surah Baqarah me zikr: Ilm aur jismani taqat me bartari ki bina par badshah banaye gaye, Taboot-e-Sakina laya gaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1601, prophetId = 16,
                        title = "Taboot-e-Sakina aur Jalut ke Khilaf Muqabla",
                        summary = "Allah ne Talut ko hukumat di, neher ke paani se aazmaish hui aur thode momino ne Jalut ke lashkar ko haraya.",
                        detailedNarrative = "Nabi ne farmaya Allah ne Talut ko ilm aur jism me wus'at bakhshi hai. Taboot-e-Sakina farishte utha kar laye. Neher par aazmaish ke baad mardana-war muqabla hua jisme no-jawan Dawud (A.S.) ne Jalut ko qatal kiya.",
                        quranicReference = "Surah Al-Baqarah (2:246-251)",
                        moralLesson = "Kitni hi choti jamaatain Allah ke hukm se badi jamaaton par ghalba pa leti hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 17. Hazrat Luqman Al-Hakeem (A.S./R.A.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 17,
                    orderIndex = 17,
                    nameArabic = "لقمان الحكيم عليه السلام / رحمه الله",
                    nameRoman = "Hazrat Luqman Al-Hakeem",
                    title = "Sahib-e-Hikmat / The Wise",
                    ageYears = "Taqreeban 100+ Saal",
                    fatherName = "Ba'oora (bin Nahor)",
                    motherName = "Umm Luqman",
                    siblings = "Ahl-e-Habsha wa Sudan",
                    children = "Tharan (Anam / Beta jise nasihat farmai)",
                    wives = "Salma",
                    eraLocation = "Sudan / Egypt / Palestine",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Quran me Surah Luqman unke naam par hai; bete ko tauheed, namaz, tawazu aur achhe akhlaq ki sunheri nasihaten keen."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1701, prophetId = 17,
                        title = "Bete ko Hikmat-Amoz Nasihaten",
                        summary = "Shirk se bachne, namaz qayam karne, waldain ki khidmat aur aahista bolne ki taaleem di.",
                        detailedNarrative = "Luqman ne farmaya: Ay mere pyare bete! Shirk mat karna, shirk sabse bada zulm hai. Namaz qayam kar, bhalai ka hukm de, burai se rok aur jo museebat aaye uspe sabr kar. Logon se rukh na phero aur zameen par itra kar mat chal.",
                        quranicReference = "Surah Luqman (31:12-19)",
                        moralLesson = "Haqeeqee hikmat Allah ka shukr ada karne aur adab-o-akhlaq ikhtiyar karne me hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 18. Hazrat Dawud (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 18,
                    orderIndex = 18,
                    nameArabic = "داود عليه السلام",
                    nameRoman = "Hazrat Dawud (A.S.)",
                    title = "Khalifatullah / Sahib-e-Zabur",
                    ageYears = "100 Saal",
                    fatherName = "Yishai (Jesse bin Obed bin Boaz)",
                    motherName = "Nitzevet",
                    siblings = "7 Bada Bhai (Eliab, Abinadab, Shimea, etc.)",
                    children = "Hazrat Sulaiman (A.S.), Absalom, Amnon, Adonijah",
                    wives = "Bathsheba, Abigail, Ahinoam, Maacah, Haggith",
                    eraLocation = "Jerusalem / Palestine",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Jalut ko gophan se mara, loha mom ki tarah pighal jata tha, Zabur padhte to parinde aur pahad tasbeeh karte the."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1801, prophetId = 18,
                        title = "Jalut ka Qatal aur Zabur ki Tilawat",
                        summary = "Jalut zalim sardaar ko qatal kiya, Allah ne hukumat aur hikmat ata ki.",
                        detailedNarrative = "Hazrat Dawud ne Jalut ko mara aur fatah bakhshi. Allah ne unke hath me lohe ko narm kar diya jisse zirah banate the. Jab khush-ilhani se Zabur padhte to parinde hawa me thehar jate aur pahad sath tasbeeh karte.",
                        quranicReference = "Surah Al-Baqarah (2:251), Surah Saba (34:10-11), Surah Sad (38:17-26)",
                        moralLesson = "Adl-o-insaaf aur kasrat-e-tasbeeh hukumat ke shandar sutoon hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 19. Hazrat Sulaiman (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 19,
                    orderIndex = 19,
                    nameArabic = "سليمان عليه السلام",
                    nameRoman = "Hazrat Sulaiman (A.S.)",
                    title = "Nabi wa Badshah-e-Aalam",
                    ageYears = "52–53 Saal",
                    fatherName = "Hazrat Dawud (A.S.)",
                    motherName = "Hazrat Bathsheba",
                    siblings = "Nathan, Shammua, Shobab",
                    children = "Rehoboam (Rehab'am)",
                    wives = "Hazrat Bilqis (Malika Saba), Naamah",
                    eraLocation = "Jerusalem (Palestine) wa Yemen",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hawa, Jinnat, Parinde sab taabe the, Cheenti ki aawaz suni, Baitul Maqdis ki azeem tameer farmai."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1901, prophetId = 19,
                        title = "Baitul Maqdis ki Tameer aur Malika Saba (Bilqis)",
                        summary = "Hudhud ke zariye khat bheja, Bilqis ka takht palak jhapakte hazir hua aur usne Islam qabool kiya.",
                        detailedNarrative = "Sulaiman (A.S.) ne jinnat se Baitul Maqdis tameer karwaya. Hudhud ne Saba ki khabar di to unhone dawat-e-Islam ka khat likha: 'Innahoo min Sulaimaana wa innahoo Bismillaahir-Rahmaanir-Raheem'. Bilqis aayi aur deen-e-tauheed apnaya.",
                        quranicReference = "Surah An-Naml (27:15-44), Surah Saba (34:12-14)",
                        moralLesson = "Taqat, shaukat aur daulat ka behtareen istemal sirf Allah ke deen ki sar-bulandi hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 20. Hazrat Yunus (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 20,
                    orderIndex = 20,
                    nameArabic = "يونس عليه السلام",
                    nameRoman = "Hazrat Yunus (A.S.)",
                    title = "Dhun-Nun (Companion of the Fish)",
                    ageYears = "Taqreeban 120 Saal",
                    fatherName = "Matta (Amittai)",
                    motherName = "Umm Yunus",
                    siblings = "Ahl-e-Nineveh",
                    children = "Aal-o-Awlad",
                    wives = "Maryam / Safiyya",
                    eraLocation = "Nineveh (Mosul, Iraq)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Machhli ke pet me 3 tareeqiyon me dua mangi: 'Laa ilaaha illaa Anta Subhaanaka innee kuntu minaz-zaalimeen'."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2001, prophetId = 20,
                        title = "Machhli ke Pet me Tasbeeh aur Nijat",
                        summary = "Samandar me machhli ne nigal liya, andheron me istighfar kiya aur Allah ne khushki par zinda nikal diya.",
                        detailedNarrative = "Hazrat Yunus (A.S.) kashti se samandar me daale gaye jahan azeem machhli ne nigal liya. Unhone shikwe ke bajaye tauba ki: 'Laa ilaaha illaa Anta Subhaanaka innee kuntu minaz-zaalimeen'. Allah ne machhli ko hukm diya aur unhe sahil par salamat daal diya jahan kaddoo ki bel saaya bani.",
                        quranicReference = "Surah Al-Anbiya (21:87-88), Surah As-Saffat (37:139-148)",
                        moralLesson = "Momin jab bhi kisi aazmaish me Ayat-e-Kareema padhta hai to Allah use ranj se najaat deta hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 21. Hazrat Al-Yasa' (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 21,
                    orderIndex = 21,
                    nameArabic = "اليسع عليه السلام",
                    nameRoman = "Hazrat Al-Yasa' (Elisha)",
                    title = "Khalifa-e-Ilyas / Sabir Nabi",
                    ageYears = "Taqreeban 90 Saal",
                    fatherName = "Ukhtoob (Shaphat)",
                    motherName = "Umm Al-Yasa'",
                    siblings = "Bani Israel ke saleheen",
                    children = "Nek nasal",
                    wives = "Qatuma",
                    eraLocation = "Baalbek (Lebanon) wa Palestine",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Hazrat Ilyas ke janasheen; murdon ko zinda karne aur beemarion se shifa dene ke mojizat mile."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2101, prophetId = 21,
                        title = "Dawat-e-Haq aur Mo'jizat-e-Shifa",
                        summary = "Bani Israel me shari'at-e-Musa ko zinda rakha aur azeem akhlaq ke sath rehnumai farmai.",
                        detailedNarrative = "Quran-e-Pak me Hazrat Ismail, Al-Yasa, Yunus aur Lut (A.S.) ke sath unka zikr karte hue farmaya gaya: 'Wa kullan faddalnaa 'alal-'aalameen' (Humne sabko jahan walon par fazilat bakhshi).",
                        quranicReference = "Surah Al-An'am (6:86), Surah Sad (38:48)",
                        moralLesson = "Neki aur sachchai par qayam rehna sharaf-e-insaniyat ki daleel hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 22. Hazrat Ilyas (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 22,
                    orderIndex = 22,
                    nameArabic = "إلياس عليه السلام",
                    nameRoman = "Hazrat Ilyas (Elijah)",
                    title = "Nabi-e-Baalbek / Mujahid-e-Tauheed",
                    ageYears = "Taqreeban 80+ Saal",
                    fatherName = "Yasin (bin Phinehas bin Eleazar bin Harun)",
                    motherName = "Umm Ilyas",
                    siblings = "Bani Harun",
                    children = "Aal-e-Haroon",
                    wives = "Salimah",
                    eraLocation = "Baalbek (Syria / Lebanon)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "'Ba'al' naam ke but ki parastish ke khilaf lade aur sachchi tauheed ka parcham buland kiya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2201, prophetId = 22,
                        title = "But 'Ba'al' ki Tardeed aur Aasmani Aag ka Mo'jiza",
                        summary = "Badshah aur qoum ko but-parasti se roka: 'Atad'oona Ba'lanw-wa tazaruna ahsanal-khaaliqeen'.",
                        detailedNarrative = "Hazrat Ilyas ne qoum ko samjhaya ki sabse behtareen paida karne wale Allah ko chhod kar but ko kyu pukarte ho? Qoum ne mukhalifat ki to 3 saal qahat pada, phir unki dua se azeem baarish hui.",
                        quranicReference = "Surah As-Saffat (37:123-132)",
                        moralLesson = "Ghairullah ki ibadat zillat hai aur Allah par yaqeen izzat ka rasta hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 23. Hazrat Dhul-Kifl (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 23,
                    orderIndex = 23,
                    nameArabic = "ذو الكفل عليه السلام",
                    nameRoman = "Hazrat Dhul-Kifl (A.S.)",
                    title = "Kafil al-Ahad / The Pledging Prophet",
                    ageYears = "Taqreeban 75–95 Saal",
                    fatherName = "Hazrat Ayyub (A.S. - Bashar bin Ayyub)",
                    motherName = "Hazrat Rahma",
                    siblings = "Baradaran-e-Ayyub",
                    children = "Nek ahl-e-khana",
                    wives = "Asiya",
                    eraLocation = "Damascus (Syria) wa Kifel (Iraq)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Din me roza, raat me ibadat aur ghusse par qaboo rakhne ka ahad pura kiya; Quran me Sabir farmaya gaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2301, prophetId = 23,
                        title = "Ahad ki Pasdari aur Shaitan par Fatah",
                        summary = "Iblees ne kayi roop dhar kar unka sabr aazmana chaha magar unhone kamil istiqamat dikhayi.",
                        detailedNarrative = "Hazrat Al-Yasa' ne jab janasheen talash kiya to Dhul-Kifl ne shart manzoor ki: din me roza, raat me shab-bedari aur kabhi ghussa na karna. Shaitan ne dopahar ki neend me tang kiya magar unhone sabr ka daman na chhoda.",
                        quranicReference = "Surah Al-Anbiya (21:85-86), Surah Sad (38:48)",
                        moralLesson = "Waade ki wafa aur jazbaat par qaboo momin ka zewar hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 24. Hazrat Dhul-Qarnayn (A.S./R.A.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 24,
                    orderIndex = 24,
                    nameArabic = "ذو القرنين عليه السلام / رحمه الله",
                    nameRoman = "Hazrat Dhul-Qarnayn",
                    title = "Badshah-e-Aadil / Conqueror of East & West",
                    ageYears = "Taqreeban 80 Saal",
                    fatherName = "Saleh / Marzaban",
                    motherName = "Malika Samiramis",
                    siblings = "Ahl-e-Khandaan",
                    children = "Aal-o-Awlad",
                    wives = "Roshanak (Roxana)",
                    eraLocation = "Mashriq se Maghrib tak aalamgeer daura",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Surah Al-Kahf me azeem zikr: Mashriq aur Maghrib ka safar kiya, Yajooj Majooj ke aage lohe aur taambe ki deewar banai."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2401, prophetId = 24,
                        title = "Sadd-e-Dhul-Qarnayn (Yajooj Majooj ki Deewar)",
                        summary = "Do pahadon ke darmiyan pighle taambe aur lohe ki azeem deewar khadi karke fasad ko roka.",
                        detailedNarrative = "Logon ne darkhwast ki ki Yajooj Majooj zameen me fasad machate hain. Dhul-Qarnayn ne maali ujrat lene se inkar kiya aur farmaya: 'Maa makkanni feehi Rabbee khair'. Lohe ke takhte jode, aag dahkai aur pighla hua taamba daal kar na-qabil-e-uboor deewar bana di.",
                        quranicReference = "Surah Al-Kahf (18:83-98)",
                        moralLesson = "Hukumat ka asal maqsad mazloomon ki hifazat aur adl qayam karna hai baghair lalach ke.",
                        orderIndex = 1
                    )
                )
            ),

            // 25. Hazrat Uzair (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 25,
                    orderIndex = 25,
                    nameArabic = "عزير عليه السلام",
                    nameRoman = "Hazrat Uzair (Ezra)",
                    title = "Muhiy al-Kitab / The Reviver of Torah",
                    ageYears = "Taqreeban 150 Saal (100 saal maut ki neend)",
                    fatherName = "Jarkha (Seraiah)",
                    motherName = "Umm Uzair",
                    siblings = "Baradaran",
                    children = "Aal-e-Uzair",
                    wives = "Asma",
                    eraLocation = "Baitul Maqdis (Jerusalem) wa Babylon",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "100 saal tak maut ki neend sulaye gaye, phir zinda hue to khana aur gadha waise hi the; Taurat ko hifz dubaara likhwaaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2501, prophetId = 25,
                        title = "100 Saal Baad Dubaara Zindagi ka Mo'jiza",
                        summary = "Ujdi hui basti dekh kar pucha 'Ise Allah kaise zinda karega?', Allah ne 100 saal maut dekar qudrat dikhayi.",
                        detailedNarrative = "Baitul Maqdis ki barbadi par guzar hue. Allah ne 100 saal ke liye wafaat di aur phir zinda kiya. Gadhe ki haddiyan unke samne joodi gayin aur gosht chadha. Unhone farmaya: 'A'lamu annal-laaha 'alaa kulli shai'in Qadeer'.",
                        quranicReference = "Surah Al-Baqarah (2:259)",
                        moralLesson = "Qayamat ke din murdon ka uthaya jana bilkul sach aur haqeeqat hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 26. Hazrat Zakariyya (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 26,
                    orderIndex = 26,
                    nameArabic = "زكريا عليه السلام",
                    nameRoman = "Hazrat Zakariyya (A.S.)",
                    title = "Kafil-e-Maryam / Shaheed Nabi",
                    ageYears = "92–100+ Saal",
                    fatherName = "Dan (bin Muslim bin Saduk)",
                    motherName = "Umm Zakariyya",
                    siblings = "Bani Haroon ke ulama",
                    children = "Hazrat Yahya (A.S. - John the Baptist)",
                    wives = "Hazrat Ishba' (Elizabeth / Sister of Hannah, Aunt of Maryam)",
                    eraLocation = "Baitul Maqdis (Jerusalem)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hazrat Maryam ki kaffalat farmai, budhape aur biwi ke baanjh hone ke bawajood aaji se dua ki aur Yahya (A.S.) ki basharat hui."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2601, prophetId = 26,
                        title = "Mihrab me Dua aur Yahya (A.S.) ki Basharat",
                        summary = "Mihrab me Maryam ke paas be-mausami phal dekhe to dua mangi: 'Rabbi hab lee mil ladunka zurriyyatan tayyibah'.",
                        detailedNarrative = "Hazrat Zakariyya ne farmaya: 'Mere sar ke baal safed ho gaye aur haddiyan kamzor ho gayin, magar main tujhse mang kar kabhi mehroom nahi raha'. Farishton ne namaz ki halat me aakar Yahya (A.S.) ki khushkhabri di.",
                        quranicReference = "Surah Aal-e-Imran (3:37-41), Surah Maryam (19:2-11)",
                        moralLesson = "Allah se maangne me umar aur zahiri asbaab rukawat nahi bante.",
                        orderIndex = 1
                    )
                )
            ),

            // 27. Hazrat Yahya (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 27,
                    orderIndex = 27,
                    nameArabic = "يحيى عليه السلام",
                    nameRoman = "Hazrat Yahya (John the Baptist)",
                    title = "Hasoor wa Sayyid / Nabi-e-Muzakki",
                    ageYears = "Taqreeban 30–34 Saal",
                    fatherName = "Hazrat Zakariyya (A.S.)",
                    motherName = "Hazrat Ishba' (Elizabeth)",
                    siblings = "None (Eklauti dua se paida hue)",
                    children = "None (Ghair-shadi-shuda)",
                    wives = "Ghair-shadi-shuda (Batool / Hasoor jaisa Quran me hai)",
                    eraLocation = "Jerusalem wa Dariya-e-Urdun (Jordan River)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Bachpan me hi nubuwwat aur hikmat ata hui; nihayat narm-dil, rona-dhona aur parhezgari unka shiaar tha."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2701, prophetId = 27,
                        title = "Bachpan me Hikmat aur Sharaf-e-Taqwa",
                        summary = "Allah ne farmaya: 'Yaa Yahyaa khuzil-Kitaaba bi-quwwah', aur bachpan me hi hikmat aur narm-dili ata farmai.",
                        detailedNarrative = "Hazrat Yahya gunahon se paak the aur waldain ke farmabardar the. Zalim badshah Heroad ki ghair-shar'i shadi ke khilaf haq baat kahi aur shaheed hue.",
                        quranicReference = "Surah Maryam (19:12-15)",
                        moralLesson = "Haq baat kehne me kisi dunya-dar badshah ka khauf nahi hona chahiye.",
                        orderIndex = 1
                    )
                )
            ),

            // 28. Hazrat Jirjis / Jirjeel (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 28,
                    orderIndex = 28,
                    nameArabic = "جرجيس / جرجيل عليه السلام",
                    nameRoman = "Hazrat Jirjeel (Jirjis / St. George)",
                    title = "Shahid-e-Tauheed / Mujahid-e-Sabr",
                    ageYears = "Taqreeban 70 Saal",
                    fatherName = "Anas (Qana)",
                    motherName = "Umm Jirjis",
                    siblings = "Ahl-e-Palestine",
                    children = "Aal-e-Saleh",
                    wives = "Jamila",
                    eraLocation = "Mosul wa Sham (Palestine & Iraq)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Tareekh-e-Tabari aur qadeem islami kitabon me zikr: Zalim but-parast badshah Dadianus ke aage kalima-e-haq buland kiya aur azeem azaab sahe."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2801, prophetId = 28,
                        title = "Dadianus Badshah ke Samne Dawat-e-Tauheed",
                        summary = "Zalim badshah ne aara se cheera aur aag me daala, magar har baar Allah ne zinda karke mojiza dikhaya.",
                        detailedNarrative = "Hazrat Jirjis (A.S.) ne hazaron logon ke samne but-parasti ko rad kiya. Zalim badshah ne tarah tarah ki sazaayein di magar unka imaan mutazalzal na hua. Aakhirkar unki dua se zalim badshah par azaab aaya.",
                        quranicReference = "Tareekh al-Rusul wal-Mulook (Tabari), Qisas al-Anbiya Ibn Kathir",
                        moralLesson = "Imaan me jo pukhtagi hoti hai wo jism ke zakhmo se dabai nahi ja sakti.",
                        orderIndex = 1
                    )
                )
            ),

            // 29. Hazrat Isa (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 29,
                    orderIndex = 29,
                    nameArabic = "عيسى عليه السلام",
                    nameRoman = "Hazrat Isa (Jesus)",
                    title = "Ruhullah wa Kalimatullah / Masih",
                    ageYears = "33 Saal (Zameen par), Aasman par zinda uthaye gaye",
                    fatherName = "Created without Father by Divine Command ('Kun')",
                    motherName = "Hazrat Maryam (A.S. - Sayyidatun Nisa)",
                    siblings = "None (Miraculous Virgin Birth)",
                    children = "None (Ghair-shadi-shuda)",
                    wives = "Ghair-shadi-shuda (Qiyamat se pehle nuzul ke baad nikah hoga)",
                    eraLocation = "Nazareth, Bethlehem, Jerusalem (Palestine)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Gahware me bole, Maadarzad andhe aur kodi ko achha kiya, murde zinda kiye, Aasman par uthaye gaye."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2901, prophetId = 29,
                        title = "Palaang me Bolna aur Mo'jizat-e-Injeel",
                        summary = "Maa ki pak-damani par no-maulood bachhe ne gawahi di: 'Innee 'Abdullaah ataaniyal-Kitaaba wa ja'alanee Nabiyyaa'.",
                        detailedNarrative = "Hazrat Isa (A.S.) ne gahware me kalam karke logon ko hairan kar diya. Mitti se parinda banakar phoonk maarte to zinda ho jata, beemaron ko shifa dete aur Allah ke hukm se murdon ko 'Qum bi-idhnillah' keh kar uthate the.",
                        quranicReference = "Surah Maryam (19:29-33), Surah Aal-e-Imran (3:49-51)",
                        moralLesson = "Allah ka irada hi asbaab ka khaliq hai, qudrat-e-ilahi me koi cheez namumkin nahi.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 2902, prophetId = 29,
                        title = "Aasman par Raf'a (Uthaya Jana) aur Nuzul ka Ahad",
                        summary = "Dushman suli par chadhana chahte the magar Allah ne unhe zinda aasman par utha liya.",
                        detailedNarrative = "Yahood ne qatal ka mansuba banaya magar shubha me daal diya gaya. Allah ne farmaya: 'Wa maa qataloohu wa maa salaboohu wa laakin shubbiha lahum'. Allah ne unhe apni taraf utha liya aur aakhiri zamane me unka nuzul hoga.",
                        quranicReference = "Surah An-Nisa (4:157-158)",
                        moralLesson = "Dushmanon ki tadbeer par Allah ki tadbeer ghalib aakar rehti hai.",
                        orderIndex = 2
                    )
                )
            ),

            // 30. Hazrat Sheeth (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 30,
                    orderIndex = 30,
                    nameArabic = "شيث عليه السلام",
                    nameRoman = "Hazrat Sheeth (Seth)",
                    title = "Hibatullah (Gift of Allah to Adam)",
                    ageYears = "912 Saal",
                    fatherName = "Hazrat Adam (A.S.)",
                    motherName = "Hazrat Hawwa (A.S.)",
                    siblings = "Habil, Qabil, Iqlima",
                    children = "Anush (Enos), No'ra aur aal-o-awlad",
                    wives = "Hazura (Azura)",
                    eraLocation = "Mecca wa Mount Abu Qubais",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Habil ki shahadat ke baad Allah ne 'Hibatullah' ke taur par ata farmaya; 50 saheefe nazil hue aur shariat qayam ki."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3001, prophetId = 30,
                        title = "Adam (A.S.) ki Wasiyat aur 50 Saheefe",
                        summary = "Adam (A.S.) ne Sheeth ko apna khalifa banaya aur Allah ne un par 50 saheefe nazil farmaye.",
                        detailedNarrative = "Hazrat Sheeth ne Qabil ki aal se door rehne ki takeed ki aur pahadi ilaqe me imandar logon ko jam'a karke namaz, roza aur taharat ki talim di.",
                        quranicReference = "Ibn Kathir (Al-Bidayah wan-Nihayah)",
                        moralLesson = "Buraai se door reh kar saleh logon ke sath rehna deen ki bunyad hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 31. Hazrat Sam bin Nuh (A.S.) - Shem
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 31,
                    orderIndex = 31,
                    nameArabic = "سام بن نوح عليه السلام / رحمه الله",
                    nameRoman = "Hazrat Sam bin Nuh (Shem)",
                    title = "Abul Arab wal-Anbiya (Father of Semites)",
                    ageYears = "600 Saal",
                    fatherName = "Hazrat Nuh (A.S.)",
                    motherName = "Amzura",
                    siblings = "Ham, Yafith, Kanaan",
                    children = "Arphaxad, Lud, Elam, Ashur, Aram",
                    wives = "Sedeqetelebab",
                    eraLocation = "Mesopotamia to Arabian Peninsula",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Kashti me sawar nek bete; unki nasal se Arab, Bani Israel aur azeem anbiya-e-kiram paida hue."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3101, prophetId = 31,
                        title = "Toofan ke Baad Nayi Bastiyon ka Qiyam",
                        summary = "Kashti se utar kar zameen par tauheed aur khidmat-e-khalq ko riwaj diya.",
                        detailedNarrative = "Hazrat Sam apne walid Nuh (A.S.) ke nihayat itaat-guzar the. Unhone Tauheed par qayam rehte hue naye aalam me insani tamaddun ki bunyad daali.",
                        quranicReference = "Tareekh-e-Tabari, Al-Kamil Ibn Atheer",
                        moralLesson = "Nek aulaad walidain ki duaon ka behtareen samar hoti hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 32. Ham bin Nuh
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 32,
                    orderIndex = 32,
                    nameArabic = "حام بن نوح رحمه الله",
                    nameRoman = "Ham bin Nuh",
                    title = "Abul Afriqa wal-Habash (Ancestor of Africans & Copts)",
                    ageYears = "Taqreeban 500 Saal",
                    fatherName = "Hazrat Nuh (A.S.)",
                    motherName = "Amzura",
                    siblings = "Sam, Yafith, Kanaan",
                    children = "Cush, Mizraim, Phut, Canaan",
                    wives = "Na'eltama'uk",
                    eraLocation = "Africa, Nile Valley (Egypt / Sudan)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Kashti me bachne wale beta jinki nasal Africa, Misr aur Habsha ke khittah me aabaad hui."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3201, prophetId = 32,
                        title = "Kashti-e-Nuh se Hijrat aur Wadi-e-Neel",
                        summary = "Toofan ke baad janoob ki taraf hijrat karke Wadi-e-Neel aur African aabaadiyon ki bunyad rakhi.",
                        detailedNarrative = "Ham bin Nuh ne apne ahl-o-ayal ke sath Misr aur Africa ke khitton ko aabaad kiya jahan se qadeem tehzebon ka aaghaz hua.",
                        quranicReference = "Al-Bidayah wan-Nihayah (Ibn Kathir)",
                        moralLesson = "Zameen ko aabaad karna aur Allah ki shariat ke mutabiq chalna insani farz hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 33. Hazrat Yafith bin Nuh (Japheth)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 33,
                    orderIndex = 33,
                    nameArabic = "يافث بن نوح رحمه الله",
                    nameRoman = "Hazrat Yafith bin Nuh (Japheth)",
                    title = "Abul Shamal wal-Mashriq",
                    ageYears = "Taqreeban 500+ Saal",
                    fatherName = "Hazrat Nuh (A.S.)",
                    motherName = "Amzura",
                    siblings = "Sam, Ham, Kanaan",
                    children = "Gomer, Magog, Madai, Javan, Tubal, Meshech, Tiras",
                    wives = "Arisisah",
                    eraLocation = "Central Asia, Caucasus & Anatolia",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Nuh (A.S.) ke teesre momin bete jinki nasal shumal, Turk, Europe aur mashriq me phaili."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3301, prophetId = 33,
                        title = "Shumali Khitton ki Tameer",
                        summary = "Shumal aur Wast-e-Asia ki taraf kooch kiya aur qudrati wasail ko taraqqi di.",
                        detailedNarrative = "Kashti se utarne ke baad Yafith ne shamali wadiyon ko apna maskan banaya aur tauheed ke asoolon par aabaadi qayam ki.",
                        quranicReference = "Tareekh Ibn Khaldun",
                        moralLesson = "Mehnat aur hijrat se dunya me naye darwaze khulte hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 34. Hazrat Hanzalah bin Safwan (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 34,
                    orderIndex = 34,
                    nameArabic = "حنظلة بن صفوان عليه السلام",
                    nameRoman = "Hazrat Hanzalah bin Safwan",
                    title = "Nabi Ashab ar-Rass (Prophet of the People of the Well)",
                    ageYears = "Taqreeban 120 Saal",
                    fatherName = "Safwan (bin Hanzalah)",
                    motherName = "Umm Hanzalah",
                    siblings = "Ahl-e-Yemen",
                    children = "Nek ahl-o-ayal",
                    wives = "Raabiah",
                    eraLocation = "Yemen (Al-Rass / Wadi ar-Rass)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Surah Al-Furqan wa Qaf me Ashab ar-Rass ka zikr: Qoum ko sanobar ke darakht ki parastish se roka, unhone kuen me daala aur azaab aaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3401, prophetId = 34,
                        title = "Ashab ar-Rass ki Tableegh aur Anqa Parinde ka Waqia",
                        summary = "Sanobar ke darakht ki pooja rokne par qoum ne dushmani ki aur azaab se nest-o-nabood hui.",
                        detailedNarrative = "Ashab ar-Rass ek kuen ke gird aabaad the jo ek darakht ki pooja karte the. Hazrat Hanzalah ne tauheed ki dawat di. Qoum ne unhe kuen me gira kar band kar diya, jis par azaab-e-ilahi ne qoum ko gher liya.",
                        quranicReference = "Surah Al-Furqan (25:38), Surah Qaf (50:12)",
                        moralLesson = "Nabi ko azaab pahunchane wali qoumon ka anjaam andhera hi andhera hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 35. Hazrat Khidr (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 35,
                    orderIndex = 35,
                    nameArabic = "الخضر عليه السلام",
                    nameRoman = "Hazrat Khidr (Al-Khadir)",
                    title = "Sahib-e-Ilm-e-Ladunni / The Green Guide",
                    ageYears = "Ilm-e-Ilahi ke mutabiq taweel hayaat",
                    fatherName = "Malkan (bin Qaligh bin Falikh)",
                    motherName = "Al-Aliah",
                    siblings = "Ahl-e-Zamana",
                    children = "Ahl-e-Khana",
                    wives = "Zahra",
                    eraLocation = "Majma' al-Bahrain (Jahan do samandar milte hain)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Surah Al-Kahf me zikr: Hazrat Musa (A.S.) ne unse safar kiya; Kashti me chhed, ladke ka qatal aur deewar ki tameer ke batini hikmatein samjhayin."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3501, prophetId = 35,
                        title = "Hazrat Musa (A.S.) ke Sath Safar-e-Hikmat",
                        summary = "Kashti me surakh, bachhe ka qatal aur girte hue deewar ki tameer ke peechhe chhipi qudrati maslihat bayan ki.",
                        detailedNarrative = "Hazrat Khidr ne farmaya: 'Aap mere sath sabr nahi kar sakenge'. Kashti ko chhed kiya taaki zalim badshah use cheen na sake. Ladke ko qatal kiya kyu ki wo walidain ko kufr me mubtala karta. Deewar ko theek kiya kyu ki uske neeche 2 yateem bachhon ka khazana tha.",
                        quranicReference = "Surah Al-Kahf (18:65-82)",
                        moralLesson = "Zaheri halaat ke peechhe Allah ki azeem hikmat aur rehmat kaari-farma hoti hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 36. Hazrat Yusha bin Nun (A.S.)
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 36,
                    orderIndex = 36,
                    nameArabic = "يوشع بن نون عليه السلام",
                    nameRoman = "Hazrat Yusha bin Nun (Joshua)",
                    title = "Fatih-e-Baitul Maqdis / Khalifa-e-Musa",
                    ageYears = "110 Saal",
                    fatherName = "Nun (bin Ephraim bin Yusuf A.S.)",
                    motherName = "Maryam (Miriam bint Imran - Khala)",
                    siblings = "Bani Ephraim",
                    children = "Nek aal-o-awlad",
                    wives = "Rahab",
                    eraLocation = "Sehra-e-Teeh, Jericho wa Baitul Maqdis",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Hazrat Musa ke khadim-e-khas; Surah Kahf me unka zikr hai; Suraj thehar gaya aur Baitul Maqdis fatah hua."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3601, prophetId = 36,
                        title = "Suraj ka Theharna aur Baitul Maqdis ki Fatah",
                        summary = "Fatah ke waqt ghuroob-e-aftab ke qareeb suraj ruk gaya taaki juma ke din fatah mukammal ho sake.",
                        detailedNarrative = "Hazrat Yusha ne dushmano ke khilaf ladte hue suraj se farmaya: 'Tu bhi mamoor hai aur main bhi'. Suraj thehar gaya jab tak Allah ne Baitul Maqdis ki azeem fatah ata na farmai.",
                        quranicReference = "Sahih Muslim & Ahmad (Hadith Habas-ush-Shams)",
                        moralLesson = "Allah apne sachche bando ke liye kainaat ke qawaneen ko bhi musakhkhar farma deta hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 37. Hazrat Shamweel (A.S.) - Samuel
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 37,
                    orderIndex = 37,
                    nameArabic = "شمويل عليه السلام",
                    nameRoman = "Hazrat Shamweel (Samuel)",
                    title = "Nabi-e-Bani Israel / Musleh-e-Aazam",
                    ageYears = "Taqreeban 80 Saal",
                    fatherName = "Elkanah (bin Jeroham)",
                    motherName = "Hannah (Umm Shamweel)",
                    siblings = "Elihu aur baradaran",
                    children = "Joel, Abijah",
                    wives = "Hannah",
                    eraLocation = "Ramah, Shiloh wa Jerusalem (Palestine)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Maa ki dua se paida hue; unke zamane me Bani Israel ne ek badshah ka mutalba kiya to unhone Talut ko muqarrar farmaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3701, prophetId = 37,
                        title = "Bani Israel ke Liye Badshah ka Intekhab",
                        summary = "Qoum ne kaha: 'Ib'as lanaa malikan nuqaatil fee sabeelillaah', unhone Talut ko badshah muntakhab kiya.",
                        detailedNarrative = "Hazrat Shamweel ne qoum ko aagah kiya ki aisa na ho ki jihaad farz ho aur tum bhaag jao. Unhone Allah ke hukm se Hazrat Talut ki qiyadat me lashkar tayyar kiya.",
                        quranicReference = "Surah Al-Baqarah (2:246-248)",
                        moralLesson = "Farz se farar hona zillat hai aur sadiq qiyadat par aitmad fatah ka rasta hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 38. Hazrat Sha'ya bin Amziya (A.S.) - Isaiah
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 38,
                    orderIndex = 38,
                    nameArabic = "شعياء بن أمصيا عليه السلام",
                    nameRoman = "Hazrat Sha'ya (Isaiah)",
                    title = "Nabi-e-Bani Israel / Mubashshir-e-Muhammad ﷺ",
                    ageYears = "Taqreeban 90 Saal",
                    fatherName = "Amziya (Amoz)",
                    motherName = "Umm Sha'ya",
                    siblings = "Ahl-e-Judah",
                    children = "Shear-jashub, Maher-shalal-hash-baz",
                    wives = "Zaynab",
                    eraLocation = "Jerusalem (Palestine)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Hazrat Hizqeel ke baad aaye; badshah Hezekiah ki rehnumai ki aur aakhiri zamane me Nabi-e-Rehmat ﷺ ki aamad ki basharat di."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3801, prophetId = 38,
                        title = "Sannakharib Lashkar ki Shikast aur Basharat-e-Rasool ﷺ",
                        summary = "Dushman ke lashkar ko ek azeem aafat ne halak kiya aur unhone aane wale aakhiri nabi ke ausaaf bayan kiye.",
                        detailedNarrative = "Hazrat Sha'ya ne Bani Israel ko tauba ki dawat di. Badshah Sanharib ne jab hamla kiya to unki dua se dushman raton raat tabah ho gaya. Darakht ke andar chupne par zalimon ne aara chala kar shaheed kiya.",
                        quranicReference = "Ibn Kathir (Al-Bidayah wan-Nihayah)",
                        moralLesson = "Zulm ke aage sar na jhukana aur aakhiri dam tak tableegh karna shahadat ka rutba deta hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 39. Hazrat Armiya bin Hilqiya (A.S.) - Jeremiah
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 39,
                    orderIndex = 39,
                    nameArabic = "إرميا بن حلقيا عليه السلام",
                    nameRoman = "Hazrat Armiya (Jeremiah)",
                    title = "Nabi-e-Baitul Maqdis / The Weeping Prophet",
                    ageYears = "Taqreeban 70 Saal",
                    fatherName = "Hilqiya (Hilkiah)",
                    motherName = "Umm Armiya",
                    siblings = "Bani Israel ke kuhanah",
                    children = "Aal-e-Saleh",
                    wives = "Maryam",
                    eraLocation = "Jerusalem wa Misr (Egypt)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Bakht-e-Nasr (Nebuchadnezzar) ke aane se pehle Bani Israel ko azaab se daraya; dukh aur rone ke sath qoum ki khair-khwahi ki."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 3901, prophetId = 39,
                        title = "Bakht-e-Nasr ke Hamle se Pehle Inzaar",
                        summary = "Bani Israel ko gunahon par tanbeeh di; unhone qaid me daal diya magar sach sabit hua.",
                        detailedNarrative = "Hazrat Armiya ne farmaya ki agar tauba na ki to Babylon ka zalim badshah Baitul Maqdis ko jala dega. Logon ne unhe jhoota keh kar kuen me qaid kiya. Aakhirkar Bakht-e-Nasr aaya aur shahr ko dhoh diya.",
                        quranicReference = "Tareekh al-Umam wal-Muluk (Tabari)",
                        moralLesson = "Naseehat karne wale ko dushnam dene se anjaam nahi badalta.",
                        orderIndex = 1
                    )
                )
            ),

            // 40. Hazrat Daniyal (A.S.) - Daniel
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 40,
                    orderIndex = 40,
                    nameArabic = "دانيال عليه السلام",
                    nameRoman = "Hazrat Daniyal (Daniel)",
                    title = "Sahib al-Ru'ya (The Interpreter of Visions)",
                    ageYears = "Taqreeban 85 Saal",
                    fatherName = "Yuhanna (bin Davidic line)",
                    motherName = "Umm Daniyal",
                    siblings = "Bani Israel ke qaidee",
                    children = "Nek nasal",
                    wives = "Dinah",
                    eraLocation = "Babylon (Iraq) wa Susa (Persia / Iran)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Sheron ke kuen me dale gaye magar sheron ne unhe chhua tak nahi; Hazrat Umar ke daur me unka jasad salamat mila."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 4001, prophetId = 40,
                        title = "Bhooke Sheron ka Ehtiram aur Hazrat Umar (R.A.) ke Daur me Ziyarat",
                        summary = "Badshah ne bhooke sheron ke kuen me phenka, sheron ne unke qadam choome; hazaron saal baad jism salamat mila.",
                        detailedNarrative = "Babylon ke badshah ne hasad ki wajah se Hazrat Daniyal ko bhooke darindon ke samne daala magar Allah ne sheron ko unka muti' bana diya. Fatah-e-Farus ke waqt Hazrat Umar ke hukm par unhe 13 qabron me chupakar ehtiram se dafnaya gaya.",
                        quranicReference = "Al-Bidayah wan-Nihayah, Sunan al-Bayhaqi",
                        moralLesson = "Allah ke waliyon ki hifazat dunya ke darinde bhi karte hain.",
                        orderIndex = 1
                    )
                )
            ),

            // 41. Hazrat Hizqeel bin Buzi (A.S.) - Ezekiel
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 41,
                    orderIndex = 41,
                    nameArabic = "حزقيل بن بوزي عليه السلام",
                    nameRoman = "Hazrat Hizqeel (Ezekiel)",
                    title = "Ibn al-Ajooz (Son of the Elderly Mother)",
                    ageYears = "Taqreeban 75 Saal",
                    fatherName = "Buzi (Bawri)",
                    motherName = "Ajooz (Nek budhi khatoon)",
                    siblings = "Bani Israel ke ahl-e-ilm",
                    children = "Aal-o-Awlad",
                    wives = "Amatullah",
                    eraLocation = "Chebar River (Babylon / Iraq)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Surah Baqarah ayat 243 me un hazaron logon ka zikr hai jo maut ke darr se basti chhod gaye the aur unki dua se dubaara zinda hue."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 4101, prophetId = 41,
                        title = "Hazaron Murdon ke Dubaara Zinda Hone ka Mo'jiza",
                        summary = "Ta'oon ke darr se bhaag kar marne wale hazaron logon ko Allah ne unki dua se zinda farmaya.",
                        detailedNarrative = "Quran-e-Pak me irshad hai: 'Alam tara ilal-lazeena kharajoo min diyaarihim wa hum uloofun hazaral mawt, fa-qaala lahumul-laahu mootoo summa ahyaahum'. Hazrat Hizqeel ne unki sookhi haddiyon par dua ki aur sab zinda hokar uth khade hue.",
                        quranicReference = "Surah Al-Baqarah (2:243), Tafseer Ibn Kathir",
                        moralLesson = "Taqdeer aur maut se koi nahi bhaag sakta, zindagi sirf Allah ke qabza-e-qudrat me hai.",
                        orderIndex = 1
                    )
                )
            ),

            // 42. Khatam-un-Nabiyyin Hazrat Muhammad Mustafa ﷺ
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 42,
                    orderIndex = 42,
                    nameArabic = "مُحَمَّدٌ رَسُولُ اللَّهِ ﷺ",
                    nameRoman = "Hazrat Muhammad Mustafa ﷺ",
                    title = "Khatam-un-Nabiyyin / Rahmatul-lil-'Aalameen (Seal of the Prophets)",
                    ageYears = "63 Saal (571–632 CE)",
                    fatherName = "Hazrat Abdullah bin Abdul Muttalib (Hashimi)",
                    motherName = "Hazrat Aminah bint Wahb (Zuhriyah)",
                    siblings = "None (Eklauti aulad; Raza'i bhai: Hamza, Abu Sufyan bin Harith, Abdullah)",
                    children = "Hazrat Qasim, Hazrat Abdullah (Tahir/Tayyib), Hazrat Ibrahim, Hazrat Zainab, Hazrat Ruqayyah, Hazrat Umm Kulthum, Sayyidatun Nisa Hazrat Fatimah Az-Zahra (Razi Allahu Anhum)",
                    wives = "Azwaaj-e-Mutahharaat (Ummahat-ul-Mu'mineen): Hazrat Khadijah bint Khuwaylid, Hazrat Sawdah bint Zam'ah, Hazrat Aisha Siddiqa bint Abi Bakr, Hazrat Hafsa bint Umar, Hazrat Zaynab bint Khuzaymah, Hazrat Umm Salama Hind, Hazrat Zaynab bint Jahsh, Hazrat Juwayriyah bint Harith, Hazrat Umm Habiba Ramla, Hazrat Safiyyah bint Huyayy, Hazrat Maymunah bint Harith, Hazrat Maria al-Qibtiyyah (Razi Allahu Anhunna)",
                    eraLocation = "Makkah Al-Mukarramah wa Madinah Al-Munawwarah (Hejaz)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Sayyidul Mursaleen, jinpar Quran Majeed nazil hua, Me'raj par gaye, dunya ko tareeki se noor ki taraf nikala."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 4201, prophetId = 42,
                        title = "Ghar-e-Hira me Pehli Wahi ka Nuzul",
                        summary = "Jibreel (A.S.) ne aakar farmaya: 'Iqra bismi Rabbikal-lazee khalaq', dunya me aakhiri hidayat ka aaghaz hua.",
                        detailedNarrative = "Ghar-e-Hira me ibadat ke dauran Jibreel (A.S.) wahi lekar aaye aur seene se laga kar farmaya 'Padho!'. Nabi-e-Akram ﷺ ne ghabrahat me Hazrat Khadijah se farmaya 'Zammilooni' (Mujhe kambal udha do). Hazrat Khadijah ne farmaya: 'Khuda ki qasam! Allah aapko kabhi ruswa nahi karega, aap sila-rehmi karte hain, sach bolte hain aur ghareebon ka bojh uthate hain'.",
                        quranicReference = "Surah Al-'Alaq (96:1-5), Sahih Bukhari (Hadith 3)",
                        moralLesson = "Ilm, sachchai aur insaniyat ki khidmat hi azeem tareen roohani bulandi ki bunyad hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 4202, prophetId = 42,
                        title = "Safat-e-Isra wa Me'raj-e-Mustafa ﷺ",
                        summary = "Masjid-e-Haram se Masjid-e-Aqsa aur 7 aasmaano se Sidratul Muntaha tak ka roohani azeem safar.",
                        detailedNarrative = "Nabi-e-Kareem ﷺ ko Buraq par Masjid-e-Haram se Baitul Maqdis le jaya gaya jahan tamam anbiya ki imamat farmai. Phir aasmaano ki sair hui, jahan 5 waqt ki Namaz ka azeem tohfa ummat ke liye mila.",
                        quranicReference = "Surah Al-Isra (17:1), Surah An-Najm (53:1-18)",
                        moralLesson = "Namaz momin ki Me'raj hai jo bande ko seedha rab se jod deti hai.",
                        orderIndex = 2
                    ),
                    ProphetEventEntity(
                        id = 4203, prophetId = 42,
                        title = "Fatah-e-Makkah aur Aalamgeer Rahm-o-Karam",
                        summary = "10,000 sathiyon ke sath bila khoon-kharaba Makkah fatah hua aur sab dushmanon ko aam muafi di.",
                        detailedNarrative = "21 saal zulm dhaaney wale Quraish ke sardaaron ke samne farmaya: 'Aaj tum par koi ilzam nahi, jao tum sab aazad ho'. Kaaba se 360 buton ko pash-pash kiya aur farmaya: 'Jaaa'al haqqu wa zahaqal baatil, innal baatila kaana zahooqaa'.",
                        quranicReference = "Surah Al-Isra (17:81), Surah An-Nasr (110:1-3)",
                        moralLesson = "Fatah ke waqt aji aur dushmano ke liye reham-o-karam hi shaan-e-rehmatul-lil-aalameen hai.",
                        orderIndex = 3
                    )
                )
            )
        )
    }
}
