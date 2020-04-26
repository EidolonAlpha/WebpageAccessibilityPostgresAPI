package postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import postgres.model.WebpagePreference;

@Repository
public interface WebpagePrefernceRepository extends CrudRepository<WebpagePreference, Long>{

}
