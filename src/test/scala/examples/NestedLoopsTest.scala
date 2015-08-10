package examples

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NestedLoopsTest extends FunSuite {

  test ("insertion sort: input data is not sorted properly") {
    assert(NestedLoops.insertionSort(Nil).isEmpty, "empty list")
    assert(NestedLoops.insertionSort(List(5)) == List(5), "list with only one element")
    assert(NestedLoops.insertionSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list")
    assert(NestedLoops.insertionSort(List( 1, 2, 3, 4, 5, 6, 7, 8)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "already sorted list")
    assert(NestedLoops.insertionSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "reverse sorted list")
    assert(NestedLoops.insertionSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("quick sort: input data is not sorted properly") {
    assert(NestedLoops.quickSort(Nil).isEmpty, "empty list")
    assert(NestedLoops.quickSort(List(5)) == List(5), "list with only one element")
    assert(NestedLoops.quickSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list")
    assert(NestedLoops.quickSort(List( 1, 2, 3, 4, 5, 6, 7, 8)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "already sorted list")
    assert(NestedLoops.quickSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "reverse sorted list")
    assert(NestedLoops.quickSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }

  test ("bubble sort: input data is not sorted properly") {
    assert(NestedLoops.bubbleSort(Nil).isEmpty, "empty list")
    assert(NestedLoops.bubbleSort(List(5)) == List(5), "list with only one element")
    assert(NestedLoops.bubbleSort(List( 5, 1, 4, 2, 8)) == List( 1, 2, 4, 5, 8), "random list - 1")
    assert(NestedLoops.bubbleSort(List( 3, 7, 4, 9, 5, 2, 6, 1)) == List(1, 2, 3, 4, 5, 6, 7, 9), "random list - 2")
    assert(NestedLoops.bubbleSort(List( 1, 2, 3, 4, 5, 6, 7, 8, 9)) == List( 1, 2, 3, 4, 5, 6, 7, 8, 9), "already sorted list")
    assert(NestedLoops.bubbleSort(List( 8, 7, 6, 5, 4, 3, 2, 1)) == List( 1, 2, 3, 4, 5, 6, 7, 8), "reverse sorted list")
    assert(NestedLoops.bubbleSort(List( 1, 1, 1, 1, 1, 1)) ==List( 1, 1, 1, 1, 1, 1), "list filled with one element")
  }
}
