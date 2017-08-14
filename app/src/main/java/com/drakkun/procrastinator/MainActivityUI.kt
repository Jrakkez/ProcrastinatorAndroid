package com.drakkun.procrastinator

import android.graphics.Typeface
import android.support.design.widget.FloatingActionButton
import android.view.ViewGroup
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by Samantha on 8/9/2017.
 */
class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            recyclerView {
                id = R.id.recycler_tasks
            }.lparams {
                topMargin = dip(16)
            }
            include<FloatingActionButton>(R.layout.fab)
        }
    }
}

class TaskUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            textView {
                id = R.id.txt_name
                textSize = 18f
                typeface = Typeface.DEFAULT_BOLD
            }.lparams {
                horizontalMargin = dip(16)
            }
            textView {
                id = R.id.txt_description
                textSize = 18f
            }.lparams {
                horizontalMargin = dip(16)
            }
            textView {
                id = R.id.txt_deadline
                textSize = 18f
            }.lparams {
                horizontalMargin = dip(16)
            }
        }
    }
}