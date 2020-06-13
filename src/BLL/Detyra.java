/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RinorJahaj
 */
@Entity
@Table(name = "Detyra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detyra.findAll", query = "SELECT d FROM Detyra d")
    , @NamedQuery(name = "Detyra.findByDetyraID", query = "SELECT d FROM Detyra d WHERE d.detyraID = :detyraID")
    , @NamedQuery(name = "Detyra.findByEmri", query = "SELECT d FROM Detyra d WHERE d.emri = :emri")
    , @NamedQuery(name = "Detyra.findByData", query = "SELECT d FROM Detyra d WHERE d.data = :data")})
public class Detyra implements Serializable {

    @Column(name = "Pershkrimi")
    private String pershkrimi;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DetyraID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer detyraID;
    @Column(name = "Emri")
    private String emri;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @JoinColumn(name = "LendaID", referencedColumnName = "LendaID")
    @ManyToOne
    private Lenda lendaID;
    @JoinColumn(name = "PrioritetiID", referencedColumnName = "PrioritetiID")
    @ManyToOne
    private Prioriteti prioritetiID;
    @JoinColumn(name = "PunetoriID", referencedColumnName = "PunonjesID")
    @ManyToOne
    private Punonjes punetoriID;

    public Detyra() {
    }

    public Detyra(Integer detyraID) {
        this.detyraID = detyraID;
    }

    public Integer getDetyraID() {
        return detyraID;
    }

    public void setDetyraID(Integer detyraID) {
        this.detyraID = detyraID;
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


    public Lenda getLendaID() {
        return lendaID;
    }

    public void setLendaID(Lenda lendaID) {
        this.lendaID = lendaID;
    }

    public Prioriteti getPrioritetiID() {
        return prioritetiID;
    }

    public void setPrioritetiID(Prioriteti prioritetiID) {
        this.prioritetiID = prioritetiID;
    }

    public Punonjes getPunetoriID() {
        return punetoriID;
    }

    public void setPunetoriID(Punonjes punetoriID) {
        this.punetoriID = punetoriID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detyraID != null ? detyraID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detyra)) {
            return false;
        }
        Detyra other = (Detyra) object;
        if ((this.detyraID == null && other.detyraID != null) || (this.detyraID != null && !this.detyraID.equals(other.detyraID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Detyra[ detyraID=" + detyraID + " ]";
    }

    public String getPershkrimi() {
        return pershkrimi;
    }

    public void setPershkrimi(String pershkrimi) {
        this.pershkrimi = pershkrimi;
    }

}
