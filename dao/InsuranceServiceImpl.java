package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import entity.Policy;
import exceptions.PolicyNotFoundException;
import utill.DBConnection;

public class InsuranceServiceImpl implements IPolicyService {
    
    @Override
    public boolean createPolicy(Policy policy) throws SQLException {
        String insertQuery = "INSERT INTO Policy (policyId, policyName, policyType, policyAmount, clientId) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(insertQuery);
            
        ps.setInt(1, policy.getPolicyId());
        ps.setString(2, policy.getPolicyName());
        ps.setString(3, policy.getPolicyType());
        ps.setDouble(4, policy.getPolicyAmount());
        ps.setInt(5, policy.getClientId());
            
        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            return true;
        }
		return false; 
    }

    @Override
    public Policy getPolicy(int policyId) throws SQLException, PolicyNotFoundException {
        Policy policy = null;
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Policy WHERE policyId=" + policyId;
        ResultSet rs = stmt.executeQuery(query);
        if (rs.next()) {
            policy = new Policy(
                rs.getInt("policyId"),
                rs.getString("policyName"),
                rs.getString("policyType"),
                rs.getDouble("policyAmount"),
                rs.getInt("clientId")
            );
        }
        return policy;
        }
        
    

    @Override
    public Collection<Policy> getAllPolicies() throws SQLException {
        Collection<Policy> policies = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Policy");
        while (rs.next()) {
            Policy policy = new Policy(
                rs.getInt("policyId"),
                rs.getString("policyName"),
                rs.getString("policyType"),
                rs.getDouble("policyAmount"),
                rs.getInt("clientId")
            );
            policies.add(policy);
        }
        return policies;
    }

    @Override
    public boolean updatePolicy(Policy policy) throws SQLException,PolicyNotFoundException {
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        String query = "UPDATE Policy SET policyType='policy E' WHERE policyId=1";
        int updateRow = stmt.executeUpdate(query);
        return updateRow > 0;
    }

    @Override
    public boolean deletePolicy(int policyId) throws SQLException ,PolicyNotFoundException{
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        String query = "DELETE FROM Policy WHERE policyId=" + policyId;
        int deleteRow = stmt.executeUpdate(query);
        return deleteRow > 0;
    }
}
