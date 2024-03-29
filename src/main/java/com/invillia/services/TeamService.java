package com.invillia.services;

import com.invillia.entities.Team;
import com.invillia.repository.MemberRepository;
import com.invillia.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository repository;


    public void insertTeam(Team team) {
        repository.save(team);
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    public void deleteTeamById(Long id) {
        repository.deleteById(id);
    }

    public Optional<Team> findById(Long id) {
        Optional<Team> team = repository.findById(id);
        return team;
    }

    public void save(Team team) {
        repository.save(team);
    }

//    public List<Team> findAllById(Long id) {
//        return repository.fin(id);
//    }
}
