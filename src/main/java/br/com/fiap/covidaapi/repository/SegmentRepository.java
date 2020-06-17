package br.com.fiap.covidaapi.repository;

import br.com.fiap.covidaapi.model.SegmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SegmentRepository extends JpaRepository<SegmentModel, Integer> {
        List<SegmentModel> findAllByIdBot(int idBot);
}
