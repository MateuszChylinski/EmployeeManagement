package com.example.employeemanagement.Repository

import com.example.employeemanagement.DAO.EmployeeDAO
import com.example.employeemanagement.Model.EmployeeModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val employeeDAO: EmployeeDAO): EmployeeRepository {


    override suspend fun insertEmployee(employeeModel: EmployeeModel) {
        employeeDAO.addNewEmployee(employeeModel)
    }

    override suspend fun deleteEmployee(employeeModel: EmployeeModel) {
        employeeDAO.deleteEmployee(employeeModel)
    }

//    override suspend fun deleteAllEmployees() {
//        employeeDAO.deleteAllEmployees()
//    }
}