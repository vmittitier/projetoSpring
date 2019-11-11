//package com.invillia.runner;
//
//import com.invillia.entities.Member;
//import com.invillia.entities.Team;
//import com.invillia.repository.MemberRepository;
//import com.invillia.repository.TeamRepository;
//import com.invillia.services.TeamService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//// classe para popular o banco no perfil de tester e sobrescrever o run da aplicacao
//@Configuration
//@Profile("test")
//public class Runner implements CommandLineRunner {
//
//    //injecao de dependencia de outro servico com autowired
//    @Autowired
//    private TeamRepository teamRepository;
//
//    @Autowired
//    private TeamService teamService;
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//    //tudo que estiver aqui sobe na hora que a app for iniciada
//    @Override
//    public void run(String... args) throws Exception {
//
//        Team t1 = new Team("incubadora");
//        Team t2 = new Team("itbox");
////        //repository que acessa os dados e passa a lista
//        teamRepository.saveAll(Arrays.asList(t1,t2));
////
//        Team team = teamRepository.findById(1L).get();
//        Team team2 = teamRepository.findById(2L).get();
////
//        //id gerado pelo banco
//        Member m1 = new Member("Joao",team);
//        Member m2 = new Member("Jose",team2);
//        memberRepository.saveAll(Arrays.asList(m1,m2));
//
//
//
//
//
//
//
//
//    }
//}
