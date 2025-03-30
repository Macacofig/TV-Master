package com.control.app.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ControlScreen(viewModel: FakeControlViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(32.dp)
            .clip(RoundedCornerShape(16.dp))  // Margen con bordes redondeados como un control remoto
            .border(2.dp, Color.Gray, RoundedCornerShape(16.dp)), // Borde gris alrededor
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fila superior: Apagar - Inicio
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ControlButton(
                icon = Icons.Filled.PowerSettingsNew,
                onClick = { viewModel.onApagarClicked() },
                buttonColor = Color.Red // Botón rojo para apagar
            )
            ControlButton(
                icon = Icons.Filled.Home,
                onClick = { /* Acción para Home */ },
                buttonColor = Color.Blue // Botón azul para home
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fila media: Micrófono - Atrás
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            ControlButton(
                icon = Icons.Default.KeyboardVoice,
                onClick = { /* Acción de micrófono */ },
                buttonColor = Color.Gray // Botón gris para micrófono
            )
            Spacer(modifier = Modifier.width(40.dp))
            ControlButton(
                icon = Icons.AutoMirrored.Filled.ArrowBack,
                onClick = { /* Acción de volver */ },
                buttonColor = Color.Gray // Botón gris para "Atrás"
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botones direccionales
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ControlButton(
                icon = Icons.Filled.KeyboardArrowUp,
                onClick = { /* Acción arriba */ },
                buttonColor = Color.LightGray // Botón gris claro para arriba
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                ControlButton(
                    icon = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    onClick = { /* Acción izquierda */ },
                    buttonColor = Color.LightGray // Botón gris claro para izquierda
                )
                Spacer(modifier = Modifier.width(40.dp))
                ControlButton(
                    icon = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    onClick = { /* Acción derecha */ },
                    buttonColor = Color.LightGray // Botón gris claro para derecha
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            ControlButton(
                icon = Icons.Filled.KeyboardArrowDown,
                onClick = { /* Acción abajo */ },
                buttonColor = Color.LightGray // Botón gris claro para abajo
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botones de volumen y canal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ControlButton(
                    icon = Icons.AutoMirrored.Filled.VolumeUp,
                    onClick = { /* Subir volumen */ },
                    buttonColor = Color.Gray // Botón gris para subir volumen
                )
                ControlButton(
                    icon = Icons.AutoMirrored.Filled.VolumeDown,
                    onClick = { /* Bajar volumen */ },
                    buttonColor = Color.Gray // Botón gris para bajar volumen
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ControlButton(
                    icon = Icons.Default.Add,
                    onClick = { /* Subir canal */ },
                    buttonColor = Color.Gray // Botón gris para subir canal
                )
                ControlButton(
                    icon = Icons.Default.Remove,
                    onClick = { /* Bajar canal */ },
                    buttonColor = Color.Gray // Botón gris para bajar canal
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Óvalo con "TvMaster"
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .padding(top = 16.dp, bottom = 32.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "TvMaster",
                style = TextStyle(
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                ),
                modifier = Modifier
                    .background(Color.Gray.copy(alpha = 0.10f), shape = RoundedCornerShape(50)) // Forma ovalada
                    .padding(horizontal = 24.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun ControlButton(icon: ImageVector, onClick: () -> Unit, buttonColor: Color) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(70.dp)
            .padding(8.dp)
            .background(buttonColor, shape = CircleShape)
            .shadow(4.dp, shape = CircleShape)
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