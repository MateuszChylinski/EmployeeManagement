package com.example.employeemanagement.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeemanagement.Model.EmployeeModel
import com.example.employeemanagement.Repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val repository: EmployeeRepository
) : ViewModel() {

    suspend fun insertEmployee(employeeModel: EmployeeModel) {
        viewModelScope.launch {
            repository.insertEmployee(employeeModel)
        }
    }
}