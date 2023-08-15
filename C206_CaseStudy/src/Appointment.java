public class Appointment {
    private String id;
    private String username;
    private String serviceProvider;
    private String service;
    private String date;
    private String time;

    public Appointment(String id, String username, String serviceProvider, String service, String date, String time) {
        this.id = id;
        this.username = username;
        this.serviceProvider = serviceProvider;
        this.service = service;
        this.date = date;
        this.time = time;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public String getService() {
        return service;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public void setService(String service) {
        this.service = service;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
