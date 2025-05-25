package com.quanxiaoha.weblog.common.domain.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quanxiaoha.weblog.common.domain.dos.TagDO;
import java.time.LocalDate;
import java.util.Objects;

public interface TagMapper extends BaseMapper<TagDO> {
    default Page<TagDO> selectPageList(Long current, Long size, String name, LocalDate startDate, LocalDate endDate) {
        Page<TagDO> page = new Page<>(current, size);
        LambdaQueryWrapper<TagDO> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Objects.nonNull(name), TagDO::getName, name)
                .ge(Objects.nonNull(startDate), TagDO::getCreateTime, startDate)
                .le(Objects.nonNull(endDate), TagDO::getCreateTime, endDate)
                .orderByDesc(TagDO::getCreateTime); //
        return selectPage(page, wrapper);
    }
}
