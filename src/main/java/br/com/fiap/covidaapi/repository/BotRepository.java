package br.com.fiap.covidaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.fiap.covidaapi.model.BotModel;

@Repository
public interface BotRepository extends JpaRepository<BotModel, Integer>{

}
