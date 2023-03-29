package com.example.employeemanagement.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.employeemanagement.R
import com.example.employeemanagement.databinding.FragmentManageEmployeesBinding

class ManageEmployees : Fragment() {
    private var _binding: FragmentManageEmployeesBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManageEmployeesBinding.inflate(inflater, container, false)
        val view = mBinding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.manageAddEmployee.setOnClickListener {
            findNavController().navigate(ManageEmployeesDirections.goToAddEmployee())
        }
    }
}