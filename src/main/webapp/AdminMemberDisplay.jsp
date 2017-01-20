<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import= "java.util.*" %>
<%@page import= "library.CheckoutBeanClass"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
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
                BookID
            </td>
            <td>
                BookTitle
            </td>
            <td>
                DateBorrowed
            </td>
            <td>
                Username
            </td>
            <td>
                Password
            </td>
        </tr>
        <% 
           ArrayList arr=new ArrayList();
           arr=(ArrayList)request.getAttribute("MemberID");
           Iterator itr = arr.iterator();
           while(itr.hasNext())
           {
              CheckoutBeanClass user=new CheckoutBeanClass();
              user=(CheckoutBeanClass)itr.next();
           
        %>   
        <tr>
            <td>
                <%= user.getMemberID() %>
            </td>
            <td>
                <%= user.getFullname() %>
            </td>
            <td>
                <%= user.getBookID() %>
            </td>
             <td>
                <%= user.getBookTitle() %>
            </td>
             <td>
                <%= user.getDateBorrowed() %>
            </td>
            <td>
                <%= user.getUsername() %>
            </td>
             <td>
                <%= user.getPassword() %>
            </td>
        </tr>  
        <%}%>
    </table>
    
    
    </body>
</html>
