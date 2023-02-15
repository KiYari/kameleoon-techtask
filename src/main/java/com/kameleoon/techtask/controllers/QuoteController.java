package com.kameleoon.techtask.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.kameleoon.techtask.model.Quote;
import com.kameleoon.techtask.model.User;
import com.kameleoon.techtask.model.Vote;
import com.kameleoon.techtask.model.dto.QuoteDto;
import com.kameleoon.techtask.model.views.QuoteView;
import com.kameleoon.techtask.services.QuoteService;
import com.kameleoon.techtask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/api")
public class QuoteController {
    private final QuoteService quoteService;
    private final UserService userService;

    @Autowired
    public QuoteController(QuoteService quoteService, UserService userService) {
        this.quoteService = quoteService;
        this.userService = userService;
    }

    @GetMapping("/quotes")
    public List<Quote> getAllQuotes() {
        return quoteService.findAll();
    }

    @GetMapping("/quote/{id}")
    public Quote getQuoteById(@PathVariable int id) {
        return quoteService.findById(id);
    }

    @GetMapping("/quote/{id}/details")
    public Map<String, Object> getQuoteDetails(@PathVariable int id) {
        Map<String, Object> details = new HashMap<>();
        Quote quote = quoteService.findById(id);
        details.put("quote", quote);
        details.put("author", quote.getAuthor());
        details.put("votes", quote.getQuoteVotes());
        return details;
    }

    @GetMapping("/quotes/random")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping("/quote/{id}/author")
    public User getAuthor(@PathVariable int id) {
        return quoteService.findById(id).getAuthor();
    }

    @GetMapping("/quote/{id}/votes")
    public List<Vote> getVotes(@PathVariable int id) {
        return quoteService.findById(id).getQuoteVotes();
    }

    @GetMapping("/quotes/top10")
    public List<Quote> getTop10Quotes() {
        return quoteService.getTopTen();
    }

    @GetMapping("/quotes/flop10")
    public List<Quote> getFlop10Quotes() {
        return quoteService.getFlopTen();
    }

    @GetMapping("/quote/{id}/votestat")
    public List<Vote> getVotesForGraph(@PathVariable int id) {
        return quoteService.getVotesForGraph(id);
    }

    @PostMapping(value = "/quotes", consumes = "application/json")
    public Quote postNewQuote(@RequestBody QuoteDto quote) {
        return quoteService.save(mapToQuote(quote));
    }

    @DeleteMapping(value = "/quote/{id}")
    public HttpStatus deleteQuote(@PathVariable int id) {
        quoteService.deleteQuote(id);
        return HttpStatus.OK;
    }

    @PatchMapping(value = "/quote/{id}", consumes = "application/json")
    public Quote updateQuote(@RequestBody QuoteDto quote, @PathVariable int id) {
        return quoteService.updateQuote(mapToQuote(quote), id);
    }

    private Quote mapToQuote(QuoteDto dto) {
        Quote quote = new Quote();
        quote.setContent(dto.getContent());
        quote.setAuthor(userService.findById(dto.getAuthorId()));
        return quote;
    }


}
