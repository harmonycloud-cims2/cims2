package com.harmonycloud.framework.adapter.outbound.database.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.harmonycloud.common.BaseMapperTest;
import com.harmonycloud.framework.adapter.outbound.database.entity.Patient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Usage:
 * @Author: gjq
 * @Date: 2019-09-04 16:05
 */
public class PatientMapperTest extends BaseMapperTest {
    @Autowired
    private PatientMapper patientMapper;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        Patient patient = new Patient();
        patient.setUsername("test");
        patientMapper.insert(patient);
        System.out.println(patientMapper.selectOne(new QueryWrapper<Patient>().eq("username", "test")));
    }
}