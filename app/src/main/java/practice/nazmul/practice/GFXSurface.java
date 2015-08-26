package practice.nazmul.practice;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by nazmul on 8/26/15.
 */
public class GFXSurface extends Activity {
    MyBringBackSurface ourSurfaceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourSurfaceView = new MyBringBackSurface(this);
        setContentView(ourSurfaceView);


    }


}
