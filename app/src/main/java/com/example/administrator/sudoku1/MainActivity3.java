package com.example.administrator.sudoku1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.CharArrayWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import android.view.ContextMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;



public class MainActivity3 extends ActionBarActivity {
    Handler handler = new Handler();
    Timer timer = new Timer();
    TimerTask timetask;
    long starttime = 0L;
    int seconds = 0;
    int pause=0;
    static int [][] model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        Intent model = this.getIntent();
        int[] input = model.getIntArrayExtra("value");
        fromPuzzleString(input);
        //Button btn = (Button) findViewById(R.id.pauseclick);
       // registerForContextMenu(btn);
        starttime=SystemClock.uptimeMillis();
        //handler.postDelayed(updateTimerThread, 0);
         doTask();

    }

    public void doTask() {

        timetask = new TimerTask() {

                public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        if(pause==0) {
                            seconds++;
                        }

                        //long millis = SystemClock.uptimeMillis() - starttime;
                        //int seconds = (int) (millis / 1000);

                        int minutes = seconds / 60;
                        seconds = seconds % 60;


                        TextView result = (TextView) findViewById(R.id.txtResult);
                        result.setText(String.format("%02d:%02d", minutes, seconds));

                    }

                });

            }
        };

        timer.schedule(timetask, 0, 1000); // Every 1 second


    }
   public void PauseonClicked(View view){


       if(pause ==0) {
           pause = 1;
       }

   }
   // @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo)
//    {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        menu.setHeaderTitle("Select The Action");
//        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title
//        menu.add(0, v.getId(), 0, "SMS");
//    }
//    @Override
//    public boolean onContextItemSelected(MenuItem item){
//        if(item.getTitle()=="Call"){
//            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
//        }
//        else if(item.getTitle()=="SMS"){
//            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();
//        }else{
//            return false;
//        }
//        return true;
//    }


  //  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        RelativeLayout RL = (RelativeLayout) findViewById(R.id.MainL);
        //LinearLayout layout = (LinearLayout) findViewById(R.id.info);


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                EditText valueTV = new EditText(this);

                valueTV.setTextSize(15);
                if(model[i][j]!=0){
                  valueTV.setText(Integer.toString(model[i][j]));
                }
                else{
                    valueTV.setText(" ");
                }
                valueTV.setId(i);
                valueTV.setTextColor(Color.BLACK);


                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(70, 70);

                if(i==0 && j==0){
                    layoutParams.setMargins(40,150,0,0);

                }
                else
                    //left top right bottom
                    layoutParams.setMargins((i*70)+40,(j*70)+150,0,0);



                if(j%2==0) {
                    if (i % 2 == 0) {
                        valueTV.setTextColor(Color.BLACK);
                        valueTV.setBackgroundColor(Color.WHITE);

                    }else{
                        valueTV.setTextColor(Color.WHITE);
                        valueTV.setBackgroundColor(Color.DKGRAY);
                    }
                }
                else {
                    if (i % 2 == 0) {
                        valueTV.setTextColor(Color.WHITE);
                        valueTV.setBackgroundColor(Color.DKGRAY);
                    } else {
                        valueTV.setTextColor(Color.BLACK);
                        valueTV.setBackgroundColor(Color.WHITE);

                    }
                }
                valueTV.setGravity(Gravity.CENTER);
                // valueTV.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                valueTV.setPadding(0, 0, 0, 0);
                valueTV.setLayoutParams(layoutParams);


                RL.addView(valueTV);

            }
        }


        return true;
    }

    public void fromPuzzleString(int[] str) {
        int[][] puz = new int[9][9];
        int k=0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                puz[i][j] = str[k];
                k++;

           }

        }
        model = puz;

   }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
