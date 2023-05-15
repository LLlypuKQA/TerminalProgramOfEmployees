fun main(args: Array<String>) {
    val menu = listOf(
        Menu(1, "Show list of employees"),
        Menu(2, "Add employee"),
        Menu(3, "Delete employee")
    )

    while (true) {
        println("MENU:")
        menu.forEach { println(it) }
        val input = readlnOrNull()?.toIntOrNull()
        when (input) {

            1 -> {
                showListOfEmployees()
                if (employeesList.isEmpty()) println("No Employees")
            }

            2 -> {
                println("Add full name: ")
                val addName = readlnOrNull().toString()
                println("Add age: ")
                val addAge = readlnOrNull().toString()
                employeesList.add(Employees(addName, addAge).toString())
                showListOfEmployees()
            }

            3 -> {
                println("Choice a number: ")
                val deleteEmployee = readlnOrNull()?.toInt()
                if (deleteEmployee != null) {
                    val index = deleteEmployee - 1
                    if (employeesList.indices.contains(index)) {
                        employeesList.removeAt(index)
                    } else println("ERROR: Incorrect input")
                    showListOfEmployees()
                }
            }
            else -> println("ERROR: Incorrect input")
        }
    }
}

val employeesList = mutableListOf<String>()
fun showListOfEmployees() {
    for ((index, employee) in employeesList.withIndex()){
        println("${index + 1}. $employee")
    }
}