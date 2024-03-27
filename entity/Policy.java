package entity;

public class Policy {
	private int policyId;
	private String policyName;
	private String policyType;
	private double policyAmount;
	private int clientId;
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public double getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public Policy(int policyId, String policyName, String policyType, double policyAmount, int clientId) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyType = policyType;
		this.policyAmount = policyAmount;
		this.clientId = clientId;
	}
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", policyAmount=" + policyAmount + ", clientId=" + clientId + "]";
	}
	
	

}
