package com.dicoding.dotaheroesbase.core.utils

import androidx.room.TypeConverter

class TypeConverter {
    @TypeConverter
    fun fromStringList(list: List<String?>?): String? {
        return list?.joinToString(separator = ";")
    }

    @TypeConverter
    fun toStringList(string: String?): List<String?>? {
        return string?.split(";")
    }
}
