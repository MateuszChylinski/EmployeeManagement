package com.example.employeemanagement.Repository

import com.example.employeemanagement.DAO.EmployeeDAO
import com.example.employeemanagement.Model.EmployeeModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(
    private val employeeDAO: EmployeeDAO
) : EmployeeRepository {

    override suspend fun insertEmployee(employeeModel: EmployeeModel) {
        employeeDAO.addNewEmployee(employeeModel)
    }

    override suspend fun deleteEmployee(id: Int) {
        employeeDAO.deleteEmployee(id)
    }

    override suspend fun updateEmployee(employeeModel: EmployeeModel) {
        employeeDAO.updateEmployee(employeeModel)
    }

    override fun getEmployees(): Flow<List<EmployeeModel>> {
        return employeeDAO.getEmployees()
    }

    override fun getEmployeeById(id: Int): Flow<EmployeeModel?> {
        return employeeDAO.getEmployeeById(id)
    }

    override suspend fun deleteAllEmployees() {
        return employeeDAO.deleteAllEmployees()
    }
}