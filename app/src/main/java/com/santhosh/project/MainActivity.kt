package com.santhosh.project

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.SearchView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var searchView: SearchView? = null
    var webView: WebView? = null
    var progressBar: ProgressBar? = null
//    var mainScreen: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchView = findViewById(R.id.searchView)
        webView = findViewById(R.id.webView)
        progressBar = findViewById(R.id.progress_bar)

        webView!!.settings.javaScriptEnabled = true
        webView!!.webViewClient = WebViewClient()
    }

    fun imageClicked(view: View) {
        var id = view.id
        var ourId: String? = ""



        if (isInternetConnected()) {
            ourId = view.resources.getResourceEntryName(id)
            webView?.loadUrl("https://www." + ourId + ".com")
            webView!!.visibility = View.VISIBLE
            mainScreen!!.visibility = View.GONE
        } else {
            Toast.makeText(
                this,
                "Oops!! There is no internet connection. Please enable your internet connection.",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

    fun iconClicked(view: android.view.View) {}


    fun isInternetConnected(): Boolean {
        val connectivityManager: ConnectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkinfo=connectivityManager.activeNetworkInfo
        if (networkinfo!=null && networkinfo!!.isConnected)
            return true
        else
            return false
    }
}