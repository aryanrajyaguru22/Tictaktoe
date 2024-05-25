 package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
      //active plaver
     // 0 = x
     //1 = o
     int activeplayer = 1;

     // stores which playes has won the game. if 2 than no one
     boolean won = false;
//     game state
//     0 = x
//     1 = o
//     2 = null
     int[] gamestate = {2, 2, 2, 2, 2, 2, 2, 2, 2};
//     this are the winning possions
     int[][] winpos = {{0,1,2}, {3,4,5} ,{6,7,8}
                        ,{0,3,6} ,{1,4,7} ,{2,5,8}
                        ,{0,4,8} ,{2,4,6}};
     boolean active = true;

     boolean istai = false;
    public void playertap(View view)
    {
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.status);
        if(!active)
        {
            reset(view);
            return;
        }
        if (gamestate[tappedimage]==2)
        {
            gamestate[tappedimage] = activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer==0)
            {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
                status.setText("O's turn - tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
                status.setText("X's turn - tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        // check for winner
        for(int[] winpos:winpos)
        {
            if(gamestate[winpos[0]]==gamestate[winpos[1]] && gamestate[winpos[1]]==gamestate[winpos[2]] && gamestate[winpos[0]]!=2)
            {
                String windisplay;
                active = false;
                if (gamestate[winpos[0]]==0)
                {
                    windisplay = "Winner of the game is X.";
                    won = true;
                }
                else
                {
                    windisplay = "Winner of the game is O.";
                    won = true;
                }
                status.setText(windisplay);
            }
        }
        int[] tai= gamestate;
        istai = linearSearch(gamestate,2);
        if(!istai && won==false)
        {
            status.setText("Game is tie between X and O");
            active = false;
        }

        
    }
    public void reset(View v)
    {
        TextView status = findViewById(R.id.status);
        active = true;
        activeplayer = 1;
        won=false;
        for (int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        status.setText("Let\'s play please tap to play.");
    }
     public static boolean linearSearch(int[] arr, int key){
         for(int i=0;i<arr.length;i++){
             if(arr[i] == key){
                 return true;
             }
         }
         return false;
     }



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}