package library;

import java.io.*;
import java.net.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HttpSession session=request.getSession();
        String name=username;  
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/devops?user=root&password=password");
            Statement stmt1=con.createStatement();
            String sql1="select Username,Password from MemberDetails where Username='"+username+"'and Password='"+password+"'";
            ResultSet rs1=stmt1.executeQuery(sql1);
             if(rs1.next())
            {
                 session.getAttribute("name");
                 session.setAttribute("name",name);
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Login Page</title>");
                 out.println("<frameset cols=25%,75% border=2>");
                 out.println("<frame name=left src=Search.html>");
                 out.println("<frame name=right>");
                 out.println("</head>");
                 out.println("<body>");
                 out.println("</body>");
                 out.println("</html>");
                 rs1.close();
                 stmt1.close();
                 con.close();
                 out.close();
             }
             else 
             {
                 String s1="Login failed";
                 request.getRequestDispatcher("/Member.jsp?method='"+s1+"'").forward(request,response);
                 session.invalidate();
                 rs1.close();
                 stmt1.close();
                 con.close();
                 out.close();
             }
           }
        catch(Exception ex)
        {
            out.println(ex);
         }
    }
} 