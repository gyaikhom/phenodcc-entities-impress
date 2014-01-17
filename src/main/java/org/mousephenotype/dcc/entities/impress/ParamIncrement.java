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
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "param_increment", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParamIncrement.findAll", query = "SELECT p FROM ParamIncrement p"),
    @NamedQuery(name = "ParamIncrement.findByParamIncrementId", query = "SELECT p FROM ParamIncrement p WHERE p.paramIncrementId = :paramIncrementId"),
    @NamedQuery(name = "ParamIncrement.findByWeight", query = "SELECT p FROM ParamIncrement p WHERE p.weight = :weight"),
    @NamedQuery(name = "ParamIncrement.findByIsActive", query = "SELECT p FROM ParamIncrement p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "ParamIncrement.findByIncrementString", query = "SELECT p FROM ParamIncrement p WHERE p.incrementString = :incrementString"),
    @NamedQuery(name = "ParamIncrement.findByIncrementType", query = "SELECT p FROM ParamIncrement p WHERE p.incrementType = :incrementType"),
    @NamedQuery(name = "ParamIncrement.findByIncrementUnit", query = "SELECT p FROM ParamIncrement p WHERE p.incrementUnit = :incrementUnit"),
    @NamedQuery(name = "ParamIncrement.findByIncrementMin", query = "SELECT p FROM ParamIncrement p WHERE p.incrementMin = :incrementMin"),
    @NamedQuery(name = "ParamIncrement.findByDeleted", query = "SELECT p FROM ParamIncrement p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "ParamIncrement.findByUserId", query = "SELECT p FROM ParamIncrement p WHERE p.userId = :userId"),
    @NamedQuery(name = "ParamIncrement.findByTimeModified", query = "SELECT p FROM ParamIncrement p WHERE p.timeModified = :timeModified")})
public class ParamIncrement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "param_increment_id", nullable = false)
    private Integer paramIncrementId;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Column(name = "increment_string", length = 255)
    private String incrementString;
    @Column(name = "increment_type", length = 255)
    private String incrementType;
    @Column(name = "increment_unit", length = 255)
    private String incrementUnit;
    @Column(name = "increment_min")
    private Integer incrementMin;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean deleted;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "time_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModified;
    @JoinColumn(name = "parameter_id", referencedColumnName = "parameter_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Parameter parameterId;

    public ParamIncrement() {
    }

    public ParamIncrement(Integer paramIncrementId) {
        this.paramIncrementId = paramIncrementId;
    }

    public ParamIncrement(Integer paramIncrementId, int weight, boolean isActive, boolean deleted) {
        this.paramIncrementId = paramIncrementId;
        this.weight = weight;
        this.isActive = isActive;
        this.deleted = deleted;
    }

    public Integer getParamIncrementId() {
        return paramIncrementId;
    }

    public void setParamIncrementId(Integer paramIncrementId) {
        this.paramIncrementId = paramIncrementId;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getIncrementString() {
        return incrementString;
    }

    public void setIncrementString(String incrementString) {
        this.incrementString = incrementString;
    }

    public String getIncrementType() {
        return incrementType;
    }

    public void setIncrementType(String incrementType) {
        this.incrementType = incrementType;
    }

    public String getIncrementUnit() {
        return incrementUnit;
    }

    public void setIncrementUnit(String incrementUnit) {
        this.incrementUnit = incrementUnit;
    }

    public Integer getIncrementMin() {
        return incrementMin;
    }

    public void setIncrementMin(Integer incrementMin) {
        this.incrementMin = incrementMin;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }
}
