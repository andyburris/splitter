package ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.DefaultModifiers
import data.ZoneGroup
import state.Action

@Composable
fun App(zoneGroups: List<ZoneGroup>, onAction: (Action) -> Unit) {
    MaterialTheme {
        CompositionLocalProvider(LocalDefaultModifier provides DefaultModifiers.modifiers) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(32.dp),
                verticalArrangement = Arrangement.spacedBy(64.dp)
            ) {
                Category("Vertical", zoneGroups.filter { it is ZoneGroup.Vertical }, onAction)
                Category("Horizontal", zoneGroups.filter { it is ZoneGroup.Horizontal }, onAction)
            }
        }
    }
}

@Composable
fun Category(name: String, zoneGroups: List<ZoneGroup>, onAction: (Action) -> Unit){
    Text(name, style = MaterialTheme.typography.h4)
    zoneGroups.forEach {
        ZoneGroupItem(it, onAction = onAction)
    }
}