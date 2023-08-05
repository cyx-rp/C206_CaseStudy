
public class ServiceProviders {
	
	private String providerId;
	private String providerDescription;
	private double providerPricing;
	
	public ServiceProviders(String providerId, String providerDescription, double providerPricing) {
		super();
		this.providerId=providerId;
		this.providerDescription=providerDescription;
		this.providerPricing=providerPricing;
	}
	
	public String getId() {
		return providerId;
	}
	public void setId(String providerId) {
		this.providerId=providerId;
	}
	
	public String getDescription() {
		return providerDescription;
	}
	public void setDescription(String providerDescription) {
		this.providerDescription=providerDescription;
	}
	
	public double getPrice() {
		return providerPricing;
	}
	public void setPrice(double providerPricing) {
		this.providerPricing=providerPricing;
	}
}
