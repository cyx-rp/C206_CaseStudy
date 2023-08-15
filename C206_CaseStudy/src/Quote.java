public class Quote { 
 private String quoteID; private String additionalInfo; 
 private double quotePrice; private String providerID;
 private String requestID; 
 public Quote(String quoteID, String additionalInfo, double quotePrice, String providerID, String requestID) {  this.quoteID = quoteID;
  this.additionalInfo = additionalInfo;  this.quotePrice = quotePrice;
  this.providerID = providerID;  this.requestID = requestID;
 } 
 public Quote(String quoteID, String additionalInfo, double quotePrice) {     super();
    this.quoteID = quoteID;    this.additionalInfo = additionalInfo;
    this.quotePrice = quotePrice;   }
  public String getId() {
  return this.quoteID; }
 public void setId(String quoteID) {
  this.quoteID=quoteID; }
  public String getAdditionalInfo() {
  return this.additionalInfo; }
 public void setAdditionalInfo(String additionalInfo) {
  this.additionalInfo=additionalInfo; }
 public double getPrice() {
  return this.quotePrice; }

 public void setPrice(double quotePrice) {  this.quotePrice=quotePrice;
 }
 public String getProviderID() {
  return this.providerID; }
 public void setServiceProvider(String providerID) {
  this.providerID=providerID; }
 public String getRequestID() {
  return this.requestID; }
 public void setRequestID(String requestID) {
  this.requestID=requestID; }
}