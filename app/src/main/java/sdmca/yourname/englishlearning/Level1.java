package sdmca.yourname.englishlearning;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Level1 extends AppCompatActivity {

    ArrayList<String> level1 = new ArrayList<String>();
    public static ArrayList<String> favourite = new ArrayList<String>();
    int ButtonId;
    ListView listView;
    EditText textView;
    Button bPlay;
    MediaPlayer mediaPlayer;
    VideoView videoView;
    int x =0 ;
    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);
        Intent intent = getIntent();
        data = intent.getStringExtra("info");
        ButtonId = intent.getIntExtra("ButtonId", 0);
        listView = (ListView) findViewById(R.id.listView);
        textView = (EditText) findViewById(R.id.editText2);
        bPlay = (Button) findViewById(R.id.button11);
        videoView = (VideoView) findViewById(R.id.videoView);
        listView.setVisibility(View.VISIBLE);
        textView.setVisibility(View.INVISIBLE);
        bPlay.setVisibility(View.INVISIBLE);
        videoView.setVisibility(View.INVISIBLE);
        if (ButtonId == 1) {
            for (int i = 1; i <= 10; i++) {
                level1.add("lesson" + i);
            }
        }
        if (ButtonId == 2) {
            for (int i = 11; i <= 20; i++) {
                level1.add("lesson" + i);
            }
        }
        if (ButtonId == 3) {
            for (int i = 21; i <= 30; i++) {
                level1.add("lesson" + i);
            }
        }
        if (ButtonId == 4) {
            for (int i = 31; i <= 40; i++) {
                level1.add("lesson" + i);
            }
        }
        if (ButtonId == 5) {
            for (int i = 41; i <= 50; i++) {
                level1.add("lesson" + i);
            }
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, level1);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlayVideo(id, ButtonId);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int pos, long id) {
                favourite.add(level1.get((int) id));
                saveArray();
                Toast.makeText(getApplicationContext(), "Added to Favourite", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }


    @Override
    public void onBackPressed() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        super.onBackPressed();
    }

    public boolean saveArray() {
        SharedPreferences sp = this.getSharedPreferences(DashBoard.data+String.valueOf(signUp.i), Activity.MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sp.edit();
        Set<String> set = new HashSet<String>();
        set.addAll(favourite);
        mEdit1.putStringSet("list", set);
        return mEdit1.commit();
    }

    public void PlayVideo(long id, int ButtonId) {
        long lessonId;
        switch (ButtonId) {
            case 1:
                lessonId = id + 1;
                String lessonName = level1.get((int) id);
                mediaPlayer = (MediaPlayer) MediaPlayer.create(this, getResources().getIdentifier(lessonName, "raw", getPackageName()));
                mediaPlayer.start();
                break;
            case 2:
                listView.setVisibility(View.INVISIBLE);
                videoView.setVisibility(View.VISIBLE);
                lessonId = id + 11;
                String lessonId2 = level1.get((int) id);
                videoView = (VideoView) findViewById(R.id.videoView);
                if (lessonId2.equals("lesson11"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson11);
                }else if (lessonId2.equals("lesson12"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson12);
                }else if (lessonId2.equals("lesson13"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson13);
                }else if (lessonId2.equals("lesson14"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson14);
                }else if (lessonId2.equals("lesson15"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson15);
                }else if (lessonId2.equals("lesson16"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson16);
                }else if (lessonId2.equals("lesson17"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson17);
                }else if (lessonId2.equals("lesson18"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson18);
                }else if (lessonId2.equals("lesson19"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson19);
                }else if (lessonId2.equals("lesson20"))
                {
                    videoView.setVideoPath("android.resource://" + getPackageName() + "/" +R.raw.lesson20);
                }
                videoView.start();
                break;
            case 3:
                lessonId = id + 21;
                listView.setVisibility(View.INVISIBLE);
                textView.setVisibility(View.VISIBLE);
                InputStream is = getResources().openRawResource(R.raw.lesson21);;
                lessonName = level1.get((int) id);
                if (lessonName.equals("lesson21")) {
                     is = getResources().openRawResource(R.raw.lesson21);
                } else if (lessonName.equals("lesson22")) {
                     is = getResources().openRawResource(R.raw.lesson22);
                }else if (lessonName.equals("lesson23")) {
                     is = getResources().openRawResource(R.raw.lesson23);
                }else if (lessonName.equals("lesson24")) {
                     is = getResources().openRawResource(R.raw.lesson24);
                }else if (lessonName.equals("lesson25")) {
                     is = getResources().openRawResource(R.raw.lesson25);
                }else if (lessonName.equals("lesson26")) {
                     is = getResources().openRawResource(R.raw.lesson26);
                }else if (lessonName.equals("lesson27")) {
                     is = getResources().openRawResource(R.raw.lesson27);
                }else if (lessonName.equals("lesson28")) {
                     is = getResources().openRawResource(R.raw.lesson28);
                }else if (lessonName.equals("lesson29")) {
                     is = getResources().openRawResource(R.raw.lesson29);
                }else if (lessonName.equals("lesson30")) {
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
                break;
                    case 4:
                        lessonId = id + 31;
                        listView.setVisibility(View.INVISIBLE);
                        lessonName = level1.get((int) id);
                        bPlay.setVisibility(View.VISIBLE);
                        mediaPlayer = (MediaPlayer) MediaPlayer.create(this, getResources().getIdentifier(lessonName, "raw", getPackageName()));
                        break;
                    case 5:
                        lessonId = id + 41;
                        listView.setVisibility(View.INVISIBLE);
                        textView.setVisibility(View.VISIBLE);
                        InputStream is2 = getResources().openRawResource(R.raw.lesson21);;
                        lessonName = level1.get((int) id);
                        if (lessonName.equals("lesson41")) {
                            is2 = getResources().openRawResource(R.raw.lesson41);
                        } else if (lessonName.equals("lesson42")) {
                            is2 = getResources().openRawResource(R.raw.lesson42);
                        }else if (lessonName.equals("lesson43")) {
                            is2 = getResources().openRawResource(R.raw.lesson43);
                        }else if (lessonName.equals("lesson44")) {
                            is2 = getResources().openRawResource(R.raw.lesson44);
                        }else if (lessonName.equals("lesson45")) {
                            is2 = getResources().openRawResource(R.raw.lesson45);
                        }else if (lessonName.equals("lesson46")) {
                            is2 = getResources().openRawResource(R.raw.lesson46);
                        }else if (lessonName.equals("lesson47")) {
                            is2 = getResources().openRawResource(R.raw.lesson47);
                        }else if (lessonName.equals("lesson48")) {
                            is2 = getResources().openRawResource(R.raw.lesson48);
                        }else if (lessonName.equals("lesson49")) {
                            is2 = getResources().openRawResource(R.raw.lesson49);
                        }else if (lessonName.equals("lesson50")) {
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
                        break;
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
    }