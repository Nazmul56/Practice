package practice.nazmul.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by nazmul on 8/24/15.
 */
public class Splash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);


        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent openStartingPoint = new Intent("practice.nazmul.practice.STRTINGPOINT");

                    startActivity(openStartingPoint);

                }
            }
        };

        timer.start();

        //
    }
}
