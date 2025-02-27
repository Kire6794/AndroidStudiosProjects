package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceApp()
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val artworks = listOf(
        Triple(R.drawable.artwork1, R.string.starry_night_title, R.string.starry_night_details),
        Triple(R.drawable.artwork2, R.string.sunflowers_title, R.string.sunflowers_details),
        Triple(R.drawable.artwork3, R.string.cafe_terrace_title, R.string.cafe_terrace_details)
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color(0xFFF8F5F2)), // Light background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Artwork Image Frame
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            modifier = Modifier
                .padding(16.dp)
                .shadow(8.dp)
        ) {
            Image(
                painter = painterResource(id = artworks[currentIndex].first),
                contentDescription = "Artwork",
                modifier = Modifier
                    .size(300.dp)
                    .border(4.dp, Color.White, RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Artwork Description
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(8.dp))
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = artworks[currentIndex].second),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(id = artworks[currentIndex].third),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { currentIndex = (currentIndex - 1 + artworks.size) % artworks.size },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF475569))
            ) {
                Text(stringResource(id = R.string.previous_button), color = Color.White)
            }

            Button(
                onClick = { currentIndex = (currentIndex + 1) % artworks.size },
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF475569))
            ) {
                Text(stringResource(id = R.string.next_button), color = Color.White)
            }
        }
    }
}
