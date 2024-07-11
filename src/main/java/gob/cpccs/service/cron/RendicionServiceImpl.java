/**
 * 
 */
package gob.cpccs.service.cron;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Service;


/**
 * @author Mauricio Rivera
 * @mail mauriciorivera68@hotmail.com
 * @date 10:36:50
 */
//@EnableScheduling
@Service
public class RendicionServiceImpl {
	
	private static final String TIME_ZONE =  "America/Guayaquil";  
	
	  @Autowired
	   @Qualifier("RendicionComponent")
	    private RendicionComponent worker;

	  
	  @Scheduled(cron="* */3 * * * *",zone = TIME_ZONE)//zone is a sample
	    public void doSchedule() {

		   worker.work();
	    }



}
