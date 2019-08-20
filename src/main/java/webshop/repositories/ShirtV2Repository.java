package webshop.repositories;


import webshop.entities.TShirtsv2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShirtV2Repository extends JpaRepository<TShirtsv2, Long> {

}