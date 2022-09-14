/*
Copyright (C) 2022 Roy Watson

Permission is hereby granted, free of charge, to any person obtaining a copy of this
software and associated documentation files (the "Software"), to deal in the Software
without restriction, including without limitation the rights to use, copy, modify, merge,
publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons
to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies
or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
OR OTHER DEALINGS IN THE SOFTWARE.
*/
package com.delasystems.androidcomposeroomexample

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.delasystems.androidcomposeroomexample.database.PetDatabase
import com.delasystems.androidcomposeroomexample.datasource.locations
import com.delasystems.androidcomposeroomexample.datasource.pets
import com.delasystems.androidcomposeroomexample.datasource.singleLocation
import com.delasystems.androidcomposeroomexample.datasource.singleLocationPets
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val db = Room.databaseBuilder(getApplication(), PetDatabase::class.java, "mypets.db")
            .build()

    private val _resultState = mutableStateOf("")
    val resultState: State<String>
        get() = _resultState

    fun insertLooping() {
        viewModelScope.launch(Dispatchers.IO) {
            _resultState.value = ""
            try {
                locations.map { db.petsDao().insertLocation(it) }
                pets.map { db.petsDao().insertPet(it) }
                _resultState.value = "SUCCEEDED !"
            } catch(ex: Exception) {
                _resultState.value = "FAILED !"
            }
        }
    }

    fun insertLocationList() {
        viewModelScope.launch(Dispatchers.IO) {
            _resultState.value = ""
            try {
                db.petsDao().insertLocations(locations)
                _resultState.value = "SUCCEEDED !"
            } catch(ex: Exception) {
                _resultState.value = "FAILED !"
            }
        }
    }

    fun saveTransaction() {
        viewModelScope.launch(Dispatchers.IO) {
            _resultState.value = ""
            try {
                db.petsDao().insertLocationAndPets(singleLocation, singleLocationPets)
                _resultState.value = "SUCCEEDED !"
           } catch(ex: Exception) {
                _resultState.value = "FAILED !"
            }
        }
    }

    fun cascadingDeleteExample() {
        viewModelScope.launch(Dispatchers.IO) {
            _resultState.value = ""
            try {
                val location = locations[1]
                db.petsDao().deleteLocation(location)
                _resultState.value = "SUCCEEDED !"
            } catch(ex: Exception) {
                _resultState.value = "FAILED !"
            }
        }
    }

    fun findFirstPetAt(city: String, state: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _resultState.value = ""
            try {
                val name = db.petsDao().findFirstPetAt(city, state)
                _resultState.value = name
            } catch(ex: Exception) {
                _resultState.value = "FAILED !"
            }
        }
    }

}