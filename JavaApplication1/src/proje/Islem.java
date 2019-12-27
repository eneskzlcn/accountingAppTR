/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proje;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ISLEM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Islem.findAll", query = "SELECT \u0131 FROM Islem \u0131"),
    @NamedQuery(name = "Islem.findByIslemId", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.islemId = :islemId"),
    @NamedQuery(name = "Islem.findByTutar", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.tutar = :tutar"),
    @NamedQuery(name = "Islem.findByTutarturu", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.tutarturu = :tutarturu"),
    @NamedQuery(name = "Islem.findByTarih", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.tarih = :tarih"),
    @NamedQuery(name = "Islem.findByVadetarihi", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.vadetarihi = :vadetarihi"),
    @NamedQuery(name = "Islem.findByIslemsaati", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.islemsaati = :islemsaati"),
    @NamedQuery(name = "Islem.findByIslemturu", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.islemturu = :islemturu"),
    @NamedQuery(name = "Islem.findByCariId", query = "SELECT \u0131 FROM Islem \u0131 WHERE \u0131.cariId = :cariId")})
public class Islem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ISLEM_ID")
    private Integer islemId;
    @Column(name = "TUTAR")
    private Integer tutar;
    @Column(name = "TUTARTURU")
    private String tutarturu;
    @Column(name = "TARIH")
    private String tarih;
    @Column(name = "VADETARIHI")
    private String vadetarihi;
    @Column(name = "ISLEMSAATI")
    private String islemsaati;
    @Column(name = "ISLEMTURU")
    private String islemturu;
    @Column(name = "CARI_ID")
    private int cariId;

    public Islem() {
    }

    public Islem(Integer islemId) {
        this.islemId = islemId;
    }

    public Integer getIslemId() {
        return islemId;
    }

    public void setIslemId(Integer islemId) {
        this.islemId = islemId;
    }

    public Integer getTutar() {
        return tutar;
    }

    public void setTutar(Integer tutar) {
        this.tutar = tutar;
    }

    public String getTutarturu() {
        return tutarturu;
    }

    public void setTutarturu(String tutarturu) {
        this.tutarturu = tutarturu;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getVadetarihi() {
        return vadetarihi;
    }

    public void setVadetarihi(String vadetarihi) {
        this.vadetarihi = vadetarihi;
    }

    public String getIslemsaati() {
        return islemsaati;
    }

    public void setIslemsaati(String islemsaati) {
        this.islemsaati = islemsaati;
    }

    public String getIslemturu() {
        return islemturu;
    }

    public void setIslemturu(String islemturu) {
        this.islemturu = islemturu;
    }

    public int getCariId() {
        return cariId;
    }

    public void setCariId(int cariId) {
        this.cariId = cariId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (islemId != null ? islemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Islem)) {
            return false;
        }
        Islem other = (Islem) object;
        if ((this.islemId == null && other.islemId != null) || (this.islemId != null && !this.islemId.equals(other.islemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return islemturu;
    }
    
}
