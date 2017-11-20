<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
   <!-- <body>    -->
   <body bgcolor=#bdc3c7>
   <table width=100% align=center cellspacing="0" cellpadding="0" bgcolor=#C3D9FF>
      <tr>
          <br>
          <td style="font-family:arial;text-align:left;font-weight:bold;padding:5 0">
          	<center>Administrators' section</center>
          </td>
      </tr>
  </table>
 <br>
 <marquee>This is the updated page - 11/20/2017</marquee>
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
          <!-- table bgcolor="#d35400" cellpadding="5"> -->
              <tr>
                  <td>User ID:</td>
                  <td>
                      <input type="text" name="username">
                  </td>
              </tr>
              <tr>
                  <td>Password:</td>
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