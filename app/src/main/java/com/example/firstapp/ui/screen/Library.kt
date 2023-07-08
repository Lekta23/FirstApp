package com.example.firstapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.firstapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Library(navController: NavController) {

  val listChips = listOf("Album", "Playlist", "Artiste", "Téléchargé");

  val listCard = listOf(
    arrayOf("Playlist", "Infopel", "Jean Delamasse"),
    arrayOf("Playlist", "Babe", "Richard Dessis"),
    arrayOf("Playlist", "Vicetone", "Lionel David"),
    arrayOf("Album", "V", "Chalk"),
    arrayOf("Album", "Vald", "Jin Vitz"),
    arrayOf("Playlist", "Plus d'inspi", "Lasté")
  )

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

      Column(modifier = Modifier.padding(it)) {
        LazyRow() {
          items(listChips) { item ->
            InputChip(
              label = { Text(text = item, color = Color.DarkGray) },
              onClick = {},
              modifier = Modifier
                .padding(4.dp),
              selected = true,
            )
          }
        }

        Row(
          modifier = Modifier.padding(12.dp, 20.dp),
          verticalAlignment = Alignment.CenterVertically,
        ) {
          Icon(
            painter = painterResource(id = R.drawable.ic_import_export_24),
            contentDescription = null,
            tint = Color.LightGray,
          )
          Text(
            text = "Récents",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
          )
          Spacer(Modifier.weight(1f))
          Icon(
            painter = painterResource(id = R.drawable.ic_grid_view_24),
            contentDescription = null,
            tint = Color.LightGray,
          )
        }


        listCard.forEach { array ->
          val cardType = array[0];
          val cardName = array[1];
          val cardAuthor = array[2];

          Row(
            modifier = Modifier.padding(12.dp, 20.dp),
            verticalAlignment = Alignment.CenterVertically,
          ) {
            AsyncImage(
              modifier = Modifier
                .weight(0.25f)
                .aspectRatio(1f),
              model = ImageRequest.Builder(LocalContext.current)
                .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                .build(),
              contentDescription = null,
              contentScale = ContentScale.Crop,
            )

            Column(modifier = Modifier
              .weight(0.75f)
              .padding(start = 20.dp),
            ) {
              Text(
                text = cardName,
                fontSize = 20.sp,
                color = Color.LightGray,
                fontWeight = FontWeight.Bold
              )
              Text(
                text = "$cardType - $cardAuthor",
                fontSize = 15.sp,
                color = Color.Gray,
              )
            }

          }


        }



      }
    }
  }
}