package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.Pasta;
import com.integrador.model.PastaPublicacao;
import com.mysql.jdbc.Statement;

public class PastaPublicacaoDAO {
	private ConexaoMysql conexao;

	public PastaPublicacaoDAO(ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}
	
	
	public PastaPublicacao salvar(PastaPublicacao pastaPublicacao) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO pasta_publicacao VALUES(null, ?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			
			prepare.setLong(1, pastaPublicacao.getPasta().getIdPasta());
			prepare.setLong(2, pastaPublicacao.getPublicacao().getIdPublicacao());
			
		
			
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				pastaPublicacao.setIdPastaPublicacao(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return pastaPublicacao;
	}
	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM pasta_publicacao WHERE id_pasta_publicacao=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);
			prepare.setLong(1, id);
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.conexao.fecharConexao();
		}
	}
	

	
}
