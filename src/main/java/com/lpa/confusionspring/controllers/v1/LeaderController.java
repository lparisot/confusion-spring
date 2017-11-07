package com.lpa.confusionspring.controllers.v1;

import com.lpa.confusionspring.api.v1.model.LeaderDTO;
import com.lpa.confusionspring.services.LeaderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(LeaderController.BASE_URL)
public class LeaderController {
    public static final String BASE_URL = "/leaders";

    private final LeaderService leaderService;

    public LeaderController(LeaderService leaderService) {
        this.leaderService = leaderService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<LeaderDTO> getAllLeaders(
            @RequestParam(value = "featured", required = false) Boolean featured,
            @RequestParam(value = "name", required = false) String name) {
        if(featured != null) {
            return leaderService.findDTOByFeatured(featured);
        }
        if(name != null) {
            return leaderService.findDTOByName(name);
        }
        return leaderService.getLeadersDTO();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<LeaderDTO> getLeader(@PathVariable String id) {
        return leaderService.findDTOById(id);
    }

}
