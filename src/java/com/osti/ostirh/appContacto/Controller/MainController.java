/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appContacto.Controller;

import com.osti.ostirh.appContacto.Modelo.Contacto;
import com.osti.ostirh.appContacto.Service.EmailManagerImpl;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author len
 */
@Controller
//@RequestMapping("/mct")
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String inicio(HttpServletResponse response) throws IOException {
        return "index";
    }

    @RequestMapping("/enviarEmail")
    public String enviarEmail(@RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "name", required = true) String nome,
            @RequestParam(value = "phone", required = true) long telefone,
            @RequestParam(value = "message", required = true) String mesagem,
            @RequestParam(value = "codigo_seg", required = false) String codigo, ModelMap mod) {

        Contacto contacto = new Contacto(nome, email, mesagem, telefone);

        if (new EmailManagerImpl().EnviarEmail(contacto)) {
            mod.addAttribute("confirmacao", "Email enviado com Sucesso!");
            mod.addAttribute("contacto", contacto);
        } else {
            mod.addAttribute("confirmacao", "Erro ao enviar Email!");
            return "erro";
        }

        return "index";
    }

}
