package com.example.orwma_lv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orwma_lv2.adapters.StudentRecyclerAdapter
import com.example.orwma_lv2.models.Student


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private var adapter = StudentRecyclerAdapter()
    private var studentList = mutableListOf<Student>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buAddStudent : Button = findViewById(R.id.buAdd)
        var etStudent : EditText = findViewById(R.id.etStudent)

        adapter = StudentRecyclerAdapter(studentList)
        setUpRecycler()

        buAddStudent.setOnClickListener {
            studentList.add(Student(etStudent.text.toString()))
            adapter.notifyDataSetChanged()
        }

    }

    private fun setUpRecycler(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}