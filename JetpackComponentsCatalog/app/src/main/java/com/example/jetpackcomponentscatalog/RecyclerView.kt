package com.example.jetpackcomponentscatalog

import android.content.ClipData.Item
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentscatalog.model.SuperHero

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Xevi", "Pepe", "Manolo", "Juan")
    LazyColumn {
        //Los recyclerView sólo reciben datos de tipo item
        item { Text(text = "Header") }

        items(myList) {
            Text(text = "hola me llamo $it")
        }
        item { Text(text = "Footer") }

    }
}

@Composable
fun SuperHeroView() {
    //El context hay que tenerlo fuera de la función
    val context = LocalContext.current
    //El spacedBy se encarga que entre los elementos haya el espacio dado
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) {
            //Esto es para renombrar it
                superhero ->
            //Al ponerle llaves es la lambda
            ItemHero(superHero = superhero) {
                Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun SuperHeroGridView() {
    //El context hay que tenerlo fuera de la función
    val context = LocalContext.current
    //El spacedBy se encarga que entre los elementos haya el espacio dado
    //El content padding pone padding alrededor del grid, NO entre elementos
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(18.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        content = {
            items(getSuperHeroes()) {
                //Esto es para renombrar it
                    superhero ->
                //Al ponerle llaves es la lambda
                ItemHero(superHero = superhero) {
                    Toast.makeText(context, it.superheroName, Toast.LENGTH_SHORT).show()
                }
            }
        })
}

@Composable
//Le pasamos el evento del item selected y hacemos que en la lambda queremos que devuelva
// el objeto SuperHero
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Red),
        modifier = Modifier
            .width(200.dp)
            .clickable { onItemSelected(superHero) }) {
        Column {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "superHero Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superheroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(4.dp)
            )
        }

    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Logan", "Logan", "Logan", R.drawable.logan),
        SuperHero("Batman", "Batman Parker", "Batman", R.drawable.batman),
        SuperHero("Thor", "Thor", "Thor", R.drawable.thor),
        SuperHero("Flash", "Flash", "Flash", R.drawable.flash),
        SuperHero("Green Lantern", "Green Lantern", "Lantern", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Wonder Woman", "Wonder Woman", R.drawable.wonder_woman)
    )
}