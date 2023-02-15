package com.kameleoon.techtask.controllers;

import com.kameleoon.techtask.model.Vote;
import com.kameleoon.techtask.model.dto.VoteDto;
import com.kameleoon.techtask.services.QuoteService;
import com.kameleoon.techtask.services.UserService;
import com.kameleoon.techtask.services.VoteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api")
public class VoteController {
    private final VoteService voteService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final QuoteService quoteService;


    @Autowired
    public VoteController(VoteService voteService, ModelMapper modelMapper, UserService userService, QuoteService quoteService) {
        this.voteService = voteService;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.quoteService = quoteService;
    }

    @GetMapping("/vote/{id}")
    public Vote getVoteInformation(@PathVariable int id) {
        return voteService.findById(id);
    }

    @PostMapping(value = "/vote", consumes = "application/json")
    public HttpStatus vote(@RequestBody VoteDto vote) {
        voteService.vote(mapToVote(vote));
        return HttpStatus.OK;
    }

    public Vote mapToVote(VoteDto dto) {
        Vote vote = new Vote();
        vote.setUpvoted(dto.isUpvoted());
        vote.setUser(userService.findById(dto.getVoterId()));
        vote.setQuoteVotedFor(quoteService.findById(dto.getQuoteId()));

        return vote;
    }
}
