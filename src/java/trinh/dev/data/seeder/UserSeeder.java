package trinh.dev.data.seeder;

import trinh.dev.data.dao.Database;
import trinh.dev.data.dao.DatabaseDao;
import trinh.dev.data.dao.UserDao;
import trinh.dev.data.model.User;

import com.github.javafaker.Faker;

public class UserSeeder {
	// Khai báo thuộc tính userDao
    private UserDao userDao;

    // Khởi tạo đối tượng Faker
    private Faker faker;
    
	public UserSeeder(UserDao userDao) {
		 this.faker = new Faker();
	     this.userDao = userDao;
	}
	
	public void seedUsers(int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            // Fake Java
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            String role = faker.job().position();

            User user = new User(email, password, role);
            userDao.insert(user);
            //Print Fake Users
            System.out.println("Inserted User: " + email + " | " + password + " | " + role);
        }
    }
	
}