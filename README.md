# 🗂️ Task Manager App

A simple **Task Manager Android App** built using **Kotlin**, **Room Database**, and **RecyclerView**.  
This app allows users to **add**, **edit**, **delete**, and **view** tasks locally — sorted by due date.  

---

## 🚀 Features

✅ Add new tasks with title, description, due date, and completion status  
✅ Edit existing tasks with pre-filled data  
✅ Delete tasks with a confirmation dialog  
✅ Store tasks locally using **Room Database**  
✅ View all tasks sorted by due date  
✅ Simple and modern user interface  
✅ (Optional) Search and filter support  

---

## 🧱 Tech Stack

| Component | Technology Used |
|------------|----------------|
| Language | Kotlin |
| Database | Room (Local Storage) |
| UI | RecyclerView, Material Design |
| Architecture | MVVM (basic structure) |
| Async Operations | Coroutines + LiveData |

---

## 📲 Screens Included

1. **MainActivity** – Displays all saved tasks in a RecyclerView.  
2. **AddEditTaskActivity** – Add or edit a task with validation and date picker.

---

## 🗃️ Database Design

**Entity:** `Task`  
| Field | Type | Description |
|--------|------|-------------|
| id | Int (Auto-generated) | Primary key |
| title | String | Task title |
| description | String? | Task details |
| dueDate | Long? | Due date (in millis) |
| isCompleted | Boolean | Task completion status |

---

## 📦 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/yourusername/TaskManagerApp.git

---

## 🖼️ Screenshots 

| Task List                                                                   | Add/Edit Task                     |
| --------------------------------------------------------------------------- | --------------------------------- |
| ![Task List Screen](A_screenshot_of_a_Task_Manager_application_on_a_mo.png) | (Add Task screen screenshot here) |

---
## 🧑‍💻 Author
Iqbal Hossain Sourav

📧 [princesourov41@gmail.com]

💬 Built with ❤️ and Kotlin

