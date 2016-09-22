/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.osti.ostirh.appContacto.Service;

import com.osti.ostirh.appContacto.Modelo.Contacto;

/**
 *
 * @author len
 */
public interface EmailManager {
    public boolean EnviarEmail(Contacto contacto);
}
