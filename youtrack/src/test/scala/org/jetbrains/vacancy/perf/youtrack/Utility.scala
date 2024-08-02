package org.jetbrains.vacancy.perf.youtrack

import scala.annotation.tailrec
import scala.util.Random

object Utility {

  private val preps = Array("", "K", "M", "G", "T")

  private def humanise(sizeBytes: Long): String = {
    @tailrec
    def go(n: Long, divider: Long, offset: Int): String = {
      if (n < 1024L)
        s"${(sizeBytes.toDouble / divider).round} ${preps(offset)}B"
      else
        go(n / 1024, divider * 1024, offset + 1)
    }

    go(sizeBytes, 1L, 0)

  }

  def debugMemoryAndOpts(): Unit = {
    sys.env
      .get("GATLING_JAVA_OPTS")
      .fold(println("GATLING_JAVA_OPTS not set"))(javaOpts => println(s"GATLING_JAVA_OPTS = $javaOpts"))

    val heapSize     = Runtime.getRuntime.totalMemory()
    val heapMaxSize  = Runtime.getRuntime.maxMemory()
    val heapFreeSize = Runtime.getRuntime.freeMemory()
    val percentFree  = ((heapFreeSize.toDouble / heapSize) * 100).round

    println(
      s"Heap: ${humanise(heapSize)} | HeapMax: ${humanise(heapMaxSize)} | Free: ${humanise(heapFreeSize)}/${humanise(heapSize)} [$percentFree %]",
    )
  }

  // Copy-paste from: https://gist.github.com/steppenwells/399819/6457b27d0c05810d4b95faa11e618ec6af2b203d
  object LoremIpsum {
    // lorum block pulled from wikipedia: http://en.wikipedia.org/wiki/Lorem_ipsum
    val loremBlock = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
    val loremWords: Array[String] = loremBlock.split(" ")

    def getWords(words: Int): String = {
      val wordCount = words % loremWords.length
      loremWords.slice(0, wordCount).mkString(" ")
    }

    def getRandomNumberOfWords(range: Range): String = {
      getWords(Random.nextInt(range.length) + range.start)
    }
  }

}
