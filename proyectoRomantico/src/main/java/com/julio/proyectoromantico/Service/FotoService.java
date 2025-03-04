package com.julio.proyectoromantico.Service;

import com.julio.proyectoromantico.Entity.Foto;
import java.util.List;
import java.util.Optional;

public interface FotoService {
    List<Foto> obtenerTodas();
    Optional<Foto> obtenerPorId(Long id);
    Foto guardar(Foto foto);
    void eliminar(Long id);
}