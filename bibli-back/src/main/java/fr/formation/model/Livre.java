package fr.formation.model;

@Entity
@Table(name = "Livre")
public class Livre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200, nullable = false)
    private String titre;

    @Column(length = 1000)
    private String résumé;

    @ManyToOne
    private Collexion collexion;

    @Column(length = 5)
    private int année;

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

    public String getRésumé() {
        return this.résumé;
    }

    public void setRésumé(String résumé) {
        this.résumé = résumé;
    }

    public collexion getCollexion() {
        return this.collexion;
    }

    public void setCollexion(Collexion collexion) {
        this.collexion = collexion;
    }

    public int getAnnée() {
        return this.année;
    }

    public void setAnnée(int année) {
        this.année = année;
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

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", titre='" + getTitre() + "'" +
                ", résumé='" + getRésumé() + "'" +
                ", collexion='" + getCollexion() + "'" +
                ", année='" + getAnnée() + "'" +
                ", auteur='" + getAuteur() + "'" +
                ", editeur='" + getEditeur() + "'" +
                "}";
    }

}
