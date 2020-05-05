package org.ubbcluj.LucrareLicentaOpera.controller;

import org.springframework.web.bind.annotation.*;
import org.ubbcluj.LucrareLicentaOpera.dto.YearlyCostDTO;
import org.ubbcluj.LucrareLicentaOpera.service.YearlyCostService;

import java.util.List;

@RestController
@RequestMapping("/yearlyCosts")
public class YearlyCostController {
    private final YearlyCostService yearlyCostService;

    public YearlyCostController(YearlyCostService yearlyCostService) {
        this.yearlyCostService = yearlyCostService;
    }


    @PostMapping(produces = "application/json")
    public List<YearlyCostDTO> saveYearlyCosts(@RequestBody List<YearlyCostDTO> yearlyCostDTOS){
        return this.yearlyCostService.saveAll(yearlyCostDTOS);
    }

    @GetMapping(produces = "application/json")
    public List<YearlyCostDTO> findYearlyCosts(){
        return this.yearlyCostService.findAll();
    }
}
