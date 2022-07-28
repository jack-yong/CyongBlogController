package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.constant.CodeType;
import com.cyong.dao.LinkMapper;
import com.cyong.model.Category;
import com.cyong.model.Link;
import com.cyong.service.LinkService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
 * @CreateTime: 2022-07-16 15:17
 * @Description: 友链服务层业务逻辑实现
 */
@Service
@Slf4j
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Autowired
    private Datafilter datafilter;

    @Override
    public DataMap searchByLinkId(int LinkId) {
        return null;
    }

    @Override
    public JSONObject getLinkCount() {

        try{
            JSONObject LinkObj = new JSONObject();
            int LinkNum = linkMapper.selectLinkNum();
            LinkObj.put("name","link");
            LinkObj.put("Num",LinkNum);
            return LinkObj;
        }
        catch (Exception e){
            System.out.println(e+"getLinkCount");
            return null;
        }
    }

    @Override
    public DataMap linkVagueSearch(String linkKeyStr, int pageSize, int pageNum, String sorter, String filters) {
        try
        {
            JSONObject linkObj = new JSONObject();
            List<String> kindList = null;
            String sortField = "";
            String sortOrder = "";
            if(!filters.equals("{}")){
                JSONObject filterObj = JSONObject.parseObject(filters);
                String kindsStr = (String) filterObj.get("linktype");
                String[] kindSL = kindsStr.split(",");
                kindList = new ArrayList<>();
                for (String item : kindSL) {
                    kindList.add(item);
                }
            }
            if(!sorter.equals(""))
            {
                String[] sorterlist = sorter.split("&&");
                sortField = sorterlist[0];
                sortOrder = sorterlist[1];
            }
            PageHelper.startPage(pageNum, pageSize);
            List<Link> allResult = linkMapper.vagueSearchLink(linkKeyStr, sortField, sortOrder, kindList);
            PageInfo<Link> linksVS = new PageInfo<>(allResult);
            linkObj.put("totalNum", linksVS.getTotal()); //总记录数目
            linkObj.put("pages", linksVS.getPages()); //总页数
            linkObj.put("pageNum", linksVS.getPageNum()); //当前页
            linkObj.put("pagesSize", linksVS.getSize()); //每页的数量
            linkObj.put("data",datafilter.LinkFilter(allResult));
            DataMap objectDataMap = DataMap.success().setData(linkObj);
            return objectDataMap;
        }
        catch (Exception e)
        {
            log.error("Service: LinkService","func : linkVagueSearch",e);
            return DataMap.fail(CodeType.UN_EXPECTED_ERROR);
        }
        finally {
            PageHelper.clearPage();
        }
    }

    @Override
    public DataMap addLink(String linkImage, String linkTitle, String linkDesc,String linkUrl, int linkType) {
       try{
            if(linkTitle.equals(""))
            {
                return DataMap.fail(CodeType.LINK_NAME_BLANK);
            }
            else if(linkDesc.equals(""))
            {
                return DataMap.fail(CodeType.LINK_CONTENT_BLANK);
            }
            else if(linkUrl.equals("")){
                return DataMap.fail(CodeType.LINK_URL_BLANK);
            }
            else{
                Link myLink = new Link();
                Date date = new Date();
                myLink.setLinkAvater(linkImage);
                myLink.setLinkName(linkTitle);
                myLink.setLinkDescription(linkDesc);
                myLink.setLinkCreateTime(date);
                myLink.setLinkUrl(linkUrl);
                myLink.setLinkRank(0);
                myLink.setLinkIsDeleted((byte)0);
                myLink.setLinkType((byte)linkType);
                linkMapper.insertSelective(myLink);
                return DataMap.success();
            }
       }
       catch (Exception e)
       {
           log.error("service：LinkService","func: addLink",e);
           return DataMap.fail(CodeType.UN_EXPECTED_ERROR);
       }

    }


}
