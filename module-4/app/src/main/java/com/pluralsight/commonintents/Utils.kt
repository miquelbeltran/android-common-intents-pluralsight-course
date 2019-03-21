package com.pluralsight.commonintents

import android.app.Activity
import android.widget.Toast

fun Activity.todo(message: String) {
    val duration = Toast.LENGTH_SHORT
    Toast.makeText(applicationContext, message, duration).show()
}