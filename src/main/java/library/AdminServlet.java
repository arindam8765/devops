package library;

import java.io.*;
import java.net.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:library");
            Statement stmt1=con.createStatement();
            String sql1="select AdminName,Password from AdminDetails where AdminName='"+username+"'and Password='"+password+"'";
            ResultSet rs1=stmt1.executeQuery(sql1);
            if(rs1.next())
            {
                 session.getAttribute("name");
                 session.setAttribute("name",name);
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>Login Page</title>");
                 out.println("</head>");
                 out.println("<frameset cols=25%,75% border=2>");
                 out.println("<frame name=left src=AdminLink.html>");
                 out.println("<frame name=right>");
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
                 request.getRequestDispatcher("/Admin.jsp?method='"+s1+"'").forward(request,response);
                 session.invalidate();
                 rs1.close();
                 stmt1.close();
                 con.close();
                 out.close();
             }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
   
        