package com.example.employeemanagement.Repository

import com.example.employeemanagement.Model.EmployeeModel

interface EmployeeRepository {
    suspend fun insertEmployee(employeeModel: EmployeeModel)
    suspend fun deleteEmployee(employeeModel: EmployeeModel)
//    suspend fun deleteAllEmployees()
}