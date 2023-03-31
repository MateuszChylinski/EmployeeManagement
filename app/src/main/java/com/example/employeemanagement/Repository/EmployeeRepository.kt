package com.example.employeemanagement.Repository

import com.example.employeemanagement.Model.EmployeeModel
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun insertEmployee(employeeModel: EmployeeModel)
    suspend fun deleteEmployee(id: Int)
    suspend fun updateEmployee(employeeModel: EmployeeModel)
    suspend fun deleteAllEmployees()
    fun getEmployeeById(id: Int): Flow<EmployeeModel?>
    fun getEmployees(): Flow<List<EmployeeModel>>
}