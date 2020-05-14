package com.example.demo.entity.composition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bulb")
@Data
public class Bulb implements CompositeElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "power", nullable = false)
    private Integer power;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
	    optional = true, fetch = FetchType.LAZY)
    @JoinTable(name = "chandelier_has_bulb",
	    joinColumns = @JoinColumn(nullable = false, unique = false, name = "chandelier_PK"),
	    inverseJoinColumns = @JoinColumn(nullable = false, unique = true, name = "bulb_PK"))
    private Chandelier chandelier;

    @Override
    public Object getCompositeParent() {
	return getChandelier();
    }
}
