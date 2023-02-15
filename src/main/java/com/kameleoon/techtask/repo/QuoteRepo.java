package com.kameleoon.techtask.repo;

import com.kameleoon.techtask.model.Quote;
import com.kameleoon.techtask.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepo extends JpaRepository<Quote, Integer> {

    @Query("select count(*) from Quote")
    public int getQuotesAmount();

    @Query("select q from Quote q order by -q.score limit 10 ")
    public List<Quote> getTop10Quotes();

    @Query("Select q from Quote q order by q.score limit 10")
    public List<Quote> getFlop10Quotes();

    @Query("select q.quoteVotes from Quote q where q.id = :id")
    public List<Vote> getVotes(int id);
}
