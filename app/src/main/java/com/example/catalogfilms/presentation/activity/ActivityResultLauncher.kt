package com.example.catalogfilms.presentation.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.catalogfilms.data.models.firebase.User
import com.example.catalogfilms.databinding.ActivityResultLauncherBinding
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class ActivityResultLauncher : AppCompatActivity() {

    lateinit var binding: ActivityResultLauncherBinding
    private lateinit var database: DatabaseReference

    //Запуск самого окна реги регистрации с ранее созданным интентом: signInIntent
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultLauncherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Чтобы читать или записывать данные из базы данных, вам нужен экземпляр DatabaseReference
        //Создаем базу данных
        database = Firebase.database.reference


        // Choose authentication providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build())


// Create and launch sign-in intent
        val signInIntent = AuthUI.getInstance()
            .createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .build()
        signInLauncher.launch(signInIntent)
        AuthUI.getInstance()
            .delete(this)
            .addOnCompleteListener {
            }

        if (getIntent().getBooleanExtra("LOGOUT", false))
        {
            finish();
            System.exit(0);
        }
    }

    private fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
        val response = result.idpResponse
        if (result.resultCode == RESULT_OK) {
            // Successfully signed in
            val authUser = FirebaseAuth.getInstance().currentUser
            val user = User(authUser?.email.toString(), authUser?.uid.toString())
            database.child("users").child(user.uid).setValue(user)

            val intentToMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentToMainActivity)
            // ...
        } else {
            // Sign in failed. If response is null the user canceled the
            // sign-in flow using the back button. Otherwise check
            // response.getError().getErrorCode() and handle the error.
            // ...
        }
    }
}