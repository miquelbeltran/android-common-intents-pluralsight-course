package com.pluralsight.commonintents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        buttonCalendar.setOnClickListener {
            onClickCalendar()
        }

        buttonMaps.setOnClickListener {
            onClickMaps()
        }

        buttonTaxi.setOnClickListener {
            onClickTaxi()
        }

        buttonSearch.setOnClickListener {
            omClickSearch()
        }

        buttonListen.setOnClickListener {
            onClickListen()
        }

        buttonWebsite.setOnClickListener {
            onClickWeb()
        }

        buttonCall.setOnClickListener {
            onClickCall()
        }

        buttonEmail.setOnClickListener {
            onClickEmail()
        }

        buttonContact.setOnClickListener {
            onClickContact()
        }
    }

    private fun onClickContact() {
        todo("Save as Contact")
    }

    private fun onClickEmail() {
        todo("Send Email")
    }

    private fun onClickCall() {
        todo("Call Friend")
    }

    private fun onClickWeb() {
        todo("Open Website")
    }

    private fun onClickListen() {
        todo("Play Music")
    }

    private fun omClickSearch() {
        todo("Search Hobbies")
    }

    private fun onClickTaxi() {
        todo("Call a Taxi")
    }

    private fun onClickMaps() {
        todo("View Location")
    }

    private fun onClickCalendar() {
        todo("Save Birthday")
    }
}
