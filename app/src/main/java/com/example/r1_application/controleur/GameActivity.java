package com.example.r1_application.controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.r1_application.R;
import com.example.r1_application.model.Question;
import com.example.r1_application.model.QuestionList;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        int answerId = (int) v.getTag ();
        if(answerId == currentQuestion.getChoiceId ()){
            Toast.makeText (this, "Correct", Toast.LENGTH_SHORT).show ();
        } else{
            Toast.makeText (this, "Wrong answer", Toast.LENGTH_SHORT).show ();
        }
    }

    private TextView gameQuestion;
    private Button gameAnswer1;
    private Button gameAnswer2;
    private Button gameAnswer3;
    private Button gameAnswer4;

    private Question currentQuestion;
    private QuestionList questionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_game );

        questionList = this.generateQuestions ();

        gameQuestion = findViewById ( R.id.gameQuestion );
        gameAnswer1 = findViewById ( R.id.gameAnswer1 );
        gameAnswer2 = findViewById ( R.id.gameAnswer2 );
        gameAnswer3 = findViewById ( R.id.gameAnswer3 );
        gameAnswer4 = findViewById ( R.id.gameAnswer4 );

        gameAnswer1.setTag ( 0 );
        gameAnswer2.setTag ( 1 );
        gameAnswer3.setTag ( 2 );
        gameAnswer4.setTag ( 3 );

        gameAnswer1.setOnClickListener ( this );
        gameAnswer2.setOnClickListener ( this );
        gameAnswer3.setOnClickListener ( this );
        gameAnswer4.setOnClickListener ( this );

        currentQuestion = questionList.getQuestion ();
        this.displayQuestion(currentQuestion);
    }

    private void displayQuestion(final Question currentQuestion) {
        gameQuestion.setText ( currentQuestion.getQuestion () );
        gameAnswer1.setText ( currentQuestion.getAnswerChoice().get ( 0 ) );
        gameAnswer2.setText ( currentQuestion.getAnswerChoice().get ( 1 ) );
        gameAnswer3.setText ( currentQuestion.getAnswerChoice().get ( 2 ) );
        gameAnswer4.setText ( currentQuestion.getAnswerChoice().get ( 3 ) );
    }

    private QuestionList generateQuestions(){
        Question question1 = new Question("What is the name of the current french president?",
                Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
                1);

        Question question2 = new Question("How many countries are there in the European Union?",
                Arrays.asList("15", "24", "28", "32"),
                2);

        Question question3 = new Question("Who is the creator of the Android operating system?",
                Arrays.asList("Andy Rubin", "Steve Wozniak", "Jake Wharton", "Paul Smith"),
                0);

        Question question4 = new Question("When did the first man land on the moon?",
                Arrays.asList("1958", "1962", "1967", "1969"),
                3);

        Question question5 = new Question("What is the capital of Romania?",
                Arrays.asList("Bucarest", "Warsaw", "Budapest", "Berlin"),
                0);

        Question question6 = new Question("Who did the Mona Lisa paint?",
                Arrays.asList("Michelangelo", "Leonardo Da Vinci", "Raphael", "Carravagio"),
                1);

        Question question7 = new Question("In which city is the composer Frédéric Chopin buried?",
                Arrays.asList("Strasbourg", "Warsaw", "Paris", "Moscow"),
                2);

        Question question8 = new Question("What is the country top-level domain of Belgium?",
                Arrays.asList(".bg", ".bm", ".bl", ".be"),
                3);

        Question question9 = new Question("What is the house number of The Simpsons?",
                Arrays.asList("42", "101", "666", "742"),
                3);

        return new QuestionList (Arrays.asList(question1,
                question2,
                question3,
                question4,
                question5,
                question6,
                question7,
                question8,
                question9));
    }
}
