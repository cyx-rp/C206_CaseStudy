import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	
	private Request rq1;
	private Request rq2;
    private Service sv1;
    private Service sv2;
	private User us1;
   	private User us2;

   	private ArrayList<User> userList;
   	private ArrayList<Service> serviceList;
	private ArrayList<Request> requestsList;

	@Before
	public void setUp() throws Exception {
        sv1 = new Service("SV001", "Bathroom Renovation", 35.00);
        sv2 = new Service("SV002", "Attic Conversion", 10.00);
        us1 = new User("Jane", "janetan", "janetan@gmail.com", 12345678, "13 Cranberry Drive");
        us2 = new User("Bill", "billong", "billong@gmail.com", 87654321, "7 Strawberry Drive");
		rq1 = new Request("RQ001","Jane","janetan","Bathroom Renovation");
		rq2 = new Request("RQ002","Bill","billong", "Attic Conversion");
        sv1 = new Service("SV001", "Bathroom Renovation", 35.00);
        sv2 = new Service("SV002", "Attic Conversion", 10.00);
		
		userList=new ArrayList<User> ();
		serviceList=new ArrayList<Service> ();
		requestsList = new ArrayList<Request>();
	}

	@After
	public void tearDown() throws Exception {
		rq1 = null;
		rq2 = null;
		requestsList = null;
		us1 = null;
		us2 = null;
		userList = null;
		sv1 = null;
		sv2 = null;
		serviceList = null;
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

	@Test
	public void testRetrieveAllRequests() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Request arraylist to retrieve item", requestsList);
		
		//test if the list of requests retrieved from the SourceCentre is empty - boundary
		String retrieveAllRequests = C206_CaseStudy.retrieveAllRequests(requestsList);
		String testOutput = "";
		assertEquals("Check that ViewAllRequestslist", testOutput, retrieveAllRequests);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addService(serviceList, sv1);
		C206_CaseStudy.addService(serviceList, sv2);
		C206_CaseStudy.addUser(userList, us1);
		C206_CaseStudy.addUser(userList, us2);
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq1);
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq2);
		assertEquals("Test that Request arraylist size is 2", 2, requestsList.size());
		
		//test if the expected output string same as the list of requests retrieved from the CaseStudy	
		retrieveAllRequests = C206_CaseStudy.retrieveAllRequests(requestsList);
		testOutput = String.format("%-10s %-20s %-30s %-20s\n", "RQ001","Jane","Bathroom Renovation","pending");
		testOutput += String.format("%-10s %-20s %-30s %-20s\n","RQ002","Bill","Attic Conversion","pending");

		assertEquals("Test that ViewAllRequestslist", testOutput, retrieveAllRequests);
		
		//test that there are no empty fields in the items
		for (int i = 0; i<requestsList.size();i++) {
			Request request = requestsList.get(i);
	        assertNotNull("ID should not be empty", request.getId());
	        assertNotNull("Username should not be empty", request.getUsername());
	        assertNotNull("Description should not be empty", request.getDescription());
	        assertNotNull("Quote status should not be empty", request.getQuoteStatus());
		}
	}
	
	@Test
	public void testAddRequest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Request arraylist to add to", requestsList);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		C206_CaseStudy.addService(serviceList, sv1);
		C206_CaseStudy.addService(serviceList, sv2);
		C206_CaseStudy.addUser(userList, us1);
		C206_CaseStudy.addUser(userList, us2);
		//The item just added is as same as the first item of the list
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq1);
		assertEquals("Check that Request arraylist size is 1", 1, requestsList.size());
		assertSame("Check that Request is added", rq1, requestsList.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq2);
		assertEquals("Check that Request arraylist size is 2", 2, requestsList.size());
		assertSame("Check that Request is added", rq2, requestsList.get(1));
		
		//test for relevant fields are missing	    
		requestsList.clear();
	    Request quoteRequest = new Request("", "", "", "");
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,quoteRequest);
		assertEquals("Check that Request arraylist size is 0", 0, requestsList.size());
		
		//test for user login is wrong and not added into the list - error
	    requestsList.clear();
	    Request quoteRequest1 = new Request("RQ001", "username", "password", "Bathroom Renovation");
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,quoteRequest1);
		assertFalse("Check that request is not added", requestsList.contains(quoteRequest1));
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq1);
		assertTrue("Check that request is added", requestsList.contains(rq1));
		
		//test that service does not exist - error
	    requestsList.clear();
	    Request quoteRequest2 = new Request("RQ001", "Jane", "janetan", "description");
	    C206_CaseStudy.addRequest(requestsList, userList, serviceList, quoteRequest2);
	    assertEquals("Check that Request arraylist size is 0", 0, requestsList.size());

	}
	
	@Test
	public void testDeleteRequest() {
		// Item list is not null and not empty so that can delete a item - boundary
		assertNotNull("Test if there is valid Request arraylist to add to", requestsList);
		// Item list is not empty so that the list has values to delete - normal
		C206_CaseStudy.addService(serviceList, sv1);
		C206_CaseStudy.addService(serviceList, sv2);
		C206_CaseStudy.addUser(userList, us1);
		C206_CaseStudy.addUser(userList, us2);
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq1);
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq2);
		assertEquals("Test that the Request arraylist is not empty and has a arraylist size of 2", 2, requestsList.size());
		
		//Given array list is 2, after deleting 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.deleteRequest(requestsList,"Jane","janetan","RQ001");
		// Verify that the service provider is removed and appropriate message is shown
		assertEquals("Test that the request arraylist size is now 1.", 1, requestsList.size());
		
		//Given array list is 1, after deleting 1 item, the size of the list is 0 - normal
		//The item just added is as same as the first item of the list
		C206_CaseStudy.deleteRequest(requestsList,"Bill","billong","RQ002");
		// Verify that the service provider is removed and appropriate message is shown
		assertEquals("Test that the request arraylist size is now 0.", 0, requestsList.size());
		
		//test for user login is wrong and not added into the list - error
	    requestsList.clear();
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq1);
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq2);
		C206_CaseStudy.deleteRequest(requestsList,"username","password","RQ001");
		assertTrue("Check that request is not removed", requestsList.contains(rq1));
		C206_CaseStudy.deleteRequest(requestsList,"Jane","janetan","RQ001");
		assertFalse("Check that request is removed", requestsList.contains(rq1));
		
		//Delete a Non-Existing request - error
		requestsList.clear();
		// Item list is not empty so that the list has values to delete
		C206_CaseStudy.addRequest(requestsList,userList,serviceList,rq1);
	    int initialSize = requestsList.size();
	    assertEquals("Test that the Service Providers arraylist size is now 1.", 1, requestsList.size());
	    // Attempt to delete a non-existing request
	    C206_CaseStudy.deleteRequest(requestsList,"Jane","janetan","RQ002");
	    // Verify that the service provider list size remains the same
	    assertEquals("Test that the Service Providers arraylist size remains 1.", initialSize, requestsList.size());
	    
	    //Delete from empty List - error
	    requestsList.clear();
	    // Attempt to delete a value from an empty list
	    
	    C206_CaseStudy.deleteRequest(requestsList,"Jane","janetan","RQ001");
	    // Verify that request list size remains 0 and appropriate message is shownd
	    assertEquals("Test that the Service Providers arraylist size remains 0.", 0, requestsList.size());
	}
	
}
