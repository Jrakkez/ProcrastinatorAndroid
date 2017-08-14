package com.drakkun.procrastinator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.*

class NewTask : AppCompatActivity() {

    private val editName by lazy { find<EditText>(R.id.edit_name) }
    private val editDescription by lazy { find<EditText>(R.id.edit_description) }
    private val editDeadline by lazy { find<EditText>(R.id.edit_deadline) }
    private val btnCreate by lazy { find<Button>(R.id.btn_create) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewTaskUI().setContentView(this)
        setClickListeners()
    }

    override fun onResume() {
        super.onResume()
        title = "New Task"
    }

    private fun setClickListeners() {
        editDeadline.setOnClickListener { showDatePicker() }
        btnCreate.setOnClickListener { createNewTask() }
    }

    private fun createNewTask() {
        //some realm stuff
    }

    fun showDatePicker() {
        val editDate = find<EditText>(R.id.edit_deadline)
        //Ensure that we use the proper date in the date picker, whether creating or updating an item
        val (month, day, year) = editDate.text.trim().split("/")

        alert {
            customView {
                val picker = datePicker {
                    id = R.id.picker_deadline
                    updateDate(year.toInt(), month.toInt() - 1, day.toInt())
                }
                positiveButton("Okay") { dialog ->
                    val dateString = "${picker.month + 1}/${picker.dayOfMonth}/${picker.year}"
                    editDate.text = SpannableStringBuilder(dateString)
                    dialog.dismiss()
                }
                negativeButton("Cancel") { dialog -> dialog.dismiss()  }
            }
        }.show()
    }
}

private class NewTaskUI : AnkoComponent<NewTask> {

    override fun createView(ui: AnkoContext<NewTask>) = with(ui) {
        verticalLayout {
            topPadding = dip(16)
            editText {
                id = R.id.edit_name
                hint = "Task"
            }.lparams {
                width = matchParent
                horizontalMargin = dip(8)
            }
            editText {
                id = R.id.edit_description
                hint = "Description"
            }.lparams {
                width = matchParent
                horizontalMargin = dip(8)
            }
            editText {
                id = R.id.edit_deadline
                madeEditableDate()
            }.lparams {
                width = matchParent
                horizontalMargin = dip(8)
            }
            button {
                id = R.id.btn_create
                hint = "Create"
            }
        }
    }
}