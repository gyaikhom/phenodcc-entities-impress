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
@Table(name = "parameter_has_options", catalog = "impress", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"parameter_id", "param_option_id"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ParameterHasOptions.findAll", query = "SELECT p FROM ParameterHasOptions p"),
    @NamedQuery(name = "ParameterHasOptions.findById", query = "SELECT p FROM ParameterHasOptions p WHERE p.id = :id"),
    @NamedQuery(name = "ParameterHasOptions.findByWeight", query = "SELECT p FROM ParameterHasOptions p WHERE p.weight = :weight")})
public class ParameterHasOptions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false)
    private int weight;
    @JoinColumn(name = "param_option_id", referencedColumnName = "param_option_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private ParamOption paramOptionId;
    @JoinColumn(name = "parameter_id", referencedColumnName = "parameter_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Parameter parameterId;

    public ParameterHasOptions() {
    }

    public ParameterHasOptions(Integer id) {
        this.id = id;
    }

    public ParameterHasOptions(Integer id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public ParamOption getParamOptionId() {
        return paramOptionId;
    }

    public void setParamOptionId(ParamOption paramOptionId) {
        this.paramOptionId = paramOptionId;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }
}
