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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "team")
    private List<Member> listMembers;

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

    public void setListMembers(List<Member> listMembers) {
        listMembers = listMembers;
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

    @Override
    public String toString() {
        return teamName;
    }
}
