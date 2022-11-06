package application;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;

import java.util.Scanner;

public class program2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao =  DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        System.out.println("Id da tabela a ser encontrada!");
        //int id = sc.nextInt();
        Department dep = departmentDao.findById(1);
        System.out.println(dep);
        
        

        System.out.println("\n=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "tabacaria");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());


        sc.close();


        



    }


}
