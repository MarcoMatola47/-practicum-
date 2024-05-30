package com.example.mypraticumtry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity2 : AppCompatActivity() {

    private lateinit var eDate:EditText
    private lateinit var eMorning:EditText
    private lateinit var eAfternoon:EditText
    private lateinit var eNotes:EditText
    private lateinit var NextButton:Button
    private lateinit var CleanButton:Button
    private lateinit var SaveButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        eDate = findViewById(R.id.eDate)
        eMorning = findViewById(R.id.eMorning)
        eAfternoon = findViewById(R.id.eAfternoon)
        eNotes = findViewById(R.id.eNotes)
        NextButton = findViewById(R.id.NextButton)
        CleanButton = findViewById(R.id.CleanButton)
        SaveButton = findViewById(R.id.SaveButton)


        val dateArray = arrayOfNulls<String>(7)
        val timeArrayMorning = arrayOfNulls<String>(7)
        val timeArrayAfternoon = arrayOfNulls<String>(7)
        val notesArray = arrayOfNulls<String>(7)

        CleanButton.setOnClickListener {
            eDate.setText("")
            eMorning.setText("")
            eAfternoon.setText("")
            eNotes.setText("")
        }
        SaveButton.setOnClickListener {
            dateArray[0] = eDate.text.toString()
            timeArrayMorning[0] = eMorning.text.toString()
            timeArrayAfternoon[0] = eAfternoon.text.toString()
            notesArray[0] = eNotes.text.toString()
        }

        NextButton.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java).apply {
                putExtra("dateArray",dateArray)
                putExtra("timeArrayMorning", timeArrayMorning)
                putExtra("timeArrayAfternoon",timeArrayAfternoon)
                putExtra("notesArray",notesArray)
            }

            startActivity(intent)
        }

        
        }
    }