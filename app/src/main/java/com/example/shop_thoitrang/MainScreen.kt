
package com.example.shop_thoitrang.ui1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shop_thoitrang.ui1.about.AboutPage
import com.example.shop_thoitrang.ui1.cart.CartPage
import com.example.shop_thoitrang.ui1.favoritor.FavoritePage
import com.example.shop_thoitrang.ui1.home.HomePage
import com.example.shop_thoitrang.ui1.product.ProductPage
import com.example.shop_thoitrang.ui1.product.ProductDetailPage
import com.example.shop_thoitrang.ui1.profile.EditProfilePage
import com.example.shop_thoitrang.ui1.profile.ProfilePage

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomePage(navController) }
        composable("favorite") { FavoritePage(navController) }
        composable("cart") { CartPage() }
        composable("about") { AboutPage() }
        composable("products") {
            ProductPage(onProductClick = { index ->
                navController.navigate("product_detail/$index")
            })
        }
        composable("product_detail/{productIndex}") { backStackEntry ->
            val productIndex = backStackEntry.arguments?.getString("productIndex")?.toInt() ?: 0
            ProductDetailPage(productIndex)
        }
        composable("profile") { ProfilePage(navController) }
        composable("edit_profile") { EditProfilePage(navController) }
    }
}