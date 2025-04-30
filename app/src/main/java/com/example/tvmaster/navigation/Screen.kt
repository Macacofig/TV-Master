package com.example.tvmaster.navigation

sealed class Screen(val route: String) {
    object ControlScreen : Screen("control")
    object SplashScreen: Screen("splash")
    object ConexionScreen: Screen("conexion")
    object ConexionFailedScreen: Screen("conexionfailed")
    object InicioMetodosScreen: Screen("inicio_metodos")
    object MenuScreen: Screen("menu")
    object SettingsScreen: Screen("settings")
}