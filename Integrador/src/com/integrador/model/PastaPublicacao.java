package com.integrador.model;

public class PastaPublicacao {
	
	private long idPastaPublicacao;
	private Pasta Pasta;
	private Publicacao Publicacao;
	
	
	public PastaPublicacao() {
		super();
	}


	public PastaPublicacao(long idPastaPublicacao, com.integrador.model.Pasta pasta,
			com.integrador.model.Publicacao publicacao) {
		super();
		this.idPastaPublicacao = idPastaPublicacao;
		Pasta = pasta;
		Publicacao = publicacao;
	}


	public long getIdPastaPublicacao() {
		return idPastaPublicacao;
	}


	public void setIdPastaPublicacao(long idPastaPublicacao) {
		this.idPastaPublicacao = idPastaPublicacao;
	}


	public Pasta getPasta() {
		return Pasta;
	}


	public void setPasta(Pasta pasta) {
		Pasta = pasta;
	}


	public Publicacao getPublicacao() {
		return Publicacao;
	}


	public void setPublicacao(Publicacao publicacao) {
		Publicacao = publicacao;
	}
	
	
	

}
