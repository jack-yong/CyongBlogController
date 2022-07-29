package com.cyong.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.DailySpeechMapper;
import com.cyong.model.DailySpeech;
import com.cyong.service.DailySpeechService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 15:15
 * @Description: 日常说说服务层业务逻辑实现
 */
@Service
@Slf4j
public class DailySpeechServiceImpl implements DailySpeechService{
    @Autowired
    private DailySpeechMapper dailySpeechMapper;

    @Autowired
    private Datafilter datafilter;

    @Override
    public DataMap searchByDSId(int DSId) {
        return null;
    }

    @Override
    public JSONObject getDSCount() {
        try {
            JSONObject DSObj = new JSONObject();
            int DSNum = dailySpeechMapper.selectDailySpeechNum();
            DSObj.put("name","DS");
            DSObj.put("Num",DSNum);
            return DSObj;
        }
        catch (Exception e){
            System.out.println(e+"getDSCount");
            return null;
        }
    }

    @Override
    public DataMap vagueSearchByDSContent(String dsContent, int pageNum, int pageSize, String sorter) {
        try
        {
            JSONObject DSObj = new JSONObject();
            String sortField = "";
            String sortOrder = "";
            if(!sorter.equals(""))
            {
                String[] sorterArg = sorter.split("&&");
                sortField = sorterArg[0];
                sortOrder = sorterArg[1];
            }
            PageHelper.startPage(pageNum, pageSize);
            List<DailySpeech> dailySpeechesResult = dailySpeechMapper.vagueSearchDS(dsContent, sortField, sortOrder);
            PageInfo<DailySpeech> dailyspeechsPI = new PageInfo<>(dailySpeechesResult);
            DSObj.put("totalNum", dailyspeechsPI.getTotal()); //总记录数目
            DSObj.put("pages", dailyspeechsPI.getPages()); //总页数
            DSObj.put("pageNum", dailyspeechsPI.getPageNum()); //当前页
            DSObj.put("pagesSize", dailyspeechsPI.getSize()); //每页的数量
            DSObj.put("data", datafilter.Pushpinsfilter(dailySpeechesResult));
            DataMap objectDataMap = DataMap.success().setData(DSObj);
            return objectDataMap;
        }
        catch (Exception e)
        {
            log.error("vagueSearchByDSContent error",e);
            return DataMap.fail(CodeType.UN_EXPECTED_ERROR);
        }
        finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public DataMap dsAdd(String dsContent, String dsImage) {
        try{
            if(dsContent.equals(""))
            {
                return DataMap.fail(CodeType.DAILYSPEECH_CONTENT_BLANK);
            }
            DailySpeech dailySpeech = new DailySpeech();
            Date date = new Date();
            String dsContentCovert = EmojiParser.parseToAliases(dsContent);
            dailySpeech.setDspeechContent(dsContentCovert);
            dailySpeech.setDspeechPicsurl(dsImage);
            dailySpeech.setDspeechPublishdate(date);
            dailySpeechMapper.insert(dailySpeech);
            return DataMap.success();
        }catch (Exception e)
        {
            log.error("vagueSearchByDSContent happend error",e);
            DataMap addfail = DataMap.fail(CodeType.UN_EXPECTED_ERROR);
            return addfail;
        }


    }

    @Override
    public DataMap getAllDailySpeech() {
        List<DailySpeech> dailySpeeches = dailySpeechMapper.searchAllDS();
        return DataMap.success().setData(datafilter.Pushpinsfilter(dailySpeeches) );
    }


}
