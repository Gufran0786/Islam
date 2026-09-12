package com.example.data

object InitialData {

    data class PrepopulatedProphet(
        val prophet: ProphetEntity,
        val events: List<ProphetEventEntity>
    )

    fun getInitialData(): List<PrepopulatedProphet> {
        return listOf(
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 1,
                    orderIndex = 1,
                    nameArabic = "آدم عليه السلام",
                    nameRoman = "Hazrat Adam (A.S.)",
                    title = "Abul Bashar / Safiyullah (Chosen of Allah)",
                    ageYears = "960–1000 Saal",
                    fatherName = "Direct Creation from Soil (Created without Parents)",
                    motherName = "None (First human created by Allah)",
                    siblings = "None (First human being)",
                    children = "Habil (Abel), Qabil (Cain), Sheeth (Seth), Iqlima, Lubuda, and many others",
                    eraLocation = "Beginning of Creation, Sri Lanka / Arabian Peninsula",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Pehle Insan aur Pehle Nabi jinhe Allah Ta'ala ne mitti se takhleeq farmaya aur Farishton se sajda karwaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 101,
                        prophetId = 1,
                        title = "Takhleeq-e-Adam aur Sajda ka Hukm",
                        summary = "Allah ne Adam (A.S.) ko mitti se banaya, ilm-e-asma sikhaya, aur farishton ko sajda-e-tazeem ka hukm diya. Iblees ne takabbur kiya aur randa-e-dargah hua.",
                        detailedNarrative = "Jab Allah Ta'ala ne zameen par apna Khalifa banane ka irada farmaya, to mitti jama karke usme apni taraf se rooh phoonki. Adam (A.S.) ko tamam cheezon ke naam aur unki haqeeqat ka ilm bakhsha. Jab farishton ke samne un asma ki azmaish hui, to farishte ajeez aa gaye aur Adam (A.S.) ne sab bata diya. Is par Allah ne sabhi ko sajda-e-tazeem ka hukm diya. Farishton ne sajda kiya magar Iblees ne aag aur mitti ka muqabla karke ghamand kiya aur Allah ki nafarmani ki wajah se shaitan kehlaaya.",
                        quranicReference = "Surah Al-Baqarah (2:30-34), Surah Al-A'raf (7:11-18)",
                        moralLesson = "Ilm aur tawazu (humility) insan ka asli sharaf hai, jabki takabbur (arrogance) zillat ka sabab banta hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 102,
                        prophetId = 1,
                        title = "Jannat se Zameen par Nuzul aur Tauba",
                        summary = "Shaitan ke behkawe me aakar mamnu'a darakht ka phal chakhna, phir nidamat ke sath dua-e-tauba mangna aur Allah ka tauba qabool karna.",
                        detailedNarrative = "Adam (A.S.) aur Hawwa (A.S.) ko Jannat me aasaishon ke sath rakha gaya, sirf ek makhsoos darakht se door rehne ki takeed thi. Shaitan ne unhe waswasa diya aur qasam khakar galat fehmi me mubtala kiya. Darakht ka phal chakhne ke baad unhe foran apni ghalti ka ehsaas hua. Unhone zameen par aakar nihayat aaji ke sath tauba ki: 'Rabbana zalamna anfusana wa il-lam taghfir lana wa tarhamna lanakunanna minal-khasireen'. Allah ne unki tauba qabool farmai.",
                        quranicReference = "Surah Al-A'raf (7:23), Surah Ta-Ha (20:121-123)",
                        moralLesson = "Ghalti ke baad sachchi nidamat aur ruju' ilallah insan ko Allah ka muqarrab bana deti hai.",
                        orderIndex = 2
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 2,
                    orderIndex = 2,
                    nameArabic = "إدريس عليه السلام",
                    nameRoman = "Hazrat Idris (A.S.)",
                    title = "Ustad al-Bashar (The Wise Scholar & Builder)",
                    ageYears = "Lagbhag 365 Saal",
                    fatherName = "Yared (Yarid bin Mahalalel)",
                    motherName = "Barkanah",
                    siblings = "Khabra aur digar rishtedar",
                    children = "Methuselah (Matushelakh)",
                    eraLocation = "Babylon (Iraq) wa Misr (Egypt)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Pehle shakhs jinhone qalam se likhna, kapde silna aur hisaab-o-falakiyat ka ilm shuru kiya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 201,
                        prophetId = 2,
                        title = "Ilm-o-Hikmat aur Qalam ki Ibtida",
                        summary = "Hazrat Idris (A.S.) ne logon ko tauheed ki taleem di, qalam se likhna sikhaya aur unche maqam par buland kiye gaye.",
                        detailedNarrative = "Hazrat Idris (A.S.) nihayat sadiq aur parhezgar the. Riwayat me aata hai ki sabse pehle qalam se likhne ka aaghaz unhi se hua. Unhone libas silne aur pehanne ka tareeqa aam kiya aur logon ko insaniyat wa adab ki taleem di. Quran-e-Pak me irshad hai: 'Wa rafa'nahu makanan 'aliyya' (Humne unhe buland maqam par uthaya).",
                        quranicReference = "Surah Maryam (19:56-57)",
                        moralLesson = "Ilm, hunar aur mehnat deen wa dunya dono me insan ke darjaat buland karte hain.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 3,
                    orderIndex = 3,
                    nameArabic = "نوح عليه السلام",
                    nameRoman = "Hazrat Nuh (A.S.)",
                    title = "Shaikh al-Anbiya / Najiyullah",
                    ageYears = "950 Saal dawat + Majmu'i umar 1000+ Saal",
                    fatherName = "Lamech (Lamik bin Mathusaleh)",
                    motherName = "Shamkha bint Anush",
                    siblings = "Nir aur digar",
                    children = "Sam, Ham, Yafith, Kanaan (Yam - jo toofan me doob gaya)",
                    eraLocation = "Mesopotamia (Kufa / Iraq / Mount Judi)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "950 saal tak sabr ke sath tauheed ki tableegh ki aur azeem toofan me Kashti (Ark) banakar ahl-e-imaan ko bachaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 301,
                        prophetId = 3,
                        title = "950 Saal ki Sabir Tableegh aur Qoum ki Hat-Dharmi",
                        summary = "Hazrat Nuh (A.S.) ne raat din apni qoum ko samjhaya magar unhone but-parasti na chhodi aur mazaq udaya.",
                        detailedNarrative = "Hazrat Nuh (A.S.) ne apni qoum me taqreeban 950 saal tak khullam-khulla aur chupke har tareeqe se Allah ki tauheed ki dawat di. Magar qoum ke sar-b-aawardah logon ne na sirf inkar kiya balki garib imandar logon ka mazaq udaya aur unke sath dushmani par utar aaye.",
                        quranicReference = "Surah Nuh (71:1-20), Surah Hud (11:25-35)",
                        moralLesson = "Dawat-e-haq me istiqamat aur mustaqil mizaji sabse badi taqat hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 302,
                        prophetId = 3,
                        title = "Kashti ki Tameer aur Aalamgeer Toofan",
                        summary = "Allah ke hukm se azeem kashti banai, har janwar ka joda rakha aur kuffar sailaab me halak ho gaye.",
                        detailedNarrative = "Jab qoum ne kisi tarah baat na maani to Allah ne Kashti banane ka hukm diya. Jab toofan ka paani zameen aur aasmaan dono taraf se phoot pada to Hazrat Nuh (A.S.) aur unke ba-imaan sathiyon ne kashti me panah li. Unka ek beta Kanaan ghamand ki wajah se pahad par chadhne laga magar maujon ne use gher liya aur doob gaya. Kashti aakhirkar Koh-e-Judi par thehri.",
                        quranicReference = "Surah Hud (11:36-48), Surah Al-Mu'minun (23:27-30)",
                        moralLesson = "Najaat sirf Allah ke ehkam aur Imaan me hai, nasabi rishte baghair imaan ke kaam nahi aate.",
                        orderIndex = 2
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 4,
                    orderIndex = 4,
                    nameArabic = "هود عليه السلام",
                    nameRoman = "Hazrat Hud (A.S.)",
                    title = "Nabi-e-Qoum-e-Aad",
                    ageYears = "Taqreeban 464 Saal",
                    fatherName = "Shalikh (bin Arphaxad bin Sam)",
                    motherName = "Umm Hud (Tawheed par qayam khatoon)",
                    siblings = "Hazrat Murrah aur digar",
                    children = "Digar aal-o-awlad",
                    eraLocation = "Al-Ahqaf (Yemen wa Oman ke darmiyan)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Qoum-e-Aad jo taqatwar qad-o-qaamat aur azeem mehlat ki malik thi, use sachi dawat di."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 401,
                        prophetId = 4,
                        title = "Qoum-e-Aad ki Nasihat aur Tund-o-Teez Aandhi",
                        summary = "Aad ne apni jismani taqat par ghamand kiya. 7 raat aur 8 din ki barfila aandhi ne unhe tabaah kar diya.",
                        detailedNarrative = "Qoum-e-Aad intehai qawi aur taqatwar the aur Iram jaise buland sutoonon wale shehar banate the. Hazrat Hud (A.S.) ne unhe samjhaya ki Allah ki nematon ka shukr ada karo aur kamzoron par zulm na karo. Unhone inkar kiya to Allah ne un par 7 raatein aur 8 din lagataar shadeed thandi aandhi bheji jisne unhe ukhde hue khajoor ke tano ki tarah gira diya.",
                        quranicReference = "Surah Al-Ahqaf (46:21-26), Surah Al-Haqqah (69:6-8)",
                        moralLesson = "Jismani taqat ya daulat par ghamand Allah ke azab ke samne bekar sabit hota hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 5,
                    orderIndex = 5,
                    nameArabic = "صالح عليه السلام",
                    nameRoman = "Hazrat Saleh (A.S.)",
                    title = "Nabi-e-Qoum-e-Thamud",
                    ageYears = "Taqreeban 586 Saal",
                    fatherName = "Ubaid bin Asif",
                    motherName = "Waleedah",
                    siblings = "Banu Thamud ke afrad",
                    children = "Saleh ke betey",
                    eraLocation = "Al-Hijr (Mada'in Saleh, Saudi Arabia)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Pahadon ko tarash kar ghar banane wali Qoum-e-Thamud ko Maujiza-e-Naqah (Oontni) dikhaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 501,
                        prophetId = 5,
                        title = "Maujiza-e-Naqah (Muqaddas Oontni) aur Azab",
                        summary = "Pahad se mujezati oontni nikli, magar sarkoosh logon ne use qatal kar diya aur azab me pakde gaye.",
                        detailedNarrative = "Qoum-e-Thamud ne mutalba kiya ki agar aap sachche nabi hain to is chattan se ek hamla oontni paida karein. Allah ne unki talab ke mutabiq chattan se azeem oontni zahir farmayi. Hazrat Saleh (A.S.) ne takeed ki ki is oontni ko paani peene diya jaye aur koi nuqsan na pahunchaya jaye. Magar unke sarkash sardaaron ne oontni ki konche kaat kar qatal kar diya. Teen din baad ek azeem cheekh aur zalzale ne sabko dher kar diya.",
                        quranicReference = "Surah Ash-Shu'ara (26:141-159), Surah Hud (11:61-68)",
                        moralLesson = "Allah ke muqaddas nishaniyon ki behurmati azab ko dawat deti hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 6,
                    orderIndex = 6,
                    nameArabic = "إبراهيم عليه السلام",
                    nameRoman = "Hazrat Ibrahim (A.S.)",
                    title = "Khalilullah / Imam-un-Naas",
                    ageYears = "175–200 Saal",
                    fatherName = "Tarukh / Azar (Chacha/Walid)",
                    motherName = "Amila / Nuna",
                    siblings = "Nahor, Haran (Hazrat Lut ke walid)",
                    children = "Hazrat Isma'il (A.S.), Hazrat Ishaq (A.S.)",
                    eraLocation = "Ur (Iraq), Harran, Sham, Misr, Makkah Mukarramah",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Tauheed ke azeem parcham-bardar, Aag me dale gaye jo gulzar bani, Ka'bah ki tameer farmayi."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 601,
                        prophetId = 6,
                        title = "But-Shikani aur Namrood ki Aag ka Gulzar Banna",
                        summary = "Buton ko tod kar tauheed ki hujjati qayam ki, Namrood ne azeem aag me phenka jise Allah ne thanda aur salamati wala bana diya.",
                        detailedNarrative = "Hazrat Ibrahim (A.S.) ne aql-o-fahm se apni qoum ko sitaron, chaand aur sooraj ki be-ikhtiyari sabit karke Wahdahu La Shareek ki taraf bulaya. Melay ke din buton ko tod kar sabse bade but ke gale me kulhadi latka di taaki log samajh sakein ki ye be-jaan pathar kisi ka bura ya bhala nahi kar sakte. Namrood ne gusse me unhe dehkti aag me phenkwana chaha, par Allah ka farman aaya: 'Ya naaru kuni bardan wa salaman 'ala Ibrahim' (Aye aag thandi aur salamati wali ban ja!).",
                        quranicReference = "Surah Al-Anbiya (21:51-70)",
                        moralLesson = "Jo Allah par kamil bharosa (Tawakkul) rakhta hai, mushkilaat uske liye aasaani ban jati hain.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 602,
                        prophetId = 6,
                        title = "Tameer-e-Ka'bah aur Qurbani ki Sunnat",
                        summary = "Apne farzand Isma'il (A.S.) ke sath milkar Baitullah ki tameer ki aur azeem imtihaan me surkhuru hue.",
                        detailedNarrative = "Hazrat Ibrahim (A.S.) ko khwab me apne pyare farzand Isma'il (A.S.) ko zibah karne ka hukum mila. Baap aur bete dono ne khushi se Allah ke aage sar jhuka diya. Allah Ta'ala ko ye ada itni pasand aayi ki jannati dumba fidiya bana diya aur qayamat tak ahl-e-imaan ke liye qurbani ki sunnat qayam farmayi. Baad me dono ne milkar Ka'bah ki tameer ki.",
                        quranicReference = "Surah As-Saffat (37:100-111), Surah Al-Baqarah (2:125-129)",
                        moralLesson = "Ita'at aur qurbani ka jazba hi imaan ki asli rooh hai.",
                        orderIndex = 2
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 7,
                    orderIndex = 7,
                    nameArabic = "لوط عليه السلام",
                    nameRoman = "Hazrat Lut (A.S.)",
                    title = "Nabi-e-Sodom wa Gomorrah",
                    ageYears = "Taqreeban 175 Saal",
                    fatherName = "Haran (Hazrat Ibrahim A.S. ke bhai)",
                    motherName = "Umm Lut",
                    siblings = "Milkah, Iscah",
                    children = "Rithah, Za'rurah (Do naik betiyan)",
                    eraLocation = "Sodom (Dead Sea, Jordan / Palestine)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hazrat Ibrahim (A.S.) ke bhatije the, behayaee aur bad-fehli me ghaltan qoum ko paaki ki dawat di."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 701,
                        prophetId = 7,
                        title = "Qoum-e-Lut ki Bad-Aamali aur Azab-e-Ilahi",
                        summary = "Fitri qawaneen ki khilaf-warzi par qoum par patharon ki barish hui aur shehar ko ulat diya gaya.",
                        detailedNarrative = "Qoum-e-Lut gandi aur ghair-fitri khwahishat me mubtala thi. Hazrat Lut (A.S.) ne unhe barha paaki aur nek chalni ki nasihat farmayi magar unhone dhakiya dawat di ki in paakbaz logon ko basti se nikaal do. Farishte insani roop me aaye aur ahl-e-imaan ko raat ke aakhri hisse me nikal jaane ka hukm mila. Subah hote hi basti par aag wa pathar barse aur zameen ulat di gayi.",
                        quranicReference = "Surah Hud (11:77-83), Surah Al-Hijr (15:58-77)",
                        moralLesson = "Fuhash aur behayai mashre ko tabah kar deti hai, pakeezgi hi hifazat hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 8,
                    orderIndex = 8,
                    nameArabic = "إسماعيل عليه السلام",
                    nameRoman = "Hazrat Isma'il (A.S.)",
                    title = "Dhabihullah / Sadiq al-Wa'd",
                    ageYears = "137 Saal",
                    fatherName = "Hazrat Ibrahim (A.S.)",
                    motherName = "Hazrat Hajirah (A.S.)",
                    siblings = "Hazrat Ishaq (A.S.) (Sautelay bhai)",
                    children = "Qedar, Nebaioth aur 12 betey (Arab Musta'riba ke jad)",
                    eraLocation = "Makkah Mukarramah (Hejaz)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Zamzam ka josh marna, Ka'bah ki tameer, aur Huzoor Akram (S.A.W.) ke jadd-e-amjad."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 801,
                        prophetId = 8,
                        title = "Aab-e-Zamzam ka Chashma aur Maidan-e-Makkah ki Aabadi",
                        summary = "Bekho-o-giyah maidan me chhotay Isma'il ki aediyan ragadne se muqaddas Zamzam foot pada.",
                        detailedNarrative = "Hazrat Ibrahim (A.S.) ne Allah ke hukm par apni biwi Hajirah aur masoom Isma'il ko be-aab-o-giyah maidan (Makkah) me chhod diya. Jab paani khatam hua to Hazrat Hajirah ne Safa aur Marwah ke darmiyan beqarari me daud lagai. Us waqt masoom Isma'il ki aediyon ke paas se aab-e-zamzam ka barqatar chashma jari ho gaya, jisne Qabeela Jurhum ko wahan aabad kiya.",
                        quranicReference = "Surah Ibrahim (14:37), Surah Maryam (19:54-55)",
                        moralLesson = "Allah par kamil tawakkul karne walon ko Allah aisi jagah se rizq deta hai jahan gumaan bhi na ho.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 9,
                    orderIndex = 9,
                    nameArabic = "إسحاق عليه السلام",
                    nameRoman = "Hazrat Ishaq (A.S.)",
                    title = "Nabi-e-Barkat / Basharat-e-Ilahi",
                    ageYears = "180 Saal",
                    fatherName = "Hazrat Ibrahim (A.S.)",
                    motherName = "Hazrat Sarah (A.S.)",
                    siblings = "Hazrat Isma'il (A.S.)",
                    children = "Hazrat Yaqub (A.S.) aur Al-Ees (Esau)",
                    eraLocation = "Kanaan (Palestine / Hebron - Al-Khalil)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hazrat Sarah ki budhape me paidaish ki khushkhabri mili, Bani Israel ke silsila-e-nubuwwat ke jad."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 901,
                        prophetId = 9,
                        title = "Farishton ki Basharat aur Ilm-o-Barkat",
                        summary = "Hazrat Sarah aur Ibrahim (A.S.) ko budhape me Ishaq (A.S.) ki wiladat ki khushkhabri mili.",
                        detailedNarrative = "Jab farishte insani shakal me Hazrat Ibrahim (A.S.) ke paas mehmaan ban kar aaye, to unhone ek aalim wa saleh farzand ki basharat di. Hazrat Sarah hairan hui kyunki dono ki umar kafi dhal chuki thi. Farishton ne kaha: 'Kya tum Allah ke hukm par tajjub karti ho?' Hazrat Ishaq (A.S.) ne sharafat, ilm aur parhezgari ke sath Sham-o-Kanaan me dawat-e-haq di.",
                        quranicReference = "Surah Hud (11:69-73), Surah As-Saffat (37:112-113)",
                        moralLesson = "Allah ki qudrat aur rehmat me koi cheez namumkin nahi.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 10,
                    orderIndex = 10,
                    nameArabic = "يعقوب عليه السلام",
                    nameRoman = "Hazrat Yaqub (A.S.)",
                    title = "Isra'il (Abdullah - Servant of God)",
                    ageYears = "147 Saal",
                    fatherName = "Hazrat Ishaq (A.S.)",
                    motherName = "Rifqah (Rebecca)",
                    siblings = "Al-Ees (Esau - Judwa bhai)",
                    children = "12 Bete (Yusuf, Binyamin, Rubil, Sham'un, Lawi, Yahuda, vaghairah)",
                    eraLocation = "Palestine wa Misr (Egypt)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Azeem Sabr-e-Jameel ke paikar, Yusuf (A.S.) ke hijr me aankhon ki beenai gayi jo baad me qameez se wapas aayi."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1001,
                        prophetId = 10,
                        title = "Sabr-e-Jameel aur Yusuf (A.S.) ka Hijr",
                        summary = "Yusuf (A.S.) ke judai ke dukh me barsa-ha-baras sabr kiya aur hamesha Allah ki rehmat se umeed rakhi.",
                        detailedNarrative = "Jab beton ne aakar kaha ki Yusuf ko bhediye ne kha liya aur khoon-alood qameez pesh ki, to Hazrat Yaqub (A.S.) ne farmaya: 'Fasabrun Jameel' (Mera kaam to bas khoobsurat sabr karna hai). Barsa-ha-baras rote rote beenai kamzor ho gayi, magar farmaya: 'Main to apne gham aur faryad ka shikwa sirf Allah se karta hoon aur Allah ki taraf se wo jaanta hoon jo tum nahi jaante'. Aakhirkar Yusuf mile aur qameez aankhon par lagate hi beenai laut aayi.",
                        quranicReference = "Surah Yusuf (12:18, 83-96)",
                        moralLesson = "Mushkil tareen waqt me bhi Allah ki rehmat se mayoos na hona sabse azeem imaan hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 11,
                    orderIndex = 11,
                    nameArabic = "يوسف عليه السلام",
                    nameRoman = "Hazrat Yusuf (A.S.)",
                    title = "As-Siddiq / Ahsanul Qasas",
                    ageYears = "110–120 Saal",
                    fatherName = "Hazrat Yaqub (A.S.)",
                    motherName = "Rahil (Rachel)",
                    siblings = "Binyamin (Sage bhai) aur 10 sautelay bhai",
                    children = "Ifrayim (Ephraim), Manassa (Manasseh)",
                    eraLocation = "Kanaan se Misr (Egypt)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Kuen me phenke gaye, qaid-khane me sabr kiya, khwabon ki ta'beer se Misr ke Aziz wa Khazana-daar bane."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1101,
                        prophetId = 11,
                        title = "Bhaiyon ka Hasad, Kunwan aur Misr ki Qaid",
                        summary = "Hasad ki wajah se andhere kuen me phenke gaye, ghulam bana kar beche gaye, pakeezgi ki khatir jail chune.",
                        detailedNarrative = "Hazrat Yusuf (A.S.) ko bachpan me 11 sitaron, suraj aur chand ko sajda karte dekhne ka khwab aaya. Bhaiyon ne hasad me aakar unhe kuen me daal diya. Qafle ne nikaal kar Misr me Aziz-e-Misr ko bech diya. Jab Aziz ki biwi ne unhe gunah ki taraf dawat di, to Hazrat Yusuf ne farmaya: 'Ma'adhallah!' aur pakeezgi bachane ke liye jail ko tarjeeh di.",
                        quranicReference = "Surah Yusuf (12:4-35)",
                        moralLesson = "Gunah se bachne ke liye har aazmaish bardasht karna sharafat aur parhezgari ki nishani hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 1102,
                        prophetId = 11,
                        title = "Iqtidaar, Khwabon ki Ta'beer aur Ma'afi ka Aala Namoona",
                        summary = "Badshah ke khwab ki ta'beer batakar qahat se mulk bachaya aur bhaiyon ko aali-zarfi se maaf farmaya.",
                        detailedNarrative = "Badshah ke 7 moti aur 7 dubli gaayon wale khwab ki sachi ta'beer di aur 7 saal me anaj zakheera karne ki mansoobabandi ki. Misr ke hukumran bane. Jab qahat me wahi bhai ghalla lene aaye, to unhe pehchana aur inteqam lene ke bajaye farmaya: 'La tathreeba 'alaikumul yaum' (Aaj tum par koi ilzam nahi, Allah tumhe maaf kare).",
                        quranicReference = "Surah Yusuf (12:43-92)",
                        moralLesson = "Taqat hone ke bawajood dushman ko maaf karna aala tareen ikhlaq hai.",
                        orderIndex = 2
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 12,
                    orderIndex = 12,
                    nameArabic = "أيوب عليه السلام",
                    nameRoman = "Hazrat Ayyub (A.S.)",
                    title = "As-Sabir (The Paragon of Patience)",
                    ageYears = "Taqreeban 140 Saal",
                    fatherName = "Amwas bin Tarekh",
                    motherName = "Bint-e-Lut (Hazrat Lut ki beti)",
                    siblings = "Khandani afrad",
                    children = "Beshumar aulad (Jo baad me dubaara ata hui)",
                    eraLocation = "Hauran / Sham (Syria / Jordan border)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Shadeed jismani beemari, maal-o-daulat aur aulad ke nuqsan par azeem misali sabr farmaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1201,
                        prophetId = 12,
                        title = "Shadeed Aazmaish aur Shifa ka Mu'jizati Chashma",
                        summary = "Beshumar beemari aur maal-o-aulad ki judai me bhi zaban par shukr raha, Allah ne zameen se thanda chashma jari farmaya.",
                        detailedNarrative = "Hazrat Ayyub (A.S.) intehai daulat-mand aur ba-aulad the. Allah ne aazmaish me unka maal, ghar aur aulad le li, aur khud unhe shadeed marz me mubtala farmaya. Saal-ha-saal beemar rahe magar shikwa kiye baghair dua ki: 'Anni massaniyad-durru wa Anta Arhamur-Rahimeen'. Allah ne farmaya: 'Apna paon zameen par maro, ye thanda paani nahane aur peene ke liye hai'. Shifa hui aur dubaara duniwi nematein dugni karke ata farmai.",
                        quranicReference = "Surah Al-Anbiya (21:83-84), Surah Sad (38:41-44)",
                        moralLesson = "Museebat me shukr-guzari aur sabr insan ko Allah ki azeem rehmat ka mustahiq banata hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 13,
                    orderIndex = 13,
                    nameArabic = "شعيب عليه السلام",
                    nameRoman = "Hazrat Shu'ayb (A.S.)",
                    title = "Khatib al-Anbiya (The Eloquent Orator)",
                    ageYears = "Taqreeban 242 Saal",
                    fatherName = "Mikaeel bin Yashjur bin Madyan",
                    motherName = "Bint-e-Lut",
                    siblings = "Ahl-e-Madyan",
                    children = "Safura (Biwi-e-Musa) aur unki behen",
                    eraLocation = "Madyan wa Ashab al-Aykah (Jordan / Saudi border)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Naap-tol me kami aur tijarati khayanat karne wali qoum ko adal wa aman ki dawat di."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1301,
                        prophetId = 13,
                        title = "Tijarati Adal ki Dawat aur Qoum par Badalon ka Azab",
                        summary = "Naap tol me kami karne aur raaste band karne se roka, inkar par 'Azab-e-Yaum-uz-Zullah' (Badal ka azab) aaya.",
                        detailedNarrative = "Ahl-e-Madyan aur Ashab-ul-Aykah tijarat me kami-beshi karte the aur logon ko loot te the. Hazrat Shu'ayb (A.S.) ne nihayat sheerin bayani se samjhaya ki Allah ka diya hua halal munafa tumhare liye behtar hai. Qoum ne mazaq udaya aur kaha kya tumhari namaz ye sikhati hai ki hum apne maal me apni marzi na karein? Nateeja ye hua ki aag barsane wale badal aur zalzale ne unhe halaak kar diya.",
                        quranicReference = "Surah Hud (11:84-95), Surah Ash-Shu'ara (26:176-191)",
                        moralLesson = "Tijarat aur rozgar me imandari aur adal muashre ki baqa ke liye lazmi hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 14,
                    orderIndex = 14,
                    nameArabic = "موسى عليه السلام",
                    nameRoman = "Hazrat Musa (A.S.)",
                    title = "Kalimullah (The One Who Spoke to Allah)",
                    ageYears = "120 Saal",
                    fatherName = "Imran (Amram bin Kohath)",
                    motherName = "Yukhabid (Jochebed)",
                    siblings = "Hazrat Harun (A.S.) (Bade Bhai), Maryam / Miryam (Badi Behen)",
                    children = "Gershom, Eliezer",
                    eraLocation = "Misr (Egypt), Madyan, Koh-e-Toor, Sehra-e-Sina",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Fir'aun ke darbar me haq ka elaan, Aasa ka azdaha banna, Samundar ka phatna, aur Taurat ka nuzul."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1401,
                        prophetId = 14,
                        title = "Sandookche me Darya-e-Neel ka Safar aur Mehal me Parwarish",
                        summary = "Fir'aun ke bachon ke qatal ke darmian Allah ne Musa (A.S.) ko usi ke mehal me parwarish karwayi.",
                        detailedNarrative = "Fir'aun ne khwab dekh kar Bani Israel ke har navzaad ladke ko qatal karne ka farman jari kiya. Hazrat Musa ki walida ne Allah ke ilham par unhe sandook me daal kar darya-e-Neel me baha diya. Fir'aun ki biwi Hazrat Aasiya ne unhe utha liya aur farzand banaya. Behen Maryam ne peechha kiya aur unki asil maa ko hi doodh pilane wali bana kar louta diya gaya.",
                        quranicReference = "Surah Al-Qasas (28:7-13), Surah Ta-Ha (20:38-40)",
                        moralLesson = "Jise Allah bachana chahe, use dushman ke ghar ke andar bhi koi nuqsan nahi pahuncha sakta.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 1402,
                        prophetId = 14,
                        title = "Koh-e-Toor par Kalam-e-Ilahi aur Fir'aun ka Gharaq hona",
                        summary = "Koh-e-Toor par aag dekh kar nubuwwat mili, Fir'aun ke samne Aasa aur Yad-e-Baiza dikhaya, aur samundar do tukde hua.",
                        detailedNarrative = "Koh-e-Toor par Allah ne Hazrat Musa se guftugu farmai aur nubuwwat ata farmayi. Fir'aun ke darbar me jaakar Bani Israel ki azaadi ka mutalba kiya. Jadoogaron ke jaal ko Musa (A.S.) ke aasa ne nigal liya aur jadoogar sajde me gir gaye. Jab Fir'aun ne lashkar ke sath peecha kiya, to Musa (A.S.) ke aasa marne par Samundar phat kar 12 khushk raaste ban gaya. Bani Israel bach gaye aur Fir'aun gharaq ho gaya.",
                        quranicReference = "Surah Ta-Ha (20:9-79), Surah Ash-Shu'ara (26:10-68)",
                        moralLesson = "Zulm chahe kitna hi taqatwar kyun na ho, aakhirkar haq ke samne dher ho jata hai.",
                        orderIndex = 2
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 15,
                    orderIndex = 15,
                    nameArabic = "هارون عليه السلام",
                    nameRoman = "Hazrat Harun (A.S.)",
                    title = "Wazeer-e-Musa wa Fasih-ul-Lisan",
                    ageYears = "122–123 Saal",
                    fatherName = "Imran",
                    motherName = "Yukhabid",
                    siblings = "Hazrat Musa (A.S.) (Chhote Bhai), Maryam (Badi Behen)",
                    children = "Nadab, Abihu, Eleazar, Ithamar",
                    eraLocation = "Misr wa Sehra-e-Sina (Mount Hor)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hazrat Musa ke mu'awin aur shareek-e-kar, nihayat sheerin-bayaan aur narm-dil paighambar."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1501,
                        prophetId = 15,
                        title = "Nubuwwat me Shirakat aur Samiri ke Fitne me Sabr",
                        summary = "Hazrat Musa ki dua par wazeer bane, Koh-e-Toor par Musa (A.S.) ki adam-maujoodgi me qoum ko bhatakne se roka.",
                        detailedNarrative = "Hazrat Musa (A.S.) ne dua mangi: 'Wa-j'al li wazeeran min ahli, Haruna akhi' (Mera wazeer mere ahl me se mere bhai Harun ko bana). Allah ne unhe nabi banaya. Jab Musa (A.S.) Toor par 40 din rahe to Samiri ne sone ka bachhda banakar logon ko gumrah kiya. Harun (A.S.) ne poori taqat se roka aur ikhtelaf se bachne ke liye Musa (A.S.) ke aane tak intezar kiya.",
                        quranicReference = "Surah Ta-Ha (20:29-36, 83-94)",
                        moralLesson = "Ittehad-e-millat aur narm dileri se ikhtelaf ko sambhalna azeem hikmat hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 16,
                    orderIndex = 16,
                    nameArabic = "داود عليه السلام",
                    nameRoman = "Hazrat Dawud (A.S.)",
                    title = "Khalifatullah / Sahib-e-Zabur",
                    ageYears = "100 Saal",
                    fatherName = "Eesha (Jesse)",
                    motherName = "Nisbah",
                    siblings = "7 se 8 bhai (Eliab, Abinadab, Shammah, etc.)",
                    children = "Hazrat Sulayman (A.S.) aur digar",
                    eraLocation = "Jerusalem / Baitul Muqaddas (Palestine)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Jaloot ko gophan se qatal kiya, Zabur utri, loha unke haathon me mom ho jata tha, parinday unke sath tasbeeh padhte the."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1601,
                        prophetId = 16,
                        title = "Jaloot ka Qatal, Zabur aur Loha Mom Banna",
                        summary = "Taloot ke lashkar me jaloot ko maara, Zabur ki tilawat par pahad wa parindey goonjte the, loha mom ki tarah narm ho jata tha.",
                        detailedNarrative = "Naw-jawan Dawud ne zaalim badshah Jaloot ko gophan ke pathar se dher kar diya. Allah ne unhe azeem saltanat aur nubuwwat dono ata farmai. Un par Zabur shareef nazil hui. Jab wo khush-ilhani se tilawat farmate to parinday hawa me thehar jaate aur pahad unke sath tasbeeh padhte the. Allah ne unke haath me lohe ko mom ki tarah narm kar diya tha jisse wo zirah (armour) banate aur rozi kamate the.",
                        quranicReference = "Surah Al-Baqarah (2:251), Surah Saba (34:10-11), Surah Sad (38:17-26)",
                        moralLesson = "Iqtidaar aur shaan-o-shaukat ke bawajood apne haath ki kamai khana aur shukr ada karna aala sifat hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 17,
                    orderIndex = 17,
                    nameArabic = "سليمان عليه السلام",
                    nameRoman = "Hazrat Sulayman (A.S.)",
                    title = "Al-Malik An-Nabi (King & Prophet)",
                    ageYears = "52–53 Saal",
                    fatherName = "Hazrat Dawud (A.S.)",
                    motherName = "Bathsheba (Sabigha)",
                    siblings = "Absalom, Amnon aur digar",
                    children = "Rehoboam (Rihbam)",
                    eraLocation = "Baitul Muqaddas (Jerusalem)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hawa, Jinnaat aur Janwaron ki boliyan sikhayi gayi, Bilqees ka takht mangwaya, Haikal-e-Sulaymani tameer karwaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1701,
                        prophetId = 17,
                        title = "Chyunti ki Pukaar, Jinnaat ki Taskheer aur Bilqees ka Qissa",
                        summary = "Chyunti ki aawaz sun kar muskuraye, Hawa par takht chalta tha, Malika Bilqees ne mutasir hokar Islam qabool kiya.",
                        detailedNarrative = "Hazrat Sulayman (A.S.) ko aisi be-misaal saltanat mili jisme Jinnaat, insaan, charind, parind aur hawayen unke zer-e-farma the. Ek martaba lashkar guzar raha tha to ek chyunti ne doosri se kaha apne bilo me ghus jao taaki rond na diye jao. Sulayman (A.S.) ne sun kar shukr ada kiya. Hudhud parinde ne Mulk-e-Saba ki khabar di, jahan ki Malika Bilqees ko dawat-e-tauheed di aur unka takht ankh jhapakne me hazir karwaya.",
                        quranicReference = "Surah An-Naml (27:15-44), Surah Saba (34:12-14)",
                        moralLesson = "Beshumar qudrat aur saltanat ke bawajood kamzor tareen makhluq ka khayal rakhna aur aajizi ikhtiyar karna zaroori hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 18,
                    orderIndex = 18,
                    nameArabic = "إلياس عليه السلام",
                    nameRoman = "Hazrat Ilyas (A.S.)",
                    title = "Nabi-e-Ba'lbek (Elijah)",
                    ageYears = "Taqreeban 100+ Saal",
                    fatherName = "Yasin (Ilyasin)",
                    motherName = "Umm Ilyas",
                    siblings = "Banu Israel ke afrad",
                    children = "Ruhani shagird Hazrat Al-Yasa (A.S.)",
                    eraLocation = "Ba'labak (Lebanon / Syria)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Ba'l naam ke but ki pooja karne walon ko sachchi tauheed ki taraf bulaya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1801,
                        prophetId = 18,
                        title = "Ba'l But ki Tardeed aur Tauheed ki Dawat",
                        summary = "Badshah aur awam ko Ba'l but chhod kar As-Sami' wal-Baseer Allah ki taraf bulaya.",
                        detailedNarrative = "Hazrat Ilyas (A.S.) ne ahl-e-Ba'labak ko samjhaya: 'Kya tum Ba'l ko pukarte ho aur sabse behtareen paida karne wale Allah ko chhodte ho?' Unki qoum ne inkar kiya jis par qahat aaya. Baad me unke ahl-e-qoum ne unki nasihat par dubaara ruju kiya.",
                        quranicReference = "Surah As-Saffat (37:123-132)",
                        moralLesson = "Beshumar jhoote buton ke bajaye sirf khaliq-e-kainat ki ibadat hi kamiyabi hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 19,
                    orderIndex = 19,
                    nameArabic = "اليسع عليه السلام",
                    nameRoman = "Hazrat Al-Yasa (A.S.)",
                    title = "Khalifa-e-Ilyas (Elisha)",
                    ageYears = "Taqreeban 90 Saal",
                    fatherName = "Ukhtub (Shaphat)",
                    motherName = "Umm Al-Yasa",
                    siblings = "Bani Israel",
                    children = "Ahl-e-Imaan",
                    eraLocation = "Sham wa Palestine (Damascus / Samaria)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Hazrat Ilyas (A.S.) ke baad nubuwwat ko aage badhaya, quran me fazilat wale bando me shumar."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 1901,
                        prophetId = 19,
                        title = "Ilm-o-Barkat aur Mu'jizat",
                        summary = "Hazrat Al-Yasa ne qoum ki islah farmai aur beemaron ko shifa-e-kamila mili.",
                        detailedNarrative = "Hazrat Al-Yasa (A.S.) Hazrat Ilyas ke humrah rahe aur unke baad Bani Israel ke hidayat-kar bane. Quran me irshad hai: 'Wa Isma'eela wal-Yasa'a wa Yunusa wa Loota, wa kullan faddalna 'alal-'alameen' (Aur humne sabko jahan-walon par fazilat bakhshi).",
                        quranicReference = "Surah Al-An'am (6:86), Surah Sad (38:48)",
                        moralLesson = "Neki aur hidayat ka silsila nasal dar nasal chalte rehna chahiye.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 20,
                    orderIndex = 20,
                    nameArabic = "يونس عليه السلام",
                    nameRoman = "Hazrat Yunus (A.S.)",
                    title = "Dhun-Nun (Sahib-ul-Hoot / Jonah)",
                    ageYears = "Taqreeban 100 Saal",
                    fatherName = "Matta (Amittai)",
                    motherName = "Khatoon-e-Saleha",
                    siblings = "Ahl-e-Nineveh",
                    children = "Saleh aulaad",
                    eraLocation = "Nineveh (Mosul, Iraq)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Machhli ke pet me chale gaye, Ayat-e-Kareema padhi, 1 lakh se zyada afrad ki qoum ne tauba ki."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2001,
                        prophetId = 20,
                        title = "Machhli ka Pet aur Ayat-e-Kareema ki Fazeelat",
                        summary = "Samundar me dale gaye, nihayat azeem machhli ne nigal liya, andheron me 'La ilaha illa Anta Subhanaka' padh kar najaat paayi.",
                        detailedNarrative = "Hazrat Yunus (A.S.) apni qoum ki hat-dharmi se tang aakar izn-e-ilahi se pehle hijrat par nikal pade. Kashti par bhaar zyada hone par qura daala gaya to unka naam nikla aur samundar me koodna pada. Ek azeem machhli ne unhe salamat nigal liya. Machhli ke pet, samundar aur raat ke andheron me unhone azeem dua mangi: 'La ilaha illa Anta Subhanaka inni kuntu minaz-zalimeen'. Allah ne machhli ko kinare par ugalne ka hukum diya aur qaddoo ki bel unpar saya-daar banayi.",
                        quranicReference = "Surah Al-Anbiya (21:87-88), Surah As-Saffat (37:139-148)",
                        moralLesson = "Ghalti ka aiteeraf aur tasbeeh har qism ke andheron aur mushkilaat se najaat dilati hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 21,
                    orderIndex = 21,
                    nameArabic = "ذو الكفل عليه السلام",
                    nameRoman = "Hazrat Dhul-Kifl (A.S.)",
                    title = "Al-Kafil (The Reliable & Trustworthy)",
                    ageYears = "Taqreeban 75–95 Saal",
                    fatherName = "Hazrat Ayyub (A.S.) (Bishr bin Ayyub)",
                    motherName = "Rahmah (Bint-e-Ifrayim)",
                    siblings = "Bani Ayyub",
                    children = "Saleh nasl",
                    eraLocation = "Damascus / Kifl (Iraq)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Sabar aur ahd-o-paiman nibhane wale nabi, qazi ban kar poora adal qayam kiya."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2101,
                        prophetId = 21,
                        title = "Ahd ki Pabandhi aur Raat Din ki Ibadat",
                        summary = "Din me roza, raat me ibadat aur faisle karte waqt gusse se bachne ka ahd poora kiya.",
                        detailedNarrative = "Hazrat Dhul-Kifl ne zimmedari uthayi ki wo din ko roza rakhenge, raat ko ibadat karenge aur faisle karte hue kabhi gussa nahi karenge. Shaitan ne kai baar aakar unka gussa aazmaya magar unhone apne kaffalah (ahd) ko aakhri dum tak poora farmaya.",
                        quranicReference = "Surah Al-Anbiya (21:85-86), Surah Sad (38:48)",
                        moralLesson = "Waada aur ahd poora karna sadiqeen ka aala wasf hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 22,
                    orderIndex = 22,
                    nameArabic = "زكريا عليه السلام",
                    nameRoman = "Hazrat Zakariyya (A.S.)",
                    title = "Kafil-e-Maryam / Shahadat-e-Haq",
                    ageYears = "Taqreeban 92–100 Saal",
                    fatherName = "Barakhya (Berechiah)",
                    motherName = "Umm Zakariyya",
                    siblings = "Bani Harun ke ulama",
                    children = "Hazrat Yahya (A.S.)",
                    eraLocation = "Baitul Muqaddas (Jerusalem)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Hazrat Maryam ki kafalat ki, budhape me saleh farzand (Yahya A.S.) ki dua qubool hui."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2201,
                        prophetId = 22,
                        title = "Hazrat Maryam ka Hujra aur Yahya (A.S.) ki Dua",
                        summary = "Hazrat Maryam ke paas be-mausam phal dekh kar budhape me saleh aulad ki dua mangi.",
                        detailedNarrative = "Hazrat Zakariyya (A.S.) jab bhi Hazrat Maryam ke hujre me aate to dekhte ki be-mausami phal rakhe hain. Pucha ye kahan se aaya? Kaha: 'Ye Allah ki taraf se hai'. Us waqt Zakariyya (A.S.) ne chupke se dua ki: 'Rabbi hab li min ladunka zurriyyatan tayyibatan'. Allah ne budhape aur biwi ke baanjh hone ke bawajood Yahya (A.S.) ki wiladat ki basharat bakhshi.",
                        quranicReference = "Surah Ali 'Imran (3:37-41), Surah Maryam (19:1-11)",
                        moralLesson = "Kainaat ke zahiri asbaab ruk jayein tab bhi Allah ke khazano se mangna chahiye.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 23,
                    orderIndex = 23,
                    nameArabic = "يحيى عليه السلام",
                    nameRoman = "Hazrat Yahya (A.S.)",
                    title = "Sayyidan wa Hasoora (John the Baptist)",
                    ageYears = "Taqreeban 30–33 Saal",
                    fatherName = "Hazrat Zakariyya (A.S.)",
                    motherName = "Isha (Elizabeth / Ashba)",
                    siblings = "Hazrat Isa (A.S.) (Khala-zaad bhai)",
                    children = "None (Hasoor - Mujarrad rahe)",
                    eraLocation = "Palestine wa Jordan (River Jordan)",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Bachpan se hi ilm-o-hikmat ata hui, narm dil, parhezgar aur haq par jaan qurban karne wale nabi."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2301,
                        prophetId = 23,
                        title = "Hikmat-e-Tufooliyat aur Haq-Goi",
                        summary = "Bachpan me hi Kitabullah ko mazbooti se pakadne ka hukum mila aur badshah ke samne haq bayan kiya.",
                        detailedNarrative = "Hazrat Yahya (A.S.) ko Allah ne bachpan me hi hikmat aur narm-dili ata farmai. Wo janglon aur sahraon me Allah ke khauf se rote the aur tauba ki tableegh karte the. Jab badshah ne na-jaiz rishta jodna chaha to Hazrat Yahya ne khullam-khulla shariat ke ahkaam ka dharam nibhaya aur shahadat ka rutba paya.",
                        quranicReference = "Surah Maryam (19:12-15)",
                        moralLesson = "Haq baat kehne me kisi duniwi taqat ya badshah se na darna shaheedon ka rasta hai.",
                        orderIndex = 1
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 24,
                    orderIndex = 24,
                    nameArabic = "عيسى عليه السلام",
                    nameRoman = "Hazrat Isa (A.S.)",
                    title = "Ruhullah / Al-Masih (Jesus)",
                    ageYears = "33 Saal (Raf'a ila As-Sama - Aasmaan par uthaye gaye)",
                    fatherName = "Born without a Father (Created by Kun by Allah)",
                    motherName = "Hazrat Maryam (A.S.) (Siddiqah)",
                    siblings = "None (Only child of Maryam)",
                    children = "None",
                    eraLocation = "Bethlehem, Nazareth, Jerusalem (Palestine)",
                    photoUrlOrRes = "img_app_icon",
                    summaryHighlights = "Paghware me guftugu, Murdon ko zinda karna, Andhon ko beena karna, Injeel ka nuzul, aur Aasmaan par uthaya jana."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2401,
                        prophetId = 24,
                        title = "Bila Baap ke Paidaish aur Jhule me Guftugu",
                        summary = "Hazrat Maryam ki kukh se bila walid paida hue, jab logon ne ilzam lagaya to navzaad Isa (A.S.) ne pukaar kar kaha: 'Inni Abdullah'.",
                        detailedNarrative = "Farishta Jibreel (A.S.) ne Hazrat Maryam ko paak farzand ki basharat di jo Allah ke kalima 'Kun' se wajood me aaye. Jab qoum ne bad-gumani ki to Maryam (A.S.) ne bachhe ki taraf ishara kiya. Jhule me masoom Isa (A.S.) ne goya hokar farmaya: 'Main Allah ka banda hoon, usne mujhe Kitab di aur Nabi banaya'.",
                        quranicReference = "Surah Maryam (19:16-36), Surah Ali 'Imran (3:45-49)",
                        moralLesson = "Allah Ta'ala asbaab ka mohtaaj nahi, wo jo chahe 'Kun fayakoon' se takhleeq karta hai.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 2402,
                        prophetId = 24,
                        title = "Injeel, Muejizat aur Aasmaan par Raf'a",
                        summary = "Mitti ke parinde me phoonk markar udaana, murdon ko zinda karna, aur dushmanon se bachakar zinda aasmaan par buland kiya jana.",
                        detailedNarrative = "Hazrat Isa (A.S.) ne Allah ke izn se andhon ko aankhein di, korhi ko theek kiya aur murdon ko zinda kiya. Injeel ki dawat di. Jab dushmanon ne qatal ki saazish rachi to Allah ne unke hum-shakal shakhs ko dushmanon ke hawale kar diya aur Hazrat Isa (A.S.) ko zinda aasmaan par utha liya: 'Wa ma qataloohu wa ma salaboohu wa lakin shubbiha lahum'.",
                        quranicReference = "Surah An-Nisa (4:157-158), Surah Al-Ma'idah (5:110-118)",
                        moralLesson = "Momin ko dushman chahe jitna mitaane ki koshish karein, Allah apne bando ki hifazat farmata hai.",
                        orderIndex = 2
                    )
                )
            ),
            PrepopulatedProphet(
                prophet = ProphetEntity(
                    id = 25,
                    orderIndex = 25,
                    nameArabic = "محمد صلى الله عليه وسلم",
                    nameRoman = "Hazrat Muhammad (S.A.W.)",
                    title = "Khatamun Nabiyyin / Rahmatul-lil-'Alameen",
                    ageYears = "63 Saal",
                    fatherName = "Hazrat Abdullah bin Abdul Muttalib",
                    motherName = "Hazrat Aminah bint Wahb",
                    siblings = "None (Raza'i bhai-behen: Shaima, Abdullah, Aneesa)",
                    children = "Qasim, Abdullah, Ibrahim, Zainab, Ruqayyah, Umm Kulthum, Fatimah az-Zahra (R.A.)",
                    eraLocation = "Makkah Mukarramah wa Madinah Munawwarah",
                    photoUrlOrRes = "img_book_banner",
                    summaryHighlights = "Aakhri aur Afzal-ul-Anbiya, Quran-e-Pak ka azeem daa'imi mu'jiza, Me'raj-un-Nabi, aur Tamam Insaniyat ke liye Rehmat."
                ),
                events = listOf(
                    ProphetEventEntity(
                        id = 2501,
                        prophetId = 25,
                        title = "Ghar-e-Hira me Pehli Wahi aur Dawat-e-Islam",
                        summary = "Ghar-e-Hira me Surah Al-Alaq ki pehli 5 aayat ka nuzul: 'Iqra bismi Rabbikal ladhi khalaq'.",
                        detailedNarrative = "40 saal ki umar me Ghar-e-Hira me ibadat ke dauran Hazrat Jibreel (A.S.) pehli wahi lekar hazir hue. Farmaya: 'Padhiye apne Rab ke naam se jisne paida kiya'. Hazrat Khadijah (R.A.) ne himmat badhayi. Aap (S.A.W.) ne As-Sadiq aur Al-Ameen ke kirdar ke sath Makkah me dawat-e-haq ka aaghaz farmaya aur shadeed zulm-o-sitam ke bawajood sabr kiya.",
                        quranicReference = "Surah Al-Alaq (96:1-5), Surah Al-Muddaththir (74:1-7)",
                        moralLesson = "Ilm, sachai aur pakeeza kirdar hi azeem inqilaab ki bunyad bante hain.",
                        orderIndex = 1
                    ),
                    ProphetEventEntity(
                        id = 2502,
                        prophetId = 25,
                        title = "Waqia-e-Me'raj aur Panj-waqta Namaz ka Tohfa",
                        summary = "Masjid-e-Haram se Masjid-e-Aqsa aur wahan se Sidratul Muntaha tak ka azeem roohani wa jismani safar.",
                        detailedNarrative = "Shab-e-Me'raj me Aap (S.A.W.) Buraq par sawar hokar Baitul Maqdis tashreef le gaye jahan tamam anbiya ki imamat farmai. Phir aasmaano ki bulandiyon par Sidratul Muntaha tak pohanche aur Deedar-e-Ilahi se musharraf hue. Ummat-e-Muslima ke liye rozana 5 waqt ki Namaz ka noorani tohfa in'am me mila.",
                        quranicReference = "Surah Al-Isra (17:1), Surah An-Najm (53:1-18)",
                        moralLesson = "Namaz momin ki me'raj hai jisse banda sidha apne Rab se rabta qayam karta hai.",
                        orderIndex = 2
                    ),
                    ProphetEventEntity(
                        id = 2503,
                        prophetId = 25,
                        title = "Hijrat-e-Madinah, Fatah-e-Makkah aur Khutba Hajjat-ul-Wida",
                        summary = "Madinah me misali riyasat qayam ki, Makkah bila khoon-kharaba fatah kiya aur insani huqooq ka azeem manshoor bakhsha.",
                        detailedNarrative = "Makkah ke zulm ke baad Madinah hijrat farmai jahan Ansar aur Muhajireen me aisi misali ukhuwwat qayam hui jiski tareekh me misaal nahi. 8 Hijri me Fatah-e-Makkah ke mauqe par sabhi jaani dushmanon ko 'La tathreeba 'alaikum' keh kar aam ma'afi de di. Hajjat-ul-Wida me tamam insani barabari, aurton ke huqooq aur aman ka azeem paigham diya.",
                        quranicReference = "Surah An-Nasr (110:1-3), Surah Al-Fath (48:1-3)",
                        moralLesson = "Rehm-o-karam aur aam ma'afi hi dilon ko jeetne ka sabse azeem hathiyar hai.",
                        orderIndex = 3
                    )
                )
            )
        )
    }
}
