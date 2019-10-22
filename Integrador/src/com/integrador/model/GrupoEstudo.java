package com.integrador.model;

import java.util.ArrayList;


public class GrupoEstudo {

	
	private long idGE;
	private String nome_ge;
	private String categoria;
	private ArrayList<UsuarioParticipaGE> integrantes;

	
	
	

	public GrupoEstudo() {
		super();
	}
	
	
	
	
	public GrupoEstudo(long idGE, String nome_ge, String categoria, ArrayList<UsuarioParticipaGE> integrantes) {
		super();
		this.idGE = idGE;
		this.nome_ge = nome_ge;
		this.categoria = categoria;
		this.integrantes = integrantes;
	}




	public long getIdGE() {
		return idGE;
	}
	public void setIdGE(long idGE) {
		this.idGE = idGE;
	}
	public String getNome_ge() {
		return nome_ge;
	}
	public void setNome_ge(String nome_ge) {
		this.nome_ge = nome_ge;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public ArrayList<UsuarioParticipaGE> getIntegrantes() {
		return integrantes;
	}




	public void setIntegrantes(ArrayList<UsuarioParticipaGE> integrantes) {
		this.integrantes = integrantes;
	}
	
	
	
	
}
