package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;


/*
 * dessa forma minha classe vai expor uma método que retorna o tipo da interface
 * mas internamente ela vai instanciar uma implementação
 * isso aqui é um macete para não precisar export a implementação, deixar somente a interface  
 * */
public class DaoFactory {
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	public static DepartmentDao createDepDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
