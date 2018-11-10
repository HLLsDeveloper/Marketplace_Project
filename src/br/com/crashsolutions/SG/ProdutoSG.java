package br.com.crashsolutions.SG;

import java.math.BigDecimal;

public class ProdutoSG {
	
	private Integer idproduto = 0;
	private String produto = null;
	private String imagem = null;
	private String descricao = null;
	private String modelo = null;
	private String genero = null;
	private String tamanho = null;
	private String cor = null;
	private String categoria = null;
	private Float valor_custo = 0f;
	private Float valor_venda = 0f;
	private Float resultado = 0f;
	private Float valor_total = 0f;
	private Integer quantidade = 0;
	private Integer quantidade_dig = 0;
	private BigDecimal numeropedido = null;
	private Integer referencia = null;
	private String condicao = null;
	
	public Integer getIdproduto() {
		return idproduto;
	}
	public void setIdproduto(Integer idproduto) {
		this.idproduto = idproduto;
	}
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getValor_custo() {
		return valor_custo;
	}
	public void setValor_custo(Float valor_custo) {
		this.valor_custo = valor_custo;
	}
	public Float getValor_venda() {
		return valor_venda;
	}
	public void setValor_venda(Float valor_venda) {
		this.valor_venda = valor_venda;
	}
	public Float getResultado() {
		return resultado;
	}
	public void setResultado(Float resultado) {
		this.resultado = resultado;
	}
	public Float getValor_total() {
		return valor_total;
	}
	public void setValor_total(Float valor_total) {
		this.valor_total = valor_total;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Integer getQuantidade_dig() {
		return quantidade_dig;
	}
	public void setQuantidade_dig(Integer quantidade_dig) {
		this.quantidade_dig = quantidade_dig;
	}
	public BigDecimal getNumeropedido() {
		return numeropedido;
	}
	public void setNumeropedido(BigDecimal numeropedido) {
		this.numeropedido = numeropedido;
	}
	public Integer getReferencia() {
		return referencia;
	}
	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}
	public String getCondicao() {
		return condicao;
	}
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
}
