package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Department obj = new Department(1, "Jr.Dev Java");
		System.out.println(obj);

		Seller seller = new Seller(1, "Andre","andreluiz@gmail.com", LocalDate.parse("04/04/2000", ftm), 4000.00, obj);
		
		System.out.println(seller);
		
		/*
		 * a gente não precisa dar um new SellerDaoJDBC
		 * a gente simplesmente chama a fabrica
		 * dessa forma o meu programa a não conhece a implementação
		 * ele conhece somente a interface e é também uma forma da a gente
		 * fazer a injeção de depedencia sem esplicitar a implementação
		 * */
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
	}

}
