package com.school.app.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Section.
 */
@Entity
@Table(name = "section")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "section_number")
    private Long sectionNumber;

    @OneToMany(mappedBy = "section")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Student> sections = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Section name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSectionNumber() {
        return sectionNumber;
    }

    public Section sectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
        return this;
    }

    public void setSectionNumber(Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public Set<Student> getSections() {
        return sections;
    }

    public Section sections(Set<Student> students) {
        this.sections = students;
        return this;
    }

    public Section addSection(Student student) {
        this.sections.add(student);
        student.setSection(this);
        return this;
    }

    public Section removeSection(Student student) {
        this.sections.remove(student);
        student.setSection(null);
        return this;
    }

    public void setSections(Set<Student> students) {
        this.sections = students;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Section)) {
            return false;
        }
        return id != null && id.equals(((Section) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Section{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", sectionNumber=" + getSectionNumber() +
            "}";
    }
}
