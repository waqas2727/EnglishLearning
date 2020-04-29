package sdmca.yourname.englishlearning;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class signUp extends AppCompatActivity {

    EditText username, password,email;
    public static int i = 0;
    Button signUp;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText4);
        email = (EditText) findViewById(R.id.editText3);
        signUp = (Button) findViewById(R.id.button);
    }
    public void saveData(View view){
        sharedPreferences = getSharedPreferences("MyUser",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String newUser = username.getText().toString();
        String Password = password.getText().toString();
        String Email = email.getText().toString();

        username.getText().clear();
        password.getText().clear();
        email.getText().clear();

        editor.putString(newUser+Password+"data",newUser+"\n"+Email);
        i++;
        editor.commit();

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
