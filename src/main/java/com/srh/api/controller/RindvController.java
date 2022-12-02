package com.srh.api.controller;

import com.srh.api.service.ProjectService;
import com.srh.api.service.RindvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.srh.api.dto.resource.ProjectDto.convert;

@RestController
@RequestMapping("/rindvs")
public class RindvController {

    @Autowired
    private RindvService rindvService;

    @Autowired
    private ProjectService projectService;


    @GetMapping
    public ArrayList<Double> getRindv(Integer id) {
        ArrayList<Double> rindv = rindvService.getRindv(id);
        return rindv;
    }

    @GetMapping("/{id}")
    public Double find(@PathVariable Integer id) {
        ArrayList<Double> rindv = rindvService.getRindv(id);
        return rindv.get(id-1);
    }

}
