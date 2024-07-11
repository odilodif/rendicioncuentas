/**
 * 
 */
package gob.cpccs.service.cron;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gob.cpccs.service.catalogos.InstitucionServicio;
import gob.cpccs.utilidades.Constantes;





/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 10:36:16
 */
@Component("RendicionComponent")
public class RendicionComponent implements RendicionService {

	@Autowired
	private InstitucionServicio institucionServicio;
	
	@Override
	public void work() {
		doSomething();

	}

	protected void doSomething() {

		System.out.println(new Date() + "schedule tasks using cron jobs - tarea 1 rendicion ");
		
	}
	




}
