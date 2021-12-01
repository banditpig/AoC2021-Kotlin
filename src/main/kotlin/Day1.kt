package day1

import java.io.File

fun readFileAsLines(fileName: String): List<String> =
    File(fileName).useLines { it.toList() }

val sub1Or0 = { xy: Pair<Int, Int> -> if (xy.first < xy.second) 1 else 0 }

fun offsetPairs(n: Int, f: (x: Pair<Int, Int>) -> Int, xs: List<Int>): List<Int> =
  xs.zip(xs.drop(n)).map { f(it) }

fun part1(ints: List<Int>): Int = offsetPairs(1, sub1Or0, ints).sum()

fun part2(ints: List<Int>): Int = offsetPairs(3, sub1Or0, ints).sum()


fun main(args: Array<String>) {
    val ints = readFileAsLines("data/Day1.txt")
        .map { it.toInt() }
    println(part1(ints))
    println(part2(ints))
}