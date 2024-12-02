package com.example.shop_thoitrang.ui1.cart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CartPage() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("Cart", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(2) { index ->
                CartItem(
                    name = "Product $index",
                    price = 148.0,
                    color = if (index % 2 == 0) Color.Yellow else Color.Yellow
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Subtotal:", fontSize = 18.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text("$296.00", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Shipping Cost:", fontSize = 18.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text("$8.00", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Tax:", fontSize = 18.sp)
                Spacer(modifier = Modifier.weight(1f))
                Text("$0.00", fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Total:", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.weight(1f))
                Text("$304.00", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle checkout */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Checkout")
        }
    }
}

@Composable
fun CartItem(
    name: String,
    price: Double,
    color: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(name)
        Spacer(modifier = Modifier.weight(1f))
        Text("$%.2f".format(price))
    }
}