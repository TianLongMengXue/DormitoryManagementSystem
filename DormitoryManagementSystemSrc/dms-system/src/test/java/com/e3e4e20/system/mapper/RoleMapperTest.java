package com.e3e4e20.system.mapper;

import com.e3e4e20.common.utils.IdUtils;
import com.e3e4e20.model.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Filename: com.e3e4e20.system.mapper
 * Description: 角色表接口类测试
 * Version: 1.0
 * Created: 2020-04-09 0:38 星期四
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class RoleMapperTest {
    @Autowired
    RoleMapper roleMapper;
    @Test
    public void insertRoleTest () {
        String roleId = String.valueOf(new IdUtils().nextId());
        // roleMapper.insertRole(new RoleDomain( , ""));
    }
}
