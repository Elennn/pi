package com.integrador.model;

import java.sql.Date;
import java.util.ArrayList;

public class Publicacao {
	private long idPublicacao;
	private String legenda;
	private String comentario;
	private String categoria;
	private String documento;
	private boolean visibilidade;
	private Date data;
	
	
	//N:N
	private ArrayList<PastaPublicacao> publicacaoPertencePasta;

	
	
	public Publicacao() {
		super();
	}
	
	
	
	



	public Publicacao(long idPublicacao, String legenda, String comentario, String categoria, String documento,
			boolean visibilidade,
			ArrayList<PastaPublicacao> publicacaoPertencePasta, Date data) {
		super();
		this.idPublicacao = idPublicacao;
		this.legenda = legenda;
		this.comentario = comentario;
		this.categoria = categoria;
		this.documento = documento;
		this.visibilidade = visibilidade;
		
		this.publicacaoPertencePasta = publicacaoPertencePasta;
		this.data = data;
	}



	public Date getData() {
		return data;
	}







	public void setData(Date data) {
		this.data = data;
	}







	public long getIdPublicacao() {
		return idPublicacao;
	}
	public void setIdPublicacao(long idPublicacao) {
		this.idPublicacao = idPublicacao;
	}
	public String getLegenda() {
		return legenda;
	}
	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public boolean isVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
	}
	
	public ArrayList<PastaPublicacao> getPublicacaoPertencePasta() {
		return publicacaoPertencePasta;
	}

	public void setPublicacaoPertencePasta(ArrayList<PastaPublicacao> publicacaoPertencePasta) {
		this.publicacaoPertencePasta = publicacaoPertencePasta;
	}
	
	

}
