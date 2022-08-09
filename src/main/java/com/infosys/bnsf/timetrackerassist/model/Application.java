package com.infosys.bnsf.timetrackerassist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name="Applications")
public class Application implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "App_Name")
    private String appName;

    @Column(name = "Manager_Name")
    private String managerName;

    @Column(name = "Area")
    private String area;

    @Column(name = "Maint_ID")
    private int maintId;

    @Column(name = "Maint_TS")
    private String maintTs;

    public Application() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    @Override
    public String toString() {
        return "Applications{" +
                "app_Name='" + appName + '\'' +
                ", manager_Name='" + managerName + '\'' +
                ", area='" + area + '\'' +
                ", maint_id=" + maintId +
                ", maint_TS='" + maintTs + '\'' +
                '}';
    }

}
