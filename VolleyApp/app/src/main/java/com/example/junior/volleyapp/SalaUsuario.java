package com.example.junior.volleyapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;

import java.util.Map;


public class SalaUsuario extends ListActivity {

    private  String url = "http://192.168.42.142/nef/noivosemfesta/index.php";
    private RequestQueue rq ;
    private Map<String, String> params;
    private ProgressDialog progressDialog;
    private TextView txtP;
    private Button btnVer;

    /** Called when the activity is first created. */
    public void onCreate(Bundle icicle) {
        super .onCreate(icicle);
// create an array of Strings, that will be put to our ListActivity
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.activity_sala_usuario,
                R.id.label, values);
        setListAdapter(adapter);
    }
    @Override
     protected void onListItemClick(ListView l, View v, int position, long id){
        String item = (String) getListAdapter().getItem(position);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(item);
        alertDialog.show();

    }

}



