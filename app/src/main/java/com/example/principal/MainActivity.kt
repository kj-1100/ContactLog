package com.example.principal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.principal.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(darkTheme = true) {
                // Controle de navegação
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { RegisterScreen() }
                }
            }
        }
    }
}


@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

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
            CustomTextField(
                padding = 8.0,
                texto = email,
                onTextoChange = { email = it },
                isEnabled = false, // O campo está habilitado
                label = "E-mail",
                placeholder = "Digite seu E-mail"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Senha
            CustomTextField(
                padding = 8.0,
                texto = senha,
                onTextoChange = { senha = it },
                isEnabled = true,
                label = "Senha",
                placeholder = "Digite sua senha"

            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de login
            Button(
                onClick = { /* Ação de login */ },
                modifier = Modifier.width(100.dp)
            ) {
                Text(text = "Login")
            }

            TextButton(onClick = { /* TODO */ }) {
                Text(text = "Não possui uma conta ", color = Color.White)
                Text(text = "clique aqui")
            }
        }
    }
}

@Composable
fun RegisterScreen() {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var dadosDeContato by remember { mutableStateOf("") }
    var isEditingAddress by remember { mutableStateOf(false) } // Estado para alternar entre exibir e editar endereço
    var endereco by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título da Tela
            Text(text = "Registo", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de E-mail
            CustomTextField(
                padding = 8.0,
                texto = email,
                onTextoChange = { email = it },
                isEnabled = false,
                label = "E-mail",
                placeholder = "Digite seu E-mail"
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Senha
            CustomTextField(
                padding = 8.0,
                texto = senha,
                onTextoChange = { senha = it },
                isEnabled = true,
                label = "Senha",
                placeholder = "Digite sua senha"
            )
            Spacer(modifier = Modifier.height(16.dp))
            ExpansionTile(title = "fejoada") {


                ListTile(
                    title = {
                        Text(text = "Selecione o tipo de contato:")
                    },
                    trailingIcon = {
                        IconButtonWithDropdown { selectedItem ->
                            dadosDeContato = selectedItem
                            println("Item selecionado: $selectedItem")
                            println("Item selecionado: $dadosDeContato 2121212121")
                        }

                    }

                )

                /**Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.width(15.dp))
                    Text("Selecione o tipo de contato:")
                    Spacer(modifier = Modifier.width(62.dp))
                    IconButtonWithDropdown { selectedItem ->
                        dadosDeContato = selectedItem
                        println("Item selecionado: $selectedItem")
                        println("Item selecionado: $dadosDeContato 2121212121")
                    }

                }**/


                ListTile(
                    model = "Número de telefone",
                    title = { Text(text = "123-456-7890") },
                    onClick = { /* Ação ao clicar no item */ }
                )
                /** ListTile(
                model = "Endereço",
                title = { Text(text = "Rua Exemplo, 123") },
                onClick = { /* Ação ao clicar no item */ }
                ) **/
                ExpansionTile(title = "Contatos") {
                    // Aqui tá alterado o comportamento do ListTile de "Endereço"
                    ListTile(
                        model = "Endereço",
                        title = {
                            if (isEditingAddress) {
                                // Exibir TextField se estiver editando o endereço
                                TextField(
                                    value = endereco,
                                    onValueChange = { endereco = it },
                                    label = { Text("Digite seu endereço") }
                                )
                            } else {
                                // Exibir o texto fixo se não estiver editando
                                Text(text = endereco)
                            }
                        },
                        onClick = {
                            isEditingAddress = !isEditingAddress // Alternar entre exibir o texto e a TextField
                        }
                    )
                }
                ListTile(
                    model = "E-mail",
                    title = { Text(text = "exemplo@email.com") },
                    onClick = { /* Ação ao clicar no item */ }
                )
                ListTile(
                    model = "Rede social",
                    title = { Text(text = "@meuperfil") },
                    onClick = { /* Ação ao clicar no item */ }
                )
            }
//                FillContactTextField(
//                    padding = 0.0,
//                    texto = dadosDeContato,
//                    onTextoChange = { dadosDeContato = it },
//                    label = "Senha",
//                    placeholder = "Digite sua senha"
//                )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de login
            Button(
                onClick = { /* Ação de login */ },
                modifier = Modifier.height(50.dp)
            ) {
                Text(text = "Registrar", fontSize = 18.sp)
            }

            TextButton(onClick = { /* TODO */ }) {
                Text(text = "Não possui uma conta ", color = Color.White)
                Text(text = "clique aqui")
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    MyApplicationTheme(darkTheme = true) {
//        RegisterScreen()
//    }
//}
