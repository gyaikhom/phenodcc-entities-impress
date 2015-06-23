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
import javax.persistence.Lob;
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
@Table(name = "section", catalog = "impress", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Section.findAll", query = "SELECT s FROM Section s"),
    @NamedQuery(name = "Section.findBySectionId", query = "SELECT s FROM Section s WHERE s.sectionId = :sectionId"),
    @NamedQuery(name = "Section.findByWeight", query = "SELECT s FROM Section s WHERE s.weight = :weight"),
    @NamedQuery(name = "Section.findByLevel", query = "SELECT s FROM Section s WHERE s.level = :level"),
    @NamedQuery(name = "Section.findByLevelText", query = "SELECT s FROM Section s WHERE s.levelText = :levelText"),
    @NamedQuery(name = "Section.findByMajorVersion", query = "SELECT s FROM Section s WHERE s.majorVersion = :majorVersion"),
    @NamedQuery(name = "Section.findByMinorVersion", query = "SELECT s FROM Section s WHERE s.minorVersion = :minorVersion"),
    @NamedQuery(name = "Section.findByTimeModified", query = "SELECT s FROM Section s WHERE s.timeModified = :timeModified"),
    @NamedQuery(name = "Section.findByUserId", query = "SELECT s FROM Section s WHERE s.userId = :userId"),
    @NamedQuery(name = "Section.findByDeleted", query = "SELECT s FROM Section s WHERE s.deleted = :deleted"),
    @NamedQuery(name = "Section.findBySopId", query = "SELECT s FROM Section s WHERE s.sopId = :sopId"),
    @NamedQuery(name = "Section.findBySectionTitleId", query = "SELECT s FROM Section s WHERE s.sectionTitleId = :sectionTitleId")})
public class Section implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "section_id", nullable = false)
    private Integer sectionId;
    @Lob
    @Column(name = "section_text", length = 65535)
    private String sectionText;
    private Integer weight;
    private Integer level;
    @Column(name = "level_text", length = 255)
    private String levelText;
    @Basic(optional = false)
    @Column(name = "major_version", nullable = false)
    private int majorVersion;
    @Basic(optional = false)
    @Column(name = "minor_version", nullable = false)
    private int minorVersion;
    @Column(name = "time_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeModified;
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(nullable = false)
    private boolean deleted;
    @JoinColumn(name = "sop_id", referencedColumnName = "sop_id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private Sop sopId;
    @JoinColumn(name = "section_title_id", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    private SectionTitle sectionTitleId;

    public Section() {
    }

    public Section(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Section(
            Integer sectionId,
            int majorVersion,
            int minorVersion,
            boolean deleted) {
        this.sectionId = sectionId;
        this.majorVersion = majorVersion;
        this.minorVersion = minorVersion;
        this.deleted = deleted;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionText() {
        return sectionText;
    }

    public void setSectionText(String sectionText) {
        this.sectionText = sectionText;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelText() {
        return levelText;
    }

    public void setLevelText(String levelText) {
        this.levelText = levelText;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(int majorVersion) {
        this.majorVersion = majorVersion;
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public void setMinorVersion(int minorVersion) {
        this.minorVersion = minorVersion;
    }

    public Date getTimeModified() {
        return timeModified;
    }

    public void setTimeModified(Date timeModified) {
        this.timeModified = timeModified;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Sop getSopId() {
        return sopId;
    }

    public void setSopId(Sop sopId) {
        this.sopId = sopId;
    }

    public SectionTitle getSectionTitleId() {
        return sectionTitleId;
    }

    public void setSectionTitleId(SectionTitle sectionTitleId) {
        this.sectionTitleId = sectionTitleId;
    }
}
