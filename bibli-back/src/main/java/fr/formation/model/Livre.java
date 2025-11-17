package fr.formation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String titre;

    @Column(length = 1000)
    private String resume;

    @ManyToOne
    private Collexion collexion;

    @Column(length = 5)
    private int annee;

    @ManyToOne
    private Auteur auteur;

    @ManyToOne
    private Editeur editeur;

    public Livre() {
    }

    public String getTitre() {
        return this.titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return this.resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Collexion getCollexion() {
        return this.collexion;
    }

    public void setCollexion(Collexion collexion) {
        this.collexion = collexion;
    }

    public int getAnnee() {
        return this.annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Auteur getAuteur() {
        return this.auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public Editeur getEditeur() {
        return this.editeur;
    }

    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", titre='" + getTitre() + "'" +
                ", resume='" + getResume() + "'" +
                ", collexion='" + getCollexion() + "'" +
                ", annee='" + getAnnee() + "'" +
                ", auteur='" + getAuteur() + "'" +
                ", editeur='" + getEditeur() + "'" +
                "}";
    }

}
