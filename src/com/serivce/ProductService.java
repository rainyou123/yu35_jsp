package com.serivce;

import com.dao.ProductDao;
import com.domain.Category;
import com.domain.Product;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductDao productDao;
    public ProductService(){
        productDao=new ProductDao();
    }
    public List<Product> getAllProduct() throws SQLException {
        return productDao.getAllProduct();
    }

    public Product getProductById(String pid) throws SQLException {
        return productDao.getProductById(pid);
    }

    public List<Category> getAllCategory() throws SQLException {
        return productDao.getAllCategory();
    }

    public void addProduct(Product product) throws SQLException {
        productDao.addProduct(product);
    }
}
