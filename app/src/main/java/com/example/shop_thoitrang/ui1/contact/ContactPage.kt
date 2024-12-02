package com.example.shop_thoitrang.ui1.contact

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ContactPage() {
    Column (modifier = Modifier.padding(16.dp)) {
        Text("Contact Us", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Address: 123 ABC Street, XYZ District, City")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Email: contact@company.com")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Phone: 0123 456 789")
        Spacer(modifier = Modifier.height(16.dp))
        Button (onClick = { /* Submit contact form */ }) {
            Text("Send Contact Information")
        }
    }
}
