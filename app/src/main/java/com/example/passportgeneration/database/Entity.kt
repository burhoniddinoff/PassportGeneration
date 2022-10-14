package com.example.passportgeneration.database

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "PassportTable")
@Parcelize
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val lastName: String,
    val middleName: String,
    val region: String,
    val city: String,
    val address: String,
    val gotDate: String,
    val lifeTime: String,
    val gender: String,
    val image: ByteArray
) : Parcelable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as com.example.passportgeneration.database.Entity

        if (id != other.id) return false
        if (name != other.name) return false
        if (lastName != other.lastName) return false
        if (middleName != other.middleName) return false
        if (region != other.region) return false
        if (city != other.city) return false
        if (address != other.address) return false
        if (gotDate != other.gotDate) return false
        if (lifeTime != other.lifeTime) return false
        if (gender != other.gender) return false
        if (!image.contentEquals(other.image)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + middleName.hashCode()
        result = 31 * result + region.hashCode()
        result = 31 * result + city.hashCode()
        result = 31 * result + address.hashCode()
        result = 31 * result + gotDate.hashCode()
        result = 31 * result + lifeTime.hashCode()
        result = 31 * result + gender.hashCode()
        result = 31 * result + image.contentHashCode()
        return result
    }
}