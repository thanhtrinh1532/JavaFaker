/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package trinh.dev;

import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import trinh.dev.data.dao.CategoryDao;
import trinh.dev.data.dao.DatabaseDao;
import trinh.dev.data.dao.ProductDao;
import trinh.dev.data.model.Category;
import trinh.dev.data.model.Product;

/**
 *
 * @author USER
 */
public class CategoryServlet extends BaseServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = new ArrayList<>();
        
        if(request.getParameter("property") !=null && request.getParameter("order") !=null){
            String property = request.getParameter("property");
            String order = request.getParameter("order");
            productList = productDao.filter(categoryId, property, order);
        }  else{ 
            productList=null; //thầy dùng findByCategory(categoryId)
        }
        
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        Category category = categoryDao.find(categoryId);
        
        request.setAttribute("productList", productList);
        request.setAttribute("category", category);
        request.getRequestDispatcher("category.jsp").include(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 
}
