package com.example.employeemanagement.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.employeemanagement.R
import com.example.employeemanagement.databinding.FragmentAddEmployeeBinding
import com.example.employeemanagement.databinding.FragmentManageEmployeesBinding


class AddEmployee : Fragment() {

    private var _binding: FragmentAddEmployeeBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEmployeeBinding.inflate(inflater, container, false)
        val view = mBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.addNewEmployee.setOnClickListener {
            findNavController().navigate(AddEmployeeDirections.goToManageEmployees())
        }
    }
}