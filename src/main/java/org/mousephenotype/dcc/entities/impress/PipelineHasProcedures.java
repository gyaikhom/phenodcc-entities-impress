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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "pipeline_has_procedures", catalog = "impress", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pipeline_id", "procedure_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PipelineHasProcedures.findAll", query = "SELECT p FROM PipelineHasProcedures p"),
    @NamedQuery(name = "PipelineHasProcedures.findById", query = "SELECT p FROM PipelineHasProcedures p WHERE p.id = :id"),
    @NamedQuery(name = "PipelineHasProcedures.findByWeight", query = "SELECT p FROM PipelineHasProcedures p WHERE p.weight = :weight"),
    @NamedQuery(name = "PipelineHasProcedures.findByMinFemales", query = "SELECT p FROM PipelineHasProcedures p WHERE p.minFemales = :minFemales"),
    @NamedQuery(name = "PipelineHasProcedures.findByMinMales", query = "SELECT p FROM PipelineHasProcedures p WHERE p.minMales = :minMales"),
    @NamedQuery(name = "PipelineHasProcedures.findByMinAnimals", query = "SELECT p FROM PipelineHasProcedures p WHERE p.minAnimals = :minAnimals"),
    @NamedQuery(name = "PipelineHasProcedures.findByIsVisible", query = "SELECT p FROM PipelineHasProcedures p WHERE p.isVisible = :isVisible"),
    @NamedQuery(name = "PipelineHasProcedures.findByIsActive", query = "SELECT p FROM PipelineHasProcedures p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "PipelineHasProcedures.findByIsMandatory", query = "SELECT p FROM PipelineHasProcedures p WHERE p.isMandatory = :isMandatory"),
    @NamedQuery(name = "PipelineHasProcedures.findByIsInternal", query = "SELECT p FROM PipelineHasProcedures p WHERE p.isInternal = :isInternal"),
    @NamedQuery(name = "PipelineHasProcedures.findByIsDeprecated", query = "SELECT p FROM PipelineHasProcedures p WHERE p.isDeprecated = :isDeprecated"),
    @NamedQuery(name = "PipelineHasProcedures.findByIsDeleted", query = "SELECT p FROM PipelineHasProcedures p WHERE p.isDeleted = :isDeleted")})
public class PipelineHasProcedures implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer weight;
    @Basic(optional = false)
    @Column(name = "is_visible", nullable = false)
    private boolean isVisible;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Basic(optional = false)
    @Column(name = "is_mandatory", nullable = false)
    private boolean isMandatory;
    @Basic(optional = false)
    @Column(name = "is_internal", nullable = false)
    private boolean isInternal;
    @Basic(optional = false)
    @Column(name = "is_deprecated", nullable = false)
    private boolean isDeprecated;
    @Basic(optional = false)
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    @Basic(optional = true)
    @Column(name = "min_females", nullable = true)
    private Integer minFemales;
    @Basic(optional = true)
    @Column(name = "min_males", nullable = true)
    private Integer minMales;
    @Basic(optional = true)
    @Column(name = "min_animals", nullable = true)
    private Integer minAnimals;
    @JoinColumn(name = "week", referencedColumnName = "id")
    @ManyToOne
    private ProcedureWeek week;
    @JoinColumn(name = "procedure_id", referencedColumnName = "procedure_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Procedure procedureId;
    @JoinColumn(name = "pipeline_id", referencedColumnName = "pipeline_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Pipeline pipelineId;

    public PipelineHasProcedures() {
    }

    public PipelineHasProcedures(Integer id) {
        this.id = id;
    }

    public PipelineHasProcedures(Integer id, boolean isVisible, boolean isActive, boolean isMandatory, boolean isInternal, boolean isDeprecated, boolean isDeleted) {
        this.id = id;
        this.isVisible = isVisible;
        this.isActive = isActive;
        this.isMandatory = isMandatory;
        this.isInternal = isInternal;
        this.isDeprecated = isDeprecated;
        this.isDeleted = isDeleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public boolean getIsInternal() {
        return isInternal;
    }

    public void setIsInternal(boolean isInternal) {
        this.isInternal = isInternal;
    }

    public boolean getIsDeprecated() {
        return isDeprecated;
    }

    public void setIsDeprecated(boolean isDeprecated) {
        this.isDeprecated = isDeprecated;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ProcedureWeek getWeek() {
        return week;
    }

    public void setWeek(ProcedureWeek week) {
        this.week = week;
    }

    public Integer getMinFemales() {
        return minFemales;
    }

    public void setMinFemales(Integer minFemales) {
        this.minFemales = minFemales;
    }

    public Integer getMinMales() {
        return minMales;
    }

    public void setMinMales(Integer minMales) {
        this.minMales = minMales;
    }

    public Integer getMinAnimals() {
        return minAnimals;
    }

    public void setMinAnimals(Integer minAnimals) {
        this.minAnimals = minAnimals;
    }

    public Procedure getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Procedure procedureId) {
        this.procedureId = procedureId;
    }

    public Pipeline getPipelineId() {
        return pipelineId;
    }

    public void setPipelineId(Pipeline pipelineId) {
        this.pipelineId = pipelineId;
    }
}
