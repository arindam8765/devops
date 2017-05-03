
package library;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminBookSearchServlet extends HttpServlet 
  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String BookTitle = request.getParameter("BookTitle");
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String userName = "root";
            String pwd = "password";
            String url = "jdbc:mysql://localhost:3306/devops?autoReconnect=true&useSSL=false";
            Connection con=DriverManager.getConnection(url,userName,pwd);
            Statement stmt=con.createStatement();
            ArrayList arr=new ArrayList();
            String sql1="select * from Books where BookTitle like '%"+BookTitle+"%'";
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
              request.setAttribute("BookTitle", arr);
              request.getRequestDispatcher("/AdminBookDisplay.jsp").forward(request,response);
            
                
           
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