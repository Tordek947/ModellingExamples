package com.example.demo.entity.composition;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface CompositeElement {

    @JsonIgnore
    Object getCompositeParent();

    Long getPk();

    @JsonIgnore
    default boolean isNew() {
	return getPk() == null;
    }
}
