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
        val text = textViewMessage.text.toString()
        // Requires the basement library
        val intent = Intent(NoteIntents.ACTION_CREATE_NOTE).apply {
            putExtra(NoteIntents.EXTRA_NAME, "Message")
            putExtra(NoteIntents.EXTRA_TEXT, text)
//            setDataAndType(data, type)

            // This is missing on the official documentation!!
            type = "text/plain"
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun openProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    private val REQUEST_IMAGE_CAPTURE = 1
    private var uriSavedImage: Uri? = null
    private var currentPhotoPath: String = ""


    // Method to generate the file name, from
    // https://developer.android.com/training/camera/photobasics
    @SuppressLint("SimpleDateFormat")
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

    private fun onButtonAttachClick() {
        // Save the saved image URI
        // Need to add File provider to the Android Manifest
        uriSavedImage = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".provider", createImageFile())
        Log.i("MainActivity", "Storing image in $uriSavedImage")

        // Call to the Camera Intent
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE).apply {
            putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage)

            // No need for file write permissions! we are in the external app folder
            flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            // Our picture is stored in the imagesFolder
            // Accessible with the file browser on Android
            Log.i("MainActivity", "Image located in $uriSavedImage")
            // Load the stored picture
            // Image appears rotated
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, uriSavedImage)

            imageViewAttachmentPreview.visibility = View.VISIBLE
            imageViewAttachmentPreview.setImageBitmap(bitmap)
        } else {
            Log.e("MainActivity", "Result Code: $resultCode")
        }
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
