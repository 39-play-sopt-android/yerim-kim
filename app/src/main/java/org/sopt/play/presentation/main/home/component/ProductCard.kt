package org.sopt.play.presentation.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.play.R
import org.sopt.play.core.designsystem.theme.PLAYSOPTTheme
import org.sopt.play.core.designsystem.theme.PlaySoptTheme
import org.sopt.play.core.extension.noRippleClickable
import org.sopt.play.data.model.ProductModel
import org.sopt.play.presentation.main.home.model.HomeCategoryModel
import java.text.DecimalFormat

val priceFormatter = DecimalFormat("#,###")

@Composable
fun ProductCard(
    product: ProductModel,
    onHeartClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Box {
            Image(
                painter = painterResource(product.imgRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.8f),
                contentScale = ContentScale.Crop,
            )

            Icon(
                painter = painterResource(if (product.isHeartEmpty) R.drawable.ic_heart_default_24 else R.drawable.ic_heart_fill_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .noRippleClickable(onHeartClick)
                    .align(Alignment.BottomEnd),
                tint = if (product.isHeartEmpty) PLAYSOPTTheme.colors.white else PLAYSOPTTheme.colors.red,
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 12.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
        ) {
            Text(
                text = product.storeName,
                style = PLAYSOPTTheme.typography.caption.m14,
                color = PLAYSOPTTheme.colors.black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = product.productName,
                style = PLAYSOPTTheme.typography.caption.r14,
                color = PLAYSOPTTheme.colors.black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Row {
                Text(
                    text = "${product.discountRate}%",
                    style = PLAYSOPTTheme.typography.caption.m14,
                    color = PLAYSOPTTheme.colors.red,
                )

                Spacer(modifier = Modifier.width(4.dp))

                Text(
                    text = priceFormatter.format(product.price),
                    style = PLAYSOPTTheme.typography.caption.m14,
                    color = PLAYSOPTTheme.colors.black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductCardPreview() {
    PlaySoptTheme {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                ProductCard(
                    product = ProductModel(
                        imgRes = R.drawable.img_product1,
                        storeName = "스토어명 최대 한 줄",
                        productName = "상품명 최대 한 줄",
                        productType = HomeCategoryModel.PANTS,
                        discountRate = 49,
                        price = 29370,
                        isHeartEmpty = false,
                    ),
                    onHeartClick = {},
                    modifier = Modifier.weight(1f),
                )

                Spacer(modifier = Modifier.width(8.dp))

                ProductCard(
                    product = ProductModel(
                        imgRes = R.drawable.img_product2,
                        storeName = "스토어명이 한 줄을 넘어가면 이렇게 됩니다.",
                        productName = "상품명이 한 줄을 넘어가면 이렇게 됩니다.",
                        productType = HomeCategoryModel.PANTS,
                        discountRate = 1,
                        price = 999999999,
                        isHeartEmpty = true,
                    ),
                    onHeartClick = {},
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}
