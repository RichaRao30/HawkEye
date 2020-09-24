package com.ibm.vil.monitoringdashboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = { "", "report" })
public class ReportController {

	@Autowired
	ReportDao reportDaoImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value="chart", method = RequestMethod.GET)
	public String index1() {
		return "index1";
	}
	
	@RequestMapping(value = "RechargeData", method = RequestMethod.GET)
	@ResponseBody
	public List<ReportVO> findAllRecharge() {
		try {
			return reportDaoImpl.rchReportList();
		} catch (Exception e) {
			e.printStackTrace();
			ReportModel productModel = new ReportModel();
			return productModel.findAllRecharge();
		}
	}

	@RequestMapping(value = "ActivationData", method = RequestMethod.GET)
	@ResponseBody
	public List<ReportVO> findAllActivation() {
		try {
			return reportDaoImpl.actReportList();
		} catch (Exception e) {
			e.printStackTrace();
			ReportModel productModel = new ReportModel();
			return productModel.findAllActivation();
		}

	}
	
	@RequestMapping(value = "RechargeTrend", method = RequestMethod.GET)
	@ResponseBody
	public List<ReportVO> findRechargeTrend() {
		try {
			return reportDaoImpl.findRechargeTrend();
		} catch (Exception e) {
			e.printStackTrace();
			ReportModel productModel = new ReportModel();
			return productModel.findRechargeTrend();
		}

	}
	
	
	@RequestMapping(value = "ActivationTrend", method = RequestMethod.GET)
	@ResponseBody
	public List<ReportVO> findActivationTrend() {
		try {
			return reportDaoImpl.findActivationTrend();
		} catch (Exception e) {
			e.printStackTrace();
			ReportModel productModel = new ReportModel();
			return productModel.findActivationTrend();
		}

	}
	
	@RequestMapping(value = "ActivationTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> findActivationTrendTable() {
		try {
			return reportDaoImpl.findActivationTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "SimexTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> findSimexTrendTable() {
		try {
			return reportDaoImpl.findSimexTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "RechargeTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> findRechargeTrendTable() {
		try {
			return reportDaoImpl.findRechargeTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "ActivationCircleTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> findActivationCircleTrendTable() {
		try {
			return reportDaoImpl.findActivationCircleTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "SimexCircleTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> findSimexCircleTrendTable() {
		try {
			return reportDaoImpl.findSimexCircleTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "RechargeCircleTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> findRechargeCircleTrendTable() {
		try {
			return reportDaoImpl.findRechargeCircleTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@RequestMapping(value = "MFPIHSTrendTable", method = RequestMethod.GET)
	@ResponseBody
	public List<TableReportVO> mfpIHSTrendTable() {
		try {
			return reportDaoImpl.mfpIHSTrendTable();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
