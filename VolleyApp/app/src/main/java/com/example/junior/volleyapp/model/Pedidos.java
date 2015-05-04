package com.example.junior.volleyapp.model;

import org.json.JSONObject;

/**
 * Created by junior on 01/05/15.
 */
public class Pedidos {

    private JSONObject pedidos;
    private String desc;
    private String produto;
    private String data;
    private int nnota;

    public Pedidos(){}

    public Pedidos(JSONObject jsonObject){
        this.pedidos = jsonObject;
    }

    public JSONObject getPedidos() {
        return pedidos;
    }

    public void setPedidos(JSONObject pedidos) {
        this.pedidos = pedidos;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getNnota() {
        return nnota;
    }

    public void setNnota(int nnota) {
        this.nnota = nnota;
    }
}
