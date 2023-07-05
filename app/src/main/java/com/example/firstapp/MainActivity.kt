package com.example.firstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import com.example.firstapp.ui.screen.Library
import com.example.firstapp.ui.theme.FirstAppTheme
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.ui.screen.Library
import com.example.firstapp.ui.screen.Home
import com.example.firstapp.ui.screen.Search
import com.example.firstapp.ui.screen.SignUp

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    setContent {
      val navController = rememberNavController()

      NavHost(navController, startDestination = "signUp") {
        composable("library") {
          Library(navController = navController)
        }
        composable("home") {
          Home(navController = navController)
        }
        composable("search") {
          Search(navController = navController)
        }
        composable("signUp") {
          SignUp(navController = navController)
        }
      }
    }
  }
}
