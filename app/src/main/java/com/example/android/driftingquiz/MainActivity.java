package com.example.android.driftingquiz;


import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.driftingquiz.R.id.q6a2;
import static com.example.android.driftingquiz.R.id.q6a3;


/**
 * This app checks the user's knowledge about drifting.
 */
public class MainActivity extends AppCompatActivity {

    String warmUpQuestion = ""; //The answer for the warmUpQuestion
    String correctAnswerForWarmUpQuestion = "DriftKing";

    int numberOfCorrectAnswers = 0;
    int numberOfCorrectCheckBox = 0;
    int questionOneAnswer = 0;
    int questionTwoAnswer = 0;
    int questionThreeAnswer = 0;
    int questionFourAnswer = 0;
    int questionFiveAnswer = 0;
    int questionSixAnswer = 0;

    boolean q6a1Check = false;
    boolean q6a2Check = false;
    boolean q6a3Check = false;
    boolean q6a4Check = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the "Check the answers" button is tapped.
     * It evaluates the answers and posts a toast message about the performance of the user.
     */
    public void checkAnswers(View view) {

        // Storing the answer of the warm up question to the "warmUpQuestion" variable
        EditText warm_up_question = (EditText) findViewById(R.id.warm_up_question);
        warmUpQuestion = warm_up_question.getText().toString();

        // Resetting the number of Correct Answers and CheckBoxes
        // This way the user can't increment his/her score by tapping on the Check Answers button
        numberOfCorrectAnswers = 0;
        numberOfCorrectCheckBox = 0;

        checkWarmUpQuestion();
        checkQuestionOne(findViewById(R.id.question_1_rg));
        checkQuestionTwo(findViewById(R.id.question_2_rg));
        checkQuestionThree(findViewById(R.id.question_3_rg));
        checkQuestionFour(findViewById(R.id.question_4_rg));
        checkQuestionFive(findViewById(R.id.question_5_rg));
        checkQuestionSix();

        //The performance of the User is calculated by Correct answers / Number of Answers * 100 to get a percentage.
        int performanceOfUser = numberOfCorrectAnswers * 100 / 7;

        //The User gets a feedback for his/her performance by a Toast message.
        String evaluationOfUser = getString(R.string.you_achieved) + " " + performanceOfUser + "%\nThe correct answer for the warm up question was DriftKing";
        Toast.makeText(this, evaluationOfUser, Toast.LENGTH_SHORT).show();


    }

    /**
     * This method checks the answers for the warm up question.
     * It compares the upper-case version of the correct answer, and the given answer,
     * thus checking only the characters without casing.
     */

    public void checkWarmUpQuestion() {
        if (warmUpQuestion.toUpperCase().equals(correctAnswerForWarmUpQuestion.toUpperCase())) {
            numberOfCorrectAnswers++;
        }
    }

    /**
     * This method checks the answers for Question One
     * It recolors the questions based on the correctness, and increment the number of the correct answers.
     * If the User decides to modify his/her answers and tap on the Check Answers again without resetting them,
     * this method recolors the unselected RadioButtons background to white
     */


    public void checkQuestionOne(View view) {

        TextView q1a1 = (TextView) findViewById(R.id.q1a1);
        TextView q1a2 = (TextView) findViewById(R.id.q1a2);
        TextView q1a3 = (TextView) findViewById(R.id.q1a3);
        TextView q1a4 = (TextView) findViewById(R.id.q1a4);

        switch (questionOneAnswer) {
            case 1:
                numberOfCorrectAnswers++;
                q1a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q1a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q1a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q1a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 2:

                q1a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q1a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q1a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q1a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 3:

                q1a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q1a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q1a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q1a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 4:

                q1a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q1a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q1a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q1a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                break;

        }
    }

    /**
     * This method monitors the RadioGroup of Question One, and changes the given answers variable accordingly.
     */

