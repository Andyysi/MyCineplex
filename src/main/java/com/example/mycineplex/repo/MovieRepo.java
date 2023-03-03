package com.example.mycineplex.repo;

import com.example.mycineplex.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.UUID;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

}

