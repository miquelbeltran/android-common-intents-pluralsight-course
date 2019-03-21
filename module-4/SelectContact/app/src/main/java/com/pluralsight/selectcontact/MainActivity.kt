package com.pluralsight.selectcontact

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button

const val REQUEST_SELECT_CONTACT = 1

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_CONTACT)
            }

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {

            val contactUri: Uri = data?.data ?: return

            val projection: Array<String> = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)

            contentResolver.query(contactUri, projection, null, null, null).use { cursor ->
                // If the cursor returned is valid, get the phone number
                if (cursor.moveToFirst()) {
                    val numberIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                    val number = cursor.getString(numberIndex)
                    // Do something with the phone number

                    Log.d("MainActivity", "Data1: $number")
                }
            }
        }
    }
}
