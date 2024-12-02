// ProductPage.kt
package com.example.shop_thoitrang.ui1.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.shop_thoitrang.R

val categories = listOf(
    Pair(R.drawable.ao_khoac, "Áo Thun"),
    Pair(R.drawable.quanje, "Quần Jeans"),
    Pair(R.drawable.ao_so_mi, "Đầm"),
    Pair(R.drawable.ao_thun, "Áo Khoác"),
    Pair(R.drawable.ao_khoac, "Phụ Kiện")
)

@Composable
fun ProductPage(onProductClick: (Int) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Danh sách sản phẩm", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(categories.size) { index ->
                ProductCard(index, categories[index], onProductClick)
            }
        }
    }
}

@Composable
fun ProductCard(index: Int, category: Pair<Int, String>, onProductClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onProductClick(index) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Product image
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Gray)
            ) {
                Image(
                    painter = rememberImagePainter(category.first),
                    contentDescription = "Ảnh sản phẩm ${category.second}",
                    modifier = Modifier.align(Alignment.Center).fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(category.second, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text("Giá tiền", fontSize = 16.sp)
        }
    }
}