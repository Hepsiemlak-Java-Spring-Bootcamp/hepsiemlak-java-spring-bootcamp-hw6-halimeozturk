package com.example.emlak_burada.repository;



import com.example.emlak_burada.model.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdvertRepository extends JpaRepository<Advert,Long> {
    Optional<Advert>  findByAdvertNo(Long advertNo);

}
