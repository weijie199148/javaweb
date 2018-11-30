package com.csh.servlet;

import search.DingLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 2018/11/1.
 */
@WebServlet(name = "ServletRequst")
public class ServletRequst extends HttpServlet {
    //String loginTmpCode = "";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8"); // 处理响应乱码问题:字节流需getBytes("UTF-8")
        //String loginTmpCodeNew = request.getParameter(loginTmpCode);
        String code=new String(request.getParameter("code").getBytes("ISO8859-1"),"UTF-8");
        DingLogin dingLogin=new DingLogin();
        String name1=dingLogin.goDingLogin(code);
        String name=new String(name1.getBytes("utf-8"),"UTF-8");
        //System.out.println(name);
        HttpSession session=request.getSession();
       // Map sessionmap=new HashMap();
        //sessionmap.put("name",name);
        //sessionmap.put("gettodayuserbyname",SearchDao.gettodayuserbyname());
        session.setAttribute("username",name);
        //String loginTmpCode=new String(request.getParameter("loginTmpCode").getBytes("ISO8859-1"),"UTF-8");
        //System.out.println(code);
        //request.getRequestDispatcher("/index.jsp").forward(request,response);
        //扫码登录后重定向到首页，注意：使用forward转发不能改变地址栏的信息，使用重定向response.sendRedirect()，可以改变地址信息
        response.sendRedirect("/javawebservlet/index.jsp");
    }
}
