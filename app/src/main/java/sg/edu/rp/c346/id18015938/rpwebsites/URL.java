package sg.edu.rp.c346.id18015938.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class URL extends AppCompatActivity {

    WebView wbURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.url);

        wbURL = findViewById(R.id.WebViewURL);

        wbURL.setWebViewClient(new WebViewClient());

        Intent intendReceived = getIntent();
        String url = intendReceived.getStringExtra("url");
        wbURL.loadUrl(url);

        wbURL.getSettings().setJavaScriptEnabled(true);
        wbURL.getSettings().setAllowFileAccess(false);
        wbURL.getSettings().getBuiltInZoomControls();


    }
}
