import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		//List of users
		ArrayList<User> userList = new ArrayList<User>();	
    	userList.add(new User("Jane", "janetan", "janetan@gmail.com", 12345678, "13 Cranberry Drive"));
    	userList.add(new User("Bill", "billong", "billong@gmail.com", 87654321, "7 Strawberry Drive"));
		
		//List of services 
		ArrayList<Service> serviceList = new ArrayList<Service>();
		serviceList.add(new Service("SV001", "Bathroom Renovation", 35));
		serviceList.add(new Service("SV002", "Attic Conversion", 10));
				
		//List of service providers
		ArrayList<ServiceProviders> serviceProvidersList = new ArrayList<ServiceProviders>();
		serviceProvidersList.add(new ServiceProviders("SP001","Aces Renovate", 70));
		serviceProvidersList.add(new ServiceProviders("SP002","Stellar Services", 50));
		
		//List of Requests
		ArrayList<Request> requestsList = new ArrayList<Request>();
		requestsList.add(new Request("RQ001","Jane","janetan","Bathroom Renovation"));
		requestsList.add(new Request("RQ002","Bill","billong", "Attic Conversion"));
		int option = 0;

		while (option != 4) {

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
				if(itemType==1) {
				}
				else if(itemType==2) {
					C206_CaseStudy.viewAllServiceProviders(serviceProvidersList);
				}else if (itemType==3) {
					C206_CaseStudy.viewAllServices(serviceList);
				}else if(itemType==4) {
					
				}else if(itemType==5) {
					C206_CaseStudy.viewAllRequests(requestsList);
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
				else if (itemType == 5) {
					// Add a request
					Request rv = inputRequest(requestsList);
					C206_CaseStudy.addRequest(requestsList,userList,serviceList,rv);
					

				} else {
					System.out.println("Invalid type");
				}

			} else if (option == 3) {
				// Loan item
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
					
				}
				else if (itemType == 2) {
					String delete = Helper.readString("Enter the id of the Service provider to be deleted > ");
					C206_CaseStudy.deleteProvider(serviceProvidersList,delete);
				}
				else if (itemType == 3) {
					// Delete Service
					C206_CaseStudy.deleteService(serviceList);
				}
				else if (itemType == 5) {
					// Delete Request
					String user = Helper.readString("Enter username > ");
					String pass = Helper.readString("Enter password > ");
					String rqId = Helper.readString("Enter request id > ");
					C206_CaseStudy.deleteRequest(requestsList,user,pass,rqId);	
					
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
	public static String retrieveAllService(ArrayList<Service> serviceList) {
		String output = "";

		for (int i = 0; i < serviceList.size(); i++) {
			if (serviceList.get(i)!=null) {
				output += String.format("%-10s %-30s %-20d\n", serviceList.get(i).getId(),
					serviceList.get(i).getDescription(), 
					serviceList.get(i).getPrice());
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
				output += String.format("%-10s %-30s %-20f\n", serviceProvidersList.get(x).getId(),serviceProvidersList.get(x).getName(),serviceProvidersList.get(x).getPrice());
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
		double price = Helper.readDouble("Enter price > ");
		
		ServiceProviders sp = new ServiceProviders(id,name,price);
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
	
	//request input
	public static Request inputRequest(ArrayList<Request> requestsList) {	
	    String username = Helper.readString("Enter username > ");
	    String password = Helper.readString("Enter password > ");
        String id = Helper.readString("Enter Request ID > ");
        String description = Helper.readString("Enter service description > ");

	    Request rv = new Request(id, username, password, description);    
	    return rv;
	}
	
	//add request
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

	
	//================================= Option 3 Loan an item (CRUD - Update) =================================
	private static void deleteService(ArrayList<Service> serviceList) {
	    // TODO Auto-generated method stub
	    String IdDelete = Helper.readString("Enter id of service to be deleted > ");
	    for (int i = 0; i < serviceList.size(); i++) {
	        Service item;
	        item = serviceList.get(i);
	        if (item.getId().equalsIgnoreCase(IdDelete)) {
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
}
 

	


	

