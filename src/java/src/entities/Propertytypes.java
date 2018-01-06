/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "propertytypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Propertytypes.findAll", query = "SELECT p FROM Propertytypes p"),
    @NamedQuery(name = "Propertytypes.findByTypeId", query = "SELECT p FROM Propertytypes p WHERE p.typeId = :typeId"),
    @NamedQuery(name = "Propertytypes.findByPType", query = "SELECT p FROM Propertytypes p WHERE p.pType = :pType")})
public class Propertytypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "typeId")
    private Integer typeId;
    @Size(max = 20)
    @Column(name = "pType")
    private String pType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propertytypestypeId")
    private Collection<Properties> propertiesCollection;

    public Propertytypes() {
    }

    public Propertytypes(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getPType() {
        return pType;
    }

    public void setPType(String pType) {
        this.pType = pType;
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
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Propertytypes)) {
            return false;
        }
        Propertytypes other = (Propertytypes) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Propertytypes[ typeId=" + typeId + " ]";
    }
    
}
