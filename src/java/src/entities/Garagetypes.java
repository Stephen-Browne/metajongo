/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
 * @author Stephen
 */
@Entity
@Table(name = "garagetypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garagetypes.findAll", query = "SELECT g FROM Garagetypes g"),
    @NamedQuery(name = "Garagetypes.findByGarageId", query = "SELECT g FROM Garagetypes g WHERE g.garageId = :garageId"),
    @NamedQuery(name = "Garagetypes.findByGType", query = "SELECT g FROM Garagetypes g WHERE g.gType = :gType")})
public class Garagetypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "garageId")
    private Integer garageId;
    @Size(max = 20)
    @Column(name = "gType")
    private String gType;
    @OneToMany(mappedBy = "garagetypesgarageId")
    private Collection<Properties> propertiesCollection;

    public Garagetypes() {
    }

    public Garagetypes(Integer garageId) {
        this.garageId = garageId;
    }

    public Integer getGarageId() {
        return garageId;
    }

    public void setGarageId(Integer garageId) {
        this.garageId = garageId;
    }

    public String getGType() {
        return gType;
    }

    public void setGType(String gType) {
        this.gType = gType;
    }

    @XmlTransient
    public Collection<Properties> getPropertiesCollection() {
        return propertiesCollection;
    }

    public void setPropertiesCollection(Collection<Properties> propertiesCollection) {
        this.propertiesCollection = propertiesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (garageId != null ? garageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garagetypes)) {
            return false;
        }
        Garagetypes other = (Garagetypes) object;
        if ((this.garageId == null && other.garageId != null) || (this.garageId != null && !this.garageId.equals(other.garageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Garagetypes[ garageId=" + garageId + " ]";
    }
    
}
