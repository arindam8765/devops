package library;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserSearchServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String category = request.getParameter("category");
        String value = request.getParameter("items");
        out.println(value);
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            String userName = "root";
            String pwd = "password";
            String url = "jdbc:mysql://localhost:3306/devops?autoReconnect=true&useSSL=false";
            Connection con=DriverManager.getConnection(url,userName,pwd);
            Statement stmt=con.createStatement();
            ArrayList arr=new ArrayList();
            if(category.equals("BookTitle"))
            {
                String sql1="select * from Books where BookTitle like '%"+value+"%'";
                ResultSet rs1=stmt.executeQuery(sql1);
                
                if(rs1.next())
                {
                   HttpSession session=request.getSession(true);
                    UserBeanClass user=new UserBeanClass();
                    user.setBookID(rs1.getString("BookID"));
                    user.setBookTitle(rs1.getString("BookTitle"));
                    user.setAuthor(rs1.getString("Author"));
                    user.setSubject(rs1.getString("Subject"));
                    user.setQuantity(rs1.getString("Quantity"));
                    arr.add(user);

              }
              request.setAttribute("category", arr);
              request.getRequestDispatcher("/UserDisplay.jsp").forward(request,response);
            }
                
            if(category.equals("Author"))
            {
                String sql2="select * from Books where Author like '%"+value+"%'";
                ResultSet rs2=stmt.executeQuery(sql2);
                
                if(rs2.next())
                {
                   HttpSession session=request.getSession(true);
                    UserBeanClass user=new UserBeanClass();
                    user.setBookID(rs2.getString("BookID"));
                    user.setBookTitle(rs2.getString("BookTitle"));
                    user.setAuthor(rs2.getString("Author"));
                    user.setSubject(rs2.getString("Subject"));
                    user.setQuantity(rs2.getString("Quantity"));
                    arr.add(user);

              }
              request.setAttribute("category", arr);
              request.getRequestDispatcher("/UserDisplay.jsp").forward(request,response);
            }
        
            if(category.equals("Subject"))
            {
                String sql3="select * from Books where Subject like '%"+value+"%'";
                ResultSet rs3=stmt.executeQuery(sql3);
               
                if(rs3.next())
                {
                   HttpSession session=request.getSession(true);
                    UserBeanClass user=new UserBeanClass();
                    user.setBookID(rs3.getString("BookID"));
                    user.setBookTitle(rs3.getString("BookTitle"));
                    user.setAuthor(rs3.getString("Author"));
                    user.setSubject(rs3.getString("Subject"));
                    user.setQuantity(rs3.getString("Quantity"));
                    arr.add(user);

              }
              request.setAttribute("category", arr);
              request.getRequestDispatcher("/UserDisplay.jsp").forward(request,response);
            }
           
                 stmt.close();
                 con.close();
                 out.close();
             }
              
        catch(Exception ex)
        {
            out.println(ex);
         }
    }
} 