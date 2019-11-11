package com.invillia.services;

import com.invillia.entities.Member;
import com.invillia.repository.MemberRepository;
import com.invillia.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository repository;


   public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

    public Optional<Member> findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }

    public void save(Member member) {
        memberRepository.save(member);
    }


    public List<Member> findByTeamId(Long id) {
       return memberRepository.findByTeamTeamId(id);
    }
}
