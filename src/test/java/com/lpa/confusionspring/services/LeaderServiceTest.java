package com.lpa.confusionspring.services;

import com.lpa.confusionspring.api.v1.mapper.LeaderMapper;
import com.lpa.confusionspring.domain.Leader;
import com.lpa.confusionspring.repositories.reactive.LeaderReactiveRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LeaderServiceTest {
    private LeaderService leaderService;

    @Mock
    private LeaderReactiveRepository leaderReactiveRepository;

    private LeaderMapper leaderMapper = LeaderMapper.INSTANCE;

    @Before
    public void setUp() throws Exception {
        // tell mockito to give me a mock recipe repository
        MockitoAnnotations.initMocks(this);

        leaderService = new LeaderServiceImpl(leaderReactiveRepository);
    }

    @Test
    public void getLeaders() throws Exception {
        Leader leader = new Leader();

        when(leaderService.getLeaders()).thenReturn(Flux.just(leader));

        List<Leader> leaders = leaderService.getLeaders().collectList().block();

        assertEquals(1, leaders.size());
        verify(leaderReactiveRepository, times(1)).findAll();
    }

    @Test
    public void findByFeatured() throws Exception {
        Leader leader1 = new Leader();
        leader1.setFeatured(true);
        Leader leader2 = new Leader();
        leader2.setFeatured(true);

        when(leaderService.findByFeatured(anyBoolean())).thenReturn(Flux.fromIterable(Arrays.asList(leader1, leader2)));

        List<Leader> leaders = leaderService.findByFeatured(true).collectList().block();

        assertEquals(2, leaders.size());
    }

    @Test
    public void findByName() throws Exception {
        Leader leader = new Leader();
        leader.setId("1");
        leader.setName("Test");

        when(leaderReactiveRepository.findByName(anyString())).thenReturn(Flux.just(leader));

        List<Leader> leaders = leaderService.findByName("Test").collectList().block();

        assertEquals(1, leaders.size());
        assertEquals("Test", leaders.get(0).getName());
        verify(leaderReactiveRepository, times(1)).findByName(anyString());
        verify(leaderReactiveRepository, never()).findAll();
    }

    @Test
    public void findById() throws Exception {
        Leader leader = new Leader();
        leader.setId("1");

        when(leaderReactiveRepository.findById(anyString())).thenReturn(Mono.just(leader));

        Leader leaderReturned = leaderService.findById("1").block();

        assertNotNull("Null recipe returned", leaderReturned);
        verify(leaderReactiveRepository, times(1)).findById(anyString());
        verify(leaderReactiveRepository, never()).findAll();
    }

}