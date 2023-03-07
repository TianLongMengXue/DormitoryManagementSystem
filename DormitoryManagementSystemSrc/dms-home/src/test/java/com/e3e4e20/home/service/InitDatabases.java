package com.e3e4e20.home.service;

import com.e3e4e20.common.utils.IdUtils;
import com.e3e4e20.model.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Description:
 * Created: 2020-04-18 14:12 星期六
 * Author: DreamSnow·Draco
 * Company: none
 * */
@SpringBootTest
public class InitDatabases {
    @Autowired
    HomeArticleService homeArticleService;
    @Autowired
    CaseService caseService;
    @Autowired
    NightService nightService;
    @Autowired
    StarService starService;
    @Autowired
    CivilService civilService;
    @Autowired
    CheckClassService checkClassService;
    @Autowired
    CriticizeService criticizeService;
    IdUtils id = new IdUtils();
    @Test
    public void init () {
        // 0:简介,1:综合,2:例检,3:抽检,4:晚归,5:考评,6:宿管公告,7:下载
        String collegeId = "1250317154721492992";
        // 3通报 + 4例检 + 1抽检 + 1文明 + 1星级 + 1班级考评 + 1晚归 = 12次
        String articleId1 = String.valueOf(id.nextId());
        String articleId2 = String.valueOf(id.nextId());
        String articleId3 = String.valueOf(id.nextId());
        String articleId4 = String.valueOf(id.nextId());
        String articleId5 = String.valueOf(id.nextId());
        String articleId6 = String.valueOf(id.nextId());
        String articleId7 = String.valueOf(id.nextId());
        String articleId8 = String.valueOf(id.nextId());
        String articleId9 = String.valueOf(id.nextId());
        String articleId10 = String.valueOf(id.nextId());
        String articleId11 = String.valueOf(id.nextId());
        String articleId12 = String.valueOf(id.nextId());

        /*
         * 初始化 通报 文章列表一
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId1,collegeId,2,"ArticleDetailCriticize",new Date(),null,
                "信息与计算机工程学院第十四周通报批评", "第十四周例检中，共计7位未叠被子、2个差寝","宿管委员会考核部"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId1,"2018年6月4日周一例检:","15软工2班", "未叠被子:杨燕峻、林高翔、蒋明宏、廖先斌、施晓东"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId1,"2018年6月4日周一例检:","17数媒班", "未叠被子:李翔、杨政立"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId1,"2018年6月4日周一例检:","15软工2班", "寝室差寝(6-311):罗家苗、杨文龙、杨燕峻、林高翔、龚俊霖、蒋明宏"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId1,"2018年6月4日周一例检:","15软工2/15软工1/17数媒班", "寝室差寝(6-314):廖先斌、施晓东、邹忠诚、樊照辉、易道鑫、李翔"));*/

        /*
         * 初始化 通报 文章列表二
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId2,collegeId,2,"ArticleDetailCriticize",new Date(),null,
                "信息与计算机工程学院第十五周通报批评", "第十五周例检中，共计12位未叠被子","宿管委员会考核部"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId2,"2018年6月11日周一例检:", "15软工2班", "未叠被子:况永锋、廖阳阳、施晓东"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId2,"2018年6月11日周一例检:", "16软件2班", "未叠被子:廖志成、郭伦钰、肖斌"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId2,"2018年6月11日周一例检:", "16软工1班", "未叠被子:黄中平"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId2,"2018年6月13日周三例检:", "15软工2班", "未叠被子:林高翔"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId2,"2018年6月13日周三例检:", "16软工1班", "未叠被子:孙立鑫、高飞"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId2,"2018年6月13日周三例检:", "16软工2班", "未叠被子:万少波、吴彬"));*/

        /*
         * 初始化 通报 文章列表三
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId3,collegeId,2,"ArticleDetailCriticize",new Date(),
                null,
                "信息与计算机工程学院第十六周通报批评", "第十六周例检中，共计1位未叠被子","宿管委员会考核部"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId3,"2018年6月20日周一例检:","16软工1班","未叠被子：王小杰"));*/

        /*
         * 初始化 例检 文章列表一
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId4, collegeId, 2,"ArticleDetailCase", new Date(), new Date(2018, 6
                , 4), "信息与计算机工程学院寝室例检卫生结果通报", "2018年6月4日周三下午16点30分学院例检，本次例检检查结果共计60个好寝，2个差寝","宿管委员会寝工部"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId4, "1栋", "1-201", "17数媒", 9.5, null, "刘琪", "师溱明"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId4, "1栋", "1-202", "17数媒", 9.0, "物品摆放不整齐", "刘琪", "杨珍"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId4, "1栋", "1-203", "17数媒", 9.0, "物品摆放不整齐", "刘琪", "李蕊"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId4, "1栋", "1-204", "17数媒", 9.5, null, "刘琪", "李娇"));*/

        /*
         * 初始化 例检 文章列表二
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId5,collegeId,2,"ArticleDetailCase",new Date(),new Date(2018, 6,
                6),"信息与计算机工程学院寝室例检卫生结果通报", "2018年6月6日周三下午16点30分学院例检，本次例检检查结果共计63个好寝，0个差寝","宿管委员会寝工部"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId5, "2栋", "2-701", "17数媒", 9.5,
                null, "刘琪、刘坚", "王永凤"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId5, "2栋", "2-702", "17软件1/17软件2"
                , 9.0, "桌面摆放不整齐", "刘坚、黎元钢", "陈芷晴"));*/

        /*
         * 初始化 例检 文章列表三
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId6,collegeId,2,"ArticleDetailCase",new Date(),new Date(2018,6,
                11),"信息与计算机工程学院寝室例检卫生结果通报","2018年6月6日周三下午16点30分学院例检，本次例检检查结果共计53个好寝，0个差寝","宿管委员会寝工部"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId6, "11栋", "11-701", "17数媒(本)",
                9.5, null, "孙正广", "张莹"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId6, "11栋", "11-702", "17数媒(本)",
                9.5, null, "孙正广", "祝悦"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId6, "11栋", "11-703", "17数媒(本)" +
                "/17软件2", 9.5, null, "孙正广、黎元钢", "傅思梦"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId6, "11栋", "11-704", "17软件2",
                9.5, null, "黎元钢", "曾诗雅"));*/

        /*
         * 初始化 例检 文章列表四
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId7,collegeId,2,"ArticleDetailCase",new Date(),new Date(2018,6,
                11),"信息与计算机工程学院寝室例检卫生结果通报","2018年6月6日周三下午16点30分学院例检，本次例检检查结果共计53个好寝，0个差寝","宿管委员会寝工部"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-901", "16" +
                "信管", 8.5, "物品摆放不整齐，整体形象较差", "刘坚", "张正义"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-902", "16" +
                "信管", 8.0, "地面脏乱，物品摆放不整齐，整体形象较差", "刘坚", "王天旭"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-903", "16" +
                "信管/16软件2", 8.5, "物品摆放不整齐，整体形象较差", "刘坚、吴新华", "江国洲"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-904", "17" +
                "数媒(本)", 8.5, "物品摆放不整齐，整体形象较差", "孙正广", "高勇"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-1001", "16" +
                "软件2", 8.0, "①号床廖志成被子未叠，地面脏乱，整体形象较差", "吴新华", "蔡杭"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-1002", "16" +
                "软件1", 8.0, "物品摆放不整齐，垃圾未倒，整体形象较差", "肖咪咪", "李国胜"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-1003", "16" +
                "软件1", 8.0, "物品摆放不整齐，垃圾未倒，整体形象较差", "肖咪咪", "叶春晖"));
        caseService.insertRecord(new CaseDomain(String.valueOf(id.nextId()), articleId7, "19栋(一单元)", "19-1-1004", "16" +
                "软件1", 8.0, "物品摆放不整齐，垃圾未倒，整体形象较差", "肖咪咪", "马志强"));*/

        /*
         * 初始化 抽检 文章列表一
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId8,collegeId,3,"ArticleDetailCriticize",
                new Date(),null,
                "信息与计算机工程学院第十六周通报批评",
                "第十六周抽检中，共计4位未叠被子","宿管委员会考核部"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId8,"2017年12月17日抽检情况：",
                "15软工2班","未叠被子:刘花朵"));
        criticizeService.insertRecord(new CriticizeDomain(String.valueOf(id.nextId()),articleId8,"2017年12月18日抽检情况：",
                "16信管班","未叠被子:曹阮香、易心茹、钟萍红"));

        *//*
         *  初始化 文明 文章列表
         *//*
        homeArticleService.insertArticle(new HomeArticleDomain(articleId9,collegeId,5,
                "ArticleDetailCivil",new Date(),null,"信息与计算机工程学院2018" +
                "年6月文明宿舍汇总表", "信息与计算机工程学院2018年6月共计评选23个文明宿舍","宿管委员会考核部"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"1-203","信息与计算机工程学院","刘琪", "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"1-204","信息与计算机工程学院","刘琪",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"2-701","信息与计算机工程学院","刘琪、刘坚",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"11-702","信息与计算机工程学院","孙正广",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"11-703","信息与计算机工程学院","孙正广、黎元钢",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"11-704","信息与计算机工程学院","黎元钢",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"13-121","信息与计算机工程学院","黄检文、刘坚",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"13-122","信息与计算机工程学院","黄检文",
                "黎元钢"
                ,"文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"13-207","信息与计算机工程学院","肖咪咪",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"13-210","信息与计算机工程学院","蔡方萍",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"13-211","信息与计算机工程学院","刘熹、蔡方萍",
                "肖咪咪、黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"13-212","信息与计算机工程学院","刘坚",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"6-416","信息与计算机工程学院","刘琪",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"6-510","信息与计算机工程学院","刘坚",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"6-512","信息与计算机工程学院","刘坚",
                "黎元钢"
                ,"文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"6-513","信息与计算机工程学院","刘坚",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"6-515","信息与计算机工程学院","刘坚、黎元钢",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"19-3-912","信息与计算机工程学院","蔡方萍、刘琪",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"20-4-516","信息与计算机工程学院","彭新平",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"20-4-613","信息与计算机工程学院","彭新平",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"20-4-614","信息与计算机工程学院","彭新平",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"20-4-615","信息与计算机工程学院","彭新平",
                "黎元钢","文明寝室"));
        civilService.insertRecord(new CivilDomain(String.valueOf(id.nextId()),articleId9,"20-4-1015","信息与计算机工程学院","黎元钢",
                "黎元钢","文明寝室"));*/

        /*
         * 初始化 星级 文章列表
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId10,collegeId,5,"ArticleDetailStar",new Date(),
                null,
                "信息与计算机工程学院2018年6月星级寝室汇总表", "信息与计算机工程学院2018年6月共计评选76个三星级、13个二星级、2个一星级宿舍","宿管委员会考核部"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"1-201",95,90,95,95,90,null, null,null,65.1,30.0,95.1,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"1-202",90,85,95,90,85,null,
                null,null,63.2,30.0,92.3,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"1-203",90,85,90,90,85,null,
                null,null,61.6,30.0,91.6,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"1-204",95,95,95,95,95,null,
                null,null,66.5,30.0,96.5,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"2-701",95,95,90,95,85,null,
                null,null,64.4,30.0,94.4,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"2-702",95,90,95,90,90,null,
                null,null,64.4,30.0,94.4,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"11-701",95,95,95,95,95,null,
                null,null,66.5,30.0,96.5,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"11-702",95,95,95,95,95,null,
                null,null,66.5,30.0,96.5,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"11-703",95,95,95,95,95,null,
                null,null,66.5,30.0,96.5,"三星级寝室"));
        starService.insertRecord(new StarDomain(String.valueOf(id.nextId()),articleId10,"11-704",95,95,95,95,95,null,
                null,null,66.5,30.0,96.5,"三星级寝室"));*/

        /*
         * 初始化 班级考评 文章列表
         */
        /*homeArticleService.insertArticle(new HomeArticleDomain(articleId11,collegeId,5,"ArticleDetailCheckClass",new Date(),null,
                "信息与计算机工程学院2018年6月班级月度考评表记分表", "信息与计算机工程学院2018年6月班级月度考评中","宿管委员会考核部"));
        checkClassService.insertRecord(new CheckClassDomain(
                String.valueOf(id.nextId()),
                articleId11,
                "李希勇",
                "15软工1班",
                8,
                3,
                12,
                10.0,
                1,
                0.83,
                0,
                0.0,
                1,
                2.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                7.17
        ));
        checkClassService.insertRecord(new CheckClassDomain(
                String.valueOf(id.nextId()),
                articleId11,
                "刘熹",
                "15软工2班",
                8,
                3,
                9,
                7.5,
                2,
                1.67,
                9,
                27.0,
                1,
                2.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                -23.17
        ));
        checkClassService.insertRecord(new CheckClassDomain(
                String.valueOf(id.nextId()),
                articleId11,
                "彭新平",
                "16软工1",
                7,
                5,
                23,
                13.14,
                0,
                0.0,
                4,
                12.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                1.14
        ));
        checkClassService.insertRecord(new CheckClassDomain(
                String.valueOf(id.nextId()),
                articleId11,
                "蔡方萍",
                "15软工2",
                8,
                3,
                15,
                12.50,
                0,
                0.0,
                2,
                6.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                6.5
        ));
        checkClassService.insertRecord(new CheckClassDomain(
                String.valueOf(id.nextId()),
                articleId11,
                "肖咪咪",
                "16软件1",
                5,
                3,
                11,
                14.67,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                14.67
        ));
        checkClassService.insertRecord(new CheckClassDomain(
                String.valueOf(id.nextId()),
                articleId11,
                "吴新华",
                "16软件2",
                5,
                2,
                5,
                10.0,
                0,
                0.0,
                3,
                9.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                0,
                0.0,
                1.0
        ));*/

        /*
         * 初始化 晚归 文章列表
         */
       /* homeArticleService.insertArticle(new HomeArticleDomain(articleId12,collegeId,4,"ArticleDetailNight",new Date(),
                new Date(2018,6,
                21),
                "信息与计算机工程学院第十六周晚归抽查通报批评", "信息与计算机工程学院2018年6月共计评选23个文明宿舍","宿管委员会考核部"));
        nightService.insertRecord(new NightDomain(String.valueOf(id.nextId()),articleId12,"13-216","15软工1班","刘向花"));
        nightService.insertRecord(new NightDomain(String.valueOf(id.nextId()),articleId12,"13-216","15软工2班","汤露茹"));
        nightService.insertRecord(new NightDomain(String.valueOf(id.nextId()),articleId12,"19-1-902","16信管班","李志波"));*/
    }
}
