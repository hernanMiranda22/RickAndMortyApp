package com.example.rickandmortyapp.detailscreen.ui.screen.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rickandmortyapp.R

@Composable
fun SkeletonDetails(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.white))
    ) {
        OutlinedCard(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.white)
            ),
            shape = RoundedCornerShape(bottomStart = 8.dp ,bottomEnd = 8.dp)
        ) {

            Row(modifier =  Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                SkeletonContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                )

                Column(modifier = Modifier
                    .padding(start = 24.dp)
                    .weight(2f)
                ) {

                    SkeletonContent(
                        modifier = Modifier
                            .height(20.dp)
                            .width(200.dp)
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    repeat(3){

                        SkeletonContent(
                            modifier = Modifier
                                .height(15.dp)
                                .width(150.dp)
                        )

                        Spacer(modifier = Modifier.size(8.dp))
                    }
                }
            }
        }

        repeat(6){
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFa3a3a3)
                )
            ) {


                SkeletonContent(modifier = Modifier
                    .height(35.dp)
                    .width(200.dp)
                    .padding(8.dp)
                )



                SkeletonContent(modifier = Modifier
                    .height(30.dp)
                    .width(200.dp)
                    .padding(8.dp)
                )



                SkeletonContent(modifier = Modifier
                    .height(30.dp)
                    .width(200.dp)
                    .padding(8.dp)
                )


            }
        }
    }
}

@Composable
private fun SkeletonContent(
    modifier: Modifier,
    colorBase : Color = colorResource(id = R.color.color_gray),
    colorTransition : Color = colorResource(id = R.color.white)
){
    val transition = rememberInfiniteTransition(label = "")

    val animation by transition.animateColor(
        initialValue = colorBase,
        targetValue = colorTransition,
        animationSpec = infiniteRepeatable(
            animation =  tween(
                durationMillis = 500,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = ""
    )

    Box(modifier = modifier.drawBehind { drawRect(animation) })
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSkeletonDetail(){
    SkeletonDetails()
}