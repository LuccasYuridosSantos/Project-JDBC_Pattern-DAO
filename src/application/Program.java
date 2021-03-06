package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
			
		SellerDao sellerDao = DaoFactory.createSellerDao();
	
		System.out.println("=== TEST 01: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 02: seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 03: seller findAll ===");
		List<Seller> list02 = sellerDao.findAll();
		list02.forEach(System.out::println);
		
		System.out.println("\n=== TEST 04: seller insert ===");
		Seller newSeller = new Seller(null, "Jorge", "Jorge@gmail.com", new Date(), 3500.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		seller = sellerDao.findById(newSeller.getId());		
		System.out.println(seller);
		
		System.out.println("\n=== TEST 05: seller update ===");
		seller =sellerDao.findById(1);
		seller.setName("Maicon White");
		sellerDao.update(seller);
		System.out.println("Update completed");
		System.out.println(sellerDao.findById(seller.getId()));
		
		
		System.out.println("\n=== TEST 06: seller delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
