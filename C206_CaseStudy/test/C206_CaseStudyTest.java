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
		SV1=new Service("SV001", "Bathroom Renovation", 35);
		SV2=new Service("SV002", "Attic Conversion", 10);
		
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
		assertEquals("Check that Camcorder arraylist size is 2", 2, serviceList.size());
		assertSame("Check that Camcorder is added", SV2, serviceList.get(1));
	}

	@Test
	public void testRetrieveAllService() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", serviceList);
		
		//test if the list of services retrieved from the SourceCentre is empty - boundary
		String allServices= C206_CaseStudy.retrieveAllService(serviceList);
		String	testOutput = "";
		assertEquals("Check that ViewAllServicelist", testOutput, allServices);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		   C206_CaseStudy.addService(serviceList, SV1);
	       C206_CaseStudy.addService(serviceList, SV2);
		assertEquals("Test that Camcorder arraylist size is 2", 2, serviceList.size());
		
		//test if the expected output string same as the list of services retrieved from the SourceCentre	
		allServices= C206_CaseStudy.retrieveAllService(serviceList);
		testOutput = String.format("%-10s %-30s %-20s\n", "SV001", "Bathroom Renovation", "35");
		testOutput += String.format("%-10s %-30s %-20s\n","SV002", "Attic Conversion", "10");
	
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
		
	    //Test deleting from empty list-Boundary
	    C206_CaseStudy.deleteService(serviceList);
	    assertEquals("Check that the Service arraylist remains empty after deleting from an empty list", 0, serviceList.size());
	}
}
