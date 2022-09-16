package com.example.wordle


//import android.R
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

import com.example.wordle.FourLetterWordList.getRandomFourLetterWord


class MainActivity : AppCompatActivity() {
    var guessCounter = 0
//    val wordToGuess = getRandomFourLetterWord()
    var wordToGuess = "book"
    var strValue=""
    lateinit var userGuess : EditText
    val guess1 = findViewById<TextView>(R.id.guess1)
    val guessCheck1 = findViewById<TextView>(R.id.guessCheck1)
    val guess2 = findViewById<TextView>(R.id.guess2)
    val guessCheck2 = findViewById<TextView>(R.id.guessCheck2)
    val guess3 = findViewById<TextView>(R.id.guess3)
    val guessCheck3 = findViewById<TextView>(R.id.guessCheck3)
    val guessButton = findViewById<Button>(R.id.guessButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guessButton.setOnClickListener{
            if (guessButton.text=="New game"){
//                resetAll()
                Log.d("TestingReset","entered new game if statement")
                //generate new word to guess
                wordToGuess = getRandomFourLetterWord()
                Log.d("TestingWord",wordToGuess.toString())
            }
            else{
                guessCounter++

                userGuess = findViewById<EditText>(R.id.userGuess)
                Log.d("Testing", userGuess.toString())
                strValue = userGuess.text.toString()

                var guessCheckResult=""
                val correctWord = findViewById<TextView>(R.id.wordToGuess)
                //displaying user guess and guess check

                if(guessCounter==1){
                    guess1.text=strValue
                    guessCheckResult = checkGuess(strValue)
                    guessCheck1.text = guessCheckResult
                    Log.d("Testing1",guessCheckResult)
                }
                if(guessCounter==2){
                    guess2.text=strValue
                    guessCheckResult = checkGuess(strValue)
                    guessCheck2.text = guessCheckResult
                    Log.d("Testing2",guessCheckResult)
                }

                if (guessCounter == 3){
                    guessButton.text = "New Game"

                    guess3.text=strValue
                    guessCheckResult = checkGuess(strValue)
                    guessCheck3.text = guessCheckResult

                    //make wordToGuess visible
                    correctWord.text=wordToGuess
                    correctWord.isVisible=true
                }
            }
        }
    }
    private fun resetAll(){
        //clear textviews
        guess1.text=""
        guessCheck1.text=""
        guess2.text=""
        guessCheck2.text=""
        guess2.text=""
        guessCheck2.text=""

        //reset counter
        guessCounter=0
        //reset guess button
        guessButton.text="Guess!"
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