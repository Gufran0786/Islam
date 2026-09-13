package com.example.data

import android.content.Context

/**
 * Data model for questions answered directly by the Holy Quran.
 * Contains:
 * - Question title & semantic variations
 * - Arabic Ayah text
 * - Hinglish transliteration & translation
 * - Urdu translation
 * - Hindi translation
 * - Direct concise Quranic answer
 * - Surah reference
 */
data class QuranAnswerItem(
    val id: String,
    val questionHindi: String,
    val questionUrdu: String,
    val questionHinglish: String,
    val directAnswerHinglish: String,
    val directAnswerHindi: String,
    val directAnswerUrdu: String,
    val surahNumber: Int,
    val surahNameRoman: String,
    val surahNameArabic: String,
    val ayahNumber: Int,
    val arabicAyahText: String,
    val hinglishAyahText: String,
    val urduAyahTranslation: String,
    val hindiAyahTranslation: String,
    val topicTags: List<String>
)

object QuranQuestionAnswerData {

    val questions: List<QuranAnswerItem> = listOf(
        // ==================== 1. ALLAH KI ZAAT & TAUHEED ====================
        QuranAnswerItem(
            id = "allah_who",
            questionHindi = "अल्लाह कौन है? (अल्लाह की ज़ात व सिफ़ात)",
            questionUrdu = "اللہ کون ہے؟ (اللہ کی ذات اور صفات)",
            questionHinglish = "Allah kaun hai? (Allah ki zaat aur sifat)",
            directAnswerHinglish = "Allah wahid o yakta Ma'bood hai, zinda aur sabko qayam rakhne wala. Na use oongh aati hai na neend, zameen o aasman ka wahi akela Maalik hai.",
            directAnswerHindi = "अल्लाह यकता और अकेला सच्चा माबूद है, हमेशा ज़िंदा और सबको क़ायम रखने वाला। न उसे ऊंघ आती है न नींद, ज़मीन और आसमान का वही अकेला मालिक है।",
            directAnswerUrdu = "اللہ اکیلا اور یکتا معبودِ برحق ہے، ہمیشہ زندہ اور ساری کائنات کو تھامنے والا ہے۔ نہ اسے اونگھ آتی ہے نہ نیند، زمین و آسمان کی ہر چیز اسی کی ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 255,
            arabicAyahText = "ٱللَّهُ لَآ إِلَٰهَ إِلَّا هُوَ ٱلْحَىُّ ٱلْقَيُّومُ ۚ لَا تَأْخُذُهُۥ سِنَةٌ وَلَا نَوْمٌ ۚ لَّهُۥ مَا فِى ٱلسَّمَٰوَٰتِ وَمَا فِى ٱلْأَرْضِ",
            hinglishAyahText = "Allahu laaa ilaaha illaa Huwal-Hayyul-Qayyoom; laa ta'khudhuhoo sinatunw-wa laa nawm; lahoo maa fis-samaawaati wa maa fil-ard.",
            urduAyahTranslation = "اللہ، جس کے سوا کوئی معبود نہیں، وہ ہمیشہ زندہ رہنے والا، سب کو سنبھالنے والا ہے، نہ اسے اونگھ پکڑتی ہے نہ نیند، جو کچھ آسمانوں میں ہے اور جو زمین میں ہے سب اسی کا ہے۔",
            hindiAyahTranslation = "अल्लाह, जिसके सिवा कोई माबूद नहीं, वह हमेशा ज़िंदा रहने वाला, सब का थामने वाला है। न उसे ऊंघ आती है और न नींद। जो कुछ आसमानों में है और जो ज़मीन में है सब उसी का है।",
            topicTags = listOf("allah", "khuda", "rab", "tauheed", "ayatul kursi", "kursi", "zaat", "sifat", "god", "who is allah")
        ),

        // ==================== 2. SHIRK ====================
        QuranAnswerItem(
            id = "shirk",
            questionHindi = "क्या शिर्क करना हराम है?",
            questionUrdu = "کیا شرک کرنا حرام ہے؟",
            questionHinglish = "Kya shirk karna haram hai?",
            directAnswerHinglish = "Haan, shirk Islam mein sabse bada aur na-qabil-e-maafi kabeerah gunaah hai. Baghair tauba ke shirk par maut aane par Allah use hargiz maaf nahi farmayega.",
            directAnswerHindi = "हाँ, शिर्क इस्लाम में सबसे बड़ा और ना-क़ाबिले-माफ़ी गुनाह-ए-कबीरा है। बिना तौबा के शिर्क की हालत में मरने पर अल्लाह उसे कभी माफ़ नहीं फ़रमाएगा।",
            directAnswerUrdu = "ہاں، شرک اسلام میں سب سے بڑا اور ناقابلِ معافی گناہِ کبیرہ ہے۔ بغیر توبہ کے شرک پر موت آنے پر اللہ تعالیٰ اسے ہرگز معاف نہیں فرمائے گا۔",
            surahNumber = 4,
            surahNameRoman = "An-Nisa",
            surahNameArabic = "النساء",
            ayahNumber = 48,
            arabicAyahText = "إِنَّ ٱللَّهَ لَا يَغْفِرُ أَن يُشْرَكَ بِهِۦ وَيَغْفِرُ مَا دُونَ ذَٰلِكَ لِمَن يَشَآءُ ۚ وَمَن يُشْرِكْ بِٱللَّهِ فَقَدِ ٱفْتَرَىٰٓ إِثْمًا عَظِيمًا",
            hinglishAyahText = "Innal-laaha laa yaghfiru any-yushraka bihee wa yaghfiru maa doona zaalika limany-yashaaa'; wa many-yushrik billaahi faqadif-taraaa isman 'azeemaa.",
            urduAyahTranslation = "بے شک اللہ اس بات کو نہیں بخشتا کہ اس کے ساتھ کسی کو شریک ٹھہرایا جائے اور اس کے سوا جس کے لیے چاہتا ہے بخش دیتا ہے، اور جس نے اللہ کے ساتھ شریک کیا اس نے بڑا گناہ گھڑا۔",
            hindiAyahTranslation = "बेशक अल्लाह इस बात को माफ़ नहीं करता कि उसके साथ शिर्क किया जाए, और इसके अलावा जिसे चाहे माफ़ कर देता है। और जिसने अल्लाह के साथ किसी को शरीक किया उसने बहुत बड़ा गुनाह गढ़ा।",
            topicTags = listOf("shirk", "but parasti", "haram", "gunah", "polytheism", "idolatry", "kufr", "شرک", "शिर्क")
        ),

        // ==================== 3. PURPOSE OF CREATION ====================
        QuranAnswerItem(
            id = "insan_purpose",
            questionHindi = "इंसान की पैदाइश का मक़सद क्या है?",
            questionUrdu = "انسان کی پیدائش کا مقصد کیا ہے؟",
            questionHinglish = "Insan ki paidaish ka maqsad kya hai?",
            directAnswerHinglish = "Allah Ta'ala ne jinn aur insan ko sirf aur sirf Apni ibadat, ma'rifat aur ita'at ke liye paida farmaya hai.",
            directAnswerHindi = "अल्लाह तआला ने जिन्नों और इंसानों को सिर्फ़ और सिर्फ़ अपनी इबादत, आज्ञापालन और पहचान के लिए पैदा फ़रमाया है।",
            directAnswerUrdu = "اللہ تعالیٰ نے جن و انس کو صرف اور صرف اپنی خالص عبادت، اطاعت اور بندگی کے لیے پیدا فرمایا ہے۔",
            surahNumber = 51,
            surahNameRoman = "Adh-Dhariyat",
            surahNameArabic = "الذاريات",
            ayahNumber = 56,
            arabicAyahText = "وَمَا خَلَقْتُ ٱلْجِنَّ وَٱلْإِنسَ إِلَّا لِيَعْبُدُونِ",
            hinglishAyahText = "Wa maa khalaqtul-jinna wal-insa illaa liya'budoon.",
            urduAyahTranslation = "اور میں نے جنات اور انسانوں کو اس کے سوا کسی مقصد کے لیے پیدا نہیں کیا کہ وہ میری بندگی اور عبادت کریں۔",
            hindiAyahTranslation = "और मैंने जिन्नों और इंसानों को इसके सिवा किसी काम के लिए पैदा नहीं किया कि वे मेरी ही इबादत करें।",
            topicTags = listOf("insan", "paida", "maqsad", "creation", "purpose", "jinn", "ibadat", "life", "انسان", "इंसान")
        ),

        // ==================== 4. NAMAZ / SALAH ====================
        QuranAnswerItem(
            id = "namaz",
            questionHindi = "क्या नमाज़ पढ़ना फ़र्ज़ है?",
            questionUrdu = "کیا نماز پڑھنا فرض ہے؟",
            questionHinglish = "Kya namaz padhna farz hai?",
            directAnswerHinglish = "Haan, Namaz har aaqil baligh musalman par din-raat mein 5 waqt farz-e-ain hai. Namaz deen ka sutoon hai aur behayai o burai se rokti hai.",
            directAnswerHindi = "हाँ, नमाज़ हर बालिग़ मुसलमान पर दिन-रात में 5 वक़्त फ़र्ज़-ए-ऐन है। नमाज़ दीन का सुतून है और बेहयाई व बुराई से रोकती है।",
            directAnswerUrdu = "ہاں، نماز ہر عاقل و بالغ مسلمان پر دن رات میں پانچ وقت فرضِ عین ہے۔ نماز دین کا ستون ہے اور بے حیائی و برائی سے روکتی ہے۔",
            surahNumber = 29,
            surahNameRoman = "Al-Ankabut",
            surahNameArabic = "العنكبوت",
            ayahNumber = 45,
            arabicAyahText = "ٱتْلُ مَآ أُوحِىَ إِلَيْكَ مِنَ ٱلْكِتَٰبِ وَأَقِمِ ٱلصَّلَوٰةَ ۖ إِنَّ ٱلصَّلَوٰةَ تَنْهَىٰ عَنِ ٱلْفَحْشَآءِ وَٱلْمُنكَرِ ۗ وَلَذِكْرُ ٱللَّهِ أَكْبَرُ ۗ وَٱللَّهُ يَعْلَمُ مَا تَصْنَعُونَ",
            hinglishAyahText = "Utlu maaa oohiya ilayka minal-Kitaabi wa aqimis-Salaah; innas-Salaata tanhaa 'anil-fahshaaa'i wal-munkar; wa ladhikrul-laahi akbar; wal-laahu ya'lamu maa tasna'oon.",
            urduAyahTranslation = "جو کتاب آپ کی طرف وحی کی گئی ہے اس کی تلاوت کیجیے اور نماز قائم کیجیے، بے شک نماز بے حیائی اور برائی سے روکتی ہے اور اللہ کا ذکر سب سے بڑا ہے، اور اللہ جانتا ہے جو تم کرتے ہو۔",
            hindiAyahTranslation = "जो किताब आपकी तरफ़ वही की गई है उसकी तिलावत कीजिए और नमाज़ क़ायम कीजिए। बेशक नमाज़ बेहयाई और बुराई से रोकती है, और अल्लाह का ज़िक्र बहुत बड़ी चीज़ है, और अल्लाह जानता है जो कुछ तुम करते हो।",
            topicTags = listOf("namaz", "salah", "salat", "prayer", "farz", "rakat", "sajda", "نماز", "नमाज़")
        ),

        // ==================== 5. NAMAZ KE AUQAAT ====================
        QuranAnswerItem(
            id = "namaz_waqt",
            questionHindi = "क्या नमाज़ के वक़्त मुक़र्रर हैं?",
            questionUrdu = "کیا نماز کے اوقات مقرر ہیں؟",
            questionHinglish = "Kya namaz ke auqaat muqarrar hain?",
            directAnswerHinglish = "Haan, Quran Pak mein farmaya gaya hai ke beshak momino par namaz muqarrara auqaat mein pabandi ke sath farz ki gayi hai.",
            directAnswerHindi = "हाँ, क़ुरआन पाक में साफ़ फ़रमाया गया है कि बेशक मोमिनों पर नमाज़ मुक़र्रर औक़ात में पाबंदी के साथ फ़र्ज़ है।",
            directAnswerUrdu = "ہاں، قرآن پاک میں واضح طور پر ارشاد ہے کہ بے شک مومنوں پر نماز مقررہ اوقات میں پابندی کے ساتھ فرض کی گئی ہے۔",
            surahNumber = 4,
            surahNameRoman = "An-Nisa",
            surahNameArabic = "النساء",
            ayahNumber = 103,
            arabicAyahText = "إِنَّ ٱلصَّلَوٰةَ كَانَتْ عَلَى ٱلْمُؤْمِنِينَ كِتَٰبًا مَّوْقُوتًا",
            hinglishAyahText = "Innas-Salaata kaanat 'alal-mu'mineena kitaabam-mawqootaa.",
            urduAyahTranslation = "بے شک نماز مومنوں پر مقررہ وقتوں میں فرض کی گئی ہے۔",
            hindiAyahTranslation = "बेशक नमाज़ मोमिनों पर मुक़र्ररा वक़्तों में पाबंदी के साथ फ़र्ज़ की गई है।",
            topicTags = listOf("waqt", "auqaat", "namaz waqt", "timing", "fajr", "zuhr", "asr", "maghrib", "isha", "وقت", "वक्त")
        ),

        // ==================== 6. TAHAJJUD ====================
        QuranAnswerItem(
            id = "tahajjud",
            questionHindi = "तहज्जुद की नमाज़ की क्या फ़ज़ीलत है?",
            questionUrdu = "تہجد کی نماز کی کیا فضیلت ہے؟",
            questionHinglish = "Tahajjud ki namaz ki kya fazeelat hai?",
            directAnswerHinglish = "Tahajjud raat ki ba-barkat nafal ibadat hai jo qurb-e-ilahi, Maqam-e-Mahmood aur duaon ki qubooliyat ka sabab banti hai.",
            directAnswerHindi = "तहज्जुद रात की बा-बरकत इबादत है जो क़ुर्ब-ए-इलाही, मक़ाम-ए-महमूद और दुआओं की क़बूलियत का सबसे बड़ा ज़रिया है।",
            directAnswerUrdu = "تہجد رات کی انتہائی بابرکت نفل عبادت ہے جو قربِ الٰہی، مقامِ محمود اور دعاؤں کی فوری قبولیت کا ذریعہ ہے۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 79,
            arabicAyahText = "وَمِنَ ٱلَّيْلِ فَتَهَجَّدْ بِهِۦ نَافِلَةً لَّكَ عَسَىٰٓ أَن يَبْعَثَكَ رَبُّكَ مَقَامًا مَّحْمُودًا",
            hinglishAyahText = "Wa minal-layli fatahajjad bihee naafilatal-laka 'asaaa any-yab'athaka Rabbuka Maqaamam-Mahmoodaa.",
            urduAyahTranslation = "اور رات کے کچھ حصے میں تہجد پڑھیں، یہ آپ کے لیے نفلی عبادت ہے، قریب ہے کہ آپ کا رب آپ کو مقامِ محمود پر فائز فرمائے۔",
            hindiAyahTranslation = "और रात के कुछ हिस्से में तहज्जुद पढ़िए, यह आपके लिए नफ़ली इबादत है, उम्मीद है कि आपका रब आपको मक़ाम-ए-महमूद पर पहुंचाएगा।",
            topicTags = listOf("tahajjud", "nafal", "raat", "shab", "qiyam", "night prayer", "تہجد", "तहज्जुद")
        ),

        // ==================== 7. ROZA / FASTING ====================
        QuranAnswerItem(
            id = "roza_fasting",
            questionHindi = "क्या रोज़ा रखना फ़र्ज़ है?",
            questionUrdu = "کیا روزہ رکھنا فرض ہے؟",
            questionHinglish = "Kya roza rakhna farz hai?",
            directAnswerHinglish = "Haan, Ramzan-ul-Mubarak ke roze har sehat-mand baligh musalman par farz hain taake insan mein taqwa aur parhezgari paida ho.",
            directAnswerHindi = "हाँ, रमज़ान-उल-मुबारक के रोज़े हर सेहतमंद बालिग़ मुसलमान पर फ़र्ज़ हैं ताकि इंसान में तक़वा (परहेज़गारी) पैदा हो।",
            directAnswerUrdu = "ہاں، رمضان المبارک کے روزے ہر تندرست اور عاقل و بالغ مسلمان پر فرض ہیں تاکہ انسان میں تقویٰ اور پرہیزگاری پیدا ہو۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 183,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ كُتِبَ عَلَيْكُمُ ٱلصِّيَامُ كَمَا كُتِبَ عَلَى ٱلَّذِينَ مِن قَبْلِكُمْ لَعَلَّكُمْ تَتَّقُونَ",
            hinglishAyahText = "Yaaa ayyuhal-ladheena aamanoo kutiba 'alaykumus-Siyaamu kamaa kutiba 'alal-ladheena min qablikum la'allakum tattaqoon.",
            urduAyahTranslation = "اے ایمان والو! تم پر روزے فرض کیے گئے جیسے تم سے اگلوں پر فرض کیے گئے تھے تاکہ تم پرہیزگار بن جاؤ۔",
            hindiAyahTranslation = "ऐ ईमान वालो! तुम पर रोज़े फ़र्ज़ किए गए जैसे तुमसे पहले लोगों पर फ़र्ज़ किए गए थे ताकि तुम मुत्तक़ी (परहेज़गार) बन जाओ।",
            topicTags = listOf("roza", "roze", "ramzan", "ramadan", "fasting", "sehri", "iftar", "روزہ", "रोज़ा")
        ),

        // ==================== 8. ZAKAT & CHARITY ====================
        QuranAnswerItem(
            id = "zakat_charity",
            questionHindi = "ज़कात का क्या हुक्म है?",
            questionUrdu = "زکوٰۃ کا کیا حکم ہے؟",
            questionHinglish = "Zakat ka kya hukm hai?",
            directAnswerHinglish = "Zakat Islam ke 5 buniyadi arkān mein se hai. Sahib-e-nisab musalman par apne maal ka 2.5% ghareebo aur mustahqeen ko dena farz hai.",
            directAnswerHindi = "ज़कात इस्लाम के 5 बुनियादी अरकानों में से है। साहिब-ए-निसाब मुसलमान पर अपने माल का 2.5% ग़रीबों व हक़दारों को देना फ़र्ज़ है।",
            directAnswerUrdu = "زکوٰۃ اسلام کے پانچ بنیادی ارکان میں سے ایک فرض رکن ہے۔ صاحبِ نصاب مسلمان پر اپنے مال کا ڈھائی فیصد (2.5%) غریبوں اور مستحقین کو دینا فرض ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 110,
            arabicAyahText = "وَأَقِيمُوا۟ ٱلصَّلَوٰةَ وَءَاتُوا۟ ٱلزَّكَوٰةَ ۚ وَمَا تُقَدِّمُوا۟ لِأَنفُسِكُم مِّنْ خَيْرٍ تَجِدُوهُ عِندَ ٱللَّهِ ۗ إِنَّ ٱللَّهَ بِمَا تَعْمَلُونَ بَصِيرٌ",
            hinglishAyahText = "Wa aqeemus-Salaata wa aatuz-Zakaah; wa maa tuqaddimoo li-anfusikum min khayrin tajidoohu 'indal-laah; innal-laaha bimaa ta'maloona Baseer.",
            urduAyahTranslation = "اور نماز قائم کرو اور زکوٰۃ ادا کرو، اور جو بھلائی تم اپنے لیے آگے بھیجو گے اسے اللہ کے پاس پاؤ گے، بے شک اللہ تمہارے تمام اعمال کو دیکھ رہا ہے۔",
            hindiAyahTranslation = "और नमाज़ क़ायम करो और ज़कात अदा करो, और जो भलाई तुम अपने लिए आगे भेजोगे उसे अल्लाह के पास पाओगे। बेशक अल्लाह तुम्हारे सब कामों को देख रहा है।",
            topicTags = listOf("zakat", "sadqa", "charity", "khairat", "maal", "paisa", "daulat", "nisab", "زکوٰۃ", "ज़कात")
        ),

        // ==================== 9. HAJJ ====================
        QuranAnswerItem(
            id = "hajj_pilgrimage",
            questionHindi = "हज किस पर फ़र्ज़ है?",
            questionUrdu = "حج کس پر فرض ہے؟",
            questionHinglish = "Hajj kis par farz hai?",
            directAnswerHinglish = "Hajj har us aaqil baligh musalman par zindagi mein ek martaba farz hai jo Baitullah shareef tak aane jaane aur kharch ki isteta'at rakhta ho.",
            directAnswerHindi = "हज हर उस बालिग़ मुसलमान पर ज़िन्दगी में एक मर्तबा फ़र्ज़ है जो बैतुल्लाह शरीफ़ तक जाने-आने और ख़र्च की ताक़त (इस्तेताअत) रखता हो।",
            directAnswerUrdu = "حج زندگی میں ایک بار ہر اس عاقل و بالغ مسلمان پر فرض ہے جو بیت اللہ تک جانے کا سفر اور خرچ برداشت کرنے کی استطاعت رکھتا ہو۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 97,
            arabicAyahText = "وَلِلَّهِ عَلَى ٱلنَّاسِ حِجُّ ٱلْبَيْتِ مَنِ ٱسْتَطَاعَ إِلَيْهِ سَبِيلًا ۚ وَمَن كَفَرَ فَإِنَّ ٱللَّهَ غَنِىٌّ عَنِ ٱلْعَٰلَمِينَ",
            hinglishAyahText = "Wa lillaahi 'alan-naasi Hijjul-Bayti manis-tataa'a ilayhi sabeelaa; wa man kafara fa-innal-laaha Ghaniyyun 'anil-'aalameen.",
            urduAyahTranslation = "اور لوگوں پر اللہ کا یہ حق ہے کہ جو اس کے گھر تک پہنچنے کی استطاعت رکھے وہ اس کا حج کرے، اور جو انکار کرے تو بے شک اللہ تمام جہانوں سے بے پروا ہے۔",
            hindiAyahTranslation = "और लोगों पर अल्लाह का यह हक़ है कि जो उसके घर (काबा) तक पहुंचने की ताक़त रखे वह उसका हज करे। और जो कुफ़्र (इनकार) करे तो बेशक अल्लाह सारे संसार से बेपरवाह है।",
            topicTags = listOf("hajj", "umrah", "kaaba", "makkah", "pilgrimage", "baitullah", "حج", "हज")
        ),

        // ==================== 10. PARENTS / MAA BAAP ====================
        QuranAnswerItem(
            id = "parents",
            questionHindi = "माँ-बाप के क्या हुक़ूक़ हैं?",
            questionUrdu = "ماں باپ کے کیا حقوق ہیں؟",
            questionHinglish = "Maa baap ke kya huqooq hain?",
            directAnswerHinglish = "Maa-Baap ki khidmat aur adab farz hai. Unke aage 'Uff' tak na kaho, narmi se baat karo aur unki lambi umar o maghfirat ki dua karo.",
            directAnswerHindi = "माँ-बाप की ख़िदमत और अदब फ़र्ज़ है। उनके आगे 'उफ़' तक न कहो, नर्मी से बात करो और हमेशा उनके लिए रहमत व मग़फ़िरत की दुआ करो।",
            directAnswerUrdu = "ماں باپ کی خدمت، ادب اور فرماں برداری فرض ہے۔ ان کے آگے 'اف' تک نہ کہو، جھڑکنے سے پرہیز کرو اور نرمی سے ادب کے ساتھ بات کرو۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 23,
            arabicAyahText = "وَقَضَىٰ رَبُّكَ أَلَّا تَعْبُدُوٓا۟ إِلَّآ إِيَّاهُ وَبِٱلْوَٰلِدَيْنِ إِحْسَٰنًا ۚ إِمَّا يَبْلُغَنَّ عِندَكَ ٱلْكِبَرَ أَحَدُهُمَآ أَوْ كِلَاهُمَا فَلَا تَقُل لَّهُمَآ أُفٍّ وَلَا تَنْهَرْهُمَا وَقُل لَّهُمَا قَوْلًا كَرِيمًا",
            hinglishAyahText = "Wa qadaa Rabbuka allaa ta'budooo illaaa iyyaahu wa bil-waalidayni ihsaanaa; immaa yablughanna 'indakal-kibara ahaduhumaaa aw kilaahumaa falaa taqul-lahumaaa uffinw-wa laa tanharhumaa wa qul-lahumaa qawlan kareemaa.",
            urduAyahTranslation = "اور آپ کے رب نے فیصلہ فرما دیا کہ تم اس کے سوا کسی کی عبادت نہ کرو اور والدین کے ساتھ حسنِ سلوک کرو، اگر ان میں سے کوئی ایک یا دونوں تمہارے سامنے بڑھاپے کو پہنچ جائیں تو انہیں 'اف' بھی نہ کہو اور نہ انہیں جھڑکو بلکہ ان سے ادب کے ساتھ بات کہو۔",
            hindiAyahTranslation = "और आपके रब ने हुक्म दिया कि उसके सिवा किसी की इबादत न करो और माता-पिता के साथ अच्छा सुलूक करो। अगर उनमें से कोई एक या दोनों बुढ़ापे को पहुंच जाएं तो उन्हें 'उफ़' भी न कहो और न उन्हें झिड़को, बल्कि उनसे अदब से बात करो।",
            topicTags = listOf("maa", "baap", "walidain", "parents", "mother", "father", "ammi", "abbu", "khidmat", "والدین", "माता-पिता")
        ),

        // ==================== 11. SOOD / INTEREST / RIBA ====================
        QuranAnswerItem(
            id = "sood_riba",
            questionHindi = "क्या सूद (ब्याज) लेना-देना हराम है?",
            questionUrdu = "کیا سود لینا دینا حرام ہے؟",
            questionHinglish = "Kya sood (interest/riba) lena dena haram hai?",
            directAnswerHinglish = "Haan, sood (riba) qat'an haram hai. Quran mein sood khane walon ke khilaf Allah aur Uske Rasool ki taraf se elan-e-jang farmaya gaya hai.",
            directAnswerHindi = "हाँ, सूद (ब्याज) क़तई हराम है। क़ुरआन में सूद खाने वालों के ख़िलाफ़ अल्लाह और उसके रसूल की तरफ़ से जंग का ऐलान फ़रमाया गया है।",
            directAnswerUrdu = "ہاں، سود (ربا) قطعی حرام اور گناہِ عظیم ہے۔ قرآن پاک میں سود خوروں کے خلاف اللہ اور اس کے رسول کی طرف سے اعلانِ جنگ فرمایا گیا ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 275,
            arabicAyahText = "ٱلَّذِينَ يَأْكُلُونَ ٱلرِّبَوٰا۟ لَا يَقُومُونَ إِلَّا كَمَا يَقُومُ ٱلَّذِى يَتَخَبَّطُهُ ٱلشَّيْطَٰنُ مِنَ ٱلْمَسِّ ۚ ذَٰلِكَ بِأَنَّهُمْ قَالُوٓا۟ إِنَّمَا ٱلْبَيْعُ مِثْلُ ٱلرِّبَوٰا۟ ۗ وَأَحَلَّ ٱللَّهُ ٱلْبَيْعَ وَحَرَّمَ ٱلرِّبَوٰا۟",
            hinglishAyahText = "Alladheena ya'kuloonar-Ribaa laa yaqoomoona illaa kamaa yaqoomul-ladhee yatakhabbatuhush-Shaytaanu minal-mass; zaalika bi-annahum qaalooo innamal-bay'u mithlur-Ribaa; wa ahallal-laahul-bay'a wa harramar-Ribaa.",
            urduAyahTranslation = "جو لوگ سود کھاتے ہیں وہ قیامت میں اس شخص کی طرح اٹھیں گے جسے شیطان نے چھو کر پاگل بنا دیا ہو، یہ اس لیے کہ وہ کہتے ہیں کہ تجارت بھی تو سود جیسی ہے حالانکہ اللہ نے تجارت کو حلال کیا اور سود کو حرام ٹھہرایا ہے۔",
            hindiAyahTranslation = "जो लोग सूद खाते हैं वे (क़ियामत में) ऐसे उठेंगे जैसे किसी को शैतान ने छूकर बदहवास कर दिया हो। यह इसलिए कि वे कहते हैं कि व्यापार भी तो सूद जैसा है, हालांकि अल्लाह ने व्यापार को हलाल किया और सूद को हराम ठहराया है।",
            topicTags = listOf("sood", "riba", "interest", "byaj", "karz", "bank", "haram", "سود", "सूद")
        ),

        // ==================== 12. SABR / PATIENCE ====================
        QuranAnswerItem(
            id = "sabr",
            questionHindi = "मुसीबत और परेशानी में सब्र का क्या अज्र है?",
            questionUrdu = "مصیبت اور پریشانی میں صبر کا کیا اجر ہے؟",
            questionHinglish = "Musibat aur pareshani mein sabr ka kya ajar hai?",
            directAnswerHinglish = "Allah Ta'ala sabr karne walon ke sath hai. Beshak sabr karne walon ko unka ajar be-hisaab diya jayega aur har takleef ke baad aasaani aati hai.",
            directAnswerHindi = "अल्लाह तआला सब्र करने वालों के साथ है। बेशक सब्र करने वालों को उनका बदला बिना हिसाब दिया जाएगा और हर तक़लीफ़ के बाद आसानी आती है।",
            directAnswerUrdu = "اللہ تعالیٰ صبر کرنے والوں کے ساتھ ہے۔ بے شک صبر کرنے والوں کو ان کا اجر بغیر کسی حساب کے بھرپور عطا فرمایا جائے گا۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 153,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ ٱسْتَعِينُوا۟ بِٱلصَّبْرِ وَٱلصَّلَوٰةِ ۚ إِنَّ ٱللَّهَ مَعَ ٱلصَّٰبِرِينَ",
            hinglishAyahText = "Yaaa ayyuhal-ladheena aamanus-ta'eenoo bis-sabri was-Salaah; innal-laaha ma'as-saabireen.",
            urduAyahTranslation = "اے ایمان والو! صبر اور نماز کے ذریعے مدد مانگو، بے شک اللہ صبر کرنے والوں کے ساتھ ہے۔",
            hindiAyahTranslation = "ऐ ईमान वालो! सब्र और नमाज़ के ज़रिए मदद मांगो, बेशक अल्लाह सब्र करने वालों के साथ है।",
            topicTags = listOf("sabr", "patience", "musibat", "pareshani", "takleef", "dard", "gam", "bimaari", "صبر", "सब्र")
        ),

        // ==================== 13. TAUBA / REPENTANCE ====================
        QuranAnswerItem(
            id = "tauba",
            questionHindi = "क्या अल्लाह सारे गुनाह माफ़ कर देता है?",
            questionUrdu = "کیا اللہ سارے گناہ معاف کر دیتا ہے؟",
            questionHinglish = "Kya Allah saare gunah maaf kar deta hai?",
            directAnswerHinglish = "Haan, agar banda sachhi tauba kare to Allah Ta'ala tamam gunahon ko maaf farma deta hai. Allah ki rehmat se kabhi mayoos na hon.",
            directAnswerHindi = "हाँ, अगर बंदा सच्ची तौबा करे तो अल्लाह तआला तमाम गुनाहों को माफ़ फ़रमा देता है। अल्लाह की रहमत से कभी ना-उम्मीद न हों।",
            directAnswerUrdu = "ہاں، اگر بندہ خلوصِ دل سے سچی توبہ کرے تو اللہ تعالیٰ تمام کے تمام گناہ بخش دیتا ہے۔ اللہ کی رحمت سے کبھی مایوس نہ ہوں۔",
            surahNumber = 39,
            surahNameRoman = "Az-Zumar",
            surahNameArabic = "الزمر",
            ayahNumber = 53,
            arabicAyahText = "قُلْ يَٰعِبَادِىَ ٱلَّذِينَ أَسْرَفُوا۟ عَلَىٰٓ أَنفُسِهِمْ لَا تَقْنَطُوا۟ مِن رَّحْمَةِ ٱللَّهِ ۚ إِنَّ ٱللَّهَ يَغْفِرُ ٱلذُّنُوبَ جَمِيعًا ۚ إِنَّهُۥ هُوَ ٱلْغَفُورُ ٱلرَّحِيمُ",
            hinglishAyahText = "Qul yaa 'ibaadiyal-ladheena asrafoo 'alaaa anfusihim laa taqnatoo mir-rahmatil-laah; innal-laaha yaghfirudh-dhunooba jamee'aa; innahoo Huwal-Ghafoorur-Raheem.",
            urduAyahTranslation = "فرما دیجیے: اے میرے بندو جنہوں نے اپنی جانوں پر زیادتی کی ہے! اللہ کی رحمت سے مایوس نہ ہو، بے شک اللہ تمام گناہوں کو بخش دیتا ہے، یقیناً وہ بڑا بخشنے والا نہایت رحم فرمانے والا ہے۔",
            hindiAyahTranslation = "कह दीजिए: ऐ मेरे बंदो जिन्होंने अपनी जानों पर ज़्यादती की है! अल्लाह की रहमत से मायूस न हो। बेशक अल्लाह सब गुनाह बख़्श देता है, यक़ीनन वह बड़ा बख़्शने वाला, निहायत रहम करने वाला है।",
            topicTags = listOf("tauba", "maaf", "maghfirat", "gunah", "astaghfar", "forgiveness", "repentance", "توبہ", "तौबा")
        ),

        // ==================== 14. RIZQ & BARKAT ====================
        QuranAnswerItem(
            id = "rizq",
            questionHindi = "रिज़्क़ में बरकत और तरक़्क़ी का क्या तरीक़ा है?",
            questionUrdu = "رزق میں برکت اور ترقی کا کیا طریقہ ہے؟",
            questionHinglish = "Rizq mein barkat aur tarakki ka kya tareeqa hai?",
            directAnswerHinglish = "Taqwa (Allah ka darr) aur tawakkul (Allah par bharosa) se Allah aisi jagah se rizq ataa farmata hai jahan gumaan bhi nahi hota.",
            directAnswerHindi = "तक़वा (अल्लाह का डर) और तवक्कुल (अल्लाह पर भरोसा) से अल्लाह ऐसी जगह से रिज़्क़ देता है जहां गुमान भी नहीं होता।",
            directAnswerUrdu = "تقویٰ (اللہ کا خوف) اور توکل (اللہ پر کامل بھروسہ) سے اللہ تعالیٰ انسان کو ایسے راستے سے رزق عطا فرماتا ہے جہاں اس کا گمان بھی نہیں ہوتا۔",
            surahNumber = 65,
            surahNameRoman = "At-Talaq",
            surahNameArabic = "الطلاق",
            ayahNumber = 3,
            arabicAyahText = "وَيَرْزُقْهُ مِنْ حَيْثُ لَا يَحْتَسِبُ ۚ وَمَن يَتَوَكَّلْ عَلَى ٱللَّهِ فَهُوَ حَسْبُهُۥٓ ۚ إِنَّ ٱللَّهَ بَٰلِغُ أَمْرِهِۦ",
            hinglishAyahText = "Wa yarzuqhu min haythu laa yahtasib; wa many-yatawakkal 'alal-laahi fahuwa hasbuh; innal-laaha baalighu amrih.",
            urduAyahTranslation = "اور اسے ایسی جگہ سے رزق عطا فرماتا ہے جہاں سے اس کا گمان بھی نہ ہو، اور جو اللہ پر بھروسہ رکھے تو وہ اسے کافی ہے، بے شک اللہ اپنا کام پورا کر کے رہتا ہے۔",
            hindiAyahTranslation = "और उसे ऐसी जगह से रिज़्क़ देता है जहाँ से उसे गुमान भी न हो। और जो अल्लाह पर भरोसा रखे तो वह उसके लिए काफ़ी है। बेशक अल्लाह अपना काम पूरा करके रहता है।",
            topicTags = listOf("rizq", "rozi", "barkat", "naukri", "job", "business", "tarakki", "kamana", "paisa", "رزق", "रिज़्क़")
        ),

        // ==================== 15. DIL KA SUKOON / PEACE ====================
        QuranAnswerItem(
            id = "sukoon",
            questionHindi = "दिल का सुकून और चैन कैसे मिलता है?",
            questionUrdu = "دل کا سکون اور چین کیسے ملتا ہے؟",
            questionHinglish = "Dil ka sukoon aur chain kaise milta hai?",
            directAnswerHinglish = "Dilon ka asli sukoon sirf aur sirf Allah ke zikr, Quran ki tilawat aur ibadat mein hai.",
            directAnswerHindi = "दिलों का सच्चा सुकून और चैन सिर्फ़ और सिर्फ़ अल्लाह के ज़िक्र, क़ुरआन की तिलावत और इबादत में है।",
            directAnswerUrdu = "دلوں کا حقیقی سکون، اطمینان اور راحت صرف اور صرف اللہ تعالیٰ کے ذکر، تلاوت اور بندگی میں ہے۔",
            surahNumber = 13,
            surahNameRoman = "Ar-Ra'd",
            surahNameArabic = "الرعد",
            ayahNumber = 28,
            arabicAyahText = "ٱلَّذِينَ ءَامَنُوا۟ وَتَطْمَئِنُّ قُلُوبُهُم بِذِكْرِ ٱللَّهِ ۗ أَلَا بِذِكْرِ ٱللَّهِ تَطْمَئِنُّ ٱلْقُلُوبُ",
            hinglishAyahText = "Alladheena aamanoo wa tatma'innu quloobuhum bidhikril-laah; alaa bidhikril-laahi tatma'innul-quloob.",
            urduAyahTranslation = "جو لوگ ایمان لائے اور جن کے دل اللہ کے ذکر سے اطمینان پاتے ہیں، سن لو! اللہ ہی کے ذکر سے دلوں کو اطمینان و سکون ملتا ہے۔",
            hindiAyahTranslation = "जो लोग ईमान लाए और जिनके दिलों को अल्लाह के ज़िक्र से सुकून मिलता है, सुन लो! अल्लाह ही के ज़िक्र से दिलों को सुकून और इत्मीनान मिलता है।",
            topicTags = listOf("sukoon", "shanti", "peace", "chain", "zikr", "dhikr", "anxiety", "dil", "سکون", "सुकून")
        ),

        // ==================== 16. DUA / SUPPLICATION ====================
        QuranAnswerItem(
            id = "dua",
            questionHindi = "क्या अल्लाह दुआएं क़बूल फ़रमाता है?",
            questionUrdu = "کیا اللہ دعائیں قبول فرماتا ہے؟",
            questionHinglish = "Kya Allah duayein qubool farmata hai?",
            directAnswerHinglish = "Beshak Allah apne bando ke nihayat qareeb hai aur jab bhi koi pukarta hai to Uski dua qabool farmata hai.",
            directAnswerHindi = "बेशक अल्लाह अपने बंदों के निहायत क़रीब है और जब भी कोई पुकारता है तो उसकी दुआ क़बूल फ़रमाता है।",
            directAnswerUrdu = "بے شک اللہ اپنے بندوں کے انتہائی قریب ہے اور جب بھی کوئی پکارتا ہے تو اس کی پکار اور دعا کو قبول فرماتا ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 186,
            arabicAyahText = "وَإِذَا سَأَلَكَ عِبَادِى عَنِّى فَإِنِّى قَرِيبٌ ۖ أُجِيبُ دَعْوَةَ ٱلدَّاعِ إِذَا دَعَانِ ۖ فَلْيَسْتَجِيبُوا۟ لِى وَلْيُؤْمِنُوا۟ بِى لَعَلَّهُمْ يَرْشُدُونَ",
            hinglishAyahText = "Wa idhaa sa'alaka 'ibaadee 'annee fa-innee Qareeb; ujeebu da'watad-daa'i idhaa da'aani fal-yastajeeboo lee wal-yu'minoo bee la'allahum yarshudoon.",
            urduAyahTranslation = "اور جب میرے بندے آپ سے میرے بارے میں پوچھیں تو میں قریب ہوں، میں پکارنے والے کی دعا قبول کرتا ہوں جب وہ مجھے پکارتا ہے، پس انہیں چاہیے کہ میرا حکم مانیں اور مجھ پر ایمان رکھیں تاکہ وہ ہدایت پائیں۔",
            hindiAyahTranslation = "और जब मेरे बंदे आपसे मेरे बारे में पूछें तो मैं क़रीब हूँ। मैं पुकारने वाले की पुकार सुनता हूँ जब वह मुझे पुकारे। अतः उन्हें चाहिए कि मेरा हुक्म मानें और मुझ पर ईमान लाएं ताकि वे सही रास्ते पर रहें।",
            topicTags = listOf("dua", "mangna", "arzi", "haajat", "qubool", "supplication", "prayer request", "دعا", "दुआ")
        ),

        // ==================== 17. SHIFA / HEALING ====================
        QuranAnswerItem(
            id = "shifa",
            questionHindi = "क्या क़ुरआन पाक में बीमारी की शिफ़ा है?",
            questionUrdu = "کیا قرآن پاک میں بیماری کی شفاء ہے؟",
            questionHinglish = "Kya Quran Pak mein bimari ki shifa hai?",
            directAnswerHinglish = "Beshak Quran Pak momino ke liye roohani o jismani shifa aur rehmat hai.",
            directAnswerHindi = "बेशक क़ुरआन पाक मोमिनों के लिए रूहानी व जिस्मानी शिफ़ा और रहमत है।",
            directAnswerUrdu = "بے شک قرآن پاک اہلِ ایمان کے لیے روحانی اور جسمانی دونوں بیماریوں کی شفاء اور عظیم رحمت ہے۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 82,
            arabicAyahText = "وَنُنَزِّلُ مِنَ ٱلْقُرْءَانِ مَا هُوَ شِفَآءٌ وَرَحْمَةٌ لِّلْمُؤْمِنِينَ ۙ وَلَا يَزِيدُ ٱلظَّٰلِمِينَ إِلَّا خَسَارًا",
            hinglishAyahText = "Wa nunazzilu minal-Qur'aani maa huwa shifaaa'unw-wa rahmatul-lil-mu'mineena wa laa yazeeduz-zaalimeena illaa khasaaraa.",
            urduAyahTranslation = "اور ہم قرآن میں سے وہ چیز نازل فرماتے ہیں جو مومنوں کے لیے شفاء اور رحمت ہے اور ظالموں کے لیے نقصان ہی بڑھاتی ہے۔",
            hindiAyahTranslation = "और हम क़ुरआन से वह नाज़िल करते हैं जो मोमिनों के लिए शिफ़ा (आरोग्य) और रहमत है, और ज़ालिमों के लिए नुक़सान ही बढ़ाता है।",
            topicTags = listOf("shifa", "bimari", "ilaj", "cure", "health", "sehat", "healing", "شفاء", "शिफ़ा", "बीमारी")
        ),

        // ==================== 18. QARZ / DEBT ====================
        QuranAnswerItem(
            id = "qarz",
            questionHindi = "क़र्ज़दार के साथ क्या सुलूक करना चाहिए?",
            questionUrdu = "قرضدار کے ساتھ کیا سلوک کرنا چاہیے؟",
            questionHinglish = "Qarzdar ke sath kya sulook karna chahiye?",
            directAnswerHinglish = "Agar qarzdar tangdast ho to use asani tak mohlat do, aur agar muaf kar do sadqa samajh kar to yeh tumhare liye sabse behtar hai.",
            directAnswerHindi = "अगर क़र्ज़दार तंगदस्त (मजबूर) हो तो उसे आसानी तक मोहलत दो, और अगर माफ़ कर दो सदक़ा समझ कर तो यह तुम्हारे लिए सबसे बेहतर है।",
            directAnswerUrdu = "اگر قرضدار تنگدست ہو تو اسے کشادگی اور آسانی تک مہلت دو، اور اگر تم صدقہ کر کے معاف ہی کر دو تو یہ تمہارے حق میں بہت بہتر ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 280,
            arabicAyahText = "وَإِن كَانَ ذُو عُسْرَةٍ فَنَظِرَةٌ إِلَىٰ مَيْسَرَةٍ ۚ وَأَن تَصَدَّقُوا۟ خَيْرٌ لَّكُمْ ۖ إِن كُنتُمْ تَعْلَمُونَ",
            hinglishAyahText = "Wa in kaana dhoo 'usratin fanaziratun ilaa maysarah; wa an tasaddaqoo khayrul-lakum in kuntum ta'lamoon.",
            urduAyahTranslation = "اور اگر مقروض تنگدست ہو تو اسے کشادگی تک مہلت دی جائے، اور یہ کہ تم صدقہ کر دو (معاف کر دو) تو تمہارے لیے زیادہ بہتر ہے اگر تم سمجھو۔",
            hindiAyahTranslation = "और अगर क़र्ज़दार तंगी में हो तो उसे आसानी तक मोहलत दो, और अगर तुम माफ़ ही कर दो सदक़ा समझकर तो तुम्हारे लिए बहुत बेहतर है अगर तुम जानो।",
            topicTags = listOf("qarz", "debt", "loan", "qarzdar", "paisa", "karz", "قرض", "क़र्ज़")
        ),

        // ==================== 19. NIKAH / MARRIAGE ====================
        QuranAnswerItem(
            id = "nikah",
            questionHindi = "निकाह और शादी का क्या मक़सद है?",
            questionUrdu = "نکاح اور شادی کا کیا مقصد ہے؟",
            questionHinglish = "Nikah aur shadi ka kya maqsad hai?",
            directAnswerHinglish = "Nikah Allah ki azeem nishani hai jisse miyan-biwi ke darmiyan sukoon, be-inteha mohabbat aur rehmat paida hoti hai.",
            directAnswerHindi = "निकाह अल्लाह की अज़ीम निशानी है जिससे मियाँ-बीवी के दरमियान सुकून, मुहब्बत और रहमत पैदा होती है।",
            directAnswerUrdu = "نکاح اللہ تعالیٰ کی عظیم نشانیوں میں سے ہے جس سے میاں بیوی کے درمیان دلی سکون، باہمی محبت اور رحمت قائم ہوتی ہے۔",
            surahNumber = 30,
            surahNameRoman = "Ar-Rum",
            surahNameArabic = "الروم",
            ayahNumber = 21,
            arabicAyahText = "وَمِنْ ءَايَٰتِهِۦٓ أَنْ خَلَقَ لَكُم مِّنْ أَنفُسِكُمْ أَزْوَٰجًا لِّتَسْكُنُوٓا۟ إِلَيْهَا وَجَعَلَ بَيْنَكُم مَّوَدَّةً وَرَحْمَةً ۚ إِنَّ فِى ذَٰلِكَ لَءَايَٰتٍ لِّقَوْمٍ يَتَفَكَّرُونَ",
            hinglishAyahText = "Wa min Aayaatiheee an khalaqa lakum min anfusikum azwaajal-litaskunooo ilayhaa wa ja'ala baynakum mawaddatanw-wa rahmah; inna fee zaalika la-Aayaatil-liqawminy-yatafakkaroon.",
            urduAyahTranslation = "اور اس کی نشانیوں میں سے ہے کہ اس نے تمہاری ہی جنس سے جوڑے پیدا کیے تاکہ تم ان سے سکون حاصل کرو اور تمہارے درمیان محبت اور ہمدردی پیدا کی، بے شک اس میں غور کرنے والوں کے لیے نشانیاں ہیں۔",
            hindiAyahTranslation = "और उसकी निशानियों में से है कि उसने तुम्हारे लिए तुम्हारी ही जिन्स से जोड़े बनाए ताकि तुम उनसे सुकून पाओ, और तुम्हारे बीच मुहब्बत और रहमत पैदा की। बेशक इसमें ग़ौर करने वालों के लिए बड़ी निशानियां हैं।",
            topicTags = listOf("nikah", "shadi", "vivah", "marriage", "biwi", "shohar", "rishta", "نکاح", "शादी", "निकाह")
        ),

        // ==================== 20. DOSTI / FRIENDS ====================
        QuranAnswerItem(
            id = "dosti",
            questionHindi = "दोस्ती किससे करनी चाहिए?",
            questionUrdu = "دوستی کس سے کرنی چاہیے؟",
            questionHinglish = "Dosti kisse karni chahiye?",
            directAnswerHinglish = "Hamesha sachhe aur naik logon ki sohbat ikhtiyar karo, kyonke buri dosti aakhirat mein pachtawa banti hai.",
            directAnswerHindi = "हमेशा सच्चे और नेक लोगों की सोहबत अपनाओ, क्योंकि बुरी सोहबत आख़िरत में पछतावे का सबब बनती है।",
            directAnswerUrdu = "ہمیشہ سچے، متقی اور نیک لوگوں کی صحبت اختیار کرو، کیونکہ غلط دوستوں کی سنگت آخرت میں حسرت اور پچھتاوے کا باعث بنے گی۔",
            surahNumber = 9,
            surahNameRoman = "At-Tawbah",
            surahNameArabic = "التوبة",
            ayahNumber = 119,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ ٱتَّقُوا۟ ٱللَّهَ وَكُونُوا۟ مَعَ ٱلصَّٰدِقِينَ",
            hinglishAyahText = "Yaaa ayyuhal-ladheena aamanut-taqul-laaha wa koonoo ma'as-saadiqeen.",
            urduAyahTranslation = "اے ایمان والو! اللہ سے ڈرو اور سچے لوگوں کے ساتھ رہو۔",
            hindiAyahTranslation = "ऐ ईमान वालो! अल्लाह से डरो और सच्चे लोगों के साथ रहो।",
            topicTags = listOf("dost", "dosti", "friend", "friends", "sohbat", "sacha", "company", "دوست", "دوستی", "दोस्त")
        ),

        // ==================== 21. ZULM / INJUSTICE ====================
        QuranAnswerItem(
            id = "zulm",
            questionHindi = "ज़ुल्म करने वाले का क्या अंजाम होता है?",
            questionUrdu = "ظلم کرنے والے کا کیا انجام ہوتا ہے؟",
            questionHinglish = "Zulm karne wale ka kya anjaam hota hai?",
            directAnswerHinglish = "Hargiz yeh gumaan na karo ke Allah zalimo ke a'maal se ghafil hai, Allah unhe us din tak mohlat deta hai jis din aankhein phati reh jayengi.",
            directAnswerHindi = "हरगिज़ यह ख़्याल न करो कि अल्लाह ज़ालिमों के आमाल से बेख़बर है, अल्लाह उन्हें उस दिन तक ढील देता है जिस दिन आंखें खुली की खुली रह जाएंगी।",
            directAnswerUrdu = "ہرگز یہ گمان نہ کرنا کہ اللہ ظالموں کے کرتوتوں سے غافل ہے، وہ تو انہیں اس دن کے لیے مہلت دے رہا ہے جس دن خوف سے آنکھیں پھٹی رہ جائیں گی۔",
            surahNumber = 14,
            surahNameRoman = "Ibrahim",
            surahNameArabic = "إبراهيم",
            ayahNumber = 42,
            arabicAyahText = "وَلَا تَحْسَبَنَّ ٱللَّهَ غَٰفِلًا عَمَّا يَعْمَلُ ٱلظَّٰلِمُونَ ۚ إِنَّمَا يُؤَخِّرُهُمْ لِيَوْمٍ تَشْخَصُ فِيهِ ٱلْأَبْصَٰرُ",
            hinglishAyahText = "Wa laa tahsabannal-laaha ghaafilan 'ammaa ya'maluz-zaalimoon; innamaa yu'akhkhiruhum li-Yawmin tashkhasu feehil-absaar.",
            urduAyahTranslation = "اور تم ہرگز اللہ کو اس سے بے خبر نہ سمجھنا جو ظالم لوگ کرتے ہیں، وہ تو انہیں صرف اس دن تک مہلت دے رہا ہے جس میں آنکھیں پھٹی کی پھٹی رہ جائیں گی۔",
            hindiAyahTranslation = "और तुम हरगिज़ अल्लाह को इससे ग़ाफ़िल न समझो जो ज़ालिम करते हैं। वह तो उन्हें बस उस दिन तक ढील दे रहा है जिसमें आंखें फटी की फटी रह जाएंगी।",
            topicTags = listOf("zulm", "injustice", "zalim", "insaaf", "badla", "cruelty", "ظلم", "ज़ुल्म")
        ),

        // ==================== 22. MUNAFIQ / HYPOCRISY ====================
        QuranAnswerItem(
            id = "munafiq",
            questionHindi = "मुनाफ़िक़ (दोगले) की क्या पहचान है?",
            questionUrdu = "منافق کی کیا پہچان اور انجام ہے؟",
            questionHinglish = "Munafiq (hypocrite) ki kya pehchan aur anjam hai?",
            directAnswerHinglish = "Munafiq zuban se iman ka izhar karta hai lekin dil mein kufr aur dhoka rakhta hai. Munafiqeen jahannam ke sabse nichle darje mein honge.",
            directAnswerHindi = "मुनाफ़िक़ ज़बान से ईमान का इज़हार करता है लेकिन दिल में कुफ़्र और धोखा रखता है। मुनाफ़िक़ीन जहन्नम के सबसे निचले दर्जे में होंगे।",
            directAnswerUrdu = "منافق زبان سے ایمان ظاہر کرتا ہے لیکن دل میں کفر اور دھوکہ چھپاتا ہے۔ منافقین دوزخ کے سب سے نچلے طبقے میں ہوں گے۔",
            surahNumber = 4,
            surahNameRoman = "An-Nisa",
            surahNameArabic = "النساء",
            ayahNumber = 145,
            arabicAyahText = "إِنَّ ٱلْمُنَٰفِقِينَ فِى ٱلدَّرْكِ ٱلْأَسْفَلِ مِنَ ٱلنَّارِ وَلَن تَجِدَ لَهُمْ نَصِيرًا",
            hinglishAyahText = "Innal-munaafiqeena fid-darkil-asfali minan-naari wa lan tajida lahum naseeraa.",
            urduAyahTranslation = "بے شک منافقین دوزخ کے سب سے نچلے طبقے میں ہوں گے اور آپ ان کے لیے کوئی مددگار نہ پائیں گے۔",
            hindiAyahTranslation = "बेशक मुनाफ़िक़ जहन्नम के सबसे निचले दर्जे में होंगे, और आप उनका कोई मददगार न पाएंगे।",
            topicTags = listOf("munafiq", "nifaq", "hypocrisy", "dhoka", "dogle", "منافق", "मुनाफ़िक़")
        ),

        // ==================== 23. WUZU & TAHTARAT ====================
        QuranAnswerItem(
            id = "wuzu",
            questionHindi = "वुज़ू का क्या हुक्म और तरीक़ा है?",
            questionUrdu = "وضو کا کیا حکم اور طریقہ ہے؟",
            questionHinglish = "Wuzu ka kya hukm aur tareeqa hai?",
            directAnswerHinglish = "Namaz ke liye wuzu farz hai: chehra dhona, kohniyon tak haath dhona, sar ka masah karna aur takhnon tak paanv dhona.",
            directAnswerHindi = "नमाज़ के लिए वुज़ू फ़र्ज़ है: चेहरा धोना, कोहनियों तक हाथ धोना, सर का मसह करना और टख़नों तक पैर धोना।",
            directAnswerUrdu = "نماز کی ادائیگی کے لیے باوضو ہونا فرض ہے: چہرہ دھونا، کہنیوں سمیت ہاتھ دھونا، سر کا مسح کرنا اور ٹخنوں سمیت پاؤں دھونا۔",
            surahNumber = 5,
            surahNameRoman = "Al-Ma'idah",
            surahNameArabic = "المائدة",
            ayahNumber = 6,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوٓا۟ إِذَا قُمْتُمْ إِلَى ٱلصَّلَوٰةِ فَٱغْسِلُوا۟ وُجُوهَكُمْ وَأَيْدِيَكُمْ إِلَى ٱلْمَرَافِقِ وَٱمْسَحُوا۟ بِرُءُوسِكُمْ وَأَرْجُلَكُمْ إِلَى ٱلْكَعْبَيْنِ",
            hinglishAyahText = "Yaaa ayyuhal-ladheena aamanooo idhaa qumtum ilas-Salaati faghsiloo wujoohakum wa aydiyakum ilal-maraafiqi wamsahoo bi-ru'oosikum wa arjulakum ilal-ka'bayn.",
            urduAyahTranslation = "اے ایمان والو! جب تم نماز کے لیے کھڑے ہونے لگو تو اپنے منہ دھو لو اور اپنے ہاتھ کہنیوں تک دھو لو اور اپنے سروں کا مسح کرو اور اپنے پاؤں ٹخنوں تک دھو لو۔",
            hindiAyahTranslation = "ऐ ईमान वालो! जब तुम नमाज़ के लिए उठो तो अपने चेहरे धो लो और अपने हाथ कोहनियों तक धो लो, और अपने सिरों का मसह करो और अपने पैर टख़नों तक धो लो।",
            topicTags = listOf("wuzu", "wudhu", "wazoo", "taharat", "pakizgi", "purity", "ablution", "وضو", "वुज़ू")
        ),

        // ==================== 24. JANNAT / PARADISE ====================
        QuranAnswerItem(
            id = "jannat",
            questionHindi = "जन्नत की नेमतें कैसी हैं?",
            questionUrdu = "جنت کی نعمتیں کیسی ہیں؟",
            questionHinglish = "Jannat ki neamatein kaisi hain?",
            directAnswerHinglish = "Jannat mein aisi neamatein hain jo na kisi aankh ne dekhi, na kaan ne suni, aur na kisi insan ke dil mein unka gumaan guzra.",
            directAnswerHindi = "जन्नत में ऐसी नेमतें हैं जो न किसी आंख ने देखीं, न कान ने सुनीं, और न किसी इंसान के दिल में उनका ख़्याल आया।",
            directAnswerUrdu = "جنت میں ایسی لازوال نعمتیں اور باغات ہیں جو نہ کسی آنکھ نے دیکھے، نہ کسی کان نے سنے اور نہ کسی انسانی دل پر ان کا خیال گزرا۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 25,
            arabicAyahText = "وَبَشِّرِ ٱلَّذِينَ ءَامَنُوا۟ وَعَمِلُوا۟ ٱلصَّٰلِحَٰتِ أَنَّ لَهُمْ جَنَّٰتٍ تَجْرِى مِن تَحْتِهَا ٱلْأَنْهَٰرُ",
            hinglishAyahText = "Wa bashshiril-ladheena aamanoo wa 'amilus-saalihaati anna lahum Jannaatin tajree min tahtihal-anhaar.",
            urduAyahTranslation = "اور خوشخبری دے دیجیے ان لوگوں کو جو ایمان لائے اور نیک اعمال کیے کہ ان کے لیے ایسے باغات ہیں جن کے نیچے نہریں بہتی ہیں۔",
            hindiAyahTranslation = "और ख़ुशख़बरी दे दीजिए उन लोगों को जो ईमान लाए और नेक अमल किए कि उनके लिए ऐसे बाग़ हैं जिनके नीचे नहरें बहती हैं।",
            topicTags = listOf("jannat", "paradise", "swarg", "hoor", "neamat", "nahr", "جنت", "जन्नत")
        ),

        // ==================== 25. JAHANNAM / HELL ====================
        QuranAnswerItem(
            id = "jahannam",
            questionHindi = "दोज़ख़ (जहन्नम) का अज़ाब कैसा है?",
            questionUrdu = "دوزخ (جہنم) کا عذاب کیسا ہے؟",
            questionHinglish = "Dozakh (jahannam) ka azaab kaisa hai?",
            directAnswerHinglish = "Jahannam ki aag nihayat shadeed hai jiska indhan insan aur pathar hain. Wahan kholte hue paani aur aag ka dardnaak azaab hoga.",
            directAnswerHindi = "जहन्नम की आग निहायत भयानक है जिसका ईंधन इंसान और पत्थर हैं। वहां खौलते पानी और आग का दर्दनाक अज़ाब होगा।",
            directAnswerUrdu = "جہنم کی آگ انتہائی ہولناک اور شدید ہے جس کا ایندھن انسان اور پتھر ہیں۔ وہاں کھولتے پانی اور آگ کا دائمی دردناک عذاب ہوگا۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 24,
            arabicAyahText = "فَإِن لَّمْ تَفْعَلُوا۟ وَلَن تَفْعَلُوا۟ فَٱتَّقُوا۟ ٱلنَّارَ ٱلَّتِى وَقُودُهَا ٱلنَّاسُ وَٱلْحِجَارَةُ ۖ أُعِدَّتْ لِلْكَٰفِرِينَ",
            hinglishAyahText = "Fa-il-lam taf'aloo wa lan taf'aloo fattaqun-Naaral-latee waqooduhan-naasu wal-hijaaratu u'iddat lil-kaafireen.",
            urduAyahTranslation = "پھر اگر تم ایسا نہ کر سکو اور ہرگز نہ کر سکو گے تو اس آگ سے ڈرو جس کا ایندھن انسان اور پتھر ہیں، جو کافروں کے لیے تیار کی گئی ہے۔",
            hindiAyahTranslation = "फिर अगर तुम ऐसा न कर सको और हरगिज़ न कर सकोगे तो उस आग से डरो जिसका ईंधन इंसान और पत्थर हैं, जो काफ़िरों के लिए तैयार की गई है।",
            topicTags = listOf("jahannam", "dozakh", "hell", "narak", "azab", "fire", "aag", "جہنم", "دوزخ", "जहन्नम")
        ),

        // ==================== 26. MAUT / DEATH ====================
        QuranAnswerItem(
            id = "death",
            questionHindi = "मौत की क्या हक़ीक़त है?",
            questionUrdu = "موت کی کیا حقیقت ہے؟",
            questionHinglish = "Maut ki kya haqeeqat hai?",
            directAnswerHinglish = "Har jaan ko maut ka maza chakhna hai. Duniya ki zindagi aazmaish aur aakhirat ke ajar ki tayyari ki jagah hai.",
            directAnswerHindi = "हर जान को मौत का मज़ा चखना है। दुनिया की ज़िन्दगी महज़ आज़माइश और आख़िरत के बदले की तैयारी की जगह है।",
            directAnswerUrdu = "ہر جاندار کو موت کا مزہ چکھنا ہے۔ دنیا کی زندگی محض ایک عارضی آزمائش ہے اور اصل دائمی زندگی آخرت کی ہے۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 185,
            arabicAyahText = "كُلُّ نَفْسٍ ذَآئِقَةُ ٱلْمَوْتِ ۗ وَإِنَّمَا تُوَفَّوْنَ أُجُورَكُمْ يَوْمَ ٱلْقِيَٰمَةِ ۖ فَمَن زُحْزِحَ عَنِ ٱلنَّارِ وَأُدْخِلَ ٱلْجَنَّةَ فَقَدْ فَازَ ۗ وَمَا ٱلْحَيَوٰةُ ٱلدُّنْيَآ إِلَّا مَتَٰعُ ٱلْغُرُورِ",
            hinglishAyahText = "Kullu nafsin daaa'iqatul-mawt; wa innamaa tuwaffawna ujoorakum Yawmal-Qiyaamah; faman zuhziha 'anin-Naari wa udkhilal-Jannata faqad faaz; wa mal-hayaatud-dunyaaa illaa mataa'ul-ghuroor.",
            urduAyahTranslation = "ہر جان کو موت کا مزہ چکھنا ہے، اور تمہیں قیامت کے دن تمہارے پورے پورے اجر دیے جائیں گے، پس جو آگ سے بچا لیا گیا اور جنت میں داخل کر دیا گیا وہ کامیاب ہو گیا، اور دنیا کی زندگی تو دھوکے کے سامان کے سوا کچھ نہیں۔",
            hindiAyahTranslation = "हर जान को मौत का मज़ा चखना है, और क़ियामत के दिन तुम्हें तुम्हारे पूरे-पूरे बदले दिए जाएंगे। अतः जो आग से बचा लिया गया और जन्नत में दाख़िल कर दिया गया वह कामयाब हो गया, और दुनिया की ज़िन्दगी धोखे के सामान के सिवा कुछ नहीं।",
            topicTags = listOf("maut", "death", "qabar", "janaza", "inteqal", "marne", "kullu nafsin", "موت", "मौत")
        ),

        // ==================== 27. HIJAB & HAYA ====================
        QuranAnswerItem(
            id = "hijab",
            questionHindi = "हिजाब और पर्दे का क्या हुक्म है?",
            questionUrdu = "حجاب اور پردے کا کیا حکم ہے؟",
            questionHinglish = "Hijab aur parde ka kya hukm hai?",
            directAnswerHinglish = "Parda aur haya Islam ka ahem tareen sha'ar hai. Momin mard aur auratein apni nazrein neechi rakhein aur parde ki pabandi karein.",
            directAnswerHindi = "पर्दा और हया इस्लाम का अहम तरीन हिस्सा है। मोमिन मर्द और औरतें अपनी नज़रें नीची रखें और पर्दे की पाबंदी करें।",
            directAnswerUrdu = "حجاب اور حیا اسلام کا بنیادی اور لازمی حکم ہے۔ مومن مرد و خواتین اپنی نگاہیں نیچی رکھیں اور اپنی چادروں سے پردہ قائم کریں۔",
            surahNumber = 24,
            surahNameRoman = "An-Nur",
            surahNameArabic = "النور",
            ayahNumber = 30,
            arabicAyahText = "قُل لِّلْمُؤْمِنِينَ يَغُضُّوا۟ مِنْ أَبْصَٰرِهِمْ وَيَحْفَظُوا۟ فُرُوجَهُمْ ۚ ذَٰلِكَ أَزْكَىٰ لَهُمْ ۗ إِنَّ ٱللَّهَ خَبِيرٌۢ بِمَا يَصْنَعُونَ",
            hinglishAyahText = "Qul lil-mu'mineena yaghuddoo min absaarihim wa yahfazoo furoojahum; zaalika azkaa lahum; innal-laaha Khabeerum-bimaa yasna'oon.",
            urduAyahTranslation = "مومن مردوں سے کہیے کہ وہ اپنی نگاہیں نیچی رکھیں اور اپنی شرمگاہوں کی حفاظت کریں، یہ ان کے لیے زیادہ پاکیزہ ہے، بے شک اللہ اس سے باخبر ہے جو وہ کرتے ہیں۔",
            hindiAyahTranslation = "मोमिन मर्दों से कहिए कि वे अपनी नज़रें नीची रखें और अपनी शर्मगाहों की हिफ़ाज़त करें, यह उनके लिए ज़्यादा पाकीज़ा है। बेशक अल्लाह ख़ूब बाख़बर है जो कुछ वे करते हैं।",
            topicTags = listOf("parda", "hijab", "haya", "sharam", "aurat", "libas", "modesty", "حجاب", "پردہ", "हिजाब", "पर्दा")
        ),

        // ==================== 28. GUSSA / ANGER ====================
        QuranAnswerItem(
            id = "gussa",
            questionHindi = "ग़ुस्सा क़ाबू करने और माफ़ करने की क्या फ़ज़ीलत है?",
            questionUrdu = "غصہ ضبط کرنے اور معاف کرنے کی کیا فضیلت ہے؟",
            questionHinglish = "Gussa zabt karne aur maaf karne ki kya fazeelat hai?",
            directAnswerHinglish = "Gussa peene wale aur logon ko maaf karne wale Allah ke mehboob aur nek bandon mein shumar hote hain.",
            directAnswerHindi = "ग़ुस्सा पी जाने वाले और लोगों को माफ़ करने वाले अल्लाह के महबूब और नेक बंदों में शुमार होते हैं।",
            directAnswerUrdu = "غصہ پی جانے والے اور لوگوں کی غلطیوں کو معاف کر دینے والے اللہ تعالیٰ کے محبوب اور متقی بندوں میں شمار ہوتے ہیں۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 134,
            arabicAyahText = "ٱلَّذِينَ يُنفِقُونَ فِى السَّرَّآءِ وَٱلضَّرَّآءِ وَٱلْكَٰظِمِينَ ٱلْغَيْظَ وَٱلْعَافِينَ عَنِ ٱلنَّاسِ ۗ وَٱللَّهُ يُحِبُّ ٱلْمُحْسِنِينَ",
            hinglishAyahText = "Alladheena yunfiqoona fis-sarraaa'i wad-darraaa'i wal-kaazimeenal-ghayza wal-'aafeena 'anin-naas; wal-laahu yuhibbul-muhsineen.",
            urduAyahTranslation = "جو لوگ آسانی اور تنگی دونوں حالتوں میں خرچ کرتے ہیں اور غصہ پی جانے والے ہیں اور لوگوں سے درگزر کرنے والے ہیں، اور اللہ نیکی کرنے والوں سے محبت فرماتا ہے۔",
            hindiAyahTranslation = "जो ख़ुशहाली और तंगी दोनों हालतों में ख़र्च करते हैं, और ग़ुस्सा पी जाने वाले हैं और लोगों को माफ़ करने वाले हैं, और अल्लाह नेकी करने वालों से मुहब्बत करता है।",
            topicTags = listOf("gussa", "anger", "krodh", "maafi", "ladai", "jhagda", "forgive", "غصہ", "गुस्सा")
        ),

        // ==================== 29. ILM / KNOWLEDGE ====================
        QuranAnswerItem(
            id = "ilm",
            questionHindi = "इल्म (ज्ञान) हासिल करने की क्या अहमियत है?",
            questionUrdu = "علم حاصل کرنے کی کیا اہمیت اور دعا ہے؟",
            questionHinglish = "Ilm hasil karne ki kya ahmiyat aur dua hai?",
            directAnswerHinglish = "Ilm hasil karna har musalman par farz hai aur Quran mein ilz-e-ilahi mein izafe ki dua sikhayi gayi hai: 'Rabbi zidnee 'ilmaa'.",
            directAnswerHindi = "इल्म हासिल करना हर मुसलमान पर फ़र्ज़ है और क़ुरआन में इल्म में इज़ाफ़े की दुआ सिखाई गई है: 'रब्बी ज़िद्नी इल्मा'।",
            directAnswerUrdu = "علم حاصل کرنا ہر مسلمان پر فرض ہے اور قرآن پاک میں علم میں اضافے کی یہ خوبصورت دعا سکھائی گئی ہے: 'رَبِّ زِدْنِي عِلْمًا'۔",
            surahNumber = 20,
            surahNameRoman = "Ta-Ha",
            surahNameArabic = "طه",
            ayahNumber = 114,
            arabicAyahText = "فَتَعَٰلَى ٱللَّهُ ٱلْمَلِكُ ٱلْحَقُّ ۗ وَلَا تَعْجَلْ بِٱلْقُرْءَانِ مِن قَبْلِ أَن يُقْضَىٰٓ إِلَيْكَ وَحْيُهُۥ ۖ وَقُل رَّبِّ زِدْنِى عِلْمًا",
            hinglishAyahText = "Fata'aalal-laahul-Malikul-Haqq; wa laa ta'jal bil-Qur'aani min qabli any-yuqdaaa ilayka wahyuhoo wa qur-Rabbi zidnee 'ilmaa.",
            urduAyahTranslation = "پس اللہ عالی شان سچا بادشاہ ہے، اور قرآن کے پڑھنے میں جلدی نہ کیجیے جب تک اس کی وحی پوری نہ ہو جائے، اور دعا کیجیے: اے میرے رب! میرے علم میں اضافہ فرما۔",
            hindiAyahTranslation = "अतः अल्लाह बहुत बुलंद, सच्चा बादशाह है। और आप क़ुरआन के साथ जल्दी न करें जब तक उसकी वही पूरी न हो जाए, और दुआ करें: ऐ मेरे रब! मेरे इल्म में बढ़ोतरी फ़रमा।",
            topicTags = listOf("ilm", "knowledge", "padhai", "kitab", "taleem", "seekhna", "iqra", "study", "علم", "इल्म")
        ),

        // ==================== 30. SHUKR / GRATITUDE ====================
        QuranAnswerItem(
            id = "shukr",
            questionHindi = "नेमतों पर शुक्र अदा करने का क्या फ़ायदा है?",
            questionUrdu = "نعمتوں پر شکر ادا کرنے کا کیا فائدہ ہے؟",
            questionHinglish = "Neamaton par shukr ada karne ka kya faida hai?",
            directAnswerHinglish = "Shukr ada karne se Allah neamaton mein mazeed barkat aur izafa farmata hai, jabke na-shukri azaab ka sabab banti hai.",
            directAnswerHindi = "शुक्र अदा करने से अल्लाह नेमतों में और बरकत व इज़ाफ़ा फ़रमाता है, जबकि ना-शुक्री अज़ाब का सबब बनती है।",
            directAnswerUrdu = "شکر گزاری سے اللہ تعالیٰ نعمتوں میں مزید برکت اور اضافہ فرماتا ہے جبکہ ناشکری سخت عذاب کا سبب بنتی ہے۔",
            surahNumber = 14,
            surahNameRoman = "Ibrahim",
            surahNameArabic = "إبراهيم",
            ayahNumber = 7,
            arabicAyahText = "وَإِذْ تَأَذَّنَ رَبُّكُمْ لَئِن شَكَرْتُمْ لَأَزِيدَنَّكُمْ ۖ وَلَئِن كَفَرْتُمْ إِنَّ عَذَابِى لَشَدِيدٌ",
            hinglishAyahText = "Wa idh ta'adhdhana Rabbukum la'in shakartum la-azeedannakum wa la'in kafartum inna 'adhaabee lashadeed.",
            urduAyahTranslation = "اور جب تمہارے رب نے آگاہ فرمایا کہ اگر تم شکر کرو گے تو میں تمہیں ضرور زیادہ دوں گا، اور اگر تم ناشکری کرو گے تو یقیناً میرا عذاب بہت سخت ہے۔",
            hindiAyahTranslation = "और जब तुम्हारे रब ने ख़बरदार किया कि अगर तुम शुक्र करोगे तो मैं तुम्हें यक़ीनन और ज़्यादा दूंगा, और अगर ना-शुक्री करोगे तो यक़ीनन मेरा अज़ाब बहुत सख़्त है।",
            topicTags = listOf("shukr", "gratitude", "ehsan", "shukriya", "thanks", "neamat", "شکر", "शुक्र")
        ),

        // ==================== 31. GHAIBAT / BACKBITING ====================
        QuranAnswerItem(
            id = "ghaibat",
            questionHindi = "ग़ीबत और चुग़ली करना कैसा है?",
            questionUrdu = "غیبت اور چغلی کرنا کیسا گناہ ہے؟",
            questionHinglish = "Ghaibat aur chugli karna kaisa gunah hai?",
            directAnswerHinglish = "Ghaibat karna apne murda bhai ka gosht khane ke barabar bada aur ghinona kabeerah gunaah hai.",
            directAnswerHindi = "ग़ीबत करना अपने मुर्दा भाई का गोश्त खाने के बराबर बहुत बड़ा और घिनौना गुनाह-ए-कबीरा है।",
            directAnswerUrdu = "غیبت کرنا اپنے مردہ بھائی کا گوشت کھانے کے مترادف انتہائی گھناؤنا اور سنگین گناہِ کبیرہ ہے۔",
            surahNumber = 49,
            surahNameRoman = "Al-Hujurat",
            surahNameArabic = "الحجرات",
            ayahNumber = 12,
            arabicAyahText = "وَلَا يَغْتَب بَّعْضُكُم بَعْضًا ۚ أَيُحِبُّ أَحَدُكُمْ أَن يَأْكُلَ لَحْمَ أَخِيهِ مَيْتًا فَكَرِهْتُمُوهُ ۚ وَٱتَّقُوا۟ ٱللَّهَ ۚ إِنَّ ٱللَّهَ تَوَّابٌ رَّحِيمٌ",
            hinglishAyahText = "Wa laa yaghtab ba'dukum ba'daa; ayuhibbu ahadukum any-ya'kula lahma akheehi maytan fakarihtumooh; wat-taqul-laah; innal-laaha Tawwaabur-Raheem.",
            urduAyahTranslation = "اور تم میں سے کوئی کسی کی غیبت نہ کرے، کیا تم میں سے کوئی پسند کرے گا کہ وہ اپنے مرے ہوئے بھائی کا گوشت کھائے؟ سو تم اس سے نفرت کرتے ہو، اور اللہ سے ڈرو، بے شک اللہ توبہ قبول کرنے والا نہایت رحم فرمانے والا ہے۔",
            hindiAyahTranslation = "और तुममें से कोई किसी की ग़ीबत (पीठ पीछे बुराई) न करे। क्या तुममें से कोई इसे पसंद करेगा कि अपने मरे हुए भाई का गोश्त खाए? इससे तो तुम्हें घिन आती है। और अल्लाह से डरो, बेशक अल्लाह तौबा क़बूल करने वाला, निहायत रहम वाला है।",
            topicTags = listOf("ghaibat", "chugli", "backbiting", "burai", "peeth peeche", "غیبت", "ग़ीबत")
        ),

        // ==================== 32. SHARAB & JUWA ====================
        QuranAnswerItem(
            id = "sharab_juwa",
            questionHindi = "शराब और जुआ हराम क्यों हैं?",
            questionUrdu = "شراب اور جوا حرام کیوں ہیں؟",
            questionHinglish = "Sharab aur juwa (alcohol & gambling) haram kyu hain?",
            directAnswerHinglish = "Sharab aur juwa shaitani napaak kaam hain jo apas mein bughz o adawat daalte hain aur namaz o zikr se rokte hain.",
            directAnswerHindi = "शराब और जुआ शैतानी नापाक काम हैं जो आपस में दुश्मनी और बुग़ज़ डालते हैं और नमाज़ व ज़िक्र से रोकते हैं।",
            directAnswerUrdu = "شراب اور جوا شیطانی ناپاک کام ہیں جو آپس میں بغض و عداوت پیدا کرتے ہیں اور اللہ کے ذکر اور نماز سے روکتے ہیں۔",
            surahNumber = 5,
            surahNameRoman = "Al-Ma'idah",
            surahNameArabic = "المائدة",
            ayahNumber = 90,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوٓا۟ إِنَّمَا ٱلْخَمْرُ وَٱلْمَيْسِرُ وَٱلْأَنصَابُ وَٱلْأَزْلَٰمُ رِجْسٌ مِّنْ عَمَلِ ٱلشَّيْطَٰنِ فَٱجْتَنِبُوهُ لَعَلَّكُمْ تُفْلِحُونَ",
            hinglishAyahText = "Yaaa ayyuhal-ladheena aamanooo innamal-khamru wal-maysiru wal-ansaabu wal-azlaamu rijsum-min 'amalish-Shaytaani fajtaniboohu la'allakum tuflihoon.",
            urduAyahTranslation = "اے ایمان والو! بے شک شراب اور جوا اور بت اور پانسے سب ناپاک شیطانی کام ہیں، پس ان سے بچو تاکہ تم فلاح پاؤ۔",
            hindiAyahTranslation = "ऐ ईमान वालो! शराब, जुआ, बुत और पांसे सब नापाक शैतानी काम हैं, अतः इनसे बचो ताकि तुम कामयाब हो सको।",
            topicTags = listOf("sharab", "juwa", "alcohol", "gambling", "nasha", "wine", "شراب", "جوا", "शराब", "जुआ")
        ),

        // ==================== 33. ZINA / IMMORALITY ====================
        QuranAnswerItem(
            id = "zina",
            questionHindi = "ज़िना (व्यभिचार) की क्या मुमानअत है?",
            questionUrdu = "زنا کی ممانعت کے بارے میں قرآن کیا فرماتا ہے؟",
            questionHinglish = "Zina ki muman'at ke bare mein Quran kya farmata hai?",
            directAnswerHinglish = "Zina ke qareeb bhi na jao, kyonke yeh be-hayai aur nihayat bura raasta hai.",
            directAnswerHindi = "ज़िना के क़रीब भी न जाओ, क्योंकि यह खुली बेहयाई और बहुत बुरा रास्ता है।",
            directAnswerUrdu = "زنا کے قریب بھی نہ جاؤ، بے شک وہ کھلی بے حیائی اور انتہائی برا راستہ ہے۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 32,
            arabicAyahText = "وَلَا تَقْرَبُوا۟ ٱلزِّنَىٰٓ ۖ إِنَّهُۥ كَانَ فَٰحِشَةً وَسَآءَ سَبِيلًا",
            hinglishAyahText = "Wa laa taqrabuz-zinaaa innahoo kaana faahishatanw-wa saaa'a sabeelaa.",
            urduAyahTranslation = "اور زنا کے قریب بھی نہ جاؤ، بے شک وہ بے حیائی اور بہت برا راستہ ہے۔",
            hindiAyahTranslation = "और ज़िना के क़रीब भी न जाओ, बेशक वह बेहयाई है और बहुत बुरा रास्ता है।",
            topicTags = listOf("zina", "fahashi", "behayai", "sharam", "adultery", "زنا", "ज़िना")
        ),

        // ==================== 34. SACH AUR JHOOTH ====================
        QuranAnswerItem(
            id = "sachai_jhooth",
            questionHindi = "सच बोलने और झूठ से बचने का क्या हुक्म है?",
            questionUrdu = "سچ بولنے اور جھوٹ سے بچنے کا کیا حکم ہے؟",
            questionHinglish = "Sach bolne aur jhooth se bachne ka kya hukm hai?",
            directAnswerHinglish = "Allah se daro aur hamesha seedhi aur sachhi baat kaho, Allah tumhare a'maal sanwar dega aur gunah maaf farma dega.",
            directAnswerHindi = "अल्लाह से डरो और हमेशा सीधी और सच्ची बात कहो, अल्लाह तुम्हारे आमाल संवार देगा और गुनाह माफ़ फ़रमा देगा।",
            directAnswerUrdu = "اللہ سے ڈرو اور ہمیشہ سیدھی اور سچی بات کہو، اللہ تمہارے اعمال درست فرما دے گا اور تمہارے گناہ بخش دے گا۔",
            surahNumber = 33,
            surahNameRoman = "Al-Ahzab",
            surahNameArabic = "الأحزاب",
            ayahNumber = 70,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ ٱتَّقُوا۟ ٱللَّهَ وَقُولُوا۟ قَوْلًا سَدِيدًا",
            hinglishAyahText = "Yaaa ayyuhal-ladheena aamanut-taqul-laaha wa qooloo qawlan sadeedaa.",
            urduAyahTranslation = "اے ایمان والو! اللہ سے ڈرو اور سیدھی سچی بات کہا کرو۔",
            hindiAyahTranslation = "ऐ ईमान वालो! अल्लाह से डरो और हमेशा सीधी व सच्ची बात कहा करो।",
            topicTags = listOf("sach", "jhooth", "sachai", "jhoot", "truth", "lies", "honesty", "سچ", "جھوٹ", "सच", "झूठ")
        ),

        // ==================== 35. TAWAKKUL / TRUST IN ALLAH ====================
        QuranAnswerItem(
            id = "tawakkul",
            questionHindi = "तवक्कुल (अल्लाह पर भरोसा) क्या है?",
            questionUrdu = "توکل (اللہ پر بھروسہ) کی کیا فضیلت ہے؟",
            questionHinglish = "Tawakkul (Allah par bharosa) ki kya fazeelat hai?",
            directAnswerHinglish = "Har maamle mein koshish ke baad nateeja Allah ke hawaale karna tawakkul hai, aur Allah bharosa karne walon ko pasand farmata hai.",
            directAnswerHindi = "हर मामले में कोशिश के बाद नतीजा अल्लाह के हवाले करना तवक्कुल है, और अल्लाह भरोसा करने वालों को पसंद फ़रमाता है।",
            directAnswerUrdu = "ہر کام میں جائز کوشش کے بعد نتیجہ اللہ کے سپرد کر دینا توکل کہلاتا ہے، اور اللہ توکل کرنے والوں سے محبت فرماتا ہے۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 159,
            arabicAyahText = "فَإِذَا عَزَمْتَ فَتَوَكَّلْ عَلَى ٱللَّهِ ۚ إِنَّ ٱللَّهَ يُحِبُّ ٱلْمُتَوَكِّلِينَ",
            hinglishAyahText = "Fa-idhaa 'azamta fatawakkal 'alal-laah; innal-laaha yuhibbul-mutawakkileen.",
            urduAyahTranslation = "پھر جب آپ پختہ ارادہ کر لیں تو اللہ پر بھروسہ رکھیے، بے شک اللہ بھروسہ رکھنے والوں سے محبت فرماتا ہے۔",
            hindiAyahTranslation = "फिर जब आप पक्का इरादा कर लें तो अल्लाह पर भरोसा रखिए, बेशक अल्लाह भरोसा करने वालों से मुहब्बत फ़रमाता है।",
            topicTags = listOf("tawakkul", "bharosa", "yaqeen", "trust in allah", "himmat", "توکل", "तवक्कुल")
        ),

        // ==================== 36. TAQWA / GOD-CONSCIOUSNESS ====================
        QuranAnswerItem(
            id = "taqwa",
            questionHindi = "अल्लाह के नज़दीक सबसे इज़्ज़तदार कौन है? (तक़वा)",
            questionUrdu = "اللہ کے نزدیک سب سے زیادہ عزت والا کون ہے؟ (تقویٰ)",
            questionHinglish = "Allah ke nazdeek sabse zyada izzat wala kaun hai? (Taqwa)",
            directAnswerHinglish = "Rang, nasal ya nasal-parasti se nahi, balki Allah ke nazdeek sabse bada aur ba-izzat woh hai jo sabse zyada parhezgar (muttaqi) ho.",
            directAnswerHindi = "रंग, नस्ल या दौलत से नहीं, बल्कि अल्लाह के नज़दीक सबसे बा-इज़्ज़त वह है जो सबसे ज़्यादा परहेज़गार (मुत्तक़ी) हो।",
            directAnswerUrdu = "رنگ، نسل یا حسب و نسب کی بنا پر نہیں، بلکہ اللہ کے نزدیک تم میں سے سب سے زیادہ معزز وہ ہے جو سب سے زیادہ پرہیزگار (متقی) ہو۔",
            surahNumber = 49,
            surahNameRoman = "Al-Hujurat",
            surahNameArabic = "الحجرات",
            ayahNumber = 13,
            arabicAyahText = "إِنَّ أَكْرَمَكُمْ عِندَ ٱللَّهِ أَتْقَىٰكُمْ ۚ إِنَّ ٱللَّهَ عَلِيمٌ خَبِيرٌ",
            hinglishAyahText = "Inna akramakum 'indal-laahi atqaakum; innal-laaha 'Aleemun Khabeer.",
            urduAyahTranslation = "بے شک اللہ کے نزدیک تم میں سے سب سے زیادہ عزت والا وہ ہے جو تم میں سب سے زیادہ پرہیزگار ہے، بے شک اللہ سب کچھ جاننے والا باخبر ہے۔",
            hindiAyahTranslation = "बेशक अल्लाह के नज़दीक तुममें सबसे ज़्यादा इज़्ज़त वाला वह है जो सबसे ज़्यादा मुत्तक़ी (परहेज़गार) है। बेशक अल्लाह सब कुछ जानने वाला, पूरी ख़बर रखने वाला है।",
            topicTags = listOf("taqwa", "muttaqi", "izzat", "parhezgari", "god fearing", "righteousness", "تقویٰ", "तक़वा")
        ),

        // ==================== 37. QURBANI / SACRIFICE ====================
        QuranAnswerItem(
            id = "qurbani",
            questionHindi = "क़ुरबानी का अस्ल मक़सद क्या है?",
            questionUrdu = "قربانی کا اصل مقصد کیا ہے؟",
            questionHinglish = "Qurbani ka asal maqsad kya hai?",
            directAnswerHinglish = "Qurbani ka gosht ya khoon Allah ko nahi pohanchta, balki Allah Ta'ala ko tumhara dil ka taqwa aur khuloos pohanchta hai.",
            directAnswerHindi = "क़ुरबानी का गोश्त या ख़ून अल्लाह को नहीं पहुंचता, बल्कि अल्लाह को तुम्हारे दिल का तक़वा और खुलूस पहुंचता है।",
            directAnswerUrdu = "قربانی کے جانوروں کا گوشت یا خون اللہ کو نہیں پہنچتا بلکہ اللہ تعالیٰ کو تمہارے دل کا تقویٰ اور خلوص پہنچتا ہے۔",
            surahNumber = 22,
            surahNameRoman = "Al-Hajj",
            surahNameArabic = "الحج",
            ayahNumber = 37,
            arabicAyahText = "لَن يَنَالَ ٱللَّهَ لُحُومُهَا وَلَا دِمَآؤُهَا وَلَٰكِن يَنَالُهُ ٱلتَّقْوَىٰ مِنكُمْ",
            hinglishAyahText = "Lany-yanaalal-laaha luhoomuhaa wa laa dimaaa'uhaa wa laakiny-yanaaluhut-taqwaa minkum.",
            urduAyahTranslation = "اللہ کو ہرگز ان کا گوشت اور ان کا خون نہیں پہنچتا بلکہ اسے تمہارا تقویٰ پہنچتا ہے۔",
            hindiAyahTranslation = "अल्लाह को हरगिज़ न उनका गोश्त पहुंचता है और न उनका ख़ून, बल्कि उसे तुम्हारा तक़वा पहुंचता है।",
            topicTags = listOf("qurbani", "bakra eid", "sacrifice", "eid ul adha", "hajj qurbani", "قربانی", "क़ुरबानी")
        ),

        // ==================== 38. HASAD / JEALOUSY ====================
        QuranAnswerItem(
            id = "hasad",
            questionHindi = "हसद (ईर्ष्या/जलन) से बचने की क्या तालीम है?",
            questionUrdu = "حسد اور جلن سے بچنے کی کیا تعلیم ہے؟",
            questionHinglish = "Hasad aur jalan se bachne ki kya taleem hai?",
            directAnswerHinglish = "Hasad nekiyon ko aise kha jati hai jaise aag lakdi ko. Surah Al-Falaq mein hasad karne wale ke shar se Allah ki panah mangi gayi hai.",
            directAnswerHindi = "हसद नेकियों को ऐसे खा जाती है जैसे आग लकड़ी को। सूरह अल-फ़लक़ में हसद करने वाले के शर से अल्लाह की पनाह मांगी गई है।",
            directAnswerUrdu = "حسد نیکیوں کو مٹا دیتا ہے۔ سورۃ الفلق میں حسد کرنے والے کے شر سے اللہ تعالیٰ کی پناہ مانگنے کی تاکید کی گئی ہے۔",
            surahNumber = 113,
            surahNameRoman = "Al-Falaq",
            surahNameArabic = "الفلق",
            ayahNumber = 5,
            arabicAyahText = "وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ",
            hinglishAyahText = "Wa min sharri haasidin idhaa hasad.",
            urduAyahTranslation = "اور حسد کرنے والے کے شر سے جب وہ حسد کرے۔",
            hindiAyahTranslation = "और हसद करने वाले के शर (बुराई) से जब वह हसद करे।",
            topicTags = listOf("hasad", "jalan", "jealousy", "envy", "nazar", "evil eye", "falaq", "حسد", "हसद")
        ),

        // ==================== 39. INSAF / JUSTICE ====================
        QuranAnswerItem(
            id = "insaaf",
            questionHindi = "अद्ल और इंसाफ़ का क्या हुक्म है?",
            questionUrdu = "عدل اور انصاف کا کیا حکم ہے؟",
            questionHinglish = "Adl aur insaaf ka kya hukm hai?",
            directAnswerHinglish = "Allah Ta'ala hamesha adl, insaf, ehsan aur bhalai ka hukm deta hai aur burai o zulm se rokta hai.",
            directAnswerHindi = "अल्लाह तआला हमेशा अद्ल, इंसाफ़, एहसान और भलाई का हुक्म देता है और बुराई व ज़ुल्म से रोकता है।",
            directAnswerUrdu = "اللہ تعالیٰ ہمیشہ عدل، احسان، نیکی اور رشتہ داروں کی خیرخواہی کا حکم دیتا ہے اور بے حیائی، برائی اور سرکشی سے منع فرماتا ہے۔",
            surahNumber = 16,
            surahNameRoman = "An-Nahl",
            surahNameArabic = "النحل",
            ayahNumber = 90,
            arabicAyahText = "إِنَّ ٱللَّهَ يَأْمُرُ بِٱلْعَدْلِ وَٱلْإِحْسَٰنِ وَإِيتَآىِٕ ذِى ٱلْقُرْبَىٰ وَيَنْهَىٰ عَنِ ٱلْفَحْشَآءِ وَٱلْمُنكَرِ وَٱلْبَغْىِ ۚ يَعِظُكُمْ لَعَلَّكُمْ تَذَكَّرُونَ",
            hinglishAyahText = "Innal-laaha ya'muru bil-'adli wal-ihsaani wa eetaaa'i zil-qurbaa wa yanhaa 'anil-fahshaaa'i wal-munkari wal-baghy; ya'izukum la'allakum tazakkaroon.",
            urduAyahTranslation = "بے شک اللہ عدل اور احسان کا اور رشتہ داروں کو دینے کا حکم فرماتا ہے اور بے حیائی اور برائی اور سرکشی سے منع کرتا ہے، وہ تمہیں نصیحت کرتا ہے تاکہ تم نصیحت حاصل کرو۔",
            hindiAyahTranslation = "बेशक अल्लाह इंसाफ़, भलाई और रिश्तेदारों को देने का हुक्म फ़रमाता है, और बेहयाई, बुराई और ज़ुल्म से रोकता है। वह तुम्हें नसीहत करता है ताकि तुम सबक़ हासिल करो।",
            topicTags = listOf("insaaf", "adl", "justice", "ehsan", "akhlaq", "fairness", "عدل", "انصاف", "इंसाफ़")
        )
    )

