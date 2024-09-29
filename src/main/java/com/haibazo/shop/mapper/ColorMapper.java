package com.haibazo.shop.mapper;

import com.haibazo.shop.dto.request.ColorRequest;
import com.haibazo.shop.dto.response.ColorResponse;
import com.haibazo.shop.entity.Color;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ColorMapper {
    Color toColor(ColorRequest request);

    ColorResponse toColorResponse(Color color);

    void updateColor(@MappingTarget Color color, ColorRequest colorRequest);
}
