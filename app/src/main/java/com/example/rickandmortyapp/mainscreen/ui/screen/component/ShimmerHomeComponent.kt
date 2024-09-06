package com.example.rickandmortyapp.mainscreen.ui.screen.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.mainscreen.ui.model.HomeCharacterCard

@Preview(showSystemUi = true)
@Composable
fun PreviewSkeleton(){
    HomeSkeleton()
}

@Composable
fun HomeSkeleton(){

    Column(
        modifier = Modifier
            .background(Color.White)
    ) {

        repeat(2){
            Row {
                repeat(2){
                    OutlinedCard(
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(2f)
                            .height(330.dp)
                    ) {
                        SkeletonComponent(modifier = Modifier
                            .size(250.dp)
                            .fillMaxWidth()
                        )

                        SkeletonComponent(modifier = Modifier
                            .height(30.dp)
                            .width(150.dp)
                            .padding(8.dp)

                        )
                    }
                }
            }
        }
    }
}


@Composable
fun SkeletonComponent(
    modifier: Modifier,
    colorBase : Color = colorResource(id = R.color.color_gray),
    colorTransition : Color = colorResource(id = R.color.white)
){
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation by transition.animateColor(
        initialValue = colorBase,
        targetValue = colorTransition,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 500,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Box(modifier = modifier.drawBehind { drawRect(translateAnimation) })
}