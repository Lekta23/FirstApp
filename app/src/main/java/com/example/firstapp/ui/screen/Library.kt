package com.example.firstapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firstapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Library(navController: NavController) {

  val listChips = listOf("Musique", "Podcasts et émissions");

  Scaffold(

    topBar = {
      TopAppBar(
        title = {
          Text(
            text = "Bibliothèque",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
          ) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
          titleContentColor = Color.White,
          containerColor = Color.Black,
        ),
        actions = {
          Icon(
            painter = painterResource(id = R.drawable.ic_baseline_photo_camera_24),
            contentDescription = null,
            tint = Color.White,
          )
        }
      )
    },

    bottomBar = {
      NavigationBar(containerColor = Color.Black) {
        NavigationBarItem(
          colors = NavigationBarItemDefaults.colors(selectedTextColor = Color.White),
          selected = navController.currentDestination?.route == "home",
          onClick = { navController.navigate("home") },
          label = { Text(text = "Accueil") },
          icon = {
            Icon(
              painter = painterResource(id = R.drawable.baseline_home_24),
              contentDescription = null
            )
          }
        )
        NavigationBarItem(
          colors = NavigationBarItemDefaults.colors(selectedTextColor = Color.White),
          selected = navController.currentDestination?.route == "search",
          onClick = { navController.navigate("search") },
          label = { Text(text = "Rechercher") },
          icon = {
            Icon(
              painter = painterResource(id = R.drawable.ic_baseline_search_24),
              contentDescription = null
            )
          }
        )
        NavigationBarItem(
          colors = NavigationBarItemDefaults.colors(selectedTextColor = Color.White),
          selected = navController.currentDestination?.route == "library",
          onClick = { navController.navigate("library") },
          label = { Text(text = "Bibliothèque") },
          icon = {
            Icon(
              painter = painterResource(id = R.drawable.ic_baseline_library_24),
              contentDescription = null
            )
          }
        )
      }
    }
  ) {

    Surface(
      color = Color.Black,
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state = rememberScrollState()),
    ) {

      Column(modifier = androidx.compose.ui.Modifier.padding(it)) {
        LazyRow() {
          items(listChips) { item ->
            InputChip(
              label = { Text(text = item, color = Color.LightGray) },
              onClick = {},
              modifier = Modifier.padding(4.dp),
              selected = true,
              colors = InputChipDefaults.inputChipColors(
                labelColor = Color.Black,
              )
            )
          }
        }

      }
    }
  }
}