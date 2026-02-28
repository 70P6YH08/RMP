interface DeliveryService{
    val serviceName : String
    fun deliver(num : Int)
}

class FoodService(override val serviceName: String) : DeliveryService{
    override fun deliver(num: Int) {
        println("Заказ $num передан в доставку через $serviceName")
    }
}

class DeliveryApplication(deliveryService: DeliveryService) : DeliveryService by deliveryService{
    fun orderCreate(num : Int){
        deliver(num)
    }
}