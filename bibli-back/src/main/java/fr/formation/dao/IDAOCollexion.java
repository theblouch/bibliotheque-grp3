package fr.formation.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Collexion;

public interface IDAOCollexion extends JpaRepository<Collexion, Integer>{

    public List<Collexion> findByNomContaining(String recherche);

    @Query("SELECT c from Collexion c where c.nom like :recherche")
	public List<Collexion> findByContientLeNom(@Param("recherche") String recherche);

}
