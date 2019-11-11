package com.invillia.repository;

import com.invillia.entities.Member;
import com.invillia.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findAllById(Long id);

    List<Member> findByTeamTeamId(Long id);

}

