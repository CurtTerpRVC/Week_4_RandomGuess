/*
 Name: Curt Terpstra
 Class: CIS-245-OA010 (Spring 2021)
 App: Week 4 Random Guess
*/

package edu.rockvalleycollege.week4randomguess

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtGuess = findViewById<TextView>(R.id.txtGuess)
        var btnGuess = findViewById<Button>(R.id.btnGuess)
        var btnToast = findViewById<Button>(R.id.btnToast)

        // Get Random Number for Toast
        var number = (Math.random() * 10001).toInt()
        Toast.makeText(this, "Number to remember $number", Toast.LENGTH_LONG).show()

        // Compare guess to number shown in Toast
        btnGuess.setOnClickListener {
            if(txtGuess.text.isNotEmpty()) {
                if (number == txtGuess.text.toString().toInt()) {
                    Toast.makeText(this, "Correct, Great job remembering", Toast.LENGTH_LONG).show()
                    txtGuess.setText("")
                    hideKeyboard()
                } else {
                    Toast.makeText(this, "InCorrect, it was not the number shown", Toast.LENGTH_LONG).show()
                    txtGuess.setText("")
                    hideKeyboard()
                }// end of logic to test the guess against the number
            } else{
                Toast.makeText(this,"Need to enter a number",Toast.LENGTH_LONG).show()
                txtGuess.requestFocus()
            }// end of check for empty txtGuess field

        }// End of btnGuess OnClick Listener

        btnToast.setOnClickListener {
            number = (Math.random() * 10001).toInt()
            println(number)
            Toast.makeText(this, "Number to remember $number", Toast.LENGTH_LONG).show()
        }// End of btnToast Onclick Listener

        // This code goes at the end of OnCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }// End of hidekeyboard findviewbyid

    }// End of OnCreate

    // This code goes just before the end of main activity
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }
    }// end of hidekeyboard function



}// end of main activity

