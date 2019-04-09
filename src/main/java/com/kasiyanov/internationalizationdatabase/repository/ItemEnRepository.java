package com.kasiyanov.internationalizationdatabase.repository;

import com.kasiyanov.internationalizationdatabase.entity.ItemEn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemEnRepository extends JpaRepository<ItemEn, Long> {

    Optional<ItemEn> findByCode(Integer code);
}