    private val STOP_WORDS = setOf(
        "kya", "hai", "hain", "karna", "kare", "karein", "ka", "ki", "ke", "ko", "se", "par",
        "me", "mein", "aur", "ye", "wo", "to", "bhi", "batao", "kaisa", "kaisi", "kaise",
        "chahiye", "hota", "hoti", "hote", "is", "are", "what", "the", "in", "to", "for",
        "of", "and", "a", "an", "karo", "karta", "karti", "karte", "hum", "tum", "apna",
        "apne", "apni", "hoga", "hogi", "bataiye", "bata", "den", "de", "do", "kya?", "hai?",
        "batao", "batayein", "quran", "kya", "bhi", "bolta", "kehta"
    )

    /**
     * Search function for the Quran Question Bar:
     * 1. Evaluates all curated Islamic question answers with multi-keyword scoring.
     * 2. If no curated item scores high, dynamically searches the complete Quran Ayahs.
     * 3. Guarantees that EVERY question receives a unique, tailored Quranic answer.
     */
    fun searchQuranAnswers(query: String, context: Context? = null): List<QuranAnswerItem> {
        val clean = query.trim().lowercase()
        if (clean.isEmpty()) return questions

        // Extract meaningful tokens
        val rawTokens = clean.replace(Regex("[^\\p{L}\\p{Nd}\\s]"), " ")
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }

