package com.example.demo.entity.composition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import ua.cmathtutor.startledfrog.entity.composition.CompositeElement;

@Entity
@Table(name = "wick")
@Data
public class Wick implements CompositeElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "material")
    private String material;

    @JsonIgnore
    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
	    optional = true, mappedBy = "wick")
    private Candle candle;

    @JsonIgnore
    @Override
    public Object getCompositeParent() {
	return getCandle();
    }

}
