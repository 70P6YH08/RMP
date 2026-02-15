class StaticDataSource<T> (val elements : Array<T>): DataSource<T> {
    var index = 0
    override fun getNext(): T = elements[index].also { index = (index + 1) % elements.size }

}
