package com.dao;

import com.domain.Category;
import com.domain.Product;
import com.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    private QueryRunner qr;
    public ProductDao(){
        qr=new QueryRunner(C3P0Utils.getDataSource());
    }
    public List<Product> getAllProduct() throws SQLException {
        QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
        String sql="select * from product";
        return qr.query(sql, new BeanListHandler<>(Product.class));
    }

    public Product getProductById(String pid) throws SQLException {
        String sql="select * from product where pid=?";
        return qr.query(sql,new BeanHandler<>(Product.class),pid);
    }

    public List<Category> getAllCategory() throws SQLException {
        String sql="select * from category";
        return qr.query(sql,new BeanListHandler<>(Category.class));
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql , product.getPid() , product.getPname()
                , product.getMarket_price() , product.getShop_price()
                , product.getPimage() , product.getPdate() , product.getIs_hot()
                , product.getPdesc() , product.getPflag() , product.getCid());
    }
}
