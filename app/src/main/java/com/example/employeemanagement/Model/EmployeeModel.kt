package com.example.employeemanagement.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")
data class EmployeeModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "surname")
    val surname: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "workplace")
    val workplace: String,
    @ColumnInfo(name = "salary")
    val salary: Double
)
