package com.drakkun.procrastinator

import android.support.design.widget.FloatingActionButton
import android.view.ViewGroup
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
        relativeLayout {
            textView {
                id = R.id.txt_name
            }
            textView {
                id = R.id.txt_description
            }
            textView {
                id = R.id.txt_deadline
            }
        }
    }
}