package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDao depart = DaoFactory.createDepartmentDao();
		
		
		System.out.println("====  Selecionando via ID ====");
		Department department = depart.findById(2);
		System.out.println(department);
		
		System.out.println("==== \n Selecionando todos ====");
		List<Department> list = depart.findAll();
		for (Department x : list) {
			System.out.println(x);
		}
		
		System.out.println("==== \n Insert Departamento ====");
		Department novoDepartamento = new Department(null, "DevDev");
		depart.insert(novoDepartamento);
		System.out.println("DEPARTAMENTO CRIADO: " + novoDepartamento.getId());
		
		System.out.println("==== \n Update Departamento ====");
		department = depart.findById(3);
		department.setName("Calica");
		depart.update(novoDepartamento);
		System.out.println("Update feito");

		System.out.println("==== \n Deletar Departamento ====");
		System.out.println("Qual id deseja deletar? ");
		int id = sc.nextInt();
		depart.deleteById(id);
		System.out.println("Departamento deletado");
		
		sc.close();
		
		

	}
}
