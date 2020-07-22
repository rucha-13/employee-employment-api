package com.org.app.repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.org.app.model.Winner;

public interface WinnerRepository extends CrudRepository<Winner, Long> {

	@Query("Select w from Winner w where Month(w.winningDate)=:month And Year(w.winningDate)=:year")
	public Winner getWinner(@Param("month")int month,@Param("year")int year);
}
