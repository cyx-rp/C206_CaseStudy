import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

    private Service sv1;
	private Service sv2;
    private ServiceProviders sp1;
	private ServiceProviders sp2;
	private ServiceProviders sp3;
	private User us1;
   	private User us2;
	private Request rq1;
	private Request rq2;
	private Quote q1;
	private Quote q2;
	
	private ArrayList<ServiceProviders> serviceProvidersList;
	private ArrayList<User> userList;
	private ArrayList<Request> requestsList;
    private ArrayList<Service> serviceList;
    private ArrayList<Quote> quotesList;


	@Before
	public void setUp() throws Exception {
		sp1 = new ServiceProviders("SP001","Aces Renovation",80);
		sp2 = new ServiceProviders("SP002","Stellar Services",90);
		sp3 = new ServiceProviders("SP003","Tucker's",50);
        us1 = new User("Jane", "janetan", "janetan@gmail.com", 12345678, "13 Cranberry Drive");
        us2 = new User("Bill", "billong", "billong@gmail.com", 87654321, "7 Strawberry Drive");
		rq1 = new Request("RQ001","Jane","janetan","Bathroom Renovation");
		rq2 = new Request("RQ002","Bill","billong", "Attic Conversion");
        sv1 = new Service("SV001", "Bathroom Renovation", 35.00);
		sv2 = new Service("SV002", "Attic Conversion", 10.00);
		q1 = new Quote("Q001","Install fluted panel", 150);
		q2 = new Quote("Q002","Polish parquet", 200);
		
		userList = new ArrayList<User>();
		serviceList=new ArrayList<Service> ();
		serviceProvidersList = new ArrayList<ServiceProviders>();	
		requestsList = new ArrayList<Request>();		
		quotesList = new ArrayList<Quote>();
	}
	
	@Test
	public void testAddService() {  // Item list is not null, so that can add a new service - boundary
	    assertNotNull("Check if there is valid Service arraylist to add to", serviceList);    
	    //Given an empty list, after adding 1 item, the size of the list is 1 - normal
	    //The item just added is as same as the first item of the list    
	    C206_CaseStudy.addService(serviceList, sv1);
	    assertEquals("Check that Service arraylist size is 1", 1, serviceList.size());    
	    assertSame("Check that Service is added", sv1, serviceList.get(0));
	        //Add another service. test The size of the list is 2? -normal
	    //The item just added is as same as the second item of the list    
	    C206_CaseStudy.addService(serviceList, sv2);
	    assertEquals("Check that Camcorder arraylist size is 2", 2, serviceList.size());    
	    assertSame("Check that Camcorder is added", sv2, serviceList.get(1));
	     //Prevent duplicates in the list-Error
	    Service duplicateService=new Service("SV001","Duplicate Service",50.00);    
	    C206_CaseStudy.addService(serviceList, duplicateService);
	    assertEquals("Check that Service arrayList size is still 2 after adding a duplicate service",2,serviceList.size()); }
	
	@Test
	public void testAddUser() {
  	  // Item list is not null, so that can add a new item - boundary
  	  assertNotNull("Check if there is valid User arraylist to add to", userList);
  	  //Given an empty list, after adding 1 item, the size of the list is 1 - normal
  	  //The item just added is as same as the first item of the list
  	  C206_CaseStudy.addUser(userList, us1);
  	  assertEquals("Check that User arraylist size is 1", 1, userList.size());
  	  assertSame("Check that User is added", us1, userList.get(0));
  	 
  	  //Add another item. test The size of the list is 2? -normal
  	  //The item just added is as same as the second item of the list
  	  C206_CaseStudy.addUser(userList, us2);
  	  assertEquals("Check that User arraylist size is 2", 2, userList.size());
  	  assertSame("Check that User is added", us2, userList.get(1));
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
    public void testAddQuote() { 
        ArrayList<Quote> quotesList = new ArrayList<>(); 
        Quote q = new Quote("ID123", "Info", 100.0, "Provider123", "Request123"); 
 
        C206_CaseStudy.addQuote(quotesList, q); 
        assertTrue(quotesList.contains(q)); 
 
        // Test adding a duplicate quote 
        C206_CaseStudy.addQuote(quotesList, q); 
        assertEquals(1, quotesList.size()); 
 
        // Test adding a valid quote 
        Quote validQuote = new Quote("ID123", "Additional Info", 100.0, "Provider123", "Request123"); 
        C206_CaseStudy.addQuote(quotesList, validQuote); 
        assertEquals("Check that Quote is added", 1, quotesList.size()); 
        assertTrue("Check that Quote is in the list", quotesList.contains(validQuote)); 
 
        // Test adding a duplicate quote 
        C206_CaseStudy.addQuote(quotesList, validQuote); 
        assertEquals("Check that duplicate Quote is not added", 1, quotesList.size()); 
 
        // Test adding a quote with missing fields 
        Quote quoteWithMissingFields = new Quote("", "", 0.0, "", ""); 
        C206_CaseStudy.addQuote(quotesList, quoteWithMissingFields); 
        assertEquals("Check that Quote with missing fields is not added", 1, quotesList.size()); 
    } 
	
	//testViewAllUsers
    @Test
    public void testViewAllUsers() {
  	  // Test if list is not null but empty -boundary
  	  assertNotNull("Test if there is valid User arraylist to retrieve item", userList);
  	 
  	  //test if the list of users retrieved from the SourceCentre is empty - boundary
  	  String allUsers = C206_CaseStudy.viewAllUsers(userList);
  	  String testOutput = "";
  	  assertEquals("Check that viewAllUsers", testOutput, allUsers);
  	 
  	  //Given an empty list, after adding 2 users, test if the size of the list is 2 - normal
  	  C206_CaseStudy.addUser(userList, us1);
  	  C206_CaseStudy.addUser(userList, us2);
  	  assertEquals("Test that Camcorder arraylist size is 2", 2, userList.size());
  	 
  	  //test if the expected output string same as the list of users retrieved from the SourceCentre    
  	  allUsers = C206_CaseStudy.viewAllUsers(userList);
  	  testOutput = String.format("%-20s%-20s%-20d%-20s\n\n", "Jane", "janetan@gmail.com", 12345678, "13 Cranberry Drive");
  	  testOutput += String.format("%-20s%-20s%-20d%-20s\n\n", "Bill", "billong@gmail.com", 87654321, "7 Strawberry Drive" );
    
  	  assertEquals("Test that ViewAllUserlist", testOutput, allUsers);
	}

	//ViewServiceProvider
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
				assertEquals("Test that Camcorder arraylist size is 3.", 3, serviceProvidersList.size());
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
	public void testRetrieveAllServices() {
		// Test if Service list is not null but empty -boundary  
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", serviceList);
		//test if the list of services retrieved from the SourceCentre is empty - boundary
		String allServices= C206_CaseStudy.retrieveAllService(serviceList);  
		String testOutput = "";
		assertEquals("Check that ViewAllServicelist", testOutput, allServices);  
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal  
		C206_CaseStudy.addService(serviceList, sv1);
		C206_CaseStudy.addService(serviceList, sv2);  assertEquals("Test that Service arraylist size is 2", 2, serviceList.size());
		//test if the expected output string same as the list of services retrieved from the SourceCent -normal  
		allServices= C206_CaseStudy.retrieveAllService(serviceList);
		testOutput = String.format("%-10s %-30s %-20.2f\n","SV001", "Bathroom Renovation", 35.00);  
		testOutput += String.format("%-10s %-30s %-20.2f\n","SV002", "Attic Conversion", 10.00);
		assertEquals("Test that ViewAllServicelist", testOutput, allServices);  
		//Ensure that retrieveAllService() returns an empty String for an empty list - error  
		serviceList.clear();
		allServices=C206_CaseStudy.retrieveAllService(serviceList);  
		assertEquals("Check that ViewAllServiceList is empty for an empty list","",allServices);
		}


	  @Test 
	  public void testViewAllQuotes() { 
	        ArrayList<Quote> quotesList = new ArrayList<>(); 
	        quotesList.add(new Quote("Q001", "Install fluted panel", 150)); 
	        quotesList.add(new Quote("Q002", "Polish parquet", 200)); 
	 
	        C206_CaseStudy.viewAllQuotes(quotesList); 
	 
	        String expectedOutput = "Expected formatted output here"; // Replace with your expected output 
	        assertEquals(expectedOutput, outputStream.toString().trim()); 
	 
	        // Reset system out 
	        System.setOut(System.out); 
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
	  public void testDeleteService() {  //Item list is not null, so that can delete a new item - boundary
		   assertNotNull("Check if there is valid Service arrayList to delete from",serviceList);  
		   //Given an empty list, after adding 2 item, the size of the list is 2 - normal
		   C206_CaseStudy.addService(serviceList, sv1);
		   C206_CaseStudy.addService(serviceList, sv2);  
		   assertEquals("Check that Camcorder arraylist size is 2", 2, serviceList.size());
		   //The item just added is as same as the first item of the list  
		   assertEquals("Check that the item added is the same as the first item of the list",serviceList.get(0),sv1);
		   // Delete the first item and check the size of the list - normal
		   C206_CaseStudy.deleteService(serviceList,"SV001");  
		   assertEquals("test that Service arraylist size is 1  after deleting one service",1,serviceList.size());
		   assertFalse("Check that deleted service does not exist", serviceList.contains(sv1));  
		   // Delete the first item and check the size of the list - normal   
		   C206_CaseStudy.deleteService(serviceList,"SV002");
		   assertEquals("test that Service arraylist size is 0 after deleting one service",0,serviceList.size());    
		   assertFalse("Check that deleted service does not exist", serviceList.contains(sv2));
		   //Test deleting from an empty list - Boundary
		   C206_CaseStudy.deleteService(serviceList,"");    
		   assertEquals("Check that the Service arraylist remains empty after deleting from an empty list",0,serviceList.size());
		   //Test deleting a non-existing service should not cause any changes in the list - Error
		   Service Sv3 = new Service ("SV003","Non-existing Service",75.00);    
		   C206_CaseStudy.addService(serviceList, Sv3);
		   C206_CaseStudy.deleteService(serviceList,"SV004");    
		   assertEquals("Test that Service arraylist size remains 1 after attempting to delete a non-existing service",1,serviceList.size());
	  } 
	


@Test
  public void testDeleteUser() {
    
    //add user to userList
    C206_CaseStudy.addUser(userList, us1);
    C206_CaseStudy.addUser(userList, us2);
    
    //test that userList has 2 User objects after adding
    assertEquals(2, userList.size());
    
    //test that username entered is the exact same as the one in list
    assertSame(userList.get(0).getUsername(), "Jane");
    C206_CaseStudy.deleteUser(userList, "Jane");
    
    //userList size = 1 now aft deletion
    assertEquals("Check if size of userList is reduced to 1", 1, userList.size());
    
    //check that User object not in list
    assertFalse(userList.contains(us1));
    
  } 
		  
	@Test
	public void testDeleteServiceProvider() {
		//Test Case 1
		assertNotNull("Test if there is valid Service Providers arraylist to add to", serviceProvidersList);
		assertEquals("Test that the Service Providers arraylist is empty.", 0, serviceProvidersList.size());
		C206_CaseStudy.addServiceProviders(serviceProvidersList, sp1);
		assertEquals("Test that the Service Providers arraylist size is now 1.", 1, serviceProvidersList.size());
		// Attempt to delete the existing service provider
		C206_CaseStudy.deleteProvider(serviceProvidersList,"SP001");
		// Verify that the service provider is removed and appropriate message is shown
		assertEquals("Test that the Service Providers arraylist size is now 0.", 0, serviceProvidersList.size());
		
	//Test Case 2
		//Delete a Non-Existing service provider
		C206_CaseStudy.addServiceProviders(serviceProvidersList, sp1);
	    int initialSize = serviceProvidersList.size();
	    assertEquals("Test that the Service Providers arraylist size is now 1.", 1, serviceProvidersList.size());

	    // Attempt to delete a non-existing service provider
	    String nonExistingId = "SP002";
	    C206_CaseStudy.deleteProvider(serviceProvidersList, nonExistingId);

	    // Verify that the service provider list size remains the same
	    assertEquals("Test that the Service Providers arraylist size remains 1.", initialSize, serviceProvidersList.size());


	    //Test Case 3
	    //Delete from empty List
	    serviceProvidersList.clear();

	    // Attempt to delete from an empty list
	    String deleteId2 = "SP001"; // Assuming SP001 doesn't exist
	    C206_CaseStudy.deleteProvider(serviceProvidersList, deleteId2);

	    // Verify that Service Providers size remains 0 and appropriate message is shown
	    assertEquals("Test that the Service Providers arraylist size remains 0.", 0, serviceProvidersList.size());	
}
	
    @Test 
    public void testDeleteQuote() { 
    	C206_CaseStudy.addQuote(quotesList,q1); 
    	C206_CaseStudy.addQuote(quotesList,q2); 
 
        C206_CaseStudy.deleteQuote(quotesList, "R0001"); 
        assertEquals("Check that quote1 is deleted", 1, quotesList.size()); 
        assertFalse("Check that quote1 is removed from the list", quotesList.contains(q1)); 
 
        // Test deleting a non-existent quote 
        C206_CaseStudy.deleteQuote(quotesList, "NonExistentID"); 
        assertEquals("Check that non-existent quote deletion does not affect the list", 1, quotesList.size()); 
 
        // Test deleting the last quote 
        C206_CaseStudy.deleteQuote(quotesList, "R0002"); 
        assertEquals("Check that quote2 is deleted", 0, quotesList.size()); 
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
	    // Verify that request list size remains 0 and appropriate message is shown
	    assertEquals("Test that the Service Providers arraylist size remains 0.", 0, requestsList.size());
	}
	

}


