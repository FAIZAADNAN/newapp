package com.example.newapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
//Defining the MainActivity class from AppCompatActivity
class MainActivity : AppCompatActivity() {
  //Declaring all the variables of elements in main xml file and sharingpreferences of login page
    private lateinit var btnStart: Button
    private lateinit var etName: EditText
    private lateinit var etPassword: EditText
    private lateinit var sharedPreferences: SharedPreferences

   //overriding the onCreate method to initializing the activity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //setting the view to layout activity_main
        setContentView(R.layout.activity_main)
       //setting the layout on the full screen mode
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        // Initialize views and assign the views by there ids
        btnStart = findViewById(R.id.btn_start)
        etName = findViewById(R.id.et_name)
        etPassword = findViewById(R.id.et_password)
       //Initialize the login page with sharedprefrences
        sharedPreferences = getSharedPreferences("appprefrences", Context.MODE_PRIVATE)

        // Retrieve the saved name and password if the user entered firstly
        val savedName = sharedPreferences.getString("USER_NAME", "")
        val savedPassword = sharedPreferences.getString("USER_PASSWORD", "")
       //setting the saved user name and password to edittext if fields are not empty
        if (!savedName.isNullOrEmpty()) {
            etName.setText(savedName)
        }
        if (!savedPassword.isNullOrEmpty()) {
            etPassword.setText(savedPassword)
        }
  //setting the onclick listener to the submit button
        btnStart.setOnClickListener {

            //getting the input user from editext fields
            val name = etName.text.toString()
            val password = etPassword.text.toString()
            //showing a toast msg if the field is empty
            if (name.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter your name and password", Toast.LENGTH_SHORT).show()
            } else {
                // Save the name and password in SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("USER_NAME", name)
                editor.putString("USER_PASSWORD", password)
                editor.apply()

                // going to the next activity
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}
