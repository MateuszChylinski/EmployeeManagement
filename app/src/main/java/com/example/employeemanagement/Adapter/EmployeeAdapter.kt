package com.example.employeemanagement.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.employeemanagement.Model.EmployeeModel
import com.example.employeemanagement.databinding.EmployeeRowBinding
import javax.inject.Inject

class EmployeeAdapter @Inject constructor(private val onItemClicked: (EmployeeModel) -> Unit) :
    RecyclerView.Adapter<EmployeeAdapter.EmployeeVH>(){
    var employees: MutableList<EmployeeModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeVH {
        val view = EmployeeRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeVH(view)
    }

    override fun onBindViewHolder(holder: EmployeeVH, position: Int) {
        with(holder) {
            binding.employeeRowName.text = employees[position].name
            binding.employeeRowSurname.text = employees[position].surname
            binding.employeeRowAge.text = employees[position].age.toString()
            binding.employeeRowWorkplace.text = employees[position].workplace
            binding.employeeRowSalary.text = employees[position].salary.toString()

            binding.root.setOnClickListener {
                onItemClicked(employees[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }
    inner class EmployeeVH(val binding: EmployeeRowBinding) : RecyclerView.ViewHolder(binding.root)
}