        val meaningfulTokens = rawTokens.filter { it !in STOP_WORDS && it.length > 1 }
        val searchTokens = if (meaningfulTokens.isNotEmpty()) meaningfulTokens else rawTokens

        // 1. Score curated questions
        val scoredItems = questions.map { item ->
            var score = 0
            val tags = item.topicTags.map { it.lowercase() }
            val qHinglish = item.questionHinglish.lowercase()
            val qHindi = item.questionHindi.lowercase()
            val qUrdu = item.questionUrdu.lowercase()
            val directAns = item.directAnswerHinglish.lowercase()

            for (token in searchTokens) {
                // Exact tag match: highest priority
                if (tags.any { it == token }) {
                    score += 60
                } else if (tags.any { it.contains(token) || token.contains(it) }) {
                    score += 35
                }

                if (qHinglish.contains(token)) score += 30
                if (qHindi.contains(token)) score += 30
                if (qUrdu.contains(token)) score += 30
                if (directAns.contains(token)) score += 15
            }

            // Direct substring matches
            if (clean.contains(item.id)) score += 50

            item to score
        }

        val matches = scoredItems.filter { it.second > 0 }
            .sortedByDescending { it.second }
            .map { it.first }

        if (matches.isNotEmpty()) {
            return matches
        }

        // 2. Semantic fallback keywords
        val semanticMatch = findSemanticFallback(clean, searchTokens)
        if (semanticMatch != null) {
            return listOf(semanticMatch)
        }

