package com.haibazo.shop.mapper;

import com.haibazo.shop.dto.request.StyleRequest;
import com.haibazo.shop.dto.response.StyleResponse;
import com.haibazo.shop.entity.Style;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StyleMapper {
    Style toStyle(StyleRequest request);

    StyleResponse toStyleResponse(Style style);

    void updateStyle(@MappingTarget Style style, StyleRequest colorRequest);
}
