package org.file.foto.file2;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface File2Repository extends JpaRepository<File2,Long>{
	
	@Query("select u from File2 u where u.usuario like ? ")
	public File2 findByNomeImage(String nome);
	
	

}
