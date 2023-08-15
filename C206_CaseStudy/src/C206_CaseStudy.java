import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		//List of users
		ArrayList<User> userList = new ArrayList<User>();
    	userList.add(new User("Jane", "janetan", "janetan@gmail.com", 12345678, "13 Cranberry Drive"));
   	    userList.add(new User("Bill", "billong", "billong@gmail.com", 87654321, "7 Strawberry Drive"));
		
		//List of services 
		ArrayList<Service> serviceList = new ArrayList<Service>();
		serviceList.add(new Service("SV001", "Bathroom Renovation", 35.00));
		serviceList.add(new Service("SV002", "Attic Conversion", 10.00));
				
		//List of service providers
		ArrayList<ServiceProviders> serviceProvidersList = new ArrayList<ServiceProviders>();
		serviceProvidersList.add(new ServiceProviders("SP001","Aces Renovate", 70));
		serviceProvidersList.add(new ServiceProviders("SP002","Stellar Services", 50));
		
		//List of Requests
		ArrayList<Request> requestsList = new ArrayList<Request>();
		requestsList.add(new Request("RQ001","Jane","janetan","Bathroom Renovation"));
		requestsList.add(new Request("RQ002","Bill","billong", "Attic Conversion"));
		
		//List of Quotes
		ArrayList<Quote> quotesList = new ArrayList<Quote>();
		quotesList.add(new Quote("Q001","Install fluted panel", 150));
		quotesList.add(new Quote("Q002","Polish parquet", 200));
		
		//List of Appointments(String id, String username, String serviceProvider, String service, String date, String time) 
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
		appointmentList.add(new Appointment("A001","username","provider","service", "2023-08-15", "10:00 AM"));
		appointmentList.add(new Appointment("A002", "username", "provider", "service", "2023-08-16", "11:00 AM"));
		int option = 0;

		while (option != 4) {	
		//main menu
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all items
				C206_CaseStudy.setHeader("VIEW");			
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Users");
				System.out.println("2. Service Providers");
				System.out.println("3. Services");
				System.out.println("4. Quotes");
				System.out.println("5. Requests");
				System.out.println("6. Appointments");
				
				int itemType = Helper.readInt("Enter option to select what you want to view > ");
				if (itemType==1) {
					C206_CaseStudy.viewAllUsers(userList);
				}else if(itemType==2) {
					C206_CaseStudy.viewAllServiceProviders(serviceProvidersList);
				}else if (itemType==3) {
					C206_CaseStudy.viewAllServices(serviceList);
				}else if(itemType==4) {
					C206_CaseStudy.viewAllQuotes(quotesList);
				}else if(itemType==5) {
					C206_CaseStudy.viewAllRequests(requestsList);
				}else if(itemType==6) {
					//view appointment
					C206_CaseStudy.viewAllAppointments(appointmentList);
				}else {
					System.out.println("Invalid type");
				}

			} else if (option == 2) {
				// Add a new item
				C206_CaseStudy.setHeader("ADD");			
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Users");
				System.out.println("2. Service Providers");
				System.out.println("3. Services");
				System.out.println("4. Quotes");
				System.out.println("5. Requests");
				System.out.println("6. Appointments");
				
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if(itemType == 1) {
					User users = inputUser();
					C206_CaseStudy.addUser(userList, users);
					System.out.println("User added");
				}
				else if (itemType == 2) {
					ServiceProviders sp = addProvider();
					C206_CaseStudy.addServiceProviders(serviceProvidersList, sp);
					System.out.println("The Service Provider has been added Successfully!");
				}

				else if (itemType == 3) {
					// Add a service
					Service sv = inputService();
					C206_CaseStudy.addService(serviceList, sv);
					System.out.println("Service added");
				}	
				
				else if (itemType == 4) {
					// Add a quote
					Quote q = inputQuote();
					C206_CaseStudy.addQuote(quotesList,q);
				}
				
				else if (itemType == 5) {
					// Add a request
					Request rv = inputRequest(requestsList);
					C206_CaseStudy.addRequest(requestsList,userList,serviceList,rv);
					
				}
				
				else if (itemType == 6) {
					// Add an appointment
			        Appointment appointment = C206_CaseStudy.inputAppointment();
			        C206_CaseStudy.addAppointment(appointmentList, appointment);
				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Delete item
				C206_CaseStudy.setHeader("DELETE");			
				C206_CaseStudy.setHeader("ITEM TYPES");
				System.out.println("1. Users");
				System.out.println("2. Service Providers");
				System.out.println("3. Services");
				System.out.println("4. Quotes");
				System.out.println("5. Requests");
				System.out.println("6. Appointments");
				
				int itemType = Helper.readInt("Enter option to select item type > ");
				if(itemType == 1) {
					String userInput = Helper.readString("Enter the username of the account you want to delete >");
					C206_CaseStudy.deleteUser(userList, userInput);
				}
				else if (itemType == 2) {
					String delete = Helper.readString("Enter the id of the Service provider to be deleted > ");
					C206_CaseStudy.deleteProvider(serviceProvidersList, delete);

				}
				else if (itemType == 3) {
					// Delete Service
					 String IdDelete = Helper.readString("Enter id of service to be deleted > ");
					deleteService(serviceList, IdDelete);

				}
				else if (itemType == 4) {
					// Delete Quote
				    String IdDelete = Helper.readString("Enter id of quote to be deleted > ");
					deleteQuote(quotesList,IdDelete);
				}
				else if (itemType == 5) {
					// Delete Request
					String user = Helper.readString("Enter username > ");
					String pass = Helper.readString("Enter password > ");
					String rqId = Helper.readString("Enter request id > ");
				    C206_CaseStudy.deleteRequest(requestsList,user,pass,rqId);	
				}
				else if (itemType == 6) {
			        String delete = Helper.readString("Enter the ID of the appointment to be deleted > ");
			        C206_CaseStudy.deleteAppointment(appointmentList, delete);			
				} else {
					System.out.println("Invalid type");
				}
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}}

		}
	
	public static void menu() {
		C206_CaseStudy.setHeader("Renovation Portal");
		System.out.println("1. View All");
		System.out.println("2. Add");
		System.out.println("3. Delete");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	//================================= Option 1 View items (CRUD- Read) =================================
	//to get list of users for viewing
	  public static String viewAllUsers(ArrayList<User> userList) {
	      
	      String output = "";
	      
	      for (int i = 0; i < userList.size(); i++) {
	        
	       String username = userList.get(i).getUsername();
	       String email = userList.get(i).getEmail();
	       int contact = userList.get(i).getContact();
	       String address = userList.get(i).getAddress();
	        
	       String header = String.format("%-20s%-20s%-20s%-20s\n", "USERNAME", "EMAIL", "CONTACT NO.", "ADDRESS");
	       String listOfUsers = String.format("%-20s%-20s%-20d%-20s\n", username, email, contact, address);
	       output += listOfUsers + "\n";
	       System.out.println(header);
	       System.out.println(output);
	      }
	      
	      return output;
	      
	    }


	public static String retrieveAllService(ArrayList<Service> serviceList) { 
	  String output = ""; 
	 
	  for (int i = 0; i < serviceList.size(); i++) { 
	   Service serviceID = serviceList.get(i); 
	   if (serviceID!=null) { 
	    output += String.format("%-10s %-30s %-20.2f\n", serviceID.getId(), 
	     serviceID.getDescription(),  
	     serviceID.getPrice()); 
	   } 
	  } 
	  return output; 
	 }
	
	public static void viewAllServices(ArrayList<Service> serviceList) {
		C206_CaseStudy.setHeader("SERVICE LIST");
		String output = String.format("%-10s %-30s %-20s\n", "ID", "DESCRIPTION",
				"PRICE");
		 output += retrieveAllService(serviceList);	
		System.out.println(output);
	}
	
	
	//Service Providers
	public static void viewAllServiceProviders(ArrayList<ServiceProviders> serviceProvidersList) {
		C206_CaseStudy.setHeader("SERVICE PROVIDERS");
		String output = String.format("%-10s %-30s %-20s\n", "ID", "NAME", "PRICE");
		output += retrieveAllServiceProviders(serviceProvidersList);
		System.out.println(output);
		
	}
	public static String retrieveAllServiceProviders(ArrayList<ServiceProviders> serviceProvidersList) {
		String output = "";
		for(int x=0; x < serviceProvidersList.size(); x++) {
			if(serviceProvidersList.get(x)!=null) {
				output += String.format("%-10s %-30s %-20f\n", serviceProvidersList.get(x).getId(),serviceProvidersList.get(x).getName(),serviceProvidersList.get(x).getCustomers());
			}
		}
		return output;
	}
	
	//Quotes
	public static void viewAllQuotes(ArrayList<Quote> quotesList) {
		C206_CaseStudy.setHeader("Quotes");
		String output = String.format("%-10s %-100s %-20s %-10s %-10s\n", "ID", "ADDITIONAL INFO",
				"PRICE", "PROVIDERID", "REQUESTID");
		 output += retrieveAllQuotes(quotesList);	
		System.out.println(output);
	}
	
	public static String retrieveAllQuotes(ArrayList<Quote> quotesList) {
		String output = "";
		for(int x=0; x < quotesList.size(); x++) {
			if(quotesList.get(x)!=null) {
				output += String.format("%-10s %-100s %-20.2f %-10s %-10s\n", quotesList.get(x).getId(),quotesList.get(x).getAdditionalInfo(),quotesList.get(x).getPrice(), quotesList.get(x).getProviderID(), quotesList.get(x).getRequestID());
			}
		}
		return output;
	}
	
	//Requests
	public static String retrieveAllRequests(ArrayList<Request> requestsList) {
		String output = "";

		for (int i = 0; i < requestsList.size(); i++) {
			Request item = requestsList.get(i);
			if (item!=null) {
				output += String.format("%-10s %-20s %-30s %-20s\n", item.getId(), item.getUsername(),item.getDescription(),item.getQuoteStatus());
			}
		}
		return output;
	}
	
	public static void viewAllRequests(ArrayList<Request> requestsList) {
		C206_CaseStudy.setHeader("REQUEST LIST");
		String output = String.format("%-10s %-20s %-30s %-20s\n", "ID","USERNAME", "DESCRIPTION",
				"QUOTE STATUS");
		 output += retrieveAllRequests(requestsList);	
		System.out.println(output);
	}

	public static void viewAllAppointments(ArrayList<Appointment> appointmentList) {
		 setHeader("APPOINTMENT LIST");
		 String output = String.format("%-10s %-20s %-30s %-20s %-20s %-10s\n", "ID", "USERNAME", "SERVICE PROVIDER", "SERVICE", "DATE", "TIME");
		 output += retrieveAllAppointments(appointmentList);
		 System.out.println(output);
		}

		//Retrieve all appointments
		public static String retrieveAllAppointments(ArrayList<Appointment> appointmentList) {
		 String output = "";
		 for (int i = 0; i < appointmentList.size(); i++) {
		     Appointment appointment = appointmentList.get(i);
		     if (appointment != null) {
		         output += String.format("%-10s %-20s %-30s %-20s %-20s %-10s\n",
		             appointment.getId(), appointment.getUsername(), appointment.getServiceProvider(),
		             appointment.getService(), appointment.getDate(), appointment.getTime());
		     }
		 }
		 return output;
		}

	//================================= Option 2 Add an item (CRUD - Create) =================================

public static User inputUser() { //add user
    
    // write your code here
    String username = Helper.readString("Enter a username >");
    String password = Helper.readString("Enter a password >");
    String email = Helper.readString("Enter your email >");
    int contact = Helper.readInt("Enter your contact number >");
    String address = Helper.readString("Enter your address >");

    User newUser = new User(username, password, email, contact, address);
    
    return newUser;
    
  }
  
  public static void addUser(ArrayList<User> userList, User newUser) {
    // write your code here
    userList.add(newUser);
  }
	
	public static Service inputService() {
		String id = Helper.readString("Enter asset id > ");
		String description = Helper.readString("Enter description > ");
		int price = Helper.readInt("Enter price > ");

		Service sv= new Service(id, description, price);
		return sv;
		
	}
	public static void addService(ArrayList<Service> serviceList, Service sv) {
		Service item;
		for(int i = 0; i < serviceList.size(); i++) {
			item = serviceList.get(i);
			if (item.getId().equalsIgnoreCase(sv.getId()) )
				return;
		}
		if ((sv.getId().isEmpty()) || (sv.getDescription().isEmpty()) ) {
			return;
		}
		
		serviceList.add(sv);
	}
	
	public static ServiceProviders addProvider() {
		String id = Helper.readString("Enter provider id > ");
		String name = Helper.readString("Enter provider name > ");
		int customer = Helper.readInt("Enter number of customers > ");
		
		ServiceProviders sp = new ServiceProviders(id,name,customer);
		return sp;
	}
	
	public static void addServiceProviders(ArrayList<ServiceProviders> serviceProvidersList, ServiceProviders sp) {
		ServiceProviders provider;
		for(int x = 0; x < serviceProvidersList.size(); x++) {
			provider = serviceProvidersList.get(x);
			if(provider.getId().equalsIgnoreCase(sp.getId()) ){
				return;
			}
		}
		if((sp.getId().isEmpty()) || (sp.getName().isEmpty())) {
			return;
		}
		serviceProvidersList.add(sp);
	}
	
	public static Quote inputQuote() {
		String id = Helper.readString("Enter quote id > ");
		String additionalInfo = Helper.readString("Enter additional info > ");
		double price = Helper.readDouble("Enter price > ");
		String providerID = Helper.readString("Enter providerID > ");
		String requestID = Helper.readString("Enter requestID > ");
		
		Quote quote = new Quote(id, additionalInfo, price, providerID, requestID);
		return quote;
	}

	public static void addQuote(ArrayList<Quote> quotesList, Quote q) {
		for(int x = 0; x < quotesList.size(); x++) {
			Quote quote = quotesList.get(x);
			if(quote.getId().equalsIgnoreCase(q.getId()) ){
				return;
			}
		}
		if((q.getId().isEmpty()) || (q.getAdditionalInfo().isEmpty()) || (q.getProviderID().isEmpty()) || (q.getRequestID().isEmpty()) )  {
			return;
		}
		quotesList.add(q);
	}
	
	//request input
	public static Request inputRequest(ArrayList<Request> requestsList) {	
	    String username = Helper.readString("Enter username > ");
	    String password = Helper.readString("Enter password > ");
        String id = Helper.readString("Enter Request ID > ");
        String description = Helper.readString("Enter service description > ");

	    Request rv = new Request(id, username, password, description);    
	    return rv;
	}

	
	public static void addRequest(ArrayList<Request> requestsList, ArrayList<User> userList, ArrayList<Service> serviceList, Request rv) {
	    if (!checkValidUser(rv, userList) || !checkValidService(rv, serviceList) || !checkUniqueId(rv, requestsList) || !checkCompleteFields(rv)) {
	        return;
	    }

	    requestsList.add(rv);
	    System.out.println("Request added");
	}

	private static boolean checkValidUser(Request rv, ArrayList<User> userList) {
		boolean checkUser = false;
	    for (int i = 0; i < userList.size(); i++) {
	        User item = userList.get(i);
	        if (item.getUsername().equalsIgnoreCase(rv.getUsername()) && item.getPassword().equals(rv.getPassword())) {
	        	checkUser = true;
	        }
	    }
	    
	    if(checkUser == false) {
            System.out.println("Incorrect Username or Passsword");
            return false; 
	    }else {
	    	return true;
	    }
	}

	private static boolean checkValidService(Request rv, ArrayList<Service> serviceList) {
		boolean checkService = false;
	    for (int i = 0; i < serviceList.size(); i++) {
	        String description = serviceList.get(i).getDescription();
	        if (description.equalsIgnoreCase(rv.getDescription())) {
	        	checkService = true;
	        }
	    }
	    
	    if (checkService == false) {
            System.out.println("Service does not exist.");
            return false; 
	    }else {
	    	return true;
	    }
	    
	}

	private static boolean checkUniqueId(Request rv, ArrayList<Request> requestsList) {
		boolean uniqueId = true;
	    for (int i = 0; i < requestsList.size(); i++) {
        Request item = requestsList.get(i);
		if (item.getId().equalsIgnoreCase(rv.getId()) ) {
			uniqueId = false;
        }
    }
	    if (uniqueId == false) {
            System.out.println("Request ID already exist.");
            return false; 
	    }else {
	    	return true;
	    }
	}

	private static boolean checkCompleteFields(Request rv) {
	    if (rv.getUsername().isEmpty() || rv.getPassword().isEmpty() || rv.getDescription().isEmpty() || rv.getQuoteStatus().isEmpty()) {
	        System.out.println("Relevant fields are missing.");
	        return false;
	    }
	    return true;
	}
	
	public static Appointment inputAppointment() {
		 String id = Helper.readString("Enter appointment ID > ");
		 String username = Helper.readString("Enter username > ");
		 String serviceProvider = Helper.readString("Enter service provider name > ");
		 String service = Helper.readString("Enter service description > ");
		 String date = Helper.readString("Enter date (YYYY-MM-DD) > ");
		 String time = Helper.readString("Enter time (HH:mm AM/PM) > ");

		 return new Appointment(id, username, serviceProvider, service, date, time);
		}

		public static void addAppointment(ArrayList<Appointment> appointmentList, Appointment appointment) {
		    Appointment app;
		    for (int x = 0; x < appointmentList.size(); x++) {
		    	app = appointmentList.get(x);
				if(app.getId().equalsIgnoreCase(appointment.getId()) ){
				return;
			}
				if((appointment.getId().isEmpty()) || (appointment.getUsername().isEmpty()) || (appointment.getServiceProvider().isEmpty()) 
						|| (appointment.getService().isEmpty()) || (appointment.getDate().isEmpty()) || (appointment.getTime().isEmpty()) ) {
				return;
			}	
		    }
		 appointmentList.add(appointment);
		 System.out.println("Appointment added");
		}
	
	//================================= Option 3 Delete an item (CRUD - Update) =================================
	public static void deleteUser(ArrayList<User> userList, String userInput) {
	   	 for (int i = 0; i < userList.size(); i++) {
	   		 User deleteUser = userList.get(i);
	   		 if (deleteUser.getUsername().equals(userInput)) {
	   			  userList.remove(i);
	   		  }
	   	  }
	   	 
	    }
	
	public static void deleteService(ArrayList<Service> serviceList, String serviceId) {
	    // TODO Auto-generated method stub
	    for (int i = 0; i < serviceList.size(); i++) {
	        Service item = serviceList.get(i);
	        if (item.getId().equalsIgnoreCase(serviceId)) {
	            serviceList.remove(item);
	            return;
	        }
	    }
	}

	
	public static void deleteProvider(ArrayList<ServiceProviders> serviceProvidersList, String delete) {
		for (int x = serviceProvidersList.size() - 1; x >= 0; x--) {
	        ServiceProviders provider = serviceProvidersList.get(x);
	        if (provider.getId().equalsIgnoreCase(delete)) {
	            serviceProvidersList.remove(x);
	            System.out.println("Service provider with ID " + delete + " has been deleted.");
	            return;
	        }
	    }
	    System.out.println("Service provider with ID " + delete + " was not found.");
}
	public static void deleteRequest(ArrayList<Request> requestsList,String user, String pass, String rqId) {		
		for (int i = 0; i < requestsList.size(); i++) {
			Request item;
			item = requestsList.get(i);
			if (item.getUsername().equalsIgnoreCase(user) && item.getPassword().equals(pass) && item.getId().equalsIgnoreCase(rqId)) {
				requestsList.remove(item);
				System.out.println("Request Deleted");
				return;
			}	
		}
		System.out.println("Request with ID " + rqId + " was not found. Please check your username, password or request id.");
	}
	
	public static void deleteQuote(ArrayList<Quote> quotesList,String IdDelete) {
	    for (int i = 0; i < quotesList.size(); i++) {
	        Quote item;
	        item = quotesList.get(i);
	        if (item.getId().equalsIgnoreCase(IdDelete)) {
	            quotesList.remove(item);
	            return;
	        }
	    }
	}
	
	public static void deleteAppointment(ArrayList<Appointment> appointmentList, String appointmentId) {
	    for (int i = 0; i < appointmentList.size(); i++) {
	        Appointment appointment = appointmentList.get(i);
	        if (appointment.getId().equalsIgnoreCase(appointmentId)) {
	            appointmentList.remove(i);
	            System.out.println("Appointment with ID " + appointmentId + " has been deleted.");
	            return;
	        }
	    }
	    System.out.println("Appointment with ID " + appointmentId + " was not found.");
	}

}




		
	
		
		


