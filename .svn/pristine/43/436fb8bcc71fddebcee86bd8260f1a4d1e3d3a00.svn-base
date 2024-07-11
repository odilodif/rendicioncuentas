package gob.cpccs.repository.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.usuario.TblPerfil;


@Repository
@Transactional
public interface PerfilRepository extends JpaRepository<TblPerfil, String>{
    
	
	List<TblPerfil> findByEstadoAndDescripcionIn(@Param("estado") String estado, @Param("descripcion") List<String> descripcion);
	List<TblPerfil> findByEstadoAndIdPerfilIn(@Param("estado") String estado, @Param("idPerfil") List<Integer> idPerfil);
	
	List<TblPerfil> findByIdPerfil(@Param("idPerfil") Integer idPerfil);
	//List<TblPerfil> findByDescripcion(@Param("descripcion") listaPerfiles);

}
