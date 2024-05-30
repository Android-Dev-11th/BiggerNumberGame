package com.example.biggernumbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //declare vars
    lateinit var left: Button
    lateinit var right: Button
    lateinit var score: TextView
    var points = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wire
        left = findViewById(R.id.button_maim_left)
        right = findViewById(R.id.button_main_right)
        score = findViewById(R.id.text_main_score)

        //inital vals
        set()

        //set listeners
        left.setOnClickListener { onClick(left) }
        right.setOnClickListener { onClick(right) }



    }

    //compare + update + reset
    fun onClick(curr: Button){
        if(curr.text.toString().toInt() > left.text.toString().toInt() || curr.text.toString().toInt() > right.text.toString().toInt()) {
            points++
        }
        set()
    }

    //update + reset
    fun set(){
        left.text = num().toString()
        right.text = num().toString()
        score.text = "Correct: $points"
    }

    //random val
    fun num(): Int{
        return ((0..255).random())
    }
}

