/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpmchad
 */
@Entity
@Table(name = "INSTRUCTOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByInstructorNo", query = "SELECT i FROM Instructor i WHERE i.instructorNo = :instructorNo"),
    @NamedQuery(name = "Instructor.findByInstructorFirstname", query = "SELECT i FROM Instructor i WHERE i.instructorFirstname = :instructorFirstname"),
    @NamedQuery(name = "Instructor.findByInstructorSurname", query = "SELECT i FROM Instructor i WHERE i.instructorSurname = :instructorSurname"),
    @NamedQuery(name = "Instructor.findByInstructorPhone", query = "SELECT i FROM Instructor i WHERE i.instructorPhone = :instructorPhone"),
    @NamedQuery(name = "Instructor.findByInstructorEmail", query = "SELECT i FROM Instructor i WHERE i.instructorEmail = :instructorEmail")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSTRUCTOR_NO")
    private Integer instructorNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "INSTRUCTOR_FIRSTNAME")
    private String instructorFirstname;
    @Size(max = 50)
    @Column(name = "INSTRUCTOR_SURNAME")
    private String instructorSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "INSTRUCTOR_PHONE")
    private String instructorPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "INSTRUCTOR_EMAIL")
    private String instructorEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instructorNo")
    private Collection<Lesson> lessonCollection;

    public Instructor() {
    }

    public Instructor(Integer instructorNo) {
        this.instructorNo = instructorNo;
    }

    public Instructor(Integer instructorNo, String instructorFirstname, String instructorPhone, String instructorEmail) {
        this.instructorNo = instructorNo;
        this.instructorFirstname = instructorFirstname;
        this.instructorPhone = instructorPhone;
        this.instructorEmail = instructorEmail;
    }

    public Integer getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(Integer instructorNo) {
        this.instructorNo = instructorNo;
    }

    public String getInstructorFirstname() {
        return instructorFirstname;
    }

    public void setInstructorFirstname(String instructorFirstname) {
        this.instructorFirstname = instructorFirstname;
    }

    public String getInstructorSurname() {
        return instructorSurname;
    }

    public void setInstructorSurname(String instructorSurname) {
        this.instructorSurname = instructorSurname;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    @XmlTransient
    public Collection<Lesson> getLessonCollection() {
        return lessonCollection;
    }

    public void setLessonCollection(Collection<Lesson> lessonCollection) {
        this.lessonCollection = lessonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (instructorNo != null ? instructorNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.instructorNo == null && other.instructorNo != null) || (this.instructorNo != null && !this.instructorNo.equals(other.instructorNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Instructor[ instructorNo=" + instructorNo + " ]";
    }
    
}
