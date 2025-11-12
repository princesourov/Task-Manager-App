package com.epikason.miaapp2501project.views

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.epikason.miaapp2501project.databinding.ItemTaskBinding
import com.epikason.miaapp2501project.db.Task

class TaskAdapter(val listener: HandleTaskClick ,val taskList: List<Task>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    interface HandleTaskClick{
        fun onEditClick(task: Task)
        fun onDeleteClick(task: Task)
        fun onCompletedChanged(task: Task, isCompleted: Boolean)
    }

    class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TaskViewHolder,
        position: Int
    ) {
        val task = taskList[position]
        holder.binding.apply {
            tvTitle.text = task.title
            tvDescription.text = task.description ?: ""
            tvDueDate.text = task.dueDate ?: "No date"
            cbCompleted.isChecked = task.isCompleted

            if (task.isCompleted) {
                tvStatus.text = "Completed"
                tvStatus.setTextColor(android.graphics.Color.GREEN)
            } else {
                tvStatus.text = "Pending"
                tvStatus.setTextColor(android.graphics.Color.RED)
            }

            root.setOnClickListener {
                listener.onEditClick(task)
                true
            }
            root.setOnLongClickListener {
                val builder = AlertDialog.Builder(holder.itemView.context)
                builder.setTitle("Delete Task")
                builder.setMessage("Are you sure you want to delete this task?")

                builder.setPositiveButton("Yes") { dialog, _ ->
                    listener.onDeleteClick(task)
                    Toast.makeText(holder.itemView.context, "Task Deleted!!", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                builder.setNegativeButton("No") { dialog, _ ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
                true
            }

            cbCompleted.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked != task.isCompleted) {
                    listener.onCompletedChanged(task, isChecked)
                }
        }


    }
    }
    override fun getItemCount(): Int = taskList.size
}