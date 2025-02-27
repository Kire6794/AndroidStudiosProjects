package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.counterapp.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                CounterScreen()
            }
        }
    }
}

@Composable
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Yellow, Color.Green)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Counter number
            Text(text = "$count", fontSize = 80.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(32.dp)) // More space

            // Row with + and - buttons
            Row {
                Button(
                    onClick = { count++ },
                    modifier = Modifier
                        .padding(12.dp)
                        .size(90.dp),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(text = "+", fontSize = 40.sp)
                }

                Spacer(modifier = Modifier.width(24.dp))

                Button(
                    onClick = { if (count > 0) count-- },
                    modifier = Modifier
                        .padding(12.dp)
                        .size(90.dp),
                    shape = RoundedCornerShape(50),
                    enabled = count > 0
                ) {
                    Text(text = "-", fontSize = 40.sp)
                }
            }

            Spacer(modifier = Modifier.height(24.dp)) // Space before reset button

            // Reset button
            Button(
                onClick = { count = 0 },
                modifier = Modifier
                    .padding(12.dp)
                    .size(120.dp, 60.dp), // Bigger button for emphasis
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red) // Red color for visibility
            ) {
                Text(text = "Reset", fontSize = 28.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    CounterAppTheme {
        CounterScreen()
    }
}
