package com.ibm.vil.monitoringdashboard;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;

public class createPreparedStatement implements PreparedStatementCreator {

	private String query;

	public createPreparedStatement(String query) {
		this.query = query;
	}

	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

		PreparedStatement ps = con.prepareStatement(query);

		return ps;
	}

}