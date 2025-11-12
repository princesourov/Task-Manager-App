package com.epikason.miaapp2501project.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var description: String,
    var dueDate: String,
    var isCompleted: Boolean = false
) : Parcelable
