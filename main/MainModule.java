package main;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Scanner;

import com.dao.InsuranceServiceImpl;
import entity.Policy;
import exceptions.PolicyNotFoundException;

public class MainModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InsuranceServiceImpl is = new InsuranceServiceImpl();

        int choice;
        String ch;

        do {
            System.out.println("---MENU--");
            System.out.println("1. Create Policy");
            System.out.println("2. Get Policy");
            System.out.println("3. Get All Policy");
            System.out.println("4. Update Policy");
            System.out.println("5. Delete Policy");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    try {
                    	System.out.println("Enter Policy ID:");
                        int policyId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Policy Name:");
                        String policyName = sc.nextLine();
                        System.out.println("Enter Policy Type:");
                        String policyType = sc.nextLine();
                        System.out.println("Enter Policy Amount:");
                        double policyAmount = sc.nextDouble();
                        System.out.println("Enter Client ID:");
                        int clientId = sc.nextInt();

                        // Create Policy object
                        Policy policy = new Policy(policyId, policyName, policyType, policyAmount, clientId);

                        boolean isCreated = is.createPolicy(policy);
                        if (isCreated)
                            System.out.println("Policy Created Successfully");
                        else
                            System.out.println("Failed to create Policy");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.println("Enter policy ID: ");
                    int policyId = sc.nextInt();
                    try {
                        Policy policy = is.getPolicy(policyId);
                        if (policy != null) {
                            System.out.println("Policy details");
                            System.out.println(policy.toString());
                        } else {
                            System.out.println("Policy not found");
                        }
                    } catch (PolicyNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try {
                        System.out.println("Policy Details:");
                        Collection<Policy> p;
                        try {
                            p = is.getAllPolicies();
                            for (Policy policy : p) {
                                System.out.println(policy);
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    break;
                case 4:
                	 System.out.println("Enter Policy ID to update: ");
                	 int updatePolicyId = sc.nextInt();
                	 System.out.println("Enter new Policy Name:");
                     String newPolicyName = sc.next();
                	 System.out.println("Enter new Policy Type:");
                	 String newPolicyType = sc.next();
                	 System.out.println("Enter new Policy Amount:");
                	 double newPolicyAmount = sc.nextDouble();
                	 System.out.println("Enter new Client ID:");
                	 int newClientId = sc.nextInt();
                	Policy updatedPolicy = new Policy(updatePolicyId, newPolicyName, newPolicyType, newPolicyAmount, newClientId);
                    try {
                        boolean isUpdated = is.updatePolicy(updatedPolicy);
                        if (isUpdated)
                            System.out.println("Policy updated Successfully");
                        else
                            System.out.println("Failed to update policy");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (PolicyNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.println("Enter PolicyID to delete: ");
                    int pid = sc.nextInt();
                    try {
                        boolean isdelete = is.deletePolicy(pid);
                        if (isdelete)
                            System.out.println("Policy deleted Successfully");
                        else
                            System.out.println("Failed to delete a policy");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (PolicyNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
            System.out.println("Enter y to continue: ");
            ch = sc.next();
        } while (ch.equalsIgnoreCase("y"));
        sc.close();
        System.out.println("Thank you for using our System");

    }

}
