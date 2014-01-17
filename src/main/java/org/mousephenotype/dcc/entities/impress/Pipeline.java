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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "pipeline", catalog = "impress", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pipeline_key"})})
@XmlRootElement
@XmlType(propOrder = {"i", "k", "n", "M", "m"})
@NamedQueries({
    @NamedQuery(name = "Pipeline.findAll", query = "SELECT p FROM Pipeline p WHERE (p.deleted = 0 AND p.active = 1 AND p.deprecated = 0) ORDER BY p.name, p.pipelineKey"),
    @NamedQuery(name = "Pipeline.findImpc", query = "SELECT p FROM Pipeline p WHERE (p.impc = 1 AND p.deleted = 0 AND p.active = 1 AND p.deprecated = 0) ORDER BY p.name, p.pipelineKey"),
    @NamedQuery(name = "Pipeline.findByCentre", query = "SELECT p FROM Pipeline p WHERE ((p.centreName IS NULL OR p.centreName = :centreName) AND p.impc = 1 AND p.deleted = 0 AND p.active = 1 AND p.deprecated = 0) ORDER BY p.name, p.pipelineKey"),
    @NamedQuery(name = "Pipeline.findByPipelineId", query = "SELECT p FROM Pipeline p WHERE p.pipelineId = :pipelineId"),
    @NamedQuery(name = "Pipeline.findByPipelineKey", query = "SELECT p FROM Pipeline p WHERE p.pipelineKey = :pipelineKey"),
    @NamedQuery(name = "Pipeline.findByName", query = "SELECT p FROM Pipeline p WHERE p.name = :name"),
    @NamedQuery(name = "Pipeline.findByWeight", query = "SELECT p FROM Pipeline p WHERE p.weight = :weight"),
    @NamedQuery(name = "Pipeline.findByVisible", query = "SELECT p FROM Pipeline p WHERE p.visible = :visible"),
    @NamedQuery(name = "Pipeline.findByActive", query = "SELECT p FROM Pipeline p WHERE p.active = :active"),
    @NamedQuery(name = "Pipeline.findByDeprecated", query = "SELECT p FROM Pipeline p WHERE p.deprecated = :deprecated"),
    @NamedQuery(name = "Pipeline.findByMajorVersion", query = "SELECT p FROM Pipeline p WHERE p.majorVersion = :majorVersion"),
    @NamedQuery(name = "Pipeline.findByMinorVersion", query = "SELECT p FROM Pipeline p WHERE p.minorVersion = :minorVersion"),
    @NamedQuery(name = "Pipeline.findByTimeModified", query = "SELECT p FROM Pipeline p WHERE p.timeModified = :timeModified"),
    @NamedQuery(name = "Pipeline.findByUserId", query = "SELECT p FROM Pipeline p WHERE p.userId = :userId"),
    @NamedQuery(name = "Pipeline.findByInternal", query = "SELECT p FROM Pipeline p WHERE p.internal = :internal"),
    @NamedQuery(name = "Pipeline.findByDeleted", query = "SELECT p FROM Pipeline p WHERE p.deleted = :deleted")})
public class Pipeline implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pipeline_id", nullable = false)
    private Integer pipelineId;
    @Basic(optional = false)
    @Column(name = "pipeline_key", nullable = false, length = 100)
    private String pipelineKey;
    @Column(length = 255)
    private String name;
    private Integer weight;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean visible;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean active;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean deprecated;
    @Basic(optional = false)
    @Column(name = "major_version", nullable = false)
    private int majorVersion;
    @Basic(optional = false)
    @Column(name = "minor_version", nullable = false)
    private int minorVersion;
    @Lob
    @Column(length = 65535)
    private String description;
    @Column(name = "time_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModified;
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean internal;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean deleted;
    @Column(name = "centre_name", length = 200)
    private String centreName;
    private Short impc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pipelineId")
    private Collection<PipelineHasProcedures> pipelineHasProceduresCollection;

    public Pipeline() {
    }

    public Pipeline(Integer pipelineId) {
        this.pipelineId = pipelineId;
    }

    public Pipeline(Integer pipelineId, String pipelineKey, boolean visible,
            boolean active, boolean deprecated, int majorVersion,
            int minorVersion, int userId, boolean internal, boolean deleted) {
        this.pipelineId = pipelineId;
        this.pipelineKey = pipelineKey;
        this.visible = visible;
        this.active = active;
        this.deprecated = deprecated;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.userId = userId;
        this.internal = internal;
        this.deleted = deleted;
    }

    @XmlElement(name = "i")
    public Integer getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Integer pipelineId) {
        this.pipelineId = pipelineId;
    }

    @XmlElement(name = "k")
    public String getPipelineKey() {
        return pipelineKey;
    }

    public void setPipelineKey(String pipelineKey) {
        this.pipelineKey = pipelineKey;
    }

    @XmlElement(name = "n")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @XmlTransient
    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @XmlTransient
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public boolean getDeprecated() {
        return deprecated;
    }

    public void setDeprecated(boolean deprecated) {
        this.deprecated = deprecated;
    }

    @XmlElement(name = "M")
    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    @XmlElement(name = "m")
    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    @XmlTransient
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Date getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    @XmlTransient
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @XmlTransient
    public boolean getInternal() {
        return internal;
    }

    public void setInternal(boolean internal) {
        this.internal = internal;
    }

    @XmlTransient
    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @XmlTransient
    public String getCentreName() {
        return centreName;
    }

    public void setCentreName(String centreName) {
        this.centreName = centreName;
    }

    @XmlTransient
    public Short getImpc() {
        return impc;
    }

    public void setImpc(Short impc) {
        this.impc = impc;
    }

    @XmlTransient
    public Collection<PipelineHasProcedures> getPipelineHasProceduresCollection() {
        return pipelineHasProceduresCollection;
    }

    public void setPipelineHasProceduresCollection(Collection<PipelineHasProcedures> pipelineHasProceduresCollection) {
        this.pipelineHasProceduresCollection = pipelineHasProceduresCollection;
    }
}
