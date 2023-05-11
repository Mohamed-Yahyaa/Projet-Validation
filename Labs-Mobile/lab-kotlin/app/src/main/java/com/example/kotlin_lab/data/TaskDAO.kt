package com.example.kotlin_lab.data

class TaskDAO {

    companion object {

        private  var task_count = 0
        private var list_tasks : MutableList<TaskEntry> = mutableListOf<TaskEntry>()

        init {
            for (i in 1 ..10){
               val task = TaskEntry(++task_count,"Todo $i",1,System.currentTimeMillis())
                list_tasks.add(0,task)
            }
        }
    }


    fun insert(taskEntry: TaskEntry){
        taskEntry.id = ++TaskDAO.task_count
        TaskDAO.list_tasks.add(0,taskEntry)
    }

    fun delete (id:Int){
     var index = this.findIndexById(id)
      list_tasks.removeAt(index)
    }

    fun update(taskEntry: TaskEntry){
        var index = this.findIndexById(taskEntry.id);
        TaskDAO.list_tasks[index] = taskEntry
    }
//
    private fun findIndexById(id: Int): Int {
        val index = TaskDAO.list_tasks.withIndex().filter { it.value.id == id }.map{it.index}.first()
        return index
    }
//

    fun getAllTasks(): MutableList<TaskEntry> {
        return TaskDAO.list_tasks
    }

    fun findById(id: Int) :TaskEntry {
        val task = TaskDAO.list_tasks.filter { it.id == id }.first()
        return task
    }


}