

 1. In `student (Sno integer NOT NULL, Sname varchar(10), Marks integer)` and `student3 (Sno integer PRIMARY KEY, Sname varchar(10))`, what happens if you insert `(NULL, 'Arun', 50)` into both tables?
A) Fails in `student` due to `NOT NULL`, succeeds in `student3`.  
B) Fails in both due to `NOT NULL`.  
C) Fails in `student` due to `NOT NULL`, fails in `student3` due to `PRIMARY KEY`.  
D) Succeeds in both with `Sno` as `NULL`.  
Correct Answer: C  
Explanation: In `student`, `Sno NOT NULL` rejects `NULL`. In `student3`, `Sno PRIMARY KEY` implies `NOT NULL` and uniqueness, so `NULL` fails there too.


 2. In `student2 (Sno integer UNIQUE, collegeId integer UNIQUE)`, after inserting `(NULL, 1)` and `(101, NULL)`, can you insert `(NULL, NULL)`?
A) Yes, because `UNIQUE` allows multiple `NULL`s.  
B) No, because `Sno` already has a `NULL`.  
C) No, because `collegeId` already has a `NULL`.  
D) Yes, but only if `Sno` is `NOT NULL`.  
Correct Answer: A  
Explanation: `UNIQUE` permits multiple `NULL`s per column (e.g., SQL standard behavior), so `(NULL, NULL)` is valid as it doesn’t duplicate `1` or `101`.



 3. In `student3 (Sno integer PRIMARY KEY)`, after inserting `(101, 'Arun')`, what happens if you update `Sno=101` to `NULL`?
A) Update succeeds.  
B) Update fails due to `PRIMARY KEY`’s `NOT NULL` requirement.  
C) Update fails due to `UNIQUE` violation.  
D) Update succeeds but deletes the row.  
Correct Answer: B  
Explanation: `PRIMARY KEY` implicitly enforces `NOT NULL`, so updating `Sno` to `NULL` violates the constraint.



 4. In `student4 (firstname varchar(10), lastname varchar(10), PRIMARY KEY(firstname, lastname))`, after inserting `('Ravi', 'Reddy')`, can you insert `('Ravi', NULL)`?
A) Yes, because `lastname` isn’t explicitly `NOT NULL`.  
B) No, because composite `PRIMARY KEY` requires non-null values.  
C) Yes, but only if `firstname` is unique.  
D) No, because `firstname` must be unique alone.  
Correct Answer: B  
Explanation: A composite `PRIMARY KEY` (e.g., `(firstname, lastname)`) mandates that all columns be non-null, so `NULL` in `lastname` fails.



 5. In `library (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school(sno) ON DELETE CASCADE)`, with `school (sno=101)` and `library (sno=101)`, what happens if you delete `sno=101` from `school`?
A) Deletion fails due to `FOREIGN KEY`.  
B) Both `school` and `library` rows are deleted.  
C) Only `school` row is deleted, `library` remains.  
D) Deletion fails due to `PRIMARY KEY`.  
Correct Answer: B  
Explanation: `ON DELETE CASCADE` deletes the parent row (`school.sno=101`) and the matching child row (`library.sno=101`).



 6. In `school (sno integer PRIMARY KEY)` and `library (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school(sno) ON UPDATE CASCADE)`, after inserting `(102)` in `school` and `(102)` in `library`, what happens if you update `school.sno=102` to `103`?
A) Update fails due to `FOREIGN KEY`.  
B) `school.sno` becomes `103`, `library.sno` remains `102`.  
C) Both `school.sno` and `library.sno` become `103`.  
D) Update fails due to `PRIMARY KEY` conflict.  
Correct Answer: C  
Explanation: `ON UPDATE CASCADE` updates the child (`library.sno`) to match the parent (`school.sno`).



 7. In `student2 (Sno integer UNIQUE, collegeId integer UNIQUE)`, after inserting `(101, 1)` and `(102, 2)`, what happens if you update `Sno=102` to `101`?
A) Update succeeds.  
B) Update fails due to `UNIQUE` on `Sno`.  
C) Update fails due to `UNIQUE` on `collegeId`.  
D) Update succeeds but swaps rows.  
Correct Answer: B  
Explanation: `Sno` is `UNIQUE`, so changing `102` to `101` (already present) violates the constraint.



 8. In `CUSTOMERS (ID INT NOT NULL, NAME VARCHAR(20) NOT NULL, PRIMARY KEY (ID))`, after inserting `(1, 'Ravi')`, what happens if you insert `(1, 'Subbu')`?
A) Insert succeeds, overwriting `(1, 'Ravi')`.  
B) Insert fails due to `PRIMARY KEY` uniqueness.  
C) Insert fails due to `NOT NULL` on `NAME`.  
D) Insert fails due to `UNIQUE` on `NAME`.  
Correct Answer: B  
Explanation: `PRIMARY KEY` on `ID` ensures uniqueness, so duplicate `1` fails.



 9. In `student4`, after inserting `('Ravi', 'Reddy', 40)` and `('Subba', 'Rao', 40)`, what happens if you update `firstname='Subba'` to `'Ravi'`?
A) Update succeeds.  
B) Update fails due to composite `PRIMARY KEY` violation.  
C) Update fails due to `NOT NULL`.  
D) Update succeeds but merges rows.  
Correct Answer: A  
Explanation: Updating `('Subba', 'Rao')` to `('Ravi', 'Rao')` is fine.



 10. In `library (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school(sno))` with `school (sno=101)`, after inserting `(101, 'C')` into `library`, can you update `library.sno=101` to `102` if `school` has no `sno=102`?
