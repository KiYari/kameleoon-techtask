package com.kameleoon.techtask.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.kameleoon.techtask.model.views.QuoteView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "quotes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column
    private String content;
    private int score;
    private LocalDateTime dateOfCreation;
    private LocalDateTime lastUpdateTime;
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    @JsonIgnore
    private User author;
    @OneToMany(mappedBy = "quoteVotedFor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vote> quoteVotes;

    @Override
    public String toString() {
        return "Quote{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", score=" + score +
                ", lastUpdateTime=" + lastUpdateTime +
                ", authorId=" + author.getId() +
                '}';
    }
}
