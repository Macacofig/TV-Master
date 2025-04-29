package com.example.tvmaster.dvd

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest


@Composable
fun SplashScreen(navController: NavController, viewModel: SplashViewModel = viewModel()) {
    var textColor by remember { mutableStateOf(Color.White) }
    val transition = rememberInfiniteTransition()

    val dx by transition.animateFloat(
        initialValue = -100f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    val dy by transition.animateFloat(
        initialValue = -100f,
        targetValue = 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    // Cambio de color del texto cada 2 segundos
    LaunchedEffect(Unit) {
        while (true) {
            textColor = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow, Color.Cyan, Color.Magenta, Color.White).random()
            delay(2000)
        }
    }

    // Observar el ViewModel para la navegación
    LaunchedEffect(viewModel) {
        viewModel.navigateToHome.collectLatest { shouldNavigate ->
            if (shouldNavigate) {
                navController.navigate("home") {
                    popUpTo("splash") { inclusive = true }
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "TV Master",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.offset(dx.dp, dy.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    // Creamos un NavController para el preview
    val navController = rememberNavController()

    // Definimos el NavHost con la ruta "splash"
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
    }
}
