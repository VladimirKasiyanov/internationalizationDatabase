package com.kasiyanov.internationalizationdatabase.repository;

import com.kasiyanov.internationalizationdatabase.entity.ItemRu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRuRepository extends JpaRepository<ItemRu, Long> {

    Optional<ItemRu> findByCode(Integer code);
}
