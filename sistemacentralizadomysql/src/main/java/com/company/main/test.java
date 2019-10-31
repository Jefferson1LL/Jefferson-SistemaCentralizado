/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.main;

import com.company.session.ProductosJpaController;
import com.mycompany.entidades.Productos;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aplicaciones D
 */
public class test {
 
    
    
    public static void main(String[] args){
        EntityManagerFactory fact = Persistence.createEntityManagerFactory("practicabdd");
        ProductosJpaController pjc = new ProductosJpaController(fact);

        Productos p = new Productos();
        p.setNombre("pan");
        Double dl  = 10.35;
        BigDecimal bdl = BigDecimal.valueOf(dl.doubleValue());
        p.setPrecio(bdl);
        
        try{
            pjc.create(p);
            
        }catch(Exception ex){
            Logger.getLogger(test.class.getName()).log(Level.ALL.SEVERE,null, ex);
        }
        
}
}
