package com.example.kotlin_lab

import com.example.kotlin_lab.data.TaskEntry
import com.example.kotlin_lab.data.TaskRepository

fun main (){

    val taskRepository = TaskRepository()
    // Ajouter une tâche
    val task = TaskEntry(1,"Task 1",1,System.currentTimeMillis())
    taskRepository.save(task);


    // Suprimer une tâche
//    taskRepository.delete(1)
    // Modifier une tâche
    val titleUp = taskRepository.findById(1)
    titleUp.title = "gidf"
    taskRepository.save(titleUp)


    // Afficher les tâches
    for(item in taskRepository.getAllTasks()){
        print(item.title)
    }


}