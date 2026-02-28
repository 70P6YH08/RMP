class RandomDataSource<T>(val randomElement : () -> T) : DataSource<T>{
    override fun getNext(): T = randomElement()
}