package com.test.bizcardapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.test.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {

    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface( modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight() ) {
        Card(modifier = Modifier
            .width(200.dp)
            .height(390.dp)
            .padding(12.dp),
            shape = RoundedCornerShape(25.dp),
            backgroundColor = Color.White,
            elevation = 4.dp
        ) {
            Column( modifier = Modifier.height(300.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally ) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button( onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                },
                        modifier = Modifier.padding(10.dp)) {
                    Text( text = "Portfolio",
                          style = MaterialTheme.typography.button )
                }

                if ( buttonClickedState.value ){
                    Content()
                }

            }
        }
    }
}

@Composable
private fun Content(){
    Box( modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp) ) {
        
        Surface( modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
                 shape = RoundedCornerShape(6.dp),
                 border = BorderStroke(width = 2.dp, color = Color.Gray)
        ) {
            Portfolio(data = listOf( "Project 1", "Project 2", "Project 3"))
        }
        
    }
}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items( data ){ item ->

            Card( modifier = Modifier
                .padding(13.dp)
                .fillMaxWidth(),
                  shape = RectangleShape,
                  elevation = 4.dp ) {
                
                Row( modifier = Modifier
                    .padding(8.dp)
                    .background(MaterialTheme.colors.surface)
                    .padding(7.dp) ) {

                    CreateImageProfile( modifier = Modifier.size(100.dp) )
                    Column( modifier = Modifier.padding(7.dp)
                            .align(alignment = Alignment.CenterVertically) ) {

                        Text( item, fontWeight = FontWeight.Bold )
                        Text( "A great Project", style = MaterialTheme.typography.body2 )

                    }
                }
            }
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier.padding(5.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Junior Saravia",
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.h4
        )

        Text(
            text = "Android Compose programmer",
            modifier = Modifier.padding(3.dp)
        )

        Text(
            text = "@composeSample",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile( modifier: Modifier = Modifier ) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardAppTheme {
        CreateBizCard()
    }
}