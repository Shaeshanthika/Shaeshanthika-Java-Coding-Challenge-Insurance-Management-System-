package com.dao;

import java.sql.SQLException;
import java.util.Collection;
import entity.Policy;
import exceptions.PolicyNotFoundException;

public interface IPolicyService {
	boolean createPolicy(Policy policy) throws SQLException;
    Policy getPolicy(int policyId) throws SQLException, PolicyNotFoundException;
    Collection<Policy> getAllPolicies() throws SQLException;
    boolean updatePolicy(Policy policy) throws SQLException, PolicyNotFoundException;
    boolean deletePolicy(int policyId) throws SQLException,PolicyNotFoundException;

}
