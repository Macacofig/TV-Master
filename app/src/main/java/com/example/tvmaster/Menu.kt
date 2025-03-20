package com.example.tvmaster

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.traceEventEnd
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tvmaster.ui.theme.TVMasterTheme

@Composable
fun MenuPantalla() {
    val semiPlomo = Color(red = 40, green = 40, blue = 40, alpha = 180)
    val plomoClaro = Color(red = 61, green = 61, blue = 61)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.fondomenu),
                contentScale = ContentScale.Crop
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xCC000000),
                            Color.Transparent//Lo pone transparente
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    painter = painterResource(id = R.drawable.ic_volver),
                    contentDescription = "Remote Control",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            //Acción al hacer clic
                        },
                    tint = Color.Unspecified
                )
                Text(
                    text = "Nombre TV",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Black),
                    color = Color.White,
                    fontSize = 26.sp
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                //Aplicaciones
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = semiPlomo
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = plomoClaro)
                            .fillMaxWidth()
                            .height(35.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.card01),
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Column(
                                modifier = Modifier
                                    .height(110.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.netflix),
                                    contentDescription = "Netflix",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            //Acción al hacer clic
                                        },
                                    tint = Color.Unspecified
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(top = 5.dp),
                                    text = "Netflix",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .height(110.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.youtube),
                                    contentDescription = "YouTube",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            //Acción al hacer clic
                                        },
                                    tint = Color.Unspecified
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(top = 5.dp),
                                    text = "YouTube",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .height(110.dp),
                                verticalArrangement = Arrangement.SpaceEvenly,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.primevideo),
                                    contentDescription = "Prime Video",
                                    modifier = Modifier
                                        .size(80.dp)
                                        .clickable {
                                            //Acción al hacer clic
                                        },
                                    tint = Color.Unspecified
                                )
                                Text(
                                    modifier = Modifier
                                        .padding(top = 5.dp),
                                    text = "Prime Video",
                                    color = Color.White,
                                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold)
                                )
                            }
                        }
                    }
                }
                //Mando a distancia
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = semiPlomo
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = plomoClaro)
                            .fillMaxWidth()
                            .height(35.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.card02),
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp),
                            text = stringResource(id = R.string.texto_card02),
                            color = Color.White,
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .background(color = Color.Black),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.control),
                                contentDescription = "Remote Control",
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(top = 8.dp)
                                    .clickable {
                                        // Acción al hacer clic
                                    },
                                tint = Color.Unspecified,
                            )
                        }
                    }
                }
                //Compartir contenido
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(
                        containerColor = semiPlomo
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(color = plomoClaro)
                            .fillMaxWidth()
                            .height(35.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.card03),
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(bottom = 8.dp),
                            text = stringResource(id = R.string.texto_card03),
                            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape)
                                .background(color = Color.Black),
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                painter = painterResource(id = R.drawable.share),
                                contentDescription = "Remote Control",
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(top = 8.dp)
                                    .clickable {
                                        // Acción al hacer clic
                                    },
                                tint = Color.Unspecified,
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuPantalla() {
    MenuPantalla()
}