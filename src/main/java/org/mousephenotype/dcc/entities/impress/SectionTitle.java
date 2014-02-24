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
@Table(name = "section_title", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SectionTitle.findAll", query = "SELECT s FROM SectionTitle s"),
    @NamedQuery(name = "SectionTitle.findById", query = "SELECT s FROM SectionTitle s WHERE s.id = :id"),
    @NamedQuery(name = "SectionTitle.findByTitle", query = "SELECT s FROM SectionTitle s WHERE s.title = :title"),
    @NamedQuery(name = "SectionTitle.findByCentreId", query = "SELECT s FROM SectionTitle s WHERE s.centreId = :centreId"),
    @NamedQuery(name = "SectionTitle.findByWeight", query = "SELECT s FROM SectionTitle s WHERE s.weight = :weight")})
public class SectionTitle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 255)
    private String title;
    @Column(name = "centre_id")
    private Integer centreId;
    private Integer weight;
    @OneToMany(mappedBy = "sectionTitleId")
    private Collection<Section> sectionCollection;

    public SectionTitle() {
    }

    public SectionTitle(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection() {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection) {
        this.sectionCollection = sectionCollection;
    }
}
