/**
 * 
 */
package gob.cpccs.service.registroUsuarioInterno;

import java.util.List;
import gob.cpccs.model.funcionarios.TblDatosFuncionarios;

/**
 * @author Carlos
 *
 */
public interface UsuarioInternoServicio {


     
     TblDatosFuncionarios obtenerUsuarioInternoPorIdentificador(String identificador);

     String obtenerMailInstitucionalFuncionario(String identificador);
     
     Object obtenerMailInstitucionalAndNombreFuncionario(String identificador);
}
