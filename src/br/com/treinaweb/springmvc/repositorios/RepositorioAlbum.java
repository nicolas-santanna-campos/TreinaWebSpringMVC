package br.com.treinaweb.springmvc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.treinaweb.springmvc.dominios.Album;

/*
 * Criando um repositorio de albuns
 * Devera extender a classe JpaRepository, que contem dois parametros: 
 * O primeiro devera ser a entidade que vai ser persistida por esse repositorio (Album)
 * O segundo devera ser o tipo da primaryKey da entidade (Nesse caso, o Long id)
 */
public interface RepositorioAlbum extends  JpaRepository<Album, Long>{
	/*
	 * Em tempo de execução os métodos de inserção, seleção, edição, deleção e alteração serão gerados pelo Spring Data
	 */
}
