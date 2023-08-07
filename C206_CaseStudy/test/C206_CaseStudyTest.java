import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private ServiceProviders sp1;
	private ServiceProviders sp2;
	private ServiceProviders sp3;
	
	private ArrayList<ServiceProviders> serviceProvidersList;

	@Before
	public void setUp() throws Exception {
		sp1 = new ServiceProviders("SP001","Aces Renovation",80);
		sp2 = new ServiceProviders("SP002","Stellar Services",90);
		sp3 = new ServiceProviders("SP003","Tucker's",50);
		serviceProvidersList = new ArrayList<ServiceProviders>();
		
		
	}
	
	@Test
	public void testAddServiceProvider() {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
