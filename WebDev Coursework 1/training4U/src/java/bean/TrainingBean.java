/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Booking;
import entity.Instructor;
import entity.Lesson;
import entity.Sport;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cmpmchad
 */
@Named(value = "trainingBean")
@SessionScoped
public class TrainingBean implements Serializable {
    @PersistenceContext(unitName = "training4UPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    List<Lesson> lessons;
    //Booking booking;
    /**
     * Creates a new instance of TrainingBean
     */
    public TrainingBean() {
        
    }
    private int bookingNo;
    private int userLessonNo;
    private String firstName;
    private String surname;
    private String phoneNumber;
    

    public List<Lesson>getLessons() {
        return lessons;
    }
    
    public List<Sport>getSports(){
        return em.createNamedQuery("Sport.findAll").getResultList();
    }
    
    public List<Instructor>getInstructors(){
        return em.createNamedQuery("Instructor.findAll").getResultList();
    }
    
    public List<Booking>getBookings(){
        return em.createNamedQuery("Booking.findAll").getResultList();
    }
    
    public String listSports(Sport sportName) {
       lessons = em.createNamedQuery("Lesson.findBySportNo").setParameter("sportNo", sportName).getResultList();
       return "lessons";
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }
    
    public int getUserLessonNo() {
        return userLessonNo;
    }

    public void setUserLessonNo(int userLessonNo) {
        this.userLessonNo = userLessonNo;
    }
    
    //booking attempts
    
    /*public String book(){
        if(this.firstName !=null && this.surname !=null && this.phoneNumber !=null){
            this.firstName == booking.customerFirstName;
    }
    }*/
    
    /*public void book(Booking booking ){
        //booking.setbookingNo(bookingNo + 1);
        booking.setBookingNo(1);
        booking.setLessonNo(1);
        booking.setCustomerFirstname(this.firstName);
        booking.setCustomerSurname(this.surname);
        booking.setCustomerPhone(this.phoneNumber);
        updateEntity(booking);
    }
    
    public void updateEntity(Object object) {
        try {
            utx.begin();
            em.merge(object);
            utx.commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean addBooking(Booking booking){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            setBookingNo(booking.getBookingNo());
            setUserLessonNo(booking.getLessonNo());
            setFirstName(booking.getCustomerFirstname());
            setSurname(booking.getCustomerSurname());
            setPhoneNumber(booking.getCustomerPhone());
            em.persist(booking);
            em.getTransaction().commit();
        
        } finally{
            em.close();
            return false;
        }
        
    }

    private EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
