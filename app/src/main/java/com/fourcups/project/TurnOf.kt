package com.fourcups.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_add_question.*
import kotlinx.android.synthetic.main.activity_turn_of.*
import kotlinx.android.synthetic.main.activity_turn_of.back

var curAct =""

class TurnOf : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turn_of)

        back.setOnClickListener{
            val intent = Intent(this,Players::class.java)
            startActivity(intent)
        }
        playerName.setText(players[curPlayer].toString())

        dare.setOnClickListener {
            curAct = "dare"

            val servIntent = Intent(this,ConnectionService::class.java)
            servIntent.putExtra("action", "next_dare")
            startService(servIntent)

            val intent = Intent(this,WaitContent::class.java)
            startActivity(intent)
        }
        truth.setOnClickListener {
            curAct = "truth"

            val servIntent = Intent(this,ConnectionService::class.java)
            servIntent.putExtra("action", "next_truth")
            startService(servIntent)


            val intent = Intent(this,WaitContent::class.java)
            startActivity(intent)
        }
    }
}
