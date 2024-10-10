package com.example.jetpackcomposecatalog2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Badge
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.BadgedBox
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecatalog2.ui.theme.CheckInfo
import com.example.jetpackcomposecatalog2.ui.theme.JetpackComposeCatalog2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalog2Theme {
                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xff161d26))


                ) {
//                    var show by remember { mutableStateOf(false)
//                    }
//
//                    Box(
//                        modifier = Modifier
//                            .fillMaxSize()
//
//                    ){
//                        Button(
//                            onClick = { show = true },
//                            modifier = Modifier.align(Alignment.Center)) {
//                            Text(text = "Mostrar Dialog")
//                        }
//                        MyConfirmationDialog(show = show, onDismiss = {show = false})}
                    RetoTwitter()
                    TuitDivider()
                    RetoTwitter()


                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalog2Theme {

    }
}
@Composable
fun MyDropDowMenu(){
    var selectedText by remember { mutableStateOf("")}
    var expanded by remember { mutableStateOf(false) }
    val comidas = listOf("Milanesas", "Matahambre", "Tortillas", "Fideos", "Ravioles")

    Column(Modifier.padding(20.dp)
    ) {
        OutlinedTextField(
            value = selectedText ,
            onValueChange = {selectedText = it},
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false},
            modifier = Modifier.fillMaxWidth()
        ) {
            comidas.forEach{comidas ->
                DropdownMenuItem(onClick = {
                    expanded = true
                    selectedText = comidas
                }
                ) {
                    Text(text = comidas)
                    
                }
            }
            
        }

    }

}






@Composable
fun MyDivider(){
    Column(modifier = Modifier.fillMaxSize()) {
        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), color = Color.Red
        )
        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp), color = Color.Yellow
        )

    }

}

@Composable
fun MyBadgeBox(){
    Column(modifier = Modifier.fillMaxSize()) {

        BadgedBox(
            modifier = Modifier.padding(12.dp),
            badge = { Badge(contentColor = Color.Cyan, backgroundColor = Color.Blue){ Text(text = "100")} }
            ){
            Icon(imageVector = Icons.Default.Star, contentDescription = "")
        }
    }

}


@Composable
fun MyCard(index: Int){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        shape = MaterialTheme.shapes.small,
        backgroundColor = Color.Red,
        border = BorderStroke(2.dp, Color.Gray)

    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = index.toString() + "Yonissa")
            Text(text = "Can")
            Text(text = "Do It")
        }

    }

}


@Composable
fun MyRadioButtonList(name: String, onItemSelected:(String) -> Unit){

    Column(
        Modifier.fillMaxWidth()
    ) {
        Row (modifier = Modifier.fillMaxWidth()){
            RadioButton(
                selected = name == "Aris", onClick = { onItemSelected ("Aris")}
            )
            Text(text = "Aris")
        }
        Row (modifier = Modifier.fillMaxWidth()){
            RadioButton(
                selected =  name == "David", onClick = { onItemSelected ("David" )}
            )
            Text(text = "David")
        }
        Row (modifier = Modifier.fillMaxWidth()){
            RadioButton(
                selected =  name == "Luz", onClick = { onItemSelected ("Luz" )}
            )
            Text(text = "Luz")
        }
        Row (modifier = Modifier.fillMaxWidth()){
            RadioButton(
                selected =  name == "Mary", onClick = { onItemSelected ("Mary" ) }
            )
            Text(text = "Mary")
        }


    }

}

@Composable
fun MyRadioButton(){
    Row (modifier = Modifier.fillMaxWidth()){
        RadioButton(
            selected = false, onClick = {  }, enabled = false,colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                //disabledSelectedColor = Color.Green,
               // disabledUnselectedColor = Color.Magenta

            )
        )
        Text(text = "ejemplo 1")
    }

}




@Composable
fun MyTriStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off)}
    TriStateCheckbox(state = status, onClick = {
       status = when(status){
            ToggleableState.On  -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}




@Composable
fun getOption(title:List<String>): List<CheckInfo>{
  return  title.map {
        var status by rememberSaveable { mutableStateOf(false)}
         CheckInfo(
            title = it,
            selected = status,
            onCheckChenge = {myNewStatus -> status = myNewStatus}
        )
  }

}




@Composable
fun MySwitchBoxWithTextCompleted(checkInfo: CheckInfo){

    Row (modifier =  Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = checkInfo.selected ,
            onCheckedChange = {checkInfo.onCheckChenge(!checkInfo.selected)})
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)


    }


}



