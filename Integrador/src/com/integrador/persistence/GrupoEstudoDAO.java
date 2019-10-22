package com.integrador.persistence;

public class GrupoEstudoDAO {
	private ConexaoMysql conexao;

	public GrupoEstudoDAO(ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}
	
	

	
}
