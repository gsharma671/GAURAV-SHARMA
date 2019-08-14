package c.example.gauravsharma.gae;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button button;
    int score=0;
    int noofques=0;
    TextView scorecard;
    TextView show;
    ArrayList<Integer>answers=new ArrayList<Integer>();
    Button BU1;
    Button BU2;
    Button BU3;
    Button BU4;
     TextView text;
    int locationofcorrect;
    TextView timer;

    public void generate(){
        Random rand=new Random();
        int a=rand.nextInt(21);
        int b=rand.nextInt(10);
        text.setText(Integer.toString(a)+"+"+Integer.toString(b));
        locationofcorrect=rand.nextInt(4);
        for(int i=0;i<4;i++){
            if(i==locationofcorrect){
                answers.add(a+b);
            }
            else {
                answers.add(rand.nextInt(41));
            }
        }

        BU1.setText(Integer.toString(answers.get(0)));
        BU2.setText(Integer.toString(answers.get(1)));
        BU3.setText(Integer.toString(answers.get(2)));
        BU4.setText(Integer.toString(answers.get(3)));




    }
    public void clickFunction(View view) {
        button.setVisibility(View.INVISIBLE);

    }
    public void choice(View view){

        if(view.getTag().toString().equals(Integer.toString(locationofcorrect))){
          score++;
          noofques++;
          scorecard.setText(Integer.toString(score)+"/"+Integer.toString(noofques));
          show.setText("correct!");

          }
          else {
            noofques++;
            scorecard.setText(Integer.toString(score)+"/"+Integer.toString(noofques));
            show.setText("wrong!");
        }
        generate();
    }

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
             text=(TextView)findViewById(R.id.ques);
            scorecard=(TextView)findViewById(R.id.textView2);
             show=(TextView)findViewById(R.id.textView4);

             BU1=(Button)findViewById(R.id.button2);
             BU2=(Button)findViewById(R.id.button3);
             BU3=(Button)findViewById(R.id.button4);
             BU4=(Button)findViewById(R.id.button6);
             timer=(TextView)findViewById(R.id.textView);
            generate();
            new CountDownTimer(30100, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timer.setText(String.valueOf(millisUntilFinished/1000));
                }

                @Override
                public void onFinish() {
                show.setText("finish");
                timer.setText("0s");
                }
            }.start();





        }
}
