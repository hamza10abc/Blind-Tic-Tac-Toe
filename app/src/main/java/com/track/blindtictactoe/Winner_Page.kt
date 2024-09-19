package com.track.blindtictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Winner_Page : AppCompatActivity() {
    private lateinit var winner : TextView
    private lateinit var play_again_btn : Button
    private lateinit var img0 : ImageView
    private lateinit var img1 : ImageView
    private lateinit var img2 : ImageView
    private lateinit var img3 : ImageView
    private lateinit var img4 : ImageView
    private lateinit var img5 : ImageView
    private lateinit var img6 : ImageView
    private lateinit var img7 : ImageView
    private lateinit var img8 : ImageView
    var F_Arr1 = arrayOf(0,0,0,0,0,0,0,0,0)
    var F_Arr = ArrayList(F_Arr1.toList())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_winner_page)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets


        winner = findViewById(R.id.winner)
        play_again_btn = findViewById(R.id.play_again)
        img0 = findViewById(R.id.img0)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        img5 = findViewById(R.id.img5)
        img6 = findViewById(R.id.img6)
        img7 = findViewById(R.id.img7)
        img8 = findViewById(R.id.img8)

        val win = intent.getStringExtra("res")
        F_Arr = intent.getIntegerArrayListExtra("F_Arr")!!
        blanker()
        o_box_fillup()
        x_box_fillup()
        println("test data below")
//        if (F_Arr != null) {
//            println(F_Arr.joinToString())
//        }else{
//            println("Its null")
//        }
        println(F_Arr?.joinToString())

        winner.setText("$win WON")

        if (win == "T")
        {
            winner.setText("IT'S A DRAW")
        }
        else if (win == "X")
        {
            winner.setText("X IS THE WINNER")
        }
        else if (win == "O")
        {
            winner.setText("O IS THE WINNER")
        }

        play_again_btn.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


//        }
    }

    private fun o_box_fillup() {
        for (i in F_Arr.indices) {
            if (F_Arr[i] < 0) {
                when (i) {
                    0 -> img0.setImageResource(R.drawable.o)
                    1 -> img1.setImageResource(R.drawable.o)
                    2 -> img2.setImageResource(R.drawable.o)
                    3 -> img3.setImageResource(R.drawable.o)
                    4 -> img4.setImageResource(R.drawable.o)
                    5 -> img5.setImageResource(R.drawable.o)
                    6 -> img6.setImageResource(R.drawable.o)
                    7 -> img7.setImageResource(R.drawable.o)
                    8 -> img8.setImageResource(R.drawable.o)
                }
            }
        }
    }

    private fun x_box_fillup() {
        for (i in F_Arr.indices) {
            if (F_Arr[i] > 0) {
                when (i) {
                    0 -> img0.setImageResource(R.drawable.x)
                    1 -> img1.setImageResource(R.drawable.x)
                    2 -> img2.setImageResource(R.drawable.x)
                    3 -> img3.setImageResource(R.drawable.x)
                    4 -> img4.setImageResource(R.drawable.x)
                    5 -> img5.setImageResource(R.drawable.x)
                    6 -> img6.setImageResource(R.drawable.x)
                    7 -> img7.setImageResource(R.drawable.x)
                    8 -> img8.setImageResource(R.drawable.x)
                }
            }
        }
    }

    private fun blanker() {
        img0.setImageResource(R.drawable.blank)
        img1.setImageResource(R.drawable.blank)
        img2.setImageResource(R.drawable.blank)
        img3.setImageResource(R.drawable.blank)
        img4.setImageResource(R.drawable.blank)
        img5.setImageResource(R.drawable.blank)
        img6.setImageResource(R.drawable.blank)
        img7.setImageResource(R.drawable.blank)
        img8.setImageResource(R.drawable.blank)
    }
}