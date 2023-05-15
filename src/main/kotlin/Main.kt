fun main(args: Array<String>) {
    val menu = listOf(
        Menu(1, "Show list of employees"),
        Menu(2, "Add employee"),
        Menu(3, "Delete employee")
    )
    val listEmployee = mutableListOf<String>()
    fun empl() {
        for ((index, employee) in listEmployee.withIndex()){
            println("${index + 1}. $employee")
        }
    }

    while (true) {
        println("MENU:")
        menu.forEach { println(it) }
        val input = readlnOrNull()?.toIntOrNull()
        when (input) {

            1 -> {
                empl()
                if (listEmployee.isEmpty()) println("No Employees")
            }

            2 -> {
                println("Add full name: ")
                val addName = readlnOrNull().toString()
                println("Add age: ")
                val addAge = readlnOrNull().toString()
                listEmployee.add(Employees(addName, addAge).toString())
                empl()
            }

            3 -> {
                println("Choice a number: ")
                val deleteEmployee = readlnOrNull()?.toInt()
                if (deleteEmployee != null) {
                    val index = deleteEmployee - 1
                    if (listEmployee.indices.contains(index)) {
                        listEmployee.removeAt(index)
                    }
                    empl()
                }
            }
            else -> println("ERROR: Incorrect input")
            //Test commit - delete me
        }
    }
}