import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
private ArrayList<Service> serviceList;
private Service SV1;
private Service SV2;


public C206_CaseStudyTest() {
	super();
}

	@Before
	public void setUp() throws Exception {
		SV1=new Service("SV001", "Bathroom Renovation", 35.00);
		SV2=new Service("SV002", "Attic Conversion", 10.00);
		
		serviceList = new ArrayList<Service>();
	}

	@After
	public void tearDown() throws Exception {
		SV1=null;
		SV2=null;
		serviceList=null;
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
	public void testRetrieveAllService() {
		// Test if Service list is not null but empty -boundary
		assertNotNull("Test if there is valid Service arraylist to retrieve item", serviceList);
		
		//test if the list of services retrieved from the SourceCentre is empty - boundary
		String allServices= C206_CaseStudy.retrieveAllService(serviceList);
		String	testOutput = "";
		assertEquals("Check that ViewAllServicelist", testOutput, allServices);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		   C206_CaseStudy.addService(serviceList, SV1);
	       C206_CaseStudy.addService(serviceList, SV2);
		assertEquals("Test that service arraylist size is 2", 2, serviceList.size());
		
		//test if the expected output string same as the list of services retrieved from the SourceCentre	
		allServices= C206_CaseStudy.retrieveAllService(serviceList);
		testOutput = String.format("%-10s %-30s %-20s\n", "SV001", "Bathroom Renovation", "35.00");
		testOutput += String.format("%-10s %-30s %-20s\n","SV002", "Attic Conversion","10.00");
		// Ensure that retrieveAllService() returns an empty string for an empty list-Error
	    serviceList.clear();
	    allServices = C206_CaseStudy.retrieveAllService(serviceList);
	    assertEquals("Check that ViewAllServicelist is empty for an empty list", "", allServices);
	
		assertEquals("Test that ViewAllServices", testOutput, allServices);
		
	}
	@Test
	public void testDeleteService() {
		// Item list is not null, so that can delete a new item - boundary
		assertNotNull("Check if there is valid Service arraylist to delete from", serviceList);
		//Given list of 2 items, after adding, it has a length of 2:
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addService(serviceList, SV1);
		C206_CaseStudy.addService(serviceList, SV2);
		assertEquals("Check that Service arraylist size is 2", 2, serviceList.size());
		//Delete the first item and check the size of the list - normal
		C206_CaseStudy.deleteService(serviceList);
	    assertEquals("Test that Service arraylist size is 1 after deleting one service", 1, serviceList.size());
	    assertFalse("Check that deleted service does not exist", serviceList.contains(SV1));
		
		//Delete other item. test The size of the list is 0 -normal
	    C206_CaseStudy.deleteService(serviceList);
	    assertEquals("Test that Service arraylist size is 0 after deleting all services", 0, serviceList.size());
	    assertFalse("Check that deleted service does not exist", serviceList.contains(SV2));
	    
	    //Test deleting from empty list-Boundary
	    C206_CaseStudy.deleteService(serviceList);
	    assertEquals("Check that the Service arraylist remains empty after deleting from an empty list", 0, serviceList.size());
	
	 //Test Error Deleting a non-existing service should not cause any changes in the list
	    Service SV3 = new Service("SV003", "Non-Existing Service", 75.00);
	    C206_CaseStudy.addService(serviceList, SV3);
	    C206_CaseStudy.deleteService(serviceList);
	    assertEquals("Test that Service arraylist size remains 2 after attempting to delete a non-existing service",
	            2, serviceList.size());
	}
}
