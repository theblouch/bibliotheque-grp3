package fr.formation.dto.response;

import org.springframework.beans.BeanUtils;

import fr.formation.model.User;

public class UtilisateurResponse {
    private int id;
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static UtilisateurResponse convert(User user) {
        UtilisateurResponse resp = new UtilisateurResponse();

        BeanUtils.copyProperties(user, resp);

        return resp;
    }
}
