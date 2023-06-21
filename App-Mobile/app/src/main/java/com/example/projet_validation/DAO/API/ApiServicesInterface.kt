package com.example.projet_validation.DAO.API

import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import retrofit2.http.*

interface ApiServicesInterface {



    @GET("getItem/{params}")
    suspend fun getItem(@Path("params") params:String): List<Univer>





    @POST("store_mob")
    suspend fun store(@Body univer: Univer ):Int

    @GET("ListFavorite")

    suspend fun ListFavorite():List<Univer>

    @GET("deletee/{name}")
    suspend fun delete(@Path("name") name: String):Int

    @POST("login")
    suspend fun login(@Body user:User):User

}