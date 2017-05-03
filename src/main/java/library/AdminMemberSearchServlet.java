
package library;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminMemberSearchServlet extends HttpServlet 
  {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String MemberID = request.getParameter("MemberID");
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            String userName = "root";
            String pwd = "password";
            String url = "jdbc:mysql://localhost:3306/devops?autoReconnect=true&useSSL=false";
            Connection con=DriverManager.getConnection(url,userName,pwd);
            Statement stmt=con.createStatement();
            ArrayList arr=new ArrayList();
            String sql1="select m.MemberID,m.Fullname,m.Username,m.Password,c.BookId,c.BookTitle,c.DateBorrow from MemberDetails m,Checkout c where m.MemberID='"+MemberID+"'and m.MemberID=c.MemberID";
            ResultSet rs1=stmt.executeQuery(sql1);
                
              if(rs1.next())
              {
                    HttpSession session=request.getSession(true);
                    
                    CheckoutBeanClass c=new CheckoutBeanClass();
                    c.setMemberID(rs1.getString("MemberID"));
                    c.setFullname(rs1.getString("Fullname"));
                    c.setDateBorrowed(rs1.getDate("DateBorrowed").toString());
                    c.setUsername(rs1.getString("Username"));
                    c.setPassword(rs1.getString("Password"));
                    c.setBookID(rs1.getString("BookID"));
                    c.setBookTitle(rs1.getString("BookTitle"));
                    arr.add(c);

              }
              request.setAttribute("MemberID", arr);
              request.getRequestDispatcher("/AdminMemberDisplay.jsp").forward(request,response);
            
                
           
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