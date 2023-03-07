package com.e3e4e20.system.mapper;

import com.e3e4e20.common.pojo.*;
import com.e3e4e20.common.utils.IdUtils;
import com.e3e4e20.model.mapper.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * Description:
 * Created: 2020-04-14 15:19 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class InitDatabase {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    PermMapper permMapper;
    @Autowired
    RolePermMapper rolePermMapper;
    @Autowired
    CtrlMenuMapper ctrlMenuMapper;
    @Autowired
    CtrlApisMapper ctrlApisMapper;
    @Autowired
    CtrlPointMapper ctrlPointMapper;
    IdUtils idUtils = new IdUtils();
    private String student = "1253885033299607552";
    private String teacher = "1253885038093697024";
    private String assistant = "1253885041939873792";
    private String dorHead = "1253885044599062528";
    private String classHead = "1253885047170170880";
    private String classChief = "1253885049795805184";
    private String memberQin = "1253885052463382528";
    private String memberMi = "1253885055055462400";
    private String memberKao = "1253885057911783424";
    private String ministerQin = "1253885060612915200";
    private String ministerMi = "1253885063272103936";
    private String ministerKao = "1253885065956458496";
    private String ministerZhu = "1253885068636618752";
    private String teacherChief = "1253885071245475840";
    private String sysAdmin = "1253885073812389888";
    @Test
    public void initSys_user () {
        String collegeId = String.valueOf(idUtils.nextId());
        userMapper.insertUser(new UserDomain("16478060","车伟奇","13657948659","1263220125@qq.com",new Date(),collegeId,"信息与计算机工程学院"));
        userMapper.insertUser(new UserDomain("16478067","李云飞","18779922797","1908407747@qq.com",new Date(),collegeId,"信息与计算机工程学院"));
        userMapper.insertUser(new UserDomain("16478080","荆辞雪","18779916319","844049178@qq.com",new Date(),collegeId,"信息与计算机工程学院"));
        userMapper.insertUser(new UserDomain("16478081","郭鹏程","18779920015","2376306355@qq.com",new Date(),collegeId,"信息与计算机工程学院"));
        userMapper.insertUser(new UserDomain("16478082","余丽","17379207923","1305284627@qq.com",new Date(),collegeId,"信息与计算机工程学院"));

    }

    @Test
    public void initRole () {
        roleMapper.insertRole(new RoleDomain(student,"学生"));
        roleMapper.insertRole(new RoleDomain(dorHead,"宿舍长"));
        roleMapper.insertRole(new RoleDomain(classHead,"班长"));
        roleMapper.insertRole(new RoleDomain(memberQin,"寝工部部门成员"));
        roleMapper.insertRole(new RoleDomain(memberMi,"秘书部部门成员"));
        roleMapper.insertRole(new RoleDomain(memberKao,"考核部部门成员"));
        roleMapper.insertRole(new RoleDomain(ministerQin,"寝工部部长"));
        roleMapper.insertRole(new RoleDomain(ministerMi,"秘书部部长"));
        roleMapper.insertRole(new RoleDomain(ministerKao,"考核部部长"));
        roleMapper.insertRole(new RoleDomain(ministerZhu,"主任"));
        roleMapper.insertRole(new RoleDomain(teacher,"老师"));
        roleMapper.insertRole(new RoleDomain(assistant,"辅导员"));
        roleMapper.insertRole(new RoleDomain(classChief,"班主任"));
        roleMapper.insertRole(new RoleDomain(teacherChief,"指导老师"));
        roleMapper.insertRole(new RoleDomain(sysAdmin,"系统管理员"));
    }

    @Test
    public void initMember () {
        /*
         * 一级菜单 个人中心
         * 学生、老师、辅导员、系统管理员
         * 二级菜单 用户信息 - 用户密码
         * 学生、老师、辅导员、系统管理员
         * 二级菜单 重置密码
         * 指导老师、系统管理员
         * 二级菜单接口 -- 获取用户基本信息
         * 二级菜单功能按钮 -- 修改密码 -- 确认提交 -- 重置密码
         * */
        Map<String, Object> map = new HashMap<>();
        map.put("id", idUtils.nextId());
        map.put("roleId", student);
        map.put("userId", "16478082");
        userRoleMapper.insertRelation(map);

        /* 一级菜单 个人中心 学生 老师 辅导员 系统管理员 */
        String perm1 = String.valueOf(idUtils.nextId());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", idUtils.nextId());
        map1.put("roleId", student);
        map1.put("permId", perm1);
        rolePermMapper.insertRelation(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", idUtils.nextId());
        map2.put("roleId", teacher);
        map2.put("permId", perm1);
        rolePermMapper.insertRelation(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", idUtils.nextId());
        map3.put("roleId", assistant);
        map3.put("permId", perm1);
        rolePermMapper.insertRelation(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", idUtils.nextId());
        map4.put("roleId", sysAdmin);
        map4.put("permId", perm1);
        rolePermMapper.insertRelation(map4);
        permMapper.insertPerm(new PermDomain(perm1,"个人中心","个人中心菜单","menu-member",0,null));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm1, "el-icon-user", 1, null));

        /* 二级菜单 基本信息 获取基本信息接口 学生 老师 辅导员 */
        String perm2 = String.valueOf(idUtils.nextId());
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", idUtils.nextId());
        map5.put("roleId", student);
        map5.put("permId", perm2);
        rolePermMapper.insertRelation(map5);
        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", idUtils.nextId());
        map6.put("roleId", teacher);
        map6.put("permId", perm2);
        rolePermMapper.insertRelation(map6);
        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", idUtils.nextId());
        map7.put("roleId", assistant);
        map7.put("permId", perm2);
        rolePermMapper.insertRelation(map7);
        permMapper.insertPerm(new PermDomain(perm2,"基本信息","用户基本信息菜单","menu-userInfo",1,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm2, "el-icon-menu", 1, "userInfo"));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm2, "get", "/ctrl/userInfo/select"));

        /* 二级菜单功能按钮 修改用户信息 学生 老师 辅导员 */
        String perm3 = String.valueOf(idUtils.nextId());
        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", idUtils.nextId());
        map8.put("roleId", student);
        map8.put("permId", perm3);
        rolePermMapper.insertRelation(map8);
        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", idUtils.nextId());
        map9.put("roleId", teacher);
        map9.put("permId", perm3);
        rolePermMapper.insertRelation(map9);
        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", idUtils.nextId());
        map10.put("roleId", assistant);
        map10.put("permId", perm3);
        rolePermMapper.insertRelation(map10);
        permMapper.insertPerm(new PermDomain(perm3,"修改用户信息","修改用户信息接口","api-userInfo-update",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm3, "post", "/ctrl/userInfo/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm3, "primary", "保存修改", 1));

        /* 二级菜单 修改密码 学生 老师 辅导员 系统管理员 */
        String perm4 = String.valueOf(idUtils.nextId());
        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", idUtils.nextId());
        map11.put("roleId", student);
        map11.put("permId", perm4);
        rolePermMapper.insertRelation(map11);
        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", idUtils.nextId());
        map12.put("roleId", teacher);
        map12.put("permId", perm4);
        rolePermMapper.insertRelation(map12);
        Map<String, Object> map13 = new HashMap<>();
        map13.put("id", idUtils.nextId());
        map13.put("roleId", assistant);
        map13.put("permId", perm4);
        rolePermMapper.insertRelation(map13);
        Map<String, Object> map14 = new HashMap<>();
        map14.put("id", idUtils.nextId());
        map14.put("roleId", sysAdmin);
        map14.put("permId", perm4);
        rolePermMapper.insertRelation(map14);
        permMapper.insertPerm(new PermDomain(perm4,"修改密码","修改密码菜单","menu-changeWord",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm4, "el-icon-menu", 2, "changeWord"));

        /* 二级菜单按钮 修改密码 学生 老师 辅导员 系统给管理员 */
        String perm5 = String.valueOf(idUtils.nextId());
        Map<String, Object> map15 = new HashMap<>();
        map15.put("id", idUtils.nextId());
        map15.put("roleId", student);
        map15.put("permId", perm5);
        rolePermMapper.insertRelation(map15);
        Map<String, Object> map16 = new HashMap<>();
        map16.put("id", idUtils.nextId());
        map16.put("roleId", teacher);
        map16.put("permId", perm5);
        rolePermMapper.insertRelation(map16);
        Map<String, Object> map17 = new HashMap<>();
        map17.put("id", idUtils.nextId());
        map17.put("roleId", assistant);
        map17.put("permId", perm5);
        rolePermMapper.insertRelation(map17);
        Map<String, Object> map18 = new HashMap<>();
        map18.put("id", idUtils.nextId());
        map18.put("roleId", sysAdmin);
        map18.put("permId", perm5);
        rolePermMapper.insertRelation(map18);
        permMapper.insertPerm(new PermDomain(perm5,"修改密码","修改密码接口","api-userWord-update",2,perm4));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm5, "post", "/ctrl/changeWord/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm5, "primary", "修改密码", 1));
        /*
        点击菜单项加载出的菜单项对应页面应该向后端做一次请求获取菜单项对应页面的内容,比如页面的上的api接口以及接口对应的code以便shiro做出权限的验证

       前端的菜单项由后台提供前端渲染到页面上,前端菜单项对应的页面本身就具有后端的api接口,角色和接口相对应,每一次前端向后端发起请求时,都对请求进行校验,该用户持有的角色中是否具有该api接口
        */

        /* 二级菜单 重置密码 指导老师 系统管理员 */
        String perm6 = String.valueOf(idUtils.nextId());
        Map<String, Object> map19 = new HashMap<>();
        map19.put("id", idUtils.nextId());
        map19.put("roleId", teacherChief);
        map19.put("permId", perm6);
        rolePermMapper.insertRelation(map19);
        Map<String, Object> map20 = new HashMap<>();
        map20.put("id", idUtils.nextId());
        map20.put("roleId", sysAdmin);
        map20.put("permId", perm6);
        rolePermMapper.insertRelation(map20);
        permMapper.insertPerm(new PermDomain(perm6,"重置密码","重置密码菜单","menu-restWord",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm6, "el-icon-menu", 3, "restWord"));

        /*二级菜单按钮 重置密码 指导老师 系统管理员*/
        String perm7 = String.valueOf(idUtils.nextId());
        Map<String, Object> map21 = new HashMap<>();
        map21.put("id", idUtils.nextId());
        map21.put("roleId", teacherChief);
        map21.put("permId", perm7);
        rolePermMapper.insertRelation(map21);
        Map<String, Object> map22 = new HashMap<>();
        map22.put("id", idUtils.nextId());
        map22.put("roleId", sysAdmin);
        map22.put("permId", perm7);
        rolePermMapper.insertRelation(map22);
        permMapper.insertPerm(new PermDomain(perm7,"重置密码","重置密码接口","api-userWord-rest",2,perm6));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm7, "post", "/ctrl/restWord/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm7, "primary", "重置密码", 1));
    }

    @Test
    public void initFeedback () {
        /*
         * 获取反馈记录 - 提交反馈 - 修改反馈 - 删除反馈 - 查看反馈内容
         * 学生 老师 辅导员
         * 获取反馈详情 - 查看反馈内容
         * 部长 主任 指导老师
         *
         * 获取反馈记录 === 通过用户id值进行查询对应用户发布的反馈
         *            === 不传入用户id值就是查询全部的反馈
         *            === 存在权限审查的问题
         * 查询反馈内容 === 通过反馈记录的id值进行查询即可查询对应反馈的内容
         * */
        /*
         * 获取意见列表 - 提交意见(一个标志码,表示院级和校级) - 修改意见 - 删除意见 - 查看意见内容
         * 学生、老师、辅导员
         * 班主任、班长、宿舍长、部门成员(向院宿管提出整改意见)
         * 部长、主任、指导老师(向校宿管提出整改意见)
         *
         * 获取意见详情列表 - 查看意见内容
         * 指导老师 主任 部长 (看到的是院宿管的整改意见)
         * 系统管理员 (看到的是校宿管整改意见)
         * */
        /*
         * 一级菜单 意见反馈
         * 二级菜单 反馈记录
         * 二级菜单接口 获取反馈记录
         * 二级菜单按钮 查看反馈内容 修改反馈内容 删除反馈记录 发布反馈菜单
         * 三级菜单按钮 发布反馈
         * 学生 老师 辅导员
         * 班主任、班长、宿舍长、部门成员 (向院宿管提出整改意见)
         * 部长、主任、指导老师 校级宿管成员 部长 主任 指导老师 (向校宿管提出整改意见,校级宿管成员、部长、主任需要在登录时执行校级、学院两个界面) (暂不实现)
         * 二级菜单 反馈详情
         * 二级菜单接口 获取反馈详情
         * 二级菜单按钮 查看反馈内容
         * 指导老师 主任 部长 (看到的是院宿管的整改意见)
         * 校级宿管成员 部长 主任 指导老师(看到的是校宿管的整改意见)
         * */

        /* 一级菜单 意见反馈 学生 老师 辅导员  */
        String perm1 = String.valueOf(idUtils.nextId());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", idUtils.nextId());
        map1.put("roleId", student);
        map1.put("permId", perm1);
        rolePermMapper.insertRelation(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", idUtils.nextId());
        map2.put("roleId", teacher);
        map2.put("permId", perm1);
        rolePermMapper.insertRelation(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", idUtils.nextId());
        map3.put("roleId", assistant);
        map3.put("permId", perm1);
        rolePermMapper.insertRelation(map3);
        permMapper.insertPerm(new PermDomain(perm1,"意见反馈","意见反馈菜单","menu-feedback",0,null));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm1, "el-icon-tickets", 2, null));

        /* 二级菜单 反馈记录 二级菜单接口 获取反馈记录 学生 老师 辅导员 */
        String perm2 = String.valueOf(idUtils.nextId());
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", idUtils.nextId());
        map4.put("roleId", student);
        map4.put("permId", perm2);
        rolePermMapper.insertRelation(map4);
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", idUtils.nextId());
        map5.put("roleId", teacher);
        map5.put("permId", perm2);
        rolePermMapper.insertRelation(map5);
        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", idUtils.nextId());
        map6.put("roleId", assistant);
        map6.put("permId", perm2);
        rolePermMapper.insertRelation(map6);
        permMapper.insertPerm(new PermDomain(perm2,"反馈记录","意见反馈记录菜单","menu-feedback-record",1,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm2, "el-icon-menu", 1, "feedbackRecord"));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm2, "get", "/ctrl/feedback/record/select"));

        /* 二级菜单按钮 查看反馈内容 修改反馈内容 删除反馈记录  学生 老师 辅导员 */
        String perm4 = String.valueOf(idUtils.nextId());
        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", idUtils.nextId());
        map10.put("roleId", student);
        map10.put("permId", perm4);
        rolePermMapper.insertRelation(map10);
        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", idUtils.nextId());
        map11.put("roleId", teacher);
        map11.put("permId", perm4);
        rolePermMapper.insertRelation(map11);
        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", idUtils.nextId());
        map12.put("roleId", assistant);
        map12.put("permId", perm4);
        rolePermMapper.insertRelation(map12);
        permMapper.insertPerm(new PermDomain(perm4,"删除反馈记录","删除反馈记录接口","api-feedback-record-delete",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm4, "post", "/ctrl/feedback/record/delete"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm4, "warning", "删除", 1));

        String perm5 = String.valueOf(idUtils.nextId());
        Map<String, Object> map13 = new HashMap<>();
        map13.put("id", idUtils.nextId());
        map13.put("roleId", student);
        map13.put("permId", perm5);
        rolePermMapper.insertRelation(map13);
        Map<String, Object> map14 = new HashMap<>();
        map14.put("id", idUtils.nextId());
        map14.put("roleId", teacher);
        map14.put("permId", perm5);
        rolePermMapper.insertRelation(map14);
        Map<String, Object> map15 = new HashMap<>();
        map15.put("id", idUtils.nextId());
        map15.put("roleId", assistant);
        map15.put("permId", perm5);
        rolePermMapper.insertRelation(map15);
        permMapper.insertPerm(new PermDomain(perm5,"修改反馈信息","修改反馈信息接口","api-feedback-record-update",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm5, "post", "/ctrl/feedback/record/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm5, "primary", "修改", 1));

        String perm6 = String.valueOf(idUtils.nextId());
        Map<String, Object> map16 = new HashMap<>();
        map16.put("id", idUtils.nextId());
        map16.put("roleId", student);
        map16.put("permId", perm6);
        rolePermMapper.insertRelation(map16);
        Map<String, Object> map17 = new HashMap<>();
        map17.put("id", idUtils.nextId());
        map17.put("roleId", teacher);
        map17.put("permId", perm6);
        rolePermMapper.insertRelation(map17);
        Map<String, Object> map18 = new HashMap<>();
        map18.put("id", idUtils.nextId());
        map18.put("roleId", assistant);
        map18.put("permId", perm6);
        rolePermMapper.insertRelation(map18);
        permMapper.insertPerm(new PermDomain(perm6,"查看反馈内容","查看反馈内容接口","api-feedback-record-content",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm6, "post", "/ctrl/feedback/record/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm6, "info", "查看", 1));

        /* 二级菜单 反馈详情 获取反馈详情 部长 主任 指导老师  */
        String perm7 = String.valueOf(idUtils.nextId());
        Map<String, Object> map19 = new HashMap<>();
        map19.put("id", idUtils.nextId());
        map19.put("roleId", ministerQin);
        map19.put("permId", perm7);
        rolePermMapper.insertRelation(map19);
        Map<String, Object> map20 = new HashMap<>();
        map20.put("id", idUtils.nextId());
        map20.put("roleId", ministerMi);
        map20.put("permId", perm7);
        rolePermMapper.insertRelation(map20);
        Map<String, Object> map21 = new HashMap<>();
        map21.put("id", idUtils.nextId());
        map21.put("roleId", ministerKao);
        map21.put("permId", perm7);
        rolePermMapper.insertRelation(map21);
        Map<String, Object> map22 = new HashMap<>();
        map22.put("id", idUtils.nextId());
        map22.put("roleId", ministerZhu);
        map22.put("permId", perm7);
        rolePermMapper.insertRelation(map22);
        Map<String, Object> map23 = new HashMap<>();
        map23.put("id", idUtils.nextId());
        map23.put("roleId", teacherChief);
        map23.put("permId", perm7);
        rolePermMapper.insertRelation(map23);
        permMapper.insertPerm(new PermDomain(perm7,"反馈详情","意见反馈详情菜单","menu-feedback-detail",1,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm7, "el-icon-menu", 2, "feedbackDetail"));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm7, "get", "/ctrl/feedback/detail/select"));

        /* 二级菜单接口 查看反馈内容 部长 主任 指导老师 */
        String perm8 = String.valueOf(idUtils.nextId());
        Map<String, Object> map24 = new HashMap<>();
        map24.put("id", idUtils.nextId());
        map24.put("roleId", ministerQin);
        map24.put("permId", perm8);
        rolePermMapper.insertRelation(map24);
        Map<String, Object> map25 = new HashMap<>();
        map25.put("id", idUtils.nextId());
        map25.put("roleId", ministerMi);
        map25.put("permId", perm8);
        rolePermMapper.insertRelation(map25);
        Map<String, Object> map26 = new HashMap<>();
        map26.put("id", idUtils.nextId());
        map26.put("roleId", ministerKao);
        map26.put("permId", perm8);
        rolePermMapper.insertRelation(map26);
        Map<String, Object> map27 = new HashMap<>();
        map27.put("id", idUtils.nextId());
        map27.put("roleId", ministerZhu);
        map27.put("permId", perm8);
        rolePermMapper.insertRelation(map27);
        Map<String, Object> map28 = new HashMap<>();
        map28.put("id", idUtils.nextId());
        map28.put("roleId", teacherChief);
        map28.put("permId", perm8);
        rolePermMapper.insertRelation(map28);
        permMapper.insertPerm(new PermDomain(perm8,"查看反馈详情内容","查看反馈详情内容接口","api-feedback-detail-detail",2,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm8, "post", "/ctrl/feedback/detail/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm8, "info", "查看", 1));

        /* 发布反馈菜单 发布反馈 学生老师 辅导员 */
        String perm9 = String.valueOf(idUtils.nextId());
        Map<String, Object> map29 = new HashMap<>();
        map29.put("id", idUtils.nextId());
        map29.put("roleId", student);
        map29.put("permId", perm9);
        rolePermMapper.insertRelation(map29);
        Map<String, Object> map30 = new HashMap<>();
        map30.put("id", idUtils.nextId());
        map30.put("roleId", teacher);
        map30.put("permId", perm9);
        rolePermMapper.insertRelation(map30);
        Map<String, Object> map31 = new HashMap<>();
        map31.put("id", idUtils.nextId());
        map31.put("roleId", assistant);
        map31.put("permId", perm9);
        rolePermMapper.insertRelation(map31);
        permMapper.insertPerm(new PermDomain(perm9,"提交反馈内容","提交反馈内容菜单","menu-feedback-record-release",0,perm2));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm9, "新增", 1, "feedbackRelease"));

        String perm3 = String.valueOf(idUtils.nextId());
        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", idUtils.nextId());
        map7.put("roleId", student);
        map7.put("permId", perm3);
        rolePermMapper.insertRelation(map7);
        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", idUtils.nextId());
        map8.put("roleId", teacher);
        map8.put("permId", perm3);
        rolePermMapper.insertRelation(map8);
        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", idUtils.nextId());
        map9.put("roleId", assistant);
        map9.put("permId", perm3);
        rolePermMapper.insertRelation(map9);
        permMapper.insertPerm(new PermDomain(perm3,"提交反馈内容","提交反馈内容接口","api-feedback-record-submit",2,perm9));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm3, "post", "/ctrl/feedback/record/submit"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm3, "primary", "提交", 1));
    }

    @Test
    public void initRepair () {
        /*
        * 一级菜单 宿舍报修 -- 宿舍长 指导老师
        * 二级菜单 报修记录 -- 宿舍长
        * 二级菜单接口 获取报修记录 -- 宿舍长
        * 二级菜单按钮 查看报修内容 修改报修内容 删除报修记录 -- 宿舍长
        * 三级菜单按钮 添加报修修记录 -- 宿舍长
        * 三级菜单按钮 提交报修记录 -- 宿舍长
        * 二级菜单 报修详情 -- 指导老师
        * 二级菜单接口 获取报修详情 -- 指导老师
        * 二级菜单按钮 查看报修内容 -- 指导老师
        * */
        /* 一级菜单 宿舍报修 -- 宿舍长 指导老师 */
        String perm1 = String.valueOf(idUtils.nextId());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", idUtils.nextId());
        map1.put("roleId", dorHead);
        map1.put("permId", perm1);
        rolePermMapper.insertRelation(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", idUtils.nextId());
        map2.put("roleId", teacherChief);
        map2.put("permId", perm1);
        rolePermMapper.insertRelation(map2);
        permMapper.insertPerm(new PermDomain(perm1,"宿舍报修","宿舍报修菜单","menu-repair",0,null));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm1, "el-icon-tickets", 3, null));

        /* 二级菜单 报修记录  二级菜单接口 获取报修记录 -- 宿舍长 */
        String perm2 = String.valueOf(idUtils.nextId());
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", idUtils.nextId());
        map3.put("roleId", dorHead);
        map3.put("permId", perm2);
        rolePermMapper.insertRelation(map3);
        permMapper.insertPerm(new PermDomain(perm2,"报修记录","报修记录菜单","menu-repair-record",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm2, "el-icon-menu", 1, "repairRecord"));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm2, "get", "/ctrl/repair/record/select"));

        /* 二级菜单按钮 查看报修内容 修改报修内容 删除报修记录 -- 宿舍长 */
        String perm3 = String.valueOf(idUtils.nextId());
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", idUtils.nextId());
        map4.put("roleId", dorHead);
        map4.put("permId", perm3);
        rolePermMapper.insertRelation(map4);
        permMapper.insertPerm(new PermDomain(perm3,"查看报修内容","查看报修内容接口","api-repair-record-content",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm3, "post", "/ctrl/repair/record/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm3, "info", "查看", 1));

        String perm4 = String.valueOf(idUtils.nextId());
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", idUtils.nextId());
        map5.put("roleId", dorHead);
        map5.put("permId", perm4);
        rolePermMapper.insertRelation(map5);
        permMapper.insertPerm(new PermDomain(perm4,"修改报修信息","修改报修信息接口","api-repair-record-update",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm4, "post", "/ctrl/repair/record/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm4, "primary", "修改", 1));

        String perm5 = String.valueOf(idUtils.nextId());
        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", idUtils.nextId());
        map6.put("roleId", dorHead);
        map6.put("permId", perm5);
        rolePermMapper.insertRelation(map6);
        permMapper.insertPerm(new PermDomain(perm5,"删除报修记录","删除报修记录接口","api-repair-record-delete",2,perm2));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm5, "post", "/ctrl/repair/record/delete"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm5, "warning", "删除", 1));

        /* 三级菜单按钮 添加报修修记录  三级菜单按钮 提交报修记录 -- 宿舍长 */
        String perm6 = String.valueOf(idUtils.nextId());
        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", idUtils.nextId());
        map7.put("roleId", dorHead);
        map7.put("permId", perm6);
        rolePermMapper.insertRelation(map7);
        permMapper.insertPerm(new PermDomain(perm6,"提交报修记录","提交报修记录菜单","menu-repair-record-submit",0,perm2));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm6, "新增", 1, "repairRecord"));

        String perm7 = String.valueOf(idUtils.nextId());
        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", idUtils.nextId());
        map8.put("roleId", dorHead);
        map8.put("permId", perm7);
        rolePermMapper.insertRelation(map8);
        permMapper.insertPerm(new PermDomain(perm7,"提交报修内容","提交报修内容接口","api-repair-record-submit",2,perm6));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm7, "post", "/ctrl/repair/record/submit"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm7, "primary", "提交", 1));

        /* 二级菜单 报修详情 二级菜单接口 获取报修详情 -- 指导老师 */
        String perm8 = String.valueOf(idUtils.nextId());
        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", idUtils.nextId());
        map9.put("roleId", teacherChief);
        map9.put("permId", perm8);
        rolePermMapper.insertRelation(map9);
        permMapper.insertPerm(new PermDomain(perm8,"报修详情","报修详情菜单","menu-repair-detail",1,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm8, "el-icon-menu", 2, "repairDetail"));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm6, "get", "/ctrl/repair/detail/select"));

        /* 二级菜单按钮 查看报修内容 -- 指导老师 */
        String perm9 = String.valueOf(idUtils.nextId());
        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", idUtils.nextId());
        map10.put("roleId", teacherChief);
        map10.put("permId", perm9);
        rolePermMapper.insertRelation(map10);
        permMapper.insertPerm(new PermDomain(perm9,"查看报修详情内容","查看报修详情内容接口","api-repair-detail-detail",2,perm8));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm9, "get", "/ctrl/repair/detail/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm9, "info", "查看", 1));
    }
    /*
    * 先把个人中心 意见反馈 宿舍报修 菜单页面同步做好 再继续 做 之后的api 菜单项 不然又是一会写一会又改的情况一天到晚全是无用功
    * */
    @Test
    public void initCaseMenu () {
        /*
         * 例检 --- 证明申请
         * 班长
         * - 审批证明
         * 班主任
         * - 结果记录 - 证明记录
         * 寝工部部门成员 寝工部部长
         * - 细则
         * 寝工部部长
         * - 通报
         * 考核部部门成员 考核部部长
         * */
        String perm1 = String.valueOf(idUtils.nextId());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", idUtils.nextId());
        map1.put("roleId", classHead);
        map1.put("permId", perm1);
        rolePermMapper.insertRelation(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", idUtils.nextId());
        map2.put("roleId", classChief);
        map2.put("permId", perm1);
        rolePermMapper.insertRelation(map2);
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", idUtils.nextId());
        map3.put("roleId", memberQin);
        map3.put("permId", perm1);
        rolePermMapper.insertRelation(map3);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", idUtils.nextId());
        map4.put("roleId", ministerQin);
        map4.put("permId", perm1);
        rolePermMapper.insertRelation(map4);
        permMapper.insertPerm(new PermDomain(perm1,"例检","例检菜单","menu-case",0,null));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm1, "el-icon-tickets", 4, null));

        String perm2 = String.valueOf(idUtils.nextId());
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", idUtils.nextId());
        map5.put("roleId", classHead);
        map5.put("permId", perm2);
        rolePermMapper.insertRelation(map5);
        permMapper.insertPerm(new PermDomain(perm2,"证明申请","证明申请菜单","menu-case-apply",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm2, "el-icon-menu", 1, "caseApply"));

        String perm3 = String.valueOf(idUtils.nextId());
        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", idUtils.nextId());
        map6.put("roleId", classChief);
        map6.put("permId", perm3);
        rolePermMapper.insertRelation(map6);
        permMapper.insertPerm(new PermDomain(perm3,"审批证明","审批证明菜单","menu-case-reply",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm3, "el-icon-menu", 2, "caseReply"));

        String perm4 = String.valueOf(idUtils.nextId());
        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", idUtils.nextId());
        map7.put("roleId", memberQin);
        map7.put("permId", perm4);
        rolePermMapper.insertRelation(map7);
        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", idUtils.nextId());
        map8.put("roleId", ministerQin);
        map8.put("permId", perm4);
        rolePermMapper.insertRelation(map8);
        permMapper.insertPerm(new PermDomain(perm4,"结果记录","结果记录菜单","menu-case-res",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm4, "el-icon-menu", 3, "caseRes"));

        String perm5 = String.valueOf(idUtils.nextId());
        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", idUtils.nextId());
        map9.put("roleId", memberQin);
        map9.put("permId", perm5);
        rolePermMapper.insertRelation(map9);
        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", idUtils.nextId());
        map10.put("roleId", ministerQin);
        map10.put("permId", perm5);
        rolePermMapper.insertRelation(map10);
        permMapper.insertPerm(new PermDomain(perm5,"证明记录","证明记录菜单","menu-case-reply-record",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm5, "el-icon-menu", 4, "caseApplyRecord"));

        String perm6 = String.valueOf(idUtils.nextId());
        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", idUtils.nextId());
        map11.put("roleId", ministerQin);
        map11.put("permId", perm6);
        rolePermMapper.insertRelation(map11);
        permMapper.insertPerm(new PermDomain(perm6,"细则","细则菜单","menu-case-rules",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm6, "el-icon-menu", 5, "caseRules"));

        String perm7 = String.valueOf(idUtils.nextId());
        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", idUtils.nextId());
        map12.put("roleId", memberKao);
        map12.put("permId", perm7);
        rolePermMapper.insertRelation(map12);
        Map<String, Object> map13 = new HashMap<>();
        map13.put("id", idUtils.nextId());
        map13.put("roleId", ministerKao);
        map13.put("permId", perm7);
        rolePermMapper.insertRelation(map13);
        permMapper.insertPerm(new PermDomain(perm7,"通报记录","通报记录菜单","menu-case-criticize",0,perm1));
        ctrlMenuMapper.insertMenu(new CtrlMenuDomain(perm7, "el-icon-menu", 6, "caseCriticize"));
    }

    @Test
    public void initCaseApis () {
        /*
         * 获取证明申请记录 - 提交证明申请 - 修改证明申请 - 删除证明申请(已批准不可删除 point) - 查看证明申请内容
         * 班长
         * - 获取证明申请记录 - 审批证明申请
         * 班主任
         * - 获取例检结果记录 - 修改例检结果(已发布成员不可修改 point) - 提交例检结果
         * 寝工部部门成员
         * - 发布例检结果(point) 删除例检结果
         * 寝工部部长
         * - 获取例检通报 - 修改例检通报(已发布成员不可修改 point) - 提交例检通报
         * 考核部部门成员
         * - 发布例检通报(point) 删除例检结果
         * 考核部部长
         * */
        String perm1 = String.valueOf(idUtils.nextId());
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", idUtils.nextId());
        map1.put("roleId", classHead);
        map1.put("permId", perm1);
        rolePermMapper.insertRelation(map1);
        permMapper.insertPerm(new PermDomain(perm1,"获取例检证明申请记录","获取例检证明申请记录接口","api-case-apply-select",2,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm1, "get", "/ctrl/case/apply/select"));

        String perm2 = String.valueOf(idUtils.nextId());
        Map<String, Object> map2 = new HashMap<>();
        map2.put("id", idUtils.nextId());
        map2.put("roleId", classHead);
        map2.put("permId", perm2);
        rolePermMapper.insertRelation(map2);
        permMapper.insertPerm(new PermDomain(perm2,"提交证明申请","提交证明申请接口","api-case-apply-submit",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm2, "post", "/ctrl/case/apply/submit"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm2, "primary", "提交", 1));

        String perm3 = String.valueOf(idUtils.nextId());
        Map<String, Object> map3 = new HashMap<>();
        map3.put("id", idUtils.nextId());
        map3.put("roleId", classHead);
        map3.put("permId", perm3);
        rolePermMapper.insertRelation(map3);
        permMapper.insertPerm(new PermDomain(perm3,"删除证明申请记录","删除证明申请记录接口","api-case-apply-delete",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm3, "post", "/ctrl/case/apply/delete"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm3, "warning", "删除", 1));

        String perm4 = String.valueOf(idUtils.nextId());
        Map<String, Object> map4 = new HashMap<>();
        map4.put("id", idUtils.nextId());
        map4.put("roleId", dorHead);
        map4.put("permId", perm4);
        rolePermMapper.insertRelation(map4);
        permMapper.insertPerm(new PermDomain(perm4,"修改证明申请信息","修改证明申请信息接口","api-case-apply-update",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm4, "post", "/ctrl/case/apply/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm4, "primary", "修改", 1));

        String perm5 = String.valueOf(idUtils.nextId());
        Map<String, Object> map5 = new HashMap<>();
        map5.put("id", idUtils.nextId());
        map5.put("roleId", classHead);
        map5.put("permId", perm5);
        rolePermMapper.insertRelation(map5);
        permMapper.insertPerm(new PermDomain(perm5,"查看证明申请内容","查看证明申请内容接口","api-case-apply-content",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm5, "post", "/ctrl/case/apply/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm5, "info", "查看", 1));

        String perm6 = String.valueOf(idUtils.nextId());
        Map<String, Object> map6 = new HashMap<>();
        map6.put("id", idUtils.nextId());
        map6.put("roleId", classChief);
        map6.put("permId", perm6);
        rolePermMapper.insertRelation(map6);
        permMapper.insertPerm(new PermDomain(perm6,"获取证明申请详情","获取证明申请详情接口","api-case-apply-detail-select",2,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm6, "get", "/ctrl/case/apply/detail/select"));

        String perm7 = String.valueOf(idUtils.nextId());
        Map<String, Object> map7 = new HashMap<>();
        map7.put("id", idUtils.nextId());
        map7.put("roleId", classChief);
        map7.put("permId", perm7);
        rolePermMapper.insertRelation(map7);
        permMapper.insertPerm(new PermDomain(perm7,"查看证明申请详情内容","查看证明申请详情内容接口","api-case-apply-detail-content",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm7, "get", "/ctrl/case/detail/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm7, "info", "查看", 1));

        String perm8 = String.valueOf(idUtils.nextId());
        Map<String, Object> map8 = new HashMap<>();
        map8.put("id", idUtils.nextId());
        map8.put("roleId", classChief);
        map8.put("permId", perm8);
        rolePermMapper.insertRelation(map8);
        permMapper.insertPerm(new PermDomain(perm8,"审批证明申请","审批证明申请详接口","api-case-detail-reply",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm8, "post", "/ctrl/case/detail/reply/approval"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm8, "primary", "批准", 1));

        String perm81 = String.valueOf(idUtils.nextId());
        Map<String, Object> map81 = new HashMap<>();
        map8.put("id", idUtils.nextId());
        map8.put("roleId", classChief);
        map8.put("permId", perm8);
        rolePermMapper.insertRelation(map8);
        permMapper.insertPerm(new PermDomain(perm81,"审批证明申请","审批证明申请详接口","api-case-detail-reply",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm81, "post", "/ctrl/case/detail/reply/reject"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm81, "warning", "驳回", 1));

        String perm9 = String.valueOf(idUtils.nextId());
        Map<String, Object> map9 = new HashMap<>();
        map9.put("id", idUtils.nextId());
        map9.put("roleId", memberQin);
        map9.put("permId", perm9);
        rolePermMapper.insertRelation(map9);
        permMapper.insertPerm(new PermDomain(perm9,"获取例检结果记录","获取例检结果记录接口","api-case-res-select",2,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm9, "get", "/ctrl/case/res/select"));

        String perm10 = String.valueOf(idUtils.nextId());
        Map<String, Object> map10 = new HashMap<>();
        map10.put("id", idUtils.nextId());
        map10.put("roleId", memberQin);
        map10.put("permId", perm10);
        rolePermMapper.insertRelation(map10);
        permMapper.insertPerm(new PermDomain(perm10,"提交例检结果记录","提交例检结果记录接口","api-case-res-submit",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm10, "post", "/ctrl/case/res/submit"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm10, "primary", "提交", 1));

        String perm11 = String.valueOf(idUtils.nextId());
        Map<String, Object> map11 = new HashMap<>();
        map11.put("id", idUtils.nextId());
        map11.put("roleId", memberQin);
        map11.put("permId", perm11);
        rolePermMapper.insertRelation(map11);
        permMapper.insertPerm(new PermDomain(perm11,"修改例检结果","修改例检结果接口","api-case-res-update",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm11, "post", "/ctrl/case/res/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm11, "primary", "修改", 1));

        String perm12 = String.valueOf(idUtils.nextId());
        Map<String, Object> map12 = new HashMap<>();
        map12.put("id", idUtils.nextId());
        map12.put("roleId", memberQin);
        map12.put("permId", perm12);
        rolePermMapper.insertRelation(map12);
        permMapper.insertPerm(new PermDomain(perm12,"查看例检结果内容记录","查看例检结果内容接口","api-case-res-content",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm12, "post", "/ctrl/case/res/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm12, "info", "查看", 1));

        String perm13 = String.valueOf(idUtils.nextId());
        Map<String, Object> map13 = new HashMap<>();
        map13.put("id", idUtils.nextId());
        map13.put("roleId", ministerQin);
        map13.put("permId", perm13);
        rolePermMapper.insertRelation(map13);
        permMapper.insertPerm(new PermDomain(perm13,"发布例检结果","发布例检结果接口","api-case-res-release",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm13, "post", "/ctrl/case/res/release"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm13, "success", "发布", 1));

        String perm14 = String.valueOf(idUtils.nextId());
        Map<String, Object> map14 = new HashMap<>();
        map14.put("id", idUtils.nextId());
        map14.put("roleId", ministerQin);
        map14.put("permId", perm14);
        rolePermMapper.insertRelation(map14);
        permMapper.insertPerm(new PermDomain(perm14,"删除例检结果","删除例检结果接口","api-case-res-delete",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm14, "post", "/ctrl/case/res/delete"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm14, "warning", "删除", 1));

        String perm15 = String.valueOf(idUtils.nextId());
        Map<String, Object> map15 = new HashMap<>();
        map15.put("id", idUtils.nextId());
        map15.put("roleId", memberKao);
        map15.put("permId", perm15);
        rolePermMapper.insertRelation(map15);
        permMapper.insertPerm(new PermDomain(perm15,"获取例检通报记录","获取例检通报记录接口","api-case-criticize-select",2,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm15, "get", "/ctrl/case/criticize/select"));

        String perm16 = String.valueOf(idUtils.nextId());
        Map<String, Object> map16 = new HashMap<>();
        map16.put("id", idUtils.nextId());
        map16.put("roleId", memberKao);
        map16.put("permId", perm16);
        rolePermMapper.insertRelation(map16);
        permMapper.insertPerm(new PermDomain(perm16,"提交例检通报记录","提交例检通报记录接口","api-case-criticize-submit",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm16, "post", "/ctrl/case/criticize/submit"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm16, "primary", "提交", 1));

        String perm17 = String.valueOf(idUtils.nextId());
        Map<String, Object> map17 = new HashMap<>();
        map17.put("id", idUtils.nextId());
        map17.put("roleId", memberKao);
        map17.put("permId", perm17);
        rolePermMapper.insertRelation(map17);
        permMapper.insertPerm(new PermDomain(perm17,"修改例检通报","修改例检通报接口","api-case-criticize-update",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm17, "post", "/ctrl/case/criticize/update"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm17, "primary", "修改", 1));

        String perm18 = String.valueOf(idUtils.nextId());
        Map<String, Object> map18 = new HashMap<>();
        map18.put("id", idUtils.nextId());
        map18.put("roleId", memberKao);
        map18.put("permId", perm18);
        rolePermMapper.insertRelation(map18);
        permMapper.insertPerm(new PermDomain(perm18,"查看例检通报内容记录","查看例检通报内容接口","api-case-criticize-content",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm18, "post", "/ctrl/case/criticize/content"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm18, "info", "查看", 1));

        String perm19 = String.valueOf(idUtils.nextId());
        Map<String, Object> map19 = new HashMap<>();
        map19.put("id", idUtils.nextId());
        map19.put("roleId", ministerKao);
        map19.put("permId", perm19);
        rolePermMapper.insertRelation(map19);
        permMapper.insertPerm(new PermDomain(perm19,"发布例检通报","发布例检通报接口","api-case-criticize-release",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm19, "post", "/ctrl/case/criticize/release"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm19, "success", "发布", 1));

        String perm20 = String.valueOf(idUtils.nextId());
        Map<String, Object> map20 = new HashMap<>();
        map20.put("id", idUtils.nextId());
        map20.put("roleId", ministerKao);
        map20.put("permId", perm20);
        rolePermMapper.insertRelation(map20);
        permMapper.insertPerm(new PermDomain(perm20,"删除例检通报","删除例检通报接口","api-case-criticize-delete",1,null));
        ctrlApisMapper.insertApi(new CtrlApisDomain(perm20, "post", "/ctrl/case/criticize/delete"));
        ctrlPointMapper.insertPoint(new CtrlPointDomain(perm20, "warning", "删除", 1));
    }

    /* 清空所有的 menu api point perm 表重新导入数据 */
}
