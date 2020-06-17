package br.com.fiap.covidaapi.repository;


import br.com.fiap.covidaapi.model.OptionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<OptionModel, Integer> {
    List<OptionModel> findAllByIdSegment(int idSegment);
}
