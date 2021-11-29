void main() {
  print(count([0, 1, 2, 3, 4]));
}

int count(List<int> list) {
  if (list.isEmpty)
    return 0;
  else {
    list.removeLast();
    return 1 + count(list);
  }
}
