package app.practice.epoxy.example2

import app.practice.epoxy.example2.models.Banner
import app.practice.epoxy.example2.models.Category
import app.practice.epoxy.example2.models.Product

object DataSourceExample2 {

    fun getMegaBanner() = Banner(
        "banner1",
        "https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&w=800"
    )

    fun getMegaBanner2() = Banner(
        "banner3",
        "https://images.pexels.com/photos/1492219/pexels-photo-1492219.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
    )

    fun getHorizontalBanners() = listOf(
        Banner(
            "banner2",
            "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Banner(
            "banner3",
            "https://images.pexels.com/photos/1492219/pexels-photo-1492219.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Banner(
            "banner4",
            "https://images.pexels.com/photos/1460124/pexels-photo-1460124.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Banner(
            "banner5",
            "https://images.pexels.com/photos/1440406/pexels-photo-1440406.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Banner(
            "banner6",
            "https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        )
    )

    fun getCategories() = listOf(
        Category(
            "category1",
            "https://images.pexels.com/photos/1254140/pexels-photo-1254140.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category2",
            "https://images.pexels.com/photos/374898/pexels-photo-374898.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category3",
            "https://images.pexels.com/photos/933498/pexels-photo-933498.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category4",
            "https://images.pexels.com/photos/1404819/pexels-photo-1404819.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category5",
            "https://images.pexels.com/photos/1492219/pexels-photo-1492219.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category6",
            "https://images.pexels.com/photos/1460124/pexels-photo-1460124.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category7",
            "https://images.pexels.com/photos/1440406/pexels-photo-1440406.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Category(
            "category8",
            "https://images.pexels.com/photos/1560424/pexels-photo-1560424.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        )
    )

    fun getPromotionProducts() = listOf(
        Product(
            "product1",
            "Product 1",
            100.0,
            "https://images.pexels.com/photos/1492219/pexels-photo-1492219.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Product(
            "product2",
            "Product 2",
            120.0,
            "https://images.pexels.com/photos/1460124/pexels-photo-1460124.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Product(
            "product3",
            "Product 3",
            150.0,
            "https://images.pexels.com/photos/1440406/pexels-photo-1440406.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Product(
            "product4",
            "Product 4",
            199.0,
            "https://images.pexels.com/photos/374898/pexels-photo-374898.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        ),
        Product(
            "product5",
            "Product 5",
            999.09,
            "https://images.pexels.com/photos/933498/pexels-photo-933498.jpeg?auto=compress&cs=tinysrgb&dpr=1&fit=crop&h=200&w=280"
        )
    )
}