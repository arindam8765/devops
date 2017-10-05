<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login Page New</title>
    </head>
   <body>
   <table width=100% align=center cellspacing="0" cellpadding="0" bgcolor=#C3D9FF>
      <tr>
          <br>
          <td style="font-family:arial;text-align:left;font-weight:bold;padding:5 0"><center>Administrators' section</center>
          </td>
      </tr>
  </table>
 <br>
  <p align="center">
  <table>
      <tr>
          <td colspan="2" align="center">
              <font size="-1">
                  Login with your
              </font>
          </td>
      </tr>    
      <tr>
          <td>
              <font size="+0"><center><b>Credential</b></center></font>
          </td>
      </tr>
  </table>
  </p>
      
      <% if(request.getParameter("method")!=null){
         
         
      %>
 <center><%=request.getParameter("method")%></center>
      <%} %>
  <form action="AdminServlet" method="Get">
      <p align="center">
          <table bgcolor="#e8eefa" cellpadding="5">
              <tr>
                  <td> Enter Login Name :
                  </td>
                  <td>
                      <input type="text" name="username">
                  </td>
              </tr>
              <tr>
                  <td>
                      Enter Password:
                  </td>
                  <td>
                      <input type="password" name="password">
                  </td>
              </tr>
              <tr>
                  <td>   
                  </td>
                  <td>
                      <center><input type="submit" value="Login"></center>
                  </td>
              </tr>
          </table>
      </p>
  </form>
  </body>
</html>
