package com.example.imgurcomposefinal.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.imgurcomposefinal.data.remote.dto.Data
import com.example.imgurcomposefinal.data.remote.dto.Image
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromDataJson(json: String): List<Data> {
        return jsonParser.fromJson<ArrayList<Data>>(
            json,
            object : TypeToken<ArrayList<Data>>(){}.type
        ) ?: emptyList()
    }

//    @TypeConverter
//    fun fromImageJson(json: String): List<Image> {
//        return jsonParser.fromJson<ArrayList<Image>>(
//            json,
//            object : TypeToken<ArrayList<Image>>(){}.type
//        ) ?: emptyList()
//    }

    @TypeConverter
    fun toDataJson (data: List<Data>) : String {
        return jsonParser.toJson(
            data,
            object : TypeToken<ArrayList<Data>>(){}.type
        ) ?: "[]"
    }

//    @TypeConverter
//    fun toImageJson (data: List<Image>) : String {
//        return jsonParser.toJson(
//            data,
//            object : TypeToken<ArrayList<Image>>(){}.type
//        ) ?: "[]"
//    }
}