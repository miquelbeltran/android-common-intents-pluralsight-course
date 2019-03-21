package com.pluralsight.playfiles

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val mp3 = Uri.parse("https://file-examples.com/wp-content/uploads/2017/11/file_example_MP3_700KB.mp3")
            val intent = Intent(Intent.ACTION_VIEW).apply {
                type = "audio/mpeg3"
                data = mp3
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }



    }
}
