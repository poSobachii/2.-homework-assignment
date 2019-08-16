package Webshop.Repository;


import Webshop.Entities.Cups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CupsRepository extends JpaRepository<Cups, Long> {

}