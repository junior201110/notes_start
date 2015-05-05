package com.example.junior.volleyapp;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.junior.volleyapp.adater.CustomListAdapter;
import com.example.junior.volleyapp.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class SalaUsuario extends Activity {
    private View viewContainer;
    private String login, id;
    private ProgressDialog progressDialog;
    private Map<String, String> params;
    private String url = "http://192.168.43.213/nef/noivosemfesta/index.php";
    private RequestQueue rq;
    private Intent intent = getIntent();
    private ListView listView;
    private CustomListAdapter adapter;
    private List<Movie> movieList = new ArrayList<Movie>();
    private int[] itemId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_usuario);

        listView = (ListView) findViewById(R.id.listview);
        adapter = new CustomListAdapter(this, movieList);
        listView.setAdapter(adapter);



        // changing action bar color

        // Creating volley request obj
        JsonArrayRequest movieReq = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        hidePDialog();

                        // Parsing json
                        for (int i = 0; i < response.length(); i++) {
                            try {

                                JSONObject obj = response.getJSONObject(i);
                                Movie movie = new Movie();
                                movie.setTitle(obj.getString("desc"));
                                //movie.setThumbnailUrl(obj.getString("image"));
                                movie.setRating(obj.getString("data"));
                                movie.setYear(obj.getString("nnotas"));

                                // Genre is json array
                                //JSONArray genreArry = obj.getJSONArray("genre");
                                //ArrayList<String> genre = new ArrayList<String>();
                                //for (int j = 0; j < genreArry.length(); j++) {
                                //	genre.add((String) genreArry.get(j));
                                //}
                                movie.setGenre(obj.getString("produto"));

                                // adding movie to movies array
                                movieList.add(movie);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                        // notifying list adapter about data changes
                        // so that it renders the list view with updated data
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                hidePDialog();

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(movieReq);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {



            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        hidePDialog();
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }


}

