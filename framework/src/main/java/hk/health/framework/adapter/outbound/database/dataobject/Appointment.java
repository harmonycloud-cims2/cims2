package hk.health.framework.adapter.outbound.database.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * appointment
 *
 * @author gjq 2019-09-12
 */
@Entity
@Data
@Table(name = "appointment")
public class Appointment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    /**
     * appointment_id
     */
    private Long appointmentId;

    /**
     * appointment_date
     */
    private Date appointmentDate;

    /**
     * attendance_status
     */
    private String attendanceStatus;

    /**
     * attendance_time
     */
    private Date attendanceTime;

    /**
     * clinic_id
     */
    private Long clinicId;

    /**
     * clinic_name
     */
    private String clinicName;

    /**
     * encounter_type_id
     */
    private Long encounterTypeId;

    /**
     * encounter_type_name
     */
    private String encounterTypeName;

    /**
     * patient_doc
     */
    private String patientDoc;

    /**
     * patient_id
     */
    private Long patientId;

    /**
     * patient_name
     */
    private String patientName;

    /**
     * patient_sex
     */
    private String patientSex;

    /**
     * room_id
     */
    private Long roomId;

    /**
     * room_name
     */
    private String roomName;

    public Appointment() {
    }

}