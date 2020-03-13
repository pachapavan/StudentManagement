package com.school.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A Student.
 */
@Entity
@Table(name = "student")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "parent_name")
    private String parentName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "address")
    private String address;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "photo_content_type")
    private String photoContentType;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;

    @OneToMany(mappedBy = "student")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StudentMarkes> students = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Attendence> attendences = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<StudentFee> fees = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("classes")
    private ClassName className;

    @ManyToOne
    @JsonIgnoreProperties("sections")
    private Section section;

    @ManyToOne
    @JsonIgnoreProperties("busRouteNames")
    private BusStops busStops;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Student studentId(Long studentId) {
        this.studentId = studentId;
        return this;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Student studentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getParentName() {
        return parentName;
    }

    public Student parentName(String parentName) {
        this.parentName = parentName;
        return this;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Student phoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Student address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Student photo(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public Student photoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
        return this;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public String getStatus() {
        return status;
    }

    public Student status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public Student comments(String comments) {
        this.comments = comments;
        return this;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<StudentMarkes> getStudents() {
        return students;
    }

    public Student students(Set<StudentMarkes> studentMarkes) {
        this.students = studentMarkes;
        return this;
    }

    public Student addStudent(StudentMarkes studentMarkes) {
        this.students.add(studentMarkes);
        studentMarkes.setStudent(this);
        return this;
    }

    public Student removeStudent(StudentMarkes studentMarkes) {
        this.students.remove(studentMarkes);
        studentMarkes.setStudent(null);
        return this;
    }

    public void setStudents(Set<StudentMarkes> studentMarkes) {
        this.students = studentMarkes;
    }

    public Set<Attendence> getAttendences() {
        return attendences;
    }

    public Student attendences(Set<Attendence> attendences) {
        this.attendences = attendences;
        return this;
    }

    public Student addAttendence(Attendence attendence) {
        this.attendences.add(attendence);
        attendence.setStudent(this);
        return this;
    }

    public Student removeAttendence(Attendence attendence) {
        this.attendences.remove(attendence);
        attendence.setStudent(null);
        return this;
    }

    public void setAttendences(Set<Attendence> attendences) {
        this.attendences = attendences;
    }

    public Set<StudentFee> getFees() {
        return fees;
    }

    public Student fees(Set<StudentFee> studentFees) {
        this.fees = studentFees;
        return this;
    }

    public Student addFee(StudentFee studentFee) {
        this.fees.add(studentFee);
        studentFee.setStudent(this);
        return this;
    }

    public Student removeFee(StudentFee studentFee) {
        this.fees.remove(studentFee);
        studentFee.setStudent(null);
        return this;
    }

    public void setFees(Set<StudentFee> studentFees) {
        this.fees = studentFees;
    }

    public ClassName getClassName() {
        return className;
    }

    public Student className(ClassName className) {
        this.className = className;
        return this;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

    public Section getSection() {
        return section;
    }

    public Student section(Section section) {
        this.section = section;
        return this;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public BusStops getBusStops() {
        return busStops;
    }

    public Student busStops(BusStops busStops) {
        this.busStops = busStops;
        return this;
    }

    public void setBusStops(BusStops busStops) {
        this.busStops = busStops;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        return id != null && id.equals(((Student) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + getId() +
            ", studentId=" + getStudentId() +
            ", studentName='" + getStudentName() + "'" +
            ", parentName='" + getParentName() + "'" +
            ", phoneNumber=" + getPhoneNumber() +
            ", address='" + getAddress() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", photoContentType='" + getPhotoContentType() + "'" +
            ", status='" + getStatus() + "'" +
            ", comments='" + getComments() + "'" +
            "}";
    }
}
