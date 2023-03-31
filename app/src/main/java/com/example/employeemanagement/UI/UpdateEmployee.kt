package com.example.employeemanagement.UI

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.employeemanagement.Database.DatabaseState
import com.example.employeemanagement.Model.EmployeeModel
import com.example.employeemanagement.ViewModel.EmployeeViewModel
import com.example.employeemanagement.databinding.FragmentUpdateEmployeeBinding
import kotlinx.coroutines.launch

class UpdateEmployee : Fragment() {

    private var _binding: FragmentUpdateEmployeeBinding? = null
    private val mBinding get() = _binding!!
    private val mViewModel: EmployeeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUpdateEmployeeBinding.inflate(inflater, container, false)

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
               mViewModel.employeeById.collect{ employee ->
                   when (employee){
                       is DatabaseState.Success -> {
                           mBinding.updateEmployeeName.setText(employee.data?.name)
                           mBinding.updateEmployeeSurname.setText(employee.data?.surname)
                           mBinding.updateEmployeeAge.setText(employee.data?.age?.toString())
                           mBinding.updateEmployeeWorkplace.setText(employee.data?.workplace)
                           mBinding.updateEmployeeSalary.setText(employee.data?.salary?.toString())
                       }
                       is DatabaseState.Error -> {
                           Log.i(TAG, "onCreateView: Failed to retrieve data about employee in UpdateFragmentEmployee fragment")}
                   }
               }
            }
        }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.updateEmployeeFinish.setOnClickListener {
            updateEmployee()
        }
    }

    private fun updateEmployee() {
        viewLifecycleOwner.lifecycleScope.launch {
            if (mBinding.updateEmployeeName.text.isEmpty() || mBinding.updateEmployeeSurname.text.isEmpty() || mBinding.updateEmployeeAge.text.toString()
                    .isEmpty() || mBinding.updateEmployeeWorkplace.text.isEmpty() || mBinding.updateEmployeeSalary.text.toString()
                    .isEmpty()
            ) {
                Toast.makeText(requireContext(), "Complete the data", Toast.LENGTH_SHORT).show()
            } else {
                Log.i(TAG, "onCreateView updateEmployee: NO 1")
                if (mViewModel.employeeIdFlow.value > 0) {
                    mViewModel.updateEmployee(
                        EmployeeModel(
                            mViewModel.employeeIdFlow.value,
                            name = mBinding.updateEmployeeName.text.toString(),
                            surname = mBinding.updateEmployeeSurname.text.toString(),
                            age = mBinding.updateEmployeeAge.text.toString().toInt(),
                            workplace = mBinding.updateEmployeeWorkplace.text.toString(),
                            salary = mBinding.updateEmployeeSalary.text.toString().toDouble()
                        )
                    )
                    Log.i(TAG, "onCreateView updateEmployee: NO 2 ")
                    findNavController().navigate(UpdateEmployeeDirections.returnToManageEmployeesFromUpdate())
                }else{
                    Toast.makeText(requireContext(), "Wrong employee ID", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }
}