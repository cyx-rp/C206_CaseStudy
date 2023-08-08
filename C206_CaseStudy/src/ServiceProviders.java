

public class ServiceProviders {
	
	private String providerId;
	private String providerName;
	private double providerPricing;
	private boolean isAvailable;
	
	public ServiceProviders(String providerId, String providerName, double providerPricing) {
		super();
		this.providerId=providerId;
		this.providerName=providerName;
		this.providerPricing=providerPricing;
		this.isAvailable = true;
	}
	
	public String getId() {
		return providerId;
	}
	public void setId(String providerId) {
		this.providerId=providerId;
	}
	
	public String getName() {
		return providerName;
	}
	public void setName(String providerName) {
		this.providerName=providerName;
	}
	
	public double getPrice() {
		return providerPricing;
	}
	public void setPrice(double providerPricing) {
		this.providerPricing=providerPricing;
	}
	
	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	///
}


