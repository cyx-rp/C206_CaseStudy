
public class ServiceProviders {
 
 private String providerId;
 private String providerName;
 private int providerCustomers;
 private boolean isAvailable;
 
 public ServiceProviders(String providerId, String providerName, int providerCustomers) {
  super();
  this.providerId=providerId;
  this.providerName=providerName;
  this.providerCustomers=providerCustomers;
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
 
 public double getCustomers() {
  return providerCustomers;
 }
 public void setCustomers(int providerCustomers) {
  this.providerCustomers=providerCustomers;
 }
 
 public boolean getIsAvailable() {
  return isAvailable;
 }

 public void setIsAvailable(boolean isAvailable) {
  this.isAvailable = isAvailable;
 }

}