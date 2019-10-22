package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.integrador.model.Usuario;
import com.integrador.model.UsuarioSegueUsuario;
import com.mysql.jdbc.Statement;

public class UsuarioSegueUsuarioDAO {

	private ConexaoMysql conexao;

	public UsuarioSegueUsuarioDAO(ConexaoMysql conexao) {

		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}

	public Usuario seguir(Usuario usuario) {
		this.conexao.abrirConexao();

		String sqlInsert = "INSERT INTO usuario_segue VALUES(null, ?, ?)";

		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setLong(1, usuario.getIdUsuario());
			prepare.setLong(2, usuario.getIdUsuario());
			prepare.executeUpdate();
			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				usuario.setIdUsuario(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}

		return usuario;
	}
}
