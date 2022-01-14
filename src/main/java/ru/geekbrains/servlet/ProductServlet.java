package ru.geekbrains.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;




@WebServlet(name = "ProductServlet", urlPatterns = "/product_servlet")
public class ProductServlet implements Servlet {

    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // Сохраняем полученную от сервера конфигурацию
        this.servletConfig = servletConfig;
    }

    // Метод вызывается для каждого нового HTTP запроса к данному сервлету
    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        ArrayList<Product> arrayList = new ArrayList<>();
        arrayList.add(new Product(1, "rice", 100));
        arrayList.add(new Product(2, "buckwheat", 130));
        arrayList.add(new Product(3, "potato", 90));
        arrayList.add(new Product(4, "sweet potato", 110));
        arrayList.add(new Product(5, "corn", 30));
        arrayList.add(new Product(6, "wheat", 40));
        arrayList.add(new Product(7, "brown rice", 120));
        arrayList.add(new Product(8, "barley", 35));
        arrayList.add(new Product(9, "oatmeal", 45));
        arrayList.add(new Product(10, "flakes", 76));

        for (int i = 0; i < 10; i ++) {
            servletResponse.getWriter().print("<h1>Product number " + arrayList.get(i).getId() + " " +
                    arrayList.get(i).getTitle() + " costs " +
                    arrayList.get(i).getCost() + " rubles" + "</h1>");
        }
    }

    @Override
    public String getServletInfo() {
        return "ProductServlet";
    }

    // При завершении работы веб приложения, контейнер вызывает этот метод для всех сервлетов из этого приложения
    @Override
    public void destroy() {
        getServletInfo();
    }
}
