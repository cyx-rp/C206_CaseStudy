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
		//Test Case 1
		// Service Providers list is not null and it is empty
				assertNotNull("Test if there is valid Service Providers arraylist to add to", serviceProvidersList);
				assertEquals("Test that the Service Providers arraylist is currently empty.", 0, serviceProvidersList.size());
				//Given an empty list, after adding 1 item, the size of the list is 1
				C206_CaseStudy.addServiceProviders(serviceProvidersList, sp1);		
				assertEquals("Test that the Service Providers arraylist size is now 1.", 1, serviceProvidersList.size());
				
				//Test Case 2
				// Add a Service provider
				C206_CaseStudy.addServiceProviders(serviceProvidersList, sp2);
				assertEquals("Test that the Service Providers arraylist size is now 2.", 2, serviceProvidersList.size());
				//The item just added is as same as the last item in the list
				assertSame("Test that Service Provider is added to the end of the list.", sp2, serviceProvidersList.get(1));
				
				//Test Case 3
				// Add a service provider that already exists in the list
				C206_CaseStudy.addServiceProviders(serviceProvidersList, sp2);
				assertEquals("Test that the Service Provider arraylist size is unchanged.", 2, serviceProvidersList.size());
				
				//Test Case 4
				// Add a service provider that has missing details
				ServiceProviders cc_missing = new ServiceProviders("SP005", "", 60);
				C206_CaseStudy.addServiceProviders(serviceProvidersList, cc_missing);
				assertEquals("Test that the Service Provider arraylist size is unchanged.", 2, serviceProvidersList.size());
	}
	
	@Test
	public void testViewServiceProvider() {
		//Test Case 1
				// Test if Item list is not null and empty
				assertNotNull("Test if there is valid Service Providers arraylist to add to", serviceProvidersList);
				assertEquals("Test that the Service Providers arraylist is empty.", 0, serviceProvidersList.size());
				// Attempt to retrieve the Service Providers 
				String allProviders= C206_CaseStudy.retrieveAllServiceProviders(serviceProvidersList);
				String testOutput = ""; 
				// Test if the output is empty
				assertEquals("Test that nothing is displayed", testOutput, allProviders);

				//Test Case 2
				C206_CaseStudy.addServiceProviders(serviceProvidersList, sp1);
				C206_CaseStudy.addServiceProviders(serviceProvidersList, sp2);
				// Test that the list is not empty
				assertEquals("Test that Service Providers arraylist size is 2.", 2, serviceProvidersList.size());
				// Attempt to retrieve the Service Providers 
				allProviders= C206_CaseStudy.retrieveAllServiceProviders(serviceProvidersList);
				testOutput = String.format("%-10s %-30s %-20f\n","SP001", "Aces Renovation", 80.00);
				testOutput += String.format("%-10s %-30s %-20f\n","SP002", "Stellar Services", 90.00);
				// Test that the details are displayed correctly
				assertEquals("Test that the display is correct.", testOutput, allProviders);

				//Test Case 3
				sp3.setIsAvailable(false);
				C206_CaseStudy.addServiceProviders(serviceProvidersList, sp3);
				assertEquals("Test that Camcorder arraylist size is 2.", 3, serviceProvidersList.size());
				assertFalse("Test that the last item in the arraylist is not available", serviceProvidersList.get(2).getIsAvailable());
				// Attempt to retrieve the Service Providers 
				allProviders= C206_CaseStudy.retrieveAllServiceProviders(serviceProvidersList);
				testOutput = String.format("%-10s %-30s %-20f\n","SP001", "Aces Renovation", 80.00);
				testOutput += String.format("%-10s %-30s %-20f\n","SP002", "Stellar Services", 90.00);
				testOutput += String.format("%-10s %-30s %-20f\n","SP003", "Tucker's", 50.00);
				// Test that the details are displayed correctly
				assertEquals("Test that the display is correct.", testOutput, allProviders);
	}
	
	@Test
	public void testDeleteServiceProvider() {
		//Test Case 1
		assertNotNull("Test if there is valid Service Providers arraylist to add to", serviceProvidersList);
		assertEquals("Test that the Service Providers arraylist is empty.", 0, serviceProvidersList.size());
	    
	}
	
///
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
