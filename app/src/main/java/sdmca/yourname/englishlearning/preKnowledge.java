package sdmca.yourname.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class preKnowledge extends AppCompatActivity {

    TextView question,title;
    Button option1,option2;
    int i ;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_knowledge);

        title = (TextView) findViewById(R.id.textView2);
        question = (TextView) findViewById(R.id.textView3);
        option1 = (Button) findViewById(R.id.button12);
        option2 = (Button) findViewById(R.id.button13);
        String q  = "Choose the right Option:";
        String q1 = "Correct Punctuation of Stomach is";
        String q2 = "Identify Adverb in Given Sentence:\n "+"You are running fast enough.";
        String q3 = "Identify simple future Sentence:" ;
        String op1 = "ˈstəək" ;
        String op2 = "ˈstəmək" ;
        String op3 = "running" ;
        String op4 = "enough" ;
        String op5 = "You played the game" ;
        String op6 = "He will complete his task" ;

        title.setText(q);
        Random random = new Random();
        i = random.nextInt(3-1)+1;

        if(i==1){
            question.setText(q1);
            option1.setText(op1);
            option2.setText(op2);
        }
        if(i==2){
            question.setText(q2);
            option1.setText(op3);
            option2.setText(op4);
        }
        if(i==3){
            question.setText(q3);
            option1.setText(op5);
            option2.setText(op6);
        }
    }
    public  void correct(View view){
        Toast.makeText(this,"Correct Answer!!",Toast.LENGTH_SHORT).show();
        if (i == 1 ){Toast.makeText(this,"You are student of level2",Toast.LENGTH_SHORT).show();}
        if (i == 2 ){Toast.makeText(this,"You are student of level3",Toast.LENGTH_SHORT).show();}
        if (i == 3 ){Toast.makeText(this,"You are student of level4",Toast.LENGTH_SHORT).show();}
    }
    public  void wrong(View view){
        Toast.makeText(this,"Correct Answer!!",Toast.LENGTH_SHORT).show();
        if (i == 1 ){Toast.makeText(this,"You are student of level1",Toast.LENGTH_SHORT).show();}
        if (i == 2 ){Toast.makeText(this,"You are student of level2",Toast.LENGTH_SHORT).show();}
        if (i == 3 ){Toast.makeText(this,"You are student of level3",Toast.LENGTH_SHORT).show();}
    }
}
