package org.ubbcluj.LucrareLicentaOpera.controller;

import org.springframework.web.bind.annotation.*;
import org.ubbcluj.LucrareLicentaOpera.dto.ShowDTO;
import org.ubbcluj.LucrareLicentaOpera.service.ShowService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/shows")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @PostMapping(produces = "application/json")
    public List<ShowDTO> saveYearlyCosts(@RequestBody List<ShowDTO> yearlyCostDTOS){
        return this.showService.saveAll(yearlyCostDTOS);
    }

    @GetMapping(produces = "application/json")
    public List<ShowDTO> findYearlyCosts(){
        return this.showService.findAll();
    }

}
