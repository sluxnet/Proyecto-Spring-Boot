package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.PaisModel;;
@Repository
public interface PaisRepository extends JpaRepository<PaisModel,Long>{
}
