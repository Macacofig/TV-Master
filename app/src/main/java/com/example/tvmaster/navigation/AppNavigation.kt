package com.example.tvmaster.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import kotlinx.serialization.encodeToString
import java.net.URLDecoder
import java.net.URLEncoder
import java.util.UUID

import com.example.tvmaster.control.ControlUI
import com.example.tvmaster.dvd.SplashUI
import com.example.tvmaster.Conexion.ConexionUI
import com.example.tvmaster.ConexionFailed.ConexionFailedUI
import com.example.tvmaster.Settings.SettingsUI
import com.example.tvmaster.Menu.MenuUI
import com.example.tvmaster.DispositivosEncontrados.DispositivosEncontradosUI

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.DispositivosEncontradosScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    )
    {
//        composable(Screen.SplashScreen.route)
//        {
//            SplashUI(navController)
//        }

//        composable(Screen.MenuScreen.route)
//        {
//            DispositivosEncontradosUI()
//        }

        // Codigo para navegar hacia atras
        composable(Screen.DispositivosEncontradosScreen.route) {
            DispositivosEncontradosUI(
                onBackClick = { navController.popBackStack() }, // vuelve al menú
            )
        }
    }
}