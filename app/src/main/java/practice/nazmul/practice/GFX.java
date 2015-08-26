package practice.nazmul.practice;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by nazmul on 8/26/15.
 */
public class GFX extends Activity{
    MyBringBack ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourView = new MyBringBack(this);
        setContentView(ourView);

    }
}
