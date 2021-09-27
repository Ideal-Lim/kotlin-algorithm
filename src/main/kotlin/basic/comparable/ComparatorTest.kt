package basic.comparable

object SortByName : Comparator<User>{
    override fun compare(user1: User, user2: User): Int {
        // 오름차순
        return user1.name.compareTo(user2.name)
        // 내림차순
        //return user2.name.compareTo(user1.name)
    }
}

fun main(){
    val user1 = User(1, "영희")
    val user2 = User(2, "민수")
    val user3 = User(3, "가가")

    arrayListOf<User>(user1, user2, user3).apply{
        println("sort by age")
        this.sort()
        this.forEach{
            println("${it.id} ${it.name}")
        }
    }

    arrayListOf<User>(user1, user2, user3).apply {
        println("sort by name")
        this.sortWith(SortByName)
        this.forEach {
            println("${it.id} ${it.name}")
        }
    }
}