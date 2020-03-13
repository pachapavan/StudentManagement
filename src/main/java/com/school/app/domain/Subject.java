package com.school.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Subject.
 */
@Entity
@Table(name = "subject")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "classname")
    private String classname;

    @Column(name = "section")
    private String section;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "subject_teacher")
    private String subjectTeacher;

    @OneToMany(mappedBy = "subject")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StudentMarkes> subjects = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public Subject classname(String classname) {
        this.classname = classname;
        return this;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getSection() {
        return section;
    }

    public Subject section(String section) {
        this.section = section;
        return this;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public Subject subjectName(String subjectName) {
        this.subjectName = subjectName;
        return this;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public Subject subjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
        return this;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectTeacher() {
        return subjectTeacher;
    }

    public Subject subjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
        return this;
    }

    public void setSubjectTeacher(String subjectTeacher) {
        this.subjectTeacher = subjectTeacher;
    }

    public Set<StudentMarkes> getSubjects() {
        return subjects;
    }

    public Subject subjects(Set<StudentMarkes> studentMarkes) {
        this.subjects = studentMarkes;
        return this;
    }

    public Subject addSubject(StudentMarkes studentMarkes) {
        this.subjects.add(studentMarkes);
        studentMarkes.setSubject(this);
        return this;
    }

    public Subject removeSubject(StudentMarkes studentMarkes) {
        this.subjects.remove(studentMarkes);
        studentMarkes.setSubject(null);
        return this;
    }

    public void setSubjects(Set<StudentMarkes> studentMarkes) {
        this.subjects = studentMarkes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Subject)) {
            return false;
        }
        return id != null && id.equals(((Subject) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Subject{" +
            "id=" + getId() +
            ", classname='" + getClassname() + "'" +
            ", section='" + getSection() + "'" +
            ", subjectName='" + getSubjectName() + "'" +
            ", subjectCode='" + getSubjectCode() + "'" +
            ", subjectTeacher='" + getSubjectTeacher() + "'" +
            "}";
    }
}
