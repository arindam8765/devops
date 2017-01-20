<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import= "java.util.*" %>
<%@page import= "library.UserBeanClass2"%>
<html>
   
    <body>



    <table border=1>
        <tr>
            <td>
                MemberID
            </td>
            <td>
                Fullname
            </td>
            <td>
                Address
            </td>
            <td>
                Username
            </td>
            <td>
                Password
            </td>
            <td>
                Delete
            </td>
            <td>
                Edit
            </td>

        </tr>
        <%
           ArrayList arr=new ArrayList();
           arr=(ArrayList)request.getAttribute("MemberID");
           Iterator itr = arr.iterator();
           while(itr.hasNext())
           {
              UserBeanClass2 user=new UserBeanClass2();
              user=(UserBeanClass2)itr.next();

        %>
        <tr>
            <td>
                <%= user.getMemberID() %>
            </td>
            <td>
                <%= user.getFullname() %>
            </td>
            <td>
                <%= user.getAddress() %>
            </td>
            <td>
                <%= user.getUsername() %>
            </td>
            <td>
                <%= user.getPassword() %>
            </td>
            <td>
                <a href="AdminEditServlet2?method=<%= user.getMemberID() %>">Edit</a>        
            </td>
            <td>
                <a href="AdminDeleteServlet2?method=<%= user.getMemberID() %>">Delete</a>
            </td>
        </tr>
        <%}%>
    </table>


    </body>
</html>
