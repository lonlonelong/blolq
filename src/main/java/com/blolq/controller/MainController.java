package com.blolq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by michael on 2016/8/9.
 */
@Controller
public class MainController
{
    @RequestMapping(value="/",method= RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/note",method = RequestMethod.GET)
    public String showNote(String id){
        return "success";
    }


}
