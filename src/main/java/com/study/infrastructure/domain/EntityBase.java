package com.study.infrastructure.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public abstract class EntityBase<Tid> extends ValueObjectBase {
	@JsonProperty("id")
	@SerializedName("id")
	public Tid id;

	public EntityBase() {
	}

	public EntityBase(Tid id) {
		this.id = id;
	}

	public Tid getId() {
		return id;
	}

	public void setId(Tid id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.getId().hashCode();
	}

	@Override
	public boolean equals(Object entity) {
		return entity != null && entity instanceof EntityBase<?>
				&& this.getId().equals(((EntityBase<?>) entity).getId());
	}

}
