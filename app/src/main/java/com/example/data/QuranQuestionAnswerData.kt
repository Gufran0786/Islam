package com.example.data

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
            hindiAyahTranslation = "बेशक अल्लाह इस बात को नहीं बख्शता कि उसके साथ किसी को शरीक ठहराया जाए, और इसके अलावा जिसे चाहे माफ़ फरमा देता है। और जिसने अल्लाह के साथ किसी को शरीक किया, उसने बहुत बड़ा गुनाह गढ़ा।",
            topicTags = listOf("shirk", "haram", "gunah", "tauheed", "kufr", "شرک", "حرام", "शिर्क", "हराम")
        ),
        QuranAnswerItem(
            id = "namaz",
            questionHindi = "क्या नमाज़ पढ़ना फ़र्ज़ है और इसकी क्या अहमियत है?",
            questionUrdu = "کیا نماز فرض ہے اور اس کی کیا اہمیت ہے؟",
            questionHinglish = "Kya namaz farz hai aur iski kya ahmiyat hai?",
            directAnswerHinglish = "Namaz Islam ke 5 bunyadi sutoonon mein se ek azeem tareen farz hai jo insan ko burai aur behayai se rokti hai.",
            directAnswerHindi = "नमाज़ इस्लाम के 5 बुनियादी अरकान में से एक अज़ीम तरीन फ़र्ज़ है जो इंसान को हर बुराई और बेहयाई से रोकती है।",
            directAnswerUrdu = "نماز اسلام کے پانچ بنیادی ارکان میں سے ایک عظیم ترین فرض ہے جو انسان کو برائی اور بے حیائی سے روکتی ہے۔",
            surahNumber = 29,
            surahNameRoman = "Al-Ankabut",
            surahNameArabic = "العنكبوت",
            ayahNumber = 45,
            arabicAyahText = "ٱتْلُ مَآ أُوحِىَ إِلَيْكَ مِنَ ٱلْكِتَٰبِ وَأَقِمِ ٱلصَّلَوٰةَ ۖ إِنَّ ٱلصَّلَوٰةَ تَنْهَىٰ عَنِ ٱلْفَحْشَآءِ وَٱلْمُنكَرِ ۗ وَلَذِكْرُ ٱللَّهِ أَكْبَرُ ۗ وَٱللَّهُ يَعْلَمُ مَا تَصْنَعُونَ",
            hinglishAyahText = "Utlu maaa oohiya ilaika minal-Kitaabi wa aqimis-Salah; innas-Salaata tanhaa 'anil-fahshaaa'i wal-munkar; wa lazikrul-laahi akbar; wal-laahu ya'lamu maa tasna'oon.",
            urduAyahTranslation = "کتاب میں سے جو وحی آپ پر اتاری گئی اس کی تلاوت کیجیے اور نماز قائم کیجیے، بے شک نماز بے حیائی اور برے کاموں سے روکتی ہے، اور اللہ کا ذکر سب سے بڑا ہے، اور اللہ جانتا ہے جو تم کرتے ہو۔",
            hindiAyahTranslation = "जो किताब आपकी तरफ़ वही की गई है उसकी तिलावत कीजिए और नमाज़ क़ायम कीजिए। बेशक नमाज़ बेहयाई और बुरे कामों से रोकती है, और यक़ीनन अल्लाह का ज़िक्र सबसे बड़ा है, और अल्लाह जानता है जो कुछ तुम करते हो।",
            topicTags = listOf("namaz", "salah", "farz", "ibadat", "burai", "نماز", "فرض", "नमाज़", "फ़र्ज़")
        ),
        QuranAnswerItem(
            id = "parents",
            questionHindi = "माँ-बाप के साथ कैसा सुलूक करना चाहिए?",
            questionUrdu = "ماں باپ کے ساتھ کیسا سلوک کرنا چاہیے؟",
            questionHinglish = "Maa baap ke sath kaisa sulook karna chahiye?",
            directAnswerHinglish = "Quran Pak mein Allah ne apni ibadat ke fauran baad waldain ke sath husn-e-sulook ka hukm diya hai aur unhe 'Uff' tak kehne se mana farmaya hai.",
            directAnswerHindi = "कुरआन पाक में अल्लाह ने अपनी इबादत के फ़ौरन बाद वालिदैन के साथ हुस्ने-सुलूक का हुक्म दिया है और उन्हें 'उफ़' तक कहने से मना फ़रमाया है।",
            directAnswerUrdu = "قرآن پاک میں اللہ تعالیٰ نے اپنی عبادت کے فوراً بعد والدین کے ساتھ حسنِ سلوک کا حکم دیا ہے اور انہیں 'اُف' تک کہنے سے سختی سے منع فرمایا ہے۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 23,
            arabicAyahText = "وَقَضَىٰ رَبُّكَ أَلَّا تَعْبُدُوٓا۟ إِلَّآ إِيَّاهُ وَبِٱلْوَٰلِدَيْنِ إِحْسَٰنًا ۚ إِمَّا يَبْلُغَنَّ عِندَكَ ٱلْكِبَرَ أَحَدُهُمَآ أَوْ كِلَاهُمَا فَلَا تَقُل لَّهُمَآ أُفٍّۢ وَلَا تَنْهَرْهُمَا وَقُل لَّهُمَا قَوْلًۭا كَرِيمًۭا",
            hinglishAyahText = "Wa qadaa Rabbuka allaa ta'budooo illaaa iyyaahu wa bilwaalidaini ihsaanaa; immaa yablughanna 'indakal-kibara ahaduhumaaa aw kilaahumaa falaa taqul lahumaaa uffinw wa laa tanharhumaa wa qul lahumaa qawlan kareemaa.",
            urduAyahTranslation = "اور تمہارے رب نے فیصلہ فرما دیا کہ تم اس کے سوا کسی کی عبادت نہ کرو اور ماں باپ کے ساتھ نیک سلوک کرو۔ اگر ان میں سے کوئی ایک یا دونوں تمہارے سامنے بڑھاپے کو پہنچ جائیں تو انہیں 'اُف' بھی نہ کہو اور نہ انہیں جھڑکو اور ان سے ادب کی بات کہو۔",
            hindiAyahTranslation = "और तुम्हारे रब ने फ़ैसला कर दिया है कि तुम उसके सिवा किसी की इबादत न करो और माँ-बाप के साथ हुस्ने-सुलूक (भलाई) करो। अगर उनमें से कोई एक या दोनों तुम्हारे पास बुढ़ापे को पहुँच जाएँ तो उन्हें 'उफ़' तक न कहो और न उन्हें झिड़को, बल्कि उनसे अदब व एहतराम की बात कहो।",
            topicTags = listOf("parents", "waldain", "maa", "baap", "walid", "mother", "father", "والدین", "माँ बाप")
        ),
        QuranAnswerItem(
            id = "sood_riba",
            questionHindi = "क्या सूद (ब्याज / Interest) लेना या देना हराम है?",
            questionUrdu = "کیا سود لینا یا دینا حرام ہے؟",
            questionHinglish = "Kya sood (interest/riba) lena ya dena haram hai?",
            directAnswerHinglish = "Haan, Quran mein sood ko qata'i taur par haram qarar diya gaya hai aur ise Allah aur Uske Rasool ke khilaf ailan-e-jang bataya gaya hai.",
            directAnswerHindi = "हाँ, क़ुरआन में सूद (ब्याज) को क़तई तौर पर हराम ठहराया गया है और इसे अल्लाह और उसके रसूल के ख़िलाफ़ ऐलान-ए-जंग करार दिया गया है।",
            directAnswerUrdu = "ہاں، قرآن پاک میں سود کو قطعی طور پر حرام قرار دیا گیا ہے اور اسے اللہ اور اس کے رسول کے خلاف اعلانِ جنگ قرار دیا گیا ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 275,
            arabicAyahText = "ٱلَّذِينَ يَأْكُلُونَ ٱلرِّبَوٰا۟ لَا يَقُومُونَ إِلَّا كَمَا يَقُومُ ٱلَّذِى يَتَخَبَّطُهُ ٱلشَّيْطَٰنُ مِنَ ٱلْمَسِّ ۚ ذَٰلِكَ بِأَنَّهُمْ قَالُوٓا۟ إِنَّمَا ٱلْبَيْعُ مِثْلُ ٱلرِّبَوٰا۟ ۗ وَأَحَلَّ ٱللَّهُ ٱلْبَيْعَ وَحَرَّمَ ٱلرِّبَوٰا۟ ۚ",
            hinglishAyahText = "Allazeena ya'kuloonar-Riba laa yaqoomoona illaa kamaa yaqoomul-lazee yatakhabbatuhush-shaitaanu minal-mass; zaalika bi-annahum qaalooo innamal-bai'u mislur-Riba; wa ahallal-laahul-bai'a wa harramar-Riba.",
            urduAyahTranslation = "وہ لوگ جو سود کھاتے ہیں قیامت کے دن اس طرح اٹھیں گے جیسے کسی کو جن نے چھو کر خبطی بنا دیا ہو، یہ اس لیے کہ وہ کہتے تھے کہ تجارت بھی تو سود ہی کی مانند ہے، حالانکہ اللہ نے تجارت کو حلال فرمایا ہے اور سود کو حرام ٹھہرایا ہے۔",
            hindiAyahTranslation = "जो लोग सूद (ब्याज) खाते हैं वे क़यामत में उसी तरह उठेंगे जैसे किसी को शैतान ने छूकर पागल कर दिया हो। यह इसलिए कि वे कहते थे कि तिजारत (व्यापार) भी तो सूद की तरह ही है, हालाँकि अल्लाह ने तिजारत को हलाल किया है और सूद को हराम ठहराया है।",
            topicTags = listOf("sood", "riba", "interest", "haram", "tijarat", "سود", "حرام", "सूद", "ब्याज")
        ),
        QuranAnswerItem(
            id = "zina",
            questionHindi = "क्या ज़िना (व्यभिचार) करना हराम है?",
            questionUrdu = "کیا زنا کرنا حرام ہے؟",
            questionHinglish = "Kya zina karna haram hai?",
            directAnswerHinglish = "Zina sakht haram aur kabeerah gunaah hai. Quran ne sirf zina se nahi balke uske qareeb bhatakne aur tamam raste ikhtiyar karne se bhi mana farmaya hai.",
            directAnswerHindi = "ज़िना बेहद सख़्त हराम और गुनाहे-कबीरा है। क़ुरआन ने सिर्फ़ ज़िना ही नहीं बल्कि उसके करीब फटकने वाले तमाम रास्तों से भी सख़्ती से मना फ़रमाया है।",
            directAnswerUrdu = "زنا سخت حرام اور گناہِ کبیرہ ہے۔ قرآن مجید نے صرف زنا ہی نہیں بلکہ اس کے قریب بھٹکنے والے تمام اسباب سے بھی سختی سے روکا ہے۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 32,
            arabicAyahText = "وَلَا تَقْرَبُوا۟ ٱلزِّنَىٰٓ ۖ إِنَّهُۥ كَانَ فَٰحِشَةًۭ وَسَآءَ سَبِيلًۭا",
            hinglishAyahText = "Wa laa taqrabuz-zinaaa; innahoo kaana faahishatanw wa saaa'a sabeelaa.",
            urduAyahTranslation = "اور زنا کے قریب بھی نہ جاؤ، بے شک وہ بڑی بے حیائی کی بات ہے اور بہت ہی برا راستہ ہے۔",
            hindiAyahTranslation = "और ज़िना के करीब भी न भटको, बेशक वह खुली बेहयाई और बेहद बुरा रास्ता है।",
            topicTags = listOf("zina", "haram", "behayai", "fahashi", "gunah", "زنا", "حرام", "ज़िना")
        ),
        QuranAnswerItem(
            id = "sabr",
            questionHindi = "मुसीबत और परेशानी में सब्र करने का क्या अज्र है?",
            questionUrdu = "مصیبت اور پریشانی میں صبر کرنے کا کیا اجر ہے؟",
            questionHinglish = "Musibat aur pareshani me sabr karne ka kya ajar hai?",
            directAnswerHinglish = "Allah Ta'ala hamesha sabr karne walon ke sath hai aur aakhirat mein sabr karne walon ko bila-hisaab ajar o sawab se nawaza jayega.",
            directAnswerHindi = "अल्लाह तआला हमेशा सब्र करने वालों के साथ है और आख़िरत में सब्र करने वालों को बे-हिसाब अजर व सवाब से नवाज़ा जाएगा।",
            directAnswerUrdu = "اللہ تعالیٰ ہمیشہ صبر کرنے والوں کے ساتھ ہے اور آخرت میں صبر کرنے والوں کو بے حساب اجر و ثواب سے نوازا جائے گا۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 153,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ ٱسْتَعِينُوا۟ بِٱلصَّبْرِ وَٱلصَّلَوٰةِ ۚ إِنَّ ٱللَّهَ مَعَ ٱلصَّٰبِرِينَ",
            hinglishAyahText = "Yaaa ayyuhal-lazeena aamanus-ta'eenoo bis-Sabri was-Salah; innal-laaha ma'as-saabireen.",
            urduAyahTranslation = "اے ایمان والو! صبر اور نماز کے ذریعے مدد چاہو، بے شک اللہ صبر کرنے والوں کے ساتھ ہے۔",
            hindiAyahTranslation = "ऐ ईमान वालो! सब्र और नमाज़ के ज़रिए मदद तलब करो, बेशक अल्लाह सब्र करने वालों के साथ है।",
            topicTags = listOf("sabr", "musibat", "pareshani", "patience", "namaz", "صبر", "سب्र")
        ),
        QuranAnswerItem(
            id = "tauba",
            questionHindi = "क्या तौबा करने से सारे गुनाह माफ़ हो जाते हैं?",
            questionUrdu = "کیا سچی توبہ سے سارے گناہ معاف ہو جاتے ہیں؟",
            questionHinglish = "Kya sachi tauba karne se sare gunaah maaf ho jate hain?",
            directAnswerHinglish = "Beshak! Allah Ta'ala ki rehmat se kabhi na-umeed nahi hona chahiye. Sachi tauba karne par Allah sare gunaah maaf farma deta hai.",
            directAnswerHindi = "बेशक! अल्लाह की रहमत से कभी मायूस नहीं होना चाहिए। सच्ची तौबा करने पर अल्लाह तमाम गुनाहों को माफ़ फ़रमा देता है।",
            directAnswerUrdu = "بے شک! اللہ کی رحمت سے کبھی ناامید نہیں ہونا چاہیے۔ سچی توبہ کرنے پر اللہ تمام گناہوں کو بخش دیتا ہے۔",
            surahNumber = 39,
            surahNameRoman = "Az-Zumar",
            surahNameArabic = "الزمر",
            ayahNumber = 53,
            arabicAyahText = "قُلْ يَٰعِبَادِىَ ٱلَّذِينَ أَسْرَفُوا۟ عَلَىٰٓ أَنفُسِهِمْ لَا تَقْنَطُوا۟ مِن رَّحْمَةِ ٱللَّهِ ۚ إِنَّ ٱللَّهَ يَغْفِرُ ٱلذُّنُوبَ جَمِيعًا ۚ إِنَّهُۥ هُوَ ٱلْغَفُورُ ٱلرَّحِيمُ",
            hinglishAyahText = "Qul yaa 'ibaadiyal-lazeena asrafoo 'alaaa anfusihim laa taqnatoo mir-rahmatil laah; innal-laaha yaghfiruz-zunooba jamee'aa; innahoo Huwal-Ghafoorur-Raheem.",
            urduAyahTranslation = "فرما دیجیے: اے میرے وہ بندو جنہوں نے اپنی جانوں پر زیادتی کی ہے! اللہ کی رحمت سے مایوس نہ ہو، بے شک اللہ سارے گناہوں کو بخش دیتا ہے، بے شک وہی بڑا بخشنے والا نہایت رحم فرمانے والا ہے۔",
            hindiAyahTranslation = "फ़रमा दीजिए: ऐ मेरे बन्दो जिन्होंने अपनी जानों पर ज़्यादती की है! अल्लाह की रहमत से मायूस न हो, बेशक अल्लाह सारे गुनाहों को माफ़ फ़रमा देता है, यक़ीनन वही बड़ा बख्शने वाला, निहायत रहम करने वाला है।",
            topicTags = listOf("tauba", "maafi", "gunah", "maghfirat", "forgiveness", "توبہ", "तौबा", "माफ़ी")
        ),
        QuranAnswerItem(
            id = "rizq",
            questionHindi = "रिज़्क़ और रोज़ी में बरकत कैसे मिलती है?",
            questionUrdu = "رزق اور روزی میں برکت کیسے حاصل ہوتی ہے؟",
            questionHinglish = "Rizq aur rozi me barkat kaise milti hai?",
            directAnswerHinglish = "Taqwa (Allah ka darr) aur Allah par kamil bharosa (Tawakkul) ikhtiyar karne wale ko Allah aisi jagah se rizq ata farmata hai jahan uska gumaan bhi nahi hota.",
            directAnswerHindi = "तुक़्वा (अल्लाह का डर) और अल्लाह पर कामिल भरोसा (तवक्कुल) करने वाले को अल्लाह ऐसी जगह से रिज़्क़ अता फ़रमाता है जहाँ उसका गुमान भी नहीं होता।",
            directAnswerUrdu = "تقویٰ (اللہ کا ڈر) اور اللہ پر کامل توکل کرنے والے کو اللہ تعالیٰ ایسی جگہ سے رزق عطا فرماتا ہے جہاں سے اس کا گمان بھی نہیں ہوتا۔",
            surahNumber = 65,
            surahNameRoman = "At-Talaq",
            surahNameArabic = "الطلاق",
            ayahNumber = 3,
            arabicAyahText = "وَيَرْزُقْهُ مِنْ حَيْثُ لَا يَحْتَسِبُ ۚ وَمَن يَتَوَكَّلْ عَلَى ٱللَّهِ فَهُوَ حَسْبُهُۥٓ ۚ إِنَّ ٱللَّهَ بَٰلِغُ أَمْرِهِۦ ۚ قَدْ جَعَلَ ٱللَّهُ لِكُلِّ شَىْءٍۢ قَدْرًۭا",
            hinglishAyahText = "Wa yarzuqhu min haisu laa yahtasib; wa many-yatawakkal 'alal-laahi fahuwa hasbuh; innal-laaha baalighu amrih; qad ja'alal-laahu likulli shai'in qadraa.",
            urduAyahTranslation = "اور اسے ایسی جگہ سے رزق عطا فرمائے گا جہاں سے اس کا گمان بھی نہ ہو، اور جو اللہ پر بھروسہ رکھے گا تو اللہ اسے کافی ہے، بے شک اللہ اپنا کام پورا کر کے رہتا ہے۔",
            hindiAyahTranslation = "और उसे ऐसी जगह से रिज़्क़ देगा जहाँ उसका वहम-ओ-गुमान भी न हो। और जो अल्लाह पर भरोसा रखेगा तो अल्लाह उसे काफ़ी है, बेशक अल्लाह अपना काम पूरा करके रहता है।",
            topicTags = listOf("rizq", "rozi", "barkat", "wealth", "tawakkul", "رزق", "برکت", "रिज़्क़", "रोज़ी")
        ),
        QuranAnswerItem(
            id = "ghaibat",
            questionHindi = "क्या ग़ीबत (पीठ पीछे बुराई) करना हराम है?",
            questionUrdu = "کیا غیبت کرنا حرام ہے؟",
            questionHinglish = "Kya ghaibat karna haram hai?",
            directAnswerHinglish = "Haan, ghaibat karna shadeed tareen kabeerah gunaah hai. Quran ne iski misal apne murdah bhai ka gosht khane se di hai.",
            directAnswerHindi = "हाँ, ग़ीबत करना शदीद तरीन कबीरा गुनाह है। क़ुरआन ने इसकी मिसाल अपने मुर्दा भाई का गोश्त खाने से दी है।",
            directAnswerUrdu = "ہاں، غیبت کرنا شدید ترین گناہِ کبیرہ ہے۔ قرآن نے اس کی مثال اپنے مردہ بھائی کا گوشت کھانے سے دی ہے۔",
            surahNumber = 49,
            surahNameRoman = "Al-Hujurat",
            surahNameArabic = "الحجرات",
            ayahNumber = 12,
            arabicAyahText = "وَلَا يَغْتَب بَّعْضُكُم بَعْضًا ۚ أَيُحِبُّ أَحَدُكُمْ أَن يَأْكُلَ لَحْمَ أَخِيهِ مَيْتًۭا فَكَرِهْتُمُوهُ ۚ وَٱتَّقُوا۟ ٱللَّهَ ۚ إِنَّ ٱللَّهَ تَوَّابٌۭ رَّحِيمٌۭ",
            hinglishAyahText = "Wa laa yaghtab ba'dukum ba'daa; a-yuhibbu ahadukum any-ya'kula lahma akheehi maitan fakarihtumooh; wattaqul-laah; innal-laaha Tawwaabur-Raheem.",
            urduAyahTranslation = "اور تم میں سے کوئی کسی کی غیبت نہ کرے، کیا تم میں سے کوئی اپنے مردہ بھائی کا گوشت کھانا پسند کرے گا؟ تم تو اس سے گھن کھاتے ہو۔ اور اللہ سے ڈرو، بے شک اللہ بڑا توبہ قبول فرمانے والا نہایت رحم والا ہے۔",
            hindiAyahTranslation = "और तुम में से कोई किसी की ग़ीबत (पीठ पीछे बुराई) न करे। क्या तुम में से कोई अपने मुर्दा भाई का गोश्त खाना पसन्द करेगा? तुम तो इससे नफ़रत करते हो। और अल्लाह से डरो, बेशक अल्लाह बड़ा तौबा क़बूल करने वाला, निहायत रहम वाला है।",
            topicTags = listOf("ghaibat", "backbiting", "jhoot", "chugli", "haram", "غیبت", "ग़ीबत")
        ),
        QuranAnswerItem(
            id = "sharab_juwa",
            questionHindi = "क्या शराब पीना और जुआ खेलना हराम है?",
            questionUrdu = "کیا شراب پینا اور جوا کھیلنا حرام ہے؟",
            questionHinglish = "Kya sharab peena aur juwa khelna haram hai?",
            directAnswerHinglish = "Haan, sharab, nasha, juwa aur qismat aazmane ke paanse sab napak aur shaitani kaam hain jinse bachne ka saaf hukm hai.",
            directAnswerHindi = "हाँ, शराब, हर क़िस्म का नशा, जुआ और पांसे सब नापाक और शैतानी काम हैं जिनसे बचने का साफ़ हुक्म है।",
            directAnswerUrdu = "ہاں، شراب، ہر نشہ، جوا اور پانسے سب ناپاک اور شیطانی کام ہیں جن سے قطعی بچنے کا حکم ہے۔",
            surahNumber = 5,
            surahNameRoman = "Al-Ma'idah",
            surahNameArabic = "المائدة",
            ayahNumber = 90,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوٓا۟ إِنَّمَا ٱلْخَمْرُ وَٱلْمَيْسِرُ وَٱلْأَنصَابُ وَٱلْأَزْلَٰمُ رِجْسٌۭ مِّنْ عَمَلِ ٱلشَّيْطَٰنِ فَٱجْتَنِبُوهُ لَعَلَّكُمْ تُفْلِحُونَ",
            hinglishAyahText = "Yaaa ayyuhal-lazeena aamanooo innamal-khamru wal-maysiru wal-ansaabu wal-azlaamu rijsum min 'amalish-shaitaani fajtaniboohu la'allakum tuflihoon.",
            urduAyahTranslation = "اے ایمان والو! بے شک شراب اور جوا اور بت اور پانسے سب ناپاک شیطانی کام ہیں، پس ان سے دور رہو تاکہ تم فلاح پاؤ۔",
            hindiAyahTranslation = "ऐ ईमान वालो! बेशक शराब, जुआ, बुत और पांसे सब नापाक शैतानी काम हैं, लिहाज़ा इनसे बचो ताकि तुम फ़लाह (कामयाबी) पाओ।",
            topicTags = listOf("sharab", "alcohol", "nasha", "juwa", "gambling", "haram", "شراب", "جوا", "शराब", "जुआ")
        ),
        QuranAnswerItem(
            id = "death",
            questionHindi = "क्या हर इंसान और जानदार को मौत आनी है?",
            questionUrdu = "کیا ہر جاندار کو موت آنی ہے؟",
            questionHinglish = "Kya har insan aur jandar ko maut aani hai?",
            directAnswerHinglish = "Beshak, kainaat ke har jandar ko maut ka maza chakhna hai aur aakhirat mein qayamat ke din aamaal ka pura badla milega.",
            directAnswerHindi = "बेशक, कायनात के हर जानदार को मौत का मज़ा चखना है और आख़िरत में क़यामत के दिन आमाल का पूरा बदला मिलेगा।",
            directAnswerUrdu = "بے شک، کائنات کے ہر جاندار کو موت کا ذائقہ چکھنا ہے اور آخرت میں قیامت کے دن اعمال کا پورا بدلہ دیا جائے گا۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 185,
            arabicAyahText = "كُلُّ نَفْسٍۢ ذَآئِقَةُ ٱلْمَوْتِ ۗ وَإِنَّمَا تُوَفَّوْنَ أُجُورَكُمْ يَوْمَ ٱلْقِيَٰمَةِ ۖ فَمَن زُحْزِحَ عَنِ ٱلنَّارِ وَأُدْخِلَ ٱلْجَنَّةَ فَقَدْ فَازَ ۗ",
            hinglishAyahText = "Kullu nafsin zaaa'iqatul mawt; wa innamaa tuwaffawna ujoorakum Yawmal-Qiyaamah; faman zuhziha 'anin-Naari wa udkhilal-Jannata faqad faaz.",
            urduAyahTranslation = "ہر جان کو موت کا مزہ چکھنا ہے، اور تمہیں قیامت کے دن تمہارے پورے بدلے دیے جائیں گے۔ پس جو آگ سے بچا لیا گیا اور جنت میں داخل کر دیا گیا تو وہ کامیاب ہو گیا۔",
            hindiAyahTranslation = "हर जान को मौत का मज़ा चखना है, और तुम सबको क़यामत के दिन तुम्हारे पूरे बदले दिए जाएँगे। फिर जिसे आग से बचा लिया गया और जन्नत में दाख़िल कर दिया गया, वह कामयाब हो गया।",
            topicTags = listOf("maut", "death", "qayamat", "jannat", "jahannam", "موت", "قیامت", "मौत")
        ),
        QuranAnswerItem(
            id = "insaaf",
            questionHindi = "क़ुरआन में इंसाफ़ और सच्चाई की क्या तालीम है?",
            questionUrdu = "قرآن میں انصاف اور سچائی کی کیا تعلیم ہے؟",
            questionHinglish = "Quran me insaaf aur sachai ki kya taleem hai?",
            directAnswerHinglish = "Islam mein bila-tafreeq sab ke sath insaaf ka hukm hai, chahe faisla apne ya apne waldain ke khilaf hi kyu na ho.",
            directAnswerHindi = "इस्लाम में बिना किसी तफ़रीक़ सबके साथ इंसाफ़ का हुक्म है, चाहे फ़ैसला अपने या अपने वालिदैन के ख़िलाफ़ ही क्यों न जाता हो।",
            directAnswerUrdu = "اسلام میں بلا تفریق سب کے ساتھ عدل و انصاف کا حکم ہے، چاہے فیصلہ اپنی ذات یا والدین کے خلاف ہی کیوں نہ ہو۔",
            surahNumber = 4,
            surahNameRoman = "An-Nisa",
            surahNameArabic = "النساء",
            ayahNumber = 135,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ كُونُوا۟ قَوَّٰمِينَ بِٱلْقِسْطِ شُهَدَآءَ لِلَّهِ وَلَوْ عَلَىٰٓ أَنفُسِكُمْ أَوِ ٱلْوَٰلِدَيْنِ وَٱلْأَقْرَبِينَ ۚ",
            hinglishAyahText = "Yaaa ayyuhal-lazeena aamanoo koonoo qawwaameena bil-qisti shuhadaaa'a lillaahi wa law 'alaaa anfusikum awil-waalidaini wal-aqrabeen.",
            urduAyahTranslation = "اے ایمان والو! انصاف پر مضبوطی سے قائم رہنے والے اور اللہ کے لیے سچی گواہی دینے والے بنو، خواہ وہ تمہاری اپنی ذات یا والدین اور قریبی رشتہ داروں کے خلاف ہی کیوں نہ ہو۔",
            hindiAyahTranslation = "ऐ ईमान वालो! इंसाफ़ पर पूरी मज़बूती से क़ायम रहने वाले और अल्लाह की ख़ातिर सच्ची गवाही देने वाले बनो, चाहे वह गवाही तुम्हारी अपनी ज़ात या वालिदैन और क़रीबी रिश्तेदारों के ख़िलाफ़ ही क्यों न हो।",
            topicTags = listOf("insaaf", "adl", "justice", "sachai", "truth", "انصاف", "عدل", "इंसाफ़", "सच्चाई")
        ),
        QuranAnswerItem(
            id = "roza_fasting",
            questionHindi = "क्या रमज़ान में रोज़ा रखना फ़र्ज़ है?",
            questionUrdu = "کیا رمضان میں روزہ رکھنا فرض ہے؟",
            questionHinglish = "Kya Ramzan me roza rakhna farz hai?",
            directAnswerHinglish = "Haan, baligh aur aaqil musalman par Ramzan ke roze farz hain taake taqwa (parhezgari) hasil ho sake.",
            directAnswerHindi = "हाँ, बालिग़ और आक़िल मुसलमान पर रमज़ान के रोज़े फ़र्ज़ हैं ताकि तक़्वा (परहेज़गारी) हासिल हो सके।",
            directAnswerUrdu = "ہاں، ہر عاقل و بالغ مسلمان پر رمضان المبارک کے روزے فرض ہیں تاکہ تقویٰ اور پرہیزگاری حاصل ہو۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 183,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ كُتِبَ عَلَيْكُمُ ٱلصِّيَامُ كَمَا كُتِبَ عَلَى ٱلَّذِينَ مِن قَبْلِكُمْ لَعَلَّكُمْ تَتَّقُونَ",
            hinglishAyahText = "Yaaa ayyuhal-lazeena aamanoo kutiba 'alaikumus-Siyaamu kamaa kutiba 'alal-lazeena min qablikum la'allakum tattaqoon.",
            urduAyahTranslation = "اے ایمان والو! تم پر روزے فرض کیے گئے ہیں جیسے تم سے اگلوں پر فرض کیے گئے تھے تاکہ تم پرہیزگار بن جاؤ۔",
            hindiAyahTranslation = "ऐ ईमान वालो! तुम पर रोज़े फ़र्ज़ किए गए जैसे तुमसे पहले के लोगों पर फ़र्ज़ किए गए थे ताकि तुम मुत्तक़ी (परहेज़गार) बनो।",
            topicTags = listOf("roza", "roze", "fasting", "ramzan", "ramadan", "sehri", "iftar", "siyaam", "taqwa", "روزہ", "رمضان", "रोज़ा", "रमज़ान", "उपवास")
        ),
        QuranAnswerItem(
            id = "zakat_charity",
            questionHindi = "क्या ज़कात अदा करना फ़र्ज़ है?",
            questionUrdu = "کیا زکوٰۃ ادا کرنا فرض ہے اور اس کا کیا حکم ہے؟",
            questionHinglish = "Kya zakat ada karna farz hai aur iska kya hukm hai?",
            directAnswerHinglish = "Sahib-e-nisab par har saal apne maal ki zakat nikalna farz-e-ain hai, isse maal paak hota hai aur ghareebon ki madad hoti hai.",
            directAnswerHindi = "साहिबे-निसाब पर हर साल अपने माल की ज़कात निकालना फ़र्ज़-ए-ऐन है, इससे माल पाक होता है और ग़रीबों की मदद होती है।",
            directAnswerUrdu = "صاحبِ نصاب پر ہر سال اپنے مال کی زکوٰۃ ادا کرنا فرضِ عین ہے، جس سے مال پاک ہوتا ہے اور غرباء کی مدد ہوتی ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 43,
            arabicAyahText = "وَأَقِيمُوا۟ ٱلصَّلَوٰةَ وَءَاتُوا۟ ٱلزَّكَوٰةَ وَٱرْكَعُوا۟ مَعَ ٱلرَّٰكِعِينَ",
            hinglishAyahText = "Wa aqeemus-Salaata wa aatuz-Zakaata warka'oo ma'ar-raaki'een.",
            urduAyahTranslation = "اور نماز قائم کرو اور زکوٰۃ دو اور رکوع کرنے والوں کے ساتھ رکوع کرو۔",
            hindiAyahTranslation = "और नमाज़ क़ायम करो और ज़कात दो और रुकूअ करने वालों के साथ रुकूअ करो।",
            topicTags = listOf("zakat", "sadqah", "charity", "khairat", "maal", "garib", "daulat", "paisa", "زکوٰۃ", "صدقہ", "ज़कात", "दान", "खैरात")
        ),
        QuranAnswerItem(
            id = "hajj_pilgrimage",
            questionHindi = "हज किस पर फ़र्ज़ है और कब अदा करना चाहिए?",
            questionUrdu = "حج کس پر فرض ہے؟",
            questionHinglish = "Hajj kis par farz hai aur kab ada karna chahiye?",
            directAnswerHinglish = "Har us musalman par jo Baitullah tak pahunchne ki maali aur jismani taqat rakhta ho, zindagi mein ek martaba Hajj farz hai.",
            directAnswerHindi = "हर उस मुसलमान पर जो बैतुल्लाह तक पहुँचने की माली और जिस्मानी ताक़त रखता हो, ज़िन्दगी में एक मर्तबा हज फ़र्ज़ है।",
            directAnswerUrdu = "ہر اس صاحبِ استطاعت مسلمان پر جو بیت اللہ تک جانے کی مالی و جسمانی طاقت رکھتا ہو زندگی میں ایک بار حج فرض ہے۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 97,
            arabicAyahText = "وَلِلَّهِ عَلَى ٱلنَّاسِ حِجُّ ٱلْبَيْتِ مَنِ ٱسْتَطَاعَ إِلَيْهِ سَبِيلًۭا ۚ وَمَن كَفَرَ فَإِنَّ ٱللَّهَ غَنِىٌّ عَنِ ٱلْعَٰلَمِينَ",
            hinglishAyahText = "Wa lillaahi 'alan-naasi Hijjul-Baiti manis-tataa'a ilaihi sabeelaa; wa man kafara fa-innal-laaha ghaniyyun 'anil-'aalameen.",
            urduAyahTranslation = "اور اللہ کے لیے لوگوں پر اس گھر کا حج فرض ہے جو اس تک پہنچنے کی طاقت رکھے، اور جو انکار کرے تو اللہ سارے جہانوں سے بے نیاز ہے۔",
            hindiAyahTranslation = "और अल्लाह के लिए लोगों पर उस घर का हज फ़र्ज़ है जो उस तक पहुँचने की ताक़त रखे, और जो इंकार करे तो अल्लाह सारे जहानों से बेनियाज़ है।",
            topicTags = listOf("hajj", "umrah", "makkah", "kaba", "baitullah", "ziyarat", "safari", "حج", "عمرہ", "हज", "उमरा")
        ),
        QuranAnswerItem(
            id = "jannat_paradise",
            questionHindi = "जन्नत की नेमतें कैसी हैं और किसे मिलेंगी?",
            questionUrdu = "جنت کی نعمتیں کیسی ہیں اور کس کو ملیں گی؟",
            questionHinglish = "Jannat ki neamatein kaisi hain aur kise milengi?",
            directAnswerHinglish = "Jannat un imaan walon ko milegi jo nek aamaal karte hain. Wahan hamesha behne wali nehrein aur aisi neamatein hain jo kabi khatam nahi hongi.",
            directAnswerHindi = "जन्नत उन ईमान वालों को मिलेगी जो नेक आमाल करते हैं। वहाँ हमेशा बहने वाली नहरें और ऐसी नेमतें हैं जो कभी ख़त्म नहीं होंगी।",
            directAnswerUrdu = "جنت ان اہل ایمان کے لیے ہے جو نیک اعمال کرتے ہیں، وہاں ایسی نہریں اور باغات ہیں جہاں وہ ہمیشہ عیش و نعمت میں رہیں گے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 25,
            arabicAyahText = "وَبَشِّرِ ٱلَّذِينَ ءَامَنُوا۟ وَعَمِلُوا۟ ٱلصَّٰلِحَٰتِ أَنَّ لَهُمْ جَنَّٰتٍۢ تَجْرِى مِن تَحْتِهَا ٱلْأَنْهَٰرُ ۖ",
            hinglishAyahText = "Wa bashshiril-lazeena aamanoo wa 'amilus-saalihaati anna lahum jannaatin tajree min tahtihal-anhaar.",
            urduAyahTranslation = "اور خوشخبری دے دیجیے ان لوگوں کو جو ایمان لائے اور نیک عمل کیے کہ ان کے لیے ایسے باغات ہیں جن کے نیچے نہریں بہتی ہیں۔",
            hindiAyahTranslation = "और खुशख़बरी दे दीजिए उन लोगों को जो ईमान लाए और उन्होंने नेक काम किए कि उनके लिए ऐसे बाग़ हैं जिनके नीचे नहरें बह रही हैं।",
            topicTags = listOf("jannat", "paradise", "neamat", "heaven", "bagh", "hoor", "جنت", "نعمت", "जन्नत", "स्वर्ग", "बहिश्त")
        ),
        QuranAnswerItem(
            id = "jahannam_hell",
            questionHindi = "जहन्नम का अज़ाब कैसा है और इससे कैसे बचें?",
            questionUrdu = "جہنم کا عذاب کیسا ہے اور اس سے کیسے بچیں؟",
            questionHinglish = "Jahannam ka azab kaisa hai aur isse kaise bachein?",
            directAnswerHinglish = "Jahannam ki aag nihayat holnak aur shadeed hai jiska indhan insan aur pathar hain. Isse bachne ke liye tauba aur taqwa ikhtiyar karein.",
            directAnswerHindi = "जहन्नम की आग निहायत खौफ़नाक और शदीद है जिसका ईंधन इंसान और पत्थर हैं। इससे बचने के लिए सच्ची तौबा और तक़्वा इख़्तियार करें।",
            directAnswerUrdu = "جہنم کی آگ انتہائی ہولناک ہے جس کا ایندھن انسان اور پتھر ہیں، اس سے بچنے کے لیے سچا ایمان اور گناہوں سے بچنا ضروری ہے۔",
            surahNumber = 66,
            surahNameRoman = "At-Tahrim",
            surahNameArabic = "التحريم",
            ayahNumber = 6,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ قُوٓا۟ أَنفُسَكُمْ وَأَهْلِيكُمْ نَارًۭا وَقُودُهَا ٱلنَّاسُ وَٱلْحِجَارَةُ",
            hinglishAyahText = "Yaaa ayyuhal-lazeena aamanoo qooo anfusakum wa ahleekum Naaranw waqooduhan-naasu wal-hijaarah.",
            urduAyahTranslation = "اے ایمان والو! اپنے آپ کو اور اپنے گھر والوں کو اس آگ سے بچاؤ جس کا ایندھن انسان اور پتھر ہیں۔",
            hindiAyahTranslation = "ऐ ईमान वालो! अपने आप को और अपने घर वालों को उस आग से बचाओ जिसका ईंधन इंसान और पत्थर हैं।",
            topicTags = listOf("jahannam", "dozakh", "hell", "azab", "fire", "aag", "جہنم", "دوزخ", "عذاب", "जहन्नम", "दोज़ख़", "अज़ाब")
        ),
        QuranAnswerItem(
            id = "dua_supplication",
            questionHindi = "क्या अल्लाह हमारी दुआएं सुनता और क़ुबूल करता है?",
            questionUrdu = "کیا اللہ ہماری دعائیں سنتا اور قبول کرتا ہے؟",
            questionHinglish = "Kya Allah hamari duayein sunta aur qubool karta hai?",
            directAnswerHinglish = "Beshak! Allah apne bando ke nihayat qareeb hai aur har pukarne wale ki dua ko sunta aur qubool farmata hai.",
            directAnswerHindi = "बेशक! अल्लाह अपने बन्दों के निहायत करीब है और हर पुकारने वाले की दुआ को सुनता और क़ुबूल फ़रमाता है।",
            directAnswerUrdu = "بے شک! اللہ اپنے بندوں کے بے حد قریب ہے اور ہر پکارنے والے کی دعا سنتا اور قبول فرماتا ہے۔",
            surahNumber = 2,
            surahNameRoman = "Al-Baqarah",
            surahNameArabic = "البقرة",
            ayahNumber = 186,
            arabicAyahText = "وَإِذَا سَأَلَكَ عِبَادِى عَنِّى فَإِنِّى قَرِيبٌ ۖ أُجِيبُ دَعْوَةَ ٱلدَّاعِ إِذَا دَعَانِ ۖ فَلْيَسْتَجِيبُوا۟ لِى وَلْيُؤْمِنُوا۟ بِى",
            hinglishAyahText = "Wa izaa sa'alaka 'ibaadee 'annee fa-innee qareeb; ujeebu da'watad-daa'i izaa da'aani falyastajeeboo lee walyu'minoo bee.",
            urduAyahTranslation = "اور جب میرے بندے آپ سے میرے بارے میں پوچھیں تو میں یقیناً قریب ہوں، میں پکارنے والے کی دعا قبول کرتا ہوں جب وہ مجھے پکارتا ہے۔",
            hindiAyahTranslation = "और जब मेरे बन्दे आपसे मेरे मुताल्लिक़ पूछें तो बेशक मैं बहुत करीब हूँ, मैं पुकारने वाले की दुआ क़ुबूल करता हूँ जब भी वह मुझे पुकारता है।",
            topicTags = listOf("dua", "prayers", "supplication", "mangna", "qubool", "madad", "haajat", "دعا", "قبولیت", "دعا مانگنا", "दुआ", "प्रार्थना", "कुबूल")
        ),
        QuranAnswerItem(
            id = "dhikr_remembrance",
            questionHindi = "दिल का सुकून किस चीज़ में मिलता है?",
            questionUrdu = "دل کا سکون کس چیز میں ملتا ہے؟",
            questionHinglish = "Dil ka sukoon kis cheez me milta hai?",
            directAnswerHinglish = "Dilo ko sacha itminaan, roohani shanti aur chain sirf aur sirf Allah ke zikr aur yaad se naseeb hota hai.",
            directAnswerHindi = "दिलों को सच्चा इत्मीनान, रूहानी शान्ति और चैन सिर्फ़ और सिर्फ़ अल्लाह के ज़िक्र और याद से नसीब होता है।",
            directAnswerUrdu = "سن لو! دلوں کا سچا اطمینان اور سکون صرف اور صرف اللہ تعالیٰ کے ذکر میں ہے۔",
            surahNumber = 13,
            surahNameRoman = "Ar-Ra'd",
            surahNameArabic = "الرعد",
            ayahNumber = 28,
            arabicAyahText = "ٱلَّذِينَ ءَامَنُوا۟ وَتَطْمَئِنُّ قُلُوبُهُم بِذِكْرِ ٱللَّهِ ۗ أَلَا بِذِكْرِ ٱللَّهِ تَطْمَئِنُّ ٱلْقُلُوبُ",
            hinglishAyahText = "Allazeena aamanoo wa tatma'innu quloobuhum bizikril laah; alaa bizikril laahi tatma'innul quloob.",
            urduAyahTranslation = "جو لوگ ایمان لائے اور جن کے دل اللہ کے ذکر سے اطمینان پاتے ہیں، سن لو! اللہ ہی کے ذکر سے دلوں کو اطمینان نصیب ہوتا ہے۔",
            hindiAyahTranslation = "जो लोग ईमान लाए और जिनके दिलों को अल्लाह के ज़िक्र से सुकून मिलता है, सुन लो! यक़ीनन अल्लाह के ज़िक्र से ही दिलों को सुकून मिलता है।",
            topicTags = listOf("dhikr", "zikr", "sukoon", "itminaan", "peace", "yaad", "shanti", "chain", "dil", "ذكر", "اطمینان", "सुकून", "ज़िक्र", "शान्ति", "तनाव")
        ),
        QuranAnswerItem(
            id = "hijab_haya",
            questionHindi = "इस्लाम में हिजाब और शर्म-ओ-हया का क्या हुक्म है?",
            questionUrdu = "اسلام میں پردہ اور شرم و حیا کا کیا حکم ہے؟",
            questionHinglish = "Islam me hijab aur sharm o haya ka kya hukm hai?",
            directAnswerHinglish = "Quran ne mard aur aurat dono ko nigahein neechi rakhne aur auraton ko parda o haya ikhtiyar karne ka saf hukm diya hai.",
            directAnswerHindi = "क़ुरआन ने मर्द और औरत दोनों को निगाहें नीची रखने और औरतों को परदा व हया इख़्तियार करने का साफ़ हुक्म दिया है।",
            directAnswerUrdu = "قرآن مجید نے مومن مردوں اور عورتوں دونوں کو نظریں نیچی رکھنے اور پردہ و حیا برقرار رکھنے کا قطعی حکم فرمایا ہے۔",
            surahNumber = 24,
            surahNameRoman = "An-Nur",
            surahNameArabic = "النور",
            ayahNumber = 30,
            arabicAyahText = "قُل لِّلْمُؤْمِنِينَ يَغُضُّوا۟ مِنْ أَبْصَٰرِهِمْ وَيَحْفَظُوا۟ فُرُوجَهُمْ ۚ ذَٰلِكَ أَزْكَىٰ لَهُمْ ۗ إِنَّ ٱللَّهَ خَبِيرٌۢ بِمَا يَصْنَعُونَ",
            hinglishAyahText = "Qul lil-mu'mineena yaghuddoo min absaarihim wa yahfazoo furoojahum; zaalika azkaa lahum; innal-laaha khabeerum bimaa yasna'oon.",
            urduAyahTranslation = "مسلمان مردوں سے کہیے کہ اپنی نگاہیں نیچی رکھیں اور اپنی شرمگاہوں کی حفاظت کریں، یہ ان کے لیے زیادہ پاکیزہ ہے، بے شک اللہ باخبر ہے جو وہ کرتے ہیں۔",
            hindiAyahTranslation = "मुसलमान मर्दों से कह दीजिए कि वे अपनी निगाहें नीची रखें और अपनी शर्मगाहों की हिफ़ाज़त करें, यह उनके लिए ज़्यादा पाकीज़ा है। बेशक अल्लाह ख़ूब बाख़बर है जो वे करते हैं।",
            topicTags = listOf("hijab", "parda", "haya", "modesty", "sharm", "nigahein", "aurat", "پردہ", "حیا", "حجاب", "पर्दा", "हिजाब", "हया")
        ),
        QuranAnswerItem(
            id = "nikah_marriage",
            questionHindi = "निकाह और शादी का इस्लाम में क्या मक़सद है?",
            questionUrdu = "نکاح اور ازدواجی رشتے کا کیا مقصد ہے؟",
            questionHinglish = "Nikah aur shadi ka Islam me kya maqsad hai?",
            directAnswerHinglish = "Nikah Allah ki azeem nishaniyon me se hai jisse dilon ko sukoon, mohabbat aur rehmat naseeb hoti hai aur paak damani banti hai.",
            directAnswerHindi = "निकाह अल्लाह की अज़ीम निशानियों में से है जिससे दिलों को सुकून, मुहब्बत और रहमत हासिल होती है और पाकदामनी बनती है।",
            directAnswerUrdu = "نکاح اللہ کی نشانیوں میں سے ہے، جس کے ذریعے میاں بیوی کے درمیان سکون، الفت اور رحمت پیدا فرمائی گئی ہے۔",
            surahNumber = 30,
            surahNameRoman = "Ar-Rum",
            surahNameArabic = "الروم",
            ayahNumber = 21,
            arabicAyahText = "وَمِنْ ءَايَٰتِهِۦٓ أَنْ خَلَقَ لَكُم مِّنْ أَنفُسِكُمْ أَزْوَٰجًۭا لِّتَسْكُنُوٓا۟ إِلَيْهَا وَجَعَلَ بَيْنَكُم مَّوَدَّةًۭ وَرَحْمَةً ۚ",
            hinglishAyahText = "Wa min Aayaatiheee an khalaqa lakum min anfusikum azwaajal litaskunooo ilaihaa wa ja'ala bainakum mawaddatanw wa rahmah.",
            urduAyahTranslation = "اور اس کی نشانیوں میں سے یہ ہے کہ اس نے تمہارے لیے تمہاری ہی جنس سے بیویاں بنائیں تاکہ تم ان کے پاس سکون پاؤ اور تمہارے درمیان محبت اور رحمت رکھ دی۔",
            hindiAyahTranslation = "और उसकी निशानियों में से है कि उसने तुम्हारे लिए तुम्हारी ही जिन्स से जोड़े बनाए ताकि तुम उनसे सुकून पाओ, और तुम्हारे बीच मुहब्बत और रहमत पैदा कर दी।",
            topicTags = listOf("nikah", "shadi", "marriage", "rishta", "biwi", "shohar", "dulha", "dulhan", "vivah", "نکاح", "شادی", "بیوی", "شوہر", "निकाह", "शादी", "विवाह")
        ),
        QuranAnswerItem(
            id = "hasad_jealousy",
            questionHindi = "हसद (जलन) से बचने के लिए क्या तालीम है?",
            questionUrdu = "حسد اور جلن سے کیسے بچا جائے؟",
            questionHinglish = "Hasad (jalan) se bachne ke liye kya taleem hai?",
            directAnswerHinglish = "Hasad nekiyon ko kha jata hai. Quran ne hasad karne walon ke shar se Allah ki panah maangne ka hukm diya hai (Surah Al-Falaq).",
            directAnswerHindi = "हसद नेकियों को खा जाता है। क़ुरआन ने हसद करने वालों के शर से अल्लाह की पनाह मांगने की तालीम दी है।",
            directAnswerUrdu = "حسد سے بچنا لازم ہے، قرآن نے حاسد کے شر سے اللہ تعالیٰ کی پناہ مانگنے کی تلقین فرمائی ہے۔",
            surahNumber = 113,
            surahNameRoman = "Al-Falaq",
            surahNameArabic = "الفلق",
            ayahNumber = 5,
            arabicAyahText = "وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ",
            hinglishAyahText = "Wa min sharri haasidin izaa hasad.",
            urduAyahTranslation = "اور حسد کرنے والے کے شر سے پناہ مانگتا ہوں جب وہ حسد کرے۔",
            hindiAyahTranslation = "और हसद करने वाले के शर से जब वह हसद करे।",
            topicTags = listOf("hasad", "jalan", "jealousy", "evil", "nazar", "panah", "حسد", "حاسد", "हसद", "जलन", "नज़र")
        ),
        QuranAnswerItem(
            id = "gussa_anger",
            questionHindi = "गुस्से पर काबू पाने और माफ़ करने की क्या फ़ज़ीलत है?",
            questionUrdu = "غصہ قابو کرنے اور معاف کرنے کی کیا فضیلت ہے؟",
            questionHinglish = "Gussa qabu karne aur maaf karne ki kya fazilat hai?",
            directAnswerHinglish = "Gussa peene wale aur logon ko maaf karne wale Allah ke mehboob aur muttaqi bande hain jinse Allah mohabbat farmata hai.",
            directAnswerHindi = "गुस्सा पीने वाले और लोगों को माफ़ करने वाले अल्लाह के महबूब और मुत्तक़ी बन्दे हैं जिनसे अल्लाह मुहब्बत फ़रमाता है।",
            directAnswerUrdu = "غصہ پی جانے والے اور لوگوں کو معاف کرنے والے متقی ہیں اور اللہ احسان کرنے والوں کو پسند فرماتا ہے۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 134,
            arabicAyahText = "ٱلَّذِينَ يُنفِقُونَ فِى السَّرَّآءِ وَٱلضَّرَّآءِ وَٱلْكَٰظِمِينَ ٱلْغَيْظَ وَٱلْعَافِينَ عَنِ ٱلنَّاسِ ۗ وَٱللَّهُ يُحِبُّ ٱلْمُحْسِنِينَ",
            hinglishAyahText = "Allazeena yunfiqoona fis-sarraaa'i wad-darraaa'i wal-kaazimeenal-ghaiza wal-'aafeena 'anin-naas; wal-laahu yuhibbul-muhsineen.",
            urduAyahTranslation = "جو خوشحالی اور تنگدستی میں خرچ کرتے ہیں اور غصہ پی جانے والے اور لوگوں کو معاف کرنے والے ہیں، اور اللہ نیکی کرنے والوں سے محبت کرتا ہے۔",
            hindiAyahTranslation = "जो ख़ुशहाली और तंगदस्ती में ख़र्च करते हैं और ग़ुस्सा पी जाने वाले और लोगों को माफ़ करने वाले हैं, और अल्लाह नेकी करने वालों से प्यार करता है।",
            topicTags = listOf("gussa", "anger", "maafi", "patience", "forgive", "jhagda", "krodh", "غصہ", "معافی", "گناہ", "ग़ुस्सा", "माफ़ी", "क्रोध")
        ),
        QuranAnswerItem(
            id = "ilm_knowledge",
            questionHindi = "इल्म हासिल करने की क्या अहमियत है?",
            questionUrdu = "علم حاصل کرنے کی کیا اہمیت ہے؟",
            questionHinglish = "Ilm hasil karne ki kya ahmiyat hai?",
            directAnswerHinglish = "Quran ki sabse pehli aayat 'Iqra' (Padhiye!) se nazil hui. Ilm hasil karna har musalman par lazim hai aur Allah se ilm mein izafe ki dua karni chahiye.",
            directAnswerHindi = "क़ुरआन की सबसे पहली आयत 'इक्रा' (पढ़िए!) से नाज़िल हुई। इल्म हासिल करना हर मुसलमान पर लाज़िम है और अल्लाह से इल्म में इज़ाफ़े की दुआ करनी चाहिए।",
            directAnswerUrdu = "قرآن کا پہلا کلمہ ہی 'اقرأ' (پڑھیے!) تھا۔ علم حاصل کرنا ہر مومن کی اولین ترجیح ہونی چاہیے اور رب سے علم کی زیادتی مانگنی چاہیے۔",
            surahNumber = 20,
            surahNameRoman = "Ta-Ha",
            surahNameArabic = "طه",
            ayahNumber = 114,
            arabicAyahText = "فَتَعَٰلَى ٱللَّهُ ٱلْمَلِكُ ٱلْحَقُّ ۗ وَلَا تَعْجَلْ بِٱلْقُرْءَانِ مِن قَبْلِ أَن يُقْضَىٰٓ إِلَيْكَ وَحْيُهُۥ ۖ وَقُل رَّبِّ زِدْنِى عِلْمًۭا",
            hinglishAyahText = "Fa-ta'aalal-laahul-Malikul-Haqq; wa laa ta'jal bil-Quraani min qabli any-yuqdaaa ilaika wahyuh; wa qur Rabbi zidnee 'ilmaa.",
            urduAyahTranslation = "اور آپ کہہ دیجیے: اے میرے رب! میرے علم میں اضافہ فرما۔",
            hindiAyahTranslation = "और आप कहिए: ऐ मेरे रब! मेरे इल्म में इज़ाफ़ा फ़रमा।",
            topicTags = listOf("ilm", "knowledge", "talim", "education", "padhna", "iqra", "seekhna", "علم", "تعلیم", "اقرأ", "इल्म", "शिक्षा", "पढ़ाई")
        ),
        QuranAnswerItem(
            id = "shukr_gratitude",
            questionHindi = "अल्लाह का शुक्र अदा करने से क्या मिलता है?",
            questionUrdu = "اللہ کا شکر ادا کرنے سے کیا ملتا ہے؟",
            questionHinglish = "Allah ka shukr ada karne se kya milta hai?",
            directAnswerHinglish = "Allah ka wada hai ke agar tum Shukr ada karoge toh Allah tumhein apni neamaton mein aur zyada barkat ata farmayega.",
            directAnswerHindi = "अल्लाह का वादा है कि अगर तुम शुक्र अदा करोगे तो अल्लाह तुम्हें अपनी नेमतों में और ज़्यादा इज़ाफ़ा फ़रमाएगा।",
            directAnswerUrdu = "اللہ کا حتمی وعدہ ہے کہ اگر تم شکر ادا کرو گے تو میں تمہیں ضرور اور زیادہ نعمتوں سے نوازوں گا۔",
            surahNumber = 14,
            surahNameRoman = "Ibrahim",
            surahNameArabic = "إبراهيم",
            ayahNumber = 7,
            arabicAyahText = "وَإِذْ تَأَذَّنَ رَبُّكُمْ لَئِن شَكَرْتُمْ لَأَزِيدَنَّكُمْ ۖ وَلَئِن كَفَرْتُمْ إِنَّ عَذَابِى لَشَدِيدٌۭ",
            hinglishAyahText = "Wa iz ta'azzana Rabbukum la'in shakartum la-azeedannakum wa la'in kafartum inna 'azaabee lashadeed.",
            urduAyahTranslation = "اور جب تمہارے رب نے آگاہ فرمایا کہ اگر تم شکر کرو گے تو میں تمہیں اور زیادہ دوں گا اور اگر تم ناشکری کرو گے تو میرا عذاب یقیناً سخت ہے۔",
            hindiAyahTranslation = "और जब तुम्हारे रब ने ख़बरदार किया कि अगर तुम शुक्र अदा करोगे तो मैं तुम्हें और ज़्यादा दूँगा और अगर तुम नाशुक्री करोगे तो यक़ीनन मेरा अज़ाब बहुत सख़्त है।",
            topicTags = listOf("shukr", "gratitude", "thankfulness", "neamat", "barkat", "ehsan", "شکر", "نعمت", "شکرگزاری", "शुक्र", "नेमत", "कृतज्ञता")
        ),
        QuranAnswerItem(
            id = "sachai_jhooth",
            questionHindi = "क्या झूठ बोलना गुनाह है और सच बोलने का क्या हुक्म है?",
            questionUrdu = "جھوٹ بولنا کیسا ہے اور سچائی کا کیا حکم ہے؟",
            questionHinglish = "Kya jhooth bolna gunah hai aur sach bolne ka kya hukm hai?",
            directAnswerHinglish = "Jhooth se sakhti se bacho kyunki jhooth burai ki taraf le jata hai, aur sachai ikhtiyar karo aur sachon ka sath do.",
            directAnswerHindi = "झूठ से सख़्ती से बचो क्योंकि झूठ बुराई और निफ़ाक़ की तरफ़ ले जाता है, और हमेशा सच्चाई इख़्तियार करो और सच्चों का साथ दो।",
            directAnswerUrdu = "جھوٹ بولنے سے سختی سے بچو اور سچے لوگوں کی سنگت اختیار کرو تاکہ فلاح پاؤ۔",
            surahNumber = 9,
            surahNameRoman = "At-Tawbah",
            surahNameArabic = "التوبة",
            ayahNumber = 119,
            arabicAyahText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوا۟ ٱتَّقُوا۟ ٱللَّهَ وَكُونُوا۟ مَعَ ٱلصَّٰدِقِينَ",
            hinglishAyahText = "Yaaa ayyuhal-lazeena aamanut-taqul-laaha wa koonoo ma'as-saadiqeen.",
            urduAyahTranslation = "اے ایمان والو! اللہ سے ڈرو اور سچے لوگوں کے ساتھ رہو۔",
            hindiAyahTranslation = "ऐ ईमान वालो! अल्लाह से डरो और सच्चे लोगों के साथ हो जाओ।",
            topicTags = listOf("jhooth", "sach", "sachai", "truth", "lying", "honest", "dhokha", "جھوٹ", "سچ", "صدق", "झूठ", "सच", "सच्चाई")
        ),
        QuranAnswerItem(
            id = "tawakkul_trust",
            questionHindi = "अल्लाह पर तवक्कुल (भरोसा) करने की क्या फ़ज़ीलत है?",
            questionUrdu = "اللہ پر توکل کرنے والے کو کیا ملتا ہے؟",
            questionHinglish = "Allah par tawakkul (bharosa) karne ki kya fazilat hai?",
            directAnswerHinglish = "Jo shakhs Allah par kamil bharosa rakhta hai, Allah uske tamam umoor aur zarooriyat ke liye kafi ho jata hai.",
            directAnswerHindi = "जो शख़्स अल्लाह पर कामिल भरोसा रखता है, अल्लाह उसके तमाम उमूर और ज़रूरतों के लिए काफ़ी हो जाता है।",
            directAnswerUrdu = "جو شخص اللہ پر مکمل بھروسہ رکھتا ہے تو اللہ اس کے لیے کافی ہو جاتا ہے۔",
            surahNumber = 3,
            surahNameRoman = "Aal-e-Imran",
            surahNameArabic = "آل عمران",
            ayahNumber = 159,
            arabicAyahText = "فَإِذَا عَزَمْتَ فَتَوَكَّلْ عَلَى ٱللَّهِ ۚ إِنَّ ٱللَّهَ يُحِبُّ ٱلْمُتَوَكِّلِينَ",
            hinglishAyahText = "Fa-izaa 'azamta fatawakkal 'alal-laah; innal-laaha yuhibbul-mutawakkileen.",
            urduAyahTranslation = "پھر جب آپ پختہ ارادہ کر لیں تو اللہ پر بھروسہ رکھیں، بے شک اللہ بھروسہ رکھنے والوں سے محبت کرتا ہے۔",
            hindiAyahTranslation = "फिर जब आप पुख़्ता इरादा कर लें तो अल्लाह पर भरोसा रखिए, बेशक अल्लाह भरोसा करने वालों से मुहब्बत करता है।",
            topicTags = listOf("tawakkul", "trust", "bharosa", "yaqeen", "himmat", "umeed", "توکل", "بھروسہ", "تवक्कुल", "भरोसा", "यकीन")
        ),
        QuranAnswerItem(
            id = "bismillah_quran",
            questionHindi = "क़ुरआन मजीद पढ़ने की क्या फ़ज़ीलत और रूहानी शिफ़ा है?",
            questionUrdu = "قرآن مجید پڑھنے کی کیا برکت اور شفا ہے؟",
            questionHinglish = "Quran Majeed padhne ki kya barkat aur shifa hai?",
            directAnswerHinglish = "Quran Majeed dilon ke liye shifa, hidayat aur momino ke liye azeem rehmat hai.",
            directAnswerHindi = "क़ुरआन मजीद दिलों के लिए शिफ़ा, हिदायत और मोमिनों के लिए अज़ीम रहमत है।",
            directAnswerUrdu = "قرآن مجید دلوں کی بیماریوں کی شفا، سراپا ہدایت اور اہل ایمان کے لیے رحمتِ کاملہ ہے۔",
            surahNumber = 17,
            surahNameRoman = "Al-Isra",
            surahNameArabic = "الإسراء",
            ayahNumber = 82,
            arabicAyahText = "وَنُنَزِّلُ مِنَ ٱلْقُرْءَانِ مَا هُوَ شِفَآءٌۭ وَرَحْمَةٌۭ لِّلْمُؤْمِنِينَ ۙ",
            hinglishAyahText = "Wa nunazzilu minal-Quraani maa huwa shifaaa'unw wa rahmatul lil-mu'mineen.",
            urduAyahTranslation = "اور ہم قرآن میں ایسی چیزیں نازل فرماتے ہیں جو ایمان والوں کے لیے شفا اور رحمت ہیں۔",
            hindiAyahTranslation = "और हम क़ुरआन में ऐसी चीज़ें नाज़िल करते हैं जो ईमान वालों के लिए शिफ़ा और रहमत हैं।",
            topicTags = listOf("quran", "shifa", "tilawat", "hidayat", "rehmat", "padhna", "bismillah", "قرآن", "شفا", "تلاوت", "क़ुरआन", "शिफ़ा", "तिलावत")
        ),
        QuranAnswerItem(
            id = "insaniyat_qatl_zulm",
            questionHindi = "इस्लाम में किसी बेगुनाह का क़त्ल या ज़ुल्म करना कैसा है?",
            questionUrdu = "کسی بے گناہ کا قتل اور ظلم کرنا کیسا ہے؟",
            questionHinglish = "Islam me kisi begunah ka qatl ya zulm karna kaisa hai?",
            directAnswerHinglish = "Kisi ek begunah insan ka qatl poori insaniyat ke qatl ke barabar hai, aur kisi ek ki jaan bachana poori insaniyat ko zindagi dene ke barabar hai.",
            directAnswerHindi = "किसी एक बेगुनाह इंसान का क़त्ल पूरी इंसानियत के क़त्ल के बराबर है, और किसी एक की जान बचाना पूरी इंसानियत को ज़िन्दगी देने के बराबर है।",
            directAnswerUrdu = "کسی ایک بے گناہ کو قتل کرنا گویا پوری انسانیت کا قتل ہے، اور کسی کی جان بچانا گویا پوری انسانیت کو زندگی بخشنا ہے۔",
            surahNumber = 5,
            surahNameRoman = "Al-Ma'idah",
            surahNameArabic = "المائدة",
            ayahNumber = 32,
            arabicAyahText = "مَن قَتَلَ نَفْسًۢا بِغَيْرِ نَفْسٍ أَوْ فَسَادٍۢ فِى ٱلْأَرْضِ فَكَأَنَّمَا قَتَلَ ٱلنَّاسَ جَمِيعًۭا وَمَنْ أَحْيَاهَا فَكَأَنَّمَآ أَحْيَا ٱلنَّاسَ جَمِيعًۭا",
            hinglishAyahText = "Man qatala nafsam bighairi nafsin aw fasaadin fil-ardi faka-annamaa qatalan-naasa jamee'anw wa man ahyaahaa faka-annamaaa ahyan-naasa jamee'aa.",
            urduAyahTranslation = "جس نے کسی انسان کو بغیر جان کے بدلے یا زمین میں فساد کے بغیر قتل کیا تو گویا اس نے سارے انسانوں کو قتل کر دیا، اور جس نے ایک جان کو بچایا تو گویا اس نے سارے انسانوں کو بچا لیا۔",
            hindiAyahTranslation = "जिसने किसी जान को क़त्ल किया बिना किसी जान के बदले या ज़मीन में फ़साद फैलाने के, तो उसने गोया सारे इंसानों को क़त्ल कर दिया, और जिसने किसी की जान बचाई उसने गोया सारे इंसानों को बचा लिया।",
            topicTags = listOf("qatl", "zulm", "insaniyat", "murder", "peace", "aman", "begunah", "قتل", "ظلم", "امن", "क़त्ल", "ज़ुल्म", "अमन")
        )
    )

    private val STOP_WORDS = setOf(
        "kya", "hai", "hain", "karna", "kare", "karein", "ka", "ki", "ke", "ko", "se", "par",
        "me", "mein", "aur", "ye", "wo", "to", "bhi", "batao", "kaisa", "kaisi", "kaise",
        "chahiye", "hota", "hoti", "hote", "is", "are", "what", "the", "in", "to", "for",
        "of", "and", "a", "an", "karo", "karta", "karti", "karte", "hum", "tum", "apna",
        "apne", "apni", "hoga", "hogi", "bataiye", "bata", "den", "de", "do", "kya?", "hai?"
    )

    /**
     * Search function for the Quran Question Bar:
     * Calculates relevance score for each answer based on meaningful keywords.
     * Guarantees that every user query returns a tailored, appropriate Quranic response.
     */
    fun searchQuranAnswers(query: String): List<QuranAnswerItem> {
        val clean = query.trim().lowercase()
        if (clean.isEmpty()) return questions

        // Extract meaningful tokens excluding stopwords
        val rawTokens = clean.replace(Regex("[^\\p{L}\\p{Nd}\\s]"), " ")
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }

        val meaningfulTokens = rawTokens.filter { it !in STOP_WORDS && it.length > 1 }
        val searchTokens = if (meaningfulTokens.isNotEmpty()) meaningfulTokens else rawTokens

        // Score each question
        val scoredItems = questions.map { item ->
            var score = 0
            val tags = item.topicTags.map { it.lowercase() }
            val qHinglish = item.questionHinglish.lowercase()
            val qHindi = item.questionHindi.lowercase()
            val qUrdu = item.questionUrdu.lowercase()
            val answerHinglish = item.directAnswerHinglish.lowercase()

            for (token in searchTokens) {
                // Exact tag match: highest priority
                if (tags.any { it == token }) {
                    score += 50
                } else if (tags.any { it.contains(token) }) {
                    score += 25
                }

                // Question match
                if (qHinglish.contains(token)) score += 35
                if (qHindi.contains(token)) score += 35
                if (qUrdu.contains(token)) score += 35

                // Answer match
                if (answerHinglish.contains(token)) score += 15
            }

            item to score
        }

        val matches = scoredItems.filter { it.second > 0 }
            .sortedByDescending { it.second }
            .map { it.first }

        if (matches.isNotEmpty()) {
            return matches
        }

        // Semantic fallback keyword mapping for common life topics
        val fallback = findSemanticFallback(clean, searchTokens)
        if (fallback != null) {
            return listOf(fallback)
        }

        // Universal Islamic Quranic response for any open question
        return listOf(generateUniversalQuranicAnswer(query.trim()))
    }

    private fun findSemanticFallback(clean: String, tokens: List<String>): QuranAnswerItem? {
        val allText = (tokens + clean).joinToString(" ")

        return when {
            allText.containsAny("namaz", "salah", "prayer", "rakat", "sajda", "wuzu") ->
                questions.firstOrNull { it.id == "namaz" }
            allText.containsAny("roza", "roze", "fast", "sehri", "iftar", "ramzan", "ramadan") ->
                questions.firstOrNull { it.id == "roza_fasting" }
            allText.containsAny("zakat", "sadqa", "khairat", "paisa", "maal", "daulat", "garib") ->
                questions.firstOrNull { it.id == "zakat_charity" }
            allText.containsAny("hajj", "umrah", "kaaba", "makkah") ->
                questions.firstOrNull { it.id == "hajj_pilgrimage" }
            allText.containsAny("maa", "baap", "walid", "walidain", "parents", "ammi", "abbu") ->
                questions.firstOrNull { it.id == "parents" }
            allText.containsAny("sood", "riba", "interest", "byaj", "karz", "bank") ->
                questions.firstOrNull { it.id == "sood_riba" }
            allText.containsAny("zina", "fahashi", "behayai", "sharam") ->
                questions.firstOrNull { it.id == "zina" }
            allText.containsAny("sabr", "pareshani", "musibat", "takleef", "dard", "gam", "bimaari") ->
                questions.firstOrNull { it.id == "sabr" }
            allText.containsAny("tauba", "maaf", "maghfirat", "gunah", "astaghfar") ->
                questions.firstOrNull { it.id == "tauba" }
            allText.containsAny("rizq", "rozi", "barkat", "naukri", "kamana", "business", "tarakki") ->
                questions.firstOrNull { it.id == "rizq" }
            allText.containsAny("ghaibat", "chugli", "burai", "peeth") ->
                questions.firstOrNull { it.id == "ghaibat" }
            allText.containsAny("sharab", "juwa", "nasha", "alcohol", "gambling") ->
                questions.firstOrNull { it.id == "sharab_juwa" }
            allText.containsAny("maut", "death", "qabar", "janaza", "inteqal", "marne") ->
                questions.firstOrNull { it.id == "death" }
            allText.containsAny("jannat", "paradise", "swarg", "hoor", "mehal") ->
                questions.firstOrNull { it.id == "jannat_paradise" }
            allText.containsAny("jahannam", "dozakh", "hell", "narak", "azab") ->
                questions.firstOrNull { it.id == "jahannam_hell" }
            allText.containsAny("dua", "mangna", "arzi", "haajat", "qubool") ->
                questions.firstOrNull { it.id == "dua_supplication" }
            allText.containsAny("sukoon", "shanti", "chain", "zikr", "dhikr", "itminaan") ->
                questions.firstOrNull { it.id == "dhikr_remembrance" }
            allText.containsAny("parda", "hijab", "haya", "aurat", "libas") ->
                questions.firstOrNull { it.id == "hijab_haya" }
            allText.containsAny("nikah", "shadi", "vivah", "rishta", "biwi", "shohar") ->
                questions.firstOrNull { it.id == "nikah_marriage" }
            allText.containsAny("hasad", "jalan", "nazar", "dushmani") ->
                questions.firstOrNull { it.id == "hasad_jealousy" }
            allText.containsAny("gussa", "krodh", "ladai", "jhagda") ->
                questions.firstOrNull { it.id == "gussa_anger" }
            allText.containsAny("ilm", "padhai", "kitab", "taleem", "seekhna", "iqra") ->
                questions.firstOrNull { it.id == "ilm_knowledge" }
            allText.containsAny("shukr", "ehsan", "shukriya", "thank") ->
                questions.firstOrNull { it.id == "shukr_gratitude" }
            allText.containsAny("jhooth", "sach", "sachai", "jhoot") ->
                questions.firstOrNull { it.id == "sachai_jhooth" }
            allText.containsAny("tawakkul", "bharosa", "yaqeen", "himmat") ->
                questions.firstOrNull { it.id == "tawakkul_trust" }
            allText.containsAny("quran", "tilawat", "shifa", "bismillah", "aayat") ->
                questions.firstOrNull { it.id == "bismillah_quran" }
            allText.containsAny("shirk", "but", "pooja", "kufr") ->
                questions.firstOrNull { it.id == "shirk" }
            else -> null
        }
    }

    private fun String.containsAny(vararg words: String): Boolean {
        return words.any { this.contains(it) }
    }

    /**
     * Generates a tailored Quranic response citing universal guidance for open-ended queries.
     */
    private fun generateUniversalQuranicAnswer(userQuestion: String): QuranAnswerItem {
        return QuranAnswerItem(
            id = "universal_guidance_${userQuestion.hashCode()}",
            questionHindi = userQuestion,
            questionUrdu = userQuestion,
            questionHinglish = userQuestion,
            directAnswerHinglish = "Quran Pak har masle mein adl, neki, husn-e-akhlaq aur sabr ka dars deta hai. Allah par kamil bharosa rakhein aur Quran ki hidayat par amal karein.",
            directAnswerHindi = "क़ुरआन पाक हर मामले में अद्ल (इंसाफ़), भलाई, हुस्ने-अख़लाक़ और सब्र की तालीम देता है। अल्लाह पर कामिल भरोसा रखें और क़ुरआन की हिदायत पर अमल करें।",
            directAnswerUrdu = "قرآن پاک ہر مسئلے میں عدل، احسان، حسنِ اخلاق اور صبر کی رہنمائی فرماتا ہے۔ اللہ پر توکل رکھیں اور احکاماتِ الٰہی پر عمل کریں۔",
            surahNumber = 16,
            surahNameRoman = "An-Nahl",
            surahNameArabic = "النحل",
            ayahNumber = 90,
            arabicAyahText = "إِنَّ ٱللَّهَ يَأْمُرُ بِٱلْعَدْلِ وَٱلْإِحْسَٰنِ وَإِيتَآىِٕ ذِى ٱلْقُرْبَىٰ وَيَنْهَىٰ عَنِ ٱلْفَحْشَآءِ وَٱلْمُنكَرِ وَٱلْبَغْىِ ۚ يَعِظُكُمْ لَعَلَّكُمْ تَذَكَّرُونَ",
            hinglishAyahText = "Innal-laaha ya'muru bil-'adli wal-ihsaani wa eetaaa'i zil-qurbaa wa yanhaa 'anil-fahshaaa'i wal-munkari wal-baghy; ya'izukum la'allakum tazakkaroon.",
            urduAyahTranslation = "بے شک اللہ عدل اور احسان کا اور رشتہ داروں کو دینے کا حکم فرماتا ہے اور بے حیائی اور برائی اور سرکشی سے منع کرتا ہے، وہ تمہیں نصیحت کرتا ہے تاکہ تم نصیحت حاصل کرو۔",
            hindiAyahTranslation = "बेशक अल्लाह इंसाफ़, भलाई और रिश्तेदारों को देने का हुक्म फ़रमाता है, और बेहयाई, बुराई और ज़ुल्म से रोकता है। वह तुम्हें नसीहत करता है ताकि तुम सबक़ हासिल करो।",
            topicTags = listOf("hidayat", "guidance", "adl", "ihsan", "akhlaq", "quran")
        )
    }
}
