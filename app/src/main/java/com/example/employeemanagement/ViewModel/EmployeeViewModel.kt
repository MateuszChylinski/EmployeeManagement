package com.example.employeemanagement.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeemanagement.Database.DatabaseState
import com.example.employeemanagement.Model.EmployeeModel
import com.example.employeemanagement.Repository.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EmployeeViewModel @Inject constructor(
    private val repository: dagger.Lazy<EmployeeRepository>
) : ViewModel() {

    //    WHY STATE FLOW?
    val employeeIdFlow = MutableStateFlow(-1)


    val allEmployees: SharedFlow<DatabaseState<List<EmployeeModel>>> =
        repository.get().getEmployees()
            .catch { DatabaseState.Error(it.message) }
            .map { DatabaseState.Success(it) }
            .shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 0)

    val employeeById: SharedFlow<DatabaseState<EmployeeModel?>> = employeeIdFlow.filterNotNull().flatMapLatest {
        repository.get().getEmployeeById(it.toInt())
    }
        .catch { DatabaseState.Error(it.message) }
        .map { DatabaseState.Success(it) }
        .shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)

//    val employeeById: SharedFlow<DatabaseState<EmployeeModel?>> =
//        repository.get().getEmployeeById(someFlow.value)
//            .catch {
//                println("onCreateView VM ERROR ${it.message}")
//                DatabaseState.Error(it.message)
//            }
//            .map {
//                println("onCreateView in VM. ID ${employeeId.value}  |  data: ${it}")
//                DatabaseState.Success(it)
//            }
//
//            .shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)


    fun insertNewEmployee(employeeModel: EmployeeModel) {
        viewModelScope.launch {
            repository.get().insertEmployee(employeeModel)
        }
    }

    fun updateEmployee(employeeModel: EmployeeModel) {
        viewModelScope.launch {
            repository.get().updateEmployee(employeeModel)
        }
    }

    fun deleteEmployee(id: Int) {
        viewModelScope.launch {
            repository.get().deleteEmployee(id)
        }
    }

    fun deleteAllEmployees() {
        viewModelScope.launch {
            repository.get().deleteAllEmployees()
        }
    }
}


