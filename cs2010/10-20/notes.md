# 10-20: Git and GitHub

## Problem: Source Control

Problem: Managing more than one version of the same program.

- Ex: You want to add a complex feature to an existing program,
  but you don't want to break the existing program while you're
  working on the new feature.
- You make some changes to a program, but it gets horribly broken
  and you want the old version back.
- Two people are working on the same program on their own computers,
  and they want to merge them back together into one version.
- One person has copies of a program on two different computers...

Plan A: Make a bunch of copies.

- cut-tree.lua
- cut-tree-with-branches.lua
- cut-tree-fixed.lua
- cut-tree-with-branches-and-fixes.lua
- cut-tree-fixed-v2.lua
- cut-tree-fixed-v2-final.lua
- cut-tree-fixed-v2-final-revised.lua
- cut-tree-with-branches-and-fixes-v2.lua

Problem:

- What if there are multiple people working together
  on a project with multiple files?

## Source Control Apps

A source control program works like this:

- We give it a directory.
- It manages revisions to stuff in the directory.
- It lets us access old versions, temporary branches, merge
  different versions, etc.
- It can connect to a remote server to help coordinate changes
  between multiple users.

Two plans for designing a tool like this:

- The old plan: Server first, the server has the main version of the
  program.
- Newer plan: Every copy is a complete "repository". If the server
  vanishes, local copies have everyting.
