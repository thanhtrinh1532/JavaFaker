/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trinh.dev.data.seeder;

import java.util.List;
import java.util.Random;

import com.github.javafaker.Faker;

import trinh.dev.data.dao.OrderDao;
import trinh.dev.data.dao.UserDao;
import trinh.dev.data.model.Order;

public class OrderSeeder {
	private Faker faker;
    private OrderDao orderDao;
    private List<Integer> existingUserIds;  
    private Random random;

    public OrderSeeder(OrderDao orderDao, UserDao userDao) {
        this.faker = new Faker();
        this.orderDao = orderDao;
        this.existingUserIds = userDao.getAllUserIds(); 
        this.random = new Random();
    }

    public void seedOrders(int numberOfOrders) {
        for (int i = 0; i < numberOfOrders; i++) {
            String code = faker.commerce().promotionCode();  
            String status = faker.options().option("Pending", "Finished");

            int userId = existingUserIds.get(random.nextInt(existingUserIds.size()));

            //Order(id, code, status, userId, created_at)
            Order order = new Order(0,code, status, userId,null);
            orderDao.insert(order);
            
            //Print Fake Order
            System.out.println("Inserted Order: " + code + " | " + status + " | " + userId);
        }
    }
}