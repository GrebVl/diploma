package com.diploma.bookEssays.web.mapper;

import com.diploma.bookEssays.entity.memo.Memo;
import com.diploma.bookEssays.web.dto.MemoDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T01:25:09+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Amazon.com Inc.)"
)
@Component
public class MemoMapperImpl implements MemoMapper {

    @Override
    public MemoDto toDto(Memo entity) {
        if ( entity == null ) {
            return null;
        }

        MemoDto memoDto = new MemoDto();

        memoDto.setId( entity.getId() );
        memoDto.setTopic( entity.getTopic() );
        memoDto.setNotion( entity.getNotion() );
        memoDto.setDescription( entity.getDescription() );
        memoDto.setConclusion( entity.getConclusion() );

        return memoDto;
    }

    @Override
    public List<MemoDto> toDto(List<Memo> entities) {
        if ( entities == null ) {
            return null;
        }

        List<MemoDto> list = new ArrayList<MemoDto>( entities.size() );
        for ( Memo memo : entities ) {
            list.add( toDto( memo ) );
        }

        return list;
    }

    @Override
    public Memo toEntity(MemoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Memo memo = new Memo();

        memo.setId( dto.getId() );
        memo.setTopic( dto.getTopic() );
        memo.setNotion( dto.getNotion() );
        memo.setDescription( dto.getDescription() );
        memo.setConclusion( dto.getConclusion() );

        return memo;
    }

    @Override
    public List<Memo> toEntity(List<MemoDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Memo> list = new ArrayList<Memo>( dtos.size() );
        for ( MemoDto memoDto : dtos ) {
            list.add( toEntity( memoDto ) );
        }

        return list;
    }
}
