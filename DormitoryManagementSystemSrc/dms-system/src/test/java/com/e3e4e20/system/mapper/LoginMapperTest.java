package com.e3e4e20.system.mapper;

import com.e3e4e20.common.pojo.LoginDomain;
import com.e3e4e20.model.mapper.LoginMapper;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Filename: com.e3e4e20.system.mapper
 * Description: LoginMapper 接口测试
 * Version: 1.0
 * Created: 2020-04-06 15:07 星期一
 * Revision: none
 * Compiler: none
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class LoginMapperTest {
    @Autowired
    LoginMapper loginMapper;
    @Test
    public void selectIdByIdTest (){
        System.out.println(loginMapper.selectIdById("16478080"));
    }
    @Test
    public void selectByIdWordTest (){
        System.out.println(loginMapper.selectByIdWord("16478080", new Md5Hash("Jcx.1999+", "16478080", 3).toBase64()));
    }
    @Test
    public void insertIdWordTest () {
        LoginDomain loginDomain1 = new LoginDomain("16478060", new Md5Hash("Cwq.1998+", "16478060", 3).toBase64());
        LoginDomain loginDomain2 = new LoginDomain("16478067", new Md5Hash("Lyf.1997+", "16478067", 3).toBase64());
        LoginDomain loginDomain3 = new LoginDomain("16478080", new Md5Hash("Jcx.1999+", "16478080", 3).toBase64());
        LoginDomain loginDomain4 = new LoginDomain("16478081", new Md5Hash("Gpc.1997+", "16478081", 3).toBase64());
        LoginDomain loginDomain5 = new LoginDomain("16478082", new Md5Hash("Yl.1997+", "16478082", 3).toBase64());
        loginMapper.insertIdWord(loginDomain1);
        loginMapper.insertIdWord(loginDomain2);
        loginMapper.insertIdWord(loginDomain3);
        loginMapper.insertIdWord(loginDomain4);
        loginMapper.insertIdWord(loginDomain5);
    }
    @Test
    public void updateByIdTest () {
        loginMapper.updateById(new LoginDomain("16478080",new Md5Hash("Jcx.1999+", "16478080", 3).toBase64()));
    }
    @Test
    public void deleteByIdTest () {
        loginMapper.deleteById("16478081");
    }
}
