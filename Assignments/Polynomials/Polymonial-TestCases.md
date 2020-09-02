# Programming Assignment Polynomials - Test Cases

## Test cases for method evaluate:

### Case 1 (3 pts)

```
poly1
-----

4 6
5 3
-11 1
5 0
```

evaluated at `x=0`

### Case 2 (4 pts)

## poly1

```
1 6
2 5
3 4
4 3
5 2
6 1
7 0
```

evaluated at `x=8`

### Case 3 (3 pts)

```
poly1
-----

1 3
-7 2
9 0
```

evaluated at `x=-1`

## Test cases for method add

### Case 1 (6 pts)

```
poly1          poly2
-----          -----

1 6            -1 6
2 5            -2 5
3 4            -3 4
4 3            -4 3
5 2            -5 2
6 1            -6 1
7 0            -7 0
```

### Case 2 (7 pts)

```
poly1          poly2
-----          -----

4 6            24 8
5 3            15 5
-11 1         110 4
5 0             5 1
```

### Case 3 (7 pts)

```
poly1          poly2
-----          -----

1 6            3 48976
2 5            2 1090
3 4            -1 6
               -2 5
               -3 4
```

### Case 4 (2 pts)

```
poly1          poly2
-----          -----

zero poly/     zero poly/
empty file     empty file
```

### Case 5 (3 pts)

```
poly1          poly2
-----          -----

1 6            zero poly/
2 5            empty file
3 4
4 3
5 2
6 1
7 0
```

## Test cases for method multiply

### Case 1 (7 pts)

```
poly1          poly2
-----          -----

1 6            -1 6
2 5            -2 5
3 4            -3 4
4 3            -4 3
5 2            -5 2
6 1            -6 1
7 0            -7 0
```

### Case 2 (7 pts)

```
poly1          poly2
-----          -----

4 6            24 8
5 3            15 5
-11 1         110 4
5 0             5 1
```

### Case 3 (7 pts)

```
poly1          poly2
-----          -----

1 6            3 48976
2 5            2 1090
3 4           -1 6
              -2 5
              -3 4
```

### Case 4 (2 pts)

```
poly1          poly2
-----          -----

zero poly/     zero poly/
empty file     empty file
```

### Case 5 (2 pts)

```
poly1          poly2
-----          -----

1 6            zero poly/
2 5            empty file
3 4
4 3
5 2
6 1
7 0
```
