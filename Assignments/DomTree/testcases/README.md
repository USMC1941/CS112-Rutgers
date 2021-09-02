# Programming Assignment DOM Tree - Test Cases

1. `build`: 20 pts

   | Points |         Test Case          |                Description                 |
   | :----: | :------------------------: | :----------------------------------------: |
   |   2    | [testb2.html](testb2.html) |    Document with a single line of text     |
   |   2    | [testb3.html](testb3.html) | Mix of plain text, `b`, `em`, and `p` tags |
   |   3    | [testb4.html](testb4.html) |                  `ol` tag                  |
   |   3    | [testb5.html](testb5.html) |                  `ul` tag                  |
   |   3    | [testb6.html](testb6.html) |      Simple `table`, `tr`, `td` tags       |
   |   3    | [testb7.html](testb7.html) |            Nested `ul` and `ol`            |
   |   4    | [testb8.html](testb8.html) |        `ul` and `ol` nested in `td`        |

2. `replaceTag`: 15 pts

   | Points |           Input            |    Replace    |             Output             |
   | :----: | :------------------------: | :-----------: | :----------------------------: |
   |   3    | [testb3.html](testb3.html) | `b` --> `em`  | [testb3tr.html](testb3tr.html) |
   |   3    |    [ex1.html](ex1.html)    | `em` --> `b`  |   [ex1tr1.html](ex1tr1.html)   |
   |   3    | [testb4.html](testb4.html) | `ol` --> `ul` | [testb4tr.html](testb4tr.html) |
   |   3    | [testb8.html](testb8.html) | `ul` --> `ol` | [testb8tr.html](testb8tr.html) |
   |   3    | [testr1.html](testr1.html) | `p` --> `em`  | [testr1tr.html](testr1tr.html) |

3. `removeTag`: 30 pts

   | Points |             Input              | Remove |                Output                |
   | :----: | :----------------------------: | :----: | :----------------------------------: |
   |   2    | [testrep1.html](testrep1.html) |  `b`   |  [testrep1tr.html](testrep1tr.html)  |
   |   3    | [testrep2.html](testrep2.html) |  `em`  |  [testrep2tr.html](testrep2tr.html)  |
   |   4    | [testrep3.html](testrep3.html) |  `p`   |  [testrep3tr.html](testrep3tr.html)  |
   |   5    |   [testb4.html](testb4.html)   |  `ol`  | [testb4reptr.html](testb4reptr.html) |
   |   6    |      [ex3.html](ex3.html)      |  `ol`  |      [ex3tr1.html](ex3tr1.html)      |
   |   5    |   [testb8.html](testb8.html)   |  `ul`  | [testb8reptr.html](testb8reptr.html) |
   |   5    | [testrep4.html](testrep4.html) |  `em`  |  [testrep4tr.html](testrep4tr.html)  |

4. `boldRow`: 15 pts

   | Points |      Input       | Row |              Output              |
   | :----: | :--------------: | :-: | :------------------------------: |
   |   4    | [testbf1.html]() |  2  | [testbf1tr.html](testbf1tr.html) |
   |   5    | [testbf2.html]() |  1  | [testbf2tr.html](testbf2tr.html) |
   |   6    | [testbf3.html]() |  3  | [testbf3tr.html](testbf3tr.html) |

5. `addTag`: 20 pts

   | Points |               Input                | Word  | Tag  |                 Output                 |
   | :----: | :--------------------------------: | :---: | :--: | :------------------------------------: |
   |   2    |  [testhello.html](testhello.html)  | hello | `b`  |  [testhellotr.html](testhellotr.html)  |
   |   1    | [testhello1.html](testhello1.html) | hello | `em` | [testhello1tr.html](testhello1tr.html) |
   |   2    |     [testhw.html](testhw.html)     | Hello | `em` |    [testhwtr1.html](testhwtr1.html)    |
   |   3    |     [testhw.html](testhw.html)     | world | `em` |    [testhwtr2.html](testhwtr2.html)    |
   |   3    |    [testmom.html](testmom.html)    | over  | `em` |    [testmomtr.html](testmomtr.html)    |
   |   3    |    [testqbf.html](testqbf.html)    |  the  | `em` |     [testqbfr.html](testqbfr.html)     |
   |   3    |    [testvvb.html](testvvb.html)    | very  | `b`  |    [testvvbtr.html](testvvbtr.html)    |
   |   3    |        [ex3.html](ex3.html)        | item  | `em` |       [ex3tr2.html](ex3tr2.html)       |
