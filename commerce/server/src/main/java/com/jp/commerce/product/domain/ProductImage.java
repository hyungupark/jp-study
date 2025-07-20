package com.jp.commerce.product.domain;

import com.jp.commerce.common.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "PRODUCT_IMAGE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductImage extends BaseTimeEntity {
    @Id
    @Column(name = "ID")
    private UUID id;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Builder
    public ProductImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
