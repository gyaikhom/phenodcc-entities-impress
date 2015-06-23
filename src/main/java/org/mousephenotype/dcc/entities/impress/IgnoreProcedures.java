/*
 * Copyright 2015 Medical Research Council Harwell.
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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gagarine Yaikhom <g.yaikhom@har.mrc.ac.uk>
 */
@Entity
@Table(name = "ignore_procedures", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IgnoreProcedures.findAll", query = "SELECT i FROM IgnoreProcedures i"),
    @NamedQuery(name = "IgnoreProcedures.findByIgnoreProceduresId", query = "SELECT i FROM IgnoreProcedures i WHERE i.ignoreProceduresId = :ignoreProceduresId"),
    @NamedQuery(name = "IgnoreProcedures.findByProcedureId", query = "SELECT i FROM IgnoreProcedures i WHERE i.procedureId = :procedureId")})
public class IgnoreProcedures implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ignore_procedures_id", nullable = false)
    private Integer ignoreProceduresId;
    @Column(name = "procedure_id")
    private Integer procedureId;

    public IgnoreProcedures() {
    }

    public IgnoreProcedures(Integer ignoreProceduresId) {
        this.ignoreProceduresId = ignoreProceduresId;
    }

    public Integer getIgnoreProceduresId() {
        return ignoreProceduresId;
    }

    public void setIgnoreProceduresId(Integer ignoreProceduresId) {
        this.ignoreProceduresId = ignoreProceduresId;
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }
    
}
