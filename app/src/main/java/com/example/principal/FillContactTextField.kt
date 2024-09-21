package com.example.principal


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun FillContactTextField(
    padding: Double,
    texto: String,
    onTextoChange: (String) -> Unit,

    placeholder: String,
    label: String
) {

    TextField(
        shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp),
        value = texto,
        onValueChange = { novoTexto -> onTextoChange(novoTexto) },
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            IconButtonWithDropdown()

        },
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = padding.dp),
    )
}
