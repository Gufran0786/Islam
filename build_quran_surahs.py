#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Generates complete authentic Quran Surahs with Arabic, Hinglish transliteration,
Urdu translation, and Hindi translation.
"""

import os
import json

def escape_kt(s):
    return s.replace('\\', '\\\\').replace('"', '\\"').replace('$', '\\$')

def ayah_code(surah, ayah, ar, hing, ur, hi):
    return f"""        Ayah(
            surahNumber = {surah},
            ayahNumber = {ayah},
            arabicText = "{escape_kt(ar)}",
            hinglishText = "{escape_kt(hing)}",
            urduTranslation = "{escape_kt(ur)}",
            hindiTranslation = "{escape_kt(hi)}"
        )"""

print("Generator script template ready")
