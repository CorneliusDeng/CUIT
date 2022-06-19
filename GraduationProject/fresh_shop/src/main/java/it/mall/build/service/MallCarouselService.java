package it.mall.build.service;

import it.mall.build.controller.vo.MallIndexCarouselVO;
import it.mall.build.entity.Carousel;
import it.mall.build.util.PageQueryUtil;
import it.mall.build.util.PageResult;

import java.util.List;

public interface MallCarouselService {
    // 后台分页
    PageResult getCarouselPage(PageQueryUtil pageUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    Carousel getCarouselById(Integer id);

    Boolean deleteBatch(Integer[] ids);

    // 返回固定数量的轮播图对象(首页调用)
    List<MallIndexCarouselVO> getCarouselsForIndex(int number);
}
