package com.haibazo.shop.server.impl;

import com.haibazo.shop.configuration.CloudinaryConfig;
import com.haibazo.shop.dto.request.ProductRequest;
import com.haibazo.shop.dto.response.PageResponse;
import com.haibazo.shop.dto.response.ProductResponse;
import com.haibazo.shop.entity.*;
import com.haibazo.shop.mapper.ProductMapper;
import com.haibazo.shop.repository.*;
import com.haibazo.shop.server.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private StyleRepository styleRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CloudinaryConfig cloudinaryConfig;

    @Override
    public ProductResponse createProduct(ProductRequest productRequest, MultipartFile file) throws IOException {
        if (productRepository.existsByName(productRequest.getName())) throw new RuntimeException("product đã tồn tại");
        Category category = categoryRepository.findById(productRequest.getCategory()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Color color = colorRepository.findById(productRequest.getColor()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Size size = sizeRepository.findById(productRequest.getSize()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Style style = styleRepository.findById(productRequest.getStyle()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Map data = cloudinaryConfig.getCloudinary().uploader().upload(productRequest.getImage().getBytes(), Map.of());
        String image_url = (String) data.get("url");
        Product product = productMapper.toProduct(productRequest, category,color,size,style,image_url);
        productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public List<ProductResponse> searchProduct(String keyword, String categoryName, String colorName, String sizeLabel, String styleName, float priceFrom, float priceTo) {
        List<Product> product = productRepository.findByKeyword(keyword, categoryName, colorName, sizeLabel,styleName, priceFrom, priceTo);
//        System.out.println(product);
//        List<ProductResponse> d = new ArrayList<>();
//        System.out.println(product.getFirst().getName());
//        for (Product product1 : product){
//            System.out.println(product1.getCategory().getName());
//        }
//        System.out.println(d);
        return product.stream().map(productMapper::toProductResponse).toList();
    }

    @Override
    public PageResponse<ProductResponse> getAllProduct(int page, int size) {
        Sort sort = Sort.by("id").descending();
        Pageable pageable = PageRequest.of(page-1, size, sort );
        var pageData = productRepository.findAll(pageable);
        return PageResponse.<ProductResponse>builder()
                .currentPage(page)
                .pageSize(pageData.getSize())
                .totalPage(pageData.getTotalPages())
                .totalElements(pageData.getTotalElements())
                .data(pageData.getContent().stream().map(productMapper::toProductResponse).toList())
                .build();
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest productRequest, MultipartFile file) throws IOException {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Category category = categoryRepository.findById(productRequest.getCategory()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Color color = colorRepository.findById(productRequest.getColor()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Size size = sizeRepository.findById(productRequest.getSize()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Style style = styleRepository.findById(productRequest.getStyle()).orElseThrow(() -> new RuntimeException("không tìm thấy"));
        Map data = cloudinaryConfig.getCloudinary().uploader().upload(productRequest.getImage().getBytes(), Map.of());
        String image_url = (String) data.get("url");
        Product productData = productMapper.updateProduct(product, productRequest, category,color,size, style, image_url);
        productRepository.save(productData);
        return productMapper.toProductResponse(productData);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
