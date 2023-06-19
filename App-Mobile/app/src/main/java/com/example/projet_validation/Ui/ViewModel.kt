package com.example.projet_validation.Ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.projet_validation.Model.Univer
import com.example.projet_validation.Model.User
import com.example.projet_validation.Repo.Repo
import com.example.projet_validation.Util.Resource
import kotlinx.coroutines.Dispatchers

class ViewModel : ViewModel() {

    private val repo = Repo()



    fun  getItem(params:String)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.getItem(params)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }









    fun  store(univer: Univer)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.store(univer)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }

    fun  ListFavorite()= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.ListFavorite()))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }

    fun  delete(name: String)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.delete(name)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }

    fun  login(user: User)= liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repo.login(user)))
        }
        catch (exception:Exception){
            emit(Resource.error(data = null, message = exception.message?:"Error"))
        }
    }



}