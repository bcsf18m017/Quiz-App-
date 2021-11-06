package com.example.alphaprac;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizPage extends AppCompatActivity {


    CountDownTimer timer;
    ProgressBar bar;
    Button next,finish,option1,option2,option3;
    TextView name,statement;
    String questions[],keys[],answers[],options[];
    boolean isAnswered=false;
    int score=0,count=0,upperBound=25,currentQuestion=0;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page2);
        name=(TextView)findViewById(R.id.name);
        statement=(TextView)findViewById(R.id.question);
        next=(Button)findViewById(R.id.next);
        finish=(Button)findViewById(R.id.Finish);
        option1=(Button)findViewById(R.id.option1);
        option2=(Button)findViewById(R.id.option2);
        option3=(Button)findViewById(R.id.option3);
        bar=(ProgressBar)findViewById(R.id.progressBar);
        Intent intent=getIntent();
        name.setText(name.getText().toString()+intent.getStringExtra("Username"));
        setQuestions();
        setOptions();
        setKeys();

        genrateRandom();
        updateQuestion();
        swap(currentQuestion,upperBound-count);
        count++;
        final int[] i = {0};
        timer=new CountDownTimer(132000,7800) {
            @Override
            public void onTick(long millisUntilFinished) {
                i[0]++;
                bar.setProgress((int) i[0]);
            }

            @Override
            public void onFinish() {
                i[0]++;
                bar.setProgress(100);
                Dialog dialog=new Dialog(QuizPage.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setContentView(R.layout.timeoutdialog);
                dialog.show();
                dialog.findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(QuizPage.this,FirstPage.class);
                        startActivity(intent);
                    }
                });
            }
        };
        timer.start();
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count<25)
                {
                    new AlertDialog.Builder(QuizPage.this).setIcon(R.drawable.ic_baseline_warning_24)
                            .setTitle("You Have Not Answered All The Questions")
                            .setMessage("Do You Still Want To Proceed")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                        }
                    }).setNeutralButton("Help", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(QuizPage.this,"Press Yes to Exit Quiz",Toast.LENGTH_SHORT).show();
                        }
                    }).show();
                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enable();
                resetColour();
                if(count==25)
                {
                    Toast.makeText(v.getContext(),"finish",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    genrateRandom();
                    updateQuestion();
                    swap(currentQuestion,upperBound-count);
                    count++;

                }
            }
        });
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                disable();
                int correct=getCorrectButton();
                Log.d("NOMAN",Integer.toString(correct));
                if(correct==1)
                {
                    option1.setBackgroundColor(getResources().getColor(R.color.green));
                    score++;
                }
                else
                {
                    if(correct==2)
                    {
                        option1.setBackgroundColor(getResources().getColor(R.color.red));
                        option2.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                    else
                    {
                        if(correct==3)
                        {
                            option1.setBackgroundColor(getResources().getColor(R.color.red));
                            option3.setBackgroundColor(getResources().getColor(R.color.green));
                        }
                    }
                }
            }
        });
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disable();
                int correct=getCorrectButton();
                Log.d("LOGG",Integer.toString(correct));
                if(correct==2)
                {
                    option2.setBackgroundColor(getResources().getColor(R.color.green));
                    score++;
                }
                else
                {
                    if(correct==1)
                    {
                        option2.setBackgroundColor(getResources().getColor(R.color.red));
                        option1.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                    else
                    {
                        if(correct==3)
                        {
                            option2.setBackgroundColor(getResources().getColor(R.color.red));
                            option3.setBackgroundColor(getResources().getColor(R.color.green));
                        }
                    }
                }
            }
        });
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disable();
                int correct=getCorrectButton();
                Log.d("LOGG",Integer.toString(correct));
                if(correct==3)
                {
                    option3.setBackgroundColor(getResources().getColor(R.color.green));
                    score++;
                }
                else
                {
                    if(correct==2)
                    {
                        option3.setBackgroundColor(getResources().getColor(R.color.red));
                        option2.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                    else
                    {
                        if(correct==1)
                        {
                            option3.setBackgroundColor(getResources().getColor(R.color.red));
                            option1.setBackgroundColor(getResources().getColor(R.color.green));
                        }
                    }
                }
            }
        });
    }


    public int getCorrectButton()
    {
        if(option1.getText().toString().equals(keys[currentQuestion]))
        {
            return 1;
        }
        if(option2.getText().toString().equals(keys[currentQuestion]))
        {
            return 2;
        }
        if(option3.getText().toString().equals(keys[currentQuestion]))
        {
            return 3;
        }
        return 0;
    }


    public void updateQuestion()
    {
        statement.setText(questions[currentQuestion]);
        Random rand=new Random();
        int temp=rand.nextInt(100);
        if(temp%2==0)
        {
            option1.setText(options[0]);
            option2.setText(options[2]);
            option3.setText(options[1]);
        }
        else
        {
            option1.setText(options[2]);
            option2.setText(options[1]);
            option3.setText(options[0]);
        }
    }

    public void disable()
    {
        option1.setClickable(false);
        option2.setClickable(false);
        option3.setClickable(false);
    }
    public void enable()
    {
        option1.setClickable(true);
        option2.setClickable(true);
        option3.setClickable(true);
    }
    public void resetColour()
    {
        option1.setBackgroundColor(getResources().getColor(R.color.white));
        option2.setBackgroundColor(getResources().getColor(R.color.white));
        option3.setBackgroundColor(getResources().getColor(R.color.white));
    }
    public void swap(int i,int j)
    {
        String q=questions[i];
        questions[i]=questions[j];
        questions[j]=q;
    }

    public void genrateRandom()
    {
        Random random=new Random();
        int temp=random.nextInt(upperBound-count);
        currentQuestion=temp;
    }
    public void setOptions()
    {
        options=new String[3];
        options[0]="Grass Alphabet";
        options[1]="Sky Alphabet";
        options[2]="Root Alphabet";
    }
    public void setQuestions()
    {
        questions=new String[26];
        questions[0]=" Alphabet "+'"'+"a"+'"'+"belongs to Which  Category" ;
        questions[1]=" Alphabet "+'"'+"b"+'"'+"belongs to Which  Category" ;
        questions[2]=" Alphabet "+'"'+"c"+'"'+"belongs to Which  Category" ;
        questions[3]=" Alphabet "+'"'+"d"+'"'+"belongs to Which  Category" ;
        questions[4]=" Alphabet "+'"'+"e"+'"'+"belongs to Which  Category" ;
        questions[5]=" Alphabet "+'"'+"f"+'"'+"belongs to Which  Category" ;
        questions[6]=" Alphabet "+'"'+"g"+'"'+"belongs to Which  Category" ;
        questions[7]=" Alphabet "+'"'+"h"+'"'+"belongs to Which  Category" ;
        questions[8]=" Alphabet "+'"'+"i"+'"'+"belongs to Which  Category" ;
        questions[9]=" Alphabet "+'"'+"j"+'"'+"belongs to Which  Category" ;
        questions[10]="Alphabet "+'"'+"k"+'"'+"belongs to Which  Category" ;
        questions[11]="Alphabet "+'"'+"l"+'"'+"belongs to Which  Category" ;
        questions[12]="Alphabet "+'"'+"m"+'"'+"belongs to Which  Category" ;
        questions[13]="Alphabet "+'"'+"n"+'"'+"belongs to Which  Category" ;
        questions[14]="Alphabet "+'"'+"o"+'"'+"belongs to Which  Category" ;
        questions[15]="Alphabet "+'"'+"p"+'"'+"belongs to Which  Category" ;
        questions[16]="Alphabet "+'"'+"q"+'"'+"belongs to Which  Category" ;
        questions[17]="Alphabet "+'"'+"r"+'"'+"belongs to Which  Category" ;
        questions[18]="Alphabet "+'"'+"s"+'"'+"belongs to Which  Category" ;
        questions[19]="Alphabet "+'"'+"t"+'"'+"belongs to Which  Category" ;
        questions[20]="Alphabet "+'"'+"u"+'"'+"belongs to Which  Category" ;
        questions[21]="Alphabet "+'"'+"v"+'"'+"belongs to Which  Category" ;
        questions[22]="Alphabet "+'"'+"w"+'"'+"belongs to Which  Category" ;
        questions[23]="Alphabet "+'"'+"x"+'"'+"belongs to Which  Category" ;
        questions[24]="Alphabet "+'"'+"y"+'"'+"belongs to Which  Category" ;
        questions[25]="Alphabet "+'"'+"z"+'"'+"belongs to Which  Category" ;
    }
    public void setKeys()
    {
        keys=new String[26];
        keys[0]="Grass Alphabet";
        keys[1]="Sky Alphabet";
        keys[2]="Grass Alphabet";
        keys[3]="Sky Alphabet";
        keys[4]="Grass Alphabet";
        keys[5]="Sky Alphabet";
        keys[6]="Root Alphabet";
        keys[7]="Sky Alphabet";
        keys[8]="Grass Alphabet";
        keys[9]="Root Alphabet";
        keys[10]="Sky Alphabet";
        keys[11]="Sky Alphabet";
        keys[12]="Grass Alphabet";
        keys[13]="Grass Alphabet";
        keys[14]="Grass Alphabet";
        keys[15]="Root Alphabet";
        keys[16]="Root Alphabet";
        keys[17]="Grass Alphabet";
        keys[18]="Grass Alphabet";
        keys[19]="Sky Alphabet";
        keys[20]="Grass Alphabet";
        keys[21]="Grass Alphabet";
        keys[22]="Grass Alphabet";
        keys[23]="Grass Alphabet";
        keys[24]="Root Alphabet";
        keys[25]="Grass Alphabet";
    }

}