package com.example.projet_validation.DAO

import com.example.projet_validation.DAO.API.ApiServicesInterface
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Dao {

    companion object{
        // private var url ="http://192.168.2.46:8000/api/"
        private var url ="http://0.0.0.0:8000/api/"
        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiService: ApiServicesInterface = getRetrofit().create(ApiServicesInterface::class.java)

    }

    suspend fun getItem(params:String)= apiService.getItem(params)





    suspend fun store(univer: Univer)= apiService.store(univer)
    suspend fun ListFavorite()= apiService.ListFavorite()
    suspend fun delete(name: String)= apiService.delete(name)
    suspend fun login(user: User)= apiService.login(user)

}