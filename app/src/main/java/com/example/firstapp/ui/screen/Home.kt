package com.example.firstapp.ui.screen
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.firstapp.R
import java.lang.reflect.Array

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {

  val listChips = listOf("Musique", "Podcasts et émissions");
  val listAlbum = listOf("Vald, Damso, Gazo", "Damso, Gazo", "PLK, Jul, Ninho");
  val listPodcast = listOf(
    arrayOf("Actualité et politique", "Les actus du jours - Je ne suis pas affiché", "Emission - Hugo Décripte"),
    arrayOf("Humour", "La table et les mots", "Emission - Jean et Alain"),
    arrayOf("Art et littérature", "Le Popcorn, c'est bon", "Emission - René Honteux à jamais dans mon coeur")
  )
  val listEcoute = arrayListOf("Roosevelt - Passion", "Used To The Silence", "We own the night");

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            text = "Bonjour",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
          ) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
          titleContentColor = Color.White,
          containerColor = Color.DarkGray,
        ),
        actions = {
          Icon(
            painter = painterResource(id = R.drawable.ic_notifications_24),
            contentDescription = "Notification",
            modifier = Modifier.padding(5.dp),
            tint = Color.White,
          )
          Icon(
            painter = painterResource(id = R.drawable.ic_access_time_24),
            contentDescription = "Regarder plus tard",
            modifier = Modifier.padding(5.dp),
            tint = Color.White,
          )
          Icon(
            painter = painterResource(id = R.drawable.ic_settings_24),
            contentDescription = "Paramètres",
            modifier = Modifier.padding(5.dp),
            tint = Color.White,
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
          selected = false,
          onClick = {},
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
          selected = false,
          onClick = {},
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
        .verticalScroll(state = rememberScrollState(), enabled = true),
    ) {
      Column(modifier = Modifier.padding(it)) {

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

        for (i in 1..3) {
          Row(
            modifier = Modifier
              .padding(1.dp, 0.dp)
              .height(100.dp)
          ) {
            Card(
              modifier = Modifier
                .weight(1f)
                .height(80.dp),
              colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
              )
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                  modifier = Modifier.weight(0.40f),
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
                  text = "Titre de la musique",
                  textAlign = TextAlign.Center
                )
              }
            }
            Spacer(modifier = Modifier.width(12.dp))
            Card(
              modifier = Modifier
                .weight(1f)
                .height(80.dp),
              colors = CardDefaults.cardColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White
              )
            ) {
              Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                  modifier = Modifier.weight(0.40f),
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
                  text = "Titre de la musique",
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
              text = "Plus du genre de",
              color = Color.Gray,
              textAlign = TextAlign.Center
            )
            Text(
              text = "Vald",
              color = Color.White,
              fontSize = 30.sp,
              textAlign = TextAlign.Center,
              fontWeight = FontWeight.Bold
            )
          }
        }

        LazyRow(
          modifier = Modifier.fillMaxWidth(),
          contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
          items(listAlbum) {item ->
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .weight(0.40f)
                .width(150.dp)
                .aspectRatio(1f)
                .padding(1.dp),
            ) {
              AsyncImage(
                modifier = Modifier
                  .weight(0.7f)
                  .height(150.dp),
                model = ImageRequest.Builder(LocalContext.current)
                  .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                  .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
              )
              Text(
                modifier = Modifier.fillMaxWidth(),
                color = Color.LightGray,
                fontSize = 15.sp,
                text = item,
                softWrap = true,
              )
            }
          }
        }

        Row(
          modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 0.dp),
        ) {
          Text(
            text = "Les Meilleurs Podcasts",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
          )
        }

        LazyRow(
          modifier = Modifier.fillMaxWidth(),
          contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
          items(listPodcast) { array ->
            val podcastCategory = array[0];
            val podcastTitle = array[1];
            val podcastCreator = array[2];

            Column(
              modifier = Modifier
                .fillMaxWidth()
                .width(170.dp)
                .aspectRatio(1f)
                .padding(0.dp, 0.dp, 20.dp, 0.dp),
            ) {
              AsyncImage(
                modifier = Modifier
                  .weight(1f)
                  .height(150.dp)
                  .clip(shape = RoundedCornerShape(15.dp)),
                model = ImageRequest.Builder(LocalContext.current)
                  .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                  .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
              )
              Text(
                modifier = Modifier
                  .fillMaxWidth(),
                color = Color.Green,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                text = podcastCategory,
                softWrap = true,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
              Text(
                modifier = Modifier
                  .fillMaxWidth(),
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                text = podcastTitle,
                softWrap = true,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
              Text(
                modifier = Modifier
                  .fillMaxWidth(),
                color = Color.LightGray,
                fontSize = 15.sp,
                text = podcastCreator,
                softWrap = true,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
              )
            }
          }
        }

        Row(
          modifier = Modifier.padding(0.dp, 40.dp, 0.dp, 0.dp),) {
          Text(
            text = "Ecoutés récemment",
            fontSize = 30.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
          )
        }

        LazyRow(
          modifier = Modifier.fillMaxWidth(),
          contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
          items(listEcoute) {item ->
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .weight(0.40f)
                .width(130.dp)
                .aspectRatio(1f)
                .padding(10.dp, 0.dp),
            ) {
              AsyncImage(
                modifier = Modifier
                  .weight(0.7f)
                  .height(130.dp),
                model = ImageRequest.Builder(LocalContext.current)
                  .data("https://images.unsplash.com/photo-1550745165-9bc0b252726f?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80")
                  .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
              )

              Text(
                modifier = Modifier
                  .fillMaxWidth(),
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                text = item,
                softWrap = true,
              )
            }
          }
        }

      }
    }
  }
}