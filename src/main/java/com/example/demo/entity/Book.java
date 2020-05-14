package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "number_of_pages", nullable = false)
    private Integer numberOfPages;
    @Column(name = "name", nullable = false, unique = true)
    private String name;

//    @RestResource(exported = false)
    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "book_2_author",
	    joinColumns = @JoinColumn(nullable = false, unique = false, name = "book_id"),
	    inverseJoinColumns = @JoinColumn(nullable = false, unique = false, name = "author_id"))
    private Set<Author> authors;
}
