package com.kameleoon.techtask.repo;

import com.kameleoon.techtask.model.Quote;
import com.kameleoon.techtask.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepo extends JpaRepository<Vote, Integer> {
}
