package net.idrok.springbootecomerce.Repository;

import net.idrok.springbootecomerce.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

    List<State> findByCustomerEmailOrderByDateCreatedDesc(@Param("code") String code);

}
