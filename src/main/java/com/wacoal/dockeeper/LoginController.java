/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacoal.dockeeper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author zraj
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @RequestMapping( method = RequestMethod.GET, value = "" )
    public ModelAndView index(){
       ModelAndView model = new ModelAndView();
       model.addObject("message", "Suppakiat");
        return model;
    }
}
