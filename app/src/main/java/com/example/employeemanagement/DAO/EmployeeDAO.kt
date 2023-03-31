package com.example.employeemanagement.DAO

import androidx.room.*
import com.example.employeemanagement.Model.EmployeeModel
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewEmployee(employeeModel: EmployeeModel)
    @Query("DELETE FROM employees WHERE id = :id")
    suspend fun deleteEmployee(id: Int)
    @Update
    suspend fun updateEmployee(employeeModel: EmployeeModel)

    @Query("SELECT * FROM employees")
    fun getEmployees(): Flow<List<EmployeeModel>>

    @Query("SELECT * FROM employees WHERE id = :id")
    fun getEmployeeById(id: Int): Flow<EmployeeModel?>

    @Query("DELETE  FROM employees")
    suspend fun deleteAllEmployees()
}