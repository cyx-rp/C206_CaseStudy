
public class Request extends User{
	private String requestId;
	 private String description;
	 private String quoteStatus;
	 
	 public Request(String requestId, String username, String password, String email, int contact, String address, String description) {
	  super(username,password,email,contact,address);
	  this.requestId=requestId;
	  this.description=description;
	 }
	 
	 public Request(String requestId,String username, String password, String email, int contact, String address, String description, boolean quoteStatus) {
	  super(username,password,email,contact,address);
	  this.requestId=requestId;
	  this.description=description;
	  this.quoteStatus="pending";
	 }
	 
	 public String getId() {
	  return requestId;
	 }
	 
	 public void setId(String requestId) {
	  this.requestId = requestId;
	 }
	 
	 public String getDescription() {
	  return description;
	 }
	 
	 public void setDescription(String description) {
	  this.description=description;
	 }
	 public String getQuoteStatus() {
	  return quoteStatus;
	 }
	 
	 public void setQuoteStatus(String quoteStatus) {
	  this.quoteStatus=quoteStatus;
	 }

	}


