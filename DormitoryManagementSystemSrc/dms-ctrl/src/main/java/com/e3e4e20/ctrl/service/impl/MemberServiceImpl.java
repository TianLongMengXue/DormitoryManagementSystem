package com.e3e4e20.ctrl.service.impl;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.pojo.DormitoryDomain;
import com.e3e4e20.common.pojo.LoginDomain;
import com.e3e4e20.common.pojo.StuDorDomain;
import com.e3e4e20.common.pojo.UserDomain;
import com.e3e4e20.ctrl.service.MemberService;
import com.e3e4e20.model.mapper.*;
import com.e3e4e20.model.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * Description: 个人中心业务层实现类
 * Created: 2020-05-07 15:46 星期四
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    LoginTimeMapper loginTimeMapper;
    @Autowired
    ClassMapper classMapper;
    @Autowired
    StuClassMapper stuClassMapper;
    @Autowired
    DormitoryMapper dormitoryMapper;
    @Autowired
    StuDorMapper stuDorMapper;
    @Autowired
    LoginMapper loginMapper;
    @Override
    public ResponseData getUserInfo(String userId) {
        UserDomain userDomain = userInfoService.selectUserInfo(userId);
        Date lastTime = loginTimeMapper.selectById(userId);
        String classId = stuClassMapper.selectClassIdByUserId(userId);
        String className = classMapper.selectNameById(classId);
        StuDorDomain stuDorDomain = stuDorMapper.selectByUserId(userId);
        DormitoryDomain dormitoryDomain = dormitoryMapper.selectById(stuDorDomain.getDorId());
        Map<String,String> userInfo = new HashMap<>();
        userInfo.put("id",userId);
        userInfo.put("name",userDomain.getUserName());
        userInfo.put("tel",userDomain.getUserTel());
        userInfo.put("mail",userDomain.getUserMail());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        userInfo.put("lastTime",simpleDateFormat.format(lastTime));
        userInfo.put("college",userDomain.getCollegeName());
        userInfo.put("class",className);
        userInfo.put("dor", dormitoryDomain.getDorNum());
        return ResponseData.SUCCESS("init", userInfo);
    }

    @Override
    public ResponseData alterUserInfo(Map<String, String> map) {
        userInfoService.update(map);
        return ResponseData.SUCCESS("修改成功", null);
    }

    @Override
    public ResponseData alterUserWord(LoginDomain loginDomain) {
        loginMapper.updateById(loginDomain);
        return ResponseData.SUCCESS("修改成功", null);
    }
}
