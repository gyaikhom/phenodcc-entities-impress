
/*
 * Copyright 2012 Medical Research Council Harwell.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mousephenotype.dcc.entities.impress;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "sop", catalog = "impress", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"procedure_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sop.findAll", query = "SELECT s FROM Sop s"),
    @NamedQuery(name = "Sop.findBySopId", query = "SELECT s FROM Sop s WHERE s.sopId = :sopId"),
    @NamedQuery(name = "Sop.findByTitle", query = "SELECT s FROM Sop s WHERE s.title = :title"),
    @NamedQuery(name = "Sop.findByCentreId", query = "SELECT s FROM Sop s WHERE s.centreId = :centreId"),
    @NamedQuery(name = "Sop.findByMajorVersion", query = "SELECT s FROM Sop s WHERE s.majorVersion = :majorVersion"),
    @NamedQuery(name = "Sop.findByMinorVersion", query = "SELECT s FROM Sop s WHERE s.minorVersion = :minorVersion"),
    @NamedQuery(name = "Sop.findByTimeModified", query = "SELECT s FROM Sop s WHERE s.timeModified = :timeModified"),
    @NamedQuery(name = "Sop.findByUserId", query = "SELECT s FROM Sop s WHERE s.userId = :userId"),
    @NamedQuery(name = "Sop.findByWeight", query = "SELECT s FROM Sop s WHERE s.weight = :weight"),
    @NamedQuery(name = "Sop.findByDeleted", query = "SELECT s FROM Sop s WHERE s.deleted = :deleted")})
public class Sop implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sop_id", nullable = false)
    private Integer sopId;
    @Column(length = 255)
    private String title;
    @Column(name = "centre_id")
    private Integer centreId;
    @Basic(optional = false)
    @Column(name = "major_version", nullable = false)
    private int majorVersion;
    @Basic(optional = false)
    @Column(name = "minor_version", nullable = false)
    private int minorVersion;
    @Column(name = "time_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModified;
    @Column(name = "user_id")
    private Integer userId;
    private Integer weight;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean deleted;
    @JoinColumn(name = "procedure_id", referencedColumnName = "procedure_id", nullable = false)
    @OneToOne(optional = false)
    private Procedure procedureId;
    @OneToMany(mappedBy = "sopId")
    private Collection<Section> sectionCollection;

    public Sop() {
    }

    public Sop(Integer sopId) {
        this.sopId = sopId;
    }

    public Sop(Integer sopId, int majorVersion, int minorVersion, boolean deleted) {
        this.sopId = sopId;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.deleted = deleted;
    }

    public Integer getSopId() {
        return sopId;
    }

    public void setSopId(Integer sopId) {
        this.sopId = sopId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCentreId() {
        return centreId;
    }

    public void setCentreId(Integer centreId) {
        this.centreId = centreId;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public Date getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Procedure getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Procedure procedureId) {
        this.procedureId = procedureId;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection() {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection) {
        this.sectionCollection = sectionCollection;
    }

}
