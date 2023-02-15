package com.kameleoon.techtask.services;

import com.kameleoon.techtask.model.Quote;
import com.kameleoon.techtask.model.Vote;
import com.kameleoon.techtask.repo.VoteRepo;
import com.kameleoon.techtask.util.exceptions.VoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VoteService {
    private final VoteRepo repo;

    @Autowired
    public VoteService(VoteRepo repo) {
        this.repo = repo;
    }

    public Vote findById(int id) {
        return repo.findById(id).orElseThrow(()-> new VoteNotFoundException("No vote with such id"));
    }

    public void vote(Vote vote) {
        vote.setVoteDate(LocalDateTime.now());
        if(vote.isUpvoted()) {
            Quote quote = vote.getQuoteVotedFor();
            quote.setScore(quote.getScore() + 1);
            repo.save(vote);
        } else {
            Quote quote = vote.getQuoteVotedFor();
            quote.setScore(quote.getScore() - 1);
            repo.save(vote);
        }
    }

}
