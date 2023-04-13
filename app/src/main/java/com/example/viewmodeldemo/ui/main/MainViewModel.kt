package com.example.viewmodeldemo.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodeldemo.model.MainRepository
import com.example.viewmodeldemo.model.StudentModel

class MainViewModel: ViewModel() {

    private val mainRepo = MainRepository()

    private val _students: MutableLiveData<List<StudentModel>> = MutableLiveData(listOf())
    val students: LiveData<List<StudentModel>> = _students

    fun getAllStudents() {
        _students.value = mainRepo.getAllStudents()
    }
}