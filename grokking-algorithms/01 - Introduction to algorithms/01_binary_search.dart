void main() {
  List<int> list = [1, 3, 5, 7, 9];
  print(binarySearch(list, 3));
  print(binarySearch(list, -1));
}

int? binarySearch(List<int> list, int item) {
  int low = 0;
  int high = list.length - 1;

  while (low <= high) {
    int mid = (low + high) ~/ 2;
    int guess = list[mid];
    if (guess == item) {
      return mid;
    } else if (guess > item) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return null;
}
