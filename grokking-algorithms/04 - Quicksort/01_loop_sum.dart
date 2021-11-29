void main() {
  print(sum([1, 2, 3, 4]));
}

int sum(List<int> list) {
  int total = 0;
  for (int value in list) {
    total += value;
  }

  return total;
}
