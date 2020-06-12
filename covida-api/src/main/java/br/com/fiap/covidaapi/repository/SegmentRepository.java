package br.com.fiap.covidaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.covidaapi.model.SegmentModel;

@Repository
public interface SegmentRepository extends JpaRepository<SegmentModel, Integer>{

}
