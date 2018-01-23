/**
 * 
 */
package com.cdc.reporte.middleware.service.ejb;

import com.cdc.reporte.exception.ReporteException;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

/**
 * @author TecnoSkill - 29/04/2008
 * @version 1.0
 */
public interface ReporteServiceEJB extends EJBObject {
	
	/**
	 * @ejb.interface-method view-type="both"
	 * @param formato
	 * @return string
	 * @throws ReporteException
	 */
	public String reporteCirculo(String formato) throws RemoteException, ReporteException;

	/**
	 * @ejb.interface-method view-type="both"
	 * @param formato
	 * @return string
	 * @throws ReporteException
	 */
	public String reporteCirculo2en1(String formato) throws RemoteException, ReporteException;
	
	/**
	 * @ejb.interface-method view-type="both"
	 * @param formato
	 * @return string
	 * @throws ReporteException
	 */
	public String reporteCirculoAutenticado(String formato) throws RemoteException, ReporteException;
	
	/**
	 * @ejb.interface-method view-type="both"
	 * @param formato
	 * @return string
	 * @throws ReporteException
	 */	
	public String reporteCirculoMasivas(String formato) throws RemoteException, ReporteException;
	public String reporteCirculoV2(String formato) throws RemoteException, ReporteException;
	/*
	/**
	 * @ejb.interface-method view-type="both"
	 * @param xml
	 * @return string
	 * @throws ReporteException
	 */
	//public String autenticaPersona(String xml) throws RemoteException, ReporteException;

	/**
	 * Envia a actualizar la consulta con el tiempo total de la consulta (hasta que el socket entrega)
	 * @ejb.interface-method view-type="both"
	 * @param formato
	 * @param tiempo
	 * @throws ReporteException
	 */
	public void enviaTiempoTotal(String formato, Long tiempo) throws RemoteException, ReporteException;
	
	public String reporteCirculoBuro(String formato) throws RemoteException, ReporteException;
	
	public boolean validaCoincidenciaRenueva(String formato) throws RemoteException, ReporteException;
	
	public String generaScore(int nconencfolio) throws RemoteException, ReporteException;
	
	public String dobleAutenticacion(int nconencfolio)  throws  RemoteException, ReporteException;
	
	

}
