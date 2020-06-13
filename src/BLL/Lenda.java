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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Lenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lenda.findAll", query = "SELECT l FROM Lenda l")
    , @NamedQuery(name = "Lenda.findByLendaID", query = "SELECT l FROM Lenda l WHERE l.lendaID = :lendaID")
    , @NamedQuery(name = "Lenda.findByDetajet", query = "SELECT l FROM Lenda l WHERE l.detajet = :detajet")})
public class Lenda implements Serializable {

   
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "Emri")
    private String emri;

    @JoinColumn(name = "LlojiPageses", referencedColumnName = "QmimiID")
    @ManyToOne
    private LlojiPageses llojiPageses;

    @OneToMany(mappedBy = "lendaID")
    private Collection<Detyra> detyraCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LendaID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer lendaID;
    @Column(name = "Detajet")
    private String detajet;
    @JoinColumn(name = "AvokatiFK", referencedColumnName = "AvokatiID")
    @ManyToOne
    private Avokati avokatiFK;
    @JoinColumn(name = "KlientiFK", referencedColumnName = "KlientiID")
    @ManyToOne
    private Klienti klientiFK;

    public Lenda() {
    }

    public Lenda(Integer lendaID) {
        this.lendaID = lendaID;
    }

    public Integer getLendaID() {
        return lendaID;
    }

    public void setLendaID(Integer lendaID) {
        this.lendaID = lendaID;
    }

    public String getDetajet() {
        return detajet;
    }

    public void setDetajet(String detajet) {
        this.detajet = detajet;
    }

    public Avokati getAvokatiFK() {
        return avokatiFK;
    }

    public void setAvokatiFK(Avokati avokatiFK) {
        this.avokatiFK = avokatiFK;
    }

    public Klienti getKlientiFK() {
        return klientiFK;
    }

    public void setKlientiFK(Klienti klientiFK) {
        this.klientiFK = klientiFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lendaID != null ? lendaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lenda)) {
            return false;
        }
        Lenda other = (Lenda) object;
        if ((this.lendaID == null && other.lendaID != null) || (this.lendaID != null && !this.lendaID.equals(other.lendaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return lendaID + " " + emri;
    }

    @XmlTransient
    public Collection<Detyra> getDetyraCollection() {
        return detyraCollection;
    }

    public void setDetyraCollection(Collection<Detyra> detyraCollection) {
        this.detyraCollection = detyraCollection;
    }

    public LlojiPageses getLlojiPageses() {
        return llojiPageses;
    }

    public void setLlojiPageses(LlojiPageses llojiPageses) {
        this.llojiPageses = llojiPageses;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

  

}
