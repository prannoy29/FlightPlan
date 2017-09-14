package demo.components.repository;

import demo.components.dao.FlightPlanDao;
import demo.components.domain.FlightPlan;
import org.springframework.data.repository.CrudRepository;

public interface FlightPlanRepository extends CrudRepository<FlightPlan,Long>, FlightPlanDao {

}
