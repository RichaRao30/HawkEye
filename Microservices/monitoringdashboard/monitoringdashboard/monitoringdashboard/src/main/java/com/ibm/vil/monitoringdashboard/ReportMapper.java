package com.ibm.vil.monitoringdashboard;

import java.sql.ResultSet; 
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ReportMapper implements RowMapper<ReportVO>{
	public ReportVO  mapRow(ResultSet rs, int rowNum) throws SQLException {

		ReportVO entity=new ReportVO();

		entity.setQuantity(rs.getInt(1));

		entity.setTrxType(rs.getString(2));


		return entity;
	}

}
