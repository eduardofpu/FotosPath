package org.file.foto.file;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileRepository extends JpaRepository<File1,Long>{
	
	@Query("select u from File1 u where u.usuario like ? ")
	public File1 findByNomeImage(String nome);
	
	

}
