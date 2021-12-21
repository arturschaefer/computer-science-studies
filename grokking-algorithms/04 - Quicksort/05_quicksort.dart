void main() {
  print(quickSort([10, 5, 2, 3])); // [2, 3, 5, 10]
}

List<int> quickSort(List<int> list) {
  if (list.length < 2) {
    return list;
  } else {
    final int pivot = list.length ~/ 2;

    Iterable<int> less = list.where((value) => value < pivot);
    Iterable<int> equal = list.where((value) => value == pivot);
    Iterable<int> greater = list.where((value) => value > pivot);

    List<int> result = [];
    if (less.isNotEmpty) {
      result += less.toList();
    }
    if (equal.isNotEmpty) {
      result += equal.toList();
    }
    if (greater.isNotEmpty) {
      result += greater.toList();
    }
    return result;
  }
}
