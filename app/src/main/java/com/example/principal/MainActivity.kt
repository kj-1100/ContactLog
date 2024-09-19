package com.example.principal
import android.os.Bundle
import com.example.principal.CustomTextField
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.principal.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme (darkTheme = true){
                // Controle de navegação
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginScreen() }
                }
            }
        }
    }
}


@Composable
fun LoginScreen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título da Tela
            Text(text = "Login", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de E-mail
            CustomTextField(placeholder = "Digite seu E-mail",
                isEnabled = true, // O campo está habilitado
                label = "E-mail"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Senha
            CustomTextField(
                placeholder = "Digite sua senha",
                isEnabled = false, // O campo está habilitado
                label = "Senha"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de login
            Button(
                onClick = { /* Ação de login */ },
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Login")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text ="Não possui uma conta ",color = Color.White)
                Text(text = "clique aqui" )
            }
        }
    }
}
@Composable
fun RegisterScreen() {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título da Tela
            Text(text = "Login", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de E-mail
            CustomTextField(placeholder = "Digite seu E-mail",
                isEnabled = true,
                label = "E-mail"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Senha
            CustomTextField(
                placeholder = "Digite sua senha",
                isEnabled = false,
                label = "Senha"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de login
            Button(
                onClick = { /* Ação de login */ },
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Login")
            }
            TextButton(onClick = { /*TODO*/ }) {

                Text(text ="Já tem uma conta ",color = Color.White)
                Text(text = "faça login" )
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyApplicationTheme(darkTheme = true) {
        LoginScreen()
    }
}
