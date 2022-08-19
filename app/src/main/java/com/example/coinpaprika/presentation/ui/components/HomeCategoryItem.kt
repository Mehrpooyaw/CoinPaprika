package com.example.coinpaprika.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun HomeCategoryItem(
    modifier: Modifier,
    resource : Int,
    title : String,
    onClick : () -> Unit
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surface.copy(0.6f)).clickable {
                onClick()
            }.padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(painter = painterResource(id = resource), contentDescription ="home_category_item",
        modifier = modifier
            .fillMaxWidth(0.4f)
            .aspectRatio(1f))
        Spacer(modifier = modifier.size(10.dp))
        TextWithShadow(text = title)
    }

}