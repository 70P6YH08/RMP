interface DataSource<T>{
    fun getNext() : T?
}