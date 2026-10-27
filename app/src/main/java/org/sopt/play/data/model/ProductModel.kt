package org.sopt.play.data.model

import androidx.annotation.DrawableRes

data class ProductModel(
    @param: DrawableRes val imgRes: Int,
    val storeName: String,
    val productName: String,
    val productType: ProductType,
    val discountRate: Int,
    val price: Int,
    val isFavorite: Boolean,
)

enum class ProductType(
    val label: String,
) {
    TOP("상의"),
    PANTS("팬츠"),
    ONE_PIECE("원피스"),
    OUTER("아우터"),
    SKIRT("스커트"),
    SHOES("슈즈"),
    BAG("가방"),
    INNERWEAR("이너웨어/잠옷"),
    PHONE("폰꾸미기"),
    ETC("기타"),
}
