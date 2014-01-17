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
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "procedure_week", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedureWeek.findAll", query = "SELECT p FROM ProcedureWeek p"),
    @NamedQuery(name = "ProcedureWeek.findById", query = "SELECT p FROM ProcedureWeek p WHERE p.id = :id"),
    @NamedQuery(name = "ProcedureWeek.findByLabel", query = "SELECT p FROM ProcedureWeek p WHERE p.label = :label"),
    @NamedQuery(name = "ProcedureWeek.findByNum", query = "SELECT p FROM ProcedureWeek p WHERE p.num = :num"),
    @NamedQuery(name = "ProcedureWeek.findByStage", query = "SELECT p FROM ProcedureWeek p WHERE p.stage = :stage"),
    @NamedQuery(name = "ProcedureWeek.findByWeight", query = "SELECT p FROM ProcedureWeek p WHERE p.weight = :weight")})
public class ProcedureWeek implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 100)
    private String label;
    @Column(length = 5)
    private String num;
    @Basic(optional = false)
    @Column(nullable = false, length = 2)
    private String stage;
    @Basic(optional = false)
    @Column(nullable = false)
    private short weight;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "week")
    private Collection<PipelineHasProcedures> pipelineHasProceduresCollection;

    public ProcedureWeek() {
    }

    public ProcedureWeek(Integer id) {
        this.id = id;
    }

    public ProcedureWeek(Integer id, String label, String stage, short weight) {
        this.id = id;
        this.label = label;
        this.stage = stage;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    @XmlTransient
    public Collection<PipelineHasProcedures> getPipelineHasProceduresCollection() {
        return pipelineHasProceduresCollection;
    }

    public void setPipelineHasProceduresCollection(Collection<PipelineHasProcedures> pipelineHasProceduresCollection) {
        this.pipelineHasProceduresCollection = pipelineHasProceduresCollection;
    }
}
