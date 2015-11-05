package practice.nazmul.practice;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nazmul on 11/5/15.
 */
public class ourViewClient extends WebViewClient {

    @Override
    public boolean shouldOverrideUrlLoading(WebView v, String url){
        v.loadUrl(url);
        return true;
    }
}
