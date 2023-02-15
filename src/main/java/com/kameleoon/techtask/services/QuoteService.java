package com.kameleoon.techtask.services;

import com.kameleoon.techtask.model.Quote;
import com.kameleoon.techtask.model.User;
import com.kameleoon.techtask.model.Vote;
import com.kameleoon.techtask.repo.QuoteRepo;
import com.kameleoon.techtask.util.exceptions.QuoteNotCreatedException;
import com.kameleoon.techtask.util.exceptions.QuoteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
public class QuoteService {
    private final QuoteRepo repo;

    @Autowired
    public QuoteService(QuoteRepo repo) {
        this.repo = repo;
    }

    public Quote save(Quote quote) {
        try {
            quote.setScore(0);
            quote.setDateOfCreation(LocalDateTime.now());
            quote.setLastUpdateTime(LocalDateTime.now());
            return repo.save(quote);
        } catch (Exception e) {
            throw new QuoteNotCreatedException("Quote has not been created");
        }
    }

    public Quote findById(int id) {
        return repo.findById(id).orElseThrow(() -> new QuoteNotFoundException("Quote has not been found"));
    }

    public List<Quote> findAll() {
        return repo.findAll();
    }

    public Quote getRandomQuote() {
        int quotesAmount = repo.getQuotesAmount();
        return findById((int) ((Math.random() * (quotesAmount - 1)) + 1)% quotesAmount);
    }

    public Quote updateQuote(Quote quote, int id) {
        Quote quoteFromDb = findById(id);

        quoteFromDb.setContent(quote.getContent());
        quoteFromDb.setAuthor(quote.getAuthor());
        quoteFromDb.setLastUpdateTime(LocalDateTime.now());

        return repo.save(quoteFromDb);
    }

    public void deleteQuote(int id) {
        repo.delete(findById(id));
    }

    public User getWhoPosted(Quote quote) {
        return quote.getAuthor();
    }

    public List<Vote> getVotes(Quote quote) {
        return quote.getQuoteVotes();
    }

    public List<Quote> getTopTen() {
        return repo.getTop10Quotes();
    }

    public List<Quote> getFlopTen() {
        return repo.getFlop10Quotes();
    }

    public List<Vote> getVotesForGraph(int id) {
        List<Vote> votes = repo.getVotes(id);
        votes.sort(Comparator.comparingInt(o -> o.getVoteDate().getSecond()));

        return votes;
    }
}
