package com.srh.api.controller;
import com.srh.api.dto.resource.ProjectDto;
import com.srh.api.hypermedia.ProjectModelAssembler;
import com.srh.api.model.Project;
import com.srh.api.service.ProjectService;
import com.srh.api.service.RpolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/rpols")
public class RpolController {
    @Autowired
    private RpolService rpolService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectModelAssembler projectModelAssembler;

    @Autowired
    private PagedResourcesAssembler<ProjectDto> pagedResourcesAssembler;

    @GetMapping
    public ArrayList<Double> getRpol(Integer id) {
        ArrayList<Double> rpol = rpolService.getRpol(id);
        return rpol;
    }


    @GetMapping("/{id}")
    public Integer find(@PathVariable Integer id) {
        Project project = projectService.find(id);
        return project.getId();
    }

    @GetMapping("/{id}/{id}")
    public Double findADouble(@PathVariable Integer id) {
        ArrayList<Double> rpol = rpolService.getRpol(id);
        return rpol.get(id-1) ;
    }

}
