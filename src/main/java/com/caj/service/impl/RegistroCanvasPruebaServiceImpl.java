package com.caj.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IRegistroCanvasPruebaDAO;
import com.caj.dao.IServicioDAO;
import com.caj.dto.RegistroCanvasDTO;
import com.caj.model.RegistroCanvasPrueba;
import com.caj.service.IRegistroCanvasPruebaService;
import com.caj.util.DBConn;

@Service
public class RegistroCanvasPruebaServiceImpl implements IRegistroCanvasPruebaService {
	
	@Autowired
	private IRegistroCanvasPruebaDAO dao;

	@Override
	public RegistroCanvasPrueba registrar(RegistroCanvasPrueba t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public RegistroCanvasPrueba modificar(RegistroCanvasPrueba t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<RegistroCanvasPrueba> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<RegistroCanvasPrueba> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		
	}

	@Override
	public void registrarCanvas(RegistroCanvasDTO regis) {
		// TODO Auto-generated method stub
		dao.registrarCanvas(regis.getCampo(), regis.getRegis().getIdRegistroCanvasPrueba(), regis.getValor());
		
	}
	
	Connection conn = null;
    ResultSet rset = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    String sql = "";
    DBConn dbconn = new DBConn();
	
	@Override
	public void registrarCanvas2(RegistroCanvasDTO regis) {
		
		// TODO Auto-generated method stub
		System.out.println("llamado");
		 boolean success = false;
	        sql="update registro_canvas_prueba "
	                + "set " + regis.getCampo() + " = '" + regis.getValor() + "' where id_cita = '" + regis.getId_cita() + "' ";
	               
	        System.out.println("ver sql -------------->>>>>>>>> : "+sql);
	        try {
	            conn = dbconn.getDBConnOSQL();
	            stmt = conn.createStatement();
	            if(stmt.executeUpdate(sql)==1){
	            	System.out.println("actualizado");
	                success=true;
	            }
	        } catch (Exception e) {
	            System.out.println("Error:"+e.getMessage());
	            e.getStackTrace();
	        }finally{
	            
	        }
	        //return success;
		
	}

}
