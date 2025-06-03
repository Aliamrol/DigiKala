package com.example.digikala.utils

import android.icu.text.DecimalFormat
import android.os.Build
import androidx.annotation.RequiresApi

object DigitHelper {
    fun digitByLocate(englishStr: String): String {
        var result = ""
        var fa = '۰'

        for (ch in englishStr) {
            fa = ch
            when (ch) {
                '0' -> fa = '۰'
                '1' -> fa = '۱'
                '2' -> fa = '۲'
                '3' -> fa = '۳'
                '4' -> fa = '۴'
                '5' -> fa = '۵'
                '6' -> fa = '۶'
                '7' -> fa = '۷'
                '8' -> fa = '۸'
                '9' -> fa = '۹'

            }
            result = "$result$fa"
        }
        return result
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun digitBySeparator(price: String): String {
        val priceFormat = DecimalFormat("###,###")
        return priceFormat.format(Integer.valueOf(price))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun digitByLocateAndSeparator(price: String): String {
        val priceWithoutCommas = price.replace(",", "")
        val persianDigit = digitByLocate(priceWithoutCommas)
        return digitBySeparator(persianDigit)
    }

    fun applyDiscount(price: Long, discountPercent: Int): Long {
        return if (discountPercent > 0) {
            val discountAmount = (price * discountPercent) / 100
            price - discountAmount
        } else {
            price
        }
    }


}