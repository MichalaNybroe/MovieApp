package com.example.demomedtine.controllers;

import com.example.demomedtine.repositories.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;

@Controller
public class DBManagerController {

    @GetMapping("/check")
    @ResponseBody
    public String checkConnection() {
        Connection c = DBManager.getConnection();
        if (c != null) {
            return "Yay - I made it to the DB!";
        } else {
            return "Noooo, there is no connection here!";
        }
    }
}