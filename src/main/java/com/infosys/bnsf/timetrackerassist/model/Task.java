package com.infosys.bnsf.timetrackerassist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    @Column(name = "Incident_ID")
    private String incidentId;

    @Column(name = "App_Name")
    private String appName;

    @Column(name = "Group_ID")
    private String groupId;

    @Column(name = "Incident_Type")
    private String incidentType;

    @Column(name = "Summary")
    private String summary;

    @Column(name = "Emp_ID")
    private int empId;

    @Column(name = "Submit_Date")
    private String submitDate;

    @Column(name = "Closed_Date")
    private String closedDate;

    @Column(name = "Impact")
    private String impact;

    @Column(name = "Resolution")
    private String resolution;

    @Column(name = "Res_Cate_Tier_1")
    private String resCateTier1;

    @Column(name = "Status")
    private String status;

    @Column(name = "Responded_Date")
    private String respondedDate;

    @Column(name = "Res_Cate_Tier_3")
    private String resCateTier3;

    @Column(name = "Target_Date")
    private String targetDate;


    @Column(name = "Maint_ID")
    private int maintId;

    @Column(name = "Maint_TS")
    private String maintTs;

    public Task() {
    }

    public String getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(String incidentId) {
        this.incidentId = incidentId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) { this.appName = appName; }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public int getMaintId() {
        return maintId;
    }

    public void setMaintId(int maintId) {
        this.maintId = maintId;
    }

    public String getMaintTs() {
        return maintTs;
    }

    public void setMaintTs(String maintTs) {
        this.maintTs = maintTs;
    }


    public String getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(String incidentType) {
        this.incidentType = incidentType;
    }

    public String getSummary() {
        return summary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(String submitDate) {
        this.submitDate = submitDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getResCateTier1() {
        return resCateTier1;
    }

    public void setResCateTier1(String resCateTier1) {
        this.resCateTier1 = resCateTier1;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRespondedDate() {
        return respondedDate;
    }

    public void setRespondedDate(String respondedDate) {
        this.respondedDate = respondedDate;
    }

    public String getResCateTier3() {
        return resCateTier3;
    }

    public void setResCateTier3(String resCateTier3) {
        this.resCateTier3 = resCateTier3;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "incidentId='" + incidentId + '\'' +
                ", appName='" + appName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", incidentType='" + incidentType + '\'' +
                ", summary='" + summary + '\'' +
                ", empId=" + empId +
                ", submitDate='" + submitDate + '\'' +
                ", closedDate='" + closedDate + '\'' +
                ", impact='" + impact + '\'' +
                ", resolution='" + resolution + '\'' +
                ", resCateTier1='" + resCateTier1 + '\'' +
                ", status='" + status + '\'' +
                ", respondedDate='" + respondedDate + '\'' +
                ", resCateTier3='" + resCateTier3 + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", maintId=" + maintId +
                ", maintTs='" + maintTs + '\'' +
                '}';
    }
}
