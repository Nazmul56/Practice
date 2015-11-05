package practice.nazmul.practice;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by nazmul on 11/5/15.
 */
public class SimpleBrowser extends Activity implements View.OnClickListener {
    EditText url;
    WebView ourBrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        ourBrow = (WebView) findViewById(R.id.webView);

        ourBrow.getSettings().setJavaScriptEnabled(true);
        ourBrow.getSettings().setLoadWithOverviewMode(true);
        ourBrow.getSettings().setUseWideViewPort(true);
        ourBrow.getSettings().getDisplayZoomControls();

        ourBrow.setWebViewClient(new ourViewClient());
        try {
            ourBrow.loadUrl("http://www.google.com");
        }catch(Exception e){
            e.printStackTrace();
        }
        Button go = (Button)findViewById(R.id.bGo);
        Button back = (Button) findViewById(R.id.bBack);
        Button forward = (Button) findViewById(R.id.bForward);
        Button refresh =(Button)findViewById(R.id.bRefresh);
        Button clearHistory = (Button)findViewById(R.id.bClear);

        url = (EditText)findViewById(R.id.etURL);
        go.setOnClickListener(this);
        back.setOnClickListener(this);
        refresh.setOnClickListener(this);
        forward.setOnClickListener(this);
        clearHistory.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.bGo:
                String theWebsite  = url.getText().toString();
                ourBrow.loadUrl(theWebsite);
                //Hiding keyboard after using this
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(url.getWindowToken(),0);
                break;
            case R.id.bBack:
                if(ourBrow.canGoBack())
                ourBrow.goBack();
                break;
            case R.id.bForward:
                if(ourBrow.canGoForward())
                    ourBrow.goForward();
                break;
            case R.id.bRefresh:
                ourBrow.reload();
                break;
            case R.id.bClear:
                ourBrow.clearHistory();
                break;

        }


    }
}
