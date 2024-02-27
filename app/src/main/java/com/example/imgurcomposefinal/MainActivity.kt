package com.example.imgurcomposefinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imgurcomposefinal.presentation.ImgurItems
import com.example.imgurcomposefinal.presentation.ImgurViewModel
import com.example.imgurcomposefinal.ui.theme.ImgurComposeFinalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImgurComposeFinalTheme {

                val viewModel: ImgurViewModel = hiltViewModel()
                val state = viewModel.state.value

                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)) {
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(state.imgList.size) {i ->
                                val listOfImages = state.imgList[i]?.images
                                val images = listOfImages?.get(0)
                                if (images != null) {
                                    ImgurItems(modifier = Modifier.padding(4.dp), image = images)
                                }

                            }
                        }

                    }
                }



            }
        }
    }
}


