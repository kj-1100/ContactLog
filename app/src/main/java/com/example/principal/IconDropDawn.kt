package com.example.principal
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconButtonWithDropdown(onItemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.padding(8.dp),
        contentAlignment = Alignment.CenterEnd
    ) {

        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Abrir Menu"
            )
        }


        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(
                text = { Text("Número de telefone") },
                onClick = {
                    onItemSelected("Número de telefone")
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Endereço") },
                onClick = {
                    onItemSelected("Endereço")
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Rede social") },
                onClick = {
                    onItemSelected("Rede social")
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("E-mail") },
                onClick = {
                    onItemSelected("E-mail")
                    expanded = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconButtonWithDropdown() {
    IconButtonWithDropdown(){selectedItem ->
        // Ação com o item selecionado
        println("Item selecionado: $selectedItem")}
}
