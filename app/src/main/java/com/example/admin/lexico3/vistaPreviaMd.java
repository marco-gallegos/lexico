package com.example.admin.lexico3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class vistaPreviaMd extends AppCompatActivity {
    WebView renderizador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_previa_md);
        renderizador = (WebView) findViewById(R.id.renderizador);
        renderizador.loadDataWithBaseURL("",getIntent().getExtras().getString("htmlText"),"text/html","UTF-8","");
    }
}
