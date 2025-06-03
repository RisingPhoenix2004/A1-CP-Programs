/*
 * Imagine you are a librarian organizing books on vertical shelves in a grand library. 
The books are currently scattered across a tree-like structure, 
where each book (node) has a position determined by its shelf number (column) 
and row number (level).

Your task is to arrange the books on shelves so that:
1. Books are placed column by column from left to right.
2. Within the same column, books are arranged from top to bottom (i.e., by row).
3. If multiple books belong to the same shelf and row, they should be arranged from left to right, just as they appear in the original scattered arrangement.

Sample Input-1:
---------------
3 9 20 -1 -1 15 7

Sample Output-1:
----------------
[[9],[3,15],[20],[7]]

Explanation:
         3
       /   \
      9     20
          /    \
         15     7

Shelf 1: [9]
Shelf 2: [3, 15]
Shelf 3: [20]
Shelf 4: [7]

Sample Input-2:
---------------
3 9 8 4 0 1 7

Sample Output-2:
----------------
[[4],[9],[3,0,1],[8],[7]]

Explanation:
          3
       /     \
      9       8
    /   \   /   \
   4     0 1     7

Shelf 1: [4]
Shelf 2: [9]
Shelf 3: [3, 0, 1]
Shelf 4: [8]
Shelf 5: [7]

Library Organization Rules:
1. Each column represents a shelf from left to right.
2. Books on the same shelf are arranged from top to bottom.
3. If books share the same position, they are arranged left to right in order of appearance.
 */
