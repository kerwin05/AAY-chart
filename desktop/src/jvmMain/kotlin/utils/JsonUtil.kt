package utils

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 *  Created by Kerwin
 *  on Date: 2022/5/10
 */

/**
 * JSON工具
 */
object JsonUtil {

    private val gson: Gson = GsonBuilder()
        .setPrettyPrinting()
        .create()

    fun <T> fromJson(content: String, clazz: Class<T>): T {
        return gson.fromJson(content, clazz)
    }

    fun <T> fromJson(content: String?, typeOfT: Type?): T {
        return gson.fromJson(content, typeOfT)
    }

    fun <T> fromJsonType(content: String, type: Type): T {
        return gson.fromJson(content, type)
    }

    fun <T> fromJsonArray(content: String, type: Type): ArrayList<T> {
        return gson.fromJson(content, type)
    }

    fun toJson(any: Any): String {
        return gson.toJson(any)
    }

    /**
     * object -> jsonString
     * 通过传递[typeAdapter]解决json字符串乱序的问题
     */
    fun <T> toJson(any: Any, typeAdapter: TypeAdapter<T>): String {
        val gson = GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(any::class.java, typeAdapter)
            .create()
        return gson.toJson(any)
    }
}