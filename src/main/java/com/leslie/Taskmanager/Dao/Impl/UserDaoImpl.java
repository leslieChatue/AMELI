package com.leslie.Taskmanager.Dao.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.leslie.Taskmanager.Dao.IUserDao;
import com.leslie.Taskmanager.Dto.UserMapping;
import com.leslie.Taskmanager.Dto.UserResponse;
import com.leslie.Taskmanager.Entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
@Repository
public class UserDaoImpl implements IUserDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<UserResponse> getUsersCriteria(String username) {
		// TODO Auto-generated method stub
		//On apple l'outil qui nous sert à créer des requetes criteria
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		//On crée la requete
		CriteriaQuery<User> query = cb.createQuery(User.class);
		//On spécifie quelle table correspond a la classe dans bd
		Root<User> root = query.from(User.class);
		//On applique le filtre
		 Predicate predicate = cb.equal(root.get("username"), username);
		//On applique l'action qu'on veut faire avec la requete : dans notre cas c'est un select
	        query.select(root)
	             .where(predicate);
		//On rajoute le tri 
		query.orderBy(cb.asc(root.get("username")));
		//On stocke le resultat dans la liste
		List<User> result =entityManager.createQuery(query).getResultList();
		//On converti la liste retournée en objet response
		List<UserResponse> liste = new ArrayList<>();
		liste = result.stream()//stream parcours la liste
				.map(UserMapping::userToDto)//map parcours chaque element de la liste
				.collect(Collectors.toList()); // et collect renvoie le tout sous forme de liste
		
		
		return liste;
	}

	@Override
	public Long countUser() {
		//On appele l'outil
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		//On cree la requete
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		//On spécifie la table dans la base
		Root<User> root = query.from(User.class);
		//On applique l'action qu'on veut faire avec la requete : dans notre cas c'est un select
		query.select(cb.count(root));
		//Retourne tout
		return entityManager.createQuery(query).getSingleResult();
	}



}
