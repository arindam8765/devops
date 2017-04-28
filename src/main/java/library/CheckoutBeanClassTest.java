package library;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckoutBeanClassTest {
	
	public CheckoutBeanClass objCheckoutBeanClass;
	
	
	@Before
	public void setup()
	{
		objCheckoutBeanClass=new CheckoutBeanClass();
	}

	@Test
	public void validateMemberId() throws Exception
	{
		objCheckoutBeanClass.setMemberID("ABC");
		System.out.println("Hello from unit test");
		assertThat(objCheckoutBeanClass.getMemberID(), is("ABC"));

	}
	
	
	

}
