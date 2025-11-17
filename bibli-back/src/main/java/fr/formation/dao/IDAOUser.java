package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.dto.response.UtilisateurProjectionResponse;
import fr.formation.model.User;


public interface IDAOUser extends JpaRepository<User, Integer> {
    public Optional<User> findByUsername(String username);

    // @Query("select u from Utilisateur u")
    public List<UtilisateurProjectionResponse> findAllProjectedBy();

    public <T> List<T> findAllProjectedBy(Class<T> clz);
}
