package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Pasta;
import com.integrador.model.Usuario;
import com.mysql.jdbc.Statement;

public class UsuarioDAO {

	private ConexaoMysql conexao;

	public UsuarioDAO(ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}

	public Usuario salvar(Usuario usuario) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO usuario VALUES(null,?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setString(1, usuario.getLogin());
			prepare.setString(2, usuario.getEmail());
			prepare.setString(3, usuario.getNome());
			prepare.setString(4, usuario.getSenha());
			prepare.setString(5, usuario.getBiografia());
			prepare.setString(6, usuario.getFoto());
			// executar essa instrucao
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				usuario.setIdUsuario(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return usuario;
	}

	// editar
	public void editar(Usuario usuario) {
		// abrir conexao
		this.conexao.abrirConexao();
		// criar a instrucao sql
		String sqlUpdate = "UPDATE usuario SET login=?, email=?, nome=?, senha=?, biografia=?, foto=? WHERE id_usuario=?";
		// preparar a instrucao para ser executada
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			prepare.setString(1, usuario.getLogin());
			prepare.setString(2, usuario.getEmail());
			prepare.setString(3, usuario.getNome());
			prepare.setString(4, usuario.getSenha());
			prepare.setString(5, usuario.getBiografia());
			prepare.setString(6, usuario.getFoto());
			prepare.setLong(7, usuario.getIdUsuario());
			// executar a instrucao
			prepare.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar conexao
			this.conexao.fecharConexao();
		}
	}

	// excluir
	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM usuario WHERE id_usuario=?";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlDelete);
			prepare.setLong(1, id);
			prepare.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public List<Usuario> buscarTodos() {
		this.conexao.abrirConexao();
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Usuario usuario = null;
		String sqlBuscarTodos = "SELECT * FROM usuario";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
			ResultSet rs = prepare.executeQuery();

			while (rs.next()) {
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setBiografia(rs.getString("biografia"));
				usuario.setFoto(rs.getString("foto"));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaUsuarios;
	}

	public Usuario buscarPorId(long id) {
		this.conexao.abrirConexao();
		Usuario usuario = null;
		String sqlBuscarPorId = "SELECT * FROM usuario WHERE id_usuario";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			prepare.setLong(1, id);

			ResultSet rs = prepare.executeQuery();

			if (rs.next()) {
				// EXISTE A LINHA E TEMOS QUE CONVERTER A LINHA PARA UM OBJETO USUARIO
				usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setBiografia(rs.getString("biografia"));
				usuario.setFoto(rs.getString("foto"));

			

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;

	}
}
