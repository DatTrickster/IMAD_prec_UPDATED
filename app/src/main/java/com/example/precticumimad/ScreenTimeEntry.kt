package com.example.precticumimad

import android.os.Parcel
import android.os.Parcelable

data class ScreenTimeEntry(
    val date: String,
    val morning: Double,
    val afternoon: Double,
    val notes: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeDouble(morning)
        parcel.writeDouble(afternoon)
        parcel.writeString(notes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ScreenTimeEntry> {
        override fun createFromParcel(parcel: Parcel): ScreenTimeEntry {
            return ScreenTimeEntry(parcel)
        }

        override fun newArray(size: Int): Array<ScreenTimeEntry?> {
            return arrayOfNulls(size)
        }
    }
}
