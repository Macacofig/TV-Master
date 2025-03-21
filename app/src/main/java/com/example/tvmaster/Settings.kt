package com.example.tvmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvmaster.R

class Settings : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsScreen()
        }
    }
}

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Fondo oscuro
            .padding(16.dp)
    ) {
        Icon(
            painter = painterResource(id = android.R.drawable.ic_menu_manage), // Ícono de ajustes
            contentDescription = stringResource(id = R.string.settings_title),
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .padding(bottom = 16.dp)
        )

        SettingsOption(stringResource(id = R.string.theme_option))
        SettingsOption(stringResource(id = R.string.customize_buttons))
        SettingsOption(stringResource(id = R.string.language_option))
        SettingsOption(stringResource(id = R.string.info_option))

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "${stringResource(id = R.string.app_version)}\n" +
                    "${stringResource(id = R.string.developers)}\n" +
                    "${stringResource(id = R.string.created_with)}\n" +
                    "${stringResource(id = R.string.leave_feedback)}",
            color = Color.White,
            fontSize = 14.sp,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.weight(1f))

        Icon(
            painter = painterResource(id = android.R.drawable.ic_media_rew), // Ícono de volver
            contentDescription = "Back Icon",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent, shape = CircleShape)
                .clickable { }
        )
    }
}

@Composable
fun SettingsOption(title: String) {
    Column {
        Text(
            text = title,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Divider(color = Color.White, thickness = 1.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingsScreen() {
    SettingsScreen()
}