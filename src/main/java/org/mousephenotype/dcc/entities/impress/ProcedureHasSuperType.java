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
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "procedure_has_super_type", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcedureHasSuperType.findAll", query = "SELECT p FROM ProcedureHasSuperType p"),
    @NamedQuery(name = "ProcedureHasSuperType.findByProcedureId", query = "SELECT p FROM ProcedureHasSuperType p WHERE p.procedureId = :procedureId"),
    @NamedQuery(name = "ProcedureHasSuperType.findByType", query = "SELECT p FROM ProcedureHasSuperType p WHERE p.type = :type")})
public class ProcedureHasSuperType implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "procedure_id", nullable = false)
    private Integer procedureId;
    @Basic(optional = false)
    @Column(nullable = false)
    private int type;

    public ProcedureHasSuperType() {
    }

    public ProcedureHasSuperType(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public ProcedureHasSuperType(Integer procedureId, int type) {
        this.procedureId = procedureId;
        this.type = type;
    }

    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
 
}
