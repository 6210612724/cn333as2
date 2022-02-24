package com.example.notes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*


class SecondActivity : AppCompatActivity() {
    private lateinit var noteText: EditText
    private lateinit var noteTitle: EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        noteText = findViewById(R.id.noteText)
        noteTitle = findViewById(R.id.noteTitle)

        loadData()

    }

    override fun onBackPressed() {
        super.onBackPressed()

        saveData()


    }

    private fun saveData(){
        val insertText = noteText.text.toString()
        val insertTitle = noteTitle.text.toString()
                noteText.setText(insertText)
        noteTitle.setText(insertTitle)

        val sharedPreferences = getSharedPreferences("sharePrefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply(){
            putString("Title_KEY", insertTitle)
            putString("Text_KEY", insertText)
        }.apply()

        val toast = Toast.makeText(this@SecondActivity, "Saved", Toast.LENGTH_SHORT)
        toast.setGravity(24, 20, 150)

        toast.show()
    }

    private fun loadData(){

        val sharedPreferences = getSharedPreferences("sharePrefs",Context.MODE_PRIVATE)
        val saveTitle = sharedPreferences.getString("Title_KEY",null)
        val saveText = sharedPreferences.getString("Text_KEY",null)
        noteTitle.setText(saveTitle)
        noteText.setText(saveText)


    }

}



