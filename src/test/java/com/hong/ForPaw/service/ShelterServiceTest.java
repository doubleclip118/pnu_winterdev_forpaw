package com.hong.ForPaw.service;

import com.hong.ForPaw.domain.Shelter.Shelter;
import com.hong.ForPaw.repository.ShelterRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ShelterServiceTest {

    @Autowired
    public ShelterRepository shelterRepository;
    @Autowired
    public ShelterService shelterService;

    @Test
    void loadShelterData() throws IOException, InterruptedException {
        // given
        shelterService.loadShelterData();;
        // when

        // then
        Optional<Shelter> shelter = shelterRepository.findById(1L);
        System.out.println(shelter);
    }
}