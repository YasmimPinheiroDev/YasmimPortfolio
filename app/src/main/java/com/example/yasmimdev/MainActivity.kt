package com.example.yasmimdev

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yasmimdev.ui.theme.YasmimDevTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var darkMode by remember { mutableStateOf(false) }

            YasmimDevTheme(darkTheme = darkMode) {
                NavegacaoApp(
                    darkMode = darkMode,
                    onToggleTheme = { darkMode = !darkMode }
                )
            }
        }
    }
}

@Composable
fun NavegacaoApp(
    darkMode: Boolean,
    onToggleTheme: () -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {
            TelaPrincipal(
                navController,
                darkMode,
                onToggleTheme
            )
        }

        composable("projetos") {
            TelaProjetos(navController)
        }
    }
}

@Composable
fun TelaPrincipal(
    navController: NavController,
    darkMode: Boolean,
    onToggleTheme: () -> Unit
) {
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {

            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(onClick = onToggleTheme) {
                    Text(if (darkMode) "Modo Claro ☀" else "Modo Escuro 🌙")
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Yasmim Pinheiro",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Text("24 anos")
                Text("Santa Bárbara d'Oeste - SP")
                Text("1º semestre - Análise e Desenvolvimento de Sistemas")

                Spacer(modifier = Modifier.height(10.dp))

                Text("Sobre mim:", fontWeight = FontWeight.Bold)

                Text(
                    "Estou aprendendo Kotlin e me apaixonando pelo desenvolvimento mobile Android. Este é meu primeiro projeto criado no Android Studio."
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text("Objetivo:", fontWeight = FontWeight.Bold)

                Text(
                    "Busco uma oportunidade na área de T.I. para adquirir experiência, evoluir profissionalmente e contribuir com dedicação e responsabilidade."
                )

                Spacer(modifier = Modifier.height(16.dp))

                BotaoSurpreendente("Falar comigo no WhatsApp") {
                    val url = "https://wa.me/5519998530106"
                    context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                }

                BotaoSurpreendente("Enviar Email") {
                    val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:YasmimPinheiroDev@gmail.com")
                    }
                    context.startActivity(emailIntent)
                }

                BotaoSurpreendente("Ver meus futuros projetos") {
                    navController.navigate("projetos")
                }
            }
        }
    }
}

@Composable
fun TelaProjetos(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Text(
                text = "Meus Futuros Projetos",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Text("• Futuro projeto")
            Text("• Futuro projeto")
            Text("• Futuro projeto")
            Text("• Futuro projeto")

            BotaoSurpreendente("Voltar") {
                navController.popBackStack()
            }
        }
    }
}

@Composable
fun BotaoSurpreendente(
    texto: String,
    onClick: () -> Unit
) {

    var pressed by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.92f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy
        ), label = ""
    )

    val infiniteTransition = rememberInfiniteTransition(label = "")

    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.3f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val gradientShift by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing)
        ), label = ""
    )

    val brush = Brush.linearGradient(
        colors = listOf(
            Color(0xFFFF4EC4),
            Color(0xFF9C27B0),
            Color(0xFF00E5FF)
        ),
        start = Offset(gradientShift, 0f),
        end = Offset(gradientShift + 300f, 300f)
    )

    Box(
        modifier = Modifier
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                shadowElevation = 20f
                shape = RoundedCornerShape(30.dp)
                clip = true
            }
            .background(brush)
            .border(
                width = 2.dp,
                color = Color.White.copy(alpha = glowAlpha),
                shape = RoundedCornerShape(30.dp)
            )
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) {
                pressed = true
                onClick()
            }
            .padding(horizontal = 40.dp, vertical = 18.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = texto,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }

    LaunchedEffect(pressed) {
        if (pressed) {
            delay(150)
            pressed = false
        }
    }
}