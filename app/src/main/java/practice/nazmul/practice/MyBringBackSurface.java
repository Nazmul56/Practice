package practice.nazmul.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by nazmul on 8/26/15.
 */
public class MyBringBackSurface extends SurfaceView implements Runnable{
    SurfaceHolder ourHolder;
    Thread ourThread = null;
    boolean isRunning = true;
    public MyBringBackSurface(Context context) {
        super(context);
        ourHolder =getHolder();
        ourThread = new Thread(this);
        ourThread.start();

    }
    public void run(){

        while(isRunning){
            if(!ourHolder.getSurface().isValid())
                continue;

            Canvas canvas = ourHolder.lockCanvas();
            canvas.drawRGB(02,02,150);
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }
}
