package com.e3e4e20.ctrl;

import com.e3e4e20.common.pojo.ClassDomain;
import com.e3e4e20.common.pojo.DormitoryDomain;
import com.e3e4e20.common.pojo.StuDorDomain;
import com.e3e4e20.common.utils.IdUtils;
import com.e3e4e20.ctrl.service.MemberService;
import com.e3e4e20.ctrl.service.MenuService;
import com.e3e4e20.model.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CtrlApplicationTests {
    @Autowired
    MenuService menuService;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StuClassMapper stuClassMapper;
    @Autowired
    TeaClassMapper teaClassMapper;
    @Autowired
    DormitoryMapper dormitoryMapper;
    @Autowired
    StuDorMapper stuDorMapper;
    @Autowired
    DorHeadMapper dorHeadMapper;
    @Autowired
    MemberService memberService;

    @Test
    void menuServiceTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", "16478082");
        System.out.println(menuService.getMenuItem(map));
    }

    @Test
    void initClassTest (){
        String classId = String.valueOf(new IdUtils().nextId());
        classMapper.insertClass(new ClassDomain(classId, "软件工程1602"));
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", new IdUtils().nextId());
        map1.put("userId", "16478060");
        map1.put("classId", classId);
        stuClassMapper.insertRelation(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", new IdUtils().nextId());
        map2.put("userId", "16478067");
        map2.put("classId", classId);
        stuClassMapper.insertRelation(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", new IdUtils().nextId());
        map3.put("userId", "16478080");
        map3.put("classId", classId);
        stuClassMapper.insertRelation(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", new IdUtils().nextId());
        map4.put("userId", "16478081");
        map4.put("classId", classId);
        stuClassMapper.insertRelation(map4);
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", new IdUtils().nextId());
        map5.put("userId", "16478082");
        map5.put("classId", classId);
        stuClassMapper.insertRelation(map5);
    }

    @Test
    void initDorTest (){
        String dorId1 = String.valueOf(new IdUtils().nextId());
        String dorId2 = String.valueOf(new IdUtils().nextId());
        String dorId3 = String.valueOf(new IdUtils().nextId());
        dormitoryMapper.insertRelation(new DormitoryDomain(dorId1,"13栋","13-210"));
        dormitoryMapper.insertRelation(new DormitoryDomain(dorId2,"12栋","12-220"));
        dormitoryMapper.insertRelation(new DormitoryDomain(dorId3,"12栋","12-301"));
        stuDorMapper.insertRelation(new StuDorDomain("16478060",dorId2,6));
        stuDorMapper.insertRelation(new StuDorDomain("16478067",dorId1,3));
        stuDorMapper.insertRelation(new StuDorDomain("16478080",dorId2,1));
        stuDorMapper.insertRelation(new StuDorDomain("16478081",dorId3,2));
        stuDorMapper.insertRelation(new StuDorDomain("16478082",dorId1,4));
        Map<String,Object> map1 = new HashMap<>();
        map1.put("id", new IdUtils().nextId());
        map1.put("userId", "16478080");
        map1.put("dorId", dorId2);
        dorHeadMapper.insertRelation(map1);
    }

    @Test
    void MemberServiceTest (){
        System.out.println(memberService.getUserInfo("16478082"));
    }
}
