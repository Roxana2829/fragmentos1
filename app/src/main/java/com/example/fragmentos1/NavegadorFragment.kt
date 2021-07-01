package com.example.fragmentos1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText


private const val DEFAULT_URL = "urlPorDefault"

/**
 * A simple [Fragment] subclass.
 * Use the [navegadorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NavegadorFragment : Fragment() {

    private var url: String? = null
    lateinit var wvNavegador:WebView
    lateinit var btnIr:Button
    lateinit var etUrl:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            url = it.getString(DEFAULT_URL)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        Log.d("url:",url!!)
        // Inflate the layout for this fragment
        val vistaNavegador = inflater.inflate(R.layout.fragment_navegador, container, false)

        wvNavegador = vistaNavegador.findViewById(R.id.wvNavegador)
        btnIr = vistaNavegador.findViewById(R.id.btnIr)
        etUrl = vistaNavegador.findViewById(R.id.etUrl)

        val webSettings = wvNavegador.settings
        webSettings.javaScriptEnabled = true
        wvNavegador.webViewClient = object : WebViewClient(){

        }

        wvNavegador.loadUrl(url!!)


        btnIr.setOnClickListener {
            url = etUrl.text.toString().trim()
            if (!url!!.isEmpty()){
                if (url!!.endsWith(".com")) {
                    url = "https//" + url
                    wvNavegador.loadUrl(url!!)
                }else{
                    url = "https://www.google.com/search?q="+etUrl.text.toString().trim()
                    wvNavegador.loadUrl(url!!)
                }
            }

        }

        return vistaNavegador
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param url por default.
         * @return A new instance of fragment NavegadorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(urlPorDefailt: String) =
                NavegadorFragment().apply {
                    arguments = Bundle().apply {
                        putString(DEFAULT_URL, urlPorDefailt)
                    }
                }
    }
}