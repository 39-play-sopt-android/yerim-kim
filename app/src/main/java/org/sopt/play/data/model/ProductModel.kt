package org.sopt.play.data.model

import androidx.annotation.DrawableRes
import org.sopt.play.R
import org.sopt.play.presentation.main.home.model.HomeCategoryModel

data class ProductModel(
    @param: DrawableRes val imgRes: Int,
    val storeName: String,
    val productName: String,
    val productType: HomeCategoryModel,
    val discountRate: Int,
    val price: Int,
    val isHeartEmpty: Boolean,
)

val productMockData = listOf(
    ProductModel(
        imgRes = R.drawable.img_product1,
        storeName = "트랜디어패럴",
        productName = "[카프리1위🏆/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        productType = HomeCategoryModel.PANTS,
        discountRate = 36,
        price = 28800,
        isHeartEmpty = true,
    ),
    ProductModel(
        imgRes = R.drawable.img_product2,
        storeName = "슬로우앤드",
        productName = "[🍁가을/3기장선택!] made. 모먼트 투커버 올데이슬랙스 (+숏/베이직/롱ver) - 4 size",
        productType = HomeCategoryModel.PANTS,
        discountRate = 50,
        price = 26820,
        isHeartEmpty = true,
    ),
    ProductModel(
        imgRes = R.drawable.img_product3,
        storeName = "어텀",
        productName = "보울7부티셔츠",
        productType = HomeCategoryModel.TOP,
        discountRate = 10,
        price = 17100,
        isHeartEmpty = true,
    ),
    ProductModel(
        imgRes = R.drawable.img_product4,
        storeName = "슬로우앤드",
        productName = "[오픈할인중] made. 도브 클래식 탄탄핏 무지셔츠 - 4 color",
        productType = HomeCategoryModel.TOP,
        discountRate = 40,
        price = 35200,
        isHeartEmpty = false,

        ),
    ProductModel(
        imgRes = R.drawable.img_product5,
        storeName = "마인크래프트",
        productName = "[입문 추천/가벼운 착용감] 가죽 갑옷",
        productType = HomeCategoryModel.OUTER,
        discountRate = 50,
        price = 15000,
        isHeartEmpty = false,
    ),
    ProductModel(
        imgRes = R.drawable.img_product6,
        storeName = "마인크래프트",
        productName = "[방어력 TOP🏆/ 내구성 강화] 다이아몬드 갑옷",
        productType = HomeCategoryModel.OUTER,
        discountRate = 8,
        price = 452800,
        isHeartEmpty = false,
    ),
    ProductModel(
        imgRes = R.drawable.img_product7,
        storeName = "마인크래프트",
        productName = "[갑옷1위/유광,무광선택] 철 갑옷",
        productType = HomeCategoryModel.OUTER,
        discountRate = 21,
        price = 28700,
        isHeartEmpty = false,
    ),
)
