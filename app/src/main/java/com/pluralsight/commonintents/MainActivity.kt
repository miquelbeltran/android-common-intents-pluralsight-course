package com.pluralsight.commonintents

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.AlarmClock
import android.provider.MediaStore
import kotlinx.android.synthetic.main.layout_message_input.*
import kotlinx.android.synthetic.main.layout_user_feed.*
import java.io.File
import android.os.Environment.getExternalStorageDirectory
import android.util.Log
import android.view.View
import androidx.core.content.FileProvider
import com.google.android.gms.actions.NoteIntents
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonReminder.setOnClickListener {
            onButtonReminderClick()
        }

        buttonAttach.setOnClickListener {
            onButtonAttachClick()
        }

        imageViewAvatar.setOnClickListener {
            openProfile()
        }

        textViewName.setOnClickListener {
            openProfile()
        }

        buttonSave.setOnClickListener {
            saveMessageAsNote()
        }
    }

    private fun saveMessageAsNote() {
        todo("Save Message As Note")
    }

    private fun openProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun onButtonAttachClick() {
        todo("Attach Picture")
    }

    private fun onButtonReminderClick() {
        todo("Create Reminder")
    }
}
