package com.example.junior.volleyapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.junior.volleyapp.conexao.CustomJsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Principal extends Activity {

    private ImageButton     imageButton;
    private TextView        txtLogin;
    private TextView        pswSenha;
    private ProgressDialog  progressDialog;
    private Map<String,String> params;
    //private String url = "http://192.168.43.213/nef/noivosemfesta/index.php";
    private String url = "http://192.168.56.1/nef/noivosemfesta/index.php";
    private RequestQueue rq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtLogin = (TextView) findViewById(R.id.txtLogin);
        pswSenha = (TextView) findViewById(R.id.txtSenha);

        rq = Volley.newRequestQueue(Principal.this);

        imageButton =(ImageButton) findViewById(R.id.sendUser);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    viaJsonObjectPOST();
                } catch (Exception e) {
                    Log.i("ERRO PRINCIPAL->",e.toString());
                }

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

    private void mudaTela(String id, String login) throws Exception{
        Intent intent = new Intent(Principal.this, SalaUsuario.class);
        intent.putExtra("id",id);
        intent.putExtra("login",login);
        startActivity(intent);

    }
public void viaJsonObjectPOST() throws  Exception{
    params = new HashMap<String, String>();
    params.put("nome",txtLogin.getText().toString());
    params.put("senha",pswSenha.getText().toString());

     progressDialog = ProgressDialog.show(Principal.this,"Logando","AGURADE...",true,true);
        CustomJsonObjectRequest jor = new CustomJsonObjectRequest(
                Request.Method.POST,url+"/inicio/post/jor",params,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                progressDialog.dismiss();

                try {
                    mudaTela(jsonObject.getString("id"),jsonObject.getString("login"));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                Log.i("ERRO URLCONTROLER ",volleyError.toString());

            }
        });

        jor.setTag("LOGIN");
        rq.add(jor);
    }

}
