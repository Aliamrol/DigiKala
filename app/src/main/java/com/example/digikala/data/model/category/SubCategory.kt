package com.example.digikala.data.model.category

data class SubCategory(
    val beauty: List<Beauty>,
    val book: List<Book>,
    val digital: List<Digital>,
    val fashion: List<Fashion>,
    val home: List<Home>,
    val mobile: List<Mobile>,
    val native: List<Native>,
    val sport: List<Sport>,
    val supermarket: List<Supermarket>,
    val tool: List<Tool>,
    val toy: List<Toy>
) {
    data class Beauty(
        val _id: String, // 63cd8e84e6c45edd1a31db09
        val count: Int, // 600
        val image: String, // https://truelearn.ir/myRestApi/img/h1.png
        val name: String // لوازم آرایشی
    )

    data class Book(
        val _id: String, // 63cd8f04e6c45edd1a31db0b
        val count: Int, // 119000
        val image: String, // https://truelearn.ir/myRestApi/img/j4.png
        val name: String // کتاب
    )

    data class Digital(
        val _id: String, // 63cd8ad9e6c45edd1a31db03
        val count: Int, // 33000
        val image: String, // https://truelearn.ir/myRestApi/img/b1.png
        val name: String // تبلت و کتابخوان
    )

    data class Fashion(
        val _id: String, // 63cfd3b41dd6b62ff2fe12bc
        val count: Int, // 338000
        val image: String, // https://truelearn.ir/myRestApi/img/d1.png
        val name: String // مردانه
    )

    data class Home(
        val _id: String, // 63cd8ec4e6c45edd1a31db0a
        val count: Int, // 14000
        val image: String, // https://truelearn.ir/myRestApi/img/i3.png
        val name: String // لوازم برقی
    )

    data class Mobile(
        val _id: String, // 63cd8b68e6c45edd1a31db04
        val count: Int, // 100
        val image: String, // https://truelearn.ir/myRestApi/img/c1.png
        val name: String // گوشی موبایل
    )

    data class Native(
        val _id: String, // 63cd8dd5e6c45edd1a31db06
        val count: Int, // 1000
        val image: String, // https://truelearn.ir/myRestApi/img/f1.png
        val name: String // خانه و کاشانه
    )

    data class Sport(
        val _id: String, // 63cd8f39e6c45edd1a31db0c
        val count: Int, // 2000
        val image: String, // https://truelearn.ir/myRestApi/img/k2.png
        val name: String // پوشاک ورزشی
    )

    data class Supermarket(
        val _id: String, // 63cd8b9ce6c45edd1a31db05
        val count: Int, // 2000
        val image: String, // https://truelearn.ir/myRestApi/img/e1.png
        val name: String // کالاهای اساسی
    )

    data class Tool(
        val _id: String, // 63c52a3b55147696a092fd80
        val count: Int, // 1000
        val image: String, // https://truelearn.ir/myRestApi/img/a1.png
        val name: String // تجهیزات صنعتی
    )

    data class Toy(
        val _id: String, // 63cd8e40e6c45edd1a31db07
        val count: Int, // 600
        val image: String, // https://truelearn.ir/myRestApi/img/g1.png
        val name: String // ایمنی و مراقبت
    )
}