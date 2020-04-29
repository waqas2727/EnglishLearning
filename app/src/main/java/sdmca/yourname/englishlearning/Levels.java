package sdmca.yourname.englishlearning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Levels extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        button1 = (Button) findViewById(R.id.button4);
        button2 = (Button) findViewById(R.id.button7);
        button3 = (Button) findViewById(R.id.button8);
        button4 = (Button) findViewById(R.id.button9);
        button5 = (Button) findViewById(R.id.button10);
    }

    public void Level1(View view){
        intent = new Intent(this, Level1.class);
        intent.putExtra("ButtonId",1);
        startActivity(intent);
    }
    public void Level2(View view){
        intent = new Intent(this, Level1.class);
        intent.putExtra("ButtonId",2);
        startActivity(intent);
    }
    public void Level3(View view){
        intent = new Intent(this, Level1.class);
        intent.putExtra("ButtonId",3);
        startActivity(intent);
    }
    public void Level4(View view){
        intent = new Intent(this, Level1.class);
        intent.putExtra("ButtonId",4);
        startActivity(intent);
    }
    public void Level5(View view){
        intent = new Intent(this, Level1.class);
        intent.putExtra("ButtonId",5);
        startActivity(intent);
    }
}
