package com.example.junior.volleyapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.junior.volleyapp.conexao.CustomJsonArraytRequest;
import com.example.junior.volleyapp.conexao.CustomJsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Principal extends ActionBarActivity {

    private EditText edtNl, edtSenha;
    //private ProgressBar progressBar;
    //private  String url = "http://webserverandroid.esy.es/inicio/post/";
    //private  String url = "http://192.168.43.213/nef/noivosemfesta/index.php/inicio/post/jor";
    private  String url = "http://192.168.56.1/nef/noivosemfesta/index.php";

    private RequestQueue rq ;
    private Map<String, String> params;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        edtNl = (EditText) findViewById(R.id.edtNL);
        edtSenha = (EditText) findViewById(R.id.edtSenha);




        rq = Volley.newRequestQueue(Principal.this);





   }

    public void callByJsonObjectRequest(View view){

       /* JsonObjectRequest jor = new JsonObjectRequest(Request.Method.POST,url, null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });*/

        progressDialog = ProgressDialog.show(Principal.this,"Title","Carregando...",true);

        params = new HashMap<String, String>();

        params.put("nome",edtNl.getText().toString());
        params.put("senha",edtSenha.getText().toString());



        CustomJsonObjectRequest com = new CustomJsonObjectRequest(Request.Method.POST,
                url+"/inicio/post/jor",
                params,
                new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    try {

                        String verifica = response.getString("erro");

                        if(verifica.equals("404")){
                            progressDialog.dismiss();
                            AlertDialog.Builder alert = new AlertDialog.Builder(Principal.this);
                            alert.setTitle("ERRO :'(");
                            alert.setMessage("Usuario não encontrado\n ou não cadastrado.\n Tente denovo");
                            alert.show();
                        }else{
                            progressDialog.dismiss();
                            Log.i("LOG","LOGADO");
                            trocaTela("salaUsuario",response);

                        }

                    } catch (JSONException e) {
                        progressDialog.dismiss();
                        e.printStackTrace();
                        Log.i("Erro Json", e.getMessage());
                    } catch (Exception e) {
                        progressDialog.dismiss();
                        e.printStackTrace();
                        Log.i("Erro no metodo de troca", e.getMessage());
                    }

                }
                },
                new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {

                    progressDialog.dismiss();

                    Toast.makeText(Principal.this, "Erro volley=> "+volleyError.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        com.setTag("tag");
        rq.add(com);

    }
    public void callByJsonArraytRequest(View view){


        CustomJsonArraytRequest jar = new CustomJsonArraytRequest(Request.Method.GET,
                url+"jar/"+edtNl.getText().toString()+"/"+edtSenha.getText().toString(),
                params,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        Toast.makeText(Principal.this, "RECEBIDO: "+response,Toast.LENGTH_LONG).show();

                        Log.i("Script","Sucess=>" + response);


                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        Toast.makeText(Principal.this, "Erro=> "+volleyError.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        jar.setTag("tag");
        rq.add(jar);
    }
    public void callByStringRequest(View view){

    }

    @Override
    public  void onStop(){

        super.onStop();

    }
    public void trocaTela(String tela, JSONObject response) throws Exception{
        if(tela.equals("salaUsuario")){

            Log.i("Logado","Usuario Encontrado");

            String login = response.getString("login");
            String id = response.getString("id");

            Intent intent = new Intent(this, SalaUsuario.class);

            intent.putExtra("login", login);
            callByJsonArraytRequest2(id);

            rq.cancelAll("tag");

            startActivity(intent);

        }
    }
    public void callByJsonArraytRequest2(String id) throws Exception{

        progressDialog = ProgressDialog.show(Principal.this,"Title","Aguarde...");
        final UserCapsule pedido = new UserCapsule();



        CustomJsonArraytRequest com = new CustomJsonArraytRequest(Request.Method.GET,
                url+"/pedidos/jor/"+id,
                params,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();
                            pedido.setResponse(response);

                        } catch (Exception e) {
                            progressDialog.dismiss();
                            e.printStackTrace();
                            Log.i("Erro no metodo de troca", e.getMessage());
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {

                        progressDialog.dismiss();

                        Toast.makeText(Principal.this, "Erro volley=> "+volleyError.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        com.setTag("tag");
        rq.add(com);
    }
}
