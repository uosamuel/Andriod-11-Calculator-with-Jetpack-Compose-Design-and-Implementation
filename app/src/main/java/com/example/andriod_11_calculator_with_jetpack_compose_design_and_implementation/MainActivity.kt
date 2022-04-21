package com.example.andriod_11_calculator_with_jetpack_compose_design_and_implementation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calccompose.ui.theme.CalcComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalcComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Calculator()
                }
            }
        }
    }
}


@Composable
fun Calculator() {

    var expressionView1 by remember {
        mutableStateOf("")
    }

    var resultView by remember {
        mutableStateOf("")
    }

    var canAddDot by remember {
        mutableStateOf(true)
    }

    var canAddOperator by remember {
        mutableStateOf(true)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xFF000000))
            .padding(20.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.45f),
            verticalArrangement = Arrangement.Bottom,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 1.dp)
            ) {
                Text(
                    text = expressionView1,
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = Color(0xFFAAAAAA),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.W300,
                    textAlign = TextAlign.End,
                    maxLines = 1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 1.dp, bottom = 10.dp)
            ) {
                Text(
                    text = resultView,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFF6400))
                        .padding(10.dp),
                    color = Color(0xFFFFFFFF),
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.End,
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "AC",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            resultView = ""
                            expressionView1 = ""
                            canAddDot = true
                            canAddOperator = true
                        }
                )
                Text(
                    text = "BackS",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val expressionListLength = expressionView1.length
                            if (expressionListLength > 0) expressionView1 =
                                expressionView1.dropLast(1)
                            if(!expressionView1.endsWith(".")){
                                canAddDot = true
                            }
                            if(expressionView1.last().isDigit()){
                                canAddOperator = true
                            }
                        }
                )
                Text(
                    text = "%",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val input = "%"
                            if (canAddOperator)  {
                                expressionView1 += input
                                canAddOperator = false
                            }
                            canAddDot = true
                        }

                )
                Text(
                    text = "/",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val input = "/"
                            if (canAddOperator)  {
                                expressionView1 += input
                                canAddOperator = false
                            }
                            canAddDot = true
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "7",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val input = "7"
                            expressionView1 += input
                            canAddOperator = true

                        }
                )
                Text(
                    text = "8",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val input = "8"
                            expressionView1 += input
                            canAddOperator = true

                        }
                )
                Text(
                    text = "9",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val input = "9"
                            expressionView1 += input
                            canAddOperator = true

                        }
                )
                Text(
                    text = "x",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            val input = "x"
                            if (canAddOperator)  {
                                expressionView1 += input
                                canAddOperator = false
                            }
                            canAddDot = true
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "4",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            expressionView1 += "4"
                            canAddOperator = true
                        }
                )
                Text(
                    text = "5",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "5"
                            expressionView1 += input
                            canAddOperator = true
                        }
                )
                Text(
                    text = "6",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "6"
                            expressionView1 += input
                            canAddOperator = true
                        }
                )
                Text(
                    text = "-",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "-"
                            if (canAddOperator)  {
                                expressionView1 += input
                                canAddOperator = false
                            }
                            canAddDot = true
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "1"
                            expressionView1 += input
                            canAddOperator = true
                        }
                )
                Text(
                    text = "2",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "2"
                            expressionView1 += input
                            canAddOperator = true
                        }
                )
                Text(
                    text = "3",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "3"
                            expressionView1 += input
                            canAddOperator = true
                        }
                )
                Text(
                    text = "+",
                    color = Color(0xFFFF6400),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "+"
                            if (canAddOperator)  {
                                expressionView1 += input
                                canAddOperator = false
                            }
                            canAddDot = true
                        }
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "0",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "0"
                            expressionView1 += input
                            canAddOperator = true
                        }
                )
                Text(
                    text = ".",
                    color = Color(0xFFFFFFFF),
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            var input = "."
                            if (canAddDot)  {
                                expressionView1 += input
                                canAddDot = false
                            }
                            canAddOperator = true
                        }
                )
                Text(
                    text = "=",
                    color = Color(0xFFFFFFFF),
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(Color(0xFFFF6400))
                        .padding(20.dp)
                        .fillMaxWidth(.5f)
                        .clickable {
                            val input = expressionView1

                            //split the text at the below signs
                            val listOfNumbers = input.split("((?<=[+\\-*/()%x])|(?=[+\\-*/()%x]))".toRegex())

                            Log.d(listOfNumbers.toString(),"msg")

                            var num: Double = 0.0

                            listOfNumbers.forEachIndexed { index, item ->
                                when (index) {
                                    0 -> {
                                        num = item
                                            .trim()
                                            .toDouble()
                                    }
                                }
                                when (item) {
                                    "x" -> {
                                        num *= listOfNumbers[index + 1]
                                            .trim()
                                            .toDouble()
                                    }
                                    "%" -> {
                                        num /= listOfNumbers[index + 1]
                                            .trim()
                                            .toDouble()
                                        num * 100
                                    }
                                    "+" -> {
                                        num += listOfNumbers[index + 1]
                                            .trim()
                                            .toDouble()
                                    }
                                    "-" -> {
                                        num -= listOfNumbers[index + 1]
                                            .trim()
                                            .toDouble()
                                    }
                                    "/" -> {
                                        num /= listOfNumbers[index + 1]
                                            .trim()
                                            .toDouble()
                                    }
                                }
                            }

                            resultView = num.toString()
                        }

                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Calculator()
}