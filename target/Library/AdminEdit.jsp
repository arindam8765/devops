<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page import= "java.util.*" %>
<%@page import= "library.UserBeanClass2"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <%
           ArrayList arr=new ArrayList();
           arr=(ArrayList)request.getAttribute("MemberID");
           Iterator itr = arr.iterator();
           while(itr.hasNext())
           {
              UserBeanClass2 user=new UserBeanClass2();
              user=(UserBeanClass2)itr.next();

        %>
    <form action="AdminMemberUpdate" method="Get">
          <br><br><br><br>
              <center>Specify a MemberID to edit</center>
              <br>
                  <p align="center">
                      <table bgcolor="#e8eefa" cellpadding="7" cellspacing="4">
                          <tr>
                              <td>
                                  MemberID
                              </td>
                              <td>
                                  <input type="text" name="MemberID" value=" <%= user.getMemberID()%>"> 
                              </td>
                          </tr>
                          <%}%>
                      </table>
                      <p>&nbsp;</p>
                      <p>&nbsp;</p>
                      <center>Edit the required field</center>
                  </p>
                  <p align="center">
                  <table bgcolor="#e8eefa" cellpadding="7" cellspacing="4">
                  <tr>
                      <td>
                          Fullname:
                      </td>
                      <td>
                          <input type="text" name="Fullname">
                      </td>
                  </tr>
                  <tr>
                      <td>
                          Address:
                      </td>
                      <td>
                          <input type="text" name="Address">
                      </td>
                  </tr>
                  <tr>
                      <td>
                      </td>
                      <td>
                          <center><input type="submit" value="edit"></center>  
                      </td>
                  </tr>
                  </table>
                  </p>
      </form>
    </body>
</html>
