package com.haibazo.shop.server;

import com.haibazo.shop.dto.request.StyleRequest;
import com.haibazo.shop.dto.response.StyleResponse;

import java.util.List;

public interface StyleService {
    StyleResponse createStyle (StyleRequest styleRequest);
    List<StyleResponse> getAllStyle();
    StyleResponse updateStyle (Long id, StyleRequest styleRequest);
    void deleteStyle (Long id);
}
