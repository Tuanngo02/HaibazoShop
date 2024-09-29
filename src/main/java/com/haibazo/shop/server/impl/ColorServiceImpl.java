package com.haibazo.shop.server.impl;

import com.haibazo.shop.dto.request.ColorRequest;
import com.haibazo.shop.dto.response.ColorResponse;
import com.haibazo.shop.entity.Color;
import com.haibazo.shop.mapper.ColorMapper;
import com.haibazo.shop.repository.ColorRepository;
import com.haibazo.shop.server.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private ColorMapper colorMapper;
    @Override
    public ColorResponse createColor(ColorRequest colorRequest) {
        Color color = colorMapper.toColor(colorRequest);

        colorRepository.save(color);

        return colorMapper.toColorResponse(color);
    }

    @Override
    public List<ColorResponse> getAllColor() {
        return colorRepository.findAll().stream().map(colorMapper::toColorResponse).toList();
    }

    @Override
    public ColorResponse updateColor(Long id, ColorRequest colorRequest) {
        Color color = colorRepository.findById(id).orElseThrow(() -> new RuntimeException("không tìm thấy"));

        colorMapper.updateColor(color, colorRequest);

        colorRepository.save(color);

        return colorMapper.toColorResponse(color);
    }

    @Override
    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }
}
