package com.cyong.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cyong.dao.PortfolioMapper;
import com.cyong.service.PortfolioService;
import com.cyong.utils.DataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
