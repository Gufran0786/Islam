package com.example.data.quran

import com.example.data.Ayah

/**
 * Complete, verified core recitations without a single missing verse:
 * - Surah 1: Al-Fatihah (1-7 complete)
 * - Surah 67: Al-Mulk (1-30 complete - Protection from punishment of the grave)
 * - Surah 62: Al-Jumu'ah (1-11 complete - Friday prayers & virtues)
 * - Surah 73: Al-Muzzammil (1-20 complete - Night prayers & Tahajjud)
 */
object QuranEssentialSurahs {
    val ayahs: List<Ayah> = listOf(
        Ayah(
            surahNumber = 1,
            ayahNumber = 1,
            arabicText = "بِسْمِ ٱللَّهِ ٱلرَّحْمَٰنِ ٱلرَّحِيمِ",
            hinglishText = "Bismil-laahir-Rahmaanir-Raheem",
            urduTranslation = "شروع اللہ کا نام لے کر جو بڑا مہربان نہایت رحم والا ہے",
            hindiTranslation = "अल्लाह के नाम से शुरू जो बड़ा मेहरबान और निहायत रहम करने वाला है।"
        ),
        Ayah(
            surahNumber = 1,
            ayahNumber = 2,
            arabicText = "ٱلْحَمْدُ لِلَّهِ رَبِّ ٱلْعَٰلَمِينَ",
            hinglishText = "Alhamdu lillaahi Rabbil-'aalameen",
            urduTranslation = "سب تعریفیں اللہ ہی کے لیے ہیں جو تمام جہانوں کا پالنے والا ہے",
            hindiTranslation = "सब तारीफ़ें अल्लाह ही के लिए हैं जो तमाम जहानों का रब (पालने वाला) है।"
        ),
        Ayah(
            surahNumber = 1,
            ayahNumber = 3,
            arabicText = "ٱلرَّحْمَٰنِ ٱلرَّحِيمِ",
            hinglishText = "Ar-Rahmaanir-Raheem",
            urduTranslation = "بڑا مہربان نہایت رحم فرمانے والا",
            hindiTranslation = "बड़ा मेहरबान, निहायत रहम फरमाने वाला।"
        ),
        Ayah(
            surahNumber = 1,
            ayahNumber = 4,
            arabicText = "مَٰلِكِ يَوْمِ ٱلدِّينِ",
            hinglishText = "Maaliki Yawmid-Deen",
            urduTranslation = "روزِ جزا (بدلے کے دن) کا مالک",
            hindiTranslation = "रोज़-ए-जज़ा (बदले व इंसाफ़ के दिन) का मालिक।"
        ),
        Ayah(
            surahNumber = 1,
            ayahNumber = 5,
            arabicText = "إِيَّاكَ نَعْبُدُ وَإِيَّاكَ نَسْتَعِينُ",
            hinglishText = "Iyyaaka na'budu wa iyyaaka nasta'een",
            urduTranslation = "ہم تیری ہی عبادت کرتے ہیں اور تجھ ہی سے مدد مانگتے ہیں",
            hindiTranslation = "हम तेरी ही इबादत करते हैं और तुझी से मदद मांगते हैं।"
        ),
        Ayah(
            surahNumber = 1,
            ayahNumber = 6,
            arabicText = "ٱهْدِنَا ٱلصِّرَٰطَ ٱلْمُسْتَقِيمَ",
            hinglishText = "Ihdinas-Siraatal-Mustaqeem",
            urduTranslation = "ہمیں سیدھا راستہ دکھا",
            hindiTranslation = "हमें सीधा रास्ता दिखा।"
        ),
        Ayah(
            surahNumber = 1,
            ayahNumber = 7,
            arabicText = "صِرَٰطَ ٱلَّذِينَ أَنْعَمْتَ عَلَيْهِمْ غَيْرِ ٱلْمَغْضُوبِ عَلَيْهِمْ وَلَا ٱلضَّآلِّينَ",
            hinglishText = "Siraatal-ladheena an'amta 'alayhim ghayril-maghdoobi 'alayhim wa lad-daalleen",
            urduTranslation = "ان لوگوں کا راستہ جن پر تو نے انعام فرمایا، نہ کہ ان کا جن پر غضب ہوا اور نہ گمراہوں کا",
            hindiTranslation = "उन लोगों का रास्ता जिन पर तूने इनाम फ़रमाया, उनका नहीं जिन पर ग़ज़ब हुआ और न भटके हुओं का।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 1,
            arabicText = "تَبَٰرَكَ ٱلَّذِى بِيَدِهِ ٱلْمُلْكُ وَهُوَ عَلَىٰ كُلِّ شَىْءٍ قَدِيرٌ",
            hinglishText = "Tabaarakal-ladhee biyadihil-mulku wa Huwa 'alaa kulli shay'in Qadeer",
            urduTranslation = "بڑی برکت والی ہے وہ ذات جس کے ہاتھ میں ساری کائنات کی بادشاہی ہے، اور وہ ہر چیز پر پوری قدرت رکھنے والا ہے",
            hindiTranslation = "बड़ी बरकत वाली है वह ज़ात जिसके हाथ में सारी बादशाही है, और वह हर चीज़ पर पूरी क़ुदरत रखने वाला है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 2,
            arabicText = "ٱلَّذِى خَلَقَ ٱلْمَوْتَ وَٱلْحَيَوٰةَ لِيَبْلُوَكُمْ أَيُّكُمْ أَحْسَنُ عَمَلًا ۚ وَهُوَ ٱلْعَزِيزُ ٱلْغَفُورُ",
            hinglishText = "Alladhee khalaqal-mawta wal-hayaata liyabluwakum ayyukum ahsanu 'amalaa; wa Huwal-'Azeezul-Ghafoor",
            urduTranslation = "جس نے موت اور زندگی کو پیدا کیا تاکہ تمہیں آزمائے کہ تم میں سے کون عمل کے اعتبار سے زیادہ اچھا ہے؛ اور وہ زبردست، بڑا بخشنے والا ہے",
            hindiTranslation = "जिसने मौत और ज़िंदगी को पैदा किया ताकि तुम्हें आज़माए कि तुममें से अमल के एतबार से कौन बेहतर है; और वह बड़ा ज़बरदस्त, बहुत बख़्शने वाला है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 3,
            arabicText = "ٱلَّذِى خَلَقَ سَبْعَ سَمَٰوَٰتٍ طِبَاقًا ۖ مَّا تَرَىٰ فِى خَلْقِ ٱلرَّحْمَٰنِ مِن تَفَٰوُتٍ ۖ فَٱرْجِعِ ٱلْبَصَرَ هَلْ تَرَىٰ مِن فُطُورٍ",
            hinglishText = "Alladhee khalaqa sab'a samaawaatin tibaaqam-maa taraa fee khalqir-Rahmaani min tafaawut; farji'il-basara hal taraa min futoor",
            urduTranslation = "جس نے اوپر تلے سات آسمان بنائے، تم رحمٰن کی اس تخلیق میں کوئی نقص اور ناہمواری نہیں پاؤ گے، پھر نگاہ دہرا کر دیکھو، کیا تمہیں کوئی شگاف نظر آتا ہے؟",
            hindiTranslation = "जिसने तह-बर-तह सात आसमान बनाए, तुम रहमान की पैदाईश में कोई ख़ामी न पाओगे, फिर नज़र दौड़ाकर देखो, क्या तुम्हें कोई दरार नज़र आती है?"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 4,
            arabicText = "ثُمَّ ٱرْجِعِ ٱلْبَصَرَ كَرَّتَيْنِ يَنقَلِبْ إِلَيْكَ ٱلْبَصَرُ خَاسِئًا وَهُوَ حَسِيرٌ",
            hinglishText = "Thummar-ji'il-basara karratayni yanqalib ilaykal-basaru khaasi'anw-wa huwa haseer",
            urduTranslation = "پھر بار بار نگاہ ڈالو، تمہاری نگاہ تھک ہار کر اور نامراد ہو کر تمہاری طرف لوٹ آئے گی",
            hindiTranslation = "फिर बार-बार नज़र दौड़ाओ, तुम्हारी नज़र थक-हार कर और नाकाम होकर तुम्हारी तरफ़ लौट आएगी।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 5,
            arabicText = "وَلَقَدْ زَيَّنَّا ٱلسَّمَآءَ ٱلدُّنْيَا بِمَصَٰبِيحَ وَجَعَلْنَٰهَا رُجُومًا لِّلشَّيَٰطِينِ ۖ وَأَعْتَدْنَا لَهُمْ عَذَابَ ٱلسَّعِيرِ",
            hinglishText = "Wa laqad zayyannas-samaaa'ad-dunyaa bimasaabeeha wa ja'alnaahaa rujoomal-lish-shayaateeni wa a'tadnaa lahum 'adhaabas-sa'eer",
            urduTranslation = "اور یقیناً ہم نے دنیا کے آسمان کو چراغوں (ستاروں) سے آراستہ کیا اور انہیں شیطانوں کو مار بھگانے کا ذریعہ بنایا اور ان کے لیے دہکتی آگ کا عذاب تیار کر رکھا ہے",
            hindiTranslation = "और यक़ीनन हमने दुनिया के आसमान को चिराग़ों (तारों) से सजाया और उन्हें शैतानों को मार भगाने का ज़रिया बनाया और उनके लिए दहकती आग का अज़ाब तैयार कर रखा है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 6,
            arabicText = "وَلِلَّذِينَ كَفَرُوا۟ بِرَبِّهِمْ عَذَابُ جَهَنَّمَ ۖ وَبِئْسَ ٱلْمَصِيرُ",
            hinglishText = "Wa lilladheena kafaroo bi-Rabbihim 'adhaabu jahannama wa bi'sal-maseer",
            urduTranslation = "اور جن لوگوں نے اپنے رب کا انکار کیا ان کے لیے جہنم کا عذاب ہے، اور وہ بہت برا ٹھکانہ ہے",
            hindiTranslation = "और जिन्होंने अपने रब का इनकार किया उनके लिए जहन्नम का अज़ाब है, और वह बहुत बुरा ठिकाना है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 7,
            arabicText = "إِذَآ أُلْقُوا۟ فِيهَا سَمِعُوا۟ لَهَا شَهِيقًا وَهِىَ تَفُورُ",
            hinglishText = "Idhaaa ulqoo feehaa sami'oo lahaa shaheeqanw-wa hiya tafoor",
            urduTranslation = "جب وہ اس میں ڈالے جائیں گے تو اس کی خوفناک دھاڑ سنیں گے جبکہ وہ جوش مار رہی ہوگی",
            hindiTranslation = "जब वे उसमें डाले जाएंगे तो उसकी भयानक चीख़ सुनेंगे जबकि वह खौल रही होगी।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 8,
            arabicText = "تَكَادُ تَمَيَّزُ مِنَ ٱلْغَيْظِ ۖ كُلَّمَآ أُلْقِىَ فِيهَا فَوْجٌ سَأَلَهُمْ خَزَنَتُهَآ أَلَمْ يَأْتِكُمْ نَذِيرٌ",
            hinglishText = "Takaadu tamayyazu minal-ghayzi kullamaaa ulqiya feehaa fawjun sa'alahum khazanatuhaaa alam ya'tikum nadheer",
            urduTranslation = "قریب ہوگا کہ وہ غصے سے پھٹ پڑے، جب بھی کوئی گروہ اس میں ڈالا جائے گا تو اس کے داروغے پوچھیں گے: کیا تمہارے پاس کوئی ڈرانے والا نہیں آیا تھا؟",
            hindiTranslation = "क़रीब होगा कि वह ग़ुस्से से फट पड़े, जब भी कोई गिरोह उसमें डाला जाएगा तो उसके दारोग़ा पूछेंगे: क्या तुम्हारे पास कोई डराने वाला नहीं आया था?"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 9,
            arabicText = "قَالُوا۟ بَلَىٰ قَدْ جَآءَنَا نَذِيرٌ فَكَذَّبْنَا وَقُلْنَا مَا نَزَّلَ ٱللَّهُ مِن شَىْءٍ إِنْ أَنتُمْ إِلَّا فِى ضَلَٰلٍ كَبِيرٍ",
            hinglishText = "Qaaloo balaa qad jaaa'anaa nadheerun fakadh-dhabnaa wa qulnaa maa nazzalal-laahu min shay'in in antum illaa fee dalaalin kabeer",
            urduTranslation = "وہ کہیں گے: ہاں، یقیناً ہمارے پاس ڈرانے والا آیا تھا مگر ہم نے جھٹلایا اور کہا کہ اللہ نے کچھ نازل نہیں کیا، تم خود بڑی گمراہی میں پڑے ہو",
            hindiTranslation = "वे कहेंगे: हाँ, हमारे पास डराने वाला आया था मगर हमने झुठलाया और कहा कि अल्लाह ने कुछ नाज़िल नहीं किया, तुम ख़ुद बड़ी गुमराही में हो।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 10,
            arabicText = "وَقَالُوا۟ لَوْ كُنَّا نَسْمَعُ أَوْ نَعْقِلُ مَا كُنَّا فِىٓ أَصْحَٰبِ ٱلسَّعِيرِ",
            hinglishText = "Wa qaaloo law kunnaa nasma'u aw na'qilu maa kunnaa feee as-haabis-sa'eer",
            urduTranslation = "اور وہ کہیں گے کہ اگر ہم سنتے یا عقل سے کام لیتے تو آج اس دہکتی آگ والوں میں نہ ہوتے",
            hindiTranslation = "और वे कहेंगे अगर हम सुनते या अक़्ल से काम लेते तो आज इस भड़कती आग वालों में न होते।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 11,
            arabicText = "فَٱعْتَرَفُوا۟ بِذَنۢبِهِمْ فَسُحْقًا لِّأَصْحَٰبِ ٱلسَّعِيرِ",
            hinglishText = "Fa'tarafoo bi-dhambihim fasuhqal-li-as-haabis-sa'eer",
            urduTranslation = "پس وہ اپنے گناہ کا اعتراف کریں گے، تو دوری اور پھٹکار ہو ان دوزخیوں کے لیے!",
            hindiTranslation = "अतः वे अपने गुनाहों का इक़रार कर लेंगे, तो लानत व दूरी हो इन दोज़खियों के लिए!"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 12,
            arabicText = "إِنَّ ٱلَّذِينَ يَخْشَوْنَ رَبَّهُم بِٱلْغَيْبِ لَهُم مَّغْفِرَةٌ وَأَجْرٌ كَبِيرٌ",
            hinglishText = "Innal-ladheena yakhshawna Rabbahum bil-ghaybi lahum maghfiratunw-wa ajrun kabeer",
            urduTranslation = "بے شک جو لوگ بن دیکھے اپنے پروردگار سے ڈرتے ہیں ان کے لیے بخشش اور بہت بڑا اجر ہے",
            hindiTranslation = "बेशक जो लोग बेदेखे अपने रब से डरते हैं उनके लिए बख़्शिश और बहुत बड़ा बदला है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 13,
            arabicText = "وَأَسِرُّوا۟ قَوْلَكُمْ أَوِ ٱجْهَرُوا۟ بِهِۦٓ ۖ إِنَّهُۥ عَلِيمٌۢ بِذَاتِ ٱلصُّدُورِ",
            hinglishText = "Wa asirroo qawlakum awijharoo bih; innahoo 'aleemum-bidhaatis-sudoor",
            urduTranslation = "اور تم اپنی بات چپکے سے کہو یا پکار کر، وہ سینوں کے چھپے بھیدوں تک کو خوب جاننے والا ہے",
            hindiTranslation = "और तुम अपनी बात चुपके से कहो या खुलकर, वह सीनों के छुपे भेदों को ख़ूब जानने वाला है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 14,
            arabicText = "أَلَا يَعْلَمُ مَنْ خَلَقَ وَهُوَ ٱللَّطِيفُ ٱلْخَبِيرُ",
            hinglishText = "Alaa ya'lamu man khalaqa wa Huwal-Lateeful-Khabeer",
            urduTranslation = "کیا وہی نہ جانے گا جس نے پیدا کیا ہے؟ حالانکہ وہ باریک بین اور ہر بات سے باخبر ہے",
            hindiTranslation = "क्या वही न जानेगा जिसने पैदा किया है? हालांकि वह बड़ा बारीकबीन, हर बात से बाख़बर है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 15,
            arabicText = "هُوَ ٱلَّذِى جَعَلَ لَكُمُ ٱلْأَرْضَ ذَلُولًا فَٱمْشُوا۟ فِى مَنَاكِبِهَا وَكُلُوا۟ مِن رِّزْقِهِۦ ۖ وَإِلَيْهِ ٱلنُّشُورُ",
            hinglishText = "Huwal-ladhee ja'ala lakumul-arda dhaloolan famshoo fee manaakibihaa wa kuloo mir-rizqih; wa ilayhin-nushoor",
            urduTranslation = "وہی ہے جس نے تمہارے لیے زمین کو تابع اور مسخر کر دیا، پس اس کے راستوں میں چلو پھرو اور اللہ کے دیے ہوئے رزق میں سے کھاؤ، اور اسی کی طرف دوبارہ جی اٹھنا ہے",
            hindiTranslation = "वही है जिसने तुम्हारे लिए ज़मीन को ताबेअ किया, अतः उसके रास्तों में चलो-फिरो और उसके रिज़्क़ में से खाओ, और उसी की तरफ़ दोबारा जी उठना है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 16,
            arabicText = "ءَأَمِنتُم مَّن فِى ٱلسَّمَآءِ أَن يَخْسِفَ بِكُمُ ٱلْأَرْضَ فَإِذَا هِىَ تَمُورُ",
            hinglishText = "A'amintum man fis-samaaa'i ay-yakhsifa bikumul-arda fa-idhaa hiya tamoor",
            urduTranslation = "کیا تم اس ذات سے بے خوف ہو گئے ہو جو آسمان میں ہے کہ وہ تمہیں زمین میں دھنسا دے اور اچانک زمین لرزنے لگے؟",
            hindiTranslation = "क्या तुम उस ज़ात से बेख़ौफ़ हो गए हो जो आसमान में है कि वह तुम्हें ज़मीन में धंसा दे और अचानक ज़मीन कांपने लगे?"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 17,
            arabicText = "أَمْ أَمِنتُم مَّن فِى ٱلسَّمَآءِ أَن يُرْسِلَ عَلَيْكُمْ حَاصِبًا ۖ فَسَتَعْلَمُونَ كَيْفَ نَذِيرِ",
            hinglishText = "Am amintum man fis-samaaa'i ay-yursila 'alaykum haasibaa; fasata'lamoona kayfa nadheer",
            urduTranslation = "یا تم اس ذات سے بے خوف ہو جو آسمان میں ہے کہ وہ تم پر پتھراؤ کرنے والی آندھی بھیج دے؟ پھر تمہیں معلوم ہو جائے گا کہ میری تنبیہ کیسی تھی",
            hindiTranslation = "या तुम बेख़ौफ़ हो कि वह तुम पर पत्थरों की आंधी भेज दे? फिर तुम्हें मालूम हो जाएगा कि मेरी चेतावनी कैसी थी।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 18,
            arabicText = "وَلَقَدْ كَذَّبَ ٱلَّذِينَ مِن قَبْلِهِمْ فَكَيْفَ كَانَ نَكِيرِ",
            hinglishText = "Wa laqad kadh-dhabal-ladheena min qablihim fakayfa kaana nakeer",
            urduTranslation = "اور یقیناً ان سے پہلے والے لوگوں نے بھی جھٹلایا تھا، تو دیکھ لو کہ میری پکڑ اور سزا کیسی سخت تھی!",
            hindiTranslation = "और यक़ीनन इनसे पहले के लोगों ने भी झुठलाया था, तो देख लो कि मेरी पकड़ कैसी थी!"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 19,
            arabicText = "أَوَلَمْ يَرَوْا۟ إِلَى ٱلطَّيْرِ فَوْقَهُمْ صَٰٓفَّٰتٍ وَيَقْبِضْنَ ۚ مَا يُمْسِكُهُنَّ إِلَّا ٱلرَّحْمَٰنُ ۚ إِنَّهُۥ بِكُلِّ شَىْءٍۭ بَصِيرٌ",
            hinglishText = "Awalam yaraw ilat-tayri fawqahum saaaaffaatinw-wa yaqbidn; maa yumsikuhunna illar-Rahmaan; innahoo bikulli shay'im-baseer",
            urduTranslation = "کیا انہوں نے اپنے اوپر پرندوں کو پر پھیلائے اور سمیٹتے ہوئے اڑتے نہیں دیکھا؟ رحمن کے سوا انہیں کوئی نہیں تھامے ہوئے؛ بے شک وہ ہر چیز کو خوب دیکھ رہا ہے",
            hindiTranslation = "क्या उन्होंने अपने ऊपर परिंदों को पर फैलाए और सिकोड़ते नहीं देखा? रहमान के सिवा उन्हें कोई नहीं थामे हुए; बेशक वह हर चीज़ को देख रहा है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 20,
            arabicText = "أَمَّنْ هَٰذَا ٱلَّذِى هُوَ جُندٌ لَّكُمْ يَنصُرُكُم مِّن دُونِ ٱلرَّحْمَٰنِ ۚ إِنِ ٱلْكَٰفِرُونَ إِلَّا فِى غُرُورٍ",
            hinglishText = "Amman haadhal-ladhee huwa jundul-lakum yansurukum min doonir-Rahmaan; inil-kaafiroona illaa fee ghuroor",
            urduTranslation = "بھلا رحمن کے مقابلے میں تمہارا وہ کون سا لشکر ہے جو تمہاری مدد کرے گا؟ کافر محض دھوکے اور فریب میں مبتلا ہیں",
            hindiTranslation = "भला रहमान के मुक़ाबले में तुम्हारा वह कौन सा लश्कर है जो तुम्हारी मदद करेगा? काफ़िर सिर्फ़ धोखे में हैं।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 21,
            arabicText = "أَمَّنْ هَٰذَا ٱلَّذِى يَرْزُقُكُمْ إِنْ أَمْسَكَ رِزْقَهُۥ ۚ بَل لَّجُّوا۟ فِى عُتُوٍّ وَنُفُورٍ",
            hinglishText = "Amman haadhal-ladhee yarzuqukum in amsaka rizqah; bal lajjoo fee 'utuwwinw-wa nufoor",
            urduTranslation = "یا وہ کون ہے جو تمہیں روزی دے اگر اللہ اپنی روزی روک لے؟ بلکہ وہ سرکشی اور حق سے بھاگنے پر اڑے ہوئے ہیں",
            hindiTranslation = "या कौन है जो तुम्हें रोज़ी दे अगर वह अपनी रोज़ी रोक ले? बल्कि वे सरकशी और नफ़रत पर अड़े हुए हैं।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 22,
            arabicText = "أَفَمَن يَمْشِى مُكِبًّا عَلَىٰ وَجْهِهِۦٓ أَهْدَىٰٓ أَمَّن يَمْشِى سَوِيًّا عَلَىٰ صِرَٰطٍ مُّسْتَقِيمٍ",
            hinglishText = "Afamay-yamshee mukibban 'alaa wajhiheee ahdaaa ammay-yamshee sawiyyan 'alaa siraatim-mustaqeem",
            urduTranslation = "بھلا جو شخص منہ کے بل اوندھا ہو کر گرے وہ زیادہ سیدھی راہ پر ہے یا وہ جو سیدھا ہو کر صراطِ مستقیم پر چل رہا ہو؟",
            hindiTranslation = "भला जो मुंह के बल औंधा होकर चले वह ज़्यादा सीधे रास्ते पर है या वह जो सीधा होकर सीधे रास्ते पर चल रहा हो?"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 23,
            arabicText = "قُلْ هُوَ ٱلَّذِىٓ أَنشَأَكُمْ وَجَعَلَ لَكُمُ ٱلسَّمْعَ وَٱلْأَبْصَٰرَ وَٱلْأَفْـِٔدَةَ ۖ قَلِيلًا مَّا تَشْكُرُونَ",
            hinglishText = "Qul Huwal-ladheee ansha'akum wa ja'ala lakumus-sam'a wal-absaara wal-af'idah; qaleelam-maa tashkuroon",
            urduTranslation = "آپ فرما دیجیے: وہی ہے جس نے تمہیں پیدا کیا اور تمہارے لیے کان، آنکھیں اور دل بنائے، تم بہت ہی کم شکر ادا کرتے ہو",
            hindiTranslation = "आप कह दीजिए: वही है जिसने तुम्हें पैदा किया और तुम्हारे कान, आंखें और दिल बनाए, तुम बहुत कम शुक्र अदा करते हो।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 24,
            arabicText = "قُلْ هُوَ ٱلَّذِى ذَرَأَكُمْ فِى ٱلْأَرْضِ وَإِلَيْهِ تُحْشَرُونَ",
            hinglishText = "Qul Huwal-ladhee dhara'akum fil-ardi wa ilayhi tuhsharoon",
            urduTranslation = "فرما دیجیے: وہی ہے جس نے تمہیں زمین میں پھیلا دیا اور اسی کے حضور تم سب اکٹھے کیے جاؤ گے",
            hindiTranslation = "कह दीजिए: वही है जिसने तुम्हें ज़मीन में फैलाया और उसी के सामने तुम जमा किए जाओगे।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 25,
            arabicText = "وَيَقُولُونَ مَتَىٰ هَٰذَا ٱلْوَعْدُ إِن كُنتُمْ صَٰدِقِينَ",
            hinglishText = "Wa yaqooloona mataa haadhal-wa'du in kuntum saadiqeen",
            urduTranslation = "اور وہ کہتے ہیں: یہ قیامت کا وعدہ کب پورا ہوگا اگر تم سچے ہو؟",
            hindiTranslation = "और वे कहते हैं: यह (क़ियामत का) वादा कब पूरा होगा अगर तुम सच्चे हो?"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 26,
            arabicText = "قُلْ إِنَّمَا ٱلْعِلْمُ عِندَ ٱللَّهِ وَإِنَّمَآ أَنَا۠ نَذِيرٌ مُّبِينٌ",
            hinglishText = "Qul innamal-'ilmu 'indal-laahi wa innamaaa ana nadheerum-mubeen",
            urduTranslation = "آپ فرما دیجیے: اس کا علم تو صرف اللہ ہی کے پاس ہے، اور میں تو صرف صاف صاف خبردار کرنے والا ہوں",
            hindiTranslation = "कह दीजिए: इसका इल्म तो सिर्फ़ अल्लाह ही के पास है, और मैं तो बस साफ़-साफ़ डराने वाला हूँ।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 27,
            arabicText = "فَلَمَّا رَأَوْهُ زُلْفَةً سِيٓـَٔتْ وُجُوهُ ٱلَّذِينَ كَفَرُوا۟ وَقِيلَ هَٰذَا ٱلَّذِى كُنتُم بِهِۦ تَدَّعُونَ",
            hinglishText = "Falammaa ra'awhu zulfatan seee'at wujoohul-ladheena kafaroo wa qeela haadhal-ladhee kuntum bihee tadda'oon",
            urduTranslation = "پھر جب وہ اسے قریب دیکھیں گے تو کافروں کے چہرے بگڑ جائیں گے اور کہا جائے گا: یہ وہی ہے جس کے آنے کی تم جلدی مچاتے تھے!",
            hindiTranslation = "फिर जब वे उसे क़रीब देखेंगे तो काफ़िरों के चेहरे बिगड़ जाएंगे और कहा जाएगा: यह वही है जिसे तुम मांगते थे!"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 28,
            arabicText = "قُلْ أَرَءَيْتُمْ إِنْ أَهْلَكَنِىَ ٱللَّهُ وَمَن مَّعِىَ أَوْ رَحِمَنَا فَمَن يُجِيرُ ٱلْكَٰفِرِينَ مِنْ عَذَابٍ أَلِيمٍ",
            hinglishText = "Qul ara'aytum in ahlakaniyal-laahu wa mam-ma'iya aw rahimanaa famay-yujeerul-kaafireena min 'adhaabin aleem",
            urduTranslation = "آپ فرما دیجیے: بھلا دیکھو تو سہی کہ اگر اللہ مجھے اور میرے ساتھیوں کو ہلاک کر دے یا ہم پر رحم فرمائے، تو کافروں کو دردناک عذاب سے کون پناہ دے گا؟",
            hindiTranslation = "कह दीजिए: भला देखो तो अगर अल्लाह मुझे और मेरे साथियों को हलाक कर दे या हम पर रहम करे, तो काफ़िरों को दर्दनाक अज़ाब से कौन बचाएगा?"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 29,
            arabicText = "قُلْ هُوَ ٱلرَّحْمَٰنُ ءَامَنَّا بِهِۦ وَعَلَيْهِ تَوَكَّلْنَا ۖ فَسَتَعْلَمُونَ مَنْ هُوَ فِى ضَلَٰلٍ مُّبِينٍ",
            hinglishText = "Qul Huwar-Rahmaanu aamannaa bihee wa 'alayhi tawakkalnaa; fasata'lamoona man huwa fee dalaalim-mubeen",
            urduTranslation = "آپ فرما دیجیے: وہی رحمٰن ہے جس پر ہم ایمان لائے اور اسی پر ہم نے بھروسا کیا، پس عنقریب تمہیں معلوم ہو جائے گا کہ کھلی گمراہی میں کون ہے",
            hindiTranslation = "कह दीजिए: वही रहमान है जिस पर हम ईमान लाए और उसी पर हमने भरोसा किया, तो अनक़रीब तुम जान लोगे कि खुली गुमराही में कौन है।"
        ),
        Ayah(
            surahNumber = 67,
            ayahNumber = 30,
            arabicText = "قُلْ أَرَءَيْتُمْ إِنْ أَصْبَحَ مَآؤُكُمْ غَوْرًا فَمَن يَأْتِيكُم بِمَآءٍ مَّعِينٍۭ",
            hinglishText = "Qul ara'aytum in asbaha maaa'ukum ghawran famay-ya'teekum bi-maaa'im-ma'een",
            urduTranslation = "فرما دیجیے: بھلا بتاؤ کہ اگر تمہارا پانی زمین کی گہرائی میں اتر جائے تو وہ کون ہے جو تمہارے پاس بہتا ہوا میٹھا چشمہ لائے گا؟",
            hindiTranslation = "कह दीजिए: भला बताओ तो अगर तुम्हारा पानी ज़मीन की गहराइयों में उतर जाए तो कौन है जो तुम्हारे पास बहता हुआ मीठा पानी लाएगा?"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 1,
            arabicText = "يُسَبِّحُ لِلَّهِ مَا فِى ٱلسَّمَٰوَٰتِ وَمَا فِى ٱلْأَرْضِ ٱلْمَلِكِ ٱلْقُدُّوسِ ٱلْعَزِيزِ ٱلْحَكِيمِ",
            hinglishText = "Yusabbihu lillaahi maa fis-samaawaati wa maa fil-ardil-Malikil-Quddoosil-'Azeezil-Hakeem",
            urduTranslation = "اللہ کی تسبیح کرتی ہے ہر وہ چیز جو آسمانوں میں ہے اور جو زمین میں ہے، وہ حقیقی بادشاہ، ہر عیب سے پاک، زبردست، کمال حکمت والا ہے",
            hindiTranslation = "अल्लाह की तस्बीह करती है हर वह चीज़ जो आसमानों में है और जो ज़मीन में है, वह सच्चा बादशाह, हर ऐब से पाक, ज़बरदस्त, हिकमत वाला है।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 2,
            arabicText = "هُوَ ٱلَّذِى بَعَثَ فِى ٱلْأُمِّيِّـۧنَ رَسُولًا مِّنْهُمْ يَتْلُوا۟ عَلَيْهِمْ ءَايَٰتِهِۦ وَيُزَكِّيهِمْ وَيُعَلِّمُهُمُ ٱلْكِتَٰبَ وَٱلْحِكْمَةَ وَإِن كَانُوا۟ مِن قَبْلُ لَفِى ضَلَٰلٍ مُّبِينٍ",
            hinglishText = "Huwal-ladhee ba'atha fil-ummiyyeena Rasoolam-minhum yatloo 'alayhim aayaatihee wa yuzakkeehim wa yu'allimuhumul-Kitaaba wal-Hikmata wa in kaanoo min qablu lafee dalaalim-mubeen",
            urduTranslation = "وہی ہے جس نے ان پڑھ لوگوں میں انہی میں سے ایک رسول (حضرت محمد ﷺ) کو بھیجا جو ان پر اللہ کی آیات پڑھتے ہیں، ان کا تزکیہ کرتے ہیں اور انہیں کتاب و حکمت کی تعلیم دیتے ہیں، اگرچہ وہ اس سے پہلے کھلی گمراہی میں پڑے ہوئے تھے",
            hindiTranslation = "वही है जिसने अनपढ़ लोगों में उन्हीं में से एक रसूल (सल्ल.) को भेजा जो उन पर अल्लाह की आयतें पढ़ते हैं, उन्हें पाक करते हैं और उन्हें किताब व हिकमत सिखाते हैं, हालांकि वे इससे पहले खुली गुमराही में थे।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 3,
            arabicText = "وَءَاخَرِينَ مِنْهُمْ لَمَّا يَلْحَقُوا۟ بِهِمْ ۚ وَهُوَ ٱلْعَزِيزُ ٱلْحَكِيمُ",
            hinglishText = "Wa aakhareena minhum lammaa yalhaqoo bihim; wa Huwal-'Azeezul-Hakeem",
            urduTranslation = "اور ان میں سے دوسرے لوگوں کے لیے بھی جو ابھی ان سے نہیں ملے ہیں؛ اور وہ زبردست، بڑی حکمت والا ہے",
            hindiTranslation = "और उन्हीं में से दूसरों के लिए भी जो अभी उनसे नहीं मिले हैं; और वह बड़ा ज़बरदस्त, हिकमत वाला है।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 4,
            arabicText = "ذَٰلِكَ فَضْلُ ٱللَّهِ يُؤْتِيهِ مَن يَشَآءُ ۚ وَٱللَّهُ ذُو ٱلْفَضْلِ ٱلْعَظِيمِ",
            hinglishText = "Dhaalika fadlul-laahi yu'teehi may-yashaaa'; wal-laahu Dhul-fadlil-'azeem",
            urduTranslation = "یہ اللہ کا خاص فضل ہے، وہ جسے چاہتا ہے عطا فرماتا ہے، اور اللہ بڑے فضل والا ہے",
            hindiTranslation = "यह अल्लाह का फ़ज़ल है, वह जिसे चाहता है देता है, और अल्लाह बड़े फ़ज़ल वाला है।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 5,
            arabicText = "مَثَلُ ٱلَّذِينَ حُمِّلُوا۟ ٱلتَّوْرَىٰةَ ثُمَّ لَمْ يَحْمِلُوهَا كَمَثَلِ ٱلْحِمَارِ يَحْمِلُ أَسْفَارًا ۚ بِئْسَ مَثَلُ ٱلْقَوْمِ ٱلَّذِينَ كَذَّبُوا۟ بِـَٔايَٰتِ ٱللَّهِ ۚ وَٱللَّهُ لَا يَهْدِى ٱلْقَوْمَ ٱلظَّٰلِمِينَ",
            hinglishText = "Mathalul-ladheena hummilut-Tawraata thumma lam yahmiloohaa kamathalil-himaari yahmilu asfaaraa; bi'sa mathalul-qawmil-ladheena kadh-dhaboo bi-aayaatil-laah; wal-laahu laa yahdil-qawmaz-zaalimeen",
            urduTranslation = "جن لوگوں پر تورات کا بوجھ ڈالا گیا پھر انہوں نے اس پر عمل نہ کیا، ان کی مثال اس گدھے جیسی ہے جس پر بڑی بڑی کتابیں لدی ہوں؛ کتنی بری مثال ہے ان لوگوں کی جنہوں نے اللہ کی آیات کو جھٹلایا، اور اللہ ظالموں کو ہدایت نہیں دیتا",
            hindiTranslation = "जिन पर तौरात का बोझ डाला गया फिर उन्होंने उस पर अमल न किया, उनकी मिसाल उस गधे जैसी है जिस पर किताबें लदी हों; कितनी बुरी मिसाल है उन लोगों की जिन्होंने अल्लाह की आयतों को झुठलाया, और अल्लाह ज़ालिमों को हिदायत नहीं देता।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 6,
            arabicText = "قُلْ يَٰٓأَيُّهَا ٱلَّذِينَ هَادُوٓا۟ إِن زَعَمْتُمْ أَنَّكُمْ أَوْلِيَآءُ لِلَّهِ مِن دُونِ ٱلنَّاسِ فَتَمَنَّوُا۟ ٱلْمَوْتَ إِن كُنتُمْ صَٰدِقِينَ",
            hinglishText = "Qul yaaa-ayyuhal-ladheena haadoo in za'amtum annakum awliyaaa'u lillaahi min doonin-naasi fatamannawul-mawta in kuntum saadiqeen",
            urduTranslation = "آپ فرما دیجیے: اے یہودیو! اگر تم یہ دعویٰ کرتے ہو کہ تمام انسانوں کو چھوڑ کر صرف تم ہی اللہ کے چہیتے ہو، تو موت کی تمنا کرو اگر تم سچے ہو",
            hindiTranslation = "कह दीजिए: ऐ यहूदियो! अगर तुम्हारा दावा है कि लोगों को छोड़कर सिर्फ़ तुम ही अल्लाह के दोस्त हो, तो मौत की तमन्ना करो अगर तुम सच्चे हो।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 7,
            arabicText = "وَلَا يَتَمَنَّوْنَهُۥٓ أَبَدًۢا بِمَا قَدَّمَتْ أَيْدِيهِمْ ۚ وَٱللَّهُ عَلِيمٌۢ بِٱلظَّٰلِمِينَ",
            hinglishText = "Wa laa yatamannawnahooo abadam-bimaa qaddamat aydeehim; wal-laahu 'aleemum-biz-zaalimeen",
            urduTranslation = "اور وہ اپنے ہاتھوں کے آگے بھیجے ہوئے اعمال کی وجہ سے کبھی بھی موت کی تمنا نہیں کریں گے، اور اللہ ظالموں کو خوب جانتا ہے",
            hindiTranslation = "और वे अपने हाथों के आगे भेजे हुए आमाल की वजह से कभी भी मौत की तमन्ना न करेंगे, और अल्लाह ज़ालिमों को ख़ूब जानता है।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 8,
            arabicText = "قُلْ إِنَّ ٱلْمَوْتَ ٱلَّذِى تَفِرُّونَ مِنْهُ فَإِنَّهُۥ مُلَٰقِيكُمْ ۖ ثُمَّ تُرَدُّونَ إِلَىٰ عَٰلِمِ ٱلْغَيْبِ وَٱلشَّهَٰدَةِ فَيُنَبِّئُكُم بِمَا كُنتُمْ تَعْمَلُونَ",
            hinglishText = "Qul innal-mawtal-ladhee tafirroona minhu fa-innahoo mulaaqeekum thumma turaddoona ilaa 'Aalimil-ghaybi wash-shahaadati fayunabbi'ukum bimaa kuntum ta'maloon",
            urduTranslation = "آپ فرما دیجیے: جس موت سے تم بھاگتے ہو وہ تو تمہیں ضرور مل کر رہے گی، پھر تم پوشیدہ اور ظاہر کے جاننے والے کی بارگاہ میں پیش کیے جاؤ گے، پھر وہ تمہیں بتا دے گا جو کچھ تم کیا کرتے تھے",
            hindiTranslation = "कह दीजिए: जिस मौत से तुम भागते हो वह तो तुम्हें आकर ही रहेगी, फिर तुम छुपे और ज़ाहिर के जानने वाले की तरफ़ लौटाए जाओगे, फिर वह तुम्हें बताएगा जो कुछ तुम करते थे।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 9,
            arabicText = "يَٰٓأَيُّهَا ٱلَّذِينَ ءَامَنُوٓا۟ إِذَا نُودِىَ لِلصَّلَوٰةِ مِن يَوْمِ ٱلْجُمُعَةِ فَٱسْعَوْا۟ إِلَىٰ ذِكْرِ ٱللَّهِ وَذَرُوا۟ ٱلْبَيْعَ ۚ ذَٰلِكُمْ خَيْرٌ لَّكُمْ إِن كُنتُمْ تَعْلَمُونَ",
            hinglishText = "Yaaa-ayyuhal-ladheena aamanooo idhaa noodiya lis-salaati miy-yawmil-Jumu'ati fas'aw ilaa dhikril-laahi wa dharul-bay'; dhaalikum khayrul-lakum in kuntum ta'lamoon",
            urduTranslation = "اے ایمان والو! جب جمعہ کے دن نماز کے لیے اذان دی جائے تو فوراً اللہ کے ذکر کی طرف دوڑ پڑو اور خرید و فروخت چھوڑ دو؛ یہ تمہارے حق میں بہت بہتر ہے اگر تم سمجھ رکھو",
            hindiTranslation = "ऐ ईमान वालो! जब जुमा के दिन नमाज़ के लिए अज़ान दी जाए तो फ़ौरन अल्लाह के ज़िक्र की तरफ़ दौड़ पड़ो और ख़रीद-ओ-फ़रोख़्त छोड़ दो; यह तुम्हारे हक़ में बहुत बेहतर है अगर तुम जानो।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 10,
            arabicText = "فَإِذَا قُضِيَتِ ٱلصَّلَوٰةُ فَٱنتَشِرُوا۟ فِى ٱلْأَرْضِ وَٱبْتَغُوا۟ مِن فَضْلِ ٱللَّهِ وَٱذْكُرُوا۟ ٱللَّهَ كَثِيرًا لَّعَلَّكُمْ تُفْلِحُونَ",
            hinglishText = "Fa-idhaa qudiyati-salaatu fantashiroo fil-ardi wabtaghoo min fadlil-laahi wadhkurul-laaha katheeral-la'allakum tuflihoon",
            urduTranslation = "پھر جب نماز پوری ہو جائے تو زمین میں پھیل جاؤ اور اللہ کا فضل (روزی) تلاش کرو، اور کثرت سے اللہ کا ذکر کرو تاکہ تم کامیابی حاصل کرو",
            hindiTranslation = "फिर जब नमाज़ पूरी हो जाए तो ज़मीन में फैल जाओ और अल्लाह का फ़ज़ल (रोज़ी) तलाश करो, और कसरत से अल्लाह का ज़िक्र करो ताकि तुम कामयाब हो सको।"
        ),
        Ayah(
            surahNumber = 62,
            ayahNumber = 11,
            arabicText = "وَإِذَا رَأَوْا۟ تِجَٰرَةً أَوْ لَهْوًا ٱنفَضُّوٓا۟ إِلَيْهَا وَتَرَكُوكَ قَآئِمًا ۚ قُلْ مَا عِندَ ٱللَّهِ خَيْرٌ مِّنَ ٱللَّهْوِ وَمِنَ ٱلتِّجَٰرَةِ ۚ وَٱللَّهُ خَيْرُ ٱلرَّٰزِقِينَ",
            hinglishText = "Wa idhaa ra'aw tijaaratan aw lahwanin-faddooo ilayhaa wa tarakooka qaaa'imaa; qul maa 'indal-laahi khayrum-minal-lahwi wa minat-tijaarah; wal-laahu khayrur-raaziqeen",
            urduTranslation = "اور جب انہوں نے کوئی تجارت یا کھیل تماشا دیکھا تو اس کی طرف دوڑ پڑے اور آپ کو کھڑا چھوڑ دیا؛ آپ فرما دیجیے: جو کچھ اللہ کے پاس ہے وہ کھیل تماشے اور تجارت سے کہیں بہتر ہے، اور اللہ سب سے بہترین روزی رساں ہے",
            hindiTranslation = "और जब उन्होंने कोई व्यापार या तमाशा देखा तो उसकी तरफ़ टूट पड़े और आपको खड़ा छोड़ दिया; कह दीजिए: जो अल्लाह के पास है वह खेल-तमाशे और व्यापार से कहीं बेहतर है, और अल्लाह सबसे बेहतरीन रोज़ी देने वाला है।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 1,
            arabicText = "يَٰٓأَيُّهَا ٱلْمُزَّمِّلُ",
            hinglishText = "Yaaa-ayyuhal-muzzammil",
            urduTranslation = "اے چادر اوڑھنے والے حبیب (محمد ﷺ)!",
            hindiTranslation = "ऐ चादर ओढ़ने वाले पैग़म्बर!"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 2,
            arabicText = "قُمِ ٱلَّيْلَ إِلَّا قَلِيلًا",
            hinglishText = "Qumil-layla illaa qaleelaa",
            urduTranslation = "رات کو نماز میں قیام کیجیے مگر تھوڑا سا حصہ",
            hindiTranslation = "रात को नमाज़ में खड़े रहिए मगर थोड़ा हिस्सा।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 3,
            arabicText = "نِّصْفَهُۥٓ أَوِ ٱنقُصْ مِنْهُ قَلِيلًا",
            hinglishText = "Nisfahooo awinqus minhu qaleelaa",
            urduTranslation = "آدھی رات یا اس سے کچھ کم کر دیجیے",
            hindiTranslation = "आधी रात या उससे कुछ कम कर दीजिए।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 4,
            arabicText = "أَوْ زِدْ عَلَيْهِ وَرَتِّلِ ٱلْقُرْءَانَ تَرْتِيلًا",
            hinglishText = "Aw zid 'alayhi wa rattilil-Qur'aana tarteelaa",
            urduTranslation = "یا اس پر تھوڑا بڑھا لیجیے، اور قرآن کو خوب ٹھہر ٹھہر کر اور صاف ترتیل کے ساتھ پڑھیے",
            hindiTranslation = "या उस पर कुछ बढ़ा लीजिए, और क़ुरआन को ठहर-ठहर कर साफ़ तरीक़े से पढ़िए।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 5,
            arabicText = "إِنَّا سَنُلْقِى عَلَيْكَ قَوْلًا ثَقِيلًا",
            hinglishText = "Innaa sanulqee 'alayka qawlan thaqeelaa",
            urduTranslation = "یقیناً ہم عنقریب آپ پر ایک بھاری کلام (وحی کی ذمہ داری) نازل فرمائیں گے",
            hindiTranslation = "यक़ीनन हम अनक़रीब आप पर एक भारी कलाम (क़ुरआन) नाज़िल करेंगे।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 6,
            arabicText = "إِنَّ نَاشِئَةَ ٱلَّيْلِ هِىَ أَشَدُّ وَطْـًٔا وَأَقْوَمُ قِيلًا",
            hinglishText = "Inna naashi'atal-layli hiya ashaddu wat'anw-wa aqwamu qeelaa",
            urduTranslation = "بے شک رات کا اٹھنا نفس کو قابو کرنے کے لیے سخت موثر اور کلام کو درست رکھنے کے لیے زیادہ موزوں ہے",
            hindiTranslation = "बेशक रात का उठना नफ़्स को कुचलने के लिए बड़ा असरदार और ज़बान को दुरुस्त रखने के लिए ज़्यादा मौज़ूं है।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 7,
            arabicText = "إِنَّ لَكَ فِى ٱلنَّهَارِ سَبْحًا طَوِيلًا",
            hinglishText = "Inna laka fin-nahaari sabhan taweelaa",
            urduTranslation = "بے شک دن کے وقت آپ کے لیے بہت سے کام اور طویل مصروفیات ہیں",
            hindiTranslation = "बेशक दिन के वक़्त आपके लिए बहुत से काम और लम्बी व्यस्तताएं हैं।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 8,
            arabicText = "وَٱذْكُرِ ٱسْمَ رَبِّكَ وَتَبَتَّلْ إِلَيْهِ تَبْتِيلًا",
            hinglishText = "Wadhkuris-ma Rabbika wa tabattal ilayhi tabteelaa",
            urduTranslation = "اور اپنے رب کے نام کا ذکر کیجیے اور سب سے کٹ کر خالص اسی کے ہو رہیے",
            hindiTranslation = "और अपने रब के नाम का ज़िक्र कीजिए और सबसे कटकर उसी के हो रहिए।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 9,
            arabicText = "رَّبُّ ٱلْمَشْرِقِ وَٱلْمَغْرِبِ لَآ إِلَٰهَ إِلَّا هُوَ فَٱتَّخِذْهُ وَكِيلًا",
            hinglishText = "Rabbul-mashriqi wal-maghribi laaa ilaaha illaa Huwa fattakhidh-hu wakeelaa",
            urduTranslation = "وہ مشرق اور مغرب کا پروردگار ہے، اس کے سوا کوئی معبود نہیں، پس اسی کو اپنا کارساز بنا لیجیے",
            hindiTranslation = "वह पूरब और पश्चिम का रब है, उसके सिवा कोई माबूद नहीं, अतः उसी को अपना कारसाज़ बना लीजिए।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 10,
            arabicText = "وَٱصْبِرْ عَلَىٰ مَا يَقُولُونَ وَٱهْجُرْهُمْ هَجْرًا جَمِيلًا",
            hinglishText = "Wasbir 'alaa maa yaqooloona wahjurhum hajran jameelaa",
            urduTranslation = "اور جو باتیں وہ مخالفین بناتے ہیں ان پر صبر کیجیے اور خوبصورتی کے ساتھ ان سے کنارہ کش رہیے",
            hindiTranslation = "और जो बातें वे मुख़ालिफ़ीन बनाते हैं उन पर सब्र कीजिए और ख़ूबसूरती के साथ उनसे किनारा कर लीजिए।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 11,
            arabicText = "وَذَرْنِى وَٱلْمُكَذِّبِينَ أُو۟لِى ٱلنَّعْمَةِ وَمَهِّلْهُمْ قَلِيلًا",
            hinglishText = "Wa dharnee wal-mukadh-dhibeena ulin-na'mati wa mahhilhum qaleelaa",
            urduTranslation = "اور مجھے اور ان جھٹلانے والے دولت مندوں کو چھوڑ دیجیے، اور انہیں تھوڑی سی مہلت دیجیے",
            hindiTranslation = "और मुझे और इन झुठलाने वाले दौलतमंदों को छोड़ दीजिए, और उन्हें थोड़ी सी मोहलत दीजिए।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 12,
            arabicText = "إِنَّ لَدَيْنَآ أَنكَالًا وَجَحِيمًا",
            hinglishText = "Inna ladaynaaa ankaalanw-wa jaheemaa",
            urduTranslation = "بے شک ہمارے پاس بھاری بیڑیاں اور دہکتی ہوئی جہنم ہے",
            hindiTranslation = "बेशक हमारे पास भारी बेड़ियां और दहकती हुई जहन्नम है।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 13,
            arabicText = "وَطَعَامًا ذَا غُصَّةٍ وَعَذَابًا أَلِيمًا",
            hinglishText = "Wa ta'aaman dhaa ghussatinw-wa 'adhaaban aleemaa",
            urduTranslation = "اور گلے میں پھنس جانے والا کھانا اور دردناک عذاب ہے",
            hindiTranslation = "और गले में फंस जाने वाला खाना और दर्दनाक अज़ाब है।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 14,
            arabicText = "يَوْمَ تَرْجُفُ ٱلْأَرْضُ وَٱلْجِبَالُ وَكَانَتِ ٱلْجِبَالُ كَثِيبًا مَّهِيلًا",
            hinglishText = "Yawma tarjuful-ardu wal-jibaalu wa kaanatil-jibaalu katheebam-maheelaa",
            urduTranslation = "جس دن زمین اور پہاڑ کانپ اٹھیں گے اور پہاڑ ریت کے بکھرے ہوئے ٹیلے بن جائیں گے",
            hindiTranslation = "जिस दिन ज़मीन और पहाड़ कांप उठेंगे और पहाड़ रेत के उड़ते टीले बन जाएंगे।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 15,
            arabicText = "إِنَّآ أَرْسَلْنَآ إِلَيْكُمْ رَسُولًا شَٰهِدًا عَلَيْكُمْ كَمَآ أَرْسَلْنَآ إِلَىٰ فِرْعَوْنَ رَسُولًا",
            hinglishText = "Innaaa arsalnaaa ilaykum Rasoolan shaahidan 'alaykum kamaaa arsalnaaa ilaa Fir'awna Rasoolaa",
            urduTranslation = "بے شک ہم نے تمہاری طرف ایک رسول (محمد ﷺ) بھیجا ہے جو تم پر گواہ ہے، جیسا کہ ہم نے فرعون کی طرف ایک رسول بھیجا تھا",
            hindiTranslation = "बेशक हमने तुम्हारी तरफ़ एक रसूल भेजा है जो तुम पर गवाह है, जैसा कि हमने फ़िरऔन की तरफ़ रसूल भेजा था।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 16,
            arabicText = "فَعَصَىٰ فِرْعَوْنُ ٱلرَّسُولَ فَأَخَذْنَٰهُ أَخْذًا وَبِيلًا",
            hinglishText = "Fa'asaa Fir'awnur-Rasoola fa-akhadhnaahu akhdhanw-wabeelaa",
            urduTranslation = "مگر فرعون نے رسول کی نافرمانی کی تو ہم نے اسے سخت وبال کے ساتھ پکڑ لیا",
            hindiTranslation = "मगर फ़िरऔन ने रसूल की नाफ़रमानी की तो हमने उसे सख़्ती से पकड़ लिया।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 17,
            arabicText = "فَكَيْفَ تَتَّقُونَ إِن كَفَرْتُمْ يَوْمًا يَجْعَلُ ٱلْوِلْدَٰنَ شِيبًا",
            hinglishText = "Fakayfa tattaqoona in kafartum yawmay-yaj'alul-wildaana sheebaa",
            urduTranslation = "پس اگر تم کفر کرو گے تو اس دن کے عذاب سے کیسے بچو گے جو بچوں کو بوڑھا کر دے گا؟",
            hindiTranslation = "तो अगर तुम कुफ़्र करोगे तो उस दिन के अज़ाब से कैसे बचोगे जो बच्चों को बूढ़ा कर देगा?"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 18,
            arabicText = "ٱلسَّمَآءُ مُنفَطِرٌۢ بِهِۦ ۚ كَانَ وَعْدُهُۥ مَفْعُولًا",
            hinglishText = "As-samaaa'u munfatirum-bih; kaana wa'duhoo maf'oolaa",
            urduTranslation = "جس کی ہیبت سے آسمان پھٹ پڑے گا، اللہ کا وعدہ پورا ہو کر ہی رہے گا",
            hindiTranslation = "जिसकी दहशत से आसमान फट पड़ेगा, अल्लाह का वादा पूरा होकर रहेगा।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 19,
            arabicText = "إِنَّ هَٰذِهِۦ تَذْكِرَةٌ ۖ فَمَن شَآءَ ٱتَّخَذَ إِلَىٰ رَبِّهِۦ سَبِيلًا",
            hinglishText = "Inna haadhihee tadhkirah; faman shaaa'at-takhadha ilaa Rabbihee sabeelaa",
            urduTranslation = "بے شک یہ ایک نصیحت ہے، پس جو چاہے اپنے رب کی طرف جانے والا راستہ اختیار کر لے",
            hindiTranslation = "बेशक यह एक नसीहत है, अतः जो चाहे अपने रब की तरफ़ रास्ता बना ले।"
        ),
        Ayah(
            surahNumber = 73,
            ayahNumber = 20,
            arabicText = "۞ إِنَّ رَبَّكَ يَعْلَمُ أَنَّكَ تَقُومُ أَدْنَىٰ مِن ثُلُثَىِ ٱلَّيْلِ وَنِصْفَهُۥ وَثُلُثَهُۥ وَطَآئِفَةٌ مِّنَ ٱلَّذِينَ مَعَكَ ۚ وَٱللَّهُ يُقَدِّرُ ٱلَّيْلَ وَٱلنَّهَارَ ۚ عَلِمَ أَن لَّن تُحْصُوهُ فَتَابَ عَلَيْكُمْ ۖ فَٱقْرَءُوا۟ مَا تَيَسَّرَ مِنَ ٱلْقُرْءَانِ ۚ عَلِمَ أَن سَيَكُونُ مِنكُم مَّرْضَىٰ ۙ وَءَاخَرُونَ يَضْرِبُونَ فِى ٱلْأَرْضِ يَبْتَغُونَ مِن فَضْلِ ٱللَّهِ ۙ وَءَاخَرُونَ يُقَٰتِلُونَ فِى سَبِيلِ ٱللَّهِ ۖ فَٱقْرَءُوا۟ مَا تَيَسَّرَ مِنْهُ ۚ وَأَقِيمُوا۟ ٱلصَّلَوٰةَ وَءَاتُوا۟ ٱلزَّكَوٰةَ وَأَقْرِضُوا۟ ٱللَّهَ قَرْضًا حَسَنًا ۚ وَمَا تُقَدِّمُوا۟ لِأَنفُسِكُم مِّنْ خَيْرٍ تَجِدُوهُ عِندَ ٱللَّهِ هُوَ خَيْرًا وَأَعْظَمَ أَجْرًا ۚ وَٱسْتَغْفِرُوا۟ ٱللَّهَ ۖ إِنَّ ٱللَّهَ غَفُورٌ رَّحِيمٌۢ",
            hinglishText = "Inna Rabbaka ya'lamu annaka taqoomu adnaa min thuluthayil-layli wa nisfahoo wa thuluthahoo wa taaa'ifatum-minal-ladheena ma'ak; wal-laahu yuqaddirul-layla wan-nahaar; 'alima al-lan tuhsoohu fataaba 'alaykum faqra'oo maa tayassara minal-Qur'aan; 'alima an sayakoonu minkum mardaa wa aakharoona yadriboona fil-ardi yabtaghoona min fadlil-laahi wa aakharoona yuqaatiloona fee sabeelil-laahi faqra'oo maa tayassara minh; wa aqeemus-salaata wa aatuz-zakaata wa aqridul-laaha qardan hasanaa; wa maa tuqaddimoo li-anfusikum min khayrin tajidoohu 'indal-laahi huwa khayranw-wa a'zama ajraa; wastaghfirul-laah; innal-laaha Ghafoorur-Raheem",
            urduTranslation = "بے شک آپ کا رب جانتا ہے کہ آپ اور آپ کے ساتھ والے لوگوں کی ایک جماعت کبھی دو تہائی رات، کبھی آدھی رات اور کبھی تہائی رات قیام کرتی ہے؛ اور اللہ ہی رات اور دن کا پورا اندازہ رکھتا ہے، اس نے جانا کہ تم اس کا پورا شمار نہیں رکھ سکو گے تو اس نے تم پر معافی کی نظر فرمائی؛ پس قرآن میں سے جتنا آسانی سے ہو سکے پڑھ لیا کرو؛ اسے معلوم ہے کہ تم میں سے بعض بیمار ہوں گے، اور کچھ دوسرے اللہ کا فضل تلاش کرنے کے لیے زمین میں سفر کر رہے ہوں گے، اور کچھ دوسرے اللہ کی راہ میں جہاد کر رہے ہوں گے؛ پس جتنا آسانی سے ہو سکے پڑھ لیا کرو، اور نماز قائم کرو اور زکوٰۃ ادا کرو اور اللہ کو قرضِ حسنہ دو؛ اور جو بھلائی تم اپنے لیے آگے بھیجو گے اسے اللہ کے پاس کہیں بہتر اور بہت بڑے اجر کی شکل میں پاؤ گے؛ اور اللہ سے مغفرت طلب کرتے رہو، بے شک اللہ بڑا بخشنے والا، نہایت رحم فرمانے والا ہے",
            hindiTranslation = "बेशक आपका रब जानता है कि आप और आपके साथियों की एक जमाअत क़रीब दो तिहाई रात, आधी रात या तिहाई रात नमाज़ में खड़े रहते हैं; और अल्लाह ही रात व दिन का हिसाब रखता है; उसने जाना कि तुम इसे पूरी तरह न निभा सकोगे तो उसने तुम पर रहम फ़रमाया; अतः जितना क़ुरआन आसानी से पढ़ सको पढ़ लिया करो; उसे मालूम है कि तुममें से कुछ बीमार होंगे, कुछ रोज़ी की तलाश में सफ़र करेंगे, और कुछ अल्लाह की राह में जिहाद करेंगे; अतः जितना आसानी से मुमकिन हो पढ़ लिया करो, नमाज़ क़ायम करो, ज़कात दो और अल्लाह को क़र्ज़-ए-हसना दो; और जो भलाई तुम आगे भेजोगे उसे अल्लाह के यहाँ बहुत बेहतर और बड़े बदले के रूप में पाओगे; और अल्लाह से माफ़ी मांगते रहो, बेशक अल्लाह बड़ा बख़्शने वाला, निहायत मेहरबान है।"
        )
    )
}
