package com.integrador.model;

import java.util.ArrayList;

public class Usuario {
	private long idUsuario;
	private String login;
	private String email;
	private String nome;
	private String senha;
	private String biografia;
	private String foto;
//1:N
	private ArrayList<Flashcard> flashcards;
	private ArrayList<Pasta> pastas;
// N:N
	private ArrayList<UsuarioSegueUsuario> usuarioSeguido;
	private ArrayList<UsuarioSegueUsuario> usuarioSeguidor;
	private ArrayList<UsuarioRespondeFc> usuarioRespondeFlashcard;
	private ArrayList<UsuarioParticipaGE> participanteGE;

	public Usuario(long idUsuario, String login, String email, String nome, String senha, String biografia, String foto,
			ArrayList<Flashcard> flashcards, ArrayList<Pasta> pastas, ArrayList<UsuarioSegueUsuario> usuarioSeguido,
			ArrayList<UsuarioSegueUsuario> usuarioSeguidor, ArrayList<UsuarioRespondeFc> usuarioRespondeFlashcard,
			ArrayList<UsuarioParticipaGE> participanteGE) {
		super();
		this.idUsuario = idUsuario;
		this.login = login;
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		this.biografia = biografia;
		this.foto = foto;
		this.flashcards = flashcards;
		this.pastas = pastas;
		this.usuarioSeguido = usuarioSeguido;
		this.usuarioSeguidor = usuarioSeguidor;
		this.usuarioRespondeFlashcard = usuarioRespondeFlashcard;
		this.participanteGE = participanteGE;
	}

	public Usuario() {
		super();
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public ArrayList<Flashcard> getFlashcards() {
		return flashcards;
	}

	public void setFlashcards(ArrayList<Flashcard> flashcards) {
		this.flashcards = flashcards;
	}

	public ArrayList<Pasta> getPastas() {
		return pastas;
	}

	public void setPastas(ArrayList<Pasta> pastas) {
		this.pastas = pastas;
	}

	public ArrayList<UsuarioSegueUsuario> getUsuarioSeguido() {
		return usuarioSeguido;
	}

	public void setUsuarioSeguido(ArrayList<UsuarioSegueUsuario> usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}

	public ArrayList<UsuarioSegueUsuario> getUsuarioSeguidor() {
		return usuarioSeguidor;
	}

	public void setUsuarioSeguidor(ArrayList<UsuarioSegueUsuario> usuarioSeguidor) {
		this.usuarioSeguidor = usuarioSeguidor;
	}

	public ArrayList<UsuarioRespondeFc> getUsuarioRespondeFlashcard() {
		return usuarioRespondeFlashcard;
	}

	public void setUsuarioRespondeFlashcard(ArrayList<UsuarioRespondeFc> usuarioRespondeFlashcard) {
		this.usuarioRespondeFlashcard = usuarioRespondeFlashcard;
	}

	public ArrayList<UsuarioParticipaGE> getParticipanteGE() {
		return participanteGE;
	}

	public void setParticipanteGE(ArrayList<UsuarioParticipaGE> participanteGE) {
		this.participanteGE = participanteGE;
	}

}
