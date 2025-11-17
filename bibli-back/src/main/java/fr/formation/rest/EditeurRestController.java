package fr.formation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Editeur;
import fr.formation.service.EditeurService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/editeur")
public class EditeurRestController {

	@Autowired
	EditeurService editeurSrv;

	@GetMapping
	public List<Editeur> allEditeurs() {
		return editeurSrv.getAll();
	}

	@GetMapping("/{id}")
	public Editeur ficheEditeur(@PathVariable Integer id) {
		return editeurSrv.getById(id);
	}

	@PostMapping
	public Editeur ajouterEditeur(@RequestBody Editeur editeur) {
		return (Editeur) editeurSrv.create(editeur);
	}

	@PutMapping("/{id}")
	public Editeur modifierEditeur(@PathVariable Integer id, @RequestBody Editeur editeur) {
		editeur.setId(id);
		return (Editeur) editeurSrv.update(editeur);
	}

	@DeleteMapping("/{id}")
	public void deleteEditeur(@PathVariable Integer id) {
		editeurSrv.deleteById(id);
	}
}
