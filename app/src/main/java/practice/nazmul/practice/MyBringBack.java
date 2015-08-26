package practice.nazmul.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by nazmul on 8/26/15.
 */
public class MyBringBack extends View {

        Bitmap gBall;
    public MyBringBack(Context context) {   // Constructor
        super(context);
        //TODO Auto-generated constructor

        gBall = BitmapFactory.decodeResource(getResources(),R.drawable.greenball); //Declare bitmap variable


    }
// This mathod drow the bitmap
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(android.R.color.white);//
        canvas.drawBitmap(gBall,(canvas.getWidth()/2), 0,null);// set the position of image


    }
}
