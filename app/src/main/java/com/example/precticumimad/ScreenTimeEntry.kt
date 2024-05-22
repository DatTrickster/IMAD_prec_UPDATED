package com.example.precticumimad

import android.os.Parcel
import android.os.Parcelable

// Data class to store screen time entry data, implementing Parcelable for easy passing between activities
data class ScreenTimeEntry(
    val date: String,         // Date of the screen time entry
    val morning: Double,      // Morning screen time in hours
    val afternoon: Double,    // Afternoon screen time in hours
    val notes: String         // Additional notes
) : Parcelable {

    // Secondary constructor to create ScreenTimeEntry from a Parcel
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",        // Read the date from the parcel, defaulting to an empty string if null
        parcel.readDouble(),              // Read the morning screen time from the parcel
        parcel.readDouble(),              // Read the afternoon screen time from the parcel
        parcel.readString() ?: ""         // Read the notes from the parcel, defaulting to an empty string if null
    )

    // Method to write the ScreenTimeEntry data to a Parcel
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)          // Write the date to the parcel
        parcel.writeDouble(morning)       // Write the morning screen time to the parcel
        parcel.writeDouble(afternoon)     // Write the afternoon screen time to the parcel
        parcel.writeString(notes)         // Write the notes to the parcel
    }

    // Method to describe contents, typically return 0 as default
    override fun describeContents(): Int {
        return 0
    }

    // Companion object to generate instances of ScreenTimeEntry from a Parcel
    companion object CREATOR : Parcelable.Creator<ScreenTimeEntry> {
        // Create a new instance of ScreenTimeEntry from a Parcel
        override fun createFromParcel(parcel: Parcel): ScreenTimeEntry {
            return ScreenTimeEntry(parcel)
        }

        // Create a new array of ScreenTimeEntry objects
        override fun newArray(size: Int): Array<ScreenTimeEntry?> {
            return arrayOfNulls(size)
        }
    }
}
