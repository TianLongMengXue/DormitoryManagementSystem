package com.e3e4e20.home.service.impl;

import com.e3e4e20.common.entity.ResponseData;
import com.e3e4e20.common.entity.home.ArticleDetail;
import com.e3e4e20.common.entity.home.ArticleDetailRecordName;
import com.e3e4e20.common.entity.home.ArticleDetailRows;
import com.e3e4e20.common.pojo.*;
import com.e3e4e20.home.service.ArticleDetailService;
import com.e3e4e20.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Description: 文章详情业务层
 * Created: 2020-04-21 16:25 星期二
 * Author: DreamSnow·Draco
 * Company: none
 * */
@Service
public class ArticleDetailServiceImpl implements ArticleDetailService {
    @Autowired
    HomeArticleTypeService homeArticleTypeService;
    @Autowired
    CaseColNameService caseColNameService;
    @Autowired
    CaseService caseService;
    @Autowired
    HomeArticleService homeArticleService;
    @Autowired
    NightColNameService nightColNameService;
    @Autowired
    NightService nightService;
    @Autowired
    CriticizeColNameService criticizeColNameService;
    @Autowired
    CriticizeService criticizeService;
    @Autowired
    StarColNameService starColNameService;
    @Autowired
    StarService starService;
    @Autowired
    CivilColNameService civilColNameService;
    @Autowired
    CivilService civilService;
    @Autowired
    CheckColNameService checkColNameService;
    @Autowired
    CheckClassService checkClassService;
    @Override
    public ResponseData getArticleDetail(Map map) {
        // 实例化响应数据
        ResponseData data = new ResponseData();
        // 查询 文章类型
        String articleType = homeArticleTypeService.getArticleTypeName((String) map.get("articleType"));
        // System.out.println(map);
        ArticleDetail<Object> articleDetail = new ArticleDetail<>();
        // 根据文章类型封装文章内容
        switch (articleType) {
            case "case":
                // System.out.println("case");
                articleDetail = caseHandle(map);
                break;
            case "night":
                // System.out.println("night");
                articleDetail = nightHandle(map);
                break;
            case "criticize":
                // System.out.println("criticize");
                articleDetail = criticizeHandle(map);
                break;
            case "star":
                // System.out.println("star");
                articleDetail = starHandle(map);
                break;
            case "civil":
                // System.out.println("civil");
                articleDetail = civilHandle(map);
                break;
            case "checkClass":
                // System.out.println("checkClass");
                articleDetail = checkClassHandle(map);
                break;
        }
        System.out.println(articleDetail.toString());
        return ResponseData.SUCCESS("articleDetail", articleDetail);
    }

    private ArticleDetail caseHandle (Map map) {
        // 获取例检、抽检表的列名
        List<ArticleDetailRecordName> recordNameList = caseColNameService.getCaseColName();
        // System.out.println(recordNameList);
        // 获取例检、抽检结果集
        List<CaseDomain> caseList = caseService.selectById((String) map.get("articleId"));
        // System.out.println(caseList);
        // 封装 例检、抽检 结果集
        List<ArticleDetailRows> rows = new ArrayList<>();
        for (CaseDomain caseDomain: caseList) {
            // 根据宿舍的栋数封装出rows
            // 若rows为空直接封装一个元素出来
            if (rows.isEmpty()){
                ArticleDetailRows articleDetailRows = new ArticleDetailRows();
                articleDetailRows.setMiniTitle(caseDomain.getBuildNum());
                articleDetailRows.setRecord(new ArrayList<>());
                articleDetailRows.getRecord().add(caseDomain);
                rows.add(articleDetailRows);
            } else {
                // 遍历rows
                boolean flag = true; // 默认 rows 中已有该数据对应的栋数
                for (ArticleDetailRows row: rows) {
                    // 新的宿舍数据是否和rows已存储的数据在同一栋内,若有直接添加
                    if (row.getMiniTitle().equals(caseDomain.getBuildNum())){
                        row.getRecord().add(caseDomain);
                        flag = true;
                        break;
                    } else {
                        // 若没有将数据封装为rows的新的子元素添加
                        flag = false;
                    }
                }
                if (!flag) {
                    ArticleDetailRows articleDetailRows = new ArticleDetailRows();
                    articleDetailRows.setMiniTitle(caseDomain.getBuildNum());
                    articleDetailRows.setRecord(new ArrayList<>());
                    articleDetailRows.getRecord().add(caseDomain);
                    rows.add(articleDetailRows);
                }
            }
        }
        // System.out.println(rows);
        // 获取文章的标题、检查时间、发布部门等信息
        HomeArticleDomain article = homeArticleService.getOneArticle(map);
        ArticleDetail articleDetail = new ArticleDetail();
        articleDetail.setTitle(article.getArticleTitle());
        articleDetail.setDateCol(true);
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
        articleDetail.setDate(date.format(article.getCheckTime()));
        articleDetail.setMiniCol(true);
        articleDetail.setRecordName(recordNameList);
        articleDetail.setRows(rows);
        // 封装例检、抽检的尾款署名
        List<String> signature = new ArrayList<>();
        signature.add((String) map.get("collegeName"));
        signature.add(article.getArticlePost());
        signature.add(date.format(article.getArticleTime()));
        articleDetail.setSignature(signature);
        return articleDetail;
    }

