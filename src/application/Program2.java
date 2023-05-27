package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DepartmentDao depDao = DaoFactory.createDepDao();
		
		depDao.insert(new Department(null, "Jr"));
	}

}
