import static org.junit.Assert.*;

<<<<<<< HEAD
=======
import java.io.ByteArrayInputStream;
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
<<<<<<< HEAD
	
private ArrayList<Service> serviceList;
private Service SV1;
private Service SV2;


public C206_CaseStudyTest() {
	super();
}
=======
	private ServiceProviders sp1;
	private ServiceProviders sp2;
	private ServiceProviders sp3;
	
	private ArrayList<ServiceProviders> serviceProvidersList;
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

	@Before
	public void setUp() throws Exception {
<<<<<<< HEAD
		SV1=new Service("SV001", "Bathroom Renovation", 35.00);
		SV2=new Service("SV002", "Attic Conversion", 10.00);
		
		serviceList = new ArrayList<Service>();
=======
		sp1 = new ServiceProviders("SP001","Aces Renovation",80);
		sp2 = new ServiceProviders("SP002","Stellar Services",90);
		sp3 = new ServiceProviders("SP003","Tucker's",50);
		serviceProvidersList = new ArrayList<ServiceProviders>();
		
		
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git
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
		C206_CaseStudy.addServiceProviders(serviceProvidersList, sp1);
		assertEquals("Test that the Service Providers arraylist size is now 1.", 1, serviceProvidersList.size());
		// Attempt to delete the existing service provider
		C206_CaseStudy.deleteProvider(serviceProvidersList);
		// Verify that the service provider is removed and appropriate message is shown
		assertEquals("Test that the Service Providers arraylist size is now 0.", 0, serviceProvidersList.size());
		
		//Test Case 2
		C206_CaseStudy.addServiceProviders(serviceProvidersList, sp1);
	    assertEquals("Test that the Service Providers arraylist size is now 1.", 1, serviceProvidersList.size());

	    // Attempt to delete a non-existing service provider
	    
	}
	
///
	@After
	public void tearDown() throws Exception {
		SV1=null;
		SV2=null;
		serviceList=null;
	}
	
	 @Test
	    public void testRetrieveAllService() {
	        // Test if Service list is not null but empty - boundary
	        assertNotNull("Test if there is valid Service arraylist to retrieve item", serviceList);
	        String allServices = C206_CaseStudy.retrieveAllService(serviceList);
	        String testOutput = "";
	        assertEquals("Check that serviceList is empty", testOutput, allServices);

	        // Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
	        C206_CaseStudy.addService(serviceList, SV1);
	        C206_CaseStudy.addService(serviceList, SV2);
	        assertEquals("Test that service arraylist size is 2", 2, serviceList.size());

	        // Test if the expected output string same as the list of services retrieved from the SourceCentre
	        allServices = C206_CaseStudy.retrieveAllService(serviceList);
	        testOutput = String.format("%-10s %-30s %-20.2f\n", "SV001", "Bathroom Renovation", 35.00);
	        testOutput += String.format("%-10s %-30s %-20.2f\n", "SV002", "Attic Conversion", 10.00);
	        // Ensure that retrieveAllService() returns an empty string for an empty list
	        serviceList.clear();
	        allServices = C206_CaseStudy.retrieveAllService(serviceList);
	        assertEquals("Check that ViewAllServicelist is empty for an empty list", "", allServices);

	        assertEquals("Test that ViewAllServices", testOutput, allServices);
	    }
	
	@Test
	public void testAddService() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Service arraylist to add to", serviceList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addService(serviceList, SV1);
		assertEquals("Check that Service arraylist size is 1", 1, serviceList.size());
		assertSame("Check that Service is added", SV1, serviceList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addService(serviceList, SV2);
		assertEquals("Check that Service arraylist size is 2", 2, serviceList.size());
		assertSame("Check that Servuce is added", SV2, serviceList.get(1));
		
		//Prevent duplicates in the list-Error
		Service duplicateService = new Service("SV001", "Duplicate Service", 50.00);
	    C206_CaseStudy.addService(serviceList, duplicateService);
	    assertEquals("Check that Service arraylist size is still 2 after adding a duplicate service", 2, serviceList.size());
	}
	

	@Test
<<<<<<< HEAD
	public void testDeleteService() {
	    // Item list is not null, so that can delete a new item - boundary
	    assertNotNull("Check if there is valid Service arraylist to delete from", serviceList);
	    
	    // Given list of 2 items, after adding, it has a length of 2:
	    // The item just added is as same as the first item of the list
	    C206_CaseStudy.addService(serviceList, SV1);
	    C206_CaseStudy.addService(serviceList, SV2);
	    assertEquals("Check that Service arraylist size is 2", 2, serviceList.size());
	    
	    // Delete the first item and check the size of the list - normal
	    C206_CaseStudy.deleteService(serviceList, "SV001");
	    assertEquals("Test that Service arraylist size is 1 after deleting one service", 1, serviceList.size());
	    assertFalse("Check that deleted service does not exist", serviceList.contains(SV1));
	    
	    // Delete the other item and test that the size of the list is 0 - normal
	    C206_CaseStudy.deleteService(serviceList, "SV002");
	    assertEquals("Test that Service arraylist size is 0 after deleting all services", 0, serviceList.size());
	    assertFalse("Check that deleted service does not exist", serviceList.contains(SV2));
	    
	    // Test deleting from an empty list - Boundary
	    C206_CaseStudy.deleteService(serviceList,"");
	    assertEquals("Check that the Service arraylist remains empty after deleting from an empty list", 0, serviceList.size());
=======

	
	
	//Hello World!
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

	    // Test error: Deleting a non-existing service should not cause any changes in the list
	    Service SV3 = new Service("SV003", "Non-Existing Service", 75.00);
	    C206_CaseStudy.addService(serviceList, SV3); // Add SV3 to test deletion
	    C206_CaseStudy.deleteService(serviceList, "SV004"); // Attempt to delete a non-existing service
	    assertEquals("Test that Service arraylist size remains 1 after attempting to delete a non-existing service",
	            1, serviceList.size());
	}
	
}
