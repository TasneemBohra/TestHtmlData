package com.tasneembohra.texthtmldata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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
                String text = editText.getText().toString().replace("<font", "<customFont");
                text = text.replace("</font>", "</customFont>");
                SpannableString spannableContent = new SpannableString(Html.fromHtml(text, null, new HtmlTagHandler()));
                textView.setText(spannableContent);
                //replaceFontSpan(spannableContent)
                webView.loadDataWithBaseURL(null, editText.getText().toString(), "text/html", "UTF-8", null);
            }
        });
    }


    public static Spannable replaceFontSpan(Spannable spannable) {
        try {
            ForegroundColorSpan[] foregroundColorSpans = spannable.getSpans(0, spannable.length(), ForegroundColorSpan.class);
            for (ForegroundColorSpan span : foregroundColorSpans) {
                int start = spannable.getSpanStart(span);
                int end = spannable.getSpanEnd(span);
                int flags = spannable.getSpanFlags(span);
                spannable.setSpan(new RelativeSizeSpan(3f), start, end, flags);
            }
            TextAppearanceSpan[] textAppearanceSpen = spannable.getSpans(0, spannable.length(), TextAppearanceSpan.class);
            for (TextAppearanceSpan span : textAppearanceSpen) {
                int start = spannable.getSpanStart(span);
                int end = spannable.getSpanEnd(span);
                int flags = spannable.getSpanFlags(span);
                spannable.setSpan(new RelativeSizeSpan(3f), start, end, flags);
            }
            TypefaceSpan[] typefaceSpen = spannable.getSpans(0, spannable.length(), TypefaceSpan.class);
            for (TypefaceSpan span : typefaceSpen) {
                int start = spannable.getSpanStart(span);
                int end = spannable.getSpanEnd(span);
                int flags = spannable.getSpanFlags(span);
                spannable.setSpan(new RelativeSizeSpan(3f), start, end, flags);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
        return spannable;
    }
}
