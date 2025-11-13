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
| description | String | Task details |
| dueDate | String | Due date (in millis) |
| isCompleted | Boolean | Task completion status |

---

## 📦 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/princesourov/Task-Manager-App.git

---

## 🖼️ Screenshots 

| Task List | Add/Edit Task |
|:--:|:--:|
| <img src="https://github.com/user-attachments/assets/8e1b8e54-4a93-4fa4-93fa-5aa5e3985505" width="250"/> | <img src="https://github.com/user-attachments/assets/fa8b2c44-5a35-4726-8e44-3e187538a157" width="250"/> |


---

## 👨‍💻 Author

👤 Iqbal Hossain Sourav 

💼 Android App Developer | 💻 Computer Science Student

📧 Email: princesourov41@gmail.com

🏢 Organization: MS Innovations

🌍 From: Nilphamari, Bangladesh

🌐 Website: epikason.weebly.com

💬 Built with ❤️, Kotlin, and endless cups of coffee ☕







