package com.example.tbc_test5.fragments.main

import android.util.Log.d
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tbc_test5.models.ActiveCourse
import com.example.tbc_test5.models.NewCourse
import com.example.tbc_test5.network.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException

class MainFragmentViewModel: ViewModel() {
    private val _newCoursesList = MutableStateFlow<List<NewCourse>?>(null)
    val newCoursesList: StateFlow<List<NewCourse>?> get() = _newCoursesList

    private val _activeCoursesList = MutableStateFlow<List<ActiveCourse>?>(null)
    val activeCoursesList: StateFlow<List<ActiveCourse>?> get() = _activeCoursesList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                val response = Repository().getCourses()
                if (response.isSuccessful){
                    _newCoursesList.value = response.body()!!.newCourses
                    _activeCoursesList.value = response.body()!!.activeCourses
                }
            }catch (e: IOException){
                d("Response", "${e.message}")
            }catch (e: Exception){
                d("Response", "${e.message}")
            }
        }
    }
}