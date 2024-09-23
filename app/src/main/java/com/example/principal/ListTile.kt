package com.example.principal

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListTile(
    leadingIcon: @Composable (() -> Unit)? = null,
    title: @Composable() (() -> Unit?)? = null,
    subtitle: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    model: String = "",
    modifier: Modifier = Modifier
) {

    if (model == "") {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(enabled = onClick != null) { onClick?.invoke() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (leadingIcon != null) {
                Box(modifier = Modifier.padding(end = 16.dp)) {
                    leadingIcon()
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                if (title != null) {
                    if (subtitle != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                        subtitle()
                    }
                }
            }

            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
    else if (model == "Número de telefone") {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Box(modifier = Modifier.padding(end = 16.dp)) {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = "",
                )
            }


            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "Número", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }


            }

           IconButton(onClick = { onClick?.invoke() }) {
               Icon(
                   imageVector = Icons.Outlined.Edit,
                   contentDescription = "",
               )
           }

        }

    }
    else if (model == "Endereço") {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.padding(end = 16.dp)) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "",
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "Logradouro", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }
                Text(text = "Bairro/Distrito", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }


            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "Localidade/UF", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }
                Text(text = "CEP", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }


            }

            IconButton(onClick = { onClick?.invoke() }) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "",
                )
            }
        }


    }
    else if (model == "Rede social") {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.padding(end = 16.dp)) {
                Icon(
                    imageVector = Icons.Outlined.AlternateEmail,
                    contentDescription = "",
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "Rede social", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }


            }

            IconButton(onClick = { onClick?.invoke() }) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "",
                )
            }
        }


    }
    else if (model == "E-mail") {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.padding(end = 16.dp)) {
                Icon(
                    imageVector = Icons.Outlined.Mail,
                    contentDescription = "",
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                Text(text = "E-mail", color = Color.LightGray, fontSize = 12.sp)
                if (title != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    title()
                }


            }

            IconButton(onClick = { onClick?.invoke() }) {
                Icon(
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "",
                )
            }
        }
    }
    else {


        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable(enabled = onClick != null) { onClick?.invoke() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (leadingIcon != null) {
                Box(modifier = Modifier.padding(end = 16.dp)) {
                    leadingIcon()
                }
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                if (title != null) {
                    if (subtitle != null) {
                        Spacer(modifier = Modifier.height(4.dp))
                        subtitle()
                    }
                }
            }

            if (trailingIcon != null) {
                trailingIcon()
            }
        }
    }
}
