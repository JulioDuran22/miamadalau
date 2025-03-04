package com.julio.proyectoromantico.Repositories;

import com.julio.proyectoromantico.Entity.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {
}
