package com.example.wordle


//import android.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import com.example.wordle.FourLetterWordList.getRandomFourLetterWord


class MainActivity : AppCompatActivity() {
    var guessCounter = 0
//    val wordToGuess = getRandomFourLetterWord()
    val wordToGuess = "book"
    var strValue=""
    var userGuess = ""
    var guessCheckResult=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessButton = findViewById<Button>(R.id.guessButton)


        guessButton.setOnClickListener{
            guessCounter++

            userGuess = findViewById<EditText>(R.id.userGuess)
            Log.d("Testing",userGuess)
            strValue = userGuess.text
            val guess1 = findViewById<TextView>(R.id.guess1)
            val guessCheck1 = findViewById<TextView>(R.id.guessCheck1)
            val guess2 = findViewById<TextView>(R.id.guess2)
            val guessCheck2 = findViewById<TextView>(R.id.guessCheck2)
            val guess3 = findViewById<TextView>(R.id.guess3)
            val guessCheck3 = findViewById<TextView>(R.id.guessCheck3)

            //displaying user guess and guess check

            if(guessCounter==1){
                guess1.text=strValue
                guessCheckResult = checkGuess(strValue)
                guessCheck1.text = guessCheckResult
                Log.d("Testing1",guessCheckResult)
            }
            if(guessCounter==2){
                guess2.text=userGuess
                guessCheckResult = checkGuess(userGuess)
                guessCheck1.text = guessCheckResult
                Log.d("Testing2",guessCheckResult)
            }

            if (guessCounter == 3){
                guessButton.text = "New Game"

                guess3.text=userGuess
                guessCheckResult = checkGuess(userGuess)
                guessCheck1.text = guessCheckResult

                //make wordToGuess visible
            }
        }

    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }
}