package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.tictactoe.R.color
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //import view
    fun buttonClick(view: View) {

        //if button 1 is click the view will be button 1 . Says what button the user clicked on
        val selectedButton = view as Button
        //need to convert to string
//        Log.d("buttonClick:", selectedButton.id.toString());
        var cellID = 0;

        when (selectedButton.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button6 -> cellID = 5
            R.id.button7 -> cellID = 6
            R.id.button8 -> cellID = 7
            R.id.button9 -> cellID = 8

        }

//        Log.d("buttonClick", cellID.toString())
          playGame(cellID, selectedButton)

    }

    var activePlayer = 1
    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()
    fun playGame(cellID: Int, selectedButton: Button) {

        if (activePlayer == 1) {
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            activePlayer = 2
        } else {

            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.color.red)
            player2.add(cellID)
            activePlayer = 1

        }

        selectedButton.isEnabled = false

        checkWinner()
    }

    fun checkWinner() {
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1

        }


        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }


        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1

        }


        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        if (player1.contains(7) && player1.contains(5) && player1.contains(9)) {
            winner = 1

        }


        if (player2.contains(7) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if (winner == 1){
            Toast.makeText(this, "Player 1 won", Toast.LENGTH_LONG).show()

        }

         else if (winner == 2){
            Toast.makeText(this, "Player 2 won", Toast.LENGTH_LONG).show()

        }


    }
}