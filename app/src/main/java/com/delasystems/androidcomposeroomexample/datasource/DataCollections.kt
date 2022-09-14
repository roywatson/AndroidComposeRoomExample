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
package com.delasystems.androidcomposeroomexample.datasource

import com.delasystems.androidcomposeroomexample.database.LocationEntity
import com.delasystems.androidcomposeroomexample.database.PetEntity

val locations = listOf<LocationEntity>(
    LocationEntity(1, "E. Van Trees", "Washington", "IN"),
    LocationEntity(2, "Nimitz Dr.", "West Lafayette", "IN"),
    LocationEntity(3, "Dodds Ct.","Burlington", "VT"),
    LocationEntity(4, "Little Eagle Bay", "Burlington", "VT"),
    LocationEntity(5, "Northshore Dr.", "Burlington", "VT")
)

val pets = listOf<PetEntity>(
    PetEntity( 1, "Woo-woo", 1960),
    PetEntity( 2, "Bruce", 1963),
    PetEntity( 2, "Margaret", 1963),
    PetEntity( 2, "George", 1964),
    PetEntity(3, "Laddie", 1965),
    PetEntity(3, "Sam", 1967),
    PetEntity(  3, "Max", 1981),
    PetEntity( 4, "Jack", 1986),
    PetEntity( 5, "Kitty", 1987),
    PetEntity( 5, "Kitty-Kitty", 1988),
    PetEntity( 5, "Willie", 1989),
    PetEntity( 5, "Dela", 1991),
    PetEntity( 5, "Gatsby", 2003),
    PetEntity( 5, "Wyatt", 2003),
    PetEntity( 5, "Cornelius", 2004),
    PetEntity( 5, "Andrea", 2005),
    PetEntity( 5, "Horatio", 2007),
    PetEntity( 5, "Annabelle", 2008),
    PetEntity( 5, "Lancelot (Bubba)", 2008),
    PetEntity( 5, "Peppers", 2014),
    PetEntity( 5, "Mr. Pickles", 2021),
)

var singleLocation = LocationEntity(3, "Dodds Ct.","Burlington", "VT")

val singleLocationPets = listOf<PetEntity>(
    PetEntity(3, "Laddie", 1965),
    PetEntity(3, "Sam", 1967),
    PetEntity(  3, "Max", 1981),
)
