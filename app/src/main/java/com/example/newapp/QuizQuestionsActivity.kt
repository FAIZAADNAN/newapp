package com.example.newapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
    //Main answers for the questionary app importing all the variable
class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {
  //Declaring all the elements of UI
    private lateinit var progressBar: ProgressBar
    private lateinit var tvProgress: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var ivImage: ImageView
    private lateinit var tv_option_one: TextView
    private lateinit var tv_option_two: TextView
    private lateinit var tv_option_three: TextView
    private lateinit var tv_option_four: TextView
    private lateinit var btn_submit : Button

    //different variables for the questionary app
    private var mCurrentPosition:Int=1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null
     //creating a code when the activity is called
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

         mUserName = intent.getStringExtra(Constants.USER_NAME)

        // Initializing UI elements by giving id to the variables
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivImage = findViewById(R.id.iv_image)
        tv_option_one = findViewById(R.id.tv_option_one)
        tv_option_two = findViewById(R.id.tv_option_two)
        tv_option_three = findViewById(R.id.tv_option_three)
        tv_option_four = findViewById(R.id.tv_option_four)
        btn_submit = findViewById(R.id.btn_submit)
     //getting the list of the questions from the constants
        mQuestionsList = Constants.getQuestions()
    //setting the first question
        setQuestion()

         //setting the onclick function for the options and submit button to get the answer
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)



    }

    private fun setQuestion(){

     //Method of setting the question to be displayed
        val question =  mQuestionsList!![mCurrentPosition -1]

        //Resetting the options from default

        defaultOptionsview()
     //changing the button text based on the numbering of the questions
        if (mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text = "SUBMIT"
        }
     //updating the progress bar and progress text
        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        //setting the question text and image

        tvQuestion.text = question!!.question
        ivImage.setImageResource(question.image ?: 0)
        tv_option_one.text = question.optionOne
        tv_option_two.text = question.optionTwo
        tv_option_three.text = question.optionThree
        tv_option_four.text = question.optionFour

    }
     //Method to reset the options view of default
    private fun defaultOptionsview(){
        val options = ArrayList<TextView>()
        options.add(0, tv_option_one)
        options.add(1, tv_option_two )
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)
   //loop to resetting each option after the answer
        for (option in options){

        }

    }
  //Method to handle the onclick funtion on the options and buttons
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two ->{
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three ->{
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four ->{
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                     val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        //checking if the selected option is correct
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    //showing the correct answer
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)
                     //changing the button texting based on the number of the question
                    if(mCurrentPosition == mQuestionsList!!.size){
                        btn_submit.text= "FINISH"
                    }else{
                        //checking if the option is selected
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

    }

   //Method to seting th background color when the option is selected
    private fun answerView(answer: Int,drawableView: Int){
        when(answer){
            1->{
                tv_option_one.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2->{
                tv_option_two.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3->{
                tv_option_three.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4->{
                tv_option_four.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

        }
    }
//Method to set the selecting option view
    private fun selectedOptionView(tv: TextView,
                                   selectedoptionNum:Int){

        defaultOptionsview()
        mSelectedOptionPosition = selectedoptionNum

        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )

    }
}
