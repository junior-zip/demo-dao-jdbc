package application;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Program {
    public static void main(String[] args) {


        SellerDao selle = DaoFactory.createSellerDao();
        Seller seller = selle.findById(3);
        System.out.println(seller);

    }
}
