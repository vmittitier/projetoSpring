package com.invillia.services;

import com.invillia.entities.Member;
import com.invillia.entities.Team;
import com.invillia.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public List<Team> findAll(){
        return repository.findAll();
    }

}
