package br.com.crashsolutions.SG;

import java.io.Serializable;

// Todas as variaveis do banco de dados irão receber os valores atraves dessa classe
public class HomeSG implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String produto = null;
	private String imagem = null;
	private int id = 0;
	private String preco = null;
	
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
}
	
	