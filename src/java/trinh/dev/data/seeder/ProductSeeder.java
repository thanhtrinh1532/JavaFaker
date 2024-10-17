package trinh.dev.data.seeder;

import trinh.dev.data.dao.ProductDao;
import trinh.dev.data.dao.CategoryDao;
import trinh.dev.data.model.Product;
import trinh.dev.data.model.Category;
import com.github.javafaker.Faker;

import java.util.List;

public class ProductSeeder {
    private ProductDao productDao;
    private CategoryDao categoryDao;
    private Faker faker;

    public ProductSeeder(ProductDao productDao, CategoryDao categoryDao) {
        this.faker = new Faker();
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    public void seedProducts(int numberOfProducts) {
        List<Category> categories = categoryDao.findAll();
        for (int i = 0; i < numberOfProducts; i++) {
            String name = faker.commerce().productName();
            String description = faker.lorem().paragraph();
            String thumbnail = faker.internet().avatar();
            double price = faker.number().randomDouble(3, 10, 1000);
            int quantity = faker.number().numberBetween(1, 100);
            int view = 0;

            // Radom get category
            int randomIndex = faker.random().nextInt(categories.size());
            Category category = categories.get(randomIndex);

            Product product = new Product(0, name, description, thumbnail, price, quantity, category.getId(), null);
            //id, name, description, thumbnail, price, quantity, categoryId, created_at
            productDao.insert(product);

            // Print Fake Products
            System.out.println("Inserted Product: " + name + " | " + price + " | " + category.getName());
        }
    }
}