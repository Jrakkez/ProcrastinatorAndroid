package com.drakkun.procrastinator

import android.text.SpannableStringBuilder
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Samantha on 8/13/2017.
 */

const val DATE_FORMAT_US_COMMON = "MM/dd/yyyy"

fun EditText.madeEditableDate() {
    val date = Date()
    val formatter = SimpleDateFormat(DATE_FORMAT_US_COMMON, Locale.getDefault())
    val dateString = formatter.format(date)

    this.text = SpannableStringBuilder(dateString)
}