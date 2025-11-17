package fr.formation.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name="collexion")
public class Collexion {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    @Column(length = 50,nullable = false)
    private String nom;

    @OneToMany (mappedBy="collexion")
	private List<Livre> livres;

    public Collexion() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collexion(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Collexion [nom=" + nom + "]";
    }

    

}
