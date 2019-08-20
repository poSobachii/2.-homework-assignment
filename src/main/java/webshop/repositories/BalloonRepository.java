package webshop.repositories;


import webshop.entities.Balloons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalloonRepository extends JpaRepository<Balloons, Long> {

}