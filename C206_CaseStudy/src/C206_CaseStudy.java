import java.util.ArrayList;

public class C206_CaseStudy {

    public static void main(final String[] args) {

        final ArrayList<Service> serviceList = new ArrayList<Service>();

        serviceList.add(new Service("SV001", "Bathroom Renovation", 35.00));
        serviceList.add(new Service("SV002", "Attic Conversion", 10.00));

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

                final int itemType = Helper.readInt("Enter option to select what you want to view > ");
                if (itemType == 3) {
                    C206_CaseStudy.viewAllServices(serviceList);
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

                final int itemType = Helper.readInt("Enter option to select item type > ");

                if (itemType == 3) {
                    // Add a service
                    final Service sv = inputService();
                    C206_CaseStudy.addService(serviceList, sv);
                    System.out.println("Service added");

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



    //================================= Option 2 Add an item (CRUD - Create) =================================
    public static Service inputService() {
        final String id = Helper.readString("Enter asset id > ");
        final String description = Helper.readString("Enter description > ");
        final double price = Helper.readDouble("Enter price > ");

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

	
	

	
	


