package com.example.projet_validation.Repo

import com.example.projet_validation.DAO.Dao
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User

class Repo {

    private val dao = Dao()

    suspend fun getItem(params:String)= dao.getItem(params)




    suspend fun store(univer: Univer)= dao.store(univer)
    suspend fun ListFavorite()= dao.ListFavorite()
    suspend fun delete(name: String)= dao.delete(name)
    suspend fun login(user: User)= dao.login(user)
}