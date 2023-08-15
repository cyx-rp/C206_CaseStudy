import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		
		//List of users
		ArrayList<User> userList = new ArrayList<User>();	
		
		//List of services 
		ArrayList<Service> serviceList = new ArrayList<Service>();
		serviceList.add(new Service("SV001", "Bathroom Renovation", 35.00));
		serviceList.add(new Service("SV002", "Attic Conversion", 10.00));
				
		//List of service providers
		ArrayList<ServiceProviders> serviceProvidersList = new ArrayList<ServiceProviders>();
		serviceProvidersList.add(new ServiceProviders("SP001","Aces Renovate", 70));
		serviceProvidersList.add(new ServiceProviders("SP002","Stellar Services", 100));
		
		//List of Requests
		ArrayList<Request> requestsList = new ArrayList<Request>();

		int option = 0;

		while (option != 4) {
		
		//Login portion
			C206_CaseStudy.login();
   		 option = Helper.readInt("Enter an option > ");
   		 
   		 if (option == 1) {
   			 
   		 }
   		 
   		 else if (option == 2) {
   			 
   		 }
   		 
   		 else if (option == 3){
   			 
   		 }
   		 
   		 else if (option == 4){
   			 System.out.println("Bye!");
   		 }
   		 else {
   			 System.out.println("Invalid option");
   		 }
		
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
				if(itemType==1) {
				}
				else if(itemType==2) {
					C206_CaseStudy.viewAllServiceProviders(serviceProvidersList);
				}else if (itemType==3) {
					C206_CaseStudy.viewAllServices(serviceList);
				}else if(itemType==4) {
					
				}else if(itemType==5) {
					
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
					C206_CaseStudy.deleteProvider(serviceProvidersList, delete);

				}
				else if (itemType == 3) {
					// Delete Service
					 String IdDelete = Helper.readString("Enter id of service to be deleted > ");
					deleteService(serviceList, IdDelete);

				}
				else if (itemType == 5) {
					// Delete Request
					
					
				} else {
					System.out.println("Invalid type");
				}
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}}

		}
	
	public static void login() {
   	 C206_CaseStudy.setHeader("Renovation Portal");
   	 System.out.println("1. User");
   	 System.out.println("2. Service Provider");
   	 System.out.println("3. Delete");
   	 System.out.println("4. Quit");
   	 Helper.line(80, "-");

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
		String output = String.format("%-10s %-30s %-20s\n", "ID", "NAME", "CUSTOMERS");
		output += retrieveAllServiceProviders(serviceProvidersList);
		System.out.println(output);
		
	}
	public static String retrieveAllServiceProviders(ArrayList<ServiceProviders> serviceProvidersList) {
		String output = "";
		for(int x=0; x < serviceProvidersList.size(); x++) {
			if(serviceProvidersList.get(x)!=null) {
				output += String.format("%-10s %-30s %-20d\n", serviceProvidersList.get(x).getId(),serviceProvidersList.get(x).getName(),(int)serviceProvidersList.get(x).getCustomers());
			}
		}
		return output;
	}
	
	


	//================================= Option 2 Add an item (CRUD - Create) =================================
	
	
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
		int customers = Helper.readInt("Enter number of customers > ");
		
		ServiceProviders sp = new ServiceProviders(id,name,customers);
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
	
	



	
	
	//================================= Option 3 Delete an item (CRUD - Update) =================================
	
	
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
	



		
	
		
		
	}
