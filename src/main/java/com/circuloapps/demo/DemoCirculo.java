    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.circuloapps.demo;


import com.cdc.procesadorformatos.util.ConvertidorFormatos;
import com.cdc.procesadorformatos.vo.SuperArrayVO;
import com.cdc.reporte.exception.ReporteException;
import com.cdc.reporte.middleware.service.ejb.ReporteServiceEJB;
import com.cdc.reporte.middleware.service.ejb.ReporteServiceEJBHome;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Hashtable;

import javax.ejb.CreateException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




/**
 *
 * @author jpadilla
 */
@RestController
@Api(value = "DemoSwagger")
public class DemoCirculo {
    
     public final static String JNDI_FACTORY_WL = "weblogic.jndi.WLInitialContextFactory";
     public static ReporteServiceEJBHome home;
     
     String xmlPrueba = "";
     String lsResult = "";
    
    @RestController
    public class HelloController 
    {
        @RequestMapping("/swagger")
        @ApiOperation("Ejemplo con swagger")
        
        String swagger() throws IOException 
        {
            return "Hola mundo swagger";
        }
        @RequestMapping("/")
        String hellow() throws IOException 
        {
            String formato = "<?xml version=\"1.0\" encoding = \"ISO-8859-1\"?><Consulta><Encabezado><ClaveOtorgante>0000081008</ClaveOtorgante><NombreUsuario>DEMO</NombreUsuario><Password>TEST01.</Password></Encabezado><Personas><Persona><DetalleConsulta><FolioConsultaOtorgante>0010001</FolioConsultaOtorgante><ProductoRequerido>9</ProductoRequerido><TipoCuenta>F</TipoCuenta><ClaveUnidadMonetaria>MX</ClaveUnidadMonetaria><ImporteContrato>1</ImporteContrato><NumeroFirma>B709359C8A7A</NumeroFirma></DetalleConsulta><Nombre><ApellidoPaterno>PRUEBA</ApellidoPaterno><ApellidoMaterno>CUATRO</ApellidoMaterno><ApellidoAdicional></ApellidoAdicional><Nombres>JUAN</Nombres><FechaNacimiento>1980-01-04</FechaNacimiento><RFC>PUCJ800104</RFC><CURP></CURP><Nacionalidad></Nacionalidad><Residencia></Residencia><EstadoCivil></EstadoCivil><Sexo></Sexo><ClaveElectorIFE></ClaveElectorIFE><NumeroDependientes></NumeroDependientes></Nombre><Domicilios><Domicilio><Direccion>INSURGENTES SUR 1004</Direccion><ColoniaPoblacion>INSURGENTES</ColoniaPoblacion><DelegacionMunicipio>BENITO JUAREZ</DelegacionMunicipio><Ciudad>BENITO JUAREZ</Ciudad><Estado>CDMX</Estado><CP>04480</CP><FechaResidencia></FechaResidencia><NumeroTelefono></NumeroTelefono><TipoDomicilio></TipoDomicilio><TipoAsentamiento></TipoAsentamiento></Domicilio></Domicilios><Empleos><Empleo><NombreEmpresa>BAZ</NombreEmpresa><Direccion>AV SIEMPREVIVA 142</Direccion><ColoniaPoblacion/><DelegacionMunicipio/><Ciudad>MEXICO</Ciudad><Estado>CDMX</Estado><CP>14789</CP><NumeroTelefono/><Extension/><Fax/><Puesto>GERENTE</Puesto><FechaContratacion/><ClaveMoneda/><SalarioMensual>8000</SalarioMensual><FechaUltimoDiaEmpleo/></Empleo></Empleos><CuentasReferencia><NumeroCuenta>0000040</NumeroCuenta></CuentasReferencia></Persona></Personas></Consulta>";
            SuperArrayVO superArrayVO = new SuperArrayVO();
            
            ConvertidorFormatos converFormat = new ConvertidorFormatos();
            
            superArrayVO = converFormat.desentramaXML(formato);
            
            return superArrayVO.getEncabezadoVO().getContrasenna();
        }
        
