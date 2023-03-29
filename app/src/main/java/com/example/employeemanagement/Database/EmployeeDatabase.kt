package com.example.employeemanagement.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.employeemanagement.DAO.EmployeeDAO
import com.example.employeemanagement.Model.EmployeeModel

@Database(version = 1, entities = [EmployeeModel::class])
abstract class EmployeeDatabase: RoomDatabase() {
    abstract fun getDAO(): EmployeeDAO
}