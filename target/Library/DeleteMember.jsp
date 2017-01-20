<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@page import= "java.util.*" %>
<%@page import= "library.AdminBeanClass"%>
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
            </tr>
            <% 
            ArrayList arr=new ArrayList();
            arr=(ArrayList)request.getAttribute("id");
            Iterator itr = arr.iterator();
            while(itr.hasNext())
            {
            AdminBeanClass admin=new AdminBeanClass();
            admin=(AdminBeanClass)itr.next();
            
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
            </tr>  
            <%}%>
        </table>
        
    </p>    
    
    </body>
</html>
