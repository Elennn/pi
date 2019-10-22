package com.integrador.model;

import java.util.ArrayList;

public class Flashcard {
	
	private long idFlashcard;
	private String categoria;
	private String pergunta;
	private String resposta1;
	private String resposta2;
	private String resposta3;
	private Usuario UsuarioAdiciona;
	//N:N
	private ArrayList<UsuarioRespondeFc> flashcardRespondidoPorUsuario;
	
	
	
	
	public Flashcard() {
		super();
	}






	public Flashcard(long idFlashcard, String categoria, String pergunta, String repostas1, String respostas2,
			String reaosta3, Usuario usuarioAdiciona, ArrayList<UsuarioRespondeFc> flashcardRespondidoPorUsuario) {
		super();
		this.idFlashcard = idFlashcard;
		this.categoria = categoria;
		this.pergunta = pergunta;
		this.resposta1 = resposta1;
		this.resposta2 = resposta2;
		this.resposta3 = resposta3;
		UsuarioAdiciona = usuarioAdiciona;
		this.flashcardRespondidoPorUsuario = flashcardRespondidoPorUsuario;
	}






	public ArrayList<UsuarioRespondeFc> getFlashcardRespondidoPorUsuario() {
		return flashcardRespondidoPorUsuario;
	}






	public void setFlashcardRespondidoPorUsuario(ArrayList<UsuarioRespondeFc> flashcardRespondidoPorUsuario) {
		this.flashcardRespondidoPorUsuario = flashcardRespondidoPorUsuario;
	}






	public long getIdFlashcard() {
		return idFlashcard;
	}




	public void setIdFlashcard(long idFlashcard) {
		this.idFlashcard = idFlashcard;
	}




	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public String getPergunta() {
		return pergunta;
	}




	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}




	public String getResposta1() {
		return resposta1;
	}




	public void setResposta1(String pergunta1) {
		this.resposta1 = resposta1;
	}




	public String getResposta2() {
		return resposta2;
	}




	public void setResposta2(String pergunta2) {
		this.resposta2 = resposta2;
	}




	public String getResposta3() {
		return resposta3;
	}




	public void setResposta3(String pergunta3) {
		this.resposta3 = resposta3;
	}




	public Usuario getUsuarioAdiciona() {
		return UsuarioAdiciona;
	}




	public void setUsuarioAdiciona(Usuario usuarioAdiciona) {
		UsuarioAdiciona = usuarioAdiciona;
	}
	


}
