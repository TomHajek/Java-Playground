package dev.playground.persistence.repository;

import dev.playground.persistence.entity.Datablock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatablockRepository extends JpaRepository<Datablock, Integer> {

}
