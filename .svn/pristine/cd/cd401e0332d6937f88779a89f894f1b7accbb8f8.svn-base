package gob.cpccs.service.registroUsuarioInterno;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import gob.cpccs.model.funcionarios.TblDatosFuncionarios;
import gob.cpccs.repository.registroUsuarioInterno.UsuarioInternoRepository;

@Service
public class UsuarioInternoServicioImpl implements UsuarioInternoServicio {

     @Autowired
     private UsuarioInternoRepository usuarioInternoRepository;

  
     @Override
     public String obtenerMailInstitucionalFuncionario(String identificador) {
          return usuarioInternoRepository.findByIdentificadorCorreoInstitucionalFuncionario(identificador);
     }
     
     @Override
     public Object obtenerMailInstitucionalAndNombreFuncionario(String identificador) {
          return usuarioInternoRepository.findByIdentificadorCorreoInstitucionalAndNombreFuncionario(identificador);
     }

     @Override
     public TblDatosFuncionarios obtenerUsuarioInternoPorIdentificador(String identificador) {
          return usuarioInternoRepository.findByIdentificador(identificador);
     }



}
