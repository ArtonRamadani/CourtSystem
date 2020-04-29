/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RinorJahaj
 */
@Entity
@Table(name = "Avokati")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avokati.findAll", query = "SELECT a FROM Avokati a")
    , @NamedQuery(name = "Avokati.findByAvokatiID", query = "SELECT a FROM Avokati a WHERE a.avokatiID = :avokatiID")
    , @NamedQuery(name = "Avokati.findByEmri", query = "SELECT a FROM Avokati a WHERE a.emri = :emri")
    , @NamedQuery(name = "Avokati.findByEmail", query = "SELECT a FROM Avokati a WHERE a.email = :email")
    , @NamedQuery(name = "Avokati.findByDataLindjes", query = "SELECT a FROM Avokati a WHERE a.dataLindjes = :dataLindjes")
    , @NamedQuery(name = "Avokati.findByKontakti", query = "SELECT a FROM Avokati a WHERE a.kontakti = :kontakti")
    , @NamedQuery(name = "Avokati.findByProfili", query = "SELECT a FROM Avokati a WHERE a.profili = :profili")})
public class Avokati implements Serializable {

    @Column(name = "Mbiemri")
    private String mbiemri;

    @OneToMany(mappedBy = "avokatiFK")
    private Collection<Lenda> lendaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AvokatiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer avokatiID;
    @Column(name = "Emri")
    private String emri;
    @Column(name = "Email")
    private String email;
    @Column(name = "DataLindjes")
    @Temporal(TemporalType.DATE)
    private Date dataLindjes;
    @Column(name = "Kontakti")
    private Integer kontakti;
    @Column(name = "Profili")
    private String profili;

    public Avokati() {
    }

    public Avokati(Integer avokatiID) {
        this.avokatiID = avokatiID;
    }

    public Integer getAvokatiID() {
        return avokatiID;
    }

    public void setAvokatiID(Integer avokatiID) {
        this.avokatiID = avokatiID;
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

    public Date getDataLindjes() {
        return dataLindjes;
    }

    public void setDataLindjes(Date dataLindjes) {
        this.dataLindjes = dataLindjes;
    }

    public Integer getKontakti() {
        return kontakti;
    }

    public void setKontakti(Integer kontakti) {
        this.kontakti = kontakti;
    }

    public String getProfili() {
        return profili;
    }

    public void setProfili(String profili) {
        this.profili = profili;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avokatiID != null ? avokatiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avokati)) {
            return false;
        }
        Avokati other = (Avokati) object;
        if ((this.avokatiID == null && other.avokatiID != null) || (this.avokatiID != null && !this.avokatiID.equals(other.avokatiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return avokatiID + " - " + emri + " " + mbiemri;
    }

    @XmlTransient
    public Collection<Lenda> getLendaCollection() {
        return lendaCollection;
    }

    public void setLendaCollection(Collection<Lenda> lendaCollection) {
        this.lendaCollection = lendaCollection;
    }

    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }
    
}
