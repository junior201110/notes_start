package com.example.junior.volleyapp;

/**
 * Created by junior on 30/04/15.
 */
public class CapsuleFields  {
    private String desc;
    private String idp;
    private String data;
    private String nnotas;
    private String produto;

    public CapsuleFields() {
    }

    public CapsuleFields(String desc, String idp, String data, String nnotas, String produto) {
        this.setDesc(desc);
        this.setIdp(idp);
        this.setData(data);
        this.setNnotas(nnotas);
        this.setProduto(produto);
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIdp() {
        return idp;
    }

    public void setIdp(String idp) {
        this.idp = idp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getNnotas() {
        return nnotas;
    }

    public void setNnotas(String nnotas) {
        this.nnotas = nnotas;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}

