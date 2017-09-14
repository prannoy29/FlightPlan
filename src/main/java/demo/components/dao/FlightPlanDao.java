package demo.components.dao;

import demo.components.domain.FlightPlan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * DAO interface for flight plans, includes CRUD operations and
 * custom methods
 */
public interface FlightPlanDao {

    /**
     * Lists down all records of FlightPlan Table
     * @return List of all FlightPlans in Table
     */
    List getAll();


}