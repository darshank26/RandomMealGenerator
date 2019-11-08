package com.darshankomu.randomrecipesgenerator.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.OkHttpClient





object ApiClient {

    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    private var retrofit: Retrofit? = null

    var client = OkHttpClient()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    val apiClient: Retrofit
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return retrofit!!
        }


}
