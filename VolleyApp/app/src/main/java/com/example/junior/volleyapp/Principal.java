package com.example.junior.volleyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Principal extends Activity {

    ImageButton imageButton;
    TextView    txtLogin;
    TextView    pswSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        pswSenha = (TextView) findViewById(R.id.txtSenha);

        imageButton =(ImageButton) findViewById(R.id.sendUser);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(Principal.this);
                alert.setTitle("ALERT");
                alert.setIcon(R.drawable.ic_account_circle_white_48dp);
                alert.setMessage("CLICADO ->"+ txtLogin.getText().toString()+" / "+pswSenha.getText().toString());
                alert.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sala_usuario, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return true;
    }

}