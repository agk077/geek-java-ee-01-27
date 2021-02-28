package ru.geekbrains.listener;

import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;

@WebListener
public class BootstrapListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductRepository productRepository = new ProductRepository();

        productRepository.saveOrUpdate(new Product(null, "Product  1",
                "Description of product 1", new BigDecimal(100)));
        productRepository.saveOrUpdate(new Product(null, "Product  2",
                "Description of product 2", new BigDecimal(200)));
        productRepository.saveOrUpdate(new Product(null, "Product  3",
                "Description of product 3", new BigDecimal(200)));
        sce.getServletContext().setAttribute("productRepository", productRepository);

        CategoryRepository categoryRepository = new CategoryRepository();
        categoryRepository.saveOrUpdate(new Category(null, "Category 1",
                "Desc of category 1"));
        categoryRepository.saveOrUpdate(new Category(null, "Category 2",
                "Desc of category 2"));
        categoryRepository.saveOrUpdate(new Category(null, "Category 3",
                "Desc of category 3"));
        sce.getServletContext().setAttribute("categoryRepository", categoryRepository);
    }
}
