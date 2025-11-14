package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import quest.model.Livre;

public interface IDAOModule extends JpaRepository<Livre, Integer> {

}