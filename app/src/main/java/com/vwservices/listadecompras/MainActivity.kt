package com.vwservices.listadecompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListScreen()
        }
    }
}

@Composable
fun ShoppingListScreen() {
    var newItem by remember { mutableStateOf(TextFieldValue("")) }
    var itemList by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = Modifier.padding(16.dp)) {
        BasicTextField(
            value = newItem,
            onValueChange = { newItem = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .border(1.dp, Color.Gray)
                .padding(16.dp),
            textStyle = LocalTextStyle.current.copy(color = Color.Black)
        )

        Button(
            onClick = {
                if (newItem.text.isNotEmpty()) {
                    itemList = itemList + newItem.text
                    newItem = TextFieldValue("")
                }
            },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Add Item")
        }

        Column(modifier = Modifier.padding(top = 16.dp)) {
            itemList.forEachIndexed { index, item ->
                Text(
                    text = "${index + 1}. $item",
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListScreenPreview() {
    ShoppingListScreen()
}
