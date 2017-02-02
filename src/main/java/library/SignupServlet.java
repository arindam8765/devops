package library;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.lang.String.*;
import javax.servlet.http.HttpServletResponse.*;
import java.sql.ResultSet.*;

public class SignupServlet extends HttpServlet
{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String fullname=request.getParameter("fullname");
        String address=request.getParameter("address");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(fullname+address+username+password);
        HttpSession session=request.getSession();
        String name=username; 
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/devops?user=root&password=password");
            Statement stmt=con.createStatement();
            String m1="select max(MemberID) from memberdetails";
            System.out.println(m1);
            ResultSet rs=stmt.executeQuery(m1);
            String id=rs.getString("MemberID");
            System.out.println(id);
            int j=Integer.parseInt(id);
            int k=j+1;
            String m2=String.valueOf(k);
            String sql="insert into MemberDetails values('"+m2+"','"+fullname+"','"+address+"','"+username+"','"+password+"')";
            int i=stmt.executeUpdate(sql);
            System.out.println(i);
            if(i==1)
            {
                 out.println("<html>");
                 out.println("<head>");
                 out.println("<title>You are a member</title>");
                 out.println("</head>");
                 out.println("<body>"); 
                 out.println("<h1>Welcome "+name+"</h1>");
                 out.println("You are a member now.");
                 out.println("<a href=Member.jsp>Login</a>");
                 out.println("</body>");
                 out.println("</html>");
                 
            }
           
        }
        catch(Exception ex)
        {
          ex.printStackTrace();
        }
    }
}