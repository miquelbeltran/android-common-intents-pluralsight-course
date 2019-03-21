package com.pluralsight.noteintentfilter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.actions.NoteIntents
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action = intent.action
        val type = intent.type

        if (action == NoteIntents.ACTION_CREATE_NOTE && type == "text/plain") {
            textView.text = intent.getStringExtra(NoteIntents.EXTRA_TEXT)
        }
    }
}
