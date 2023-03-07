package com.e3e4e20.home.service;

import com.e3e4e20.common.pojo.HomeIntroduceDomain;
import com.e3e4e20.model.service.HomeIntroduceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Description:
 * Created: 2020-04-19 14:42 星期日
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class IntroduceServiceTest {
    @Autowired
    HomeIntroduceService homeIntroduceService;
    @Test
    public void introduceTest (){
        homeIntroduceService.addIntroduce(new HomeIntroduceDomain(
                0,
                "信息与计算机工程学院宿管委员会简介",
                "信息与计算机工程学院宿管委员会成立于2017年11月11日,前身为信息与计算机工程学院团总支学生分会宿管部;宿管委员会下设寝工部、秘书部、考核部三个部门,由指导老师、主任、部长及部门成员组成。",
                "../../assets/images/img_00.jpg",
                "寝工部负责例检、抽检及相关工作。",
                "../../assets/images/img_01.jpg",
                "秘书部负责反馈、报修、宿管日常工作记录及相关工作。",
                "../../assets/images/img_02.jpg",
                "考核部负责通报、晚归、考评及相关工作。",
                "../../assets/images/img_03.jpg"
        ));
    }
}
