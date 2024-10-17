/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trinh.dev;

import trinh.dev.data.dao.CategoryDao;
import trinh.dev.data.dao.Database;
import trinh.dev.data.model.Category;
import trinh.dev.data.impl.CategoryImpl;
import trinh.dev.data.model.Order;
import trinh.dev.data.model.OrderItem;
import trinh.dev.data.model.Product;
import trinh.dev.data.dao.DatabaseDao;
import trinh.dev.data.dao.OrderDao;
import trinh.dev.data.dao.OrderItemDao;
import trinh.dev.data.dao.ProductDao;
import trinh.dev.data.dao.UserDao;
import trinh.dev.data.impl.UserImpl;
import trinh.dev.data.model.User;
import trinh.dev.data.seeder.CategorySeeder;
import trinh.dev.data.seeder.ProductSeeder;
import trinh.dev.data.seeder.UserSeeder;

import java.util.List;
import java.util.Locale;
import com.github.javafaker.Faker;
import trinh.dev.data.seeder.OrderSeeder;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                DatabaseDao.init(new Database());
                Faker faker = new Faker();
		//Insert User	
	        UserDao userDao = DatabaseDao.getInstance().getUserDao();
//	        UserSeeder userSign = new UserSeeder(userDao);
//	        userSign.seedUsers(5);        
//	        //Insert Category
//	        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
//	        CategorySeeder categorySeeder = new CategorySeeder(categoryDao);
//	        categorySeeder.seedCategories(5);
//	        //Insert Product
//	        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
//	        ProductSeeder productSeeder = new ProductSeeder(productDao, categoryDao);
//	        productSeeder.seedProducts(10);
//	        //Insert Order
//              OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
//	        OrderSeeder orderSeeder = new OrderSeeder(orderDao, userDao);
//	        orderSeeder.seedOrders(5);
                //Insert OrderItem
                
	        System.out.println("Seeded fake users successfully!");
			
	}
	
}