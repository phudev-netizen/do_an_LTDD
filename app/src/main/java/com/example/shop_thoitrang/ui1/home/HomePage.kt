
package com.example.shop_thoitrang.ui1.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shop_thoitrang.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun HomePage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Header(navController)
        Spacer(modifier = Modifier.height(16.dp))
        Content()
        Spacer(modifier = Modifier.weight(1f))
        Footer(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(navController: NavController) {
    TopAppBar(
        title = {
            Text("Fashion shop", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
        },
        actions = {
            Row {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    //imageVector = Icons.Default.ShoppingCart,
                    painter = painterResource(id = R.drawable.ic_cart_filled),
                    contentDescription = "Cart",
                    modifier = Modifier.size(24.dp).clickable {
                        navController.navigate("cart")
                    }
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)
    )
}

@Composable
fun Content() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Loại Sản Phẩm", style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
            Text("See All", style = TextStyle(fontSize = 14.sp, color = Color.Gray))
        }

        val categories = listOf(
            Pair(R.drawable.ao_khoac, "Áo Thun"),
            Pair(R.drawable.ao_khoac, "Quần Jeans"),
            Pair(R.drawable.ao_so_mi, "Đầm"),
            Pair(R.drawable.ao_thun, "Áo Khoác"),
            Pair(R.drawable.quanje, "Phụ Kiện")
        )

        LazyRow(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories.size) { index ->
                Column(
                    modifier = Modifier.width(80.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White)
                            .border(2.dp, Color.Gray)
                    ) {
                        Image(
                            painter = painterResource(id = categories[index].first),
                            contentDescription = categories[index].second,
                            modifier = Modifier.fillMaxSize().clip(RectangleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        categories[index].second,
                        style = TextStyle(fontSize = 14.sp),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Sản phẩm bán chạy nhất", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
            Text("See All", style = TextStyle(fontSize = 14.sp, color = Color.Gray))
        }

        val images = listOf(
            Pair(R.drawable.ao_so_mi, "Áo sơ mi"),
            Pair(R.drawable.ao, "Áo thun"),
            Pair(R.drawable.dam, "Đầm trắng"),
            Pair(R.drawable.ao_khoac, "Áo Flanel"),
            Pair(R.drawable.quanje, "Quần Jeans")
        )

        LazyRow(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(images.size) { index ->
                Card(
                    modifier = Modifier.size(width = 160.dp, height = 240.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = images[index].first),
                            contentDescription = images[index].second,
                            modifier = Modifier.fillMaxWidth().height(120.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.padding(8.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                images[index].second,
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("$100.00", style = TextStyle(fontSize = 14.sp, color = Color.Gray))
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Promotions Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Giảm Giá ", style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold))
            Text("See All", style = TextStyle(fontSize = 14.sp, color = Color.Gray))
        }

        // Promotions data
        val promotions = listOf(
            Pair(R.drawable.khuyen_mai1, "Giảm giá 20% cho đơn hàng đầu tiên"),
            Pair(R.drawable.khuyen_mai3, "Giảm giá 30% cho sản phẩm mùa hè"),
            Pair(R.drawable.khuyen_mai2, "Mua 1 tặng 1 tất cả sản phẩm"),
            Pair(R.drawable.khuyen_mai1, "Giảm giá 20% cho đơn hàng đầu tiên"),
            Pair(R.drawable.khuyen_mai2, "Mua 1 tặng 1 tất cả sản phẩm"),
            Pair(R.drawable.khuyen_mai3, "Giảm giá 30% cho sản phẩm mùa hè")
        )

        // State for LazyRow
        val listState = rememberLazyListState()

        // Auto-scroll logic
        LaunchedEffect(Unit) {
            while (true) {
                for (i in promotions.indices) {
                    listState.animateScrollToItem(i)
                    delay(3000) // Delay between scrolls
                }
            }
        }

        LazyRow(
            state = listState,
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(promotions.size) { index ->
                Card(
                    modifier = Modifier.size(width = 160.dp, height = 240.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = promotions[index].first),
                            contentDescription = promotions[index].second,
                            modifier = Modifier.fillMaxWidth().height(120.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.padding(8.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                promotions[index].second,
                                style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Footer(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_home), // Thay R.drawable.ic_home bằng ảnh của bạn
            contentDescription = "Home",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    navController.navigate("home")
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_category), // Thay bằng ảnh sản phẩm
            contentDescription = "Product",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    navController.navigate("products")
                }
        )
                Image(
            painter = painterResource(id = R.drawable.ic_favorite), // Thay bằng ảnh liên hệ
            contentDescription = "Favotite",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    navController.navigate("favorite")
                }
        )
        Image(
            painter = painterResource(id = R.drawable.ic_profile), // Thay bằng ảnh hồ sơ
            contentDescription = "Profile",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    navController.navigate("profile")
                }
        )


//        Image(
//            painter = painterResource(id = R.drawable.ic_about), // Thay bằng ảnh giới thiệu
//            contentDescription = "About",
//            modifier = Modifier
//                .size(40.dp)
//                .clickable {
//                    navController.navigate("about")
//                }
//        )
    }
}

