package com.jeflette.dogbreedapplication.util

import androidx.room.TypeConverter
import com.jeflette.dogbreedapplication.data.local.entity.Height
import com.jeflette.dogbreedapplication.data.local.entity.Image
import com.jeflette.dogbreedapplication.data.local.entity.Weight

class Converter {

    @TypeConverter
    fun fromHeight(height: Height): String? {
        return height.metric
    }

    @TypeConverter
    fun toHeight(metric: String?): Height {
        return Height(metric)
    }

    @TypeConverter
    fun fromWeight(weight: Weight): String? {
        return weight.metric
    }

    @TypeConverter
    fun toWeight(metric: String?): Weight {
        return Weight(metric)
    }

    @TypeConverter
    fun fromImage(image: Image): String? {
        return image.url
    }

    @TypeConverter
    fun toImage(url: String?): Image {
        return Image(url)
    }
}