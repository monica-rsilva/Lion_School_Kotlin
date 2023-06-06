package br.senai.sp.jandira.lionschool

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.lionschool.model.Student
import br.senai.sp.jandira.lionschool.model.StudentList
import br.senai.sp.jandira.lionschool.service.RetrofitFactory
import br.senai.sp.jandira.lionschool.ui.theme.LionSchoolTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ClassActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LionSchoolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ClassScreen()
                }
            }
        }
    }
}

@Composable
fun ClassScreen() {

    var student by remember{
        mutableStateOf(listOf<Student>())
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
       Card(modifier = Modifier
           .fillMaxWidth()
           .height(130.dp),
           shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp),
            backgroundColor = Color(49,121,179)
           ) {
       }
        
       LazyColumn(modifier = Modifier.fillMaxSize()){
           val call = RetrofitFactory().getCourseService().getStudentsByCourse()

           call.enqueue(object : Callback<StudentList>{
               override fun onResponse(
                   call: Call<StudentList>,
                   response: Response<StudentList>) {
                   student = response.body()!!.Student
               }

               override fun onFailure(call: Call<StudentList>, t: Throwable) {
                   Log.i("DS2M","onFailure:${t.message}")
               }
           })

           items(student){
               Card(modifier = Modifier.fillMaxWidth().height(200.dp)) {
                   Text(text = it.name, fontSize = 18.sp)
                   Text(text = it.status, fontSize = 18.sp)
               }
           }
       }
    }
    
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview2() {
    LionSchoolTheme {
        ClassScreen()
    }
}