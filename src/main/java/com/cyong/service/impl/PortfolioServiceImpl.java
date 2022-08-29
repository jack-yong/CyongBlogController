package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.PortfolioMapper;
import com.cyong.model.Portfolio;
import com.cyong.service.PortfolioService;
import com.cyong.utils.DataMap;
import com.cyong.utils.Datafilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.impl
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:59
 * @Description: 作品集服务层业务逻辑实现
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {
    @Autowired
    private PortfolioMapper portfolioMapper;

    @Autowired
    private Datafilter datafilter;


    @Override
    public DataMap searchByPortfolioId(int PortfolioId) {
        return null;
    }

    @Override
    public JSONObject getPortfolioCount() {
        try{
            JSONObject portfolioObj = new JSONObject();
            int portfolioNum = portfolioMapper.selectPortfolioNum();
            portfolioObj.put("name","portfolio");
            portfolioObj.put("Num",portfolioNum);
            return portfolioObj;
        }
        catch (Exception e){
            System.out.println(e+"getPortfolioCount");
            return null;
        }
    }

    @Override
    public DataMap searchAllPortfolio() {
        List<Portfolio> allPortfolios = portfolioMapper.getAllPortfolios();
        return  DataMap.success().setData(datafilter.PortfolioFilter(allPortfolios));
    }

    @Override
    public DataMap addPortfolio(String portfoliotitle, String portfolioContent, String portfolioimage, String portfoliourl) {
        Date createTime = new Date();
        Portfolio portfolio = new Portfolio();
        portfolio.setPortfolioDate(createTime);
        portfolio.setPortfolioTitle(portfoliotitle);
        portfolio.setPortfolioImgUrl(portfolioimage);
        portfolio.setPortfolioDescribe(portfolioContent);
        portfolio.setPortfolioUrl(portfoliourl);
        portfolioMapper.insert(portfolio);
        return DataMap.success();
    }

}
