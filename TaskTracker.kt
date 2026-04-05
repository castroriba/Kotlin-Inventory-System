import java.io.File

/**
 * 1. DATA CLASS REQUIREMENT
 * Represents a single task in the system.
 */
data class Task(
    val id: Int,
    var title: String,
    var category: String,
    var isCompleted: Boolean = false
)

/**
 * 2. FILE I/O REQUIREMENT - SAVE
 * Renamed to saveTasksToFile to avoid conflict with the inventory system.
 */
fun saveTasksToFile(tasks: List<Task>) {
    val file = File("tasks.txt")
    try {
        file.printWriter().use { out ->
            tasks.forEach {
                out.println("${it.id}|${it.title}|${it.category}|${it.isCompleted}")
            }
        }
        println("\nSystem: All tasks have been saved to tasks.txt")
    } catch (e: Exception) {
        println("Error saving to file: ${e.message}")
    }
}

/**
 * 3. FILE I/O REQUIREMENT - LOAD
 * Renamed to loadTasksFromFile to avoid conflict with the inventory system.
 */
fun loadTasksFromFile(): MutableList<Task> {
    val tasks = mutableListOf<Task>()
    val file = File("tasks.txt")
    if (file.exists()) {
        file.forEachLine { line ->
            val parts = line.split("|")
            if (parts.size == 4) {
                // Correctly mapping data to the Task data class
                tasks.add(Task(parts[0].toInt(), parts[1], parts[2], parts[3].toBoolean()))
            }
        }
        println("System: Tasks loaded successfully from file.")
    }
    return tasks
}

/**
 * 4. FUNCTIONS & COLLECTIONS REQUIREMENT
 * Adds a new task with a unique ID based on the current list size.
 */
fun addTask(taskList: MutableList<Task>) {
    println("\n--- Create New Task ---")
    print("Task Title: ")
    val title = readLine() ?: "New Task"
    print("Category (Work/Home/School): ")
    val category = readLine() ?: "General"

    // EXPRESSION: Determine next available ID
    val id = if (taskList.isEmpty()) 1 else taskList.maxOf { it.id } + 1

    taskList.add(Task(id, title, category))
    println("Success: Task added!")
}

/**
 * 5. LOOPS REQUIREMENT
 * Displays all tasks currently in the list.
 */
fun viewTasks(taskList: List<Task>) {
    if (taskList.isEmpty()) {
        println("\nYour list is empty. Add a task to get started!")
        return
    }
    println("\n--- Your Task List ---")
    for (task in taskList) {
        val status = if (task.isCompleted) "[COMPLETED]" else "[PENDING]"
        println("${task.id}. $status ${task.title} (${task.category})")
    }
}

/**
 * 6. CONDITIONALS & USER INTERFACE
 * The main entry point using a 'when' block and 'while' loop.
 */
fun main() {
    // Calling the renamed load function
    val taskList = loadTasksFromFile()
    var userChoice = 0

    while (userChoice != 5) {
        println("\n**************************")
        println("* MODULE 3: TASK TRACKER *")
        println("**************************")
        println("1. Add Task")
        println("2. View All Tasks")
        println("3. Toggle Task Completion")
        println("4. Delete Task")
        println("5. Save and Exit")
        print("Selection: ")

        userChoice = readLine()?.toIntOrNull() ?: 0

        when (userChoice) {
            1 -> addTask(taskList)
            2 -> viewTasks(taskList)
            3 -> {
                print("Enter Task ID to toggle: ")
                val idInput = readLine()?.toIntOrNull()
                val foundTask = taskList.find { it.id == idInput }
                if (foundTask != null) {
                    foundTask.isCompleted = !foundTask.isCompleted
                    println("Task ${foundTask.id} status updated.")
                } else {
                    println("Task ID not found.")
                }
            }
            4 -> {
                print("Enter Task ID to delete: ")
                val idInput = readLine()?.toIntOrNull()
                // Fixed the reference to correctly target the task list
                if (taskList.removeIf { it.id == idInput }) {
                    println("Task removed.")
                } else {
                    println("Task ID not found.")
                }
            }
            5 -> {
                // Calling the renamed save function
                saveTasksToFile(taskList)
                println("Closing application. Have a productive day!")
            }
            else -> println("Invalid input. Please choose 1-5.")
        }
    }
}