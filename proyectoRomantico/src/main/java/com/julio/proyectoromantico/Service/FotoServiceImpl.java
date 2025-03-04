package com.julio.proyectoromantico.Service;

import com.julio.proyectoromantico.Entity.Foto;
import com.julio.proyectoromantico.Repositories.FotoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FotoServiceImpl implements FotoService {

    private final FotoRepository fotoRepository;

    public FotoServiceImpl(FotoRepository fotoRepository) {
        this.fotoRepository = fotoRepository;
    }

    @Override
    public List<Foto> obtenerTodas() {
        return fotoRepository.findAll();
    }

    @Override
    public Optional<Foto> obtenerPorId(Long id) {
        return fotoRepository.findById(id);
    }

    @Override
    public Foto guardar(Foto foto) {
        return fotoRepository.save(foto);
    }

    @Override
    public void eliminar(Long id) {
        fotoRepository.deleteById(id);
    }
}