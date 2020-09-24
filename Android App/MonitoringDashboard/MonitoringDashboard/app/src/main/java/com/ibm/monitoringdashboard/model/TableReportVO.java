package com.ibm.monitoringdashboard.model;

public class TableReportVO {
    private String time,today,lastweek,diff,diff_prct;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String today) {
        this.today = today;
    }

    public String getLastweek() {
        return lastweek;
    }

    public void setLastweek(String lastweek) {
        this.lastweek = lastweek;
    }

    public String getDiff() {
        return diff;
    }

    public void setDiff(String diff) {
        this.diff = diff;
    }

    public String getDiff_prct() {
        return diff_prct;
    }

    public void setDiff_prct(String diff_prct) {
        this.diff_prct = diff_prct;
    }
}
