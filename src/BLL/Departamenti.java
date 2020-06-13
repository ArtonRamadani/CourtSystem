/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Departamenti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departamenti.findAll", query = "SELECT d FROM Departamenti d")
    , @NamedQuery(name = "Departamenti.findByDepartamentiID", query = "SELECT d FROM Departamenti d WHERE d.departamentiID = :departamentiID")
    , @NamedQuery(name = "Departamenti.findByEmri", query = "SELECT d FROM Departamenti d WHERE d.emri = :emri")})
public class Departamenti implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deparamentiFK")
    private Collection<Punonjes> punonjesCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DepartamentiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer departamentiID;
    @Column(name = "Emri")
    private String emri;

    public Departamenti() {
    }

    public Departamenti(Integer departamentiID) {
        this.departamentiID = departamentiID;
    }

    public Integer getDepartamentiID() {
        return departamentiID;
    }

    public void setDepartamentiID(Integer departamentiID) {
        this.departamentiID = departamentiID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (departamentiID != null ? departamentiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamenti)) {
            return false;
        }
        Departamenti other = (Departamenti) object;
        if ((this.departamentiID == null && other.departamentiID != null) || (this.departamentiID != null && !this.departamentiID.equals(other.departamentiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return departamentiID + " - " + emri;
    }

    @XmlTransient
    public Collection<Punonjes> getPunonjesCollection() {
        return punonjesCollection;
    }

    public void setPunonjesCollection(Collection<Punonjes> punonjesCollection) {
        this.punonjesCollection = punonjesCollection;
    }
    
}
