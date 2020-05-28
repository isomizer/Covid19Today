package special.topic.covid19today.ui.chatbot;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import special.topic.covid19today.R;

public class ChatbotFragment extends Fragment {

    protected WebView webView;
    private static final String ENROLLMENT_URL = "file:///android_asset/index.html";

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chatbot, container, false);

        webView = root.findViewById(R.id.local_dialog_webview);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        refreshWebView(webView);

        return root;
    }

    public void refreshWebView(View view) {
        webView.loadUrl(ENROLLMENT_URL);
    }
}
