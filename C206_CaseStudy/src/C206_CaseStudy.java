import java.util.ArrayList;

public class C206_CaseStudy {

<<<<<<< HEAD
    public static void main(final String[] args) {

        final ArrayList<Service> serviceList = new ArrayList<Service>();
=======
	public static void main(String[] args) {
		
		//List of users
		ArrayList<User> userList = new ArrayList<User>();
		
		
		//List of services 
		ArrayList<Service> serviceList = new ArrayList<Service>();
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

<<<<<<< HEAD
        serviceList.add(new Service("SV001", "Bathroom Renovation", 35.00));
        serviceList.add(new Service("SV002", "Attic Conversion", 10.00));
=======
		serviceList.add(new Service("SV001", "Bathroom Renovation", 35));
		serviceList.add(new Service("SV002", "Attic Conversion", 10));
		
		
		//List of service providers
		ArrayList<ServiceProviders> serviceProvidersList = new ArrayList<ServiceProviders>();
		serviceProvidersList.add(new ServiceProviders("SP001","Aces Renovate", 70));
		serviceProvidersList.add(new ServiceProviders("SP002","Stellar Services", 50));
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

        int option = 0;

        while (option != 4) {

            C206_CaseStudy.menu();
            option = Helper.readInt("Enter an option > ");

<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

<<<<<<< HEAD
                final int itemType = Helper.readInt("Enter option to select what you want to view > ");
                if (itemType == 3) {
                    C206_CaseStudy.viewAllServices(serviceList);
                }
=======
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
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

<<<<<<< HEAD
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
=======
				else if (itemType == 3) {
					// Add a service
					Service sv = inputService();
					C206_CaseStudy.addService(serviceList, sv);
					System.out.println("Service added");
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

                final int itemType = Helper.readInt("Enter option to select item type > ");

<<<<<<< HEAD
                if (itemType == 3) {
                    // Add a service
                    final Service sv = inputService();
                    C206_CaseStudy.addService(serviceList, sv);
                    System.out.println("Service added");
=======
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
					C206_CaseStudy.deleteProvider(serviceProvidersList);
				}
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

<<<<<<< HEAD
                } else {
                    System.out.println("Invalid type");
                }
=======
				else if (itemType == 3) {
					// Delete Service
					C206_CaseStudy.deleteService(serviceList);
				} else {
					System.out.println("Invalid type");
				}
			} else if (option == 4) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}}
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

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

                final int itemType = Helper.readInt("Enter option to select item type > ");

                if (itemType == 3) {
                    // Delete Service
                	final String selectedID=Helper.readString("Enter ID of service to delete:");
                    C206_CaseStudy.deleteService(serviceList,selectedID);
                } else {
                    System.out.println("Invalid type");
                }
            } else if (option == 4) {
                System.out.println("Bye!");
            } else {
                System.out.println("Invalid option");
            }
        }
    }

<<<<<<< HEAD
    public static void menu() {
        C206_CaseStudy.setHeader("Renovation Portal");
        System.out.println("1. View All");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.println("4. Quit");
        Helper.line(80, "-");
    }

    public static void setHeader(final String header) {
        Helper.line(80, "-");
        System.out.println(header);
        Helper.line(80, "-");
    }



    //================================= Option 1 View items (CRUD- Read) =================================
    public static String retrieveAllService(final ArrayList<Service> serviceList) {
=======
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllService(ArrayList<Service> serviceList) {
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git
		String output = "";

		for (int i = 0; i < serviceList.size(); i++) {

			output += String.format("%-10s %-30s %-20.2f\n", serviceList.get(i).getId(),
					serviceList.get(i).getDescription(), 
					serviceList.get(i).getPrice());
		}
		return output;
	}
	
	public static void viewAllServices(final ArrayList<Service> serviceList) {
		C206_CaseStudy.setHeader("Service LIST");
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


<<<<<<< HEAD
=======
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
		User account;

		for(int i = 0; i < userList.size(); i++) {
			account = userList.get(i);
			
			if ((newUser.getUsername().isEmpty()) || (newUser.getUsername().isEmpty()) ) {
				userList.add(newUser);
			}
		}
	}
	
	public static Service inputService() {
		String id = Helper.readString("Enter asset id > ");
		String description = Helper.readString("Enter description > ");
		int price = Helper.readInt("Enter price > ");
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

<<<<<<< HEAD
    //================================= Option 2 Add an item (CRUD - Create) =================================
    public static Service inputService() {
        final String id = Helper.readString("Enter asset id > ");
        final String description = Helper.readString("Enter description > ");
        final double price = Helper.readDouble("Enter price > ");
=======
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
	
	public static void deleteProvider(ArrayList<ServiceProviders> serviceProvidersList) {
		String delete = Helper.readString("Enter the id of the Service provider to be deleted > ");
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
>>>>>>> branch 'master' of https://github.com/cyx-rp/C206_CaseStudy.git

        final Service sv = new Service(id, description, price);
        return sv;
    }

    public static void addService(final ArrayList<Service> serviceList, final Service sv) {
        Service item;
        for (int i = 0; i < serviceList.size(); i++) {
            item = serviceList.get(i);
            if (item.getId().equals(sv.getId())) // Updated to use equals() for case-sensitive comparison
                return;
        }
        if ((sv.getId().isEmpty()) || (sv.getDescription().isEmpty())) {
            return;
        }

        serviceList.add(sv);
    }

    //================================= Option 3 Delete an item (CRUD - Delete) =================================
    public static void deleteService(final ArrayList<Service> serviceList, final String serviceId) {
        for (int i = 0; i < serviceList.size(); i++) {
            final Service service = serviceList.get(i);
            if (service.getId().equals(serviceId)) {
                serviceList.remove(i);
                return;
            }
        }
    }
}

	
	

	
	


