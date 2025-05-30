package com.quanxiaoha.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quanxiaoha.weblog.common.domain.dos.TagDO;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public interface TagMapper extends BaseMapper<TagDO> {

    /**
     * 分页查询
     * @param current
     * @param size
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    default Page<TagDO> selectPageList(Long current, Long size, String name, LocalDate startDate, LocalDate endDate) {
        Page<TagDO> page = new Page<>(current, size);
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Objects.nonNull(name), TagDO::getName, name)
                .ge(Objects.nonNull(startDate), TagDO::getCreateTime, startDate)
                .le(Objects.nonNull(endDate), TagDO::getCreateTime, endDate)
                .orderByDesc(TagDO::getCreateTime); //
        return selectPage(page, wrapper);
    }
    /**
     * 根据key模糊查询
     */
    default List<TagDO> selectByKey(String key) {
        LambdaQueryWrapper<TagDO> wapper = new LambdaQueryWrapper<>();
        // 构造模糊查询条件
        wapper.like(Objects.nonNull(key), TagDO::getName, key).orderByDesc(TagDO::getCreateTime);
        return selectList(wapper);
    }
}
