package com.example.administrator.sudoku1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 19/2/2558.
 */
public class table extends ActionBarActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);



            RelativeLayout RL =  (RelativeLayout)findViewById(R.id.MainL);
            //LinearLayout layout = (LinearLayout) findViewById(R.id.info);


            for (int i = 0 ; i < 9 ; i++) {
                for(int j=0;j<9;j++) {
                    EditText valueTV = new EditText(this);

                    valueTV.setTextSize(10);
                    valueTV.setText(" ");
                    valueTV.setId(i);
                    valueTV.setTextColor(Color.BLACK);





                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(70, 70);


                    layoutParams.setMargins(i*70,j*70,0,0);

                    valueTV.setBackgroundColor(Color.WHITE);

                    if(j%2==0) {
                        if (i % 2 == 0)
                            valueTV.setBackgroundColor(Color.WHITE);
                        else
                            valueTV.setBackgroundColor(Color.YELLOW);
                    }
                    else {
                        if (i % 2 == 0)
                            valueTV.setBackgroundColor(Color.YELLOW);
                        else
                            valueTV.setBackgroundColor(Color.WHITE);
                    }
                    valueTV.setGravity(Gravity.CENTER);
                    // valueTV.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                    valueTV.setPadding(0,0,0,0);
                    valueTV.setLayoutParams(layoutParams);


                    RL.addView(valueTV);

                }
            }


            return true;
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


