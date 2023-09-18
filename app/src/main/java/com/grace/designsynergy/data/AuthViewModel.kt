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

    fun signup(email: String, pass: String, confpass: String) {

        if (email.isBlank() || pass.isBlank() || confpass.isBlank()) {
            Toast.makeText(context, "Please email and password cannot be blank", Toast.LENGTH_LONG)
                .show()
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
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

    fun login(email: String, Password: String) {
        mAuth.signInWithEmailAndPassword(email, Password).addOnCompleteListener {
            if (email.isBlank() || Password.isBlank()) {
                Toast.makeText(context, "Please Email and password cannot be blank", Toast.LENGTH_LONG)
                    .show()
                mAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener {
                    if (it.isSuccessful){
                        Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                        navController.navigate(ROUTE_HOME)
                    }
                    else{
                        Toast.makeText(context, "Login Failed", Toast.LENGTH_SHORT).show()

                    }

                }
        }

    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_LOGIN)
    }

    fun isloggedin(): Boolean {
        return mAuth.currentUser != null
    }


}
}



