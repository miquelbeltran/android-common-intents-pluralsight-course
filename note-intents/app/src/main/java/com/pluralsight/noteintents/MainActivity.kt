package com.pluralsight.noteintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.actions.NoteIntents
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action = intent.action
        val type = intent.type

        if (NoteIntents.ACTION_CREATE_NOTE == action && type != null) {
            if ("text/plain" == type) {
                val savedNote = intent.getStringExtra(NoteIntents.EXTRA_TEXT)
                textView.text = savedNote
            }
        }

    }
}
