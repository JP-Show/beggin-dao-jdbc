package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;

	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
			//aqui é preparando o SQL, algum script sql
			st = conn.prepareStatement("INSERT INTO department " + "(Name) " + "VALUES " + "(?)",
					//aqui é para pegar o id que o sql gerar lá no banco
					Statement.RETURN_GENERATED_KEYS);
			//aqui é adicionando valor
			st.setString(1, obj.getName());
			//aqui é armazendo as linhas que foram mutadas, por exemplo, se caso você inseriu um dado, o valor vai ser 1
			int rowsAffected = st.executeUpdate();
			//aqui se caso mudar vai entrar na condição
			if (rowsAffected > 0) {
				//parar pegar o que gerar de id no Statement.RETURN_GERENATED_KE;YS
				ResultSet rs = st.getGeneratedKeys();
				//aqui se caso o houver algum conteudo na linha, ele vai entrar no caso
				if (rs.next()) {
					//aqui vai armazenar o id
					int id = rs.getInt(1);
					//aqui ta armazenamento o obj que ta no parametro e recebendo o id que foi gerado o mysql
					obj.setId(id);
					// aqui estamos fechando o ResultSet
					DB.closeResultSet(rs);
				}
			}

		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}

	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;	
		try {
			st = conn.prepareStatement(
					
					"UPDATE department "
					+ "SET Name = ?"
					+ "WHERE Id = ?"
					);
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			//como não vamos inserir nada novo, e nem retornar nada, só mandar o st.executeUpdate();
			st.executeUpdate();
			
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department WHERE Id = ?"
					);
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				return new Department(id, rs.getString("Name"));
				
			}
			return null;
		}catch(SQLException e) {
			throw new db.DbException(e.getMessage());
		}
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT * FROM department" 
					);
			rs = st.executeQuery();
			
			List<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				list.add(new Department(rs.getInt("Id"), rs.getString("Name")));
			}
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
