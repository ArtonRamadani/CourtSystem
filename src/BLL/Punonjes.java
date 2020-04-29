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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Punonjes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Punonjes.findAll", query = "SELECT p FROM Punonjes p")
    , @NamedQuery(name = "Punonjes.findByPunonjesID", query = "SELECT p FROM Punonjes p WHERE p.punonjesID = :punonjesID")
    , @NamedQuery(name = "Punonjes.findByEmri", query = "SELECT p FROM Punonjes p WHERE p.emri = :emri")
    , @NamedQuery(name = "Punonjes.findByEmail", query = "SELECT p FROM Punonjes p WHERE p.email = :email")
    , @NamedQuery(name = "Punonjes.findByKontakti", query = "SELECT p FROM Punonjes p WHERE p.kontakti = :kontakti")})
public class Punonjes implements Serializable {

    @Column(name = "Mbiemri")
    private String mbiemri;

    @OneToMany(mappedBy = "punetoriID")
    private Collection<Detyra> detyraCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PunonjesID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer punonjesID;
    @Column(name = "Emri")
    private String emri;
    @Column(name = "Email")
    private String email;
    @Column(name = "Kontakti")
    private Integer kontakti;
    @JoinColumn(name = "DeparamentiFK", referencedColumnName = "DepartamentiID")
    @ManyToOne(optional = false)
    private Departamenti deparamentiFK;

    public Punonjes() {
    }

    public Punonjes(Integer punonjesID) {
        this.punonjesID = punonjesID;
    }

    public Integer getPunonjesID() {
        return punonjesID;
    }

    public void setPunonjesID(Integer punonjesID) {
        this.punonjesID = punonjesID;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getKontakti() {
        return kontakti;
    }

    public void setKontakti(Integer kontakti) {
        this.kontakti = kontakti;
    }



    public Departamenti getDeparamentiFK() {
        return deparamentiFK;
    }

    public void setDeparamentiFK(Departamenti deparamentiFK) {
        this.deparamentiFK = deparamentiFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (punonjesID != null ? punonjesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Punonjes)) {
            return false;
        }
        Punonjes other = (Punonjes) object;
        if ((this.punonjesID == null && other.punonjesID != null) || (this.punonjesID != null && !this.punonjesID.equals(other.punonjesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Punonjes[ punonjesID=" + punonjesID + " ]";
    }

    @XmlTransient
    public Collection<Detyra> getDetyraCollection() {
        return detyraCollection;
    }

    public void setDetyraCollection(Collection<Detyra> detyraCollection) {
        this.detyraCollection = detyraCollection;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

}
