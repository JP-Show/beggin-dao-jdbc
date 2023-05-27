package application;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Department obj = new Department(1, "null");
		System.out.println(obj);

		Seller seller = new Seller(1, "Andre","andreluiz@gmail.com", new Date(), 4000.00, obj);
		
		
		
		/*
		 * a gente não precisa dar um new SellerDaoJDBC
		 * a gente simplesmente chama a fabrica
		 * dessa forma o meu programa a não conhece a implementação
		 * ele conhece somente a interface e é também uma forma da a gente
		 * fazer a injeção de depedencia sem esplicitar a implementação
		 * */
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		
		
		System.out.println(sellerDao.findById(3));
		System.out.println(seller);
	
		System.out.println("Test 2");
		
		
		List<Seller> d = sellerDao.findByDepartment(new Department(4, "Books"));
	
		for(Seller selle : d) {
			System.out.println(selle.toString());
			
		}
		System.out.println("Test 3");
		List<Seller> de= sellerDao.findAll();
		for(Seller selle : de) {
			System.out.println(selle.toString());
			
		}
		

		Seller newSelller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, obj);
		sellerDao.insert(newSelller);
		System.out.println("Inserted! New id = " + newSelller.getId());
		
		System.out.println("test 5");
		seller = sellerDao.findById(1);
		seller.setName("Andre Luiz");
		sellerDao.update(seller);
		System.out.println();
		sellerDao.deleteById(1);
		
	}

}
