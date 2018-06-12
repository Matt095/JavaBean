/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cmpmchad
 */
@Entity
@Table(name = "LESSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l"),
    @NamedQuery(name = "Lesson.findByLessonNo", query = "SELECT l FROM Lesson l WHERE l.lessonNo = :lessonNo"),
    @NamedQuery(name = "Lesson.findByLessonDate", query = "SELECT l FROM Lesson l WHERE l.lessonDate = :lessonDate"),
    @NamedQuery(name = "Lesson.findByStartTime", query = "SELECT l FROM Lesson l WHERE l.startTime = :startTime"),
    @NamedQuery(name = "Lesson.findByEndTime", query = "SELECT l FROM Lesson l WHERE l.endTime = :endTime"),
    @NamedQuery(name = "Lesson.findByPrice", query = "SELECT l FROM Lesson l WHERE l.price = :price"),
    @NamedQuery(name = "Lesson.findBySportNo", query = "SELECT l FROM Lesson l WHERE l.sportNo = :sportNo")})
    
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSON_NO")
    private Integer lessonNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LESSON_DATE")
    @Temporal(TemporalType.DATE)
    private Date lessonDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIME)
    private Date endTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private BigDecimal price;
    @JoinColumn(name = "INSTRUCTOR_NO", referencedColumnName = "INSTRUCTOR_NO")
    @ManyToOne(optional = false)
    private Instructor instructorNo;
    @JoinColumn(name = "SPORT_NO", referencedColumnName = "SPORT_NO")
    @ManyToOne(optional = false)
    private Sport sportNo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonNo")
    private Collection<Booking> bookingCollection;

    public Lesson() {
    }

    public Lesson(Integer lessonNo) {
        this.lessonNo = lessonNo;
    }

    public Lesson(Integer lessonNo, Date lessonDate, Date startTime, Date endTime, BigDecimal price) {
        this.lessonNo = lessonNo;
        this.lessonDate = lessonDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    public Integer getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(Integer lessonNo) {
        this.lessonNo = lessonNo;
    }

    public Date getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(Date lessonDate) {
        this.lessonDate = lessonDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instructor getInstructorNo() {
        return instructorNo;
    }

    public void setInstructorNo(Instructor instructorNo) {
        this.instructorNo = instructorNo;
    }

    public Sport getSportNo() {
        return sportNo;
    }

    public void setSportNo(Sport sportNo) {
        this.sportNo = sportNo;
    }

    @XmlTransient
    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonNo != null ? lessonNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.lessonNo == null && other.lessonNo != null) || (this.lessonNo != null && !this.lessonNo.equals(other.lessonNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lesson[ lessonNo=" + lessonNo + " ]";
    }
    
}
