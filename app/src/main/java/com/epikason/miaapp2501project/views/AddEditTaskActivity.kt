package com.epikason.miaapp2501project.views

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.epikason.miaapp2501project.databinding.ActivityAddEditTaskBinding
import com.epikason.miaapp2501project.db.Task
import com.epikason.miaapp2501project.db.TaskDao
import com.epikason.miaapp2501project.db.TaskDatabase
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Suppress("DEPRECATION")
class AddEditTaskActivity : AppCompatActivity() {
    companion object{
        const val editKey ="edit"
        const val Update ="Update"
        const val add ="Save"
    }
    lateinit var binding: ActivityAddEditTaskBinding
    lateinit var dao: TaskDao
    private var taskId = 0
    private var selectedDate: Long? = null
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityAddEditTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Room.databaseBuilder(
            applicationContext,
            TaskDatabase::class.java,
            "Task_DB"
        ).allowMainThreadQueries().build()

        dao = db.getTaskDao()

        if (intent.hasExtra(editKey)){
            binding.btnSave.text = Update
            binding.tvPage.text = "Update task"
            val task = intent.getParcelableExtra<Task>(editKey)

            task?.let {
                binding.apply {
                    etTitle.setText(it.title)
                    etDescription.setText(it.description)
                    tvPickedDate.text = it.dueDate
                    cbCompleted.isChecked = it.isCompleted
                    taskId = it.id
                    selectedDate = dateFormat.parse(task.dueDate)?.time
                }
            }

        }else{
            binding.btnSave.text = add
            binding.tvPage.text = "Add new task"
        }


        binding.btnPickDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val picker = DatePickerDialog(
                this,
                { _, y, m, d ->
                    calendar.set(y, m, d)
                    selectedDate = calendar.timeInMillis
                    binding.tvPickedDate.text = dateFormat.format(calendar.time)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            picker.show()
        }

        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val desc = binding.etDescription.text.toString().trim()
            val pickedDate = binding.tvPickedDate.text.toString()
            val completed = binding.cbCompleted.isChecked

            if (title.isEmpty()) {
                binding.etTitle.error = "Title can't be empty"
                return@setOnClickListener
            }
            if (selectedDate == null) {
                binding.tvPickedDate.apply {
                    error = "Please pick a date"
                    text = "Please pick a date"
                }
                return@setOnClickListener
            }
            if (binding.btnSave.text.toString()==add){
                addTask(title, desc, pickedDate, completed)
            }else{
                updateTask(title, desc, pickedDate, completed)
            }

        }

    }

    private fun updateTask(title: String, desc: String, pickedDate: String, completed: Boolean) {
        val task = Task(taskId, title, desc, pickedDate, completed)
        dao.editTask(task)
        Toast.makeText(this, "Task Update successfully!", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun addTask(title: String, desc: String, pickedDate: String, completed: Boolean) {
        val task = Task(0, title, desc, pickedDate, completed)
        dao.addTask(task)
        Toast.makeText(this, "Task added successfully!", Toast.LENGTH_SHORT).show()
        finish()
    }


}