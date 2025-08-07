package com.example.proyectomovilesb2.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectomovilesb2.R
import com.example.proyectomovilesb2.models.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [
        Advertisement::class,
        Manufacturer::class,
        Review::class,
        User::class,
        PaymentProvider::class,
        UserPaymentProvider::class,
        Product::class,
        BookmarkItem::class,
        Location::class,
        CartItem::class,
        Order::class,
        OrderItem::class,
        OrderPayment::class,
        Notification::class,
        ProductColor::class,
        ProductSize::class,
    ],
    version = 1, exportSchema = false)
abstract class RoomDb : RoomDatabase() {

    /** A function that used to retrieve Room's related dao instance */
    abstract fun getDao(): RoomDao

    class PopulateDataClass @Inject constructor(
        private val client: Provider<RoomDb>,
        private val scope: CoroutineScope,
    ) : RoomDatabase.Callback() {
        private val description =
            "This is the description text that is supposed to be long enough to show how the UI looks, so it's not a real text.\n"
        private val manufacturers = listOf(
            Manufacturer(id = 1, name = "Pilsener", icon = R.drawable.pilsener),
            Manufacturer(id = 2, name = "Club", icon = R.drawable.club1),
            Manufacturer(id = 3, name = "Corona", icon = R.drawable.corona1),
        )
        private val advertisements = listOf(
            Advertisement(1, R.drawable.anuncio_pilsener, 1, 0),
            Advertisement(2, R.drawable.anuncio_club, 2, 0),
            Advertisement(3, R.drawable.anuncio_corona, 3, 0),
        )

        private val pilsenerProducts = listOf(
            Product(
                id = 100,
                name = "Cerveza Pilsener Original",
                image = R.drawable.pilsener1,
                price = 1.0,
                description = description,
                manufacturerId = 1,
                basicColorName = "white",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 101,
                name = "Cerveza Pilsener Light Playa",
                image = R.drawable.pilsener2,
                price = 1.1,
                description = description,
                manufacturerId = 1,
                basicColorName = "blue",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 102,
                name = "Cerveza Pilsener Light",
                image = R.drawable.pilsener3,
                price = 1.5,
                description = description,
                manufacturerId = 1,
                basicColorName = "blue",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 103,
                name = "Cerveza Pilsener Cero",
                image = R.drawable.pilsener4,
                price = 1.5,
                description = description,
                manufacturerId = 1,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            }
        )

        private val clubProducts = listOf(
            Product(
                id = 1,
                name = "Cerveza Club Original",
                image = R.drawable.club2,
                price = 1.1,
                description = description,
                manufacturerId = 2,
                basicColorName = "dark-green",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 3,
                name = "Cerveza Club Platino",
                image = R.drawable.club3,
                price = 1.2,
                description = description,
                manufacturerId = 2,
                basicColorName = "gray",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 7,
                name = "Cerveza Club Negra",
                image = R.drawable.club4,
                price = 1.5,
                description = description,
                manufacturerId = 2,
                basicColorName = "black",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 8,
                name = "Cerveza Club Premium Roja",
                image = R.drawable.club5,
                price = 2.0,
                description = description,
                manufacturerId = 2,
                basicColorName = "red",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
        )
        private val coronaProducts = listOf(
            Product(
                id = 10,
                name = "Corona Extra",
                image = R.drawable.corona2,
                price = 1.0,
                description = description,
                manufacturerId = 3,
                basicColorName = "yellow",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },

            Product(
                id = 12,
                name = "Corona Tropical Limón & Toronja",
                image = R.drawable.corona3,
                price = 1.1,
                description = description,
                manufacturerId = 3,
                basicColorName = "red",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
            Product(
                id = 13,
                name = "Corona Tropical Frutos Amarillos",
                image = R.drawable.corona4,
                price = 1.1,
                description = description,
                manufacturerId = 3,
                basicColorName = "yellow",
            ).also {
                it.colors = mutableListOf(
                    ProductColor(productId = it.id,
                        colorName = it.basicColorName,
                        image = it.image),
                )
            },
        )
        private val paymentProviders = listOf(
            PaymentProvider(
                id = "apple",
                title = R.string.apple_pay,
                icon = R.drawable.ic_apple,
            ),
            PaymentProvider(
                id = "master",
                title = R.string.master_card,
                icon = R.drawable.ic_master_card,
            ),
            PaymentProvider(
                id = "visa",
                title = R.string.visa,
                icon = R.drawable.ic_visa,
            ),
        )
        private val userPaymentAccounts = listOf(
            UserPaymentProvider(
                providerId = "apple",
                cardNumber = "8402-5739-2039-5784"
            ),
            UserPaymentProvider(
                providerId = "master",
                cardNumber = "3323-8202-4748-2009"
            ),
            UserPaymentProvider(
                providerId = "visa",
                cardNumber = "7483-02836-4839-2833"
            ),
        )
        private val userLocation = Location(
            address = "AlTaif 51, st 5",
            city = "Khartoum",
            country = "Sudan",
        )

        init {
            pilsenerProducts.forEach {
                it.sizes = mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )
            }
            clubProducts.onEach {
                it.sizes = mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )
            }
            coronaProducts.onEach {
                it.sizes = mutableListOf(
                    ProductSize(it.id, 38),
                    ProductSize(it.id, 40),
                    ProductSize(it.id, 42),
                    ProductSize(it.id, 44),
                )
            }

            scope.launch {
                populateDatabase(dao = client.get().getDao(), scope = scope)
            }
        }

        private suspend fun populateDatabase(dao: RoomDao, scope: CoroutineScope) {
            /** Save users */
            scope.launch {
                dao.saveUser(
                    User(
                        userId = 1,
                        name = "Mustafa Ibrahim",
                        profile = R.drawable.mustapha_profile,
                        phone = "+249922943879",
                        email = "mustfaibra@gmail.com",
                        password = "12344321",
                        token = "ds2f434ls2ks2lsj2ls",
                    )
                )
            }
            /** insert manufacturers */
            scope.launch {
                manufacturers.forEach {
                    dao.insertManufacturer(it)
                }
            }
            /** insert advertisements */
            scope.launch {
                advertisements.forEach {
                    dao.insertAdvertisement(it)
                }
            }
            /** Insert products */
            scope.launch {
                clubProducts.plus(coronaProducts).plus(pilsenerProducts)
                    .forEach { product ->

                        dao.insertProduct(product = product)
                        product.colors?.forEach { productColor ->
                            dao.insertOtherProductCopy(productColor)
                        }
                        product.sizes?.forEach { productSize ->
                            dao.insertSize(productSize)
                        }
                    }
            }
            /** Insert payment providers */
            scope.launch {
                paymentProviders.forEach {
                    dao.savePaymentProvider(paymentProvider = it)
                }
            }
            /** Insert user's payment providers */
            scope.launch {
                userPaymentAccounts.forEach {
                    dao.saveUserPaymentProvider(it)
                }
            }
            /** Insert user's location */
            scope.launch {
                dao.saveLocation(location = userLocation)
            }
        }
    }

}