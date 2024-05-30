package com.example.mypraticumtry

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {

    private lateinit var displaytextView: TextView
    private lateinit var averagetextView: TextView
    private lateinit var Returnbutton:Button
    private lateinit var Displaybutton:Button
    private lateinit var Calculatebutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        displaytextView = findViewById(R.id.displaytextView)
        averagetextView = findViewById(R.id.averagetextView)
        Returnbutton = findViewById(R.id.Returbutton)
        Displaybutton = findViewById(R.id.Displaybutton)
        Calculatebutton = findViewById(R.id.Calculatebutton)



        Displaybutton.setOnClickListener {
            val dateArray = intent.getStringArrayExtra("dateArray")
            val timeArrayMorning = intent.getStringArrayExtra("timeArrayMorning")
            val timeArrayAfternoon = intent.getStringArrayExtra("timesArrayAfternoon")
            val notesArray = intent.getStringArrayExtra("noteArray")

            val details = StringBuilder()
            var totalScreenTime = 0.0
            for (int in dateArray?.indices ?: 0..0) {
                val morningTime = timeArrayMorning?.get(int)?.toDoubleOrNull() ?: 0.0
                val afternoonTime = timeArrayAfternoon?.get(int)?.toDoubleOrNull() ?: 0.0
                totalScreenTime += morningTime + afternoonTime

                details.append("Date: ${dateArray?.get(int)}\n")
                details.append("Morning Screen Time: $morningTime\n")
                details.append("Afternoon Screen Time: $afternoonTime\n")
                details.append("Notes: ${notesArray?.get(int)}\n\n")
            }


            displaytextView.text = details.toString()

            val averageScreenTime = totalScreenTime / (dateArray?.size ?: 1)
            averagetextView.text = "Average Screen Time: %.2f".format(averageScreenTime)


        }
        Returnbutton.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}