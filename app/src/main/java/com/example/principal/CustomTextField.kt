
package com.example.principal
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun CustomTextField(
    isEnabled: Boolean,
    placeholder:String,
    label: String
) {
    var texto by remember { mutableStateOf("") }
    var senhaVisivel by remember { mutableStateOf(isEnabled) }

    // Define o ícone e o conteúdo da descrição baseado na visibilidade da senha e no estado de enabled
    val icon = if (senhaVisivel) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
    val contentDescription = if (senhaVisivel) "Ocultar senha" else "Mostrar senha"

    TextField(
        value = texto,
        onValueChange = { novoTexto -> texto = novoTexto },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        visualTransformation = if (senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (!isEnabled) {
                IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                    Icon(imageVector = icon, contentDescription = contentDescription)
                }
            }
        },
        modifier = Modifier.fillMaxWidth()
    )
}
