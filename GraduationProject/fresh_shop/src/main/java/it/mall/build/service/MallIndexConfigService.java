package it.mall.build.service;

import it.mall.build.controller.vo.MallIndexConfigGoodsVO;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;
import it.mall.build.entity.IndexConfig;

import java.util.List;

public interface MallIndexConfigService {
    // 后台分页
    PageResult getConfigsPage(PageQueryUtil pageUtil);

    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    // 返回固定数量的首页配置商品对象(首页调用)
    List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    Boolean deleteBatch(Long[] ids);
}
