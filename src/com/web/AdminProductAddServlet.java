package com.web;

import com.domain.Product;
import com.serivce.ProductService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class AdminProductAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//            解决从前端获取数据乱码问题
            req.setCharacterEncoding("utf-8");
            Product product=new Product();
            BeanUtils.populate(product,req.getParameterMap());
            //手动放入前端没有自动映射的数据pid pimage pflag pdate
            product.setPid(UUID.randomUUID().toString());
            System.out.println(product.getPid());
            product.setPimage("products/1/c_0044.jpg");
            product.setPflag(0);
            product.setPdate(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date().getTime()));
            ProductService productService=new ProductService();
            productService.addProduct(product);

            resp.sendRedirect(req.getContextPath()+"/adminProductList");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
