package com.ibm.vil.monitoringdashboard;

import java.sql.ResultSet; 
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TableReportMapper implements RowMapper<TableReportVO> {
	public TableReportVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		TableReportVO entity = new TableReportVO();

		entity.setTime(rs.getString(1));
		entity.setToday(rs.getString(2));
		entity.setLastweek(rs.getString(3));
		entity.setDiff(rs.getString(4));
		entity.setDiff_prct(rs.getString(5));

		return entity;
	}

}
