package br.com.crashsolutions.SG;

import java.math.BigDecimal;

public class CadastroFisicoSG {
	
	private Integer idusuario = 0;
	private String email = null;
	private String senha = null;
	private String cpf = null;
	private String nome = null;
	private String sobrenome = null;
	private String destinatario = null;
	private String datanascimento = null;
	private String sexo = null;
	private Integer idendereco = 0;
	private Integer idenderecofisico = 0;
	private String nomeendereco = null;
	private String endereco = null;
	private Integer numero = 0;
	private String complemento = null;
	private String bairro = null;
	private String cidade = null;
	private String estado  = null;
	private String cep = null;
	private BigDecimal telefone = null;
	private BigDecimal celular = null;
	private String condicao = null;
	private String imagem = null;
	
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String string) {
		this.cpf = string;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getDatanascimento() {
		return datanascimento;
	}
	public void setDatanascimento(String datanascimento2) {
		this.datanascimento = datanascimento2;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Integer getIdendereco() {
		return idendereco;
	}
	public void setIdendereco(Integer idendereco) {
		this.idendereco = idendereco;
	}
	public Integer getIdenderecofisico() {
		return idenderecofisico;
	}
	public void setIdenderecofisico(Integer idenderecofisico) {
		this.idenderecofisico = idenderecofisico;
	}
	public String getNomeendereco() {
		return nomeendereco;
	}
	public void setNomeendereco(String nomeendereco) {
		this.nomeendereco = nomeendereco;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep2) {
		this.cep = cep2;
	}
	public BigDecimal getTelefone() {
		return telefone;
	}
	public void setTelefone(BigDecimal telefone) {
		this.telefone = telefone;
	}
	public BigDecimal getCelular() {
		return celular;
	}
	public void setCelular(BigDecimal celular) {
		this.celular = celular;
	}
	public String getCondicao() {
		return condicao;
	}
	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}
}
