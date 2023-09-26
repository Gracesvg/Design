package com.grace.designsynergy.data

import com.grace.designsynergy.models.Project
import com.grace.designsynergy.navigation.ROUTE_LOGIN
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavHostController
import com.google.firebase.database.FirebaseDatabase

class ProjectViewModel(var navController: NavHostController, var context: Context) {
    var authRepository: AuthViewModel

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_LOGIN)
        }
    }



    fun saveProject(ProjectDescription: String, name: String, phoneNo: String,city:String,email:String) {
        val id = System.currentTimeMillis().toString()
        val projectData = Project(ProjectDescription, name, phoneNo, city,email,id)
        val projectRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")

        projectRef.setValue(projectData).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun deleteProject(id: String) {
        val delRef = FirebaseDatabase.getInstance().getReference()
            .child("Project/$id")
        delRef.removeValue().addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Project deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun UpdateProject(ProjectDescription: String, name: String, phoneNo: String, city: String,email: String,id: String) {
        val updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Project/$id")
        val UpdateProject = Project(ProjectDescription,name, phoneNo, city,email, id)
        updateRef.setValue(UpdateProject).addOnCompleteListener {
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }


}