package com.example.digikala.ui.screens.home

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebPageScreen(
    navController: NavHostController,
    url: String
) {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,
                )

                webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(
                        view: WebView?,
                        request: WebResourceRequest?
                    ): Boolean {
                        val requestedUrl = request?.url.toString()
                        return if (requestedUrl.startsWith("http") || requestedUrl.startsWith("https")) {
                            false // WebView خودش هندل کنه
                        } else {
                            try {
                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(requestedUrl))
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                Log.e("WebView", "Unsupported URL scheme: $requestedUrl", e)
                            }
                            true // ما هندل کردیم
                        }
                    }
                }

                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
                settings.userAgentString = System.getProperty("http.agent")
                loadUrl(url)
            }
        },
        update = {
            it.loadUrl(url)
        }
    )
}
