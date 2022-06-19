package it.mall.build.service;

import it.mall.build.controller.vo.MallIndexCategoryVO;
import it.mall.build.controller.vo.SearchPageCategoryVO;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;
import it.mall.build.entity.GoodsCategory;

import java.util.List;

public interface MallCategoryService {
    // 后台分页
    PageResult getCategorisPage(PageQueryUtil pageUtil);

    String saveCategory(GoodsCategory goodsCategory);

    String updateGoodsCategory(GoodsCategory goodsCategory);

    GoodsCategory getGoodsCategoryById(Long id);

    Boolean deleteBatch(Integer[] ids);

    // 返回分类数据(首页调用)
    List<MallIndexCategoryVO> getCategoriesForIndex();

    // 返回分类数据(搜索页调用)
    SearchPageCategoryVO getCategoriesForSearch(Long categoryId);

    // 根据parentId和level获取分类列表
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
}
