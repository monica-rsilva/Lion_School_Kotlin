package br.senai.sp.jandira.lionschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CoursesScreen()
                }
            }
        }
    }
}

@Composable
fun CoursesScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            Card (
                modifier = Modifier
                    .width(136.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(bottomStart = 100.dp),
                backgroundColor = Color(49,121,179)
            ){
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            Text(
                modifier = Modifier.width(300.dp),
                text = stringResource(id = R.string.description),
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold
                )
            
            Image(
                modifier = Modifier.size(300.dp),
                painter = painterResource(id = R.drawable.student),
                contentDescription = ""
            )
            Card(
                modifier = Modifier
                    .fillMaxSize(),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
            ) {
                Column(modifier = Modifier
                    .border(BorderStroke(2.dp,Color.Red))
                    .background(Brush.verticalGradient
                        (colors = listOf(Color(255,255,255),
                                         Color(49,121,179))
                        )
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                ) {

                    Button(
                        modifier = Modifier
                            .width(250.dp)
                            .height(80.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(Color(49,121,179)),
                        onClick = { /*TODO*/ }
                    ) {

                    }

                    Button(
                        modifier = Modifier
                            .width(250.dp)
                            .height(80.dp),
                        shape = RoundedCornerShape(25.dp),
                        colors = ButtonDefaults.buttonColors(Color(49,121,179)),
                        onClick = { /*TODO*/ }
                    ) {

                    }
                }
            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LionSchoolTheme {
        CoursesScreen()
    }
}