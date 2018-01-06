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
@Table(name = "styles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Styles.findAll", query = "SELECT s FROM Styles s"),
    @NamedQuery(name = "Styles.findByStyleId", query = "SELECT s FROM Styles s WHERE s.styleId = :styleId"),
    @NamedQuery(name = "Styles.findByPStyle", query = "SELECT s FROM Styles s WHERE s.pStyle = :pStyle")})
public class Styles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "styleId")
    private Integer styleId;
    @Size(max = 20)
    @Column(name = "pStyle")
    private String pStyle;
    @OneToMany(mappedBy = "stylesstyleId")
    private Collection<Properties> propertiesCollection;

    public Styles() {
    }

    public Styles(Integer styleId) {
        this.styleId = styleId;
    }

    public Integer getStyleId() {
        return styleId;
    }

    public void setStyleId(Integer styleId) {
        this.styleId = styleId;
    }

    public String getPStyle() {
        return pStyle;
    }

    public void setPStyle(String pStyle) {
        this.pStyle = pStyle;
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
        hash += (styleId != null ? styleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Styles)) {
            return false;
        }
        Styles other = (Styles) object;
        if ((this.styleId == null && other.styleId != null) || (this.styleId != null && !this.styleId.equals(other.styleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Styles[ styleId=" + styleId + " ]";
    }
    
}
