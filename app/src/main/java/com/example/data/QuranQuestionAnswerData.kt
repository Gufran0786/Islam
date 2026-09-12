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
        )
    )

    /**
     * Search function for the Quran Question Bar:
     * Matches keywords across Hindi, Urdu, Hinglish, Arabic and topic tags.
     */
    fun searchQuranAnswers(query: String): List<QuranAnswerItem> {
        val clean = query.trim().lowercase()
        if (clean.isEmpty()) return questions

        val tokens = clean.split(" ").filter { it.isNotBlank() && it.length > 1 }

        return questions.filter { item ->
            // Check direct match
            val searchable = "${item.questionHinglish} ${item.questionHindi} ${item.questionUrdu} " +
                    "${item.directAnswerHinglish} ${item.directAnswerHindi} ${item.directAnswerUrdu} " +
                    "${item.surahNameRoman} ${item.topicTags.joinToString(" ")}"

            clean in searchable.lowercase() || tokens.any { token ->
                searchable.lowercase().contains(token)
            }
        }
    }
}
