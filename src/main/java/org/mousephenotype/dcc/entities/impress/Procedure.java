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
import javax.persistence.Transient;
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
@Table(name = "procedure", catalog = "impress", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"procedure_key"})})
@XmlRootElement
@XmlType(propOrder = {"i", "e", "n", "a"})
@NamedQueries({
    @NamedQuery(name = "Procedure.findAll", query = "SELECT p FROM Procedure p"),
    @NamedQuery(name = "Procedure.findByProcedureId", query = "SELECT p FROM Procedure p WHERE p.procedureId = :procedureId"),
    @NamedQuery(name = "Procedure.findByProcedureKey", query = "SELECT p FROM Procedure p WHERE p.procedureKey = :procedureKey"),
    @NamedQuery(name = "Procedure.findByProcedureKeyLike", query = "SELECT p FROM Procedure p WHERE (p.procedureKey LIKE :pattern1 OR p.procedureKey LIKE :pattern2) order by p.name, p.procedureKey"),
    @NamedQuery(name = "Procedure.findByPipelineId", query = "SELECT p FROM Procedure p, PipelineHasProcedures php WHERE (p = php.procedureId AND php.pipelineId = :pipelineId) order by p.name, p.procedureKey"),
    @NamedQuery(name = "Procedure.findByName", query = "SELECT p FROM Procedure p WHERE p.name = :name"),
    @NamedQuery(name = "Procedure.findByType", query = "SELECT p FROM Procedure p WHERE p.type = :type"),
    @NamedQuery(name = "Procedure.findByMajorVersion", query = "SELECT p FROM Procedure p WHERE p.majorVersion = :majorVersion"),
    @NamedQuery(name = "Procedure.findByMinorVersion", query = "SELECT p FROM Procedure p WHERE p.minorVersion = :minorVersion"),
    @NamedQuery(name = "Procedure.findByTimeModified", query = "SELECT p FROM Procedure p WHERE p.timeModified = :timeModified"),
    @NamedQuery(name = "Procedure.findByUserId", query = "SELECT p FROM Procedure p WHERE p.userId = :userId"),
    @NamedQuery(name = "Procedure.findByOldProcedureKey", query = "SELECT p FROM Procedure p WHERE p.oldProcedureKey = :oldProcedureKey")})
public class Procedure implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "procedure_id", nullable = false)
    private Integer procedureId;
    @Basic(optional = false)
    @Column(name = "procedure_key", nullable = false, length = 100)
    private String procedureKey;
    @Column(length = 255)
    private String name;
    @Basic(optional = false)
    @Column(nullable = false)
    private int type;
    @Basic(optional = false)
    @Column(nullable = false, length = 11)
    private String level;
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
    @Column(name = "old_procedure_key", length = 100)
    private String oldProcedureKey;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedureId")
    private Collection<ProcedureHasParameters> procedureHasParametersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedureId")
    private Collection<PipelineHasProcedures> pipelineHasProceduresCollection;
    
    @Transient
    private short stateId;
    @Transient
    private Long numUnresolved;

    public Procedure() {
    }

    public Procedure(Integer procedureId) {
        this.procedureId = procedureId;
    }

    @XmlElement(name = "i")
    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    @XmlElement(name = "e")
    public String getProcedureKey() {
        return procedureKey;
    }

    public void setProcedureKey(String procedureKey) {
        this.procedureKey = procedureKey;
    }

    @XmlElement(name = "n")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "t")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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

    public String getOldProcedureKey() {
        return oldProcedureKey;
    }

    public void setOldProcedureKey(String oldProcedureKey) {
        this.oldProcedureKey = oldProcedureKey;
    }

    @XmlTransient
    public Collection<ProcedureHasParameters> getProcedureHasParametersCollection() {
        return procedureHasParametersCollection;
    }

    public void setProcedureHasParametersCollection(Collection<ProcedureHasParameters> procedureHasParametersCollection) {
        this.procedureHasParametersCollection = procedureHasParametersCollection;
    }
    
    @XmlTransient
    public Collection<PipelineHasProcedures> getPipelineHasProceduresCollection() {
        return pipelineHasProceduresCollection;
    }

    public void setPipelineHasProceduresCollection(Collection<PipelineHasProcedures> pipelineHasProceduresCollection) {
        this.pipelineHasProceduresCollection = pipelineHasProceduresCollection;
    }

    @XmlElement(name = "s")
    public short getStateId() {
        return stateId;
    }

    public void setStateId(short stateId) {
        this.stateId = stateId;
    }

    @XmlElement(name = "ur")
    public Long getNumUnresolved() {
        return numUnresolved;
    }

    public void setNumUnresolved(Long numUnresolved) {
        this.numUnresolved = numUnresolved;
    }

    @XmlElement(name = "l")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
