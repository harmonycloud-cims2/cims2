package hk.health.framework.adapter.inbound.controller;

import hk.health.common.base.BaseResult;
import hk.health.framework.adapter.outbound.database.AppointmentRepository;
import hk.health.framework.adapter.outbound.database.dataobject.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * appointment
 *
 * @author gjq 2019-09-12
 */
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    /**
     * 新增或编辑
     */
    @PostMapping("/save")
    public Object save(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    /**
     * 删除
     */
    @PostMapping("/delete")
    public Object delete(int id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            appointmentRepository.deleteById(id);
            return BaseResult.ok("删除成功");
        } else {
            return BaseResult.error("没有找到该对象");
        }
    }

    /**
     * 查询
     */
    @PostMapping("/find")
    public Object find(int id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if (appointment.isPresent()) {
            return BaseResult.ok(appointment.get());
        } else {
            return BaseResult.error("没有找到该对象");
        }
    }

    /**
     * 分页查询
     */
    @PostMapping("/list")
    public Object list(Appointment appointment,
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {

        //创建匹配器，需要查询条件请修改此处代码
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        //创建实例
        Example<Appointment> example = Example.of(appointment, matcher);
        //分页构造
        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        return appointmentRepository.findAll(example, pageable);
    }

}
