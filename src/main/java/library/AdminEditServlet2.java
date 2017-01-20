package library;

import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminEditServlet2 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String memberid=request.getParameter("method");
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:library");
            Statement stmt=con.createStatement();
            ArrayList arr=new ArrayList();
            String sql1="select * from MemberDetails where MemberID='"+memberid+"'"; 
            ResultSet rs1=stmt.executeQuery(sql1);
                
            if(rs1.next())
            {
                 
                    HttpSession session=request.getSession(true);
                    UserBeanClass2 user=new UserBeanClass2();
                    user.setMemberID(rs1.getString("MemberID"));
                    user.setFullname(rs1.getString("Fullname"));
                    user.setAddress(rs1.getString("Address"));
                    arr.add(user);

              }
              request.setAttribute("MemberID", arr);
              request.getRequestDispatcher("/AdminEdit.jsp").forward(request,response);
            
                
           
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