package com.drakkun.procrastinator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.*

class NewTask : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewTaskUI().setContentView(this)
    }
}

private class NewTaskUI : AnkoComponent<NewTask> {

    fun showDatePicker(ctx: NewTask) {
        ctx.alert {
            customView {
                datePicker {
                    id = R.id.picker_deadline
                }
            }
            positiveButton("Okay") { dialog -> dialog.dismiss() }
            negativeButton("Cancel") { dialog -> dialog.dismiss() }
        }.show()
    }

    override fun createView(ui: AnkoContext<NewTask>) = with(ui) {
        verticalLayout {
            editText {
                id = R.id.edit_name
                hint = "Task"
            }
            editText {
                id = R.id.edit_description
                hint = "Description"
            }
            editText {
                id = R.id.edit_deadline
                hint = "Deadline"
                setOnClickListener { showDatePicker(ui.owner) }
            }
        }
    }
}