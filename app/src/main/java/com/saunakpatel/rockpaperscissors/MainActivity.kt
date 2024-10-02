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
import kotlin.random.Random



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
    private var cpuChoice = 0;
    private var humanChoice = 0;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cpuHand = findViewById<ImageView>(R.id.cpuHand)
        humanHand = findViewById<ImageView>(R.id.humanHand)

        roundNum = findViewById<TextView>(R.id.roundNum)
        cpuScore = findViewById<TextView>(R.id.cpuScore)
        humanScore = findViewById<TextView>(R.id.humanScore)
        reset = findViewById<Button>(R.id.reset)

        choiceRock = findViewById<ImageButton>(R.id.choiceRock)
        choicePaper = findViewById<ImageButton>(R.id.choicePaper)
        choiceScissors = findViewById<ImageButton>(R.id.choiceScissors)

        humanHand.setImageResource(R.drawable.rps_blank)
        cpuHand.setImageResource(R.drawable.rps_blank)

        choiceRock.setOnClickListener{_ ->
            humanChoice = 0;
            play(humanChoice)
        }

        choicePaper.setOnClickListener{_ ->
            humanChoice = 1;
            play(humanChoice)
        }

        choiceScissors.setOnClickListener{_ ->
            humanChoice = 2;
            play(humanChoice)
        }

        reset.setOnClickListener{_ ->
            reset()
        }

    }

    private fun play(choice: Int){

        when (choice) {
            0 -> humanHand.setImageResource(R.drawable.rps_rock)
            1 -> humanHand.setImageResource(R.drawable.rps_paper)
            else -> humanHand.setImageResource(R.drawable.rps_scissors)
        }

        val random = Random.nextInt(3)

        when (random) {
            0 -> cpuHand.setImageResource(R.drawable.rps_rock)
            1 -> cpuHand.setImageResource(R.drawable.rps_paper)
            else -> cpuHand.setImageResource(R.drawable.rps_scissors)
        }

        helper(choice, random)

        if (roundCnt == 20) reset()
    }

    private fun reset(){
        roundNum.text = "0"
        cpuScore.text = "0"
        humanScore.text = "0"

        humanHand.setImageResource(R.drawable.rps_blank)
        cpuHand.setImageResource(R.drawable.rps_blank)

        roundCnt = 0
        scoreCPU = 0
        scoreHuman = 0

    }

    private fun helper(choice: Int, random: Int){
        if(choice == random) roundCnt += 1
        else if(choice == 1 && random == 0 || choice == 0 && random == 2 || choice == 2 && random == 1){
            roundCnt += 1
            scoreHuman += 1
        } else {
            roundCnt += 1
            scoreCPU += 1
        }
        cpuScore.text = "" + scoreCPU
        humanScore.text = "" + scoreHuman
        roundNum.text = "" + roundCnt
    }

}