A) Update succeeds.  
B) Update fails due to `FOREIGN KEY`.  
C) Update fails due to `PRIMARY KEY`.  
D) Update succeeds but breaks the reference.  
Correct Answer: B  
Explanation: `FOREIGN KEY` requires `sno` to exist in `school`, so `102` fails without a matching parent.



 11. In `student2`, after inserting `(NULL, 1, 'Arun')`, `(101, 2, 'Subba')`, and `(NULL, 3, 'Ravi')`, what happens if you insert `(NULL, 1, 'Kavita')`?
A) Insert succeeds.  
B) Insert fails due to `UNIQUE` on `collegeId`.  
C) Insert fails due to `UNIQUE` on `Sno`.  
D) Insert fails due to `PRIMARY KEY`.  
Correct Answer: B  
Explanation: `collegeId` is `UNIQUE`, and `1` already exists, so the insert fails.



 12. In `school (sno integer PRIMARY KEY)` and `library (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school(sno) ON DELETE CASCADE)`, with `school (101, 102)` and `library (101, 102)`, what happens if you delete from `school` where `sno > 100`?
A) Deletes `school (101, 102)` and `library (101, 102)`.  
B) Deletes `school (101, 102)` only.  
C) Deletes `school (101, 102)` and `library (102)`.  
D) Deletion fails due to `FOREIGN KEY`.  
Correct Answer: A  
Explanation: `sno > 100` matches `101` and `102`, and `ON DELETE CASCADE` deletes both `school` and `library` rows.



 13. In `student3`, after inserting `(101, 'Arun')` and `(102, 'Subba')`, what happens if you update `Sno=101` to `102`?
A) Update succeeds, merging rows.  
B) Update fails due to `PRIMARY KEY` uniqueness.  
C) Update succeeds, deleting `(102, 'Subba')`.  
D) Update fails due to `NOT NULL`.  
Correct Answer: B  
Explanation: `PRIMARY KEY` on `Sno` prevents duplicate `102`.



 14. In `student4`, after inserting `('Ravi', 'Reddy', 40)` and `('Kavita', 'Reddy', 40)`, can you update `lastname='Reddy'` to `NULL` for all rows?
A) Yes, because `lastname` isn’t `NOT NULL`.  
B) No, because composite `PRIMARY KEY` requires non-null values.  
C) Yes, but only for one row.  
D) No, because `firstname` must be unique.  
Correct Answer: B  
Explanation: Composite `PRIMARY KEY (firstname, lastname)` disallows `NULL` in either column.



 15. In `library1 (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school1(sno))`, with `school1 (101, 102)` and `library1 (101)`, can you delete `school1.sno=102`?
A) Yes, because `library1` doesn’t reference `102`.  
B) No, because `FOREIGN KEY` prevents it.  
C) Yes, but `library1.sno=101` is also deleted.  
D) No, because `sno=102` is a `PRIMARY KEY`.  
Correct Answer: A  
Explanation: `FOREIGN KEY` only restricts deletion if referenced; `102` isn’t in `library1`, so it succeeds.



 16. In `student2`, after inserting `(101, 1, 'Arun')`, what happens if you update `collegeId=1` to `NULL` and then insert `(102, 1, 'Subba')`?
A) Both succeed.  
B) Insert fails due to `UNIQUE` on `collegeId`.  
C) Update fails due to `UNIQUE` on `Sno`.  
D) Insert succeeds, but update fails.  
Correct Answer: A  
Explanation: Updating `collegeId` to `NULL` is allowed (no `NOT NULL`), and inserting `(102, 1)` works as `1` isn’t present.



 17. In `CUSTOMERS2 (ID INT NOT NULL, NAME VARCHAR(20) NOT NULL, Country VARCHAR(30) DEFAULT 'india')`, after inserting `(1, 'Ravi')`, can you update `NAME='Ravi'` to `NULL`?
A) Yes, because `NAME` has a default.  
B) No, because `NAME` is `NOT NULL`.  
C) Yes, but `Country` becomes `NULL`.  
D) No, because `ID` is `PRIMARY KEY`.  
Correct Answer: B  
Explanation: `NAME NOT NULL` prevents updating to `NULL`.



 18. In `library (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school(sno) ON DELETE CASCADE)`, with `school (101)` and `library (101)`, can you update `school.sno=101` to `101`?
A) Update fails due to `FOREIGN KEY`.  
B) Update succeeds with no effect.  
C) Update fails due to `PRIMARY KEY`.  
D) `library.sno=101` is deleted.  
Correct Answer: B  
Explanation: Updating a value to itself is a no-op and succeeds without triggering cascades.



 19. In `student4`, after inserting `('Ravi', 'Reddy', 40)`, what happens if you insert `('Ravi', 'Reddy', NULL)`?
A) Insert succeeds because `Marks` isn’t constrained.  
B) Insert fails due to composite `PRIMARY KEY`.  
C) Insert succeeds but overwrites the first row.  
D) Insert fails due to `NOT NULL`.  
Correct Answer: B  
Explanation: Composite `PRIMARY KEY (firstname, lastname)` rejects duplicate `('Ravi', 'Reddy')`.



 20. In `school (sno integer PRIMARY KEY)` and `library (sno integer PRIMARY KEY, FOREIGN KEY (sno) REFERENCES school(sno))`, with `school (101, 102)` and `library (101)`, what happens if you update `school.sno=101` to `102`?
A) Update succeeds, `library.sno=101` remains.  
B) Update fails due to `PRIMARY KEY` in `school`.  
C) Update fails due to `FOREIGN KEY` in `library`.  
D) Update succeeds, `library.sno=101` becomes `102`.  
Correct Answer: B  
Explanation: `school.sno=102` already exists, violating `PRIMARY KEY` uniqueness; no cascade occurs.



 