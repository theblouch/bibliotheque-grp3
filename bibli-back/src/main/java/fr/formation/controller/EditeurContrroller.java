package fr.formation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.formation.model.Editeur;
import fr.formation.service.EditeurService;

@Controller
@RequestMapping("/editeur")
public class EditeurContrroller {
	
	@Autowired
	EditeurService ediserv;
	
	@GetMapping
	public String allEditeur(Model model) 
	{
		model.addAttribute("editeurs",ediserv.getAll());
		model.addAttribute("editeur",new Editeur());
		return "editeurs/editeurs";
	}
	
	
	/*@GetMapping("/filter")
	@ResponseBody
	public String allEditeurFilter(String searchLike) 
	{
		String reponse ="";
		List<Editeur> editeurs = ediserv.getAllByLibelleLike(searchLike);
		if(editeurs.isEmpty()) 
		{
			reponse+="<tr><td align='center' colspan='3'>Aucun resultat</td></tr>";
		}
		for(Editeur editeur : editeurs) 
		{
			reponse+="<tr>";
			reponse+="<td>"+editeur.getId()+"</td>";
			reponse+="<td>"+editeur.getNom()+"</td>";
			reponse+="<td>"+editeur.getPays()+"</td>";
			reponse+="<td>";
			reponse+="<a href='editeur/id="+editeur.getId()+"'><input type='button' value='Modifier'></a>";
			reponse+="<a href='editeur/delete/id="+editeur.getId()+"'><input type='button' value='Supprimer'></a>";
			reponse+="</td>";
			reponse+="</tr>";
		}
		return reponse;
	}*/
	
	@GetMapping("/{id}")
	public String ficheEditeur(@PathVariable Integer id,Model model) 
	{
		Editeur editeur = ediserv.getById(id);
		model.addAttribute("editeur",editeur);
		return "editeurs/updateEditeur";
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerEditeur(@PathVariable Integer id) 
	{
		ediserv.deleteById(id);
		return "redirect:/editeur";
	}
	
	@PostMapping
	public String ajoutEditeur(@ModelAttribute Editeur editeur) 
	{
		
		ediserv.create(editeur);
		return "redirect:/editeur";
	}
	
	@PostMapping("/{id}")
	public String modifierEditeur(@ModelAttribute Editeur editeur) 
	{
		
		ediserv.update(editeur);
		return "redirect:/editeur";
	}

}
