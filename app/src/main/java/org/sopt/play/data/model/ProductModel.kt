package org.sopt.play.data.model

import androidx.annotation.DrawableRes
import org.sopt.play.R

data class ProductModel(
    @param: DrawableRes val imgRes: Int,
    val storeName: String,
    val productName: String,
    val discountRate: Int,
    val price: Int,
    val isHeartEmpty: Boolean,
)

val productMockData = listOf(
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = true,
    ),
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = false,
    ),
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = false,
    ),
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = false,

        ),
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = true,
    ),
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = true,
    ),
    ProductModel(
        imgRes = R.drawable.img_mock,
        storeName = "트랜디어패럴",
        productName = "[카프리1위\uD83C\uDFC6/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = 28800,
        isHeartEmpty = true,
    ),
)
