void main() {
  print(sum([2, 4, 6]));
}

int sum(List<int> list) {
  int total = 0;
  if (list.isEmpty) {
    return total;
  } else {
    total += list.removeLast();
    return total + sum(list);
  }
}
