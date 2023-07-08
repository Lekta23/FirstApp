package com.example.firstapp.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.firstapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(navController: NavController) {
  val rechercherTextFieldValue = remember { mutableStateOf(TextFieldValue("")) }

  val listColor = listOf(Color(225,51,1), Color(115,88,255), Color(30,50,100), Color(234,17,95), Color(190,89,1), Color(21,136,7), Color(33,46,116), Color(39,133,106));
  val listCardName = listOf("Podcasts", "Evenements live", "Concu spécialement pour vous", "Dernières sorties", "Hip-Hop", "Pop", "Variété Française", "Eté", "Classement", "Latino", "Ambiance", "Dance/Electro");

  Scaffold(

    topBar = {
      TopAppBar(
        title = {
          Text(
            text = "Rechercher",
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

        TextField(
          modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp, 0.dp)
            .clip(shape = RoundedCornerShape(10.dp)),
          value = rechercherTextFieldValue.value,
          onValueChange = {
            rechercherTextFieldValue.value = it
          },
          leadingIcon = {
            Icon(
              painter = painterResource(id = R.drawable.ic_baseline_search_24),
              contentDescription = "Rechercher",
              modifier = Modifier.padding(5.dp),
              tint = Color.DarkGray,
            )
          },
          placeholder = { Text(text = "Que souhaitez-vous écouter ?") },
          label = { Text(text = "Que souhaitez-vous écouter ?") },
        )

        Row(
          modifier = Modifier.padding(12.dp,20.dp),
        ) {
          Text(
            text = "Parcourir tout",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
          )
        }

        val numRows = (listCardName.size + 1) / 2

        for (row in 0 until numRows) {
          val startIndex = row * 2
          val endIndex = startIndex + 2
          val rowItems = listCardName.subList(startIndex, endIndex.coerceAtMost(listCardName.size))

          Row() {
            for (i in 0..1) {
              val randomColorIndex = (0 until listColor.size).random()

              Card(
                modifier = Modifier
                  .weight(1f)
                  .padding(start = 6.dp, end = 6.dp)
                  .height(100.dp),
                colors = CardDefaults.cardColors(
                  containerColor = listColor[randomColorIndex],
                  contentColor = Color.White
                )
              ) {
                Row() {
                  Text(
                    modifier = Modifier
                      .weight(.7f)
                      .padding(8.dp,10.dp,0.dp,0.dp),
                    text = rowItems[i],
                    fontWeight = FontWeight.Bold,
                  )
                  Box(
                    modifier = Modifier
                      .weight(0.40f)
                      .padding(top = 30.dp)
                      .rotate(20f)
                      .clip(shape = RoundedCornerShape(15.dp))
                  ) {
                    AsyncImage(
                      modifier = Modifier
                        .aspectRatio(1f),
                      model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                        .build(),
                      contentDescription = null,
                      contentScale = ContentScale.Crop,
                    )
                  }
                }
              }
            }
          }
          Spacer(modifier = Modifier.height(12.dp))
        }
      }
    }
  }
}