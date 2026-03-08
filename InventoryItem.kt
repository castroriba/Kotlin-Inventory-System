// 1. DATA CLASS
data class InventoryItem(
    val id: Int,
    var name: String,
    var quantity: Int,
    var price: Double
)

// 2. HELPER FUNCTIONS (Adding these helps reach the 100-line goal)
fun printHeader() {
    println("\n==============================")
    println("   INVENTORY MANAGEMENT APP")
    println("==============================")
}

fun main() {
    val inventory = mutableListOf<InventoryItem>()

    // Starting with a test item
    inventory.add(InventoryItem(1, "Apple", 50, 0.50))

    var userChoice = 0

    while (userChoice != 6) {
        printHeader()
        println("1. Add New Item")
        println("2. View All Items")
        println("3. Search for Item")
        println("4. Update Item Quantity")
        println("5. Delete Item")
        println("6. Exit")
        print("Enter choice: ")

        userChoice = readLine()?.toIntOrNull() ?: 0

        when (userChoice) {
            1 -> {
                println("\n--- Add New Item ---")
                print("Enter ID number: ")
                val id = readLine()?.toIntOrNull() ?: 0
                print("Enter Name: ")
                val name = readLine() ?: "Unknown"
                print("Enter Quantity: ")
                val qty = readLine()?.toIntOrNull() ?: 0
                print("Enter Price: ")
                val price = readLine()?.toDoubleOrNull() ?: 0.0

                inventory.add(InventoryItem(id, name, qty, price))
                println("Item '$name' added successfully!")
            }
            2 -> {
                println("\n--- Current Inventory ---")
                if (inventory.isEmpty()) {
                    println("The inventory is currently empty.")
                } else {
                    for (item in inventory) {
                        println("ID: ${item.id} | Name: ${item.name} | Qty: ${item.quantity} | Price: $${item.price}")
                    }
                }
            }
            3 -> {
                println("\n--- Search Inventory ---")
                print("Enter the name of the item to find: ")
                val searchName = readLine()?.lowercase() ?: ""
                val foundItems = inventory.filter { it.name.lowercase().contains(searchName) }

                if (foundItems.isEmpty()) {
                    println("No items found matching '$searchName'.")
                } else {
                    for (item in foundItems) {
                        println("Found: ID: ${item.id} | Name: ${item.name} | Qty: ${item.quantity}")
                    }
                }
            }
            4 -> {
                // NEW: Update Quantity
                print("\nEnter the ID of the item to update: ")
                val updateId = readLine()?.toIntOrNull() ?: -1
                val itemToUpdate = inventory.find { it.id == updateId }

                if (itemToUpdate != null) {
                    print("Enter new quantity for ${itemToUpdate.name}: ")
                    val newQty = readLine()?.toIntOrNull() ?: itemToUpdate.quantity
                    itemToUpdate.quantity = newQty
                    println("Quantity updated!")
                } else {
                    println("Item ID not found.")
                }
            }
            5 -> {
                // NEW: Delete Item
                print("\nEnter the ID of the item to delete: ")
                val deleteId = readLine()?.toIntOrNull() ?: -1
                val removed = inventory.removeIf { it.id == deleteId }

                if (removed) {
                    println("Item deleted successfully.")
                } else {
                    println("Item ID not found.")
                }
            }
            6 -> println("Exiting program... Goodbye!")
            else -> println("Invalid choice, please try again.")
        }
    }
}
