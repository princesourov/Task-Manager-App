package com.epikason.miaapp2501project.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY CASE WHEN dueDate IS NULL THEN 1 ELSE 0 END, dueDate ASC")
    fun getAllTasksSortedByDueDate(): LiveData<List<Task>>

    @Insert
    fun addTask(task: Task)

    @Update
    fun editTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("SELECT * FROM task WHERE id = :taskId LIMIT 1")
    fun getTaskById(taskId: Int): Task?
}
