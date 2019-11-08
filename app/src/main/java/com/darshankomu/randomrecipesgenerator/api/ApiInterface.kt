package com.darshankomu.randomrecipesgenerator.api
import com.darshankomu.randomrecipesgenerator.model.Recipes
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @get:GET("random.php")
    val get_recipes: Call<Recipes>

}
