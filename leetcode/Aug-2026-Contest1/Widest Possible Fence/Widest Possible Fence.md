# 4007. Widest Possible Fence


You are given an integer array planks, where planks[i] represents the height of the ith wooden plank. Each plank has a width of 1 unit.

You want to build a fence consisting of planks that all have the same height.

You may either use a plank as is, or combine exactly two distinct original planks into a single plank whose height equals the sum of their heights. Each original plank can be used at most once, and not all original planks need to be used.

Return the maximum possible width of the fence that can be built.

 

Example 1:

Input: planks = [1,3,2,5,7,5,4,2,1]

Output: 4

Explanation:

We can have four planks of height 5.

planks[3] = 5
planks[5] = 5
planks[0] + planks[6] = 1 + 4 = 5
planks[1] + planks[2] = 3 + 2 = 5
Hence, the maximum width is 4.

Example 2:

Input: planks = [2,3,7]

Output: 1

Explanation:

It is impossible to form two planks of the same height, even after combining two distinct original planks.
Since not all original planks need to be used, we can choose any one plank as the fence.
Therefore, the maximum possible width is 1.
 

Constraints:

1 <= planks.length <= 1000
1 <= planks[i] <= 109




# Explanation

Absolutely. This solution is actually **much smarter** than it first appears. The beauty is that it **doesn't try every target explicitly**. Instead, it **builds the answer for every target at the same time**.

Let's go through it slowly.

---

# Step 1: Count frequencies

```java
Map<Integer, Integer> count = new HashMap<>();
```

Suppose

```text
A = [1,3,2,5,7,5,4,2,1]
```

Then

```text
count

1 -> 2
2 -> 2
3 -> 1
4 -> 1
5 -> 2
7 -> 1
```

This tells us how many planks of each height exist.

---

# Step 2

```java
Map<Integer,Integer> res = new HashMap<>();
```

This is the clever part.

`res[target]` means

> **"How many fence planks of height `target` can I make?"**

Initially they do

```java
res.put(x, res.getOrDefault(x,0)+1);
```

So every existing plank contributes one.

After initialization

```text
res

1 -> 2
2 -> 2
3 -> 1
4 -> 1
5 -> 2
7 -> 1
```

because

```text
height 5

5
5
```

already gives two fence planks of height 5.

---

# Step 3

Now comes the magic.

```java
for(int a : count.keySet())
```

Choose one height.

Then

```java
for(int b : count.keySet())
```

Choose another height.

Imagine

```text
a = 1
b = 4
```

Then

```text
1 + 4 = 5
```

How many such pairs can we make?

Frequency

```text
1 -> 2

4 -> 1
```

Only

```text
min(2,1)=1
```

because the single 4 runs out.

So

```java
res.put(5, res.get(5)+1);
```

Now

```text
res[5]

was 2

becomes 3
```

---

## Next

Suppose

```text
a = 2
b = 3
```

Frequencies

```text
2 -> 2

3 -> 1
```

Again

```text
min(2,1)=1
```

Another fence plank of height 5.

Now

```text
res[5]

3

↓

4
```

Exactly the answer.

---

# Why use min?

Suppose

```text
1 -> 100

4 -> 2
```

Can you build

```text
100
```

pairs?

No.

You only have

```text
2
```

fours.

So only

```text
min(100,2)=2
```

pairs.

---

# Why

```java
if(a==b)
```

?

Suppose

```text
2 -> 5
```

Target

```text
4
```

Need

```text
2+2
```

Five twos become

```text
(2,2)

(2,2)

2 left
```

Only

```text
5/2 = 2
```

pairs.

Hence

```java
count.get(a)/2
```

---

# Why

```java
if(a<b)
```

?

Imagine

```text
1+4
```

Later you'll also see

```text
4+1
```

They're the same pair.

So only count one ordering.

---

# The brilliant idea

Instead of saying

```text
Target = 5

count everything
```

then

```text
Target = 6

count everything
```

...

this algorithm says

> "Whenever I discover a pair whose sum is X, I'll immediately add it to `res[X]`."

So it's computing

```text
res[2]

res[3]

res[4]

res[5]

res[6]

...
```

**all simultaneously**.

That's why it's much faster.

---

# Visualize it

Suppose

```text
count

1 -> 2

2 -> 2

3 -> 1

4 -> 1

5 -> 2
```

The loops generate

```text
1+1 -> 2

1+2 -> 3

1+3 -> 4

1+4 -> 5   (+1)

1+5 -> 6

2+2 -> 4

2+3 -> 5   (+1)

2+4 -> 6

2+5 -> 7

3+3 -> 6

...
```

Each time

```
sum
```

gets another possible fence plank.

Eventually

```text
res

2 -> ...

3 -> ...

4 -> ...

5 -> 4   ← maximum

6 -> ...

7 -> ...
```

---

## The part that confused you (and me at first!)

At first glance it looks like:

> "Wait... how is this not reusing planks?"

The trick is that **it isn't trying to construct one actual fence**.

For a fixed pair of heights `a` and `b`, the maximum number of disjoint pairs is **independent** of every other pair:

* `1 + 4` can contribute at most `min(freq[1], freq[4])`.
* `2 + 3` can contribute at most `min(freq[2], freq[3])`.

These use **different height values**, so they don't interfere with each other. If two different pair types would require the same height (like `1+4` and `2+3` both making 5), they still don't compete because the algorithm is adding the maximum contribution from **each distinct height combination**. For a given target, each height value participates in exactly one complementary pair (`x` pairs only with `target - x`), so there's no double usage within that target.

---

### This is actually a nice DSA pattern to remember

The algorithm is based on changing the perspective:

* ❌ "For each target, find all pairs."
* ✅ "For each pair, contribute to its target."

That small reversal turns a much more expensive algorithm into a concise and efficient one. Once you start recognizing these "reverse the loops" ideas, you'll see them in quite a few optimization problems.
