package com.example.orwma_lv2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orwma_lv2.R
import com.example.orwma_lv2.models.Student

class StudentRecyclerAdapter(private val studentList:MutableList<Student> = mutableListOf()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = (
            ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.student_sample, parent, false))
            )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).onBind(studentList[position])
    }

    override fun getItemCount(): Int = (studentList.size)


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var tvName: TextView = itemView.findViewById(R.id.tvName)
        var buDelete: Button = itemView.findViewById(R.id.buDelete)

        fun onBind(student: Student) {
            tvName.text = student.name
            buDelete.setOnClickListener {
                if (studentList.isNotEmpty()) {
                    studentList.remove(student)
                    notifyDataSetChanged()
                }
            }
        }

    }
}


