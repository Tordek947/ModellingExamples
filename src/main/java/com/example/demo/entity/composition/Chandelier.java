package com.example.demo.entity.composition;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "chandelier")
@Data
public class Chandelier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "color", nullable = true)
    private String color;

    @OneToMany(
	    cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
		    CascadeType.REMOVE },
	    mappedBy = "chandelier", fetch = FetchType.EAGER)
    private Set<Bulb> bulbs;
}
