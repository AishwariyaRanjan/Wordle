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
import java.util.*


class MainActivity : AppCompatActivity() {
    var guessCounter = 0
    var wordToGuess = getRandomFourLetterWord()
    var strValue=""
    lateinit var userGuess : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guess1 = findViewById<TextView>(R.id.guess1)
        val guessCheck1 = findViewById<TextView>(R.id.guessCheck1)
        val guess2 = findViewById<TextView>(R.id.guess2)
        val guessCheck2 = findViewById<TextView>(R.id.guessCheck2)
        val guess3 = findViewById<TextView>(R.id.guess3)
        val guessCheck3 = findViewById<TextView>(R.id.guessCheck3)
        val guessButton = findViewById<Button>(R.id.guessButton)
        val correctWord = findViewById<TextView>(R.id.wordToGuess)

        guessButton.setOnClickListener{
            if (guessButton.text=="New Game"){
                Log.d("TestingReset","entered new game if statement")

                //clear textviews
                guess1.text=""
                guessCheck1.text=""
                guess2.text=""
                guessCheck2.text=""
                guess3.text=""
                guessCheck3.text=""

                //reset counter
                guessCounter=0
                //reset guess button
                guessButton.text="Guess!"

                //generate new word to guess
                wordToGuess = getRandomFourLetterWord()
                Log.d("TestingWord",wordToGuess.toString())
                correctWord.isVisible=false
            }
            else{
                guessCounter++

                userGuess = findViewById<EditText>(R.id.userGuess)
                Log.d("Testing", userGuess.toString())
                strValue = userGuess.text.toString()

                var guessCheckResult=""

                //displaying user guess and guess check
                if(guessCounter==1){
                    guess1.text=strValue
                    guessCheckResult = checkGuess(strValue.toUpperCase(Locale.ROOT))
                    guessCheck1.text = guessCheckResult
                    Log.d("Testing1",guessCheckResult)
                }
                if(guessCounter==2){
                    guess2.text=strValue
                    guessCheckResult = checkGuess(strValue.toUpperCase(Locale.ROOT))
                    guessCheck2.text = guessCheckResult
                    Log.d("Testing2",guessCheckResult)
                }

                if (guessCounter == 3){
                    guessButton.text = "New Game"

                    guess3.text=strValue
                    guessCheckResult = checkGuess(strValue.toUpperCase(Locale.ROOT))
                    guessCheck3.text = guessCheckResult

                    //make wordToGuess visible
                    correctWord.text=wordToGuess
                    correctWord.isVisible=true
                }
                //reser editText for user
                userGuess.setText("")
            }//end of else
        }
    }

    private fun checkGuess(guess: String) : String {
        var result = ""
        Log.d("testingCheckGuess - guess",guess.toString())
        Log.d("testingCheckGuess - wordToGuess",wordToGuess.toString())
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