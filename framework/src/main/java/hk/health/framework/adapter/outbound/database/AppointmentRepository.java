package hk.health.framework.adapter.outbound.database;

import hk.health.framework.adapter.outbound.database.dataobject.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * appointment
 *
 * @author gjq 2019-09-12
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

}
