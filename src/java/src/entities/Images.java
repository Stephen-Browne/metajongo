/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stephen
 */
@Entity
@Table(name = "images")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Images.findAll", query = "SELECT i FROM Images i"),
    @NamedQuery(name = "Images.findByIdimages", query = "SELECT i FROM Images i WHERE i.idimages = :idimages")})
public class Images implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idimages")
    private Integer idimages;
    @Lob
    @Size(max = 65535)
    @Column(name = "imageName")
    private String imageName;
    @JoinColumn(name = "properties_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Properties propertiesId;

    public Images() {
    }

    public Images(Integer idimages) {
        this.idimages = idimages;
    }

    public Integer getIdimages() {
        return idimages;
    }

    public void setIdimages(Integer idimages) {
        this.idimages = idimages;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Properties getPropertiesId() {
        return propertiesId;
    }

    public void setPropertiesId(Properties propertiesId) {
        this.propertiesId = propertiesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idimages != null ? idimages.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Images)) {
            return false;
        }
        Images other = (Images) object;
        if ((this.idimages == null && other.idimages != null) || (this.idimages != null && !this.idimages.equals(other.idimages))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "src.entities.Images[ idimages=" + idimages + " ]";
    }
    
}
