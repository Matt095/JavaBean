/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cmpmchad
 */
@Entity
@Table(name = "BOOKING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingNo", query = "SELECT b FROM Booking b WHERE b.bookingNo = :bookingNo"),
    @NamedQuery(name = "Booking.findByCustomerFirstname", query = "SELECT b FROM Booking b WHERE b.customerFirstname = :customerFirstname"),
    @NamedQuery(name = "Booking.findByCustomerSurname", query = "SELECT b FROM Booking b WHERE b.customerSurname = :customerSurname"),
    @NamedQuery(name = "Booking.findByCustomerPhone", query = "SELECT b FROM Booking b WHERE b.customerPhone = :customerPhone")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "BOOKING_NO")
    private Integer bookingNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CUSTOMER_FIRSTNAME")
    private String customerFirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CUSTOMER_SURNAME")
    private String customerSurname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "CUSTOMER_PHONE")
    private String customerPhone;
    @JoinColumn(name = "LESSON_NO", referencedColumnName = "LESSON_NO")
    @ManyToOne(optional = false)
    private Lesson lessonNo;

    public Booking() {
    }

    public Booking(Integer bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Booking(Integer bookingNo, String customerFirstname, String customerSurname, String customerPhone) {
        this.bookingNo = bookingNo;
        this.customerFirstname = customerFirstname;
        this.customerSurname = customerSurname;
        this.customerPhone = customerPhone;
    }

    public Integer getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(Integer bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Lesson getLessonNo() {
        return lessonNo;
    }

    public void setLessonNo(Lesson lessonNo) {
        this.lessonNo = lessonNo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingNo != null ? bookingNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingNo == null && other.bookingNo != null) || (this.bookingNo != null && !this.bookingNo.equals(other.bookingNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Booking[ bookingNo=" + bookingNo + " ]";
    }
    
}
