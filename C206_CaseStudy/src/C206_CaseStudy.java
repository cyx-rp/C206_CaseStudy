import java.util.ArrayList;
import java.util.List;


public class C206_CaseStudy {
	public static void main(String[] args) {
;
		ArrayList<Service> serviceList = new ArrayList<Service>();
		

		serviceList.add(new Service("SV001", "Bathroom Renovation",35.00));
		serviceList.add(new Service("SV002","Green Home Improvements",19.90));


		int option = 0;

		while (option != 7) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			if (option==1) {
				
			}
			else if (option==2) {
				
			}
			else if (option==3) {
				servicemenu(serviceList);
				
			}
			else if (option==4) {
				
			}
			else if(option==5) {
				
			}
			else if(option==6) {
				
			}
			else if (option == 7) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}

	}

	private static void menu() {
		// TODO Auto-generated method stub
		C206_CaseStudy.setHeader("Renovation Portal");
		System.out.println("1. Users");
		System.out.println("2. Service Providers");
		System.out.println("3. Services");
		System.out.println("4. Quotes");
		System.out.println("5. Requests");
		System.out.println("6. Appointments");
		System.out.println("7. Quit");
		Helper.line(80, "-");
		
	}
	private static void setHeader(String header) {
		// TODO Auto-generated method stub
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
		
	}

	private static void servicemenu(ArrayList<Service> serviceList) {
		//modify this to fit your code.
		C206_CaseStudy.setHeader("Renovation Portal");
		System.out.println("1. View all services");
		System.out.println("2. Add a service");
		System.out.println("3. Delete a Services");
		System.out.println("4. Back");
		Helper.line(80, "-");
		int option = 0;

		while (option != 4) {

			boolean exit=false;
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				ViewAllServices(serviceList);

			} else if (option == 2) {

				addService(serviceList);

			} else if (option == 3) {
				// Delete Service
				
				deleteService(serviceList);
				/*int itemType = Helper.readInt("Enter option to select item type > ");

				if (itemType == 1) {
					// Loan camcorder
					ResourceCentre.loanCamcorder(camcorderList);
				} else if (itemType == 2) {
					// Loan Chromebook
					ResourceCentre.loanChromebook(chromebookList);
				} else {
					System.out.println("Invalid type");
				}*/

			} else if (option == 4) {
				exit=true;
				break;
				} else {
					System.out.println("Invalid option");
				}

	}

}

	public static String retrieveAllServices(ArrayList<Service> serviceList) {
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
	
	public static void ViewAllServices(ArrayList<Service> serviceList) {
C206_CaseStudy.setHeader("Service LIST");
		String output = String.format("%-10s %-30s %-20s\n", "ID", "DESCRIPTION",
"Price");
		 output += retrieveAllServices(serviceList);	
		System.out.println(output);}
	public static Service inputService(ArrayList<Service> serviceList) {
		String id = Helper.readString("Enter id > ");
		String description = Helper.readString("Enter description > ");
		double price = Helper.readDouble("Enter price > ");

		Service service= new Service(id, description, price);
		return service;
		
	}
	public static void addService(ArrayList<Service> serviceList, Service service) {
		Service item;
		for(int i = 0; i < serviceList.size(); i++) {
			item = serviceList.get(i);
			if (item.getId().equalsIgnoreCase(service.getId()) )
				return;
		}
		if ((service.getId().isEmpty()) || (service.getDescription().isEmpty()) ) {
			return;
		}
		
		serviceList.add(service);
	}
	public static void deleteService(ArrayList<Service> serviceList) {
		String idtoremove = Helper.readString("Enter the id of the service to delete >");
		(int i = 0; i < serviceList.size(); i++) {
			if (serviceList.get(i).getId()==idtoremove) {
				serviceList.remove(i);
			}
				return;
		}
		
	}
	}
