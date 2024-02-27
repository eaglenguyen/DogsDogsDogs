package com.example.imgurcomposefinal.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.imgurcomposefinal.data.remote.dto.Image

@Composable
fun ImgurItems(
    image: Image,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        val imageMods = Modifier.border(BorderStroke(1.dp, Color.Black)).aspectRatio(16f / 9f )
        // removes .mp4 files
        val imageLink = if (!image.link.contains("mp4")) {
            image.link
        } else {
            return@Column
        }

        AsyncImage(
            modifier = imageMods,
            model = imageLink,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
//
//        Text(
//            text = image.id,
//            fontSize = 16.sp,
//            fontWeight = FontWeight.Bold,
//            color = Color.Black
//        )

    }
}