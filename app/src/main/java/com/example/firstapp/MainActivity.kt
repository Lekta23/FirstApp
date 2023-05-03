package com.example.firstapp

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.InputChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.imageLoader
import coil.request.ImageRequest
import com.example.firstapp.ui.theme.FirstAppTheme

class MainActivity : ComponentActivity() {
  @OptIn(ExperimentalMaterial3Api::class)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val listChips = listOf("filter1", "filter2")
    setContent {
      FirstAppTheme {
        Scaffold(
          topBar = {
            TopAppBar(
              title = { Text(text = "Good Morning") },
              colors = TopAppBarDefaults.smallTopAppBarColors(
                titleContentColor = Color.White,
                containerColor = Color.Black,
              ),
              actions = {
                Icon(
                  painter = painterResource(id = R.drawable.ic_baseline_snowshoeing_24),
                  contentDescription = "Lala"
                )
                Icon(
                  painter = painterResource(id = R.drawable.ic_baseline_whatshot_24),
                  contentDescription = null
                )
              }
            )
          },
          bottomBar = {
            NavigationBar(containerColor = Color.Black) {
              NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(selectedTextColor = Color.White),
                selected = true,
                onClick = {},
                label = { Text(text = "Carte SD") },
                icon = {
                  Icon(
                    painter = painterResource(id = R.drawable.vc_baseline_sd_card_24),
                    contentDescription = null
                  )
                }
              )
              NavigationBarItem(selected = true, onClick = {}, icon = {})
              NavigationBarItem(selected = true, onClick = {}, icon = {})
            }
          }

        ) {
          Column(modifier = Modifier.padding(it)) {
            LazyRow() {
              items(listChips) { item ->
                InputChip(
                  label = { Text(text = item) },
                  onClick = {},
                  modifier = Modifier.padding(4.dp),
                  selected = true,
                )
              }
            }
            for(i in 1..3) {
              Row(
                modifier = Modifier
                  .padding(12.dp, 0.dp)
                  .height(60.dp)
              ) {
                Card(
                  modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                  colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                  )
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                      modifier = Modifier.weight(0.25f),
                      model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                        .build(),
                      contentDescription = null,
                      contentScale = ContentScale.Crop,
                    )
                    Text(
                      modifier = Modifier
                        .weight(.7f)
                        .padding(10.dp),
                      text = "Hello",
                      textAlign = TextAlign.Center
                    )
                  }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Card(
                  modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                  colors = CardDefaults.cardColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                  )
                ) {
                  Row(verticalAlignment = Alignment.CenterVertically) {
                    AsyncImage(
                      modifier = Modifier.weight(0.25f),
                      model = ImageRequest.Builder(LocalContext.current)
                        .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                        .build(),
                      contentDescription = null,
                      contentScale = ContentScale.Crop,
                    )
                    Text(
                      modifier = Modifier
                        .weight(.7f)
                        .padding(10.dp),
                      text = "Hello",
                      textAlign = TextAlign.Center
                    )
                  }
                }
              }
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
              AsyncImage(
                // image en rond
                model = ImageRequest.Builder(LocalContext.current)
                  .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                  .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                  .weight(0.25f)
                  .padding(10.dp)
                  .size(80.dp)
                  .clip(CircleShape)
              )
              Column(modifier = Modifier.weight(0.75f)) {
                Text(
                  text = "Titre de la musique",
                  textAlign = TextAlign.Center
                )
                Text(
                  text = "Titre de l'artiste",
                  textAlign = TextAlign.Center,
                  fontWeight = FontWeight.Bold
                )
              }
              }
            }
          }
        }
      }
    }
  }

  @Composable
  fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
      text = "Hello $name!",
      modifier = modifier
    )
  }

  @Preview(showBackground = true)
  @Composable
  fun GreetingPreview() {
    FirstAppTheme {
      Greeting("Android")
    }
  }