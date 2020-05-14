package com.example.demo.entity.composition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import lombok.Data;

@Entity
@Table(name = "head")
@Data
public class Head implements CompositeElement {

    @Id
    @Column(name = "human_PK")
    private Long pk;

    @Column(name = "has_hair")
    private Boolean hasHair;

    @RestResource(exported = true)
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
	    optional = false)
    @JoinColumn(name = "human_PK", nullable = false)
    private Human human;

    @Override
    public Human getCompositeParent() {
	return getHuman();
    }
}