    private ArticleDetail nightHandle (Map map) {
        // 获取晚归通报的列名集
        List<ArticleDetailRecordName> recordNameList = nightColNameService.getCaseColName();
        // 获取晚归结果集
        List<NightDomain> nightList = nightService.selectById((String) map.get("articleId"));
        // 封装晚归结果集
        List<ArticleDetailRows> rows = new ArrayList<>();
        ArticleDetailRows articleDetailRows = new ArticleDetailRows();
        articleDetailRows.setRecord(new ArrayList<>());
        for (NightDomain nightDomain:nightList) {
            articleDetailRows.getRecord().add(nightDomain);
        }
        rows.add(articleDetailRows);
        // 获取文章的标题、检查时间、发布部门等信息
        HomeArticleDomain article = homeArticleService.getOneArticle(map);
        // 封装文章详情
        ArticleDetail articleDetail = new ArticleDetail();
        // 封装文章标题
        articleDetail.setTitle(article.getArticleTitle());
        // 封装文章副标题
        articleDetail.setDateCol(true);
        articleDetail.setMiniCol(false);
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
        articleDetail.setDate("在"+date.format(article.getCheckTime())+"寝室晚归抽查中，下列寝室缺寝晚归情况特此通报批评。");
        // 封装晚归表列名
        articleDetail.setRecordName(recordNameList);
        // 封装晚归结果集
        articleDetail.setRows(rows);
        // 封装尾款署名
        List<String> signature = new ArrayList<String>();
        signature.add((String) map.get("collegeName"));
        signature.add(article.getArticlePost());
        signature.add(date.format(article.getArticleTime()));
        articleDetail.setSignature(signature);
        return articleDetail;
    }

    private ArticleDetail criticizeHandle (Map map) {
        // 获取通报批评列名集
        List<ArticleDetailRecordName> recordNameList = criticizeColNameService.getCaseColName();
        // 获取通报结果集
        List<CriticizeDomain> criticizeList = criticizeService.selectById((String) map.get("articleId"));
        // System.out.println("criticizeService.selectById((String) map.get(\"articleId\"));============>");
        // System.out.println(criticizeList);
        // 封装通报批评结果集
        List<ArticleDetailRows> rows = new ArrayList<>();
        for (CriticizeDomain criticizeDomain: criticizeList) {
            // 抽取通报的检查时间,同一时间的封装在一个数组中
            // 若是结果集 rows 为空,为 rows 直接向 rows 内填充数据
            if (rows.isEmpty()) {
                ArticleDetailRows articleDetailRows = new ArticleDetailRows();
                articleDetailRows.setMiniTitle(criticizeDomain.getCheckTime());
                articleDetailRows.setRecord(new ArrayList<>());
                articleDetailRows.getRecord().add(criticizeDomain);
                rows.add(articleDetailRows);
            } else {
                // 若 rows 不为空,遍历 rows 将同一检查时间的通报记录放于同一个记录集内
                boolean flag = true; // 初始化认为 rows 内存在该记录的对应的检查时间
                for (ArticleDetailRows row: rows) {
                    // 判断 rows 是否已有与本次criticizeDomain相同miniTitle
                    if (row.getMiniTitle().equals(criticizeDomain.getCheckTime())){
                        row.getRecord().add(criticizeDomain);
                        flag = true;
                        break;
                    } else {
                        // 当rows中没有相同的miniTile则新建一个具有该miniTitle分类的加入到rows中
                        /*ArticleDetailRows articleDetailRows = new ArticleDetailRows();
                        articleDetailRows.setMiniTitle(criticizeDomain.getCheckTime());
                        articleDetailRows.setRecord(new ArrayList<>());
                        articleDetailRows.getRecord().add(criticizeDomain);
                        System.out.println(articleDetailRows);
                        System.out.println(rows);
                        rows.add(articleDetailRows);
                        System.out.println(rows.add(articleDetailRows));
                        System.out.println(rows);
                        break;*/
                        flag = false;
                    }
                }
                if (!flag) {
                    ArticleDetailRows articleDetailRows = new ArticleDetailRows();
                    articleDetailRows.setMiniTitle(criticizeDomain.getCheckTime());
                    articleDetailRows.setRecord(new ArrayList<>());
                    articleDetailRows.getRecord().add(criticizeDomain);
                    // System.out.println(articleDetailRows);
                    // System.out.println(rows);
                    rows.add(articleDetailRows);
                    // System.out.println(rows.add(articleDetailRows));
                    // System.out.println(rows);
                }
            }
        }
        // 获取文章的标题、检查时间、发布部门等信息
        HomeArticleDomain article = homeArticleService.getOneArticle(map);
        // 封装文章详情
        ArticleDetail articleDetail = new ArticleDetail();
        // 文章标题
        articleDetail.setTitle(article.getArticleTitle());
        // 文章副标题
        articleDetail.setDateCol(false);
        // 文章小标题
        articleDetail.setMiniCol(true);
        // 文章表列名
        articleDetail.setRecordName(recordNameList);
        // 文章结果记录集
        articleDetail.setRows(rows);
        // 文章尾款署名
        List<String> signature = new ArrayList<>();
        signature.add((String) map.get("collegeName"));
        signature.add(article.getArticlePost());
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
        signature.add(date.format(article.getArticleTime()));
        articleDetail.setSignature(signature);
        return articleDetail;
    }
    private ArticleDetail starHandle (Map map) {
        // 获取星级宿舍表列名
        List<ArticleDetailRecordName> recordNameList = starColNameService.getCaseColName();
        // 获取星级宿舍结果集
        List<StarDomain> starList = starService.selectById((String) map.get("articleId"));
        // 封装星级宿舍结果集
        List<ArticleDetailRows> rows = new ArrayList<>();
        ArticleDetailRows articleDetailRows = new ArticleDetailRows();
        articleDetailRows.setRecord(new ArrayList<>());
        for (StarDomain starDomain:starList) {
            articleDetailRows.getRecord().add(starDomain);
        }
        rows.add(articleDetailRows);
        // 获取文章的标题、检查时间、发布部门等信息
        HomeArticleDomain article = homeArticleService.getOneArticle(map);
        // 封装文章详情
        ArticleDetail articleDetail = new ArticleDetail();
        // 文章标题
        articleDetail.setTitle(article.getArticleTitle());
        // 文章副标题
        articleDetail.setDateCol(false);
        // 文章小标题
        articleDetail.setMiniCol(false);
        // 文章表列名
        articleDetail.setRecordName(recordNameList);
        // 文章结果集
        articleDetail.setRows(rows);
        // 文章尾款署名
        List<String> signature = new ArrayList<>();
        signature.add((String) map.get("collegeName"));
        signature.add(article.getArticlePost());
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
        signature.add(date.format(article.getArticleTime()));
        articleDetail.setSignature(signature);
        return articleDetail;
    }

