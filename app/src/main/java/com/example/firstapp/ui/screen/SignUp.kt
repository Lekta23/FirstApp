package com.example.firstapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(navController: NavController) {

  val _emailTextFieldValue = remember { mutableStateOf(TextFieldValue("")) }
  val _passwordTextFieldValue = remember { mutableStateOf(TextFieldValue("")) }
  val _sexeM = remember { mutableStateOf(true) }
  val _sexeF = remember { mutableStateOf(false) }
  val PrenomTextFieldValue = remember { mutableStateOf(TextFieldValue("")) }
  val NomTextFieldValue = remember { mutableStateOf(TextFieldValue("")) }
  val textResult = remember { mutableStateOf("") }
  Scaffold() {

    Surface(
      color = Color.Black,
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(state = rememberScrollState(), enabled = true),
    ) {
      Column(modifier = Modifier.padding(it)) {
        Row(
          horizontalArrangement = Arrangement.Center,
          modifier =
          Modifier
            .padding(top = 120.dp)
            .fillMaxSize()
        ) {
          Text(text = "Inscription",fontSize = 35.sp, fontWeight = FontWeight.Bold,color = Color.White);
        }

        Column(modifier = Modifier.padding(20.dp)) {
          Text(
            text = "Je suis : ",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
              .padding(bottom = 10.dp)
          )

          Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
              selected = true,
              onClick = { _sexeM.value = true },
              modifier = Modifier.size(24.dp)
            )
            Text(text = "Homme", color = Color.White, modifier = Modifier.padding(start = 10.dp,end = 10.dp))

            RadioButton(
              selected = false,
              onClick = { _sexeF.value = true },
              modifier = Modifier.size(24.dp)
            )
            Text(text = "Femme", color = Color.White, modifier = Modifier.padding(start = 10.dp,end = 10.dp))
          }
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
          TextField(
            modifier = Modifier.weight(1f),
            value = PrenomTextFieldValue.value,
            onValueChange = {
              PrenomTextFieldValue.value = it
            },
            placeholder = { Text(text = "Prénom") },
            label = { Text(text = "Prénom") },
          )
          TextField(
            modifier = Modifier.weight(1f),
            value = NomTextFieldValue.value,
            onValueChange = {
              NomTextFieldValue.value = it
            },
            placeholder = { Text(text = "Nom") },
            label = { Text(text = "Nom") },
          )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
          TextField(
            modifier = Modifier.weight(1f),
            value = _emailTextFieldValue.value,
            onValueChange = {
              _emailTextFieldValue.value = it
            },
            placeholder = { Text(text = "Email") },
            label = { Text(text = "Email") },
          )
        }

        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(20.dp)) {
          TextField(
            modifier = Modifier.weight(1f),
            value = _passwordTextFieldValue.value,
            onValueChange = {
              _passwordTextFieldValue.value = it
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            placeholder = { Text(text = "Mot de passe") },
            label = { Text(text = "Mot de passe") },
          )
        }

        Column(
          modifier = Modifier
            .height(100.dp)
            .padding(20.dp)
            .fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
        ) {
          Row() {
            Button(
              modifier = Modifier.padding(end= 10.dp),
              onClick = {
                val firebaseAuth = Firebase.auth
                firebaseAuth.createUserWithEmailAndPassword(
                  _emailTextFieldValue.value.text,
                  _passwordTextFieldValue.value.text
                )
                  .addOnCompleteListener {
                    if (it.isSuccessful) {
                      val user = it.result.user
                      textResult.value = "Utilisateur créé avec succès"
                      val db = Firebase.firestore
                      val userTosave = hashMapOf(
                        "nom" to NomTextFieldValue.value.text,
                        "prenom" to PrenomTextFieldValue.value.text,
                        "sexe" to if (_sexeM.value) "M" else "F",
                        "email" to _emailTextFieldValue.value.text,
                        "password" to _passwordTextFieldValue.value.text,
                      )

                      navController.navigate("home")

                      if (user != null) {
                        db.collection("users").document(user.uid).set(userTosave)
                          .addOnSuccessListener { documentReference ->
                            println("DocumentSnapshot added with ID: ${documentReference}")
                          }
                          .addOnFailureListener { e ->
                            println("Error adding document: $e")
                          }
                      }
                    }
                  }.addOnFailureListener {
                    println("Error: $it")
                    textResult.value = "Erreur: $it"
                  }
              }) {
              Text(text = "Enregistrer")
            }
            Button(onClick = { navController.navigate("SignIn") }) {
              Text(text = "J'ai déjà un compte")
            }
          }

          Text(text = textResult.value, color = Color.White, fontWeight = FontWeight.Bold,)
        }
      }
    }
  }
}