package com.example.data

/**
 * Data model for Mala'ikah (Angels / فرشتے / फ़रिश्ते) in Islam.
 */
data class AngelEntity(
    val id: String,
    val nameArabic: String,
    val nameRoman: String,
    val nameHindi: String,
    val nameUrdu: String,
    val title: String,
    val primaryDutyHinglish: String,
    val primaryDutyHindi: String,
    val primaryDutyUrdu: String,
    val detailedResponsibilities: List<String>,
    val quranAyahArabic: String,
    val quranAyahTranslationUrdu: String,
    val quranAyahTranslationHindi: String,
    val quranSurahReference: String,
    val hadithReference: String,
    val category: String, // "Chaar Muqarrab", "Aamaal o Qabar", "Jannat o Jahannam", "Nizam-e-Kainat"
    val specialCharacteristics: String
)

object AngelsData {

    val angelsList: List<AngelEntity> = listOf(
        // 1. Jibreel (A.S.)
        AngelEntity(
            id = "jibreel",
            nameArabic = "جِبْرِيل عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Jibreel (A.S.)",
            nameHindi = "हज़रत जिब्रील (अ.स.)",
            nameUrdu = "حضرت جبرائیل علیہ السلام",
            title = "Rooh al-Qudus (روح القدس) • Rooh al-Ameen • Sayyid al-Mala'ikah",
            primaryDutyHinglish = "Tamam Nabiyon aur Rasoolon tak Allah Ta'ala ka paigham, Wahi aur Aasmani Sahife/Kitabein pahunchana.",
            primaryDutyHindi = "तमाम नबियों और रसूलों तक अल्लाह तआला का पैग़ाम, वही और आसमानी किताबें पहुँचाना।",
            primaryDutyUrdu = "تمام انبیاء و رسل تک اللہ تعالیٰ کا کلام، وحی اور آسمانی کتابیں پہنچانا۔",
            detailedResponsibilities = listOf(
                "Hazrat Muhammad (S.A.W.) par Ghaar-e-Hira mein pehli Wahi 'Iqra' lekar aana.",
                "Hazrat Musa, Hazrat Isa, Hazrat Ibrahim aur tamam Nabiyon ke paas Wahi lana.",
                "Shab-e-Me'raj mein Nabi Kareem (S.A.W.) ke hamrah Sidratul Muntaha tak jana.",
                "Ghazwa-e-Badr aur digar ma'arkon mein Musalmano ki madad ke liye farishton ki qayadat karna.",
                "Lailatul Qadr (Shab-e-Qadr) mein farishton ke lashkar ke sath zameen par nazil hona."
            ),
            quranAyahArabic = "قُلْ مَن كَانَ عَدُوًّۭا لِّجِبْرِيلَ فَإِنَّهُۥ نَزَّلَهُۥ عَلَىٰ قَلْبِكَ بِإِذْنِ ٱللَّهِ مُصَدِّقًۭا لِّمَا بَيْنَ يَدَيْهِ وَهُدًۭى وَبُشْرَىٰ لِلْمُؤْمِنِينَ",
            quranAyahTranslationUrdu = "فرما دیجیے: جو کوئی جبرائیل کا دشمن ہے تو بے شک انہوں نے ہی اس (قرآن) کو اللہ کے حکم سے آپ کے دل پر اتارا ہے۔",
            quranAyahTranslationHindi = "फ़रमा दीजिए: जो कोई जिब्रील का दुश्मन हो तो यक़ीनन उन्होंने ही इस (क़ुरआन) को अल्लाह के हुक्म से आपके दिल पर उतारा है।",
            quranSurahReference = "Surah Al-Baqarah (2:97) & Surah Ash-Shu'ara (26:193)",
            hadithReference = "Sahih Bukhari: Rasoolullah (S.A.W.) ne Jibreel (A.S.) ko unki asli shakal mein dekha jinke 600 par the.",
            category = "Chaar Muqarrab",
            specialCharacteristics = "Tamam farishton ke sardar hain, quwwat aur amant ke aala tareen martabe par faiz hain."
        ),

        // 2. Mika'eel (A.S.)
        AngelEntity(
            id = "mikaeel",
            nameArabic = "مِيكَائِيل عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Mika'eel (A.S.)",
            nameHindi = "हज़रत मीकाईल (अ.स.)",
            nameUrdu = "حضرت میکائیل علیہ السلام",
            title = "Malak al-Arzaq (رزق و باراں کے نگران)",
            primaryDutyHinglish = "Makhlooq tak rizaq pahunchana, badal chalana, barish barsana aur khetion ko sarsabz karna.",
            primaryDutyHindi = "मख़लूक़ तक रिज़्क़ (आहार) पहुँचाना, बादल चलाना, बारिश बरसाना और खेती-बाड़ी व क़ुदरती निज़ाम की निगरानी।",
            primaryDutyUrdu = "تمام مخلوقات تک رزق پہنچانا، بارش برسانا، بادل چلانا اور نباتات و ہواؤں کے قدرتی نظام کی تدبیر۔",
            detailedResponsibilities = listOf(
                "Allah ke hukm se badalon ko mukhtalif ilaqon tak le jana aur qatre qatre ka hisab rakhna.",
                "Har insan, janwar, parinde aur kide tak unke muqarrar waqt par rizaq pahunchana.",
                "Daryaon, samandaron aur chashmon ke behne ke nizam ki dekh-bhal karna.",
                "Ghazwa-e-Badr mein lashkar-e-mala'ikah mein shareek hokar haq ki nusrat karna."
            ),
            quranAyahArabic = "مَن كَانَ عَدُوًّۭا لِّلَّهِ وَمَلَٰٓئِكَتِهِۦ وَرُسُلِهِۦ وَجِبْرِيلَ وَمِيكَىٰلَ فَإِنَّ ٱللَّهَ عَدُوٌّۭ لِّلْكَٰفِرِينَ",
            quranAyahTranslationUrdu = "جو کوئی اللہ اور اس کے فرشتوں اور اس کے رسولوں اور جبرائیل اور میکائیل کا دشمن ہو، تو بے شک اللہ ایسے کافروں کا دشمن ہے۔",
            quranAyahTranslationHindi = "जो कोई अल्लाह, उसके फ़रिश्तों, उसके रसूलों, जिब्रील और मीकाईल का दुश्मन हो, तो बेशक अल्लाह काफ़िरों का दुश्मन है।",
            quranSurahReference = "Surah Al-Baqarah (2:98)",
            hadithReference = "Musnad Ahmad: Rasoolullah (S.A.W.) ne farmaya jab se Jahannam paida ki gayi hai, Mika'eel kabhi muskuraye nahi.",
            category = "Chaar Muqarrab",
            specialCharacteristics = "Rehmat aur rizaq ke farishte hain jinke sath be-shumar farishte badalon aur qatrat ki nigrani karte hain."
        ),

        // 3. Israfeel (A.S.)
        AngelEntity(
            id = "israfeel",
            nameArabic = "إِسْرَافِيل عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Israfeel (A.S.)",
            nameHindi = "हज़रत इसराफ़ील (अ.स.)",
            nameUrdu = "حضرت اسرافیل علیہ السلام",
            title = "Sahib al-Soor (صاحبِ صور • The Trumpet Blower)",
            primaryDutyHinglish = "Qayamat ke aane par 'Soor' phoonkna jisse sari kainaat fana ho jayegi, aur doobara phoonk kar sabko zinda karna.",
            primaryDutyHindi = "क़यामत आने पर 'सूर' फूँकना जिससे पूरी कायनात फ़ना हो जाएगी, और दोबारा फूँक कर तमाम मख़लूक़ को ज़िंदा करना।",
            primaryDutyUrdu = "قیامت کے وقت صور پھونکنا جس سے پوری کائنات فنا ہو جائے گی، اور دوبارہ صور پھونک کر سب کو دوبارہ زندہ کرنا۔",
            detailedResponsibilities = listOf(
                "Soor ko munh se lagaye Allah ke hukm ke muntazir hain (Nafkhatul Faza / Maut).",
                "Pehle Soor par aasmaan o zameen ke tamam jandar behosh/fana ho jayenge.",
                "Dusre Soor par (Nafkhatul Qiyam) har insan apni qabar se aalame-barzakh se uth khada hoga.",
                "Lauh-e-Mahfooz se ahkaam hasil karke digar farishton tak muntaqil karna."
            ),
            quranAyahArabic = "وَنُفِخَ فِى ٱلصُّورِ فَصَعِقَ مَن فِى ٱلسَّمَٰوَٰتِ وَمَن فِى ٱلْأَرْضِ إِلَّا مَن شَآءَ ٱللَّهُ ۖ ثُمَّ نُفِخَ فِيهِ أُخْرَىٰ فَإِذَا هُمْ قِيَامٌۭ يَنظُرُونَ",
            quranAyahTranslationUrdu = "اور صور پھونکا جائے گا تو آسمانوں اور زمین میں جو کوئی ہے سب بے ہوش ہو کر گر پڑیں گے سوائے جسے اللہ چاہے، پھر دوبارہ صور پھونکا جائے گا تو وہ فوراً کھڑے ہو کر دیکھ رہے ہوں گے۔",
            quranAyahTranslationHindi = "और जब सूर फूँका जाएगा तो जो कोई आसमानों और ज़मीन में है सब बेहोश (फ़ना) हो जाएँगे सिवाय उसके जिसे अल्लाह चाहे, फिर दोबारा फूँका जाएगा तो अचानक सब उठ खड़े होकर देखने लगेंगे।",
            quranSurahReference = "Surah Az-Zumar (39:68) & Surah Al-Kahf (18:99)",
            hadithReference = "Sunan Tirmidhi: Rasoolullah (S.A.W.) ne farmaya: 'Main kaise aasaish se rahu jabke Soor wale farishte ne Soor munh me le rakha hai.'",
            category = "Chaar Muqarrab",
            specialCharacteristics = "Hamesha Arsh ke samne sar jhukaye Allah ke Kun (Hukm) ke muntazir rehte hain."
        ),

        // 4. Malak al-Mawt / Izra'eel (A.S.)
        AngelEntity(
            id = "izraeel",
            nameArabic = "مَلَكُ ٱلْمَوْتِ (عَزْرَائِيل)",
            nameRoman = "Malak al-Mawt (Hazrat Izra'eel A.S.)",
            nameHindi = "मलकुल मौत (हज़रत इज़राईल अ.स.)",
            nameUrdu = "ملک الموت (حضرت عزرائیل علیہ السلام)",
            title = "Qabiz al-Arwah (قابض الارواح • Angel of Death)",
            primaryDutyHinglish = "Allah ke tay shuda waqt par har insan aur jandar ki rooh qabz karna.",
            primaryDutyHindi = "अल्लाह के मुक़र्रर किए हुए तय वक़्त पर हर इंसान और जानदार की रूह क़ब्ज़ (निकालना) करना।",
            primaryDutyUrdu = "مقررہ وقت پر انسان اور کائنات کی تمام ذی روح مخلوقات کی روح قبض کرنا۔",
            detailedResponsibilities = listOf(
                "Nek aur momin bandon ki rooh nihayat narmi aur ahtiram ke sath mashk ki khushboo mein nikalna.",
                "Gunahgaron aur zalimon ki rooh sakhti ke sath nikalna.",
                "Inke matahat 'Nashitat' (narmi se nikalne wale) aur 'Nazi'at' (sakhti se khinchne wale) farishte kaam karte hain.",
                "Kainaat ki har basti aur ghar par rozana nigah daalna."
            ),
            quranAyahArabic = "قُلْ يَتَوَفَّىٰكُم مَّلَكُ ٱلْمَوْتِ ٱلَّذِى وُكِّلَ بِكُمْ ثُمَّ إِلَىٰ رَبِّكُمْ تُرْجَعُونَ",
            quranAyahTranslationUrdu = "فرما دیجیے: موت کا فرشتہ جو تم پر مقرر کیا گیا ہے تمہاری جانیں قبض کرے گا، پھر تم اپنے رب کی طرف لوٹائے جاؤ گے۔",
            quranAyahTranslationHindi = "फ़रमा दीजिए: मौत का फ़रिश्ता जो तुम पर मुक़र्रर किया गया है तुम्हारी जान क़ब्ज़ करेगा, फिर तुम अपने रब की तरफ़ लौटाए जाओगे।",
            quranSurahReference = "Surah As-Sajdah (32:11) & Surah An-Nazi'at (79:1-2)",
            hadithReference = "Musnad Ahmad: Momin ki rooh aise nikalti hai jaise mashkize se paani ka qatra aasaani se dhalta hai.",
            category = "Chaar Muqarrab",
            specialCharacteristics = "Poori zameen inke samne aisi hai jaise kisi ke samne dastarkhwan ho jisme se jo chahe utha le."
        ),

        // 5. Kiraman Katibeen (Raqeeb o Ateed)
        AngelEntity(
            id = "kiraman_katibeen",
            nameArabic = "كِرَامًا كَاتِبِينَ (رَقِيب وَعَتِيد)",
            nameRoman = "Kiraman Katibeen (Raqeeb & Ateed)",
            nameHindi = "किरामन कातिबीन (रक़ीब व अतीद)",
            nameUrdu = "کراماً کاتبین (رقیب اور عتید)",
            title = "Aamaal Nigran (اعمال لکھنے والے معزز فرشتے)",
            primaryDutyHinglish = "Har insan ke nek aur bad aamaal ko hamesha mehfooz aur darj karna.",
            primaryDutyHindi = "हर इंसान के अच्छे (नेक) और बुरे आमाल को हमेशा महफ़ूज़ व दर्ज (रिकॉर्ड) करना।",
            primaryDutyUrdu = "ہر انسان کے دائیں اور بائیں شانے پر رہ کر نیکیوں اور برائیوں کا اعمال نامہ تحریر کرنا۔",
            detailedResponsibilities = listOf(
                "Dahine (Right) shane ka farishta nekiyan aur husn-e-aamaal foran likhta hai.",
                "Bayen (Left) shane ka farishta gunah foran nahi likhta, balke tauba ke liye muhlat deta hai.",
                "Qayamat ke din yehi farishte insaan ke aamaal nama le kar gawah bankar hazir honge.",
                "Insan ke zaban se nikla hua har lafz inki nigrani mein darj hota hai."
            ),
            quranAyahArabic = "وَإِنَّ عَلَيْكُمْ لَحَٰفِظِينَ ۝ كِرَامًۭا كَاتِبِينَ ۝ يَعْلَمُونَ مَا تَفْعَلُونَ",
            quranAyahTranslationUrdu = "اور بے شک تم پر نگہبان مقرر ہیں، معزز لکھنے والے، جو کچھ تم کرتے ہو وہ سب جانتے ہیں۔",
            quranAyahTranslationHindi = "और बेशक तुम पर निगहबान मुक़र्रर हैं, मुअज़्ज़ज़ (इज़्ज़तदार) लिखने वाले, जो कुछ तुम करते हो वे सब जानते हैं।",
            quranSurahReference = "Surah Al-Infitar (82:10-12) & Surah Qaf (50:17-18)",
            hadithReference = "Mu'jam al-Kabeer: Dahina farishta bayen farishte ka ameer hai; jab banda gunah karta hai to dahina kehta hai 6 ghante ruko shayad tauba kar le.",
            category = "Aamaal o Qabar",
            specialCharacteristics = "Nihayat ba-adab aur sachhe kuraar hain jo har waqt insan ke hum-rah rehte hain."
        ),

        // 6. Munkar aur Nakeer
        AngelEntity(
            id = "munkar_nakeer",
            nameArabic = "مُنكَرٌ وَنَكِيرٌ",
            nameRoman = "Munkar & Nakeer",
            nameHindi = "मुनकर और नकीर",
            nameUrdu = "منکر اور نکیر",
            title = "Sawaal-e-Qabar ke Farishte (فرشتگانِ سوالِ قبر)",
            primaryDutyHinglish = "Qabar mein dafan ke baad murde se teen ahem imtihani sawaal poochna.",
            primaryDutyHindi = "क़ब्र में दफ़्न के बाद मैय्यत से तीन अहम इम्तिहानी सवाल पूछना।",
            primaryDutyUrdu = "قبر میں تدفین کے بعد ہر انسان سے رب، دین اور رسول کے بارے میں سوالات کرنا۔",
            detailedResponsibilities = listOf(
                "Pehla Sawaal: 'مَنْ رَبُّكَ؟' (Tera Rab kaun hai?).",
                "Doosra Sawaal: 'مَا دِينُكَ؟' (Tera deen kya hai?).",
                "Teesra Sawaal: 'مَا كُنْتَ تَقُولُ فِي هَذَا الرَّجُلِ؟' (Hazrat Muhammad SAW ke bare me tu kya aqeedah rakhta tha?).",
                "Momin bande ko Jannat ki khidki khol kar aaraam ki basharat dena.",
                "Munafiq aur kafir ko unke inkar par saza aur azaab shuru hona."
            ),
            quranAyahArabic = "يُثَبِّتُ ٱللَّهُ ٱلَّذِينَ ءَامَنُوا۟ بِٱلْقَوْلِ ٱلثَّابِتِ فِى ٱلْحَيَوٰةِ ٱلدُّنْيَا وَفِى ٱلْآخِرَةِ ۖ",
            quranAyahTranslationUrdu = "اللہ ایمان والوں کو پکی بات (کلمہ طیبہ) کے ذریعے دنیا کی زندگی میں اور آخرت (قبر) میں ثابت قدم رکھتا ہے۔",
            quranAyahTranslationHindi = "अल्लाह ईमान वालों को पक्की बात (कलिमा तय्यिबा) के ज़रिए दुनिया की ज़िंदगी में और आख़िरत (क़ब्र) में साबित-क़दम रखता है।",
            quranSurahReference = "Surah Ibrahim (14:27)",
            hadithReference = "Sunan Tirmidhi: Do neeli aakhon wale aur siyaah rang ke farishte aate hain jinhe Munkar aur Nakeer kaha jata hai.",
            category = "Aamaal o Qabar",
            specialCharacteristics = "Nihayat haibat-nak aur azeem roop mein aakar haq o batil ki aazmaish karte hain."
        ),

        // 7. Hazrat Malik (A.S.)
        AngelEntity(
            id = "malik",
            nameArabic = "مَالِك عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Malik (A.S.)",
            nameHindi = "हज़रत मालिक (अ.स.)",
            nameUrdu = "حضرت مالک علیہ السلام",
            title = "Khazin al-Naar (خازنِ جہنم • Keeper of Hell)",
            primaryDutyHinglish = "Jahannam (Dozakh) ke nizam aur azaab ke farishton (Zabaniyah) ki sarbarahi.",
            primaryDutyHindi = "जहन्नम (दोज़ख़) के निज़ाम और अज़ाब के फ़रिश्तों (ज़बानिया) की सरबराही व निगरानी।",
            primaryDutyUrdu = "دوزخ کے داروغہ اور جہنم کے عذاب پر مامور فرشتوں (زبانیہ) کے سربراہ۔",
            detailedResponsibilities = listOf(
                "Jahannam ke darwazon aur uske tabqon ki nigrani.",
                "Dozakhi jab azaab se tang aakar pukaarenge to unhe jawab dena.",
                "19 azeem-ush-shaan farishte (Zabaniyah) inke zere-qayadat Jahannam par muqarrar hain.",
                "Kabhi muskurate nahi aur nihayat sakht aur roab-dar hain."
            ),
            quranAyahArabic = "وَنَادَوْا۟ يَٰمَٰلِكُ لِيَقْضِ عَلَيْنَا رَبُّكَ ۖ قَالَ إِنَّكُم مَّٰكِثُونَ",
            quranAyahTranslationUrdu = "اور وہ پکاریں گے: اے مالک! تیرا رب ہمارا کام ہی تمام کر دے! وہ فرمائیں گے: تمہیں تو اب اسی حالت میں رہنا ہے۔",
            quranAyahTranslationHindi = "और वे पुकारेंगे: ऐ मालिक! तेरा रब हमारा काम ही तमाम कर दे! वह फ़रमाएँगे: तुम्हें तो हमेशा इसी हाल में रहना है।",
            quranSurahReference = "Surah Az-Zukhruf (43:77) & Surah Al-Muddaththir (74:30)",
            hadithReference = "Sahih Bukhari: Shab-e-Me'raj mein Rasoolullah (S.A.W.) ne Malik (A.S.) ko dekha jo ghamgeen aur pur-jalal the.",
            category = "Jannat o Jahannam",
            specialCharacteristics = "Allah ke ehkaam ki tameel mein ratti barabar kami nahi karte aur nihayat taqatwar hain."
        ),

        // 8. Hazrat Ridwan (A.S.)
        AngelEntity(
            id = "ridwan",
            nameArabic = "رِضْوَان عَلَيْهِ ٱلسَّلَامُ",
            nameRoman = "Hazrat Ridwan (A.S.)",
            nameHindi = "हज़रत रिज़वान (अ.स.)",
            nameUrdu = "حضرت رضوان علیہ السلام",
            title = "Khazin al-Jannah (خازنِ جنت • Keeper of Paradise)",
            primaryDutyHinglish = "Jannat ke darwazon aur azeem ne'maton ki nigrani aur ahl-e-jannat ka istiqbal.",
            primaryDutyHindi = "जन्नत के दरवाज़ों और अज़ीम नेमतों की निगरानी और अहले-जन्नत (जन्नत वालों) का शानदार इस्तक़बाल।",
            primaryDutyUrdu = "جنت کے داروغہ اور اہل ایمان کا خوش آمدید کہہ کر جنت میں استقبال کرنا۔",
            detailedResponsibilities = listOf(
                "Jannat ke 8 darwazon ki hifazat aur intezam.",
                "Momin bandon par Salamti ki nida pesh karna: 'Salamun Alaikum Tibtum'.",
                "Jannati mahlon aur khidmatgar farishton ki dekh-bhal.",
                "Hamesha khush-ikhlaq, noorani aur bashashat ke aalam mein rehna."
            ),
            quranAyahArabic = "وَسِيقَ ٱلَّذِينَ ٱتَّقَوْا۟ رَبَّهُمْ إِلَى ٱلْجَنَّةِ زُمَرًا ۖ حَتَّىٰٓ إِذَا جَآءُوهَا وَفُتِحَتْ أَبْوَٰبُهَا وَقَالَ لَهُمْ خَزَنَتُهَا سَلَٰمٌ عَلَيْكُمْ طِبْتُمْ فَٱدْخُلُوهَا خَٰلِدِينَ",
            quranAyahTranslationUrdu = "اور جو لوگ اپنے رب سے ڈرتے رہے انہیں گروہ در گروہ جنت کی طرف لے جایا جائے گا، یہاں تک کہ جب وہ اس کے پاس پہنچیں گے اور اس کے دروازے کھولے جائیں گے اور اس کے نگہبان ان سے کہیں گے: تم پر سلامتی ہو، تم اچھے رہے، پس اس میں ہمیشہ رہنے کے لیے داخل ہو جاؤ۔",
            quranAyahTranslationHindi = "और जो अपने रब से डरते रहे उन्हें गिरोह दर गिरोह जन्नत की तरफ़ ले जाया जाएगा, यहाँ तक कि जब वे वहाँ पहुँचेंगे और उसके दरवाज़े खोल दिए जाएँगे और उसके निगहबान उनसे कहेंगे: तुम पर सलामती हो, तुम पाकीज़ा रहे, पस इसमें हमेशा रहने के लिए दाख़िल हो जाओ।",
            quranSurahReference = "Surah Az-Zumar (39:73)",
            hadithReference = "Ibn Kathir & Tabarani: Jannat ke sabse bade daroghah ka naam Ridwan hai jinka chehra noor se roshan hai.",
            category = "Jannat o Jahannam",
            specialCharacteristics = "Raza-e-Ilaahi aur rehmat ka paikar hain, jannat ki tamaam ne'maton ke kafil hain."
        ),

        // 9. Hamalat al-Arsh (حملة العرش)
        AngelEntity(
            id = "hamalat_arsh",
            nameArabic = "حَمَلَةُ ٱلْعَرْشِ",
            nameRoman = "Hamalat al-Arsh",
            nameHindi = "हमलतुल अर्श (अर्श उठाने वाले फ़रिश्ते)",
            nameUrdu = "حملۃ العرش (عرش اٹھانے والے فرشتے)",
            title = "Arsh-e-Azeem ke Hamil Farishte",
            primaryDutyHinglish = "Allah Ta'ala ke azeem Arsh ko uthana aur har waqt Tasbeeh o Tahmeed mein mashghool rehna.",
            primaryDutyHindi = "अल्लाह तआला के अज़ीम अर्श को उठाना और हर वक़्त तस्बीह व तहमीद (अल्लाह की पाकी व तारीफ़) में मश्ग़ूल रहना।",
            primaryDutyUrdu = "اللہ تعالیٰ کے عرشِ عظیم کو اٹھانا اور شب و روز اللہ کی حمد و تسبیح بیان کرنا۔",
            detailedResponsibilities = listOf(
                "Dunya mein Arsh ko 4 azeem farishte uthaye hue hain.",
                "Qayamat ke din inki tadad 8 azeem farishte hogi.",
                "Ehl-e-Imaan ki maghfirat aur hidayat ke liye duayein mangte hain.",
                "Inki jussamat aur azeem quwwat ka tasawwur bhi insan ke bas se bahar hai."
            ),
            quranAyahArabic = "ٱلَّذِينَ يَحْمِلُونَ ٱلْعَرْشَ وَمَنْ حَوْلَهُۥ يُسَبِّحُونَ بِحَمْدِ رَبِّهِمْ وَيُؤْمِنُونَ بِهِۦ وَيَسْتَغْفِرُونَ لِلَّذِينَ ءَامَنُوا۟",
            quranAyahTranslationUrdu = "وہ فرشتے جو عرش کو اٹھائے ہوئے ہیں اور جو اس کے اردگرد ہیں اپنے رب کی حمد کے ساتھ تسبیح کرتے ہیں اور اس پر ایمان رکھتے ہیں اور مومنوں کے لیے مغفرت طلب کرتے ہیں۔",
            quranAyahTranslationHindi = "जो फ़रिश्ते अर्श को उठाए हुए हैं और जो उसके गिर्द हैं, वे अपने रब की हम्द के साथ तस्बीह करते हैं और उस पर ईमान रखते हैं और मोमिनों के लिए बख्शिश तलब करते हैं।",
            quranSurahReference = "Surah Ghafir (40:7) & Surah Al-Haqqah (69:17)",
            hadithReference = "Sunan Abi Dawood: Rasoolullah (S.A.W.) ne farmaya: 'Mujhe Arsh uthane wale farishte ke bare me batane ki ijazat di gayi, unke kaan ki lou se kandhe tak ka fasla 700 saal ki musafat hai.'",
            category = "Nizam-e-Kainat",
            specialCharacteristics = "Kainaat ki sabse azeem tareen jussamat aur quwwat rakhne wali makhlooq hain."
        ),

        // 10. Mu'aqqibat (Hifazat Karne Wale Farishte)
        AngelEntity(
            id = "muaqqibat",
            nameArabic = "ٱلْمُعَقِّبَاتُ",
            nameRoman = "Al-Mu'aqqibat",
            nameHindi = "अल-मुअक़्क़िबात (हिफ़ाज़त करने वाले फ़रिश्ते)",
            nameUrdu = "معقبات (حفاظت کرنے والے فرشتے)",
            title = "Harasatul Insan (حارِسَةُ الْإِنْسَان • Guardian Angels)",
            primaryDutyHinglish = "Har insan ke aage aur peeche se Allah ke hukm se aafat aur balaon se hifazat karna.",
            primaryDutyHindi = "हर इंसान के आगे और पीछे से अल्लाह के हुक्म से हादसों, बलाओं और शैतानी शर से हिफ़ाज़त करना।",
            primaryDutyUrdu = "انسان کے آگے اور پیچھے سے گردش کر کے اللہ کے اذن سے اس کی ناگہانی آفات سے حفاظت کرنا۔",
            detailedResponsibilities = listOf(
                "Din aur raat ke waqt badal badal kar aate hain (Subah aur Asr ki namaz mein jam'a hote hain).",
                "Jab tak taqdeer ka qazaa na aaye, insan ko gair-mutawaqqah khatron se mehfooz rakhte hain.",
                "Insan so raha ho ya jaag raha ho, uski rohani aur jismani hifazat karte hain."
            ),
            quranAyahArabic = "لَهُۥ مُعَقِّبَٰتٌۭ مِّنۢ بَيْنِ يَدَيْهِ وَمِنْ خَلْفِهِۦ يَحْفَظُونَهُۥ مِنْ أَمْرِ ٱللَّهِ ۗ",
            quranAyahTranslationUrdu = "اس کے لیے آگے اور پیچھے سے باری باری آنے والے فرشتے ہیں جو اللہ کے حکم سے اس کی حفاظت کرتے ہیں۔",
            quranAyahTranslationHindi = "उसके लिए आगे और पीछे से बारी-बारी आने वाले फ़रिश्ते हैं जो अल्लाह के हुक्म से उसकी हिफ़ाज़त करते हैं।",
            quranSurahReference = "Surah Ar-Ra'd (13:11)",
            hadithReference = "Sahih Bukhari: Raat aur din ke farishte Fajr aur Asr ki namazon mein aapas mein milte hain, phir Allah unse poochta hai Mere bandon ko kis haal me choda.",
            category = "Nizam-e-Kainat",
            specialCharacteristics = "Rehmat aur hifazat ki dhaal ban kar insan ke gird ghera banate hain."
        )
    )
}
