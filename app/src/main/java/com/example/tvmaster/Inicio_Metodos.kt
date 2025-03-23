package com.example.tvmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

class InicioMetodos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("inicio") { HomeScreen(navController) }
        composable("metodo/{marca}") { backStackEntry ->
            val marca = backStackEntry.arguments?.getString("marca")
            if (marca != null) {
                MetodoScreen(navController, marca)
            }
        }
        composable("details") { DetailsScreen(navController) }
    }
}

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000) // Espera 3 segundos
        navController.navigate("inicio") // Navega a la pantalla de inicio
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Cargando...", fontSize = 24.sp, color = Color.White)
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo de pantalla
        Image(
            painter = painterResource(id = R.drawable.fondomenu), // Reemplaza con el nombre de tu imagen
            contentDescription = "Fondo de pantalla",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Ajusta la imagen al tamaño de la pantalla
        )

        // Contenido de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título
            Text(
                text = "TV Master",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp),
                color = Color.White
            )

            // Subtítulo
            Text(
                text = "Escoge la marca de tu televisor:",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White
            )

            // Lista de marcas
            val marcas = listOf("Samsung", "LG", "Sony")
            marcas.forEach { marca ->
                Button(
                    onClick = {
                        // Navegar a la pantalla de método
                        navController.navigate("metodo/$marca")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = marca)
                }
            }
        }
    }
}

@Composable
fun MetodoScreen(navController: NavController, marca: String) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo de pantalla
        Image(
            painter = painterResource(id = R.drawable.fondomenu), // Reemplaza con el nombre de tu imagen
            contentDescription = "Fondo de pantalla",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título
            Text(
                text = "Método:",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp),
                color = Color.White
            )

            // Opciones de método
            val metodos = listOf("WIFI", "InfraRojo")
            metodos.forEach { metodo ->
                Button(
                    onClick = {
                        // Aquí puedes agregar la lógica para manejar el método seleccionado
                        println("Marca: $marca, Método: $metodo")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {
                    Text(text = metodo)
                }
            }
        }
    }
}

@Composable
fun DetailsScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fondo de pantalla
        Image(
            painter = painterResource(id = R.drawable.fondomenu), // Reemplaza con el nombre de tu imagen
            contentDescription = "Fondo de pantalla",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Contenido de la pantalla
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Esta es la pantalla de detalles",
                fontSize = 24.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = {
                // Regresa a la pantalla anterior
                navController.popBackStack()
            }) {
                Text(text = "Regresar")
            }
        }
    }
}