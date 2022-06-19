package it.mall.build.controller.shop;

import it.mall.build.common.Constants;
import it.mall.build.common.IndexConfigTypeEnum;
import it.mall.build.controller.vo.MallIndexCarouselVO;
import it.mall.build.controller.vo.MallIndexCategoryVO;
import it.mall.build.controller.vo.MallIndexConfigGoodsVO;
import it.mall.build.service.MallCarouselService;
import it.mall.build.service.MallCategoryService;
import it.mall.build.service.MallIndexConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private MallCarouselService mallCarouselService;

    @Resource
    private MallIndexConfigService mallIndexConfigService;

    @Resource
    private MallCategoryService mallCategoryService;

    // 首页数据展示
    @GetMapping({"/index", "/", "/index.html"})
    public String indexPage(HttpServletRequest request) {
        // 查询分类数据
        List<MallIndexCategoryVO> categories = mallCategoryService.getCategoriesForIndex();
        if (CollectionUtils.isEmpty(categories)) {
            return "error/error_5xx";
        }
        // 查询轮播图信息
        List<MallIndexCarouselVO> carousels = mallCarouselService.getCarouselsForIndex(Constants.INDEX_CAROUSEL_NUMBER);
        // 查询热销商品
        List<MallIndexConfigGoodsVO> hotGoodses = mallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_HOT.getType(), Constants.INDEX_GOODS_HOT_NUMBER);
        // 查询新品
        List<MallIndexConfigGoodsVO> newGoodses = mallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_NEW.getType(), Constants.INDEX_GOODS_NEW_NUMBER);
        // 查询推荐商品
        List<MallIndexConfigGoodsVO> recommendGoodses = mallIndexConfigService.getConfigGoodsesForIndex(IndexConfigTypeEnum.INDEX_GOODS_RECOMMOND.getType(), Constants.INDEX_GOODS_RECOMMOND_NUMBER);
        request.setAttribute("categories", categories);//分类数据
        request.setAttribute("carousels", carousels);//轮播图
        request.setAttribute("hotGoodses", hotGoodses);//热销商品
        request.setAttribute("newGoodses", newGoodses);//新品
        request.setAttribute("recommendGoodses", recommendGoodses);//推荐商品
        return "mall/index";
    }
}
