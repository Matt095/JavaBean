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
@Table(name = "SPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sport.findAll", query = "SELECT s FROM Sport s"),
    @NamedQuery(name = "Sport.findBySportNo", query = "SELECT s FROM Sport s WHERE s.sportNo = :sportNo"),
    @NamedQuery(name = "Sport.findBySportName", query = "SELECT s FROM Sport s WHERE s.sportName = :sportName"),
    @NamedQuery(name = "Sport.findBySportDescription", query = "SELECT s FROM Sport s WHERE s.sportDescription = :sportDescription"),
    @NamedQuery(name = "Sport.findByIndoor", query = "SELECT s FROM Sport s WHERE s.indoor = :indoor")})
public class Sport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SPORT_NO")
    private Integer sportNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SPORT_NAME")
    private String sportName;
    @Size(max = 60)
    @Column(name = "SPORT_DESCRIPTION")
    private String sportDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INDOOR")
    private Boolean indoor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sportNo")
    private Collection<Lesson> lessonCollection;

    public Sport() {
    }

    public Sport(Integer sportNo) {
        this.sportNo = sportNo;
    }

    public Sport(Integer sportNo, String sportName, Boolean indoor) {
        this.sportNo = sportNo;
        this.sportName = sportName;
        this.indoor = indoor;
    }

    public Integer getSportNo() {
        return sportNo;
    }

    public void setSportNo(Integer sportNo) {
        this.sportNo = sportNo;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getSportDescription() {
        return sportDescription;
    }

    public void setSportDescription(String sportDescription) {
        this.sportDescription = sportDescription;
    }

    public Boolean getIndoor() {
        return indoor;
    }

    public void setIndoor(Boolean indoor) {
        this.indoor = indoor;
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
        hash += (sportNo != null ? sportNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sport)) {
            return false;
        }
        Sport other = (Sport) object;
        if ((this.sportNo == null && other.sportNo != null) || (this.sportNo != null && !this.sportNo.equals(other.sportNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Sport[ sportNo=" + sportNo + " ]";
    }
    
}
