void main() {
  print(quickSort([10, 5, 2, 3])); // [2, 3, 5, 10]
}

List<int> quickSort(List<int> list) {
  if (list.length < 2) {
    return list;
  } else {
    final int pivot = list.first;

    List<int> less = list.where((value) => value < pivot).toList();
    List<int> equal = list.where((value) => value == pivot).toList();
    List<int> greater = list.where((value) => value > pivot).toList();

    return quickSort(less) + equal + quickSort(greater);
  }
}
