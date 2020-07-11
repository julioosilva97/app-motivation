package btech.com.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecutityPreferences(context: Context) {

    private val sharedPreferences : SharedPreferences = context.getSharedPreferences("motivation",Context.MODE_PRIVATE)

    fun storeString(key:String,value:String){
        sharedPreferences.edit().putString(key,value).apply()
    }

    fun getStoredString(key :String): String {
        return sharedPreferences.getString(key,"") ?: "" //se vim null ?: faça isso
    }
}