package com.fico.demo.dal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = Category.TABLE_NAME)
public class Category extends AbstractEntity {

  public static final String TABLE_NAME = "CATEGORY";

  private String name;
  private String description;

  public String getName() {
    return name;
  }

  public Category withName(String name) {
    this.name = name;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Category withDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public Category withId(Long id) {
    super.withId(id);
    return this;
  }

  @Override
  public Category withWhenCreated(Date whenCreated) {
    super.withWhenCreated(whenCreated);
    return this;
  }

  @Override
  public Category withWhenLastUpdated(Date whenLastUpdated) {
    super.withWhenLastUpdated(whenLastUpdated);
    return this;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Category other = (Category) obj;
    if (description == null) {
      if (other.description != null)
        return false;
    } else if (!description.equals(other.description))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
