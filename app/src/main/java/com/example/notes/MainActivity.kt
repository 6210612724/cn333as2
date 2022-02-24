package com.example.notes

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var makeNote_bt : Button
    private lateinit var titleNote : TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeNote_bt = findViewById(R.id.makeNote_bt)
        titleNote = findViewById(R.id.titleNote)


        loadData()
        maKeNote()



    }

    private fun maKeNote(){
        makeNote_bt.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loadData(){
        val sharedPreferences = getSharedPreferences("sharePrefs", Context.MODE_PRIVATE)
        val saveString = sharedPreferences.getString("Title_KEY",null)


    }

}

