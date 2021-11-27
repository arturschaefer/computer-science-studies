void main() {
  print(selectionSort([5, 3, 6, 2, 10]));
}

List<int> selectionSort(List<int> list) {
  List<int> orderedList = [];
  final initialLength = list.length;
  for (int i = 0; i < initialLength; i++) {
    final smallest = findSmallest(list);
    orderedList.add(list.removeAt(smallest));
  }
  return orderedList;
}

int findSmallest(List<int> list) {
  int smallest = list.first;
  int smallestIndex = 0;
  for (int i = 0; i < list.length; i++) {
    if (list[i] < smallest) {
      smallest = list[i];
      smallestIndex = i;
    }
  }
  return smallestIndex;
}
