/**
 * 
 */
package com.cdc.reporte.middleware.service.ejb;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

/**
 * @author TecnoSkill - 29/04/2008
 * @version 1.0
 */
public interface ReporteServiceEJBHome extends EJBHome {
	public ReporteServiceEJB create() throws CreateException, RemoteException;

}
