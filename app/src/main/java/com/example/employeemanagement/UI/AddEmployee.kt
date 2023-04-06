package com.example.employeemanagement.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.employeemanagement.Model.EmployeeModel
import com.example.employeemanagement.ViewModel.EmployeeViewModel
import com.example.employeemanagement.databinding.FragmentAddEmployeeBinding
import kotlinx.coroutines.launch

class AddEmployee : Fragment() {

    private var _binding: FragmentAddEmployeeBinding? = null
    private val mBinding get() = _binding!!
    private val mViewModel: EmployeeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEmployeeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.addNewEmployee.setOnClickListener {
            addEmployee()
        }
    }

    private fun addEmployee() {
        viewLifecycleOwner.lifecycleScope.launch {
            if (mBinding.addEmployeeName.text.isEmpty() || mBinding.addEmployeeSurname.text.isEmpty() || mBinding.addEmployeeAge.text.toString()
                    .isEmpty() || mBinding.addEmployeeWorkplace.text.isEmpty() || mBinding.addEmployeeSalary.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(requireContext(), "Complete the data", Toast.LENGTH_SHORT).show()
            } else {
                mViewModel.insertNewEmployee(
                    EmployeeModel(
                        0,
                        name = mBinding.addEmployeeName.text.toString(),
                        surname = mBinding.addEmployeeSurname.text.toString(),
                        age = mBinding.addEmployeeAge.text.toString().toInt(),
                        workplace = mBinding.addEmployeeWorkplace.text.toString(),
                        salary = mBinding.addEmployeeSalary.text.toString().toDouble()
                    )
                )
                findNavController().navigate(AddEmployeeDirections.returnToManageEmployeesFromAddEmployee())
            }
        }
    }
}