        @RequestMapping("/ejb")
        String ejb() throws IOException, RemoteException, CreateException, ReporteException 
        {
                    try {

                            Hashtable env_WL = new Hashtable();

                            env_WL.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY_WL);
                            env_WL.put(Context.PROVIDER_URL, "t3://10.77.50.90:7003");

                            InitialContext context = new InitialContext(env_WL);
                            ReporteServiceEJBHome obj = (ReporteServiceEJBHome) context.lookup("ejb/ReporteServiceEJBPF");

                            

                            ReporteServiceEJB reporte = (ReporteServiceEJB) narrow(obj.create(), ReporteServiceEJB.class);


                            xmlPrueba="<?xml version='1.0' encoding='ISO-8859-1'?><Consulta><Encabezado><ClaveOtorgante>0000081008</ClaveOtorgante>"
                                    + "<NombreUsuario>IHM0915CMI</NombreUsuario><Password>IHM0915CMI</Password></Encabezado>"
                                    + "<Personas><Persona><DetalleConsulta><FolioConsultaOtorgante>0010001</FolioConsultaOtorgante>"
                                    + "<ProductoRequerido>14</ProductoRequerido><TipoCuenta>F</TipoCuenta><ClaveUnidadMonetaria>MX</ClaveUnidadMonetaria>"
                                    + "<ImporteContrato>1</ImporteContrato><NumeroFirma>B709359C8A7A</NumeroFirma></DetalleConsulta>"
                                    + "<Nombre><ApellidoPaterno>PRUEBA</ApellidoPaterno><ApellidoMaterno>CUATRO</ApellidoMaterno><ApellidoAdicional/><Nombres>JUAN</Nombres>"
                                    + "<FechaNacimiento>1980-01-04</FechaNacimiento><RFC>PUCJ800104</RFC><CURP></CURP><Nacionalidad></Nacionalidad><Residencia></Residencia><EstadoCivil></EstadoCivil><Sexo></Sexo><ClaveElectorIFE></ClaveElectorIFE><NumeroDependientes></NumeroDependientes></Nombre>"
                                    + "<Domicilios><Domicilio><Direccion>INSURGENTES SUR 1004</Direccion><ColoniaPoblacion>INSURGENTES</ColoniaPoblacion><DelegacionMunicipio>BENITO JUAREZ</DelegacionMunicipio><Ciudad>BENITO JUAREZ</Ciudad>"
                                    + "<Estado>DF</Estado><CP>04480</CP><FechaResidencia></FechaResidencia><NumeroTelefono></NumeroTelefono><TipoDomicilio></TipoDomicilio><TipoAsentamiento></TipoAsentamiento></Domicilio></Domicilios>"
                                    + "<Empleos><Empleo><NombreEmpresa>BAZ</NombreEmpresa><Direccion>AV SIEMPREVIVA 142</Direccion><ColoniaPoblacion/><DelegacionMunicipio/><Ciudad>MEXICO</Ciudad><Estado>DF</Estado><CP>14789</CP><NumeroTelefono/><Extension/><Fax/><Puesto>GERENTE</Puesto><FechaContratacion/><ClaveMoneda/><SalarioMensual>8000</SalarioMensual><FechaUltimoDiaEmpleo/></Empleo></Empleos>"
                                    + "<CuentasReferencia><NumeroCuenta>0000040</NumeroCuenta></CuentasReferencia>"
                                    //+ "<Autenticacion><TarjetaDeCredito><Tiene>V</Tiene><NumeroCuenta>1214</NumeroCuenta></TarjetaDeCredito><CreditoHipotecario><Tiene>V</Tiene></CreditoHipotecario><CreditoAutomotriz><Tiene>V</Tiene></CreditoAutomotriz></Autenticacion>"
                                    + "</Persona></Personas></Consulta>";

                            lsResult = reporte.reporteCirculo(xmlPrueba);

                            
                            //CHKDETDOM

                    } catch (NamingException ne) {
                            ne.printStackTrace();
                    }
            return lsResult;
            }

            
        }
        private static Object narrow(Object ref, Class c) {
                    return PortableRemoteObject.narrow(ref, c);
            }
    
    
}
