package com.grace.designsynergy.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.ui.autofill.AutofillType
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.navigation.NavHostController
import com.google.firebase.auth.FirebaseAuth
import com.grace.designsynergy.models.User
import com.grace.designsynergy.navigation.ROUTE_HOME
import com.grace.designsynergy.navigation.ROUTE_LOGIN
import com.grace.designsynergy.navigation.ROUTE_SIGNUP

class AuthViewModel (var navController:NavHostController,var context:Context) {
    var mAuth: FirebaseAuth


    init {
        mAuth = FirebaseAuth.getInstance()
    }

    fun signup(Email: String, Password: String, ConfirmPassword: String) {

        if (Email.isBlank() || Password.isBlank() || ConfirmPassword.isBlank()) {
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
        } else {
            mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(context, "Registered Successfully", Toast.LENGTH_SHORT).show()
                    navController.navigate(ROUTE_LOGIN)

                } else {
                    Toast.makeText(context, "Failed to create user", Toast.LENGTH_SHORT)
                        .show()
                    navController.navigate(ROUTE_LOGIN)
                }
            }
        }
    }

    fun login(Email: String, Password: String) {
        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener {
            if (Email.isBlank() || Password.isBlank()) {
                Toast.makeText(context, "Please Email and password cannot be blank", Toast.LENGTH_LONG)
                    .show()
                mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                    }
                    else{
                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_LOGIN)


                    }

                }
        }

    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

//    fun isloggedin(): Boolean {
//        return mAuth.currentUser != null
//    }


}

    fun isloggedin():Boolean {
        return mAuth.currentUser != null

    }
}



