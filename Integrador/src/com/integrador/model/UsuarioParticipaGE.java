package com.integrador.model;

public class UsuarioParticipaGE {

	private long idUsuarioParticipaGE;
	private Usuario Usuario;
	private GrupoEstudo GrupoEstudo;

	public UsuarioParticipaGE() {
		super();
	}

	public UsuarioParticipaGE(long idUsuarioParticipaGE, com.integrador.model.Usuario usuario,
			com.integrador.model.GrupoEstudo grupoEstudo) {
		super();
		this.idUsuarioParticipaGE = idUsuarioParticipaGE;
		Usuario = usuario;
		GrupoEstudo = grupoEstudo;
	}

	public long getIdUsuarioParticipaGE() {
		return idUsuarioParticipaGE;
	}

	public void setIdUsuarioParticipaGE(long idUsuarioParticipaGE) {
		this.idUsuarioParticipaGE = idUsuarioParticipaGE;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public GrupoEstudo getGrupoEstudo() {
		return GrupoEstudo;
	}

	public void setGrupoEstudo(GrupoEstudo grupoEstudo) {
		GrupoEstudo = grupoEstudo;
	}

}
