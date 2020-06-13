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
@Table(name = "Klienti")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Klienti.findAll", query = "SELECT k FROM Klienti k")
    , @NamedQuery(name = "Klienti.findByKlientiID", query = "SELECT k FROM Klienti k WHERE k.klientiID = :klientiID")
    , @NamedQuery(name = "Klienti.findByEmri", query = "SELECT k FROM Klienti k WHERE k.emri = :emri")
    , @NamedQuery(name = "Klienti.findByEmail", query = "SELECT k FROM Klienti k WHERE k.email = :email")
    , @NamedQuery(name = "Klienti.findByAdresa", query = "SELECT k FROM Klienti k WHERE k.adresa = :adresa")})
public class Klienti implements Serializable {

    @Column(name = "Mbiemri")
    private String mbiemri;
    @Column(name = "Kontakti")
    private String kontakti;

    @OneToMany(mappedBy = "klientiFK")
    private Collection<Lenda> lendaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "KlientiID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer klientiID;
    @Column(name = "Emri")
    private String emri;
    @Column(name = "Email")
    private String email;
    @Column(name = "Adresa")
    private String adresa;

    public Klienti() {
    }

    public Klienti(Integer klientiID) {
        this.klientiID = klientiID;
    }

    public Integer getKlientiID() {
        return klientiID;
    }

    public void setKlientiID(Integer klientiID) {
        this.klientiID = klientiID;
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

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klientiID != null ? klientiID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Klienti)) {
            return false;
        }
        Klienti other = (Klienti) object;
        if ((this.klientiID == null && other.klientiID != null) || (this.klientiID != null && !this.klientiID.equals(other.klientiID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return klientiID + " - " + emri;
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

    public String getKontakti() {
        return kontakti;
    }

    public void setKontakti(String kontakti) {
        this.kontakti = kontakti;
    }

}
