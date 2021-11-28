void main() {
  countdown(5);
}

void countdown(int value) {
  print(value);
  if (value <= 0)
    return;
  else
    countdown(value - 1);
}
