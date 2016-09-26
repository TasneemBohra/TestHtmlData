package com.tasneembohra.texthtmldata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText) findViewById(R.id.htmlEditTextView);
        final WebView webView = (WebView) findViewById(R.id.htmlWebView);
        final TextView textView = (TextView) findViewById(R.id.htmlTextView);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(Html.fromHtml(editText.getText().toString()));
                webView.loadDataWithBaseURL(null, editText.getText().toString(), "text/html", "UTF-8", null);
            }
        });
    }
}
