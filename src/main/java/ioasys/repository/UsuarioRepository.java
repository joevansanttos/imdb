package ioasys.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ioasys.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	
	@Query("select u from Usuario u join u.perfis p where p.nome='ROLE_USUARIO'")
    Page<Usuario> listaUsuariosComuns(Pageable paginacao);
	
	@Query("select u from Usuario u where u.email = :email")
	Optional<Usuario> findByEmail(@Param("email")String email);

	
}