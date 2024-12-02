package com.example.shop_thoitrang.ui1.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductDetailPage(productIndex: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Product image
        Box(
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
                .background(Color.Gray)
        ) {
            Text(
                "Ảnh sản phẩm $productIndex",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Product name and price
        Text(
            text = "Sản phẩm $productIndex",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Giá tiền",
            fontSize = 18.sp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Color options
        Text(
            text = "Màu sắc:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            ColorBox(Color.Red)
            ColorBox(Color.Green)
            ColorBox(Color.Blue)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Size options
        Text(
            text = "Kích thước:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SizeBox("S")
            SizeBox("M")
            SizeBox("L")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Action buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { /* Handle add to cart action */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Thêm giỏ hàng")
            }
            Button(
                onClick = { /* Handle buy action */ },
                modifier = Modifier.weight(1f)
            ) {
                Text("Mua ngay")
            }
        }
    }
}

@Composable
fun ColorBox(color: Color) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(color)
    )
}

@Composable
fun SizeBox(size: String) {
    Box(
        modifier = Modifier
            .size(48.dp)
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(size, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}
