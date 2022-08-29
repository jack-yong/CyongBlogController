package com.cyong.service;

import com.alibaba.fastjson.JSONObject;
import com.cyong.utils.DataMap;

/**
 * @BelongsProject: CyongBlogController
 * @BelongsPackage: com.cyong.service.security
 * @Author: cyong
 * @CreateTime: 2022-07-16 16:57
 * @Description: 作品集服务层业务逻辑
 */
public interface PortfolioService {
    DataMap searchByPortfolioId(int PortfolioId);

    JSONObject getPortfolioCount();

    DataMap searchAllPortfolio();

    DataMap addPortfolio(String portfoliotitle,String portfolioContent,String portfolioimage,String portfoliourl);
}
