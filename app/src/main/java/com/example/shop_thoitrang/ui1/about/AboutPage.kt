package com.example.shop_thoitrang.ui1.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutPage() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("About Us", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Our company specializes in providing high-quality products...")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Our mission is to bring customer satisfaction through excellent products and services.")
    }
}
