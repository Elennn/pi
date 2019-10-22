package com.integrador.persistence;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class PastaDAO {

	
	private ConexaoMysql conexao;

	public PastaDAO(ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");
	}
	public Pasta adicionar(Pasta pasta) {
		// abrir conexao mysql
		this.conexao.abrirConexao();
		// criar a instrucao sql de insert
		String sqlInsert = "INSERT INTO pasta VALUES(null,?, ?, ?)";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setString(1, pasta.getCategoria());
			prepare.setString(2, pasta.getTitulo());
			prepare.setLong(3, pasta.getUsuarioPasta().getIdUsuario());

			
		
			
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				pasta.setIdPasta(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return pasta;
	}
	
	public void excluir(long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM pasta WHERE id_pasta=?";
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
	
	public void editar(Pasta pasta) {
		// abrir conexao
		this.conexao.abrirConexao();
		// criar a instrucao sql
		String sqlUpdate = "UPDATE pasta SET categoria=?, titulo=?, id_usuario=?";
		// preparar a instrucao para ser executada
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlUpdate);
			prepare.setString(1, pasta.getCategoria());
			prepare.setString(2, pasta.getTitulo());
			prepare.setLong(3, pasta.getUsuarioPasta().getIdUsuario());
	
			
			// executar a instrucao
			prepare.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// fechar conexao
			this.conexao.fecharConexao();
		}
	}
	
	
	public List<Pasta> buscarTodos(){
		this.conexao.abrirConexao();
		List<Pasta> listaPastas=new ArrayList<Pasta>();
		Pasta pasta=null;
		String sqlBuscarTodos= "SELECT * FROM pasta";
		try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
		ResultSet rs=prepare.executeQuery();
		
		while(rs.next()) {
			pasta = new Pasta();
			pasta.setIdPasta(rs.getLong("id_pasta"));
			pasta.setCategoria(rs.getString("categoria"));
			pasta.setTitulo(rs.getString("titulo"));
			listaPastas.add(pasta);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listaPastas;
	}
	public Pasta buscarPorId(long id) {
		this.conexao.abrirConexao();
		Pasta pasta = null;
		String sqlBuscarPorId="SELECT * FROM pasta WHERE id_pasta";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			prepare.setLong(1, id);
			
			ResultSet rs = prepare.executeQuery();
			
			if(rs.next()) {
				// EXISTE A LINHA E TEMOS QUE CONVERTER A LINHA PARA UM OBJETO USUARIO
				pasta= new Pasta();
				pasta.setIdPasta(rs.getLong("id_pasta"));
				pasta.setCategoria(rs.getString("categoria"));
				pasta.setTitulo(rs.getString("titulo"));
				
				// FALTAUSUARIOPASTA
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return pasta;
		
	}

	
		
	}
	
	
	

