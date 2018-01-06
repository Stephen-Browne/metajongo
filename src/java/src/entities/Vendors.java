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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "vendors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendors.findAll", query = "SELECT v FROM Vendors v"),
    @NamedQuery(name = "Vendors.findByVendorid", query = "SELECT v FROM Vendors v WHERE v.vendorid = :vendorid"),
    @NamedQuery(name = "Vendors.findByName", query = "SELECT v FROM Vendors v WHERE v.name = :name")})
public class Vendors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "vendorid")
    private Integer vendorid;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "agents_agentId", referencedColumnName = "agentId")
    @ManyToOne
    private Agents agentsagentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendorsVendorid")
    private Collection<Properties> propertiesCollection;

    public Vendors() {
    }

    public Vendors(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public Integer getVendorid() {
        return vendorid;
    }

    public void setVendorid(Integer vendorid) {
        this.vendorid = vendorid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agents getAgentsagentId() {
        return agentsagentId;
    }

    public void setAgentsagentId(Agents agentsagentId) {
        this.agentsagentId = agentsagentId;
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
        hash += (vendorid != null ? vendorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendors)) {
            return false;
        }
        Vendors other = (Vendors) object;
        if ((this.vendorid == null && other.vendorid != null) || (this.vendorid != null && !this.vendorid.equals(other.vendorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Vendors[ vendorid=" + vendorid + " ]";
    }
    
}
