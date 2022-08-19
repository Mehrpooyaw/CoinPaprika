package com.example.coinpaprika.presentation.ui.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.coinpaprika.domain.models.coin_list.CoinListItem
import com.example.coinpaprika.presentation.ui.components.TextWithShadow
import com.example.coinpaprika.presentation.ui.theme.NeonGreen
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(
    modifier: Modifier,
    onNavigateToCoinScreen : (String) -> Unit
){
    val vm = getViewModel<SearchViewModel>()
    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = vm.searchInputValue, onValueChange = vm::onTextValueChanged,
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth(),
            label = {
                Text("Search in Coin Paprika... \uD83E\uDDD0", color = MaterialTheme.colorScheme.onBackground)
            },
            placeholder = {
                Text("Bitcoin OR btc")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Rounded.Search,null, tint = MaterialTheme.colorScheme.onBackground)
            }
        )

        LazyColumn() {
            items(vm.searchResults) {
                SearchViewItem(modifier = modifier, result = it){
                    it.id?.let { it1 -> onNavigateToCoinScreen(it1) }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchViewItem(
    modifier : Modifier,
    result : CoinListItem,
    onClick : () -> Unit
){
    ElevatedCard(
        modifier = modifier
            .padding(5.dp).padding(horizontal = 5.dp)
            .fillMaxWidth(),
        onClick = {
            onClick()
        }
    ) {
        Column(modifier
            .fillMaxSize()
            .padding(10.dp)
        ) {
            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                result.symbol?.let { TextWithShadow(text = it,
                style = MaterialTheme.typography.titleMedium,) }
                if (result.isNew == true){
                    TextWithShadow(text = "new",color = NeonGreen)
                }

            }
            Spacer(modifier = modifier.size(5.dp))
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                result.name?.let {
                    TextWithShadow(text = it,
                        color = Color.LightGray,
                        style = MaterialTheme.typography.labelMedium)
                }
                result.type?.let {
                    TextWithShadow(text = it, color = Color.Gray, style = MaterialTheme.typography.labelSmall)
                }

            }
        }

    }
}