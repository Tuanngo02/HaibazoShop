package com.haibazo.shop.server;

import com.haibazo.shop.dto.request.ColorRequest;
import com.haibazo.shop.dto.response.ColorResponse;

import java.util.List;

public interface ColorService {
    ColorResponse createColor (ColorRequest colorRequest);
    List<ColorResponse> getAllColor();
    ColorResponse updateColor (Long id, ColorRequest colorRequest);
    void deleteColor (Long id);
}
