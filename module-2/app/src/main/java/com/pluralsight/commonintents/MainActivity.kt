package com.pluralsight.commonintents

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_message_input.*
import kotlinx.android.synthetic.main.layout_user_feed.*


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
