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
 * @author RinorJahaj
 */
@Entity
@Table(name = "LlojiPageses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LlojiPageses.findAll", query = "SELECT l FROM LlojiPageses l")
    , @NamedQuery(name = "LlojiPageses.findByQmimiID", query = "SELECT l FROM LlojiPageses l WHERE l.qmimiID = :qmimiID")
    , @NamedQuery(name = "LlojiPageses.findByEmri", query = "SELECT l FROM LlojiPageses l WHERE l.emri = :emri")})
public class LlojiPageses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "QmimiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer qmimiID;
    @Column(name = "Emri")
    private String emri;
    @OneToMany(mappedBy = "llojiPageses")
    private Collection<Lenda> lendaCollection;

    public LlojiPageses() {
    }

    public LlojiPageses(Integer qmimiID) {
        this.qmimiID = qmimiID;
    }

    public Integer getQmimiID() {
        return qmimiID;
    }

    public void setQmimiID(Integer qmimiID) {
        this.qmimiID = qmimiID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @XmlTransient
    public Collection<Lenda> getLendaCollection() {
        return lendaCollection;
    }

    public void setLendaCollection(Collection<Lenda> lendaCollection) {
        this.lendaCollection = lendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qmimiID != null ? qmimiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LlojiPageses)) {
            return false;
        }
        LlojiPageses other = (LlojiPageses) object;
        if ((this.qmimiID == null && other.qmimiID != null) || (this.qmimiID != null && !this.qmimiID.equals(other.qmimiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return emri;
    }

}
