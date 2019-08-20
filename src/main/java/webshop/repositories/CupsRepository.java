package webshop.repositories;


import webshop.entities.Cups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupsRepository extends JpaRepository<Cups, Long> {

}