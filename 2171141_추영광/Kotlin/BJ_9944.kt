import java.io.*

val dxl = intArrayOf(1, -1, 0, 0)
val dyl = intArrayOf(0, 0, 1, -1)
var ans = 1000000

fun dfs(x:Int, y:Int, M:Array<String>, n:Int, m:Int, cnt:Int = 0):Int{
    var blocked = 0
    for (i in 0..3){
        val dx = dxl[i]; val dy = dyl[i]
        val C = M.copyOf()
        C[y] = StringBuilder(C[y]).also {it.setCharAt(x, '*')}.toString()
        var nx = dx+x; var ny = dy+y
        if (!(nx in 0 until m && ny in 0 until n)) {blocked++; continue}
        if (C[ny][nx] == '*') {blocked++; continue}
        while (nx in 0 until m && ny in 0 until n && C[ny][nx] == '.'){
            C[ny] = StringBuilder(C[ny]).also {it.setCharAt(nx, '*')}.toString()
            nx += dx; ny += dy
        }
        ans = minOf(ans, dfs(nx-dx, ny-dy, C, n, m, cnt+1))
    }
    var check = 0
    if (blocked == 4){
        M.forEachIndexed{ cy, it ->
            it.forEachIndexed{cx, k->
                if (k == '*' || (cy == y && cx == x)) check++
            }
        }
        return if (check == n*m) cnt else 1000000
    }
    return ans
}

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var tc = 1
    while (true){
        val tmp = br.readLine() ?: break
        val (n, m) = tmp.split(" ").map {it.toInt()}
        val M = Array<String>(n) {br.readLine()}
        val testCoor = mutableListOf<IntArray>()
        M.forEachIndexed{ y, i ->
            i.forEachIndexed{ x, j ->
                if (j == '.') testCoor.add(intArrayOf(x, y))
            }
        }
        var res = 1000000; ans = 1000000
        testCoor.forEach{(x, y) ->
            res = minOf(dfs(x, y, M, n, m), res)
        }
        bw.write("Case $tc: ${if (res==1000000) -1 else res}\n"); tc++
    }

    br.close()
    bw.flush()
    bw.close()
}