    private ArticleDetail civilHandle (Map map) {
        // 获取文明宿舍表列名
        List<ArticleDetailRecordName> recordNameList = civilColNameService.getCaseColName();
        // 获取文明宿舍结果集
        List<CivilDomain> civilList = civilService.selectById((String) map.get("articleId"));
        // 封装文明宿舍结果集
        List<ArticleDetailRows> rows = new ArrayList<>();
        ArticleDetailRows articleDetailRows = new ArticleDetailRows();
        articleDetailRows.setRecord(new ArrayList<>());
        for (CivilDomain civilDomain:civilList) {
            articleDetailRows.getRecord().add(civilDomain);
        }
        rows.add(articleDetailRows);
        // 获取文章的标题、检查时间、发布部门等信息
        HomeArticleDomain article = homeArticleService.getOneArticle(map);
        // 封装文章详情
        ArticleDetail articleDetail = new ArticleDetail();
        // 文章标题
        articleDetail.setTitle(article.getArticleTitle());
        // 文章副标题
        articleDetail.setDateCol(false);
        // 文章小标题
        articleDetail.setMiniCol(false);
        // 文章表列名
        articleDetail.setRecordName(recordNameList);
        // 文章结果集
        articleDetail.setRows(rows);
        // 文章尾款署名
        List<String> signature = new ArrayList<>();
        signature.add((String) map.get("collegeName"));
        signature.add(article.getArticlePost());
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
        signature.add(date.format(article.getArticleTime()));
        articleDetail.setSignature(signature);
        return articleDetail;
    }
    private ArticleDetail checkClassHandle (Map map) {
        // 获取班级考评表列名
        List<ArticleDetailRecordName> recordNameList = checkColNameService.getCaseColName();
        // 获取班级考评结果集
        List<CheckClassDomain> checkClassList = checkClassService.selectById((String) map.get("articleId"));
        // 封装班级考评结果集
        List<ArticleDetailRows> rows = new ArrayList<>();
        ArticleDetailRows articleDetailRows = new ArticleDetailRows();
        articleDetailRows.setRecord(new ArrayList<>());
        for (CheckClassDomain checkClassDomain:checkClassList) {
            articleDetailRows.getRecord().add(checkClassDomain);
        }
        rows.add(articleDetailRows);
        // 获取文章的标题、检查时间、发布部门等信息
        HomeArticleDomain article = homeArticleService.getOneArticle(map);
        // 封装文章详情
        ArticleDetail articleDetail = new ArticleDetail();
        // 文章标题
        articleDetail.setTitle(article.getArticleTitle());
        // 文章副标题
        articleDetail.setDateCol(false);
        // 文章小标题
        articleDetail.setMiniCol(false);
        // 文章表列名
        articleDetail.setRecordName(recordNameList);
        // 文章结果集
        articleDetail.setRows(rows);
        // 文章尾款署名
        List<String> signature = new ArrayList<>();
        signature.add((String) map.get("collegeName"));
        signature.add(article.getArticlePost());
        SimpleDateFormat date = new SimpleDateFormat("yyyy年MM月dd日");
        signature.add(date.format(article.getArticleTime()));
        articleDetail.setSignature(signature);
        return articleDetail;
    }
}
