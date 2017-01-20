<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import= "java.util.*" %>
<%@page import= "library.UserBeanClass"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

    
    <p align="center">
        <table border=1>
            <tr>
                <td>
                    BookID
                </td>
                <td>
                    BookTitle
                </td>
                <td>
                    Author
                </td>
                <td>
                    Subject
                </td>
                <td>
                    Quantity
                </td>
                <td>
                    
                </td>
            </tr>
            <% 
            ArrayList arr=new ArrayList();
            arr=(ArrayList)request.getAttribute("category");
            Iterator itr = arr.iterator();
            while(itr.hasNext())
            {
            UserBeanClass user=new UserBeanClass();
            user=(UserBeanClass)itr.next();
            
            %>   
            <tr>
                <td>
                    <%= user.getBookID() %>
                </td>
                <td>
                    <%= user.getBookTitle() %>
                </td>
                <td>
                    <%= user.getAuthor() %>
                </td>
                <td>
                    <%= user.getSubject() %>
                </td>
                <td>
                    <%= user.getQuantity() %>
                </td>
                <td>
                    <a href="UserIssueServlet?method=<%= user.getBookID() %>">Issue</a>
                </td>
            </tr>  
            <%}%>
        </table>
        
    </p>    
    
    </body>
</html>
