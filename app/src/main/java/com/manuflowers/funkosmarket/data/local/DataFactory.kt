package com.manuflowers.funkosmarket.data.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manuflowers.funkosmarket.data.model.FunkoEntity
import java.io.IOException

class DataFactoryImpl(private val context: Context) : DataFactory {

    override fun loadData(): List<FunkoEntity> {
        val jsonFileAsString = loadJSONFileFromAssets("funkos.json")
        val gson = Gson()
        val funkosListType = object : TypeToken<List<FunkoEntity>>() {}.type
        return gson.fromJson(jsonFileAsString, funkosListType)
    }

    private fun loadJSONFileFromAssets(fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            null
        }
    }
}

interface DataFactory {
    fun loadData(): List<FunkoEntity>
}