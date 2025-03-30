package com.control.app.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.automirrored.filled.VolumeDown
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ControlScreen(viewModel: FakeControlViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fila superior: Apagar - Inicio
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ControlButton(icon = Icons.Filled.PowerSettingsNew, onClick = { viewModel.onApagarClicked() })
            ControlButton(icon = Icons.Filled.Home, onClick = { /* Acción para Home */ })
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Fila media: Micrófono - Atrás
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ControlButton(icon = Icons.Default.KeyboardVoice, onClick = { /* Acción de micrófono */ })
            Spacer(modifier = Modifier.width(40.dp))
            ControlButton(icon = Icons.AutoMirrored.Filled.ArrowBack, onClick = { /* Acción de volver */ })

        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botones direccionales
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ControlButton(icon = Icons.Filled.KeyboardArrowUp, onClick = { /* Acción arriba */ })
            Row {
                ControlButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft, onClick = { /* Acción izquierda */ })
                Spacer(modifier = Modifier.width(40.dp))
                ControlButton(icon = Icons.AutoMirrored.Filled.KeyboardArrowRight, onClick = { /* Acción derecha */ })
            }
            ControlButton(icon = Icons.Filled.KeyboardArrowDown, onClick = { /* Acción abajo */ })
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botones de volumen y canal
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ControlButton(icon = Icons.AutoMirrored.Filled.VolumeUp, onClick = { /* Subir volumen */ })
                ControlButton(icon = Icons.AutoMirrored.Filled.VolumeDown, onClick = { /* Bajar volumen */ })
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ControlButton(icon = Icons.Default.Add, onClick = { /* Subir canal */ })
                ControlButton(icon = Icons.Default.Remove, onClick = { /* Bajar canal */ })
            }
        }
    }
}

@Composable
fun ControlButton(icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(50.dp)
            .background(Color.Gray, shape = CircleShape)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true)
@Composable
fun PreviewControlScreen() {
    ControlScreen(viewModel = FakeControlViewModel())
}