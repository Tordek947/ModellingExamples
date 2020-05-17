package com.example.demo.entity.composition;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ua.cmathtutor.startledfrog.entity.composition.CompositeElement;

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

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @RestResource(exported = false)
    @JsonIgnore
    @ManyToOne(optional = true)
    @Transient
//    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH },
//	    optional = true, fetch = FetchType.EAGER)
//    @JoinColumn(name = "chandelier_PK", nullable = true, table = "bulb")
    private Chandelier chandelier;

    @JsonIgnore
    @Override
    public Object getCompositeParent() {
	return getChandelier();
    }
}
