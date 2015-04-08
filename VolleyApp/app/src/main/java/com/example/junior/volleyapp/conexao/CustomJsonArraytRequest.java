package com.example.junior.volleyapp.conexao;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * Created by junior on 30/03/15.
 */

public class CustomJsonArraytRequest extends Request<JSONArray>{

    private Response.Listener<JSONArray> response;
    private Map<String, String> params;

    public CustomJsonArraytRequest(String url, Map<String, String> params, Response.Listener<JSONArray> response, Response.ErrorListener listener) {
        super(Method.GET, url, listener);

        this.params = params;
        this.response = response;

    }
    public CustomJsonArraytRequest(int method, String url, Map<String, String> params, Response.Listener<JSONArray> response, Response.ErrorListener listener) {
        super(method, url, listener);

        this.params = params;
        this.response = response;

    }
    public Map<String, String> getParams() throws AuthFailureError {
        return params;
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        Log.i("1","entra try");
        try {

            String js = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            return Response.success(new JSONArray(js), HttpHeaderParser.parseCacheHeaders(response));


        }

        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        catch (JSONException e) {
            e.printStackTrace();
        }
       return null;
    }



    @Override
    protected void deliverResponse(JSONArray response) {
        this.response.onResponse(response);
    }
}
