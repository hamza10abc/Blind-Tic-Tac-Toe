package com.track.blindtictactoe

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var turn_disp : TextView
    private lateinit var done_btn : Button
    private lateinit var ready_btn : Button
    private lateinit var img0 : ImageView
    private lateinit var img1 : ImageView
    private lateinit var img2 : ImageView
    private lateinit var img3 : ImageView
    private lateinit var img4 : ImageView
    private lateinit var img5 : ImageView
    private lateinit var img6 : ImageView
    private lateinit var img7 : ImageView
    private lateinit var img8 : ImageView
    private var index = 1 // default value when not clicked
    private var img_index_old = -1 // selected image old
    private var img_index_new = -1 // selected image new
    private var x_flag = 0 // x is not wining
    private var o_flag = 0 // o is not wining
    private var turn = -1 //X is denoted by 1 and O is denoted by -1
    private val X_Arr = arrayOf(0,0,0,0,0,0,0,0,0)  //X positions
    private val O_Arr = arrayOf(0,0,0,0,0,0,0,0,0)  //O posotions
    private val F_Arr = arrayOf(0,0,0,0,0,0,0,0,0)  //Final position of X and O

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        println("hello ANDROID")

        turn_disp = findViewById(R.id.turn_display)
        done_btn = findViewById(R.id.done_btn)
        ready_btn = findViewById(R.id.ready_btn)
        img0 = findViewById(R.id.img0)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        img3 = findViewById(R.id.img3)
        img4 = findViewById(R.id.img4)
        img5 = findViewById(R.id.img5)
        img6 = findViewById(R.id.img6)
        img7 = findViewById(R.id.img7)
        img8 = findViewById(R.id.img8)
        ready_btn.setVisibility(View.VISIBLE)

        blanker()
        Turn_X() //Starting with X


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

    fun Turn_X()
    {
        ready_btn.setVisibility(View.VISIBLE)
        blanker()
        click_off()
        turn_disp.setText("Turn X")
        ready_btn.setOnClickListener {
            click_on()
            ready_btn.setVisibility(View.INVISIBLE)

            x_box_fillup()

            turn = -turn
//            turn_disp.setText("Turn X")
            check_click { index ->
                X_Arr[index] = turn
                //            println(X_Arr.joinToString())
                done_btn.setOnClickListener {
                    if (F_Arr[index] == 0) {
                        F_Arr[index] = turn
//                        println(F_Arr.joinToString())
                        Turn_O()
                    } else {

                        X_Arr[index] = 0
//                        println(F_Arr.joinToString())
                        Turn_O()
                    }
                }
            }
        }
    }

    private fun click_on() {
        img0.isClickable = true
        img1.isClickable = true
        img2.isClickable = true
        img3.isClickable = true
        img4.isClickable = true
        img5.isClickable = true
        img6.isClickable = true
        img7.isClickable = true
        img8.isClickable = true
    }

    private fun click_off() {
        img0.isClickable = false
        img1.isClickable = false
        img2.isClickable = false
        img3.isClickable = false
        img4.isClickable = false
        img5.isClickable = false
        img6.isClickable = false
        img7.isClickable = false
        img8.isClickable = false
    }

    private fun x_box_fillup() {
        blanker()
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

    private fun Turn_O()
    {
        ready_btn.setVisibility(View.VISIBLE)
        blanker()
        turn_disp.setText("Turn O")
        click_off()
        ready_btn.setOnClickListener {
            click_on()
            ready_btn.setVisibility(View.INVISIBLE)

            o_box_fillup()

            turn = -turn
//            turn_disp.setText("Turn O")
            check_click { index ->
                O_Arr[index] = turn
                //            println(O_Arr.joinToString())
                done_btn.setOnClickListener {
                    if (F_Arr[index] == 0) {
                        F_Arr[index] = turn
//                        println(F_Arr.joinToString())
                        for (i in F_Arr.indices) {
                            F_Arr[i] *= 10
                        }
                        check_win()
                        Turn_X()
                    } else {
                        if (F_Arr[index] == 1 || F_Arr[index] == -1) {
                            F_Arr[index] = 0
//                            println(F_Arr.joinToString())
                            Turn_X()
                        } else {
                            for (i in F_Arr.indices) {
                                F_Arr[i] *= 10
                            }
                            check_win()
                            if (turn_disp.text == "Turn O") {
                                Turn_X()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun o_box_fillup() {
        blanker()
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

    private fun check_win() {
        println(F_Arr.joinToString())
        //CHECKING FOR X---------------------------------------
        if(F_Arr[0] > 0 && F_Arr[1] > 0 && F_Arr[2] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[3] > 0 && F_Arr[4] > 0 && F_Arr[5] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[6] > 0 && F_Arr[7] > 0 && F_Arr[8] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[0] > 0 && F_Arr[3] > 0 && F_Arr[6] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[1] > 0 && F_Arr[4] > 0 && F_Arr[7] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[2] > 0 && F_Arr[5] > 0 && F_Arr[8] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[0] > 0 && F_Arr[4] > 0 && F_Arr[8] > 0)
        {
            x_flag++
            win()
        }
        else if(F_Arr[2] > 0 && F_Arr[4] > 0 && F_Arr[6] > 0)
        {
            x_flag++
            win()
        }

        //----------------------------------------------------------
        //----------------------------------------------------------
        //CHECKING FOR O--------------------------------------------
        if(F_Arr[0] < 0 && F_Arr[1] < 0 && F_Arr[2] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[3] < 0 && F_Arr[4] < 0 && F_Arr[5] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[6] < 0 && F_Arr[7] < 0 && F_Arr[8] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[0] < 0 && F_Arr[3] < 0 && F_Arr[6] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[1] < 0 && F_Arr[4] < 0 && F_Arr[7] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[2] < 0 && F_Arr[5] < 0 && F_Arr[8] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[0] < 0 && F_Arr[4] < 0 && F_Arr[8] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[2] < 0 && F_Arr[4] < 0 && F_Arr[6] < 0)
        {
            o_flag++
            win()
        }
        else if(F_Arr[0] != 0 && F_Arr[1] != 0 && F_Arr[2] != 0 && F_Arr[3] != 0 && F_Arr[4] != 0 && F_Arr[5] != 0 && F_Arr[6] != 0 && F_Arr[7] != 0 && F_Arr[8] != 0)
        {
            x_flag++
            o_flag++
            win()
        }

    }

    private fun win() {
        val intent = Intent(this,Winner_Page::class.java)
        if(o_flag > 0 && x_flag > 0)
        {
            intent.putExtra("res","T")
//            intent.putExtra("F_Arr",F_Arr)
            intent.putIntegerArrayListExtra("F_Arr", ArrayList(F_Arr.toList()))
        }
        else if (o_flag > 0 && x_flag == 0)
        {
            intent.putExtra("res","O")
//            intent.putExtra("F_Arr",F_Arr)
            intent.putIntegerArrayListExtra("F_Arr", ArrayList(F_Arr.toList()))
        }
        else if (o_flag == 0 && x_flag > 0)
        {
            intent.putExtra("res","X")
//            intent.putExtra("F_Arr",F_Arr)
            intent.putIntegerArrayListExtra("F_Arr",ArrayList(F_Arr.toList()))
        }
        startActivity(intent)
    }

//    private fun x_won() {
//        println("X won")
//        val intent = Intent(this,Winner_Page::class.java)
//        intent.putExtra("x","X")
//        startActivity(intent)
//    }
//
//    private fun o_won() {
//        println("O won")
//        val intent = Intent(this,Winner_Page::class.java)
//        intent.putExtra("x","O")
//        startActivity(intent)
//    }

//    private fun winner(i: Int): String {
//        var winn = "Unknown1"
//        if (i > 0)
//        {
//            winn = "X"
//        }
//        else{
//            winn = "O"
//        }
//        return winn
//    }

    fun check_click(callback: (Int) -> Unit) {
        img0.setOnClickListener {
            callback(0)
//            println("test 0")
            if (turn == 1)
            {
                x_box_fillup()
                img0.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img0.setImageResource(R.drawable.o)
            }
        }
        img1.setOnClickListener {
            callback(1)
//            println("test 1")
            if (turn == 1)
            {
                x_box_fillup()
                img1.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img1.setImageResource(R.drawable.o)
            }
        }
        img2.setOnClickListener {
            callback(2)
//            println("test 2")
            if (turn == 1)
            {
                x_box_fillup()
                img2.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img2.setImageResource(R.drawable.o)
            }
        }
        img3.setOnClickListener {
            callback(3)
//            println("test 3")
            if (turn == 1)
            {
                x_box_fillup()
                img3.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img3.setImageResource(R.drawable.o)
            }
        }
        img4.setOnClickListener {
            callback(4)
//            println("test 4")
            if (turn == 1)
            {
                x_box_fillup()
                img4.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img4.setImageResource(R.drawable.o)
            }
        }
        img5.setOnClickListener {
            callback(5)
//            println("test 5")
            if (turn == 1)
            {
                x_box_fillup()
                img5.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img5.setImageResource(R.drawable.o)
            }
        }
        img6.setOnClickListener {
            callback(6)
//            println("test 6")
            if (turn == 1)
            {
                x_box_fillup()
                img6.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img6.setImageResource(R.drawable.o)
            }
        }
        img7.setOnClickListener {
            callback(7)
//            println("test 7")
            if (turn == 1)
            {
                x_box_fillup()
                img7.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img7.setImageResource(R.drawable.o)
            }
        }
        img8.setOnClickListener {
            callback(8)
//            println("test 8")
            if (turn == 1)
            {
                x_box_fillup()
                img8.setImageResource(R.drawable.x)
            }
            else if (turn == -1)
            {
                o_box_fillup()
                img8.setImageResource(R.drawable.o)
            }
        }
    }
    }