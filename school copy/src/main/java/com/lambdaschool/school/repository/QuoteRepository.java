package com.lambdaschool.school.repository;

import com.lambdaschool.school.model.Quote;
import com.lambdaschool.school.view.CountQuotes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface QuoteRepository extends CrudRepository<Quote, Long>
{
    @Query(value = "SELECT u.username, count(q.quotesid) as countquotes FROM quotes q JOIN users u on q.userid = u.userid GROUP BY u.username", nativeQuery = true)
    ArrayList<CountQuotes> getCountQuotes();
}
