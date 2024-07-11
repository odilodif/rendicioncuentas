package gob.cpccs.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.cpccs.model.usuario.TblRol;


@Repository
public interface RolRepository extends JpaRepository<TblRol, String>{
//	TblRoles findByNombreRol(@Param("nombreRol") String nombreRol);
	TblRol findByRolDescripcion(@Param("rolDescripcion") String rolDescripcion);

}
