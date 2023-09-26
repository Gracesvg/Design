package com.grace.designsynergy.data

import android.app.ProgressDialog
import android.content.Context
import android.media.Image
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.grace.designsynergy.models.Uploads
import com.grace.designsynergy.navigation.ROUTE_LOGIN


class UploadViewModel(var navController: NavHostController, var context: Context) {
    var authRepository:AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController,context)
        if (!authRepository.isloggedin()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

fun Uploads(image: String, id: String, filePath: Uri){

    var id = System.currentTimeMillis().toString()
    var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
    progress.show()

    storageReference.putFile(filePath).addOnCompleteListener{
        progress.dismiss()
        if (it.isSuccessful){
            // Proceed to store other data into the db
            storageReference.downloadUrl.addOnSuccessListener {
                val image = it.toString()
                var houseData = Uploads(image,id)
                var dbRef = FirebaseDatabase.getInstance()
                    .getReference().child("Uploads/$id")
                dbRef.setValue(houseData)
                Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
        }
    }
}


fun viewUploads(upload: MutableState<Uploads>, uploads: SnapshotStateList<Uploads>): SnapshotStateList<Uploads> {
    var ref = FirebaseDatabase.getInstance().getReference().child("Uploads")

    progress.show()
    ref.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            progress.dismiss()
            uploads.clear()
            for (snap in snapshot.children){
                val value = snap.getValue(Uploads::class.java)
                upload.value = value!!
                uploads.add(value)
            }
        }

        override fun onCancelled(error: DatabaseError) {
            Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
        }
    })
    return uploads
}
}
