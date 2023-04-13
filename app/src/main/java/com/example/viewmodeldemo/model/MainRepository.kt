package com.example.viewmodeldemo.model

class MainRepository {

    fun getAllStudents(): List<StudentModel> {

        val students = mutableListOf<StudentModel>()

        students.add(StudentModel("Jane", 35))
        students.add(StudentModel("James", 54))
        students.add(StudentModel("Jack", 70))

        return students
    }

}