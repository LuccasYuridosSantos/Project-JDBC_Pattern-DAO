package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== TEST 01: Department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);

		
		System.out.println("\n=== TEST 02: Department findAll ===");
		List<Department> listDep = departmentDao.findAll();
		listDep.forEach(System.out::println);
	
		System.out.println("\n=== TEST 03: Department insert ===");
		Department dep02 = new Department(null, "Games");
		departmentDao.insert(dep02);
		System.out.println("Inserted! New id = " + dep02.getId());
		System.out.println(dep = departmentDao.findById(dep02.getId()));
		
		System.out.println("\n=== TEST 04: Department Update ===");
		dep = departmentDao.findById(1);
		dep.setName("GameAwards");
		departmentDao.update(dep);
		System.out.println("Update completed");
		System.out.println(departmentDao.findById(dep.getId()));
		
		System.out.println("\n=== TEST 05: Department delete by id ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete departement with Id: "+ dep.getId() + " Success");
		
		sc.close();
	
	}

}
