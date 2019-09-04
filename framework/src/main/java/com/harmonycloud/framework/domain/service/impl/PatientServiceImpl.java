package com.harmonycloud.framework.domain.service.impl;

import com.harmonycloud.framework.adapter.outbound.database.entity.Patient;
import com.harmonycloud.framework.adapter.outbound.database.mapper.PatientMapper;
import com.harmonycloud.framework.domain.service.IPatientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 病人 服务实现类
 *
 * @author GJQ
 * @since 2019-09-04
 */
@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient> implements IPatientService {

}
