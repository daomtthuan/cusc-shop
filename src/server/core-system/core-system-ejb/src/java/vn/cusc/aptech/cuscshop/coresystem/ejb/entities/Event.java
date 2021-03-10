/*
 * The MIT License
 *
 * Copyright 2021 Daomtthuan.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package vn.cusc.aptech.cuscshop.coresystem.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Event entity
 *
 * @author Daomtthuan
 * @version 1.0
 */
@Entity
@Table(name = "event", catalog = "cusc_shop", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
  @NamedQuery(name = "Event.findById", query = "SELECT e FROM Event e WHERE e.id = :id"),
  @NamedQuery(name = "Event.findByTitle", query = "SELECT e FROM Event e WHERE e.title = :title"),
  @NamedQuery(name = "Event.findByPost", query = "SELECT e FROM Event e WHERE e.post = :post"),
  @NamedQuery(name = "Event.findByState", query = "SELECT e FROM Event e WHERE e.state = :state")})
public class Event implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "title")
  private String title;
  @Basic(optional = false)
  @NotNull
  @Column(name = "post")
  @Temporal(TemporalType.DATE)
  private Date post;
  @Basic(optional = false)
  @NotNull
  @Column(name = "state")
  private boolean state;
  @JoinColumn(name = "id_account", referencedColumnName = "id")
  @ManyToOne(optional = false)
  private Account idAccount;

  public Event() {
  }

  public Event(Integer id) {
    this.id = id;
  }

  public Event(Integer id, String title, Date post, boolean state) {
    this.id = id;
    this.title = title;
    this.post = post;
    this.state = state;
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

  public Date getPost() {
    return post;
  }

  public void setPost(Date post) {
    this.post = post;
  }

  public boolean getState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public Account getIdAccount() {
    return idAccount;
  }

  public void setIdAccount(Account idAccount) {
    this.idAccount = idAccount;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Event)) {
      return false;
    }
    Event other = (Event) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "vn.cusc.aptech.cuscshop.coresystem.ejb.entities.Event[ id=" + id + " ]";
  }

}
