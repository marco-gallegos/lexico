package com.example.admin.lexico3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText md;
    TextView out;
    FloatingActionButton fab;

    String ttraducido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        md = (EditText) findViewById(R.id.md);
        out = (TextView) findViewById(R.id.out);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String texto = md.getText().toString();
                char a='\0';
                if (texto.length() >0){
                    a = texto.charAt(0);
                }
                int i=0;
                ttraducido = "";

                while (i < texto.length()){
                    if(a == '\n'){
                        ttraducido += a;
                        i++;
                        a= texto.charAt(i);
                    }
                    if(a == '#'){
                        ttraducido += "<h1>";
                        i++;
                        while(a != '\n' && i < texto.length()){
                            a= texto.charAt(i);
                            ttraducido += a;
                            i++;
                        }
                        if(a == '\n'){
                            a= texto.charAt(i);
                        }
                        ttraducido += "</h1>";
                    }
                    if (a == '*'){
                        ttraducido += "<ul><li>";
                        i++;
                        while(a != '\n' && i < texto.length()){
                            a= texto.charAt(i);
                            ttraducido += a;
                            i++;
                        }
                        if(a == '\n'){
                            a= texto.charAt(i);
                        }
                        ttraducido += "</li></ul>";
                    }
                    else{
                        ttraducido += "<p>";

                        while(a != '\n' && i < texto.length()){
                            a= texto.charAt(i);
                            ttraducido += a;
                            i++;
                        }
                        if(a == '\n'){
                            a= texto.charAt(i);
                        }

                        ttraducido += "</p>";
                    }
                }

                out.setText(ttraducido);

                Intent preview = new Intent(getApplicationContext(),vistaPreviaMd.class);
                preview.putExtra("htmlText",ttraducido);
                startActivity(preview);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
