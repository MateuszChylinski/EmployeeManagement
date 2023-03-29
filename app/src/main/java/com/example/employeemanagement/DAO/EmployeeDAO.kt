package com.example.employeemanagement.DAO

import androidx.room.*
import com.example.employeemanagement.Model.EmployeeModel

@Dao
interface EmployeeDAO {
    @Insert
    suspend fun addNewEmployee(employeeModel: EmployeeModel)
    @Delete
    suspend fun deleteEmployee(employeeModel: EmployeeModel)
//    @Query("DELETE * from employees")
//    suspend fun deleteAllEmployees()
}