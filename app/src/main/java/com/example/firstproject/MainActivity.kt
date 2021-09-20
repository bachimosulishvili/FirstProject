package com.example.firstproject

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.Array

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        val numberInput = R.id.numberInput
        val button = findViewById<Button>(R.id.button)
        var numberTextView = findViewById<TextView>(R.id.numberTextView)

        val numberInputReversed = numberInput.toString().reversed().toInt()
        val arrayOfNumber = arrayOf(numberInputReversed.toString().split(""))

        button.setOnClickListener() {
            val units = arrayOfNumber[0][1].toInt()
            val tens = arrayOfNumber[0][2].toInt()
            val hundreds = arrayOfNumber[0][3].toInt()

            val twentys =
                if (units == 0 && tens == 2) {"ოცი"}
                else if(units == 0 && tens == 4){"ორმოცი"}
                else if(units == 0 && tens == 6){"სამოცი"}
                else if(units == 0 && tens == 8){"ოთხმოცი"}
                else{""}

            val unitsText = when (units){
                1 -> "ერთი"
                2 -> "ორი"
                3 -> "სამი"
                4 -> "ოთხი"
                5 -> "ხუთი"
                6 -> "ექვსი"
                7 -> "შვიდი"
                8 -> "რვა"
                9 -> "ცხრა"
                else -> ""
            }

            val tensText = when (tens){
                2 -> "ოცდა"
                3 -> "ოცდა"
                4 -> "ორმოცდა"
                5 -> "ორმოცდა"
                6 -> "სამოცდა"
                7 -> "სამოცდა"
                8 -> "ოთხმოცდა"
                9 -> "ოთხმოცდა"
                else -> ""
            }

            val hundredsText = when (hundreds){
                1 -> "ას"
                2 -> "ორას"
                3 -> "სამას"
                4 -> "ოთხას"
                5 -> "ხუთას"
                6 -> "ექვსას"
                7 -> "შვიდას"
                8 -> "რვაას"
                9 -> "ცხრაას"
                else -> ""
            }


            var answer =
                if (hundreds != 0 && tens == 0 && units == 0){hundredsText+"ი"}
                else if (hundreds != 0 && tens != 0 && units == 0){hundredsText+twentys}
                else if (hundreds != 0 && tens != 0 && units != 0){hundredsText+tensText+unitsText}
                else{"Error"}

            numberTextView.text = answer
        }
    }

}
