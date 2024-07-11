package gob.cpccs.repository.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import gob.cpccs.model.usuario.TblPerfil;
import gob.cpccs.model.usuario.TblUsuario;
import gob.cpccs.model.usuario.TblUsuarioRol;

@Repository
@Transactional
public interface UsuarioRolRepository extends JpaRepository<TblUsuarioRol, String> {
	public List<TblUsuarioRol> findByIdUserAndIdPerfil(@Param("idUser") TblUsuario idUser,
			@Param("idPerfil") TblPerfil idPerfil);
	
	@Query("select t from TblUsuarioRol t where t.idUser.idUser=:idUser")
	public TblUsuarioRol findByidUser(@Param("idUser") Integer idUser);
	
	@Query("select t from TblUsuarioRol t where t.idUser.idUser=:idUser")
	public List<TblUsuarioRol>  findByidUserAnd(@Param("idUser") Integer idUser);

	@Modifying(clearAutomatically = true)
	@Query("delete from TblUsuarioRol t  where t.idUser.idUser=:idUser  ")
	void BorrarUsuariorolXcod(@Param("idUser") Integer idUser);

}
