package com.example.junior.volleyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class SalaUsuario extends Activity {
    private View viewContainer;
    String login, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_usuario);
        ListView l = (ListView) findViewById(R.id.listview);
        String[] values = new String[] {"", "Ubuntu", "Android", "iPhone",
                "Windows", "Ubuntu", "Android", "iPhone", "Windows","Ubuntu", "Android", "iPhone",
                "Windows", "Ubuntu", "Android", "iPhone", "Windows"  };
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>( this,
                android.R.layout.simple_list_item_1, values);
        viewContainer = findViewById(R.id.undobar);
        l.setAdapter(adapter);
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = (String) adapterView.getAdapter().getItem(i);
                Toast.makeText(SalaUsuario.this,"Item Clicado" + item,Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        login = intent.getStringExtra("login");

        TextView txtLOGIN = (TextView) findViewById(R.id.txtLogin);
        txtLOGIN.setText("Pedidos - "+ login);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sala_usuario, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        showUndo(viewContainer);
        return true;
    }
    public void onClick(View view) {
        Toast.makeText( this , "Deletion undone", Toast.LENGTH_LONG).show();
        viewContainer.setVisibility(View.GONE);
    }
    public static void showUndo( final View viewContainer) {
        viewContainer.setVisibility(View.VISIBLE);
        viewContainer.setAlpha(1);
        viewContainer.animate().alpha(0.4f).setDuration(5000)
                .withEndAction( new Runnable() {
                    @Override
                    public void run() {
                        viewContainer.setVisibility(View.GONE);
                    }
                });
    }
}