package com.caj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caj.dto.RegistroCanvasDTO;
import com.caj.model.RegistroCanvasPrueba;
import com.caj.util.DBConn;

public interface IRegistroCanvasPruebaDAO extends JpaRepository<RegistroCanvasPrueba, Integer> {
	
	 Connection conn = null;
	    ResultSet rset = null;
	    Statement stmt = null;
	    PreparedStatement pstmt = null;
	    String sql = "";
	    DBConn dbconn = new DBConn();
	
	@Query(value = "update registro_canvas_prueba set :campo = :valor   where id_registro_canvas_prueba = :id_registro", nativeQuery = true)
	void registrarCanvas(@Param("campo")String campo, @Param("id_registro")Integer id_registro , @Param("valor")String valor);
	
	//void registrarCanvas2(RegistroCanvasDTO regis);
	

}
