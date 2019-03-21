package com.pluralsight.commonintents

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.actions.NoteIntents
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
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
            putExtra(NoteIntents.EXTRA_NAME, "Message Subject")
            putExtra(NoteIntents.EXTRA_TEXT, "Message Text")
            type = "text/plain"
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openProfile() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }

    private fun onButtonAttachClick() {
        todo("Attach Picture")
    }

    private fun onButtonReminderClick() {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "Write Post")
            putExtra(AlarmClock.EXTRA_HOUR, 17)
            putExtra(AlarmClock.EXTRA_MINUTES, 0)
            putExtra(AlarmClock.EXTRA_DAYS, arrayListOf(
                java.util.Calendar.SUNDAY,
                java.util.Calendar.MONDAY,
                java.util.Calendar.TUESDAY,
                java.util.Calendar.WEDNESDAY,
                java.util.Calendar.THURSDAY,
                java.util.Calendar.FRIDAY,
                java.util.Calendar.SATURDAY
            ))
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}
