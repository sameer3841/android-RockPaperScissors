package com.saunakpatel.rockpaperscissors

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class MainActivity : AppCompatActivity() {

    lateinit var cpuHand : ImageView;
    lateinit var humanHand : ImageView;
    lateinit var choiceRock : ImageButton;
    lateinit var choicePaper : ImageButton;
    lateinit var choiceScissors : ImageButton;
    lateinit var roundNum : TextView;
    lateinit var cpuScore : TextView;
    lateinit var humanScore : TextView;
    lateinit var reset : Button;

    private var roundCnt = 0;
    private var scoreCPU = 0;
    private var scoreHuman = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cpuHand = findViewById<ImageView>(R.id.cpuHand)



        }
    }
