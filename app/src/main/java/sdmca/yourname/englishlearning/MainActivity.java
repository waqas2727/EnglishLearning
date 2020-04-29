package sdmca.yourname.englishlearning;

import android.app.WallpaperInfo;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user, pass;
    Button login;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.txtuser);
        pass=(EditText)findViewById(R.id.txtpass);
        login=(Button)findViewById(R.id.btnlogin);

    }
    public void login(View view){
        String userName = user.getText().toString();
        String password = pass.getText().toString();
        sharedPreferences = getSharedPreferences("MyUser",MODE_PRIVATE);
        String userDetails = sharedPreferences.getString(userName+password+"data","UserName or Password is incorrect");
        if (userDetails.equals("UserName or Password is incorrect")){
            Toast.makeText(this,"Invalid UserName or Password",Toast.LENGTH_SHORT).show();
            user.getText().clear();
            pass.getText().clear();
        }
        else {
            editor = sharedPreferences.edit();
            editor.putString("display", userDetails);
            editor.commit();

            user.getText().clear();
            pass.getText().clear();
            Intent intent = new Intent(this, DashBoard.class);
            intent.putExtra("UserName",userName);
            startActivity(intent);
        }
    }

    public void signUp(View view) {
        Intent intent = new Intent(this,signUp.class);
        startActivity(intent);
    }
    }
