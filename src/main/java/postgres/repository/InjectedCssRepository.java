package postgres.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import postgres.model.CssRuleSet;

@Repository
public interface InjectedCssRepository extends CrudRepository<CssRuleSet, Long>{

}
