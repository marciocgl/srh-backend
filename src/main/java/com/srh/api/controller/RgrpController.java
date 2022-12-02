package com.srh.api.controller;

import com.srh.api.service.RgrpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/rgrps")
public class RgrpController {
    @Autowired
    private RgrpService rgrpService;

    @GetMapping
    public ArrayList<Double> getRgrp(Integer id, ArrayList<Double> grupo1, ArrayList<Double> grupo2) {
        ArrayList<Double> rgrp = rgrpService.getRgrp(id, grupo1, grupo2);
        return rgrp;
    }

    @GetMapping("/{id}")
    public Double find(@PathVariable Integer id, ArrayList<Double> grupo1, ArrayList<Double> grupo2) {
        ArrayList<Double> rgrp = rgrpService.getRgrp(id, grupo1, grupo2);
        return rgrp.get(id-1);
    }

}