    public void questionOne(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q1a1:
                if (checked)
                    questionOneAnswer = 1;
                break;

            case R.id.q1a2:
                if (checked)
                    questionOneAnswer = 2;
                break;
            case R.id.q1a3:
                if (checked)
                    questionOneAnswer = 3;
                break;
            case R.id.q1a4:
                if (checked)
                    questionOneAnswer = 4;
                break;
        }
    }

    /**
     * This method checks the answers for Question Two
     * It recolors the questions based on the correctness, and increment the number of the correct answers.
     * If the User decides to modify his/her answers and tap on the Check Answers again without resetting them,
     * this method recolors the unselected RadioButtons background to white
     */

    public void checkQuestionTwo(View view) {

        TextView q2a1 = (TextView) findViewById(R.id.q2a1);
        TextView q2a2 = (TextView) findViewById(R.id.q2a2);
        TextView q2a3 = (TextView) findViewById(R.id.q2a3);
        TextView q2a4 = (TextView) findViewById(R.id.q2a4);

        switch (questionTwoAnswer) {
            case 1:
                q2a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q2a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q2a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q2a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 2:
                numberOfCorrectAnswers++;
                q2a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q2a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q2a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q2a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 3:
                q2a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q2a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q2a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q2a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 4:
                q2a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q2a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q2a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q2a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                break;

        }
    }

    /**
     * This method monitors the RadioGroup of Question Two, and changes the given answers variable accordingly.
     */

    public void questionTwo(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q2a1:
                if (checked)
                    questionTwoAnswer = 1;
                break;

            case R.id.q2a2:
                if (checked)
                    questionTwoAnswer = 2;
                break;
            case R.id.q2a3:
                if (checked)
                    questionTwoAnswer = 3;
                break;
            case R.id.q2a4:
                if (checked)
                    questionTwoAnswer = 4;
                break;
        }
    }


    /**
     * This method checks the answers for Question Three
     * It recolors the questions based on the correctness, and increment the number of the correct answers.
     * If the User decides to modify his/her answers and tap on the Check Answers again without resetting them,
     * this method recolors the unselected RadioButtons background to white
     */

    public void checkQuestionThree(View view) {

        TextView q3a1 = (TextView) findViewById(R.id.q3a1);
        TextView q3a2 = (TextView) findViewById(R.id.q3a2);
        TextView q3a3 = (TextView) findViewById(R.id.q3a3);
        TextView q3a4 = (TextView) findViewById(R.id.q3a4);

        switch (questionThreeAnswer) {
            case 1:
                q3a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q3a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q3a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q3a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 2:
                q3a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q3a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q3a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q3a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 3:

                numberOfCorrectAnswers++;
                q3a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q3a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q3a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q3a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));

                break;

            case 4:
                q3a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q3a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q3a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q3a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                break;

        }
    }

    /**
     * This method monitors the RadioGroup of Question Three, and changes the given answers variable accordingly.
     */

    public void questionThree(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q3a1:
                if (checked)
                    questionThreeAnswer = 1;
                break;

            case R.id.q3a2:
                if (checked)
                    questionThreeAnswer = 2;
                break;
            case R.id.q3a3:
                if (checked)
                    questionThreeAnswer = 3;
                break;
            case R.id.q3a4:
                if (checked)
                    questionThreeAnswer = 4;
                break;
        }
    }


    /**
     * This method checks the answers for Question Four
     * It recolors the questions based on the correctness, and increment the number of the correct answers.
     * If the User decides to modify his/her answers and tap on the Check Answers again without resetting them,
     * this method recolors the unselected RadioButtons background to white
     */

    public void checkQuestionFour(View view) {

        TextView q4a1 = (TextView) findViewById(R.id.q4a1);
        TextView q4a2 = (TextView) findViewById(R.id.q4a2);
        TextView q4a3 = (TextView) findViewById(R.id.q4a3);
        TextView q4a4 = (TextView) findViewById(R.id.q4a4);

        switch (questionFourAnswer) {
            case 1:
                numberOfCorrectAnswers++;
                q4a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q4a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q4a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q4a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 2:

                q4a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q4a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q4a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q4a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 3:

                q4a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q4a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q4a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q4a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 4:

                q4a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q4a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q4a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q4a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                break;

        }
    }

    /**
     * This method monitors the RadioGroup of Question Four, and changes the given answers variable accordingly.
     */

    public void questionFour(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q4a1:
                if (checked)
                    questionFourAnswer = 1;
                break;

            case R.id.q4a2:
                if (checked)
                    questionFourAnswer = 2;
                break;
            case R.id.q4a3:
                if (checked)
                    questionFourAnswer = 3;
                break;
            case R.id.q4a4:
                if (checked)
                    questionFourAnswer = 4;
                break;
        }
    }


    /**
     * This method checks the answers for Question Five
     * It recolors the questions based on the correctness, and increment the number of the correct answers.
     * If the User decides to modify his/her answers and tap on the Check Answers again without resetting them,
     * this method recolors the unselected RadioButtons background to white
     */

    public void checkQuestionFive(View view) {

        TextView q5a1 = (TextView) findViewById(R.id.q5a1);
        TextView q5a2 = (TextView) findViewById(R.id.q5a2);
        TextView q5a3 = (TextView) findViewById(R.id.q5a3);
        TextView q5a4 = (TextView) findViewById(R.id.q5a4);

        switch (questionFiveAnswer) {
            case 1:
                q5a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q5a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q5a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q5a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 2:
                numberOfCorrectAnswers++;
                q5a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q5a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q5a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q5a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 3:
                q5a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q5a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q5a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                q5a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                break;

            case 4:
                q5a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q5a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
                q5a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
                q5a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));
                break;

        }
    }

    /**
     * This method monitors the RadioGroup of Question Five, and changes the given answers variable accordingly.
     */

    public void questionFive(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.q5a1:
                if (checked)
                    questionFiveAnswer = 1;
                break;

            case R.id.q5a2:
                if (checked)
                    questionFiveAnswer = 2;
                break;
            case R.id.q5a3:
                if (checked)
                    questionFiveAnswer = 3;
                break;
            case R.id.q5a4:
                if (checked)
                    questionFiveAnswer = 4;
                break;
        }
    }

    /**
     * This method checks the answers for Question Six
     * It recolors the questions based on the correctness, and increment the number of the correct answers.
     * If the User decides to modify his/her answers and tap on the Check Answers again without resetting them,
     * this method recolors the unchecked CheckBoxes' background to white.
     */

    public void checkQuestionSix() {


        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q6a1);
        CheckBox checkBox2 = (CheckBox) findViewById(q6a2);
        CheckBox checkBox3 = (CheckBox) findViewById(q6a3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q6a4);

        checkBox1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));
        checkBox4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorCorrect));

        q6a2Check = checkBox2.isChecked();
        if (q6a2Check) {
            checkBox2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));

        } else {
            checkBox2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        }

        q6a3Check = checkBox3.isChecked();
        if (q6a3Check) {
            checkBox3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorIncorrect));

        } else {
            checkBox3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        }

        if (q6a1Check && !q6a2Check && !q6a3Check && q6a4Check) {
            numberOfCorrectAnswers++;
        }
    }

    /**
     * This method is called when the "Reset" button is clicked.
     * The answers reverts back to the original state.
     */
    public void reset(View view) {


        //Resetting the radio groups
        RadioGroup question_1_rg = (RadioGroup) findViewById(R.id.question_1_rg);
        question_1_rg.clearCheck();
        RadioGroup question_2_rg = (RadioGroup) findViewById(R.id.question_2_rg);
        question_2_rg.clearCheck();
        RadioGroup question_3_rg = (RadioGroup) findViewById(R.id.question_3_rg);
        question_3_rg.clearCheck();
        RadioGroup question_4_rg = (RadioGroup) findViewById(R.id.question_4_rg);
        question_4_rg.clearCheck();
        RadioGroup question_5_rg = (RadioGroup) findViewById(R.id.question_5_rg);
        question_5_rg.clearCheck();

        //Resetting the checkboxes

        CheckBox q6a1 = (CheckBox) findViewById(R.id.q6a1);
        q6a1.setChecked(false);
        CheckBox q6a2 = (CheckBox) findViewById(R.id.q6a2);
        q6a2.setChecked(false);
        CheckBox q6a3 = (CheckBox) findViewById(R.id.q6a3);
        q6a3.setChecked(false);
        CheckBox q6a4 = (CheckBox) findViewById(R.id.q6a4);
        q6a4.setChecked(false);
        q6a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q6a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q6a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q6a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));


        //Resetting the variables
        numberOfCorrectAnswers = 0;
        warmUpQuestion = "";
        questionOneAnswer = 0;
        questionTwoAnswer = 0;
        questionThreeAnswer = 0;
        questionFourAnswer = 0;
        questionFiveAnswer = 0;
        questionSixAnswer = 0;

        //Resetting the colors
        TextView q1a1 = (TextView) findViewById(R.id.q1a1);
        TextView q1a2 = (TextView) findViewById(R.id.q1a2);
        TextView q1a3 = (TextView) findViewById(R.id.q1a3);
        TextView q1a4 = (TextView) findViewById(R.id.q1a4);
        q1a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q1a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q1a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q1a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));

        TextView q2a1 = (TextView) findViewById(R.id.q2a1);
        TextView q2a2 = (TextView) findViewById(R.id.q2a2);
        TextView q2a3 = (TextView) findViewById(R.id.q2a3);
        TextView q2a4 = (TextView) findViewById(R.id.q2a4);
        q2a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q2a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q2a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q2a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));

        TextView q3a1 = (TextView) findViewById(R.id.q3a1);
        TextView q3a2 = (TextView) findViewById(R.id.q3a2);
        TextView q3a3 = (TextView) findViewById(R.id.q3a3);
        TextView q3a4 = (TextView) findViewById(R.id.q3a4);
        q3a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q3a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q3a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q3a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));

        TextView q4a1 = (TextView) findViewById(R.id.q4a1);
        TextView q4a2 = (TextView) findViewById(R.id.q4a2);
        TextView q4a3 = (TextView) findViewById(R.id.q4a3);
        TextView q4a4 = (TextView) findViewById(R.id.q4a4);
        q4a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q4a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q4a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q4a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));

        TextView q5a1 = (TextView) findViewById(R.id.q5a1);
        TextView q5a2 = (TextView) findViewById(R.id.q5a2);
        TextView q5a3 = (TextView) findViewById(R.id.q5a3);
        TextView q5a4 = (TextView) findViewById(R.id.q5a4);
        q5a1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q5a2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q5a3.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
        q5a4.setBackgroundColor(ContextCompat.getColor(this, R.color.colorDefaultBackground));
    }

}