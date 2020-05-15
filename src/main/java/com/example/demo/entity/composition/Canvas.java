package com.example.demo.entity.composition;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

//@SecondaryTable(name = "image")
@Entity
@Table(name = "canvas")
@Data
public class Canvas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PK")
    private Long pk;

    @Column(name = "square")
    private Integer square;

    @OneToOne(
	    cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
		    CascadeType.REMOVE },
	    optional = true)
    @JoinColumn(name = "image_PK", nullable = true/* , referencedColumnName = "PK", nullable = true, table = "image" */)
    private Image image;
}
