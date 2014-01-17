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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "param_option", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParamOption.findAll", query = "SELECT p FROM ParamOption p"),
    @NamedQuery(name = "ParamOption.findByParamOptionId", query = "SELECT p FROM ParamOption p WHERE p.paramOptionId = :paramOptionId"),
    @NamedQuery(name = "ParamOption.findByParentId", query = "SELECT p FROM ParamOption p WHERE p.parentId = :parentId"),
    @NamedQuery(name = "ParamOption.findByName", query = "SELECT p FROM ParamOption p WHERE p.name = :name"),
    @NamedQuery(name = "ParamOption.findByIsDefault", query = "SELECT p FROM ParamOption p WHERE p.isDefault = :isDefault"),
    @NamedQuery(name = "ParamOption.findByIsActive", query = "SELECT p FROM ParamOption p WHERE p.isActive = :isActive"),
    @NamedQuery(name = "ParamOption.findByWeight", query = "SELECT p FROM ParamOption p WHERE p.weight = :weight"),
    @NamedQuery(name = "ParamOption.findByDeleted", query = "SELECT p FROM ParamOption p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "ParamOption.findByUserId", query = "SELECT p FROM ParamOption p WHERE p.userId = :userId"),
    @NamedQuery(name = "ParamOption.findByTimeModified", query = "SELECT p FROM ParamOption p WHERE p.timeModified = :timeModified")})
public class ParamOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "param_option_id", nullable = false)
    private Integer paramOptionId;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(length = 255)
    private String name;
    @Basic(optional = false)
    @Column(name = "is_default", nullable = false)
    private boolean isDefault;
    @Basic(optional = false)
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;
    @Lob
    @Column(length = 65535)
    private String description;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean deleted;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "time_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModified;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paramOptionId")
    private Collection<ParameterHasOptions> parameterHasOptionsCollection;

    public ParamOption() {
    }

    public ParamOption(Integer paramOptionId) {
        this.paramOptionId = paramOptionId;
    }

    public ParamOption(Integer paramOptionId, boolean isDefault, boolean isActive, int weight, boolean deleted) {
        this.paramOptionId = paramOptionId;
        this.isDefault = isDefault;
        this.isActive = isActive;
        this.weight = weight;
        this.deleted = deleted;
    }

    public Integer getParamOptionId() {
        return paramOptionId;
    }

    public void setParamOptionId(Integer paramOptionId) {
        this.paramOptionId = paramOptionId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @XmlTransient
    public Collection<ParameterHasOptions> getParameterHasOptionsCollection() {
        return parameterHasOptionsCollection;
    }

    public void setParameterHasOptionsCollection(Collection<ParameterHasOptions> parameterHasOptionsCollection) {
        this.parameterHasOptionsCollection = parameterHasOptionsCollection;
    }
}
