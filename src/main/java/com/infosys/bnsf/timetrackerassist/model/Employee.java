package com.infosys.bnsf.timetrackerassist.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "Employee_Table")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = -1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Emp_ID")
    private Long empId;

    @NotBlank(message = "Field required!")
    @Column(name = "C_ID")
    private String cId;

    @NotBlank(message = "Field required!")
    @Column(name = "Emp_Name", columnDefinition = "varchar(255)")
    private String empName;

    @NotBlank(message = "Field required!")
    @Column(name = "Access")
    private char access;

    /*
    @ManyToOne
    @JoinColumn(name = "Group_ID")
    private Group groupId; */

    @NotBlank(message = "Field required!")
    @Column(name = "Group_ID")
    private Group groupId;

    @NotBlank(message = "Field required!")
    @Column (name = "Maint_ID")
    private int maintId;

    @NotBlank(message = "Field required!")
    @Column (name = "Maint_TS")
    private String maintTs;

    public Employee() {
        this(-1L,"n/a","n/a",'n',new Group(),-1,"n/a");
    }

    public Employee(Long empId, String cId, String empName, char access, Group groupId, int maintId, String maintTs) {
        this.empId = empId;
        this.cId = cId;
        this.empName = empName;
        this.access = access;
        this.groupId = groupId;
        this.maintId = maintId;
        this.maintTs = maintTs;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public char getAccess() {
        return access;
    }

    public void setAccess(char access) {
        this.access = access;
    }

    public Group getGroupId() {
        return groupId;
    }

    public void setGroupId(Group groupId) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", cId='" + cId + '\'' +
                ", empName='" + empName + '\'' +
                ", access=" + access +
                ", groupId=" + groupId +
                ", maintId=" + maintId +
                ", maintTs='" + maintTs + '\'' +
                '}';
    }
}
