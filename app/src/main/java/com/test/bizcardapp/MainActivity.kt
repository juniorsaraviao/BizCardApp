package com.test.bizcardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardAppTheme {
        CreateBizCard()
    }
}