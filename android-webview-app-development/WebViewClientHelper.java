// File: app/src/main/java/com/fxcopytrade/app/WebViewClientHelper.java

package com.fxcopytrade.app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/**
 * WebViewClientHelper - Custom WebViewClient to handle page navigation
 * Manages page loading, errors, and external URL handling
 */
public class WebViewClientHelper extends WebViewClient {

    private Context context;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    // Domain to keep within WebView
    private static final String TARGET_DOMAIN = "fxcopytrade.online";

    /**
     * Constructor
     */
    public WebViewClientHelper(Context context, ProgressBar progressBar,
                              SwipeRefreshLayout swipeRefreshLayout) {
        this.context = context;
        this.progressBar = progressBar;
        this.swipeRefreshLayout = swipeRefreshLayout;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        return handleUrl(view, url);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return handleUrl(view, url);
    }

    /**
     * Handle URL loading logic
     * Opens external URLs in browser, keeps internal URLs in WebView
     */
    private boolean handleUrl(WebView view, String url) {
        // Handle telephone links
        if (url.startsWith("tel:")) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(url));
            context.startActivity(intent);
            return true;
        }

        // Handle email links
        if (url.startsWith("mailto:")) {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse(url));
            context.startActivity(intent);
            return true;
        }

        // Handle WhatsApp links
        if (url.startsWith("whatsapp://")) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                Toast.makeText(context, "WhatsApp not installed", Toast.LENGTH_SHORT).show();
                return true;
            }
        }

        // Handle other app-specific schemes
        if (url.startsWith("intent://") || url.startsWith("market://")) {
            try {
                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                return true;
            }
        }

        // Check if URL belongs to target domain
        if (url.contains(TARGET_DOMAIN)) {
            // Load within WebView
            view.loadUrl(url);
            return false;
        } else if (url.startsWith("http://") || url.startsWith("https://")) {
            // External URL - open in external browser
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
            return true;
        }

        // Default: load in WebView
        return false;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        
        // Show progress bar
        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(0);
        }
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        
        // Hide progress bar
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }

        // Stop swipe refresh animation
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        super.onReceivedError(view, request, error);
        
        // Handle error
        if (progressBar != null) {
            progressBar.setVisibility(View.GONE);
        }

        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }

        // Show error message
        String errorMessage = "Error loading page";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            errorMessage = "Error: " + error.getDescription();
        }
        
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadResource(WebView view, String url) {
        super.onLoadResource(view, url);
        // Called when WebView loads a resource
    }

    @Override
    public void doUpdateVisitedHistory(WebView view, String url, boolean isReload) {
        super.doUpdateVisitedHistory(view, url, isReload);
        // Called when URL is added to history
    }
}
