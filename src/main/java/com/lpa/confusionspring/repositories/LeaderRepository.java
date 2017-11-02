package com.lpa.confusionspring.repositories;

import com.lpa.confusionspring.domain.Leader;
import org.springframework.data.repository.CrudRepository;

public interface LeaderRepository extends CrudRepository<Leader, String> {
}
