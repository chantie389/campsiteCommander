package com.example.campsitecommander

import android.os.Parcel
import android.os.Parcelable

data class GearItem(
    val itemName: String,
    val category: String,
    val quantity: Int,
    val comment: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(itemName)
        parcel.writeString(category)
        parcel.writeInt(quantity)
        parcel.writeString(comment)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GearItem> {
        override fun createFromParcel(parcel: Parcel): GearItem {
            return GearItem(parcel)
        }

        override fun newArray(size: Int): Array<GearItem?> {
            return arrayOfNulls(size)
        }
    }
}
