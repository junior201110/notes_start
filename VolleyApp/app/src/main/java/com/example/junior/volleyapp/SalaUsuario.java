package com.example.junior.volleyapp;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Map;


public class SalaUsuario extends ListActivity {

    //private  String url = "http://192.168.43.213/nef/noivosemfesta/index.php/pedidos/jor/";

    String url = "http://192.168.56.1/nef/noivosemfesta/index.php/pedidos/jor";

    private RequestQueue requestQueue ;
    private Map<String, String> params;
    private ProgressDialog progressDialog;

    private  String id, login;
    private String[] values;
    private Intent intent;
    Gson json = new Gson();
    private UserCapsule pedido;





    /** Called when the activity is first created. */
    public void onCreate(Bundle icicle) {
        intent = getIntent();
        requestQueue = Volley.newRequestQueue(SalaUsuario.this);
        //id = intent.getStringExtra("id");
        //url = url +"/"+id;

        super.onCreate(icicle);
        try {

            Log.i("PEDIDO", pedido.getResponse().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    SalaUsuario.this,
                    R.layout.activity_sala_usuario,
                    R.id.label,values);
        setListAdapter(adapter);
// create an array of Strings, that will be put to our ListActivity






    }
    @Override
     protected void onListItemClick(ListView l, View v, int position, long id){
        /*String item = (String) getListAdapter().getItem(position);

        try {
            trocaTela();

        } catch (Exception e) {
            e.printStackTrace();
        }

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setMessage(item +"->"+login);
        alertDialog.show();
     */

    }
/* Funcionando Apartir daqui
    public void callByJsonArraytRequest() throws Exception{

        progressDialog = ProgressDialog.show(SalaUsuario.this,"Title","Aguarde...");



        CustomJsonArraytRequest com = new CustomJsonArraytRequest(Request.Method.GET,
                url,
                params,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            progressDialog.dismiss();

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

                        Toast.makeText(SalaUsuario.this, "Erro volley=> "+volleyError.getMessage(), Toast.LENGTH_LONG).show();

                    }
                });
        com.setTag("tag");
        requestQueue.add(com);
    }
    public void visualizaItem( JSONArray response) throws Exception{

        if(response.length() > 0){
            Log.i("OK",response.toString());
        }else {
            Log.i("ERRO","Nada RECEBIDO");
        }


    }*/

    private String[] criaLista() throws Exception{
        //Toast.makeText(SalaUsuario.this,String.valueOf(response.get(cont-1)),Toast.LENGTH_LONG).show();
        values= new String[]{"1","outros"};
        /*int i=0;
            try {

                while (i < cont) {
                           dados[i] = user.getResponse().getString(i);
                    i++;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }*/
        return values;


    }



}



