package com.diploma.bookEssays.web.mapper;

import com.diploma.bookEssays.entity.memo.Memo;
import com.diploma.bookEssays.web.dto.MemoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemoMapper extends Mappable<Memo, MemoDto> {
}
