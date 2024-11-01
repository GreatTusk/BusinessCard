package com.f776.businesscard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import businesscard.composeapp.generated.resources.Res
import businesscard.composeapp.generated.resources.android_logo
import businesscard.composeapp.generated.resources.email
import businesscard.composeapp.generated.resources.name
import businesscard.composeapp.generated.resources.phone_number
import businesscard.composeapp.generated.resources.social_media_handle
import businesscard.composeapp.generated.resources.title
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview


val textColor = Color(0xFFC1C5CF)
val secondaryTextColor = Color(0xFF01E8C6)

@Composable
@Preview
fun App() {
    MaterialTheme {
        val bgColor = Color(0xFF181C28)

        Box(
            modifier = Modifier
                .background(bgColor)
                .fillMaxSize()
                .padding(top = 32.dp, bottom = 32.dp, start = 16.dp, end = 16.dp)
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                BusinessCard()
            }
            ContactInfo(modifier = Modifier.padding(start = 52.dp, end = 52.dp)
                .align(Alignment.BottomCenter))
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(Res.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier.size(144.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.name),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = textColor,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(Res.string.title),
            fontSize = 20.sp,
            color = secondaryTextColor,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        ContactRow(
            icon = Icons.Outlined.Call,
            text = stringResource(Res.string.phone_number),
            description = "telephone"
        )
        ContactRow(
            icon = Icons.Outlined.Add,
            text = stringResource(Res.string.social_media_handle),
            description = "social media handle"
        )
        ContactRow(
            icon = Icons.Outlined.MailOutline,
            text = stringResource(Res.string.email),
            description = "email"
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = description,
            tint = secondaryTextColor,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = textColor,
            fontSize = 16.sp
        )
    }
}
