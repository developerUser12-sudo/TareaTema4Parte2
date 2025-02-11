package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class DiarioController {

	
	@Autowired
    private DiarioServicio servicio;

	@RequestMapping("/index")
	public String bienvenida(HttpServletRequest request, HttpServletResponse response, Model model) {

		String fecha = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				fecha = cookie.getValue();
				break;

			}
		}

		if (fecha != null) {
			model.addAttribute("fecha", fecha);
		}

		String timeStamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
		Cookie cookieFecha = new Cookie("fecha", timeStamp);
		cookieFecha.setMaxAge(200000);
		cookieFecha.setPath("/");
		response.addCookie(cookieFecha);
		model.addAttribute("notas",servicio.listarNota());
		return "index";
	}
	@GetMapping("/new")
    public String formulario(Model modelo) {
        Nota nota = new Nota();
        modelo.addAttribute("nota", nota);
        return "new";
    }
	@PostMapping("/index")
	public String guardarNota(@ModelAttribute("nota") Nota nota) {
		servicio.guardarNota(nota);
		return "redirect:/index";
	}


	
}
