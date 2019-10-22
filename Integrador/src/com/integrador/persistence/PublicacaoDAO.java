package com.integrador.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.integrador.model.Flashcard;
import com.integrador.model.Pasta;
import com.integrador.model.Publicacao;
import com.mysql.jdbc.Statement;

public class PublicacaoDAO {
	private ConexaoMysql conexao;

	public PublicacaoDAO(ConexaoMysql conexao) {
		super();
		this.conexao = new ConexaoMysql("localhost", "3306", "root", "my3soul", "bd_app");

	}

	public Publicacao adicionar(Publicacao publicacao) {
		this.conexao.abrirConexao();
		String sqlInsert = "INSERT INTO publicacao VALUES (null, ?, ?,?, ?,?, ? )";

		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlInsert,
					Statement.RETURN_GENERATED_KEYS);
			prepare.setString(1, publicacao.getLegenda());
			prepare.setString(2, publicacao.getComentario());

			prepare.setString(3, publicacao.getCategoria());
			prepare.setString(4, publicacao.getDocumento());
			prepare.setBoolean(5, publicacao.isVisibilidade());
			prepare.setDate(6, publicacao.getData());

			// executar essa instrucao
			prepare.executeUpdate();

			ResultSet rs = prepare.getGeneratedKeys();
			if (rs.next()) {
				long id = rs.getLong(1);
				publicacao.setIdPublicacao(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// fechar a conexao com mysql
			this.conexao.fecharConexao();
		}
		return publicacao;
	}
	public void excluir (long id) {
		this.conexao.abrirConexao();
		String sqlDelete = "DELETE FROM publicacao WHERE id_publicacao=?";
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
	public List<Publicacao> buscarTodos()
	{ this.conexao.abrirConexao();
	List<Publicacao> listaPublicacoes=new ArrayList<Publicacao>();
	Publicacao publicacao=null;
	String sqlBuscarTodos= "SELECT * FROM publicacao";
	try {
		PreparedStatement prepare =(PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarTodos);
		ResultSet rs=prepare.executeQuery();
		
		while(rs.next()) {
			publicacao= new Publicacao();
			publicacao.setIdPublicacao(rs.getLong("id_publicacao"));
			publicacao.setLegenda(rs.getString("legenda"));
			publicacao.setComentario(rs.getString("comentario"));
			publicacao.setCategoria(rs.getString("categoria"));
			publicacao.setDocumento(rs.getString("documento"));
			publicacao.setVisibilidade(rs.getBoolean("visibilidade"));
			publicacao.setData(rs.getDate("data"));
			
			
			listaPublicacoes.add(publicacao);
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	
	return listaPublicacoes;
	
	
	
	
	
	
	
	}
	public Publicacao buscarPorId(long id) {
		this.conexao.abrirConexao();
		Publicacao publicacao = null;
		String sqlBuscarPorId="SELECT * FROM publicacao WHERE id_publicacao";
		try {
			PreparedStatement prepare = (PreparedStatement) this.conexao.getConexao().prepareStatement(sqlBuscarPorId);
			prepare.setLong(1, id);
			
			ResultSet rs = prepare.executeQuery();
			
			if(rs.next()) {
				// EXISTE A LINHA E TEMOS QUE CONVERTER A LINHA PARA UM OBJETO USUARIO
				publicacao= new Publicacao();
				publicacao.setLegenda(rs.getString("legenda"));
				publicacao.setComentario(rs.getString("comentario"));
				publicacao.setCategoria(rs.getString("categoria"));
				publicacao.setDocumento(rs.getString("documento"));
				publicacao.setVisibilidade(rs.getBoolean("visibilidade"));
				
				
			
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return publicacao;
		
	}
	}


