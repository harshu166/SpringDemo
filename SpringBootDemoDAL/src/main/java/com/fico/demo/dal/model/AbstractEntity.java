package com.fico.demo.dal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class AbstractEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Date whenCreated;
  private Date whenLastUpdated;

  public Long getId() {
    return id;
  }

  AbstractEntity withId(Long id) {
    this.id = id;
    return this;
  }

  public Date getWhenCreated() {
    return whenCreated;
  }

  public AbstractEntity withWhenCreated(Date whenCreated) {
    this.whenCreated = whenCreated;
    return this;
  }

  public Date getWhenLastUpdated() {
    return whenLastUpdated;
  }

  public AbstractEntity withWhenLastUpdated(Date whenLastUpdated) {
    this.whenLastUpdated = whenLastUpdated;
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((whenCreated == null) ? 0 : whenCreated.hashCode());
    result = prime * result + ((whenLastUpdated == null) ? 0 : whenLastUpdated.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AbstractEntity other = (AbstractEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (whenCreated == null) {
      if (other.whenCreated != null)
        return false;
    } else if (!whenCreated.equals(other.whenCreated))
      return false;
    if (whenLastUpdated == null) {
      if (other.whenLastUpdated != null)
        return false;
    } else if (!whenLastUpdated.equals(other.whenLastUpdated))
      return false;
    return true;
  }

}
