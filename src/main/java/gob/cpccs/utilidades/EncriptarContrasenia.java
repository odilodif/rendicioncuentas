package gob.cpccs.utilidades;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Controlador EncriptarContrasenia
 *
 * Este archivo contiene métodos para el controlador EncriptarContrasenia
 *
 * @property CPCCS
 * @author Carlos Anchundia
 * @email e.du.ingcharles@hotmail.com
 * @date 2019-01-15
 * @uses EncriptarContrasenia
 * @package gob.cpccs.utilidades
 * @subpackage 
 * 
 */

public class EncriptarContrasenia {
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
