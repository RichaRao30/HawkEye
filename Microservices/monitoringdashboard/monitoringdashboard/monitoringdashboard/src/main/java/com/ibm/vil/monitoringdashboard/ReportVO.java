/**
 * 
 */
package com.ibm.vil.monitoringdashboard;


public class ReportVO {
	
		private String trxType;
		private int quantity;
		
		public ReportVO() {}
		
		public ReportVO(String trxType, int quantity) {
			super();
			this.trxType = trxType;
			this.quantity = quantity;
		}
		
		public String getTrxType() {
			return trxType;
		}
		public void setTrxType(String trxType) {
			this.trxType = trxType;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		
}

