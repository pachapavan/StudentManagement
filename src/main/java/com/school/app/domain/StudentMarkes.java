package com.school.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A StudentMarkes.
 */
@Entity
@Table(name = "student_markes")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class StudentMarkes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "exam_name")
    private String examName;

    @Column(name = "total_markes")
    private Long totalMarkes;

    @Column(name = "markes")
    private Long markes;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    @JsonIgnoreProperties("students")
    private Student student;

    @ManyToOne
    @JsonIgnoreProperties("subjects")
    private Subject subject;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public StudentMarkes examName(String examName) {
        this.examName = examName;
        return this;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Long getTotalMarkes() {
        return totalMarkes;
    }

    public StudentMarkes totalMarkes(Long totalMarkes) {
        this.totalMarkes = totalMarkes;
        return this;
    }

    public void setTotalMarkes(Long totalMarkes) {
        this.totalMarkes = totalMarkes;
    }

    public Long getMarkes() {
        return markes;
    }

    public StudentMarkes markes(Long markes) {
        this.markes = markes;
        return this;
    }

    public void setMarkes(Long markes) {
        this.markes = markes;
    }

    public String getComments() {
        return comments;
    }

    public StudentMarkes comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Student getStudent() {
        return student;
    }

    public StudentMarkes student(Student student) {
        this.student = student;
        return this;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public StudentMarkes subject(Subject subject) {
        this.subject = subject;
        return this;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StudentMarkes)) {
            return false;
        }
        return id != null && id.equals(((StudentMarkes) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "StudentMarkes{" +
            "id=" + getId() +
            ", examName='" + getExamName() + "'" +
            ", totalMarkes=" + getTotalMarkes() +
            ", markes=" + getMarkes() +
            ", comments='" + getComments() + "'" +
            "}";
    }
}
