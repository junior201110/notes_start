package com.example.junior.volleyapp;

import android.app.Activity;
import android.os.Bundle;

import com.example.junior.volleyapp.model.NovoPedidoModel;


public class NovoPedido extends Activity {

    NovoPedidoModel  novo = new NovoPedidoModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_pedido);
    }

    private void passerData() throws Exception{

    }


}
