package com.integrador.model;

public class UsuarioRespondeFc {

	private long idUsuarioRespondeFc;
	private Usuario usuarioResponde;
	private Flashcard flashcardRespondido;

	public UsuarioRespondeFc() {
		super();
	}

	public UsuarioRespondeFc(long idUsuarioRespondeFc, Usuario usuarioResponde, Flashcard flashcardRespondido) {
		super();
		this.idUsuarioRespondeFc = idUsuarioRespondeFc;
		this.usuarioResponde = usuarioResponde;
		this.flashcardRespondido = flashcardRespondido;
	}

	public long getIdUsuarioRespondeFc() {
		return idUsuarioRespondeFc;
	}

	public void setIdUsuarioRespondeFc(long idUsuarioRespondeFc) {
		this.idUsuarioRespondeFc = idUsuarioRespondeFc;
	}

	public Usuario getUsuarioResponde() {
		return usuarioResponde;
	}

	public void setUsuarioResponde(Usuario usuarioResponde) {
		this.usuarioResponde = usuarioResponde;
	}

	public Flashcard getFlashcardRespondido() {
		return flashcardRespondido;
	}

	public void setFlashcardRespondido(Flashcard flashcardRespondido) {
		this.flashcardRespondido = flashcardRespondido;
	}

}
