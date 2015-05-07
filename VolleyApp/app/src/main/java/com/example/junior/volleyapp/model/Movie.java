package com.example.junior.volleyapp.model;

public class Movie {
	private String idp; //, thumbnailUrl;
	private String desc;
	private String produto;
	private String nnotas;
	private String data;

	public Movie() {
	}

	public Movie(String idp, String desc, String produto,
			String nnotas, String data) {
		// setado entre name e year /, String thumbnailUrl/
		this.setIdp(idp);
		//this.thumbnailUrl = thumbnailUrl;
		this.setDesc(desc);
		this.setProduto(produto);
		this.setNnotas(nnotas);
		this.setData(data);
	}
	//public String getThumbnailUrl() {
	//	return thumbnailUrl;
	//}

	//public void setThumbnailUrl(String thumbnailUrl) {
	//	this.thumbnailUrl = thumbnailUrl;
	//}
	public String getIdp() {
		return idp;
	}

	public void setIdp(String idp) {
		this.idp = idp;
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

	public String getNnotas() {
		return nnotas;
	}

	public void setNnotas(String nnotas) {
		this.nnotas = nnotas;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
