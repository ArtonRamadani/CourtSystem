/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ArtonRamadani
 */
@Entity
@Table(name = "Prioriteti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioriteti.findAll", query = "SELECT p FROM Prioriteti p")
    , @NamedQuery(name = "Prioriteti.findByPrioritetiID", query = "SELECT p FROM Prioriteti p WHERE p.prioritetiID = :prioritetiID")
    , @NamedQuery(name = "Prioriteti.findByEmertimi", query = "SELECT p FROM Prioriteti p WHERE p.emertimi = :emertimi")})
public class Prioriteti implements Serializable {

    @OneToMany(mappedBy = "prioritetiID")
    private Collection<Detyra> detyraCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PrioritetiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer prioritetiID;
    @Column(name = "Emertimi")
    private String emertimi;

    public Prioriteti() {
    }

    public Prioriteti(Integer prioritetiID) {
        this.prioritetiID = prioritetiID;
    }

    public Integer getPrioritetiID() {
        return prioritetiID;
    }

    public void setPrioritetiID(Integer prioritetiID) {
        this.prioritetiID = prioritetiID;
    }

    public String getEmertimi() {
        return emertimi;
    }

    public void setEmertimi(String emertimi) {
        this.emertimi = emertimi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prioritetiID != null ? prioritetiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioriteti)) {
            return false;
        }
        Prioriteti other = (Prioriteti) object;
        if ((this.prioritetiID == null && other.prioritetiID != null) || (this.prioritetiID != null && !this.prioritetiID.equals(other.prioritetiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emertimi;
    }

    @XmlTransient
    public Collection<Detyra> getDetyraCollection() {
        return detyraCollection;
    }

    public void setDetyraCollection(Collection<Detyra> detyraCollection) {
        this.detyraCollection = detyraCollection;
    }

}
