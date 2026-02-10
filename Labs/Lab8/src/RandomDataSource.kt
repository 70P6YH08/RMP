class RandomDataSource<T>(var numbers: Array<T>) : DataSource<T>{
    override fun getNext(): T? {
        var randomNumber : Int = (0 ..numbers.size).random()

        return numbers[randomNumber]
    }

}