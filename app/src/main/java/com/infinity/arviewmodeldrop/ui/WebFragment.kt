package com.infinity.arviewmodeldrop.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.infinity.arviewmodeldrop.databinding.FragmentWebBinding
import kotlinx.android.synthetic.main.fragment_web.*

class WebFragment : Fragment() {
    private var _binding: FragmentWebBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.webView.webViewClient = WebViewClient()

        // this will load the url of the website
        webView.loadUrl("https://jurnal.syntaxliterate.co.id/index.php/syntax-literate/article/view/7566/4748")

        // this will enable the javascript settings
        webView.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        webView.settings.setSupportZoom(true)
    }

//    // if you press Back button this code will work
//    fun onBackPressed() {
//        // if your webview can go back it will go back
//        if (webView.canGoBack())
//            webView.goBack()
//        // if your webview cannot go back
//        // it will exit the application
//        else
//            super.onBackPressed()
//    }
//    }
}