@Composable
fun MySwitchBoxWithText(){
    var state by rememberSaveable { mutableStateOf(false)}
    Row (modifier =  Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(checked = state, onCheckedChange = {state = !state})
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "ejemplo 1")


    }


}


@Composable
fun MySwitchBox(){
    var state by rememberSaveable { mutableStateOf(false)}
    Checkbox(
        checked = state,
        onCheckedChange = { state = !state},
        enabled = true,
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Yellow,
            checkmarkColor = Color.Blue
        )
    )

}

@Composable
fun MySwitch(){
    var state by rememberSaveable { mutableStateOf(false)}
    Switch(
        checked = state,
        onCheckedChange = {state = !state},
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            uncheckedTrackColor = Color.Magenta,
           // uncheckedBorderColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
           // checkedBorderColor = Color.Blue,
            disabledCheckedTrackColor = Color.Yellow,
            disabledCheckedThumbColor = Color.Yellow,
            disabledUncheckedThumbColor = Color.Yellow,
            disabledUncheckedTrackColor = Color.Yellow
        )

    )

}



@Composable
fun MyProgressAdvance(){
    var progressStatus by rememberSaveable { mutableStateOf(0f)

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator(progress = progressStatus)
        Row (
            modifier = Modifier
                .fillMaxWidth()
        ){
            Button(onClick = { progressStatus += 0.1f }
            ) {
                Text(text = "Incrementar")
            }
            Button(onClick = {  progressStatus -= 0.1f }
            ) {
                Text(text = "Reducir")
            }


        }

    }

}


@Composable
fun MyProgress(){
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier
                    .padding(top = 32.dp),
                color = Color.Green
            )
        }
        Button(onClick = { showLoading = !showLoading }
        ) {
            Text(text = "cargar perfil")
        }

    }

}


@Composable
fun MyIcon(){
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "icon",
        tint = Color.Red

    )

}

@Composable
fun MyImageAdvance(){
    Image(
        painter = painterResource(id = R.drawable.img_20210725_151234),
        contentDescription = "ejemplo",
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .border(5.dp, Color.Magenta, CircleShape)
            ,
        contentScale = ContentScale.Crop
    )

}

@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.img_20210725_151234),
        contentDescription = "ejemplo",
       alpha = 0.5f
    )

}


@Composable
fun MyButtonExample(){
    var enabled by rememberSaveable { mutableStateOf(true) }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ){
        Button(
            onClick = { enabled = false},
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                 Color.Magenta,
                contentColor = Color.Blue
            ),
            border = BorderStroke(5.dp, Color.Green)
        ){
            Text(text = "Hola")
        }
        OutlinedButton(
            onClick = {enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
              //  containerColor = Color.Magenta,
                contentColor = Color.Blue,
               // disabledContainerColor = Color.White,
                disabledContentColor = Color.Yellow
            ),
        ) {
            Text(text = "hola")

        }
        TextButton(onClick = { }
        ) {
            Text(text = "hola")

        }

    }

}

@Composable
fun MyTextField(name: String, ouValueChange:(String)-> Unit){
    TextField(value = name, onValueChange = {ouValueChange(it)})

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyTextFieldOulined(){
    var myText by remember { mutableStateOf("")
    }
    OutlinedTextField(
        value = myText,
        onValueChange = {myText = it},
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "holita")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Red
        )
    )


}

@Composable
fun MyTextFieldAdvance(){
    var myText by remember { mutableStateOf("")}
    TextField(
        value = myText, onValueChange = {
            myText = if (it.contains("a")){
                it.replace("a","")
        }else{
            it
        }
                                        },
        label = { Text(text = "Introduce su nombre")}
    )


}

@Composable
fun MyText(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Estos es un ejemplo")
        Text(text = "Estos es un ejemplo", color = Color.Blue)
        Text(text = "Estos es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "Estos es un ejemplo",fontWeight = FontWeight.Light)
        Text(text = "Estos es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))

        Text(
            text = "Estos es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.LineThrough))

        Text(
            text = "Estos es un ejemplo",
            style = TextStyle(textDecoration = TextDecoration.Underline))

        Text(text = "Estos es un ejemplo",style = TextStyle(
            textDecoration = TextDecoration.combine(listOf(TextDecoration.Underline, TextDecoration.LineThrough)))
        )
        Text(text = "Estos es un ejemplo", fontSize = 30.sp)
    }

}