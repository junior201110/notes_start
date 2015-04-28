package com.example.junior.volleyapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.junior.volleyapp.conexao.CustomJsonArraytRequest;

import org.json.JSONArray;

import java.util.Map;


public class SalaUsuario extends Activity {
    private View viewContainer;
    String login, id;
    private ProgressDialog progressDialog;
    private Map<String,String> params;
    private String url = "http://192.168.56.1/nef/noivosemfesta/index.php";
    private RequestQueue rq;
    ListView l;
   private int[] itemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super .onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_usuario);
        l  = (ListView) findViewById(R.id.listview);
        rq = Volley.newRequestQueue(SalaUsuario.this);



        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        login = intent.getStringExtra("login");

        TextView txtLOGIN = (TextView) findViewById(R.id.txtLogin);
        txtLOGIN.setText("Pedidos - "+ login);

        viaJsonArrayGET();
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String item = (String) adapterView.getAdapter().getItem(i);

                makeAlertDialog("ITEM", item);

                verItems();


            }
        });
        l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View v,
                                           int index, long arg3) {

                Log.i("TAG","in onLongClick");
                String str=l.getItemAtPosition(index).toString();

                Log.i("TAG","long click : " +str);
                return true;
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
        showUndo(viewContainer);
        return true;
    }
    public void onClick(View view) {
        Toast.makeText(this, "Deletion undone", Toast.LENGTH_LONG).show();
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

    public void viaJsonArrayGET(){
        progressDialog = ProgressDialog.show(SalaUsuario.this,"Aguarde","Caregando Items",true,true);
        String id = this.id;

        CustomJsonArraytRequest jar = new CustomJsonArraytRequest(
                Request.Method.GET,url+"/pedidos/jor/"+id,params,new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                try{


                        criaLista(jsonArray);
                    progressDialog.dismiss();

                }catch (Exception e){
                    Log.i("tag", e.toString());
                }

            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                makeAlertDialog("ERRO",volleyError.toString());

            }
        }
        );

        jar.setTag("PEDIDOS");
        rq.add(jar);

    }

    public void criaLista(JSONArray jsonArray) throws Exception{
        progressDialog.dismiss();

        String[] values = new String[jsonArray.length()];
        itemId = new int[jsonArray.length()];

        Log.i("TAMANHO ARRAY", String.valueOf(values.length));

            if(jsonArray.getJSONObject(0).getString("desc").equals("404")){
                makeAlertDialog("ERRO","USUSARIO AINDA NÃO POSSUi\n PEDIDOS CADASTRADO");
                values[0] = "";
            }else{
                if(jsonArray.length() > 0){
                    for (int i=0;i<jsonArray.length();i++) {

                        values[i] = String.valueOf(jsonArray.getJSONObject(i).getString("desc"));
                        itemId[i] = jsonArray.getJSONObject(i).getInt("idp");
                    }
                    }
            }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);



        //List<String> adapter = new ArrayList<String>();


        l.setAdapter(adapter);

    }

    public void makeAlertDialog(String title, String mesage){

        AlertDialog.Builder alert = new AlertDialog.Builder(SalaUsuario.this);

        alert.setTitle(title);
        alert.setMessage(mesage);
        alert.setCancelable(true);
        alert.show();

    }

    public void verItems(){

        for(int i=0;i<itemId.length;i++){
            Log.i("ID", String.valueOf(itemId[i]));
        }

    }

}
