package com.example.jetpackcomposecatalog2

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Icon

@Composable
@Preview
fun RetoTwitterPreview(){
    RetoTwitter()
}



@Composable
fun RetoTwitter(){
    var chat by remember { mutableStateOf(false)}
    var rt by remember { mutableStateOf(false)}
    var like by remember { mutableStateOf(false)}
    Row(modifier = Modifier
//        .fillMaxSize()

        .background(Color(0xff161d26))
        .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile) ,
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .size(55.dp)
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            Row (Modifier.fillMaxWidth()){
                TextTitle(title = "Yonissa", Modifier.padding(end = 8.dp))
                DefaultTitle(title = "@Yonissa Jaquez",Modifier.padding(end = 8.dp))
                DefaultTitle(title = "4hs",Modifier.padding(end = 8.dp))
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "",
                    tint = Color.White

                )
            }
            TextBody(text = "Estamos buscando un Programador" +
                    "Estamos buscando un Programador" +
                    "Estamos buscando un Programador" +
                    "Estamos buscando un Programador" ,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "" ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(10)),
                contentScale = ContentScale.Crop
            )
            Row(Modifier.padding(top = 16.dp)
            ) {
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_chat),
                            contentDescription = "",
                            tint = Color(0xff7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_chat_filled),
                            contentDescription = "",
                            tint = Color(0xff7E8B98)
                        )
                    },
                    isSelected = chat
                ) {
                    chat = !chat
                }

                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color(0xff7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_rt),
                            contentDescription = "",
                            tint = Color(0xff00ff27)
                        )
                    },
                    isSelected = rt
                ) {
                    rt = !rt
                }
                SocialIcon(
                    modifier = Modifier.weight(1f),
                    unselectedIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = "",
                            tint = Color(0xff7E8B98)
                        )
                    },
                    selectedIcon = {
                        Icon(painter = painterResource(id = R.drawable.ic_like_filled),
                            contentDescription = "",
                            tint = Color(0xffff0000)
                        )
                    },
                    isSelected = like
                ) {
                    like = !like
                }
            }
        }

    }

}
@Composable
fun SocialIcon(
    modifier: Modifier,
    unselectedIcon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit,
    isSelected:Boolean,
    onItemSelected: () -> Unit
    ){
    var defaultValue = 1
    Row (
        modifier = modifier.clickable { onItemSelected() },
        verticalAlignment = Alignment.CenterVertically
    ){
        if (isSelected){
            selectedIcon()
        }else{
            unselectedIcon()
        }
        Text(
            text = if (isSelected)(defaultValue +1).toString() else defaultValue.toString(),
            color = Color(0xff7E8B98),
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 4.dp)
        )

    }

}


@Composable
fun TextBody(text : String, modifier: Modifier = Modifier){
    Text(text = text, color = Color.White,  modifier = modifier)

}

@Composable
fun TextTitle(title: String, modifier: Modifier = Modifier){
    Text(text = title, color = Color.White, fontWeight = FontWeight.ExtraBold, modifier = modifier)

}
@Composable
fun DefaultTitle(title: String, modifier: Modifier = Modifier){
    Text(text = title, color = Color.Gray,  modifier = modifier)

}
@Composable
fun TuitDivider(){
    Divider(
        Modifier
            .padding(top = 4.dp)
            .height(1.dp)
            .fillMaxWidth(),
        color = Color(0xff7E8B98)
    )
}

