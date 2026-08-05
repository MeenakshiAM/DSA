# Remove Methods From Project
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are maintaining a project that has n methods numbered from 0 to n - 1.

You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.

There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.

A group of methods can only be removed if no method outside the group invokes any methods within it.

Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.

 

Example 1:

Input: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]

Output: [0,1,2,3]

Explanation:



Method 2 and method 1 are suspicious, but they are directly invoked by methods 3 and 0, which are not suspicious. We return all elements without removing anything.

Example 2:

Input: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]

Output: [3,4]

Explanation:



Methods 0, 1, and 2 are suspicious and they are not directly invoked by any other method. We can remove them.

Example 3:

Input: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]

Output: []

Explanation:



 

Constraints:

1 <= n <= 105
0 <= k <= n - 1
0 <= invocations.length <= 2 * 105
invocations[i] == [ai, bi]
0 <= ai, bi <= n - 1
ai != bi
invocations[i] != invocations[j]





This sentence confuses a lot of people the first time. Let's break it down with a picture.

Suppose the arrows mean

```text id="v3sy5i"
A -> B
```

which means

> **A calls (invokes) B.**

---

## Example 1

```text id="pgyn7v"
1 -> 2
2 -> 3
3 -> 4
```

Suppose

```text id="f3v3m9"
k = 2
```

The bug is in method 2.

Then suspicious methods are

```text id="fdq02w"
2
3
4
```

because 2 calls 3, and 3 calls 4.

Now ask:

> Is there any method **outside** this group calling one of them?

The only outside method is

```text id="hxbacm"
1
```

But

```text id="vlyot4"
1 -> 2
```

Yes!

Method **1** (outside the group) calls **2** (inside the group).

So the condition

> "no method outside the group invokes any method inside"

is **violated**.

Therefore **you cannot remove** the group.

---

## Why?

Imagine deleting methods

```text id="l8n8u8"
2
3
4
```

Then method

```text id="lbmw91"
1
```

still contains

```text id="r98x7o"
call 2();
```

But method 2 no longer exists.

Now method 1 is broken.

That's why removal isn't allowed.

---

## Example 2

```text id="ax3hyl"
1

2 -> 3
3 -> 4
```

Suppose

```text id="eowjlwm"
k = 2
```

Suspicious group

```text id="m4lcsj"
2
3
4
```

Does any outside method call them?

Method 1 doesn't call anyone.

So the answer is **No**.

Now you can safely delete

```text id="vf3eho"
2
3
4
```

because nothing else depends on them.

---

## Example 3

```text id="qvfnm0"
1 -> 3

2 -> 3

3 -> 4
```

Suppose

```text id="29pbck"
k = 3
```

Suspicious group

```text id="jck8gp"
3
4
```

Outside methods are

```text id="fjlwmn"
1
2
```

Do they call inside?

Yes.

```text id="sjlwmn"
1 -> 3

2 -> 3
```

Therefore you **cannot** remove

```text id="qyo9mc"
3
4
```

because methods 1 and 2 would be left with invalid calls.

---

## The sentence in plain English

> **"A group of methods can only be removed if no method outside the group invokes any methods within it."**

means:

> **Before deleting the suspicious methods, check whether any method that is NOT being deleted still calls one of them. If yes, you are not allowed to delete the group.**

---

### A simple analogy

Think of methods as rooms connected by doors.

If you're going to demolish a group of rooms, you must make sure **no room that remains standing has a door leading into the rooms being demolished**.

If an outside room still has a door to a demolished room, people would walk into a wall. That's exactly what the problem is preventing.

So, whenever you solve this problem, after finding all suspicious methods (using DFS/BFS from `k`), ask yourself one question:

> **"Is there any edge from a non-suspicious method to a suspicious method?"**

* **Yes** → You cannot remove the group.
* **No** → You can remove the entire suspicious group.
