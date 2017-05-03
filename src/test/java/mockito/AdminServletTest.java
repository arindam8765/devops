package mockito;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import junit.framework.TestCase;
import org.junit.Test;
import library.AdminServlet;
import static org.mockito.Mockito.*;

public class AdminServletTest 
{
	@Test
	public void testServlet() throws ServletException, IOException
	{
		HttpServletRequest req = mock(HttpServletRequest.class);
		HttpServletResponse res = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		
		when(req.getParameter("username")).thenReturn("Arindam");
		when(req.getParameter("password")).thenReturn("devops123");
		when(req.getSession()).thenReturn(session);

		StringWriter sw = new StringWriter();
		PrintWriter pw  =new PrintWriter(sw);

		when(res.getWriter()).thenReturn(pw);

		AdminServlet test =new AdminServlet();
		test.doGet(req, res);
		
		String result = sw.getBuffer().toString().trim();
		//System.out.println(result);
		TestCase.assertNotNull(result);
		
	}
	
}
