void main() {
  print(max([1, 5, 10, 25, 16, 1])); // 25
}

int max(List<int> list) {
  if (list.length == 2) {
    return (list.first > list[1]) ? list.first : list[1];
  } else {
    int last = list.removeLast();
    int subMax = max(list);

    int maxValue = subMax > last ? subMax : last;
    return list.first > maxValue ? list.first : maxValue;
  }
}
