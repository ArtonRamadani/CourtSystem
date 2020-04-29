/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author RinorJahaj
 */
@Entity
@Table(name = "Furnitori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Furnitori.findAll", query = "SELECT f FROM Furnitori f")
    , @NamedQuery(name = "Furnitori.findByFurnitoriID", query = "SELECT f FROM Furnitori f WHERE f.furnitoriID = :furnitoriID")
    , @NamedQuery(name = "Furnitori.findByEmri", query = "SELECT f FROM Furnitori f WHERE f.emri = :emri")})
public class Furnitori implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FurnitoriID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer furnitoriID;
    @Column(name = "Emri")
    private String emri;

    public Furnitori() {
    }

    public Furnitori(Integer furnitoriID) {
        this.furnitoriID = furnitoriID;
    }

    public Integer getFurnitoriID() {
        return furnitoriID;
    }

    public void setFurnitoriID(Integer furnitoriID) {
        this.furnitoriID = furnitoriID;
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
        hash += (furnitoriID != null ? furnitoriID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Furnitori)) {
            return false;
        }
        Furnitori other = (Furnitori) object;
        if ((this.furnitoriID == null && other.furnitoriID != null) || (this.furnitoriID != null && !this.furnitoriID.equals(other.furnitoriID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Furnitori[ furnitoriID=" + furnitoriID + " ]";
    }

}
