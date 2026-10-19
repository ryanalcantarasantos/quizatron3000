package com.example.listadeexercicios

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizatron3000.R


data class Questao(
    val pergunta: String,
    val opcoes: List<String>,
    val correta: Int
)


val listaQuestoes = listOf(
    Questao("Qual é a capital da França?", listOf("Londres", "Berlim", "Paris", "Madri"), 2),
    Questao("Quanto é 2 + 2?", listOf("3", "4", "5", "6"), 1),
    Questao("Qual é a cor do céu?", listOf("Azul", "Verde", "Roxo", "Preto"), 0)
)

@Composable
fun Pergunta1(modifier: Modifier = Modifier) {

    var indice by remember { mutableStateOf(0) }
    val questao = listaQuestoes[indice]

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFF80AB))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF66BB6A),
                contentColor = Color.Black
            ),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Text(
                text = "Pergunta ${indice + 1} de ${listaQuestoes.size}",
                fontSize = 18.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = questao.pergunta,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                questao.opcoes.forEach { opcao ->
                    OpcaoResposta(
                        texto = opcao,
                        onClick = {
                            if (indice < listaQuestoes.size - 1) {
                                indice++
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun OpcaoResposta(texto: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black
        )
    ) {
        Text(
            text = texto,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}