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
package com.delasystems.androidcomposeroomexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "tbl_location",
    primaryKeys = ["loc_id"]
)
data class LocationEntity(
    @ColumnInfo(name = "loc_id", defaultValue = "-1")
    val locId: Long,
    @ColumnInfo(name = "street", defaultValue = "")
    val street: String,
    @ColumnInfo(name = "city", defaultValue = "")
    val city: String,
    @ColumnInfo(name = "state", defaultValue = "")
    val state: String
)

@Entity(
    tableName = "tbl_pet",
    primaryKeys = ["name"],
    foreignKeys = [
        ForeignKey(
            entity= LocationEntity::class,
            parentColumns = ["loc_id"],
            childColumns = ["location"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PetEntity(
    @ColumnInfo(name = "location", defaultValue = "-1")
    val location: Long,
    @ColumnInfo(name = "name", defaultValue = "")
    val name: String,
    @ColumnInfo(name = "adopted", defaultValue = "")
    val year: Int
)
