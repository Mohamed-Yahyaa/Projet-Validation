package com.example.projet_validation.Ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.projet_validation.R
import com.example.projet_validation.Util.status
import com.example.projet_validation.databinding.FragmentAccueilBinding
import com.squareup.picasso.Picasso
import java.util.Observer

class AccueilFragment :BaseFragment<FragmentAccueilBinding>(FragmentAccueilBinding::inflate) {




    private val viewModel: ViewModel by viewModels()
    override fun init(view: View) {
        binding.apply {
            arguments.let {
                if (it != null) {
//                    filmID = it.getInt("idFilm",0)
                }
            }

        }
        viewModel.getItem("ee").observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it.status){
                status.ERROR-> this.showResponseError(it.message.toString())
                status.SUCCESS->{
                    binding.apply {

//                        Picasso.get().load("https://image.tmdb.org/t/p/w500/"+it.data?.backdrop_path).into(imageFilm)
                    }
                }

                else -> { print("dddddddddddd")
                }
            }


        })

    }

    override fun listeners(view: View) {
        binding.apply {
        }
    }

}