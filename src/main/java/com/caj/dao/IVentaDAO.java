package com.caj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.caj.model.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {
	
	@Query("from Venta v where  v.paciente.id =:idPatient")
	List<Venta> searchSaleByPatient( @Param("idPatient")Integer idPatient);
 
}
