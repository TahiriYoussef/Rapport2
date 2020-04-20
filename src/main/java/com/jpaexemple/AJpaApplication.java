package com.jpaexemple;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpaexemple.dao.CategorieRepository;
import com.jpaexemple.dao.EntityRepositiry;
import com.jpaexemple.entities.Categorie;
import com.jpaexemple.entities.Produit;

@SpringBootApplication
public class AJpaApplication {

	public static void main(String[] args) {
	ApplicationContext ctx=SpringApplication.run(AJpaApplication.class, args);
	ProduitRepository produitDao=ctx.getBean(ProduitRepository.class);
	CategorieRepository categorieDao=ctx.getBean(CategorieRepository.class);
	
	Categorie c1=new Categorie("Ordinateurs ");
	Categorie c2=new Categorie("Imprimantes");
	Categorie c3=new Categorie("Mobile");
	categorieDao.save(c1);
	categorieDao.save(c2);
	categorieDao.save(c3);
	produitDao.save(new Produit("HP512",7500,10,c2));
	produitDao.save(new Produit("MX6300",10000,3,c2));
	produitDao.save(new Produit("LG45",890,15,c3));	

	
	List<Produit> produits=produitDao.findAll();
	for(Produit p : produits)
	{
		System.out.println("Designation:"+p.getDesignation());
		System.out.println("Prix:"+p.getPrix());
	}
	System.out.println("***************");	

	List<Produit> produitsDesignation=produitDao.produitsParMC("%H%");
	for(Produit m : produitsDesignation)
	{
		System.out.println("Designation:"+m.getDesignation());
		System.out.println("Prix:"+m.getPrix());
	}

	}

}
