package sdmca.yourname.englishlearning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static sdmca.yourname.englishlearning.Level1.favourite;

public class FavouriteLesson extends AppCompatActivity {

    ListView listView;
    MediaPlayer mediaPlayer;
    VideoView videoView;
    EditText textView;
    Button bPlay,bStop;
    int x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_lesson);
        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        videoView = (VideoView) findViewById(R.id.videoView);
        textView = (EditText) findViewById(R.id.editText2);
        bPlay = (Button) findViewById(R.id.button11);
        bStop = (Button) findViewById(R.id.bStop);

        textView.setVisibility(View.INVISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        favourite = getArray();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,favourite);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("info", "inside onclick");
                String lessonNo = favourite.get((int)id);
                play(lessonNo);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                favourite.remove(favourite.get((int) id));
                saveArray();
                listView.invalidateViews();
                Toast.makeText(getApplicationContext(),"Remove from Favourite",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    public void stop(View view){
        mediaPlayer.stop();
    }
    public boolean saveArray() {
        SharedPreferences sp = this.getSharedPreferences(DashBoard.data+String.valueOf(signUp.i), Activity.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sp.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(favourite);
        mEdit1.putStringSet("list", set);
        return mEdit1.commit();
    }

    public void play(String lessonNo){
        if (lessonNo.length() == 7){
            mediaPlayer = (MediaPlayer) MediaPlayer.create(this, getResources().getIdentifier(lessonNo, "raw", getPackageName()));
            mediaPlayer.start();
        }
        else {
            String num = String.valueOf(lessonNo.charAt(6)).concat(String.valueOf(lessonNo.charAt(7))) ;
            if (Integer.valueOf(num) >= 11 && Integer.valueOf(num) <=20){
                listView.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                if (lessonNo.equals("lesson11"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson11);
                }else if (lessonNo.equals("lesson12"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson12);
                }else if (lessonNo.equals("lesson13"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson13);
                }else if (lessonNo.equals("lesson14"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson14);
                }else if (lessonNo.equals("lesson15"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson15);
                }else if (lessonNo.equals("lesson16"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson16);
                }else if (lessonNo.equals("lesson17"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson17);
                }else if (lessonNo.equals("lesson18"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson18);
                }else if (lessonNo.equals("lesson19"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson19);
                }else if (lessonNo.equals("lesson20"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson20);
                }
                videoView.start();
            } else if (Integer.valueOf(num) >= 21 && Integer.valueOf(num) <=30){
                listView.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);
                InputStream is = getResources().openRawResource(R.raw.lesson21);;
                if (lessonNo.equals("lesson21")) {
                    is = getResources().openRawResource(R.raw.lesson21);
                } else if (lessonNo.equals("lesson22")) {
                    is = getResources().openRawResource(R.raw.lesson22);
                }else if (lessonNo.equals("lesson23")) {
                    is = getResources().openRawResource(R.raw.lesson23);
                }else if (lessonNo.equals("lesson24")) {
                    is = getResources().openRawResource(R.raw.lesson24);
                }else if (lessonNo.equals("lesson25")) {
                    is = getResources().openRawResource(R.raw.lesson25);
                }else if (lessonNo.equals("lesson26")) {
                    is = getResources().openRawResource(R.raw.lesson26);
                }else if (lessonNo.equals("lesson27")) {
                    is = getResources().openRawResource(R.raw.lesson27);
                }else if (lessonNo.equals("lesson28")) {
                    is = getResources().openRawResource(R.raw.lesson28);
                }else if (lessonNo.equals("lesson29")) {
                    is = getResources().openRawResource(R.raw.lesson29);
                }else if (lessonNo.equals("lesson30")) {
                    is = getResources().openRawResource(R.raw.lesson30);
                }
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line;
                String entireFile = "";
                try {
                    while((line = br.readLine()) != null) {
                        entireFile += (line + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textView.setText(entireFile);
            } else if (Integer.valueOf(num) >= 31 && Integer.valueOf(num) <=40){
                listView.setVisibility(View.INVISIBLE);
                bPlay.setVisibility(View.VISIBLE);
                bStop.setVisibility(View.VISIBLE);

                mediaPlayer = (MediaPlayer) MediaPlayer.create(this, getResources().getIdentifier(lessonNo, "raw", getPackageName()));

            } else if (Integer.valueOf(num) >= 41 && Integer.valueOf(num) <=50){
                listView.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);
                InputStream is2 = getResources().openRawResource(R.raw.lesson21);;
                if (lessonNo.equals("lesson41")) {
                    is2 = getResources().openRawResource(R.raw.lesson41);
                } else if (lessonNo.equals("lesson42")) {
                    is2 = getResources().openRawResource(R.raw.lesson42);
                }else if (lessonNo.equals("lesson43")) {
                    is2 = getResources().openRawResource(R.raw.lesson43);
                }else if (lessonNo.equals("lesson44")) {
                    is2 = getResources().openRawResource(R.raw.lesson44);
                }else if (lessonNo.equals("lesson45")) {
                    is2 = getResources().openRawResource(R.raw.lesson45);
                }else if (lessonNo.equals("lesson46")) {
                    is2 = getResources().openRawResource(R.raw.lesson46);
                }else if (lessonNo.equals("lesson47")) {
                    is2 = getResources().openRawResource(R.raw.lesson47);
                }else if (lessonNo.equals("lesson48")) {
                    is2 = getResources().openRawResource(R.raw.lesson48);
                }else if (lessonNo.equals("lesson49")) {
                    is2 = getResources().openRawResource(R.raw.lesson49);
                }else if (lessonNo.equals("lesson50")) {
                    is2 = getResources().openRawResource(R.raw.lesson50);
                }
                BufferedReader br2 = new BufferedReader(new InputStreamReader(is2));
                String line2;
                String entireFile2 = "";
                try {
                    while((line2 = br2.readLine()) != null) {
                        entireFile2 += (line2 + "\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                textView.setText(entireFile2);
            } else {
                mediaPlayer = (MediaPlayer) MediaPlayer.create(this, getResources().getIdentifier(lessonNo, "raw", getPackageName()));
                mediaPlayer.start();
            }
        }
    }

    public void Play(View view){
        boolean b = true;
        if (bPlay.getText().equals("Play") && b == true) {
            mediaPlayer.start();
            bPlay.setText("Pause");
            b = false;
        } else if (bPlay.getText().equals("Pause")) {
            x = mediaPlayer.getCurrentPosition();
            mediaPlayer.pause();
            bPlay.setText("Resume");
            b = false;
        } else if (bPlay.getText().equals("Resume") && b == true) {
            mediaPlayer.seekTo(x);
            mediaPlayer.start();
            bPlay.setText("Pause");
            b = false;
        }
    }
    public ArrayList<String> getArray() {
        SharedPreferences sp = this.getSharedPreferences(DashBoard.data+String.valueOf(signUp.i), Activity.MODE_PRIVATE);
        Set<String> set = sp.getStringSet("list",  null);
        return new ArrayList<String>(set);
    }
}
