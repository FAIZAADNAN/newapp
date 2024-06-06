package com.example.newapp

object Constants {

    val USER_NAME: String? = null
    const val USER_Name: String = "user_name"
    const val TOTAL_QUESTIONS: String ="total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // Add questions here with correct image resources
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.flag1,
            "Argentina", "Africa",
            "Korea", "nigeria",
            1
        )

        questionsList.add(que1)

        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.flag2,
            "Ausralia", "belgium",
            "bangaldesh", "uruguay",
            1
        )

        questionsList.add(que2)

        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.flag3,
            "China", "Egypt",
            "France", "Greece",
            1
        )

        questionsList.add(que3)

        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.flag4,
            "India", "Egypt",
            "France", "Greece",
            2
        )

        questionsList.add(que4)

        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.flag5,
            "Kenya", "Maxico",
            "Netherlands", "Newzealand",
            2
        )

        questionsList.add(que5)

        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.flag6,
            "Norway", "Pakistan",
            "Poland", "Portugal",
            2
        )

        questionsList.add(que6)

        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.flag7,
            "Russia", "Saudi Arabia",
            "Turkey", "SouthAfrica",
            2
        )

        questionsList.add(que7)

        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.flag8,
            "Spain", "Switerland",
            "Thailand", "Japan",
            3
        )

        questionsList.add(que8)

        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.flag9,
            "Turkey", "Ukraine",
            "United Kingdom", "United States",
            1
        )

        questionsList.add(que9)

        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.flag10,
            "Vietnam", "Zambia",
            "Zimbabwe", "Austria",
            4
        )

        questionsList.add(que10)

        val que11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.flag11,
            "Belgium", "Bolivia",
            "Chile", "Colombia",
            4
        )

        questionsList.add(que11)

        val que12 = Question(
            12, "What country does this flag belong to?",
            R.drawable.flag12,
            "Croatia", "Cuba",
            "Ecuador", "Czech Republic",
            4
        )

        questionsList.add(que12)



        val que13 = Question(
            13, "What country does this flag belong to?",
            R.drawable.flag13,
            "Estonia", "Germany",
            "Hungary", "Georgia",
            2
        )

        questionsList.add(que13)

        val que14 = Question(
            14, "What country does this flag belong to?",
            R.drawable.flag14,
            "Iceland", "Indonesia",
            "Jamaica", "Holland",
            2
        )

        questionsList.add(que14)

        val que15 = Question(
            15, "What country does this flag belong to?",
            R.drawable.flag15,
            "Jordan", "Latvia",
            "Kazakhstan", "Lebanon",
            1
        )

        questionsList.add(que15)

        val que16 = Question(
            16, "What country does this flag belong to?",
            R.drawable.flag16,
            "Lithuania", "Malaysia",
            "Luxembourg", "Malta",
            4
        )

        questionsList.add(que16)

        val que17 = Question(
            17, "What country does this flag belong to?",
            R.drawable.flag17,
            "Mongolia", "Nigeria",
            "Nepal", "Oman",
            4
        )

        questionsList.add(que17)

        val que18 = Question(
            18, "What country does this flag belong to?",
            R.drawable.flag18,
            " Philippines", "belgium",
            "Qatar", "uruguay",
            3
        )

        questionsList.add(que18)

        val que19 = Question(
            19, "What country does this flag belong to?",
            R.drawable.flag19,
            "Singapore", "belgium",
            "bangaldesh", "uruguay",
            1
        )

        questionsList.add(que19)

        val que20 = Question(
            20, "What country does this flag belong to?",
            R.drawable.flag20,
            "Syria", "belgium",
            "bangaldesh", "uruguay",
            1
        )

        questionsList.add(que20)



        // Add more questions...

        return questionsList
    }
}