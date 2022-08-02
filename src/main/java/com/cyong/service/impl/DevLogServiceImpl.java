package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.DevLogMapper;
import com.cyong.model.DevLog;
import com.cyong.service.DevLogService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:56
 * @Description: 开发日志服务层业务逻辑实现
 */
@Service
@Slf4j
public class DevLogServiceImpl  implements DevLogService {

    @Autowired
    private DevLogMapper devLogMapper;

    @Autowired
    private Datafilter datafilter;

    @Override
    public DataMap searchByDLId(int DLId) {
        return null;
    }

    @Override
    public JSONObject getDLCount() {
        try{
            JSONObject DLObj = new JSONObject();
            int DLNum = devLogMapper.selectDevLogNum();
            DLObj.put("name","DL");
            DLObj.put("Num",DLNum);
            return DLObj;
        }
        catch (Exception e){
            System.out.println(e+"getDLCount");
            return null;
        }

    }

    @Override
    public DataMap vagueSearchDevlog(String searchkey, int pageSize, int pageNum, String sorter, String filters) {
        try{
            JSONObject devlogObj =  new JSONObject();
            List<String> typeList = null;
            String sortField = "";
            String sortOrder = "";
            if(!filters.equals("{}"))
            {
                JSONObject filterObj = JSONObject.parseObject(filters);
                String typeStr = (String) filterObj.get("devlogtype");
                String[] typeSL = typeStr.split(",");
                typeList = new ArrayList<>();
                for (String item : typeSL) {
                    typeList.add(item);
                }
            }
            if(!sorter.equals(""))
            {
                String[] splitList = sorter.split("&&");
                sortField = splitList[0];
                sortOrder = splitList[1];
            }
            PageHelper.startPage(pageNum,pageSize);
            List<DevLog> allResult = devLogMapper.vagueSearchDL(searchkey,sortField,sortOrder,typeList);
            PageInfo<DevLog> devLogPageInfo = new PageInfo<>(allResult);
            devlogObj.put("totalNum", devLogPageInfo.getTotal()); //总记录数目
            devlogObj.put("pages", devLogPageInfo.getPages()); //总页数
            devlogObj.put("pageNum", devLogPageInfo.getPageNum()); //当前页
            devlogObj.put("pagesSize", devLogPageInfo.getSize()); //每页的数量
            devlogObj.put("data",datafilter.DevlogFilter(allResult));
            DataMap objectDataMap = DataMap.success().setData(devlogObj);
            return objectDataMap;
        }
        catch (Exception e)
        {
            log.error("Service : DevLogService","func :vagueSearchDevlog",e);
            return DataMap.fail(CodeType.UN_EXPECTED_ERROR);
        }
        finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public DataMap addDevlog(String devLogTitle, String devLogContent, int devlogKind) {
       try {
            if(devLogTitle.equals(""))
            {
                return DataMap.fail(CodeType.DEVLOG_TITLE_BLANK);

            }
            else if(devLogContent.equals(""))
            {
                return DataMap.fail(CodeType.DEVLOG_CONTENT_BLANK);
            }
            else{
                DevLog devLog = new DevLog();
                Date date = new Date();
                String praseEmoji = EmojiParser.parseToAliases(devLogContent);
                devLog.setDevLogTitle(devLogTitle);
                devLog.setDevLogContent(praseEmoji);
                devLog.setDevLogType((byte)devlogKind);
                devLog.setDevLogCreateTime(date);
                devLogMapper.insertSelective(devLog);
                return DataMap.success();
            }
       }
       catch (Exception e)
       {
            log.error("Service :LinkService","func:addDevlog",e);
            return DataMap.fail(CodeType.UN_EXPECTED_ERROR);
       }
    }

    @Override
    public DataMap getAllDevlog() {
        List<DevLog> allDL = devLogMapper.getAllDL();
        return DataMap.success().setData(datafilter.DevlogFilter(allDL));
    }


}
