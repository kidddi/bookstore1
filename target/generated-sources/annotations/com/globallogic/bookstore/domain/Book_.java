package com.globallogic.bookstore.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, Integer> price;
	public static volatile SingularAttribute<Book, String> name;
	public static volatile SingularAttribute<Book, Integer> timesBought;
	public static volatile SingularAttribute<Book, Long> id;

}

