package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.PastaPublicacao;
import com.integrador.model.UsuarioParticipaGE;
import com.mysql.jdbc.Statement;

public class UsuarioParticipaGEDAO {
	private ConexaoMysql conexao;

	public UsuarioParticipaGEDAO(ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}
	
	
	public UsuarioParticipaGE salvar(UsuarioParticipaGE usuarioParticipaGE) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO usuario_ge VALUES(null, ?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			
			prepare.setLong(1, usuarioParticipaGE.getUsuario().getIdUsuario());
			prepare.setLong(2, usuarioParticipaGE.getGrupoEstudo().getIdGE());
			
		
			
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				usuarioParticipaGE.setIdUsuarioParticipaGE(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return usuarioParticipaGE;
	}
	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM usuario_ge WHERE id_usuario_ge=?";
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
