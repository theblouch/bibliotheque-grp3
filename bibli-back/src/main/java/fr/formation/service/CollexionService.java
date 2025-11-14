package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.dao.IDAOCollexion;
import fr.formation.model.Collexion;

public class CollexionService {

    @Autowired
    IDAOCollexion daoCollexion;
    
    public Collexion getById(Integer id) throws RuntimeException
	{
		if(id==null) 
		{
			throw new RuntimeException("L'id d'une collexion ne peut pas etre null");	
		}
		Optional <Collexion> opt = daoCollexion.findById(id);
		if(opt.isEmpty()) {return null;}
		else {return opt.get();}
	}

	public List<Collexion> getAll()
	{
		return daoCollexion.findAll();
	}
	
	public List<Collexion> getAllByLibelleLike(String recherche)
	{
		return daoCollexion.findByNomContaining(recherche);
	}

	public Collexion create(Collexion collexion) 
	{
		return daoCollexion.save(collexion);
	}

	public Collexion update(Collexion collexion) 
	{
		return daoCollexion.save(collexion);
	}

	public void deleteById(Integer id) 
	{
		daoCollexion.deleteById(id);
	}

	public void delete(Collexion collexion)
	{
		daoCollexion.delete(collexion);
	}
	

}
