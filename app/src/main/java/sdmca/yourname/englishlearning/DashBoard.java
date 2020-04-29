package sdmca.yourname.englishlearning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DashBoard extends AppCompatActivity {

    TextView textView;
    Intent intent;
    public static String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        textView = (TextView) findViewById(R.id.textView);
        intent = getIntent();
        data = intent.getStringExtra("UserName");
        textView.setText("Hi, "+data);


    }
    public void signOut(View view){
        intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
    public void preKnowledge(View view){
        intent = new Intent(this,preKnowledge.class);
        startActivity(intent);
    }
    public void favLessons(View view){
        intent = new Intent(this,FavouriteLesson.class);
        startActivity(intent);
    }
    public void levels(View view){
        intent = new Intent(this,Levels.class);
        startActivity(intent);
    }
}
