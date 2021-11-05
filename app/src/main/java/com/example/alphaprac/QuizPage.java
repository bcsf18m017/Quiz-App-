package com.example.alphaprac;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizPage extends AppCompatActivity {




    String questions[],keys[],answers[],options[];
    int randomGenerated[];
    int randomIndex=0;
    List<Integer> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page2);
        list=new ArrayList<Integer>();
        list.add(0);
        setQuestions();
        setOptions();
        setKeys();

    }



    public int genrateRandom()
    {
        Random random=new Random();
        int temp=random.nextInt(26)+1;
        while(list.contains(temp))
        {
            temp=random.nextInt(26)+1;
        }
        list.add(temp);
        return temp;
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
        keys[11]="Sky Alphabet";
        keys[12]="Sky Alphabet";
        keys[13]="Grass Alphabet";
        keys[14]="Grass Alphabet";
        keys[15]="Grass Alphabet";
        keys[16]="Root Alphabet";
        keys[17]="Root Alphabet";
        keys[18]="Grass Alphabet";
        keys[19]="Grass Alphabet";
        keys[20]="Sky Alphabet";
        keys[21]="Grass Alphabet";
        keys[22]="Grass Alphabet";
        keys[23]="Grass Alphabet";
        keys[24]="Root Alphabet";
        keys[25]="Grass Alphabet";
    }

}