package fr.formation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IDAOAuteur;
import fr.formation.model.Auteur;

@Service
public class AuteurService {

    @Autowired
    IDAOAuteur daoAuteur;

    public List<Auteur> getAll() {
        return daoAuteur.findAll();
    }

    public Auteur getById(Integer id) throws RuntimeException {
        if (id == null) {
            throw new RuntimeException("L'id ne peut pas être null");
        }
        Optional<Auteur> opt = daoAuteur.findById(id);
        if (opt.isEmpty()) {
            return null;
        } else {
            return opt.get();
        }
    }

    public Auteur create(Auteur auteur) {
        return daoAuteur.save(auteur);
    }

    public Auteur update(Auteur auteur) {
        return daoAuteur.save(auteur);
    }

    public void deleteById(Integer id) {
        daoAuteur.deleteById(id);
    }

    public void delete(Auteur auteur) {
        daoAuteur.delete(auteur);
    }
}
