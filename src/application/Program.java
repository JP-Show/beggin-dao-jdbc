package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		DateTimeFormatter ftm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Department obj = new Department(1, "Jr.Dev Java");
		System.out.println(obj);

		Seller seller = new Seller(1, "Andre","andreluiz@gmail.com", LocalDate.parse("04/04/2000", ftm), 4000.00, obj);
		
		System.out.println(seller);
	}

}
