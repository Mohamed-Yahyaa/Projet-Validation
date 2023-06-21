package com.example.lab_kotlinlivecoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_kotlinlivecoding.databinding.ActivityMainBinding
import com.example.lab_kotlinlivecoding.ui.TaskAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding: il lier layout avec data source
//        inflate : utilise pour convertire xml a view
        var binding = ActivityMainBinding.inflate(layoutInflater)
//        en utilise pour faire set a layout pour activitiy
        setContentView(binding.root)
//        binding.apply : en utilise pour donner l'acces a view
          binding.apply {
//              taskAdapter : pour adabter les tache dans recycelview
              var taskAdapter = TaskAdapter()
//              layoutManager : c'est responsable de position d'un item dans recycelview
              referenceRecyclerView.layoutManager = LinearLayoutManager(applicationContext)
              referenceRecyclerView.adapter = taskAdapter
          }
    }
}