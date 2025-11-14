package fr.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Auteur;
import fr.formation.service.AuteurService;

@RestController
@RequestMapping("/api/auteur")
public class AuteurRestController {

    @Autowired
    AuteurService auteurSrv;

    @GetMapping
    public List<Auteur> allAuteurs() {
        return auteurSrv.getAll();
    }

    @GetMapping("/{id}")
    public Auteur ficheAuteur(@PathVariable Integer id, Auteur auteur) {
        return auteurSrv.getById(id);
    }

    @PostMapping
    public Auteur ajoutAuteur(@RequestBody Auteur auteur) {
        return auteurSrv.create(auteur);
    }

    @PutMapping("/{id}")
    public Auteur modifierAuteur(@PathVariable Integer id, @RequestBody Auteur auteur) {
        auteur.setId(id);
        return (Auteur) auteurSrv.update(auteur);
    }

    @DeleteMapping("/{id}")
    public void supprimerAuteur(@PathVariable Integer id) {
        auteurSrv.deleteById(id);
    }
}
