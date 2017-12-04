package dao;

import org.springframework.data.repository.CrudRepository;

import model.TestCase;

public interface TestCaseRepository extends CrudRepository<TestCase, Long>{

}
