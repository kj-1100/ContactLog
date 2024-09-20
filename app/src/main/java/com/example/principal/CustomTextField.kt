
package com.example.principal
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    padding: Double,
    texto: String,
    onTextoChange: (String) -> Unit,
    isEnabled: Boolean,
    placeholder: String,
    label: String
) {
    var senhaVisivel by remember { mutableStateOf(isEnabled) }
    val icon = if (!senhaVisivel) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff
    val contentDescription = if (senhaVisivel) "Ocultar senha" else "Mostrar senha"

    TextField(shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
        value = texto,
        onValueChange = { novoTexto -> onTextoChange(novoTexto) },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        visualTransformation = if (!senhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if (isEnabled) {
                IconButton(onClick = { senhaVisivel = !senhaVisivel }) {
                    Icon(imageVector = icon, contentDescription = contentDescription)
                }
            }
        },
        maxLines=1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding.dp),
    )
}
