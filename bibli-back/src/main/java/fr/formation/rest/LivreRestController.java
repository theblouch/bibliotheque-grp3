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

import fr.formation.model.Livre;
import fr.formation.service.LivreService;

@RestController
@RequestMapping("/api/livre")
public class LivreRestController {

    @Autowired
    LivreService livreSrv;

    @GetMapping
    public List<Livre> allLivres() {
        return livreSrv.getAll();
    }

    @GetMapping("/{id}")
    public Livre ficheLivre(@PathVariable Integer id, Livre livre) {
        return livreSrv.getById(id);
    }

    @PostMapping
    public Livre ajoutLivre(@RequestBody Livre livre) {
        return livreSrv.create(livre);
    }

    @PutMapping("/{id}")
    public Livre modifierLivre(@PathVariable Integer id, @RequestBody Livre livre) {
        livre.setId(id);
        return (Livre) livreSrv.update(livre);
    }

    @DeleteMapping("/{id}")
    public void supprimerLivre(@PathVariable Integer id) {
        livreSrv.deleteById(id);
    }

}
