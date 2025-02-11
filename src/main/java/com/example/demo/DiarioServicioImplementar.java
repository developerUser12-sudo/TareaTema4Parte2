package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiarioServicioImplementar implements DiarioServicio{
	@Autowired
    private DiarioRepository repositorio;
	
	@Override
	public List<Nota> listarNota(){
		return repositorio.findAll();
	}
	@Override
    public Nota guardarNota(Nota nota) {
        return repositorio.save(nota);
    }
}