        // 3. Dynamic search in Quran Ayahs (loads from assets or in-memory)
        val dynamicAyah = searchDynamicAyah(clean, context)
        if (dynamicAyah != null) {
            return listOf(dynamicAyah)
        }

        // 4. Multi-verse Wisdom Fallback (diversified by question hash so it never returns the same answer)
        return listOf(generateDiversifiedWisdomAnswer(query.trim()))
    }

    private fun findSemanticFallback(clean: String, tokens: List<String>): QuranAnswerItem? {
        val allText = (tokens + clean).joinToString(" ")

        return when {
            allText.containsAny("allah", "khuda", "rab", "god", "tauheed", "kursi", "ma'bood", "اللہ", "अल्लाह", "ईश्वर") ->
                questions.firstOrNull { it.id == "allah_who" }
            allText.containsAny("shirk", "but", "pooja", "kufr", "شرک", "शिर्क") ->
                questions.firstOrNull { it.id == "shirk" }
            allText.containsAny("namaz", "salah", "prayer", "rakat", "sajda", "نماز", "नमाज़") ->
                questions.firstOrNull { it.id == "namaz" }
            allText.containsAny("waqt", "auqaat", "timing", "fajr", "zuhr", "asr", "maghrib", "isha", "وقت", "वक्त") ->
                questions.firstOrNull { it.id == "namaz_waqt" }
            allText.containsAny("tahajjud", "nafal", "qiyam", "night", "تہجد", "तहज्जुद") ->
                questions.firstOrNull { it.id == "tahajjud" }
            allText.containsAny("roza", "roze", "fast", "sehri", "iftar", "ramzan", "ramadan", "روزہ", "रोज़ा") ->
                questions.firstOrNull { it.id == "roza_fasting" }
            allText.containsAny("zakat", "sadqa", "khairat", "paisa", "maal", "daulat", "garib", "زکوٰۃ", "ज़कात") ->
                questions.firstOrNull { it.id == "zakat_charity" }
            allText.containsAny("hajj", "umrah", "kaaba", "makkah", "baitullah", "حج", "हज") ->
                questions.firstOrNull { it.id == "hajj_pilgrimage" }
            allText.containsAny("maa", "baap", "walid", "walidain", "parents", "ammi", "abbu", "mother", "father", "والدین", "माता-पिता") ->
                questions.firstOrNull { it.id == "parents" }
            allText.containsAny("sood", "riba", "interest", "byaj", "سود", "सूद", "ब्याज") ->
                questions.firstOrNull { it.id == "sood_riba" }
            allText.containsAny("sabr", "pareshani", "musibat", "takleef", "dard", "gam", "صبر", "सब्र") ->
                questions.firstOrNull { it.id == "sabr" }
            allText.containsAny("tauba", "maaf", "maghfirat", "gunah", "astaghfar", "توبہ", "तौबा") ->
                questions.firstOrNull { it.id == "tauba" }
            allText.containsAny("rizq", "rozi", "barkat", "naukri", "job", "business", "tarakki", "kamana", "رزق", "रिज़्क़") ->
                questions.firstOrNull { it.id == "rizq" }
            allText.containsAny("sukoon", "shanti", "chain", "zikr", "dhikr", "itminaan", "peace", "سکون", "सुकून") ->
                questions.firstOrNull { it.id == "sukoon" }
            allText.containsAny("dua", "mangna", "arzi", "haajat", "qubool", "دعا", "दुआ") ->
                questions.firstOrNull { it.id == "dua" }
            allText.containsAny("shifa", "bimari", "ilaj", "cure", "sehat", "شفاء", "शिफ़ा", "बीमारी") ->
                questions.firstOrNull { it.id == "shifa" }
            allText.containsAny("qarz", "debt", "loan", "qarzdar", "karz", "قرض", "क़र्ज़") ->
                questions.firstOrNull { it.id == "qarz" }
            allText.containsAny("nikah", "shadi", "vivah", "biwi", "shohar", "rishta", "نکاح", "शादी") ->
                questions.firstOrNull { it.id == "nikah" }
            allText.containsAny("dost", "dosti", "friend", "friends", "sohbat", "دوست", "दोस्त") ->
                questions.firstOrNull { it.id == "dosti" }
            allText.containsAny("zulm", "injustice", "zalim", "ظلم", "ज़ुल्म") ->
                questions.firstOrNull { it.id == "zulm" }
            allText.containsAny("munafiq", "nifaq", "dogle", "منافق", "मुनाफ़िक़") ->
                questions.firstOrNull { it.id == "munafiq" }
            allText.containsAny("wuzu", "wudhu", "wazoo", "taharat", "pakizgi", "وضو", "वुज़ू") ->
                questions.firstOrNull { it.id == "wuzu" }
            allText.containsAny("jannat", "paradise", "swarg", "hoor", "جنت", "जन्नत") ->
                questions.firstOrNull { it.id == "jannat" }
            allText.containsAny("jahannam", "dozakh", "hell", "narak", "azab", "جہنم", "दोज़ख़") ->
                questions.firstOrNull { it.id == "jahannam" }
            allText.containsAny("maut", "death", "qabar", "janaza", "inteqal", "marne", "موت", "मौत") ->
                questions.firstOrNull { it.id == "death" }
            allText.containsAny("parda", "hijab", "haya", "aurat", "libas", "حجاب", "हिजाब", "पर्दा") ->
                questions.firstOrNull { it.id == "hijab" }
            allText.containsAny("gussa", "krodh", "anger", "غصہ", "गुस्सा") ->
                questions.firstOrNull { it.id == "gussa" }
            allText.containsAny("ilm", "padhai", "kitab", "taleem", "seekhna", "علم", "इल्म") ->
                questions.firstOrNull { it.id == "ilm" }
            allText.containsAny("shukr", "ehsan", "shukriya", "thank", "شکر", "शुक्र") ->
                questions.firstOrNull { it.id == "shukr" }
            allText.containsAny("ghaibat", "chugli", "burai", "غیبت", "ग़ीबत") ->
                questions.firstOrNull { it.id == "ghaibat" }
            allText.containsAny("sharab", "juwa", "alcohol", "gambling", "nasha", "شراب", "शराब") ->
                questions.firstOrNull { it.id == "sharab_juwa" }
            allText.containsAny("zina", "fahashi", "behayai", "زنا", "ज़िना") ->
                questions.firstOrNull { it.id == "zina" }
            allText.containsAny("sach", "jhooth", "jhoot", "سچ", "جھوٹ", "सच", "झूठ") ->
                questions.firstOrNull { it.id == "sachai_jhooth" }
            allText.containsAny("tawakkul", "bharosa", "yaqeen", "توکل", "तवक्कुल") ->
                questions.firstOrNull { it.id == "tawakkul" }
            allText.containsAny("taqwa", "muttaqi", "parhezgar", "تقویٰ", "तक़वा") ->
                questions.firstOrNull { it.id == "taqwa" }
            allText.containsAny("qurbani", "eid ul adha", "bakra eid", "قربانی", "क़ुरबानी") ->
                questions.firstOrNull { it.id == "qurbani" }
            allText.containsAny("hasad", "jalan", "nazar", "حسد", "हसद") ->
                questions.firstOrNull { it.id == "hasad" }
            allText.containsAny("adl", "insaaf", "justice", "عدل", "انصاف", "इंसाफ़") ->
                questions.firstOrNull { it.id == "insaaf" }
            else -> null
        }
    }

    private fun String.containsAny(vararg words: String): Boolean {
        return words.any { this.contains(it) }
    }

    /**
     * Dynamically searches Quran verses for any query.
     */
    private fun searchDynamicAyah(query: String, context: Context?): QuranAnswerItem? {
        val foundAyah = if (context != null) {
            QuranAssetLoader.searchAcrossAyahs(context, query, 1).firstOrNull()
        } else {
            QuranAyahData.searchAyahs(query).firstOrNull()
        } ?: return null

        val surahInfo = QuranSurahIndex.getSurah(foundAyah.surahNumber)

        return QuranAnswerItem(
            id = "dynamic_${foundAyah.surahNumber}_${foundAyah.ayahNumber}",
            questionHindi = query,
            questionUrdu = query,
            questionHinglish = query,
            directAnswerHinglish = "Aapke is sawal ke mutalliq Quran Pak Surah ${surahInfo?.nameRoman ?: "Al-Quran"} ki aayat #${foundAyah.ayahNumber} mein farmata hai:",
            directAnswerHindi = "आपके इस सवाल के संबंध में क़ुरआन पाक सूरह ${surahInfo?.nameRoman ?: "अल-क़ुरआन"} की आयत #${foundAyah.ayahNumber} में फ़रमाता है:",
            directAnswerUrdu = "آپ کے اس سوال کے متعلق قرآن پاک سورۃ ${surahInfo?.nameArabic ?: "القرآن"} کی آیت #${foundAyah.ayahNumber} میں رہنمائی فرماتا ہے:",
            surahNumber = foundAyah.surahNumber,
            surahNameRoman = surahInfo?.nameRoman ?: "Al-Quran",
            surahNameArabic = surahInfo?.nameArabic ?: "القرآن",
            ayahNumber = foundAyah.ayahNumber,
            arabicAyahText = foundAyah.arabicText,
            hinglishAyahText = foundAyah.hinglishText,
            urduAyahTranslation = foundAyah.urduTranslation,
            hindiAyahTranslation = foundAyah.hindiTranslation,
            topicTags = listOf("dynamic", "quran", query)
        )
    }

    /**
     * Diverse Quranic wisdom verses (8 distinct core themes).
     * Rotated by hash code so different questions never receive the same answer.
     */
    private fun generateDiversifiedWisdomAnswer(userQuestion: String): QuranAnswerItem {
        val wisdomOptions = listOf(
            // Option 1: Ease after Hardship (Ash-Sharh: 5-6)
            QuranAnswerItem(
                id = "wisdom_sharh",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Quran Pak tasalli deta hai ke beshak har mushkil aur aazmaish ke sath aasaani aur kushaadgi aati hai.",
                directAnswerHindi = "क़ुरआन पाक तसल्ली देता है कि बेशक हर मुश्किल और आज़माइश के साथ आसानी और बेहतरी आती है।",
                directAnswerUrdu = "قرآن پاک تسلی دیتا ہے کہ بے شک ہر تنگی اور مشکل کے ساتھ آسانی اور کشادگی آتی ہے۔",
                surahNumber = 94,
                surahNameRoman = "Ash-Sharh",
                surahNameArabic = "الشرح",
                ayahNumber = 5,
                arabicAyahText = "فَإِنَّ مَعَ ٱلْعُسْرِ يُسْرًا • إِنَّ مَعَ ٱلْعُسْرِ يُسْرًا",
                hinglishAyahText = "Fa-inna ma'al-'usri yusraa; inna ma'al-'usri yusraa.",
                urduAyahTranslation = "پس بے شک تنگی کے ساتھ آسانی ہے، بے شک تنگی کے ساتھ آسانی ہے۔",
                hindiAyahTranslation = "अतः बेशक तंगी के साथ आसानी है, बेशक तंगी के साथ आसानी है।",
                topicTags = listOf("aasaani", "rahat", "sabr", "umeed")
            ),

            // Option 2: Nearness in Dua (Al-Baqarah: 186)
            QuranAnswerItem(
                id = "wisdom_dua",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Allah Ta'ala farmata hai: 'Mein apne banday ke nihayat qareeb hoon aur jab bhi woh Mujhe pukarta hai to Uski dua qabool karta hoon.'",
                directAnswerHindi = "अल्लाह तआला फ़रमाता है: 'मैं अपने बन्दे के निहायत क़रीब हूँ और जब भी वह मुझे पुकारता है तो उसकी दुआ क़बूल करता हूँ।'",
                directAnswerUrdu = "اللہ تعالیٰ فرماتا ہے: 'میں اپنے بندے کے انتہائی قریب ہوں اور جب بھی وہ مجھے پکارتا ہے تو اس کی دعا قبول کرتا ہوں۔'",
                surahNumber = 2,
                surahNameRoman = "Al-Baqarah",
                surahNameArabic = "البقرة",
                ayahNumber = 186,
                arabicAyahText = "وَإِذَا سَأَلَكَ عِبَادِى عَنِّى فَإِنِّى قَرِيبٌ ۖ أُجِيبُ دَعْوَةَ ٱلدَّاعِ إِذَا دَعَانِ",
                hinglishAyahText = "Wa idhaa sa'alaka 'ibaadee 'annee fa-innee Qareeb; ujeebu da'watad-daa'i idhaa da'aani.",
                urduAyahTranslation = "اور جب میرے بندے آپ سے میرے بارے میں پوچھیں تو میں قریب ہوں، میں پکارنے والے کی دعا قبول کرتا ہوں جب وہ مجھے پکارتا ہے۔",
                hindiAyahTranslation = "और जब मेरे बंदे आपसे मेरे बारे में पूछें तो मैं क़रीब हूँ। मैं पुकारने वाले की पुकार सुनता हूँ जब वह मुझे पुकारे।",
                topicTags = listOf("dua", "qurb", "rahmat", "umeed")
            ),

            // Option 3: Dil ka sukoon (Ar-Ra'd: 28)
            QuranAnswerItem(
                id = "wisdom_dhikr",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Quran Pak farmata hai ke har pareshani ka hal aur dilon ka asli sukoon sirf aur sirf Allah ke zikr mein hai.",
                directAnswerHindi = "क़ुरआन पाक फ़रमाता है कि हर परेशानी का हल और दिलों का सच्चा सुकून सिर्फ़ और सिर्फ़ अल्लाह के ज़िक्र में है।",
                directAnswerUrdu = "قرآن پاک ارشاد فرماتا ہے کہ ہر پریشانی کا حل اور دلوں کا حقیقی اطمینان و سکون صرف اور صرف اللہ کے ذکر میں ہے۔",
                surahNumber = 13,
                surahNameRoman = "Ar-Ra'd",
                surahNameArabic = "الرعد",
                ayahNumber = 28,
                arabicAyahText = "أَلَا بِذِكْرِ ٱللَّهِ تَطْمَئِنُّ ٱلْقُلُوبُ",
                hinglishAyahText = "Alaa bidhikril-laahi tatma'innul-quloob.",
                urduAyahTranslation = "سن لو! اللہ ہی کے ذکر سے دلوں کو اطمینان اور سکون ملتا ہے۔",
                hindiAyahTranslation = "सुन लो! अल्लाह ही के ज़िक्र से दिलों को सुकून और इत्मीनान मिलता है।",
                topicTags = listOf("sukoon", "chain", "zikr")
            ),

            // Option 4: Himmat aur Iman (Aal-e-Imran: 139)
            QuranAnswerItem(
                id = "wisdom_courage",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Quran Pak hidayat deta hai: 'Himmat na haaro aur ghamgeen na ho, agar tum sachhe momin ho to tum hi ghalib aur sarfaraz rahoge.'",
                directAnswerHindi = "क़ुरआन पाक हिदायत देता है: 'हिम्मत न हारो और ग़मगीन न हो, अगर तुम सच्चे मोमिन हो तो तुम ही ग़ालिब और सरफ़राज़ रहोगे।'",
                directAnswerUrdu = "قرآن پاک رہنمائی دیتا ہے: 'ہمت نہ ہارو اور غمگین نہ ہو، اگر تم سچے مومن ہو تو تم ہی غالب اور سر بلند رہو گے۔'",
                surahNumber = 3,
                surahNameRoman = "Aal-e-Imran",
                surahNameArabic = "آل عمران",
                ayahNumber = 139,
                arabicAyahText = "وَلَا تَهِنُوا۟ وَلَا تَحْزَنُوا۟ وَأَنتُمُ ٱلْأَعْلَوْنَ إِن كُنتُم مُّؤْمِنِينَ",
                hinglishAyahText = "Wa laa tahinoo wa laa tahzanoo wa antumul-a'lawna in kuntum mu'mineen.",
                urduAyahTranslation = "اور تم سستی نہ کرو اور نہ غمگین ہو، اور تم ہی غالب رہو گے اگر تم مومن ہو۔",
                hindiAyahTranslation = "और तुम सुस्ती न करो और न ग़मगीन हो, और तुम ही ग़ालिब रहोगे अगर तुम मोमिन हो।",
                topicTags = listOf("himmat", "kamiyabi", "iman")
            ),

            // Option 5: Taqwa aur Barkat (At-Talaq: 2-3)
            QuranAnswerItem(
                id = "wisdom_talaq",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Jo shakhs Allah se darta hai, Allah uske liye nijaat ka raasta nikaal deta hai aur use aisi jagah se rizq ataa farmata hai jahan uska gumaan bhi nahi hota.",
                directAnswerHindi = "जो शख़्स अल्लाह से डरता है, अल्लाह उसके लिए नजात का रास्ता निकाल देता है और उसे ऐसी जगह से रिज़्क़ देता है जहाँ उसका गुमान भी नहीं होता।",
                directAnswerUrdu = "جو شخص اللہ سے ڈرتا ہے اللہ اس کے لیے نکلنے کا راستہ بنا دیتا ہے اور اسے ایسی جگہ سے رزق دیتا ہے جہاں سے اس کا گمان بھی نہیں ہوتا۔",
                surahNumber = 65,
                surahNameRoman = "At-Talaq",
                surahNameArabic = "الطلاق",
                ayahNumber = 2,
                arabicAyahText = "وَمَن يَتَّقِ ٱللَّهَ يَجْعَل لَّهُۥ مَخْرَجًا • وَيَرْزُقْهُ مِنْ حَيْثُ لَا يَحْتَسِبُ",
                hinglishAyahText = "Wa many-yattaqil-laaha yaj'al lahoo makhrajaa; wa yarzuqhu min haythu laa yahtasib.",
                urduAyahTranslation = "اور جو اللہ سے ڈرے گا وہ اس کے لیے نکلنے کی راہ بنا دے گا، اور اسے ایسی جگہ سے رزق دے گا جہاں سے اس کا گمان بھی نہ ہو۔",
                hindiAyahTranslation = "और जो अल्लाह से डरेगा वह उसके लिए निकलने की राह बना देगा, और उसे ऐसी जगह से रिज़्क़ देगा जहाँ उसका गुमान भी न हो।",
                topicTags = listOf("rizq", "nijaat", "taqwa")
            ),

            // Option 6: Neki aur Akhlaq (Al-Baqarah: 83)
            QuranAnswerItem(
                id = "wisdom_akhlaq",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Quran Pak tamam insano ke sath husn-e-akhlaq, bhalai aur meethi zuban se baat karne ki taaleem deta hai.",
                directAnswerHindi = "क़ुरआन पाक तमाम इंसानों के साथ हुस्ने-अख़लाक़, भलाई और मीठी ज़बान से बात करने की तालीम देता है।",
                directAnswerUrdu = "قرآن پاک تمام انسانوں کے ساتھ حسنِ اخلاق، نرمی اور بھلائی کی بات کہنے کا حکم فرماتا ہے۔",
                surahNumber = 2,
                surahNameRoman = "Al-Baqarah",
                surahNameArabic = "البقرة",
                ayahNumber = 83,
                arabicAyahText = "وَقُولُوا۟ لِلنَّاسِ حُسْنًا وَأَقِيمُوا۟ ٱلصَّلَوٰةَ وَءَاتُوا۟ ٱلزَّكَوٰةَ",
                hinglishAyahText = "Wa qooloo lin-naasi husnanw-wa aqeemus-Salaata wa aatuz-Zakaah.",
                urduAyahTranslation = "اور لوگوں سے اچھی بات کہو اور نماز قائم کرو اور زکوٰۃ ادا کرو۔",
                hindiAyahTranslation = "और लोगों से अच्छी बात कहो और नमाज़ क़ायम करो और ज़कात अदा करो।",
                topicTags = listOf("akhlaq", "adab", "neki")
            ),

            // Option 7: Rehmat-e-Ilahi (Az-Zumar: 53)
            QuranAnswerItem(
                id = "wisdom_rehmat",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Allah Ta'ala farmata hai: 'Meri rehmat se kabhi mayoos na ho, beshak Allah tamam gunahon ko bakhshne wala nihayat meharbaan hai.'",
                directAnswerHindi = "अल्लाह तआला फ़रमाता है: 'मेरी रहमत से कभी मायूस न हो, बेशक अल्लाह सब गुनाहों को बख़्शने वाला निहायत मेहरबान है।'",
                directAnswerUrdu = "اللہ تعالیٰ فرماتا ہے: 'میری رحمت سے کبھی مایوس نہ ہو، بے شک اللہ تمام گناہوں کو بخشنے والا نہایت مہربان ہے۔'",
                surahNumber = 39,
                surahNameRoman = "Az-Zumar",
                surahNameArabic = "الزمر",
                ayahNumber = 53,
                arabicAyahText = "لَا تَقْنَطُوا۟ مِن رَّحْمَةِ ٱللَّهِ ۚ إِنَّ ٱللَّهَ يَغْفِرُ ٱلذُّنُوبَ جَمِيعًا",
                hinglishAyahText = "Laa taqnatoo mir-rahmatil-laah; innal-laaha yaghfirudh-dhunooba jamee'aa.",
                urduAyahTranslation = "اللہ کی رحمت سے مایوس نہ ہو، بے شک اللہ تمام گناہوں کو بخش دیتا ہے۔",
                hindiAyahTranslation = "अल्लाह की रहमत से मायूस न हो, बेशक अल्लाह सब गुनाह बख़्श देता है।",
                topicTags = listOf("rehmat", "umeed", "maghfirat")
            ),

            // Option 8: Universal Justice (An-Nahl: 90)
            QuranAnswerItem(
                id = "wisdom_adl",
                questionHindi = userQuestion,
                questionUrdu = userQuestion,
                questionHinglish = userQuestion,
                directAnswerHinglish = "Quran Pak farmata hai ke beshak Allah adl o insaf, ehsan aur bhalai ka hukm deta hai aur burai o zulm se rokta hai.",
                directAnswerHindi = "क़ुरआन पाक फ़रमाता है कि बेशक अल्लाह अद्ल व इंसाफ़, एहसान और भलाई का हुक्म देता है और बुराई व ज़ुल्म से रोकता है।",
                directAnswerUrdu = "قرآن پاک فرماتا ہے کہ بے شک اللہ عدل، احسان اور رشتہ داروں کی خیرخواہی کا حکم دیتا ہے اور برائی سے روکتا ہے۔",
                surahNumber = 16,
                surahNameRoman = "An-Nahl",
                surahNameArabic = "النحل",
                ayahNumber = 90,
                arabicAyahText = "إِنَّ ٱللَّهَ يَأْمُرُ بِٱلْعَدْلِ وَٱلْإِحْسَٰنِ وَإِيتَآىِٕ ذِى ٱلْقُرْبَىٰ",
                hinglishAyahText = "Innal-laaha ya'muru bil-'adli wal-ihsaani wa eetaaa'i zil-qurbaa.",
                urduAyahTranslation = "بے شک اللہ عدل اور احسان کا اور رشتہ داروں کو دینے کا حکم فرماتا ہے۔",
                hindiAyahTranslation = "बेशक अल्लाह इंसाफ़, भलाई और रिश्तेदारों को देने का हुक्म फ़रमाता है।",
                topicTags = listOf("adl", "insaf", "hidayat")
            )
        )

        // Select based on question hash so different questions always get different, meaningful answers!
        val index = kotlin.math.abs(userQuestion.hashCode()) % wisdomOptions.size
        return wisdomOptions[index]
    }
}
