package com.school.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A StaffSalary.
 */
@Entity
@Table(name = "staff_salary")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StaffSalary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salary_paid")
    private Long salaryPaid;

    @Column(name = "month")
    private String month;

    @OneToMany(mappedBy = "staffSalary")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Staff> salaries = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalaryPaid() {
        return salaryPaid;
    }

    public StaffSalary salaryPaid(Long salaryPaid) {
        this.salaryPaid = salaryPaid;
        return this;
    }

    public void setSalaryPaid(Long salaryPaid) {
        this.salaryPaid = salaryPaid;
    }

    public String getMonth() {
        return month;
    }

    public StaffSalary month(String month) {
        this.month = month;
        return this;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Set<Staff> getSalaries() {
        return salaries;
    }

    public StaffSalary salaries(Set<Staff> staff) {
        this.salaries = staff;
        return this;
    }

    public StaffSalary addSalary(Staff staff) {
        this.salaries.add(staff);
        staff.setStaffSalary(this);
        return this;
    }

    public StaffSalary removeSalary(Staff staff) {
        this.salaries.remove(staff);
        staff.setStaffSalary(null);
        return this;
    }

    public void setSalaries(Set<Staff> staff) {
        this.salaries = staff;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StaffSalary)) {
            return false;
        }
        return id != null && id.equals(((StaffSalary) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StaffSalary{" +
            "id=" + getId() +
            ", salaryPaid=" + getSalaryPaid() +
            ", month='" + getMonth() + "'" +
            "}";
    }
}
