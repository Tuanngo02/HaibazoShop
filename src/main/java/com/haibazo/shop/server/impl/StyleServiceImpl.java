package com.haibazo.shop.server.impl;

import com.haibazo.shop.dto.request.StyleRequest;
import com.haibazo.shop.dto.response.StyleResponse;
import com.haibazo.shop.entity.Color;
import com.haibazo.shop.entity.Style;
import com.haibazo.shop.mapper.StyleMapper;
import com.haibazo.shop.repository.StyleRepository;
import com.haibazo.shop.server.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StyleServiceImpl implements StyleService {
    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private StyleMapper styleMapper;
    @Override
    public StyleResponse createStyle(StyleRequest styleRequest) {
        Style style = styleMapper.toStyle(styleRequest);

        styleRepository.save(style);

        return styleMapper.toStyleResponse(style);
    }

    @Override
    public List<StyleResponse> getAllStyle() {
        return styleRepository.findAll().stream().map(styleMapper::toStyleResponse).toList();
    }

    @Override
    public StyleResponse updateStyle(Long id, StyleRequest styleRequest) {
        Style style = styleRepository.findById(id).orElseThrow(() -> new RuntimeException("không tìm thấy"));

        styleMapper.updateStyle(style, styleRequest);

        styleRepository.save(style);

        return styleMapper.toStyleResponse(style);
    }

    @Override
    public void deleteStyle(Long id) {
        styleRepository.deleteById(id);
    }
}
