package com.example.demo;

import java.util.List;

public interface DiarioServicio {
	public List<Nota> listarNota();
	public Nota guardarNota(Nota nota);
}
