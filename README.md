Task Management and Productivity Tracker
Overview
As part of my Module #3 learning for CSE 310, I developed a Command Line Interface (CLI) application using Kotlin to help users track and manage their daily tasks. This project allowed me to demonstrate advanced programming concepts including data classes, complex collections, and persistent file storage.

The software allows users to create tasks with specific categories, toggle their completion status, and ensure all data is saved to a local text file for future sessions.
Video Demo Link- 

Development Environment

Language: Kotlin

IDE: IntelliJ IDEA


Version Control: Git/GitHub

Libraries: Java.io (for File I/O)

Execution Instructions
To run this project on your local machine, follow these steps:

Install Kotlin: Ensure you have the Kotlin SDK and a Java Runtime Environment (JRE) installed.

Clone the Repository: Download the source code from GitHub.

Open in IntelliJ: Open the project folder in IntelliJ IDEA.

Run the App: Locate TaskTracker.kt in the src folder, right-click the main() function, and select Run 'TaskTrackerKt'.

Data Storage: The application will automatically create a tasks.txt file in the project directory to save your data.

Useful Websites
Kotlin Data Classes Documentation-https://kotlinlang.org/docs/data-classes.html: This was essential for understanding how to properly structure the Task data class with specific properties like IDs and Booleans.

Baeldung-https://www.baeldung.com/kotlin/read-file: Reading and Writing Files in Kotlin: I used this guide to implement the PrintWriter logic for saveTasksToFile and the forEachLine logic for loadTasksFromFile.

Kotlin Collections Overview-https://kotlinlang.org/docs/collections-overview.html: This provided the foundation for using a MutableList to store tasks and using functions like .find and .removeIf to manage the list effectively.

JetBrains Academy - Input/Output-https://hyperskill.org/projects/555: This resource helped me handle the readLine() inputs and ensure the menu loop continued correctly without crashing.

Future Work
Priority Levels: Add a feature to tag tasks as High, Medium, or Low priority.

Due Date Sorting: Implement a function to sort tasks by their deadline dates using java.time.

Search Functionality: Add a keyword search to find specific tasks within large lists.