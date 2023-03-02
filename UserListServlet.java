package cn.itcase.web.servlet;

import cn.itcase.domain.User;
import cn.itcase.service.UserService;
import cn.itcase.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用UserService完成查询
        UserService service= new UserServiceImpl();
        List<User> users=service.findAll();
        //2.将list存入reques域
        request.setAttribute("users",users);
        //3.转发到list.jsp页面
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
