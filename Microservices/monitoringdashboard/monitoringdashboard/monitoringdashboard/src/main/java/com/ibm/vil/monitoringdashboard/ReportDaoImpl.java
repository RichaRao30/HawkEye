package com.ibm.vil.monitoringdashboard;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

@Repository
@Configuration
@PropertySource("classpath:application.properties")
public class ReportDaoImpl implements ReportDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${actReportSql.query}")
	private String actReportSql;

	@Value("${rchReportSql.query}")
	private String rchReportSql;

	@Value("${actTrendSql.query}")
	private String actTrendSql;

	@Value("${rchTrendSql.query}")
	private String rchTrendSql;

	@Value("${actTableTrendSql.query}")
	private String actTableTrendSql;

	@Value("${simexTableTrendSql.query}")
	private String simexTableTrendSql;

	@Value("${rchTableTrendSql.query}")
	private String rchTableTrendSql;

	@Value("${actCircleTableTrendSql.query}")
	private String actCircleTableTrendSql;

	@Value("${simexCircleTableTrendSql.query}")
	private String simexCircleTableTrendSql;

	@Value("${rchCircleTableTrendSql.query}")
	private String rchCircleTableTrendSql;
	
	@Value("${mfpIHSTableTrendSql.query}")
	private String mfpIHSTableTrendSql;
	

	@Override
	public List<ReportVO> actReportList() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(actReportSql);
		List<ReportVO> actReport = jdbcTemplate.query(psc, new ReportMapper());
		return actReport;
	}

	@Override
	public List<ReportVO> rchReportList() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(rchReportSql);
		List<ReportVO> actReport = jdbcTemplate.query(psc, new ReportMapper());
		return actReport;
	}

	@Override
	public List<ReportVO> findRechargeTrend() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(rchTrendSql);
		List<ReportVO> rchTrend = jdbcTemplate.query(psc, new ReportMapper());

		return rchTrend;
	}

	@Override
	public List<ReportVO> findActivationTrend() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(actTrendSql);
		List<ReportVO> actTrend = jdbcTemplate.query(psc, new ReportMapper());

		return actTrend;
	}

	@Override
	public List<TableReportVO> findActivationTrendTable() {

		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(actTableTrendSql);
		List<TableReportVO> actTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return actTrend;
	}

	@Override
	public List<TableReportVO> findRechargeTrendTable() {

		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(rchTableTrendSql);
		List<TableReportVO> rchTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return rchTrend;
	}

	@Override
	public List<TableReportVO> findSimexTrendTable() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(simexTableTrendSql);
		List<TableReportVO> simexTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return simexTrend;
	}

	@Override
	public List<TableReportVO> findActivationCircleTrendTable() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(actCircleTableTrendSql);
		List<TableReportVO> actTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return actTrend;
	}

	@Override
	public List<TableReportVO> findRechargeCircleTrendTable() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(rchCircleTableTrendSql);
		List<TableReportVO> rchTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return rchTrend;
	}

	@Override
	public List<TableReportVO> findSimexCircleTrendTable() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(simexCircleTableTrendSql);
		List<TableReportVO> simexTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return simexTrend;
	}

	@Override
	public List<TableReportVO> mfpIHSTrendTable() {
		PreparedStatementCreator psc = null;
		psc = new createPreparedStatement(mfpIHSTableTrendSql);
		List<TableReportVO> ihsTrend = jdbcTemplate.query(psc, new TableReportMapper());

		return ihsTrend;
	}


}
