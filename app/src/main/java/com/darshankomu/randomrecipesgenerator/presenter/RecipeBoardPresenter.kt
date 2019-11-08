package com.darshankomu.randomrecipesgenerator.presenter

import com.darshankomu.randomrecipesgenerator.api.ApiClient
import com.darshankomu.randomrecipesgenerator.api.ApiInterface
import com.darshankomu.randomrecipesgenerator.model.Recipes
import com.darshankomu.randomrecipesgenerator.view.RecipeBoardView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RecipeBoardPresenter(private val view : RecipeBoardView) {

    internal fun getRecipesData()
    {
        view.showLoading()

        val apiInterface = ApiClient.apiClient.create(ApiInterface::class.java)

        val call = apiInterface.get_recipes

        call.enqueue(object : Callback<Recipes>
        {

            override fun onResponse(call: Call<Recipes>, response: Response<Recipes>) {
                view.hideLoading()

                if(response.isSuccessful)
                {
                    view.getResult(response.body())
                }


            }

            override fun onFailure(call: Call<Recipes>, t: Throwable) {
                view.hideLoading()
                view.onRequestError(t.localizedMessage!!)
            }

        })

    }



}
