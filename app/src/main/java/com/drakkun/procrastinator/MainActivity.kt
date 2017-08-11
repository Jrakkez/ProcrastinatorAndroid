package com.drakkun.procrastinator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val recycler by lazy { find<RecyclerView>(R.id.recycler_tasks) }
    private val taskList: ArrayList<Task> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        initRecyclerView()
        setupFab()
    }

    override fun onResume() {
        super.onResume()
        updateUI()
    }

    private fun initRecyclerView() {
        recycler.adapter = Adapter(taskList)
        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun updateUI() {
        recycler.adapter.notifyDataSetChanged()
    }

    private fun setupFab() {
        val fab = find<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { startActivityForResult<NewTask>(9998) }
    }

    inner class Holder(val taskView: View) : RecyclerView.ViewHolder(taskView)

    inner class Adapter(val taskList: ArrayList<Task>) : RecyclerView.Adapter<Holder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val ankoContext = AnkoContext.create(this@MainActivity, parent)
            val component = TaskUI()

            return Holder(component.createView(ankoContext))
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            val task = taskList[position]
            val taskView = holder.taskView
            val txtName = taskView.find<TextView>(R.id.txt_name)
            val txtDescription = taskView.find<TextView>(R.id.txt_description)
            val txtDeadline = taskView.find<TextView>(R.id.txt_deadline)

            txtName.text = task.taskName
            txtDescription.text = task.description
            txtDeadline.text = task.deadline
        }

        override fun getItemCount(): Int = taskList.size
    }
}