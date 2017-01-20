<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<html>
  <head>
    <title>MemberLogin Page</title>
    
  </head>
   <table width=100% align=center cellspacing="0" cellpadding="0" bgcolor=#C3D9FF>
      <tr>
          <br>
          <td style="font-family:arial;text-align:left;font-weight:bold;padding:5 0"><center>Member's section</center>
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
              <font size="+0"><center><b>Account</b></center></font>
          </td>
      </tr>
  </table>
  </p>
      
  <% if(request.getParameter("method")!=null){
         
         
      %>
 <center><%=request.getParameter("method")%></center>
      <%} %>
      <form action="UserServlet" method="get">
      <p align="center">
          <table bgcolor="lavender">
              <tr>
                  <td>
                      Username:
                  </td>
                  <td>
                      <input type="text" name="username">
                  </td>
              </tr>
              <tr>
                  <td>
                      Password:
                  </td>
                  <td>
                      <input type="password" name="password">
                  </td>
              </tr>
              <tr>
                  <td>   
                      <p align="center"> <input type="submit" value="submit"></p></center>
                  </td>
              </tr>
          </table>
      </p>
  </form>
  </body>
</html>

