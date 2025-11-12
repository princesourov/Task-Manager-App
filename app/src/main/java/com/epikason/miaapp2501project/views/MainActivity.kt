package com.epikason.miaapp2501project.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.epikason.miaapp2501project.R
import com.epikason.miaapp2501project.databinding.ActivityMainBinding
import com.epikason.miaapp2501project.db.Task
import com.epikason.miaapp2501project.db.TaskDao
import com.epikason.miaapp2501project.db.TaskDatabase

class MainActivity : AppCompatActivity(), TaskAdapter.HandleTaskClick {
    lateinit var binding: ActivityMainBinding
    lateinit var dao: TaskDao
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "Task_DB"
        ).allowMainThreadQueries().build()


        dao = db.getTaskDao()

        setTaskData()

        binding.addTaskBtn.setOnClickListener {
            val intent = Intent(this, AddEditTaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setTaskData() {
        adapter = TaskAdapter(this@MainActivity,emptyList())
        binding.rvTasks.layoutManager = LinearLayoutManager(this)
        binding.rvTasks.adapter = adapter


        dao.getAllTasksSortedByDueDate().observe(this, Observer { tasks ->
            adapter = TaskAdapter(this@MainActivity,tasks)
            binding.rvTasks.adapter = adapter
        })
    }

    override fun onEditClick(task: Task) {
        val editIntent = Intent(this, AddEditTaskActivity::class.java)
        editIntent.putExtra(AddEditTaskActivity.editKey,task)
        startActivity(editIntent)
    }

    override fun onDeleteClick(task: Task) {
        dao.deleteTask(task)
        Toast.makeText(this, "Task Deleted!!", Toast.LENGTH_SHORT).show()
        setTaskData()
    }

    override fun onCompletedChanged(
        task: Task,
        isCompleted: Boolean
    ) {
        dao.editTask(task.copy(isCompleted=isCompleted))
    }

    override fun onResume() {
        setTaskData()
        super.onResume()
    }

}

