package com.example.employeemanagement.UI

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.employeemanagement.Adapter.EmployeeAdapter
import com.example.employeemanagement.Database.DatabaseState
import com.example.employeemanagement.Model.EmployeeModel
import com.example.employeemanagement.ViewModel.EmployeeViewModel
import com.example.employeemanagement.databinding.FragmentManageEmployeesBinding
import kotlinx.coroutines.launch
import javax.inject.Inject

class ManageEmployees : Fragment() {
    private var _binding: FragmentManageEmployeesBinding? = null
    private val mBinding get() = _binding!!
    private val mViewModel: EmployeeViewModel by activityViewModels()

    @Inject
    lateinit var mAdapter: EmployeeAdapter
    private var employeeData: MutableList<EmployeeModel> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentManageEmployeesBinding.inflate(inflater, container, false)
        val view = mBinding.root

        mBinding.manageRv.layoutManager = LinearLayoutManager(this.requireContext())
        mAdapter = EmployeeAdapter { employeeModel ->
            mViewModel.employeeIdFlow.value = employeeModel.id
            findNavController().navigate(ManageEmployeesDirections.goToUpdateEmployee())
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                mViewModel.allEmployees.collect { employee ->
                    when (employee) {
                        is DatabaseState.Success -> {
                            employeeData.clear()
                            employee.data?.forEach {
                                employeeData.add(it)
                            }
                            mAdapter.employees = employeeData
                            mBinding.manageRv.adapter = mAdapter
                            mAdapter.notifyDataSetChanged()
                        }
                        is DatabaseState.Error -> {
                            Log.i(
                                TAG,
                                "onCreateView: Error occurred in ManageEmployees fragment while trying to retrieve data from the ViewModel"
                            )
                        }
                    }
                }
            }
        }

        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val id: Int = mAdapter.employees[viewHolder.absoluteAdapterPosition].id
                mViewModel.deleteEmployee(id)
                mAdapter.notifyDataSetChanged()
            }

        }).attachToRecyclerView(mBinding.manageRv)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.manageAddEmployee.setOnClickListener {
            findNavController().navigate(ManageEmployeesDirections.goToAddEmployee())
        }
        mBinding.manageDeleteAll.setOnClickListener {
            mViewModel.deleteAllEmployees()
        }
    }
}