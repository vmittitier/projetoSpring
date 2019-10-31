package com.invillia.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @Column(nullable = false)
    private String teamName;

    @JoinColumn
    @OneToMany(cascade = CascadeType.ALL)
    private static List<Member> listMembers;

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDate updatedAt;

    public Team(){}

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public List<Member> getListMembers() {
        return listMembers;
    }

    public static void setListMembers(List<Member> listMembers) {
        Team.listMembers = listMembers;
    }

    public Long getId() {
        return teamId;
    }

    public void setId(Long id) {
        this.teamId = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

}
