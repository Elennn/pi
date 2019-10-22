package com.integrador.model;

public class UsuarioSegueUsuario {
	
	private long idUsuarioSegue;
	private Usuario seguido;
	private Usuario seguidor;
	
	
	public UsuarioSegueUsuario(long idUsuarioSegue, Usuario seguido, Usuario seguidor) {
		super();
		this.idUsuarioSegue = idUsuarioSegue;
		this.seguido = seguido;
		this.seguidor = seguidor;
	}


	public UsuarioSegueUsuario() {
		super();
	}


	public long getIdUsuarioSegue() {
		return idUsuarioSegue;
	}


	public void setIdUsuarioSegue(long idUsuarioSegue) {
		this.idUsuarioSegue = idUsuarioSegue;
	}


	public Usuario getSeguido() {
		return seguido;
	}


	public void setSeguido(Usuario seguido) {
		this.seguido = seguido;
	}


	public Usuario getSeguidor() {
		return seguidor;
	}


	public void setSeguidor(Usuario seguidor) {
		this.seguidor = seguidor;
	}
	

}
