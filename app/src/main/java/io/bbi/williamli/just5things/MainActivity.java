package io.bbi.williamli.just5things;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final ImageView launchButton01 = (ImageView) findViewById(R.id.launchButton01);
        final ImageView launchButton02 = (ImageView) findViewById(R.id.launchButton02);
        final ImageView launchButton03 = (ImageView) findViewById(R.id.launchButton03);
        final ImageView launchButton04 = (ImageView) findViewById(R.id.launchButton04);
        final ImageView launchButton05 = (ImageView) findViewById(R.id.launchButton05);

        launchButton01.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                launchFragment(1);

            }
        });

        launchButton02.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                launchFragment(2);

            }
        });

        launchButton03.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                launchFragment(3);

            }
        });

        launchButton04.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                launchFragment(4);

            }
        });

        launchButton05.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                launchFragment(5);

            }
        });



    }

    private void launchFragment(int fragNumber) {

        Intent intent;


        switch(fragNumber){
            case 1:
                intent = new Intent(this, ScrollingActivity01.class);
                break;
            case 2:
                intent = new Intent(this, ScrollingActivity02.class);
                break;
            case 3:
                intent = new Intent(this, ScrollingActivity03.class);
                break;
            case 4:
                intent = new Intent(this, ScrollingActivity04.class);
                break;
            default:
                intent = new Intent(this, ScrollingActivity05.class);

        }

        startActivity(intent);


    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
