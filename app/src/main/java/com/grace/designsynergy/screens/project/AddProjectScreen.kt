package com.grace.designsynergy.screens.project

import com.grace.designsynergy.data.ProjectViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.grace.designsynergy.navigation.ROUTE_UPDATEPROJECT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProjectsScreen(navController: NavHostController) {
    var search1 by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        OutlinedTextField(value = search1,
            onValueChange = { search1 = it },
            placeholder = { Text(text = "") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "search"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Person"
                )
            }
        )

        Text(
            text = "Add Project",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var ProjectDescription by remember { mutableStateOf(TextFieldValue("")) }
        var name by remember { mutableStateOf(TextFieldValue("")) }
        var phoneNo by remember { mutableStateOf(TextFieldValue("")) }
        var city by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = ProjectDescription,
            onValueChange = { ProjectDescription = it },
            label = { Text(text = "ProjectDescription") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "name *") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = phoneNo,
            onValueChange = { phoneNo = it },
            label = { Text(text = "phoneNo *") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text(text = "city *") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "email *") },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )



        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            val projectRepository = ProjectViewModel(navController,context)
            projectRepository.saveProject(ProjectDescription.text.trim(),name.text.trim(),
                phoneNo.text,city.text.trim(),email.text.trim())
            navController.navigate(ROUTE_UPDATEPROJECT)}) {
            Text(text = "Save")
        }

    }
}

@Preview
@Composable
fun AddProject() {
    AddProjectsScreen(rememberNavController())
}
