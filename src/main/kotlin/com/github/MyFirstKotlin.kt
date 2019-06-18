package com.github


fun main(args : Array<String>) {

    val employee = Employee("Sunit", "Parekh")
    employee.fullName()


    val listOf = listOf("Sunit", "Parekh")
    listOf.count { item -> item == "Sunit" }
}

open class Employee(val firstName: String, val lastName: String) {

    var fullName = firstName + lastName
        set(value) { field = value }

    init {
        fullName = firstName + lastName
    }

    open fun fullName() = firstName + lastName

}

class Student(firstName: String, lastName: String, val department: String)
    : Employee(firstName,lastName) {


    override fun fullName() = firstName + lastName
}
