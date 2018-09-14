package com.pinyougou.mapper;

import com.pinyougou.pojo.TbPromotion;
import com.pinyougou.pojo.TbPromotionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbPromotionMapper {
    int countByExample(TbPromotionExample example);

    int deleteByExample(TbPromotionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbPromotion record);

    int insertSelective(TbPromotion record);

    List<TbPromotion> selectByExample(TbPromotionExample example);

    TbPromotion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbPromotion record, @Param("example") TbPromotionExample example);

    int updateByExample(@Param("record") TbPromotion record, @Param("example") TbPromotionExample example);

    int updateByPrimaryKeySelective(TbPromotion record);

    int updateByPrimaryKey(TbPromotion record);
}