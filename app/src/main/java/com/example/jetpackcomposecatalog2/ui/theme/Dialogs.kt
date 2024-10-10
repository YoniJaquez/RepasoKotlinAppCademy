package com.example.jetpackcomposecatalog2.ui.theme

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.jetpackcomposecatalog2.R


@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: ()-> Unit,
){
    if (show){
        Dialog(onDismissRequest = { onDismiss() }
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White).border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(10.dp))
            ) {
                MyTextDialog(text = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                var status by remember { mutableStateOf("") }

                ItemDialog(name = "Nathy",status ){ status = it}
                ItemDialog(name = "ANNA", status ){ status = it}
                ItemDialog(name = "CARI" ,status){ status = it}
                ItemDialog(name = "PAULA",status ){ status = it}
                Divider(Modifier.fillMaxWidth(), Color.LightGray)
                Row(Modifier.align(Alignment.End).padding(8.dp)
                ) {
                    TextButton(onClick = { }
                    ) {
                        Text(text = "CANCEL")
                    }
                    TextButton(onClick = { }
                    ) {
                        Text(text = "OK")
                    }
                }
                

            }

        }
    }

}







@Composable
fun ItemDialog(name: String,selectedName: String, onItemSelected:(String) -> Unit){
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding()){
            RadioButton(
                selected = name == selectedName, onClick = { onItemSelected (name)}
            )
            Text(text = name, modifier = Modifier.align(Alignment.CenterVertically))

        }

    }

}



@Composable
fun MyCustumDialog(
    show: Boolean,
    onDismiss: ()-> Unit,
){
    if (show){
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTextDialog(text = "Set backup Account")
                AccountItem(email = "luzbelle@gmail.com", drawable = R.drawable.circle_user )
                AccountItem(email = "AnnaMary@gmail.com", drawable = R.drawable.circle_user )
                AccountItem(email = "Nueva cuenta", drawable = R.drawable.circle_plus )
            }
        }


    }

}





@Composable
fun MySimpleCustumDialog(
    show: Boolean,
    onDismiss: ()-> Unit,
){
    if (show){
        Dialog(
            onDismissRequest = {onDismiss()},
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false)
        ) {

            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Estos es un emplo")
                Text(text = "Estos es un emplo")
                Text(text = "Estos es un emplo")
            }
        }
    }

}


@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: ()-> Unit,
    onConfirm: ()-> Unit
){
    if (show){
        AlertDialog(
            onDismissRequest = {  },
//        confirmButton = {
//            TextButton(onClick = {  }) {
//                Text(text = " confirmButton" )
//            }
//        },
//        dismissButton = {
//            TextButton(onClick = { }) {
//                Text(text = "DismissButton")
//            }
//        },

            buttons = {
                Row {

                    TextButton(onClick = { onConfirm() }) {
                        Text(text = " confirmButton" )
                    }

                    TextButton(onClick = {onDismiss() }) {
                        Text(text = "DismissButton")
                    }
                }
            },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola, puede confirmar su cita para el dia de mañana?") },
        )
    }


}

@Composable
fun AccountItem( email: String, @DrawableRes drawable: Int, ){
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier
                .padding(5.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(color = Color.Blue)


        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )

    }

}



@Composable
fun MyTextDialog(text: String, modifier: Modifier = Modifier.padding(bottom = 12.dp)){
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )

}