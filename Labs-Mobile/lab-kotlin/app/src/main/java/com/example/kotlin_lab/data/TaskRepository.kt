package com.example.kotlin_lab.data

class TaskRepository () {

    private val taskDAO = TaskDAO()
    private fun insert(taskEntry: TaskEntry) = taskDAO.insert(taskEntry)
    private fun update(taskEntry: TaskEntry) = taskDAO.update(taskEntry)
    fun delete(taskId: Int) = taskDAO.delete(taskId)
    fun getAllTasks() = taskDAO.getAllTasks()
    fun findById(id: Int) = taskDAO.findById(id)
    fun newTask(): TaskEntry {
        return TaskEntry(0,"",0,System.currentTimeMillis())
    }

    fun save(taskEntry: TaskEntry) {

        if(taskEntry.id == 0){
            this.insert(taskEntry)
        }else{
            this.update(taskEntry)
        }
    